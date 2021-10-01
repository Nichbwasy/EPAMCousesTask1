package jewels.classes.filters;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;

import java.util.List;

public class NecklaceFilter {
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
    }

    public Double getMinTransparency() {
        return minTransparency;
    }

    public void setMinTransparency(Double minTransparency) {
        if (minTransparency >= 0 & minTransparency <= 1)
            this.minTransparency = minTransparency;
        else {
            this.maxTransparency = 0D;
            System.out.println("Min transparency must be in the diapason from 0 to 1.");
        }
    }

    public Double getMaxTransparency() {
        return maxTransparency;
    }

    public void setMaxTransparency(Double maxTransparency) {
        if (maxTransparency >= 0 & maxTransparency <= 1)
            this.maxTransparency = maxTransparency;
        else {
            this.maxTransparency = 1D;
            System.out.println("Max transparency must be in the diapason from 0 to 1.");
        }
    }
}
