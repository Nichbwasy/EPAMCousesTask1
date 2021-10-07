package jewels.classes.gems;

import jewels.classes.common.PreciousTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Emerald extends Gem{
    private static final Logger LOGGER = LoggerFactory.getLogger(Emerald.class);

    public Emerald() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 68.17;
        this.transparency = 0.94;
        LOGGER.debug("New emerald has been created: " + this.toString());
    }

    public Emerald(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 68.17;
        this.transparency = 0.94;
        LOGGER.debug("New emerald has been created: " + this.toString());
    }
}
