package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;

/**
 * Created by thiago on 9/4/18.
 */
public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    Boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}

