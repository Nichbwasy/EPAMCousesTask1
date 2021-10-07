package jewels.classes.controls;

import jewels.classes.filters.NecklaceFilter;
import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;
import jewels.interfaces.controls.INecklaceControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class NecklaceControl implements INecklaceControl {
    private static final Logger LOGGER = LoggerFactory.getLogger(NecklaceControl.class);

    @Override
    public Double getNecklaceWeight(Necklace necklace) {
        Double weight = 0D;
        List<Gem> gems = necklace.getGems();
        for (Gem g : gems)
            weight += g.getKarat();
        LOGGER.info("Weight of gems in the necklace {}.", weight);
        return weight;
    }

    @Override
    public Double getNecklacePrice(Necklace necklace) {
        Double price = 0D;
        List<Gem> gems = necklace.getGems();
        for (Gem g : gems)
            price += g.getPrice();
        LOGGER.info("Price of gems in the necklace {}.", price);
        return price;
    }

    @Override
    public Necklace sortGemsByField(Necklace necklace, String field) {
        List<Gem> gems = necklace.getGems(field);
        Necklace retNecklace = new Necklace(gems.size());
        for (Gem g : gems) retNecklace.addGem(g);
        LOGGER.info("Necklace {} was sorted by field to {}.", necklace.getGems().toString(), gems.toString());
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
            LOGGER.info("Necklace {} was filtrated by transparency to {}.", necklace.getGems().toString(), result.toString());
        } else {
            LOGGER.warn("Can't filter the necklace. Min transparency ({}) can't be more then max transparency ({}).",
                    minTransparency, maxTransparency);
        }
        return result;
    }
}
