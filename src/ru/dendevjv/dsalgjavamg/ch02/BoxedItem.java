package ru.dendevjv.dsalgjavamg.ch02;

public class BoxedItem implements Sellable, Transportable {
    private String descript;
    private int price;
    private int weight;
    private boolean haz;
    @SuppressWarnings("unused") // this instance variable is an example
    private int height = 0;
    @SuppressWarnings("unused") // this instance variable is an example
    private int width = 0;
    @SuppressWarnings("unused") // this instance variable is an example
    private int depth = 0;

    public BoxedItem(String desc, int pr, int wt, boolean ha) {
        descript = desc;
        price = pr;
        weight = wt;
        haz = ha;
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public boolean isHazardous() {
        return haz;
    }

    @Override
    public String description() {
        return descript;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price / 2;
    }

    public int insuredValue() {
        return price * 2;
    }

    public void setBox(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }
}
