package jewels.gems;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.gems.Topaz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopazTest {
    @Test
    public void createTopazTest() {
        Topaz gem = new Topaz();
        Assertions.assertEquals(1D, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.SEMI_PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.38D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(12.75D, gem.getPrice(), 0.001);
    }

    @Test
    public void createParametrizedTopazTest() {
        Double karat = 2.5D;
        Topaz gem = new Topaz(karat);
        Assertions.assertEquals(karat, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.SEMI_PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.38D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(karat * 12.75D, gem.getPrice(), 0.001 );
    }
}
