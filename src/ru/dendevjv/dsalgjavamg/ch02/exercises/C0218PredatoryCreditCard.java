package ru.dendevjv.dsalgjavamg.ch02.exercises;

import ru.dendevjv.dsalgjavamg.ch01.CreditCard;

public class C0218PredatoryCreditCard extends CreditCard {
    /** Annual percentage rate. */
    private double apr;
    private int chargeCount;

    public C0218PredatoryCreditCard(String cust, String bk, String acnt, int lim,
            double initialBal, double rate) {
        super(cust, bk, acnt, lim, initialBal);
        apr = rate;
        chargeCount = 0;
    }
    
    /**
     * Charges interest on a positive balance.
     */
    public void processMonth() {
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
        chargeCount = 0;
    }

    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess) {
            balance += 5;   // assess a 5$ penalty
        }
        chargeCount++;
        if (chargeCount >= 10) {
            balance += 1;
        }
        return isSuccess;
    }
}
