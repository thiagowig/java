package br.com.ithiago.repository;

import br.com.ithiago.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by thiago on 12/30/18.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
