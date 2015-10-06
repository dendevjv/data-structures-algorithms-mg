package ru.dendevjv.dsalgjavamg.ch02;

import ru.dendevjv.dsalgjavamg.ch01.CreditCard;

public class PredatoryCreditCard extends CreditCard {
    /** Annual percentage rate. */
    private double apr;

    public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
            double initialBal, double rate) {
        super(cust, bk, acnt, lim, initialBal);
        apr = rate;
    }
    
    /**
     * Charges interest on a positive balance.
     */
    public void processMonth() {
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
    }

    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess) {
            balance += 5;   // assess a 5$ penalty
        }
        return isSuccess;
    }
}
