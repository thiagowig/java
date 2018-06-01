package br.com.ithiago.greendog.repository;

import br.com.ithiago.greendog.model.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thiago on 5/31/18.
 */
@Repository
public interface PropertyRepository extends PagingAndSortingRepository<Property, String> {

    @Query("SELECT prop FROM Property prop WHERE prop.name LIKE %:filter% ORDER BY prop.category")
    public List<Property> findByFilter(@Param("filter") String filter);
}
