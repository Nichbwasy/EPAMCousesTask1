package jewels.classes.gems;

import jewels.classes.common.PreciousTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ruby extends Gem{
    private static final Logger LOGGER = LoggerFactory.getLogger(Ruby.class);

    public Ruby() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 21.98;
        this.transparency = 0.75;
        LOGGER.debug("New ruby has been created: " + this.toString());
    }

    public Ruby(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 21.98;
        this.transparency = 0.75;
        LOGGER.debug("New ruby has been created: " + this.toString());
    }
}
