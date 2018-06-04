package org.learning.model;

import java.math.BigDecimal;

public interface Bonuses {

    static BigDecimal overtime(BigDecimal amount) {
        return amount.add(BigDecimal.valueOf(100));
    }

    static BigDecimal birthday(BigDecimal amount) {
        return amount.add(BigDecimal.valueOf(1000));
    }
}