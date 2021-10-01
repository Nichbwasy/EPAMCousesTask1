package jewels.classes.gems;

import jewels.classes.commom.PreciousTypes;

public class Ruby extends Gem{
    public Ruby() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 21.98;
        this.transparency = 0.75;
    }

    public Ruby(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 21.98;
        this.transparency = 0.75;
    }
}
