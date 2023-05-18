package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void testConstructorWithNegativeRate() {
        int initialBalance = 2000;
        int minBalance = 1_000;
        int maxBalance = 10_000;
        int rate = -1;

        Assertions.assertThrows(RuntimeException.class, () -> {
            new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        });
    }
    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }
    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldPayMoreThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(2_000 - 1_000, account.getBalance());
    }
    @Test
    public void shouldPayLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void YearChangePositiveBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(100, account.yearChange());
    }
    @Test
    public void YearChangeRounding() {
        SavingAccount account = new SavingAccount(
                1_234,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(60, account.yearChange());
    }
    @Test
    public void YearChangeZeroRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );
        Assertions.assertEquals(0, account.yearChange());
    }
}
