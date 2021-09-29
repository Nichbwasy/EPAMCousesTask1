package jewels.classes.gems;

import jewels.classes.commom.PreciousTypes;

public class Topaz extends Gem {
    public Topaz() {
        this.karat = 1D;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 12.75;
    }

    public Topaz(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 12.75;
    }
}
