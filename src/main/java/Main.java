import jewels.classes.controls.NecklaceControl;
import jewels.classes.gems.*;
import jewels.classes.necklace.Necklace;
import jewels.interfaces.controls.INecklaceControl;

public class Main {
    private static INecklaceControl necklaceControl = new NecklaceControl();

    public static void main(String[] args) {
        Gem g1 = new Amethyst(4D);
        Gem g2 = new Topaz(6D);
        Gem g3 = new Sapphire(2D);
        Gem g4 = new Ruby(1.5D);
        Gem g5 = new Emerald(3.4D);
        Necklace necklace = new Necklace(5);
        necklace.addGems(g1, g2, g3, g4, g5);

        System.out.println("The necklace weight is " + necklaceControl.getNecklaceWeight(necklace));
        System.out.println("The necklace price is " + necklaceControl.getNecklacePrice(necklace));

    }

}
