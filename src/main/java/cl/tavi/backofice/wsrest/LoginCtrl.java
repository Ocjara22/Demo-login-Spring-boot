package cl.tavi.backofice.wsrest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tavi.backofice.models.entity.Telefono;
import cl.tavi.backofice.models.entity.Usuario;
import cl.tavi.backofice.models.service.UserService;
import cl.tavi.backofice.models.service.UsuarioService;

@CrossOrigin(origins = {"localhost:4200"})
@RestController()
@RequestMapping(value = "api")
public class LoginCtrl {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@PostMapping(value="/registro")
	public @ResponseBody ResponseEntity<Usuario> registroUsuario(
			@RequestParam(value="email", required = true) String email,
			@RequestParam(value="username", required = true) String userName,
			@RequestParam(value="password", required = true) String password
			){
		
		Usuario usuario = new Usuario();
		Usuario Response= new Usuario();
		List<Telefono> phones = new ArrayList<Telefono>();
		
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setUsername(userName);
		try {
			Response = this.userService.saveUser(usuario, phones);
		}catch(Exception e) {
			logger.error("Ha ocurrido un problema al registrar el usuario: "+e.getMessage());
		}
		return new ResponseEntity<Usuario>(Response,HttpStatus.OK);
	}
	
	
	@PostMapping(value="/login")
	public @ResponseBody ResponseEntity<String> loginUsuario(){		
		String value = "Login ok :)";
		// Implementacion por spring security
		return new ResponseEntity<String>(value,HttpStatus.OK);
		
	}
	
}
