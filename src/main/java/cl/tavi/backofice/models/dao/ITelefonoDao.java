package cl.tavi.backofice.models.dao;

import org.springframework.data.repository.CrudRepository;

import cl.tavi.backofice.models.entity.Telefono;

public interface ITelefonoDao extends CrudRepository<Telefono, Long> {

}
