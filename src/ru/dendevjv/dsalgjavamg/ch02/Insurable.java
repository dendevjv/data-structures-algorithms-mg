package ru.dendevjv.dsalgjavamg.ch02;

public interface Insurable extends Sellable, Transportable {
    /** Returns insured value in cents */
    int insuredValue();
}
