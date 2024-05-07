package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
public class MoneyManyParamsAnnotationTest {
    @ParameterizedTest
    @CsvSource({
        "10,USD",
        "20,EUR",
        "30,CHF",
    })
    void constructoShouldAmountAndCurrency(int amount ,String currency){
        Money money = new Money(amount,currency);
        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);
    }
}
