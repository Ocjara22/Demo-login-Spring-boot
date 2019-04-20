package cl.tavi.backofice.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.tavi.backofice.models.dao.IUsuarioDao;
import cl.tavi.backofice.models.entity.Usuario;



@Service
public class UsuarioService implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao userDao; 
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = userDao.findByEmail(username);
		
		if(usuario == null) {
			logger.error("Ha ocurrido un problema al obtener el usuario en capa de SVS: ");
			throw new UsernameNotFoundException("Me fui a la shit!!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}
	
	

}
