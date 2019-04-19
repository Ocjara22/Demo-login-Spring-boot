package cl.tavi.backofice.models.dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.tavi.backofice.models.entity.Usuario;



public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

		
		public Usuario findByUsername(String username);
		

}
