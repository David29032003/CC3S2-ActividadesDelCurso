package org.example;

import com.sun.jdi.event.MonitorContendedEnteredEvent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyManyValueTest {
    @Test
    void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");
        assertThat(money.getAmount()).isEqualTo(10);
        assertThat(money.getCurrency()).isEqualTo("USD");
        money = new Money(20, "EUR");
        assertThat(money.getAmount()).isEqualTo(20);
        assertThat(money.getCurrency()).isEqualTo("EUR");
    }
}
