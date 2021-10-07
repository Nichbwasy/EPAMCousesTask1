package jewels.classes.gems;

import jewels.classes.common.PreciousTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sapphire extends Gem{
    private static final Logger LOGGER = LoggerFactory.getLogger(Sapphire.class);

    public Sapphire() {
        this.karat = 1D;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 35.59;
        this.transparency = 0.69;
        LOGGER.debug("New sapphire has been created: " + this.toString());
    }

    public Sapphire(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.PRECIOUS;
        this.price = karat * 35.59;
        this.transparency = 0.69;
        LOGGER.debug("New sapphire has been created: " + this.toString());
    }
}
