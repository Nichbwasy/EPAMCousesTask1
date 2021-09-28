package jewels.gems;

import jewels.commom.PreciousTypes;

public class Sapphire extends Gem{
    public Sapphire() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.value = karat * 35.59;
    }

    public Sapphire(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.value = karat * 35.59;
    }
}
