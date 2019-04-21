package cl.tavi.backofice.models.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.tavi.backofice.exception.EmailRegistradoException;
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
	public Usuario saveUser(Usuario usuario, List<Telefono> phones)throws EmailRegistradoException{
		logger.info("Registro de usuario en capa de SVS:");
		
		
		Usuario UsuarioValidacion = this.userDao.findByEmail(usuario.getEmail());
		
		if(UsuarioValidacion != null) {
			logger.error("Correo ya registrado en la base de datos");
			throw new EmailRegistradoException("El correo ya registrado");
		}
		
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
