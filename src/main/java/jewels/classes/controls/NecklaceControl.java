package jewels.classes.controls;

import jewels.classes.filters.NecklaceFilter;
import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;
import jewels.interfaces.controls.INecklaceControl;

import java.util.ArrayList;
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
    public Necklace sortGemsByField(Necklace necklace, String field) {
        List<Gem> gems = necklace.getGems(field);
        Necklace retNecklace = new Necklace(gems.size());
        for (Gem g : gems) retNecklace.addGem(g);
        return retNecklace;
    }

    @Override
    public List<Gem> getGemsByTransparency(Necklace necklace, Double minTransparency, Double maxTransparency) {
        List<Gem> result = new ArrayList<>();
        if (minTransparency < maxTransparency) {
            NecklaceFilter filter = new NecklaceFilter(necklace);
            filter.setMaxTransparency(maxTransparency);
            filter.setMinTransparency(minTransparency);
            result = necklace.getGems(filter, null);
        } else {
            System.out.println("Min transparency can't be more then max transparency.");
        }
        return result;
    }
}
