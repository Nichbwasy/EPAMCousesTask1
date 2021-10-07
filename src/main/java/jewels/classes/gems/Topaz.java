package jewels.classes.gems;

import jewels.classes.common.PreciousTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Topaz extends Gem {
    private static final Logger LOGGER = LoggerFactory.getLogger(Topaz.class);

    public Topaz() {
        this.karat = 1D;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 12.75;
        this.transparency = 0.38;
        LOGGER.debug("New topaz has been created: " + this.toString());
    }

    public Topaz(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 12.75;
        this.transparency = 0.38;
        LOGGER.debug("New topaz has been created: " + this.toString());
    }
}
