package cl.tavi.backofice.wsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.tavi.backofice.models.dao.IUsuarioDao;

@RestController
@RequestMapping(value="/wsrest")
public class HelloCtrl {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> helloPage(){
		
		
		String saludo="Hola mundo " + this.usuarioDao.findByEmail("admin").toString();
	
		return new ResponseEntity<String>(saludo,HttpStatus.OK);
	}
}
