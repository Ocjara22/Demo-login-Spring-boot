package cl.tavi.backofice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan({"cl.tavi.backofice.models.entity","cl.tavi.backofice.wsrest"})
//@EnableJpaRepositories(basePackageClasses=cl.tavi.backofice.models.dao.IUsuarioDao.class)
@SpringBootApplication
public class BackofficeApiRestLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeApiRestLoginApplication.class, args);
	}

}
