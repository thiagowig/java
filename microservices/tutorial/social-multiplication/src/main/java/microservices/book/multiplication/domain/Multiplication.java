package microservices.book.multiplication.domain;

import lombok.*;

/**
 * Created by thiago on 9/2/18.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class Multiplication {

    private final int factorA;
    private final int factorB;

    Multiplication() {
        this(0, 0);
    }
}
