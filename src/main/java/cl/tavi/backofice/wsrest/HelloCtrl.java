package cl.tavi.backofice.wsrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="wsrest")
public class HelloCtrl {

	
	
	@RequestMapping(value="/hello")
	public @ResponseBody ResponseEntity<String> helloPage(){
		
		
		String saludo="Hola mundo";
	
		return new ResponseEntity<String>(saludo,HttpStatus.OK);
	}
}
