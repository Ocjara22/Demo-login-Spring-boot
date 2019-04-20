package cl.tavi.backofice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.tavi.backofice.models.entity.Telefono;
import cl.tavi.backofice.models.entity.Usuario;
import cl.tavi.backofice.models.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BackofficeApiRestLoginApplication.class)
public class ServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Ignore
	@Test
	public void saveUser() {
		
		Usuario usuario = new Usuario();
		List<Telefono> phones = new ArrayList<Telefono>();
		
		Telefono t1 = new Telefono();
		t1.setCitycode("1");
		t1.setNumber("999999999");
		t1.setContrycode("23");
		
		Telefono t2 = new Telefono();
		t2.setCitycode("1");
		t2.setNumber("99998999");
		t2.setContrycode("23");
		
		phones.add(t1);
		phones.add(t2);
		
		usuario.setEmail("ocjara@prueba3.com");
		usuario.setPassword("12345");
		usuario.setUsername("prueba46");
		Usuario test= this.userService.saveUser(usuario, phones);
		System.out.println(test);
	}
	
	@Ignore
	@Test
	public void getUser() {
	
	}
	
}
