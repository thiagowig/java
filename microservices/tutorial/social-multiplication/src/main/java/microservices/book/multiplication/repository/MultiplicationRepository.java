package microservices.book.multiplication.repository;

import microservices.book.multiplication.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by thiago on 11/13/18.
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
