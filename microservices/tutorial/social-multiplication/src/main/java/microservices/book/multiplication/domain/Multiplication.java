package microservices.book.multiplication.domain;

import lombok.Data;

/**
 * Created by thiago on 9/2/18.
 */
@Data
public class Multiplication {

    private int factorA;
    private int factorB;
    private int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        this.result = factorA * factorB;
    }
}
