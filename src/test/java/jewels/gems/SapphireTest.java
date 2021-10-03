package jewels.gems;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.gems.Sapphire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SapphireTest {
    @Test
    public void createSapphireTest() {
        Sapphire gem = new Sapphire();
        Assertions.assertEquals(1D, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.69D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(35.59D, gem.getPrice(), 0.001);
    }

    @Test
    public void createParametrizedSapphireTest() {
        Double karat = 2.5D;
        Sapphire gem = new Sapphire(karat);
        Assertions.assertEquals(karat, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.69D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(karat * 35.59D, gem.getPrice(), 0.001);
    }
}
