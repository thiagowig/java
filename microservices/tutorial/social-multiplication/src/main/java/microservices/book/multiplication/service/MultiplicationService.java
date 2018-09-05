package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;

/**
 * Created by thiago on 9/4/18.
 */
public interface MultiplicationService {

    Multiplication createRandomMultiplication();
}

