package ru.dendevjv.dsalgjavamg.ch02;

/**
 * Photographs that can be sold.
 */
public class Photograph implements Sellable {
    private String description;
    private int price;
    private boolean color;
    
    public Photograph(String desc, int pr, boolean clr) {
        description = desc;
        price = pr;
        color = clr;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price / 2;
    }
    
    public boolean isColor() {
        return color;
    }

}
