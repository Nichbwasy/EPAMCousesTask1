package jewels.classes.gems;

import jewels.classes.common.PreciousTypes;

public class Gem {
    protected Double karat = 0D;
    protected PreciousTypes precious = PreciousTypes.ORDINARY;
    protected Double price = 0D;
    protected Double transparency = 0D;

    public Double getKarat() {
        return karat;
    }

    public void setKarat(Double karat) {
        this.karat = karat;
    }

    public Double getWeight() {
        return karat * 0.2;
    }

    public PreciousTypes getPrecious() {
        return precious;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        return "Gem[" +
                "karat=" + karat +
                ", precious=" + precious +
                ", price=" + price +
                ", transparency=" + transparency +
                ']';
    }
}
