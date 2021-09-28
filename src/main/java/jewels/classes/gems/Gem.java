package jewels.gems;

import jewels.commom.PreciousTypes;

public class Gem {
    protected Double karat = 0D;
    protected PreciousTypes precious = PreciousTypes.ORDINARY;
    protected Double value = 0D;

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

    public Double getValue() {
        return value;
    }

}
