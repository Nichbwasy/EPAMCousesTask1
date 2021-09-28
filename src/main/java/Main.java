import jewels.gems.*;
import jewels.necklace.Necklace;

public class Main {
    public static void main(String[] args) {
        Gem g1 = new Amethyst(4D);
        Gem g2 = new Topaz(6D);
        Gem g3 = new Sapphire(2D);
        Gem g4 = new Ruby(1.5D);
        Gem g5 = new Emerald(3.4D);
        Necklace necklace = new Necklace(5);
        necklace.addGems(g1, g2, g3, g4, g5);
        necklace.addGem(g2);

    }

}
