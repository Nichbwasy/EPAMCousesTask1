package jewels.classes.controls;

import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;
import jewels.interfaces.controls.INecklaceControl;

public class NecklaceControl implements INecklaceControl {
    @Override
    public Double getNecklaceWeight(Necklace necklace) {
        Double weight = 0D;
        for (Gem g : necklace.getGems())
            weight += g.getKarat();
        return weight;
    }

    @Override
    public Double getNecklacePrice(Necklace necklace) {
        Double price = 0D;
        for (Gem g : necklace.getGems())
            price += g.getPrice();
        return price;
    }
}
