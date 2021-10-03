import jewels.classes.controls.NecklaceControl;
import jewels.classes.gems.*;
import jewels.classes.necklace.Necklace;
import jewels.interfaces.controls.INecklaceControl;

import java.util.List;

public class Main {
    private static INecklaceControl necklaceControl = new NecklaceControl();

    public static void main(String[] args) {
        Gem g1 = new Amethyst(1D);
        Gem g2 = new Topaz(1D);
        Gem g3 = new Sapphire(1D);
        Gem g4 = new Ruby(1D);
        Gem g5 = new Emerald(1D);
        Necklace<Gem> necklace = new Necklace<>(5);
        necklace.addGems(g1, g3, g2, g4, g5);
        Double weight = necklaceControl.getNecklaceWeight(necklace);
        Necklace sortedNecklace = necklaceControl.sortGemsByField(necklace, "precious");


        List<Gem> gems = necklaceControl.getGemsByTransparency(necklace, 0.7D, 0.99D);
        for (Gem g : gems) System.out.println(g);

        System.out.println("The necklace weight is " + necklaceControl.getNecklaceWeight(necklace));
        System.out.println("The necklace price is " + necklaceControl.getNecklacePrice(necklace));

    }

}
