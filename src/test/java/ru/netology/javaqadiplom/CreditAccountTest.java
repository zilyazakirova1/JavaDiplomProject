package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.add(3000);

        Assertions.assertEquals(3000, account.getBalance());
    }
    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.add(-3000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldToNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new CreditAccount(-2000,5000,15));
    }
    @Test
    public void shouldToNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new CreditAccount(0,-5000,15));
    }
    @Test
    public void shouldToNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new CreditAccount(0,5000,-15));
    }

    @Test
    public void shouldPayToPositiveAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(-3000, account.getBalance());
    }
    @Test
    public void shouldPayToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.pay(-3000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToZeroAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(0, account.getBalance());
    }
}
