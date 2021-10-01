package jewels.classes.gems;

import jewels.classes.commom.PreciousTypes;

public class Amethyst extends Gem {
    public Amethyst() {
        this.karat = 1D;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 9.61;
        this.transparency = 0.27;
    }

    public Amethyst(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 9.61;
        this.transparency = 0.27;
    }
}
