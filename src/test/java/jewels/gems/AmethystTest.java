package jewels.gems;

import jewels.classes.common.PreciousTypes;
import jewels.classes.gems.Amethyst;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmethystTest {
    @Test
    public void createAmethystTest() {
        Amethyst gem = new Amethyst();
        Assertions.assertEquals(1D, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.SEMI_PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.27D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(9.61D, gem.getPrice(), 0.001);
    }

    @Test
    public void createParametrizedAmethystTest() {
        Double karat = 2.5D;
        Amethyst gem = new Amethyst(karat);
        Assertions.assertEquals(karat, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.SEMI_PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.27D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(karat * 9.61D, gem.getPrice(), 0.001);
    }
}
