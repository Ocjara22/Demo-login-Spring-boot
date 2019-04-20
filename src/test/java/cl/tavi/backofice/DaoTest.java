package cl.tavi.backofice;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.tavi.backofice.models.dao.IUsuarioDao;
import cl.tavi.backofice.models.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BackofficeApiRestLoginApplication.class)
public class DaoTest {
	
	@Autowired
	private IUsuarioDao usuarioService;
	
	@Ignore
	@Test
	public void test01() {
		Usuario u = this.usuarioService.findByEmail("ocjara@prueba2.com");
		System.out.println(u.toString());
	}
	
	@Ignore
	@Test
	public void testSaveUser() {
		Usuario usuario = new Usuario();
		usuario.setEmail("tavi@lala.com");
		usuario.setPassword("12345");
		usuario.setUsername("prueba2");
		Usuario test= this.usuarioService.save(usuario);
		System.out.println(test);
		
	}
}
