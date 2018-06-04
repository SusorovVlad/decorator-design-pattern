package org.learning.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SalaryTest {

    @Test
    public void creation() {
        Salary salary = Salary.gross(BigDecimal.TEN);

        assertThat(salary).hasFieldOrPropertyWithValue("amount", BigDecimal.TEN);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void creationWithBonuses() {
        Salary salary = Salary.gross(BigDecimal.valueOf(100))
                .apply(Bonuses::overtime, Bonuses::birthday);

        assertThat(salary).hasFieldOrPropertyWithValue("amount", BigDecimal.valueOf(1200));
    }

    @Test
    public void exceptionThrownWhenAmountIsNull() {
        Assertions.assertThatThrownBy(() -> Salary.gross(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Amount cannot be null.");
    }

    @Test
    public void exceptionThrownWhenAmountIsNegative() {
        Assertions.assertThatThrownBy(() -> Salary.gross(BigDecimal.valueOf(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Amount cannot be negative.");
    }
}
