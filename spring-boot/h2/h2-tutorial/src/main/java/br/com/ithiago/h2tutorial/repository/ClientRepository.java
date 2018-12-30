package br.com.ithiago.h2tutorial.repository;

import br.com.ithiago.h2tutorial.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by thiago on 12/30/18.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
