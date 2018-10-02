package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thiago on 9/4/18.
 */
@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();

        return new Multiplication(factorA, factorB);
    }

    @Override
    public Boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
        int factorA = resultAttempt.getMultiplication().getFactorA();
        int factorB = resultAttempt.getMultiplication().getFactorB();
        Boolean result = resultAttempt.getResultAttempt() == factorA * factorB;

        return result;
    }
}
