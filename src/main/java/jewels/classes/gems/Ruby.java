package jewels.gems;

import jewels.commom.PreciousTypes;

public class Ruby extends Gem{
    public Ruby() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.value = karat * 21.98;
    }

    public Ruby(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.value = karat * 21.98;
    }
}
