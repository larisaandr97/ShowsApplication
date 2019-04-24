package unibuc.Domain;

public class PriceCategory {
    protected String name;
    protected int discount;

    public PriceCategory(String name, int discount) {
        name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
