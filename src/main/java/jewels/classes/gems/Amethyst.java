package jewels.classes.gems;

import jewels.classes.common.PreciousTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Amethyst extends Gem {
    private static final Logger LOGGER = LoggerFactory.getLogger(Amethyst.class);

    public Amethyst() {
        this.karat = 1D;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 9.61;
        this.transparency = 0.27;
        LOGGER.debug("New amethyst has been created: " + this.toString());
    }

    public Amethyst(Double karat) {
        this.karat = karat;
        this.precious = PreciousTypes.SEMI_PRECIOUS;
        this.price = karat * 9.61;
        this.transparency = 0.27;
        LOGGER.debug("New amethyst has been created: " + this.toString());
    }
}
