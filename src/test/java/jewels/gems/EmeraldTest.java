package jewels.gems;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.gems.Emerald;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmeraldTest {
    @Test
    public void createEmeraldTest() {
        Emerald gem = new Emerald();
        Assertions.assertEquals(1D, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.94D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(68.17D, gem.getPrice(), 0.001);
    }

    @Test
    public void createParametrizedEmeraldTest() {
        Double karat = 2.5D;
        Emerald gem = new Emerald(karat);
        Assertions.assertEquals(karat, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.94D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(karat * 68.17D, gem.getPrice(), 0.001);
    }
}
