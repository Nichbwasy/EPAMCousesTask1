package jewels.classes.filters;

import jewels.classes.common.PreciousTypes;
import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NecklaceFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(NecklaceFilter.class);

    private Necklace excludedNecklace;
    private PreciousTypes gemType = null;
    private Double minTransparency = null;
    private Double maxTransparency = null;

    public NecklaceFilter(Necklace excludedNecklace) {
        this.excludedNecklace = excludedNecklace;
    }

    public Necklace getExcludedNecklace() {
        return excludedNecklace;
    }

    public void setExcludedNecklace(Necklace excludedNecklace) {
        this.excludedNecklace = excludedNecklace;
    }

    public PreciousTypes getGemType() {
        return gemType;
    }

    public void setGemType(PreciousTypes gemType) {
        this.gemType = gemType;
        LOGGER.info("Gem type has been sated to {}", gemType.toString());
    }

    public Double getMinTransparency() {
        return minTransparency;
    }

    public void setMinTransparency(Double minTransparency) {
        if (minTransparency >= 0 & minTransparency <= 1) {
            this.minTransparency = minTransparency;
            LOGGER.info("Min transparency has been sated to {} ", minTransparency);
        }
        else {
            this.maxTransparency = 0D;
            LOGGER.warn("Min transparency must be in the diapason from 0 to 1. " +
                    "Entered value = '{}'", minTransparency);
        }
    }

    public Double getMaxTransparency() {
        return maxTransparency;
    }

    public void setMaxTransparency(Double maxTransparency) {
        if (maxTransparency >= 0 & maxTransparency <= 1) {
            this.maxTransparency = maxTransparency;
            LOGGER.info("Max transparency has been sated to {} ", minTransparency);
        }
        else {
            this.maxTransparency = 1D;
            LOGGER.warn("Max transparency must be in the diapason from 0 to 1. " +
                    "Entered value = '{}'", maxTransparency);
        }
    }
}
