package jewels.gems;

import jewels.commom.PreciousTypes;

public class Emerald extends Gem{
    public Emerald() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.value = karat * 68.17;
    }

    public Emerald(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.value = karat * 68.17;
    }
}
