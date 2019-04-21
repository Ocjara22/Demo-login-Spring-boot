package cl.tavi.backofice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan({"cl.tavi.backofice.models.entity","cl.tavi.backofice.wsrest"})
//@EnableJpaRepositories(basePackageClasses=cl.tavi.backofice.models.dao.IUsuarioDao.class)
@SpringBootApplication
public class BackofficeApiRestLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeApiRestLoginApplication.class, args);
	}

}
