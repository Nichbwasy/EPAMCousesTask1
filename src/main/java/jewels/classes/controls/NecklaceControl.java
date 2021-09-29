package jewels.classes.controls;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.filters.NecklaceFilter;
import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;
import jewels.interfaces.controls.INecklaceControl;

import java.util.List;

public class NecklaceControl implements INecklaceControl {
    @Override
    public Double getNecklaceWeight(Necklace necklace) {
        Double weight = 0D;
        List<Gem> gems = necklace.getGems();
        for (Gem g : gems)
            weight += g.getKarat();
        return weight;
    }

    @Override
    public Double getNecklacePrice(Necklace necklace) {
        Double price = 0D;
        List<Gem> gems = necklace.getGems();
        for (Gem g : gems)
            price += g.getPrice();
        return price;
    }

    @Override
    public Necklace sortGemsByType(Necklace necklace, PreciousTypes type) {
        NecklaceFilter filter = new NecklaceFilter(necklace);
        filter.setGemType(type);
        List<Gem> gems = necklace.getGems(filter);
        Necklace retNecklace = new Necklace(gems.size());
        for (Gem g : gems) retNecklace.addGem(g);
        return retNecklace;
    }

    @Override
    public List<Gem> getGemsByTransparency(Necklace necklace, Double minTransparency, Double maxTransparency) {
        List<Gem> sortedGems = null;
        if (minTransparency >= 0 && minTransparency <= 1){
            if (maxTransparency >= 0 && maxTransparency <= 1) {
                if (minTransparency > maxTransparency) {
                    NecklaceFilter filter = new NecklaceFilter(necklace);
                    filter.setMaxTransparency(maxTransparency);
                    filter.setMinTransparency(maxTransparency);
                    return necklace.getGems(filter, null);
                } else {
                    System.out.println("Min transparency can't be more then max transparency.");
                }
            } else {
                System.out.println("Max transparency must be in the diapason from 0 to 1.");
            }
        } else {
            System.out.println("Min transparency must be in the diapason from 0 to 1.");
        }
        return sortedGems;
    }
}
