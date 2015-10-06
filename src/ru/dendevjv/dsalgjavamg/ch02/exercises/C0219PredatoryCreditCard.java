package ru.dendevjv.dsalgjavamg.ch02.exercises;

import ru.dendevjv.dsalgjavamg.ch01.CreditCard;

public class C0219PredatoryCreditCard extends CreditCard {
    private static final double MINIMUM_MONTHLY_PAYMENT_PERCENTAGE = 50.0;

    private static final double MINIMUM_PAYMENT_FEE = 1.0;
    
    /** Annual percentage rate. */
    private double apr;
    private double monthlyPayment;
    private double minimumMonthlyPayment;

    public C0219PredatoryCreditCard(String cust, String bk, String acnt, int lim,
            double initialBal, double rate) {
        super(cust, bk, acnt, lim, initialBal);
        apr = rate;
        calculateMinimumMonthlyPayment();
    }
    
    /**
     * Charges interest on a positive balance.
     */
    public void processMonth() {
        if (monthlyPayment < minimumMonthlyPayment) {
            balance += MINIMUM_PAYMENT_FEE;
        }
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
        calculateMinimumMonthlyPayment();
    }
    
    @Override
    public void makePayment(double amount) {
        super.makePayment(amount);
        monthlyPayment += amount;
    }
    
    private void calculateMinimumMonthlyPayment() {
        monthlyPayment = 0;
        double currentBalance = getBalance();
        if (currentBalance < 0) {
            minimumMonthlyPayment = -currentBalance * (MINIMUM_MONTHLY_PAYMENT_PERCENTAGE / 100.0);
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
    
    @Override
    public String toStringMultilined() {
        String s = super.toStringMultilined();
        s += System.lineSeparator() + "monthlyPayment = " + monthlyPayment;
        return s;
    }
    
    @Override
    public void printSummary() {
        System.out.println();
        super.printSummary();
    }
    
    public static void main(String[] args) {
        C0219PredatoryCreditCard cc = new C0219PredatoryCreditCard("John Doe", "JM", "101", 1000, -100, 2.0);
        cc.printSummary();
        
        cc.makePayment(10);
        cc.printSummary();
        
        cc.processMonth();
        cc.printSummary();
    }
}
