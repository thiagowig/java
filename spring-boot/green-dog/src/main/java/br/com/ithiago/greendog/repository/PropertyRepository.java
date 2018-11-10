package br.com.ithiago.greendog.repository;

import br.com.ithiago.greendog.model.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by thiago on 5/31/18.
 */
public interface PropertyRepository extends PagingAndSortingRepository<Property, String> {

    public List<Property> findByName(String name);

}
