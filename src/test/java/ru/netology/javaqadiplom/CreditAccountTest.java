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

//    @Test
//    public void shouldToNegativeInitialBalance() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(-2000, 5000, 15));
//    }

    @Test
    public void shouldToNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(0, -5000, 15));
    }

    @Test
    public void shouldToNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CreditAccount(0, 5000, -15));
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

        account.pay(6000);

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

    @Test
    public void shouldYearChangeIfBalancePositive() {
        CreditAccount account = new CreditAccount(
                200,
                5000,
                15
        );

        //  account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldYearChangeIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                -200,
                5000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldYearChangeIfBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void GetterCreditLimit() {
        CreditAccount account = new CreditAccount(200, 5000, 15);
        int expected = 5000;
        Assertions.assertEquals(expected, account.getCreditLimit());
    }
}
