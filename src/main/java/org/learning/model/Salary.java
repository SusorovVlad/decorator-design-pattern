package org.learning.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Salary {

    private final BigDecimal amount;

    private Salary(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null.");
        if (amount.intValue() < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
    }

    public static Salary gross(BigDecimal amount) {
        return new Salary(amount);
    }

    public Salary apply(Function<BigDecimal, BigDecimal> ... bonuses) {
        return new Salary(Stream.of(bonuses)
                .reduce(Function.identity(), Function::andThen)
                .apply(amount));
    }
}
