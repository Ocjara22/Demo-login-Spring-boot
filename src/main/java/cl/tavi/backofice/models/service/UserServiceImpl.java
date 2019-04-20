package cl.tavi.backofice.models.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.tavi.backofice.models.dao.ITelefonoDao;
import cl.tavi.backofice.models.dao.IUsuarioDao;
import cl.tavi.backofice.models.entity.Telefono;
import cl.tavi.backofice.models.entity.Usuario;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private IUsuarioDao userDao;
	
	@Autowired
	private ITelefonoDao phoneDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Override
	public Usuario saveUser(Usuario usuario, List<Telefono> phones) {
		logger.info("Registro de usuario en capa de SVS:");
		usuario.setPassword(this.passwordEncoder.encode(usuario.getPassword()));
			
		Usuario usuarioRetorno = userDao.save(usuario);;
		
		if(phones.size() < 1) {
			logger.info("El listado de telefonos es vacio para el usuario registrado en capa de SVS:");
		}else {
			for(Telefono tel: phones) {
				tel.setIdUsuario(usuarioRetorno.getId());
				Telefono telefonoAux = this.phoneDao.save(tel);
				logger.info("Se ha registrado un telefonno en la capa de SVS: "+telefonoAux);			
			}
		}		
		return usuarioRetorno;
	}
}
