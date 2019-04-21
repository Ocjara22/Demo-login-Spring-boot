package cl.tavi.backofice.models.service;

import java.util.List;

import cl.tavi.backofice.exception.EmailRegistradoException;
import cl.tavi.backofice.models.entity.Telefono;
import cl.tavi.backofice.models.entity.Usuario;

public interface UserService {
	
	
	public Usuario saveUser(Usuario usuario, List<Telefono> phones) throws EmailRegistradoException; 

	
}
