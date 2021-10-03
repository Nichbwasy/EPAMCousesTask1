package jewels.gems;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.gems.Ruby;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RubyTest {
    @Test
    public void createRubyTest() {
        Ruby gem = new Ruby();
        Assertions.assertEquals(1D, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.75D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(21.98D, gem.getPrice(), 0.001);
    }

    @Test
    public void createParametrizedRubyTest() {
        Double karat = 2.5D;
        Ruby gem = new Ruby(karat);
        Assertions.assertEquals(karat, gem.getKarat(), 0.001);
        Assertions.assertEquals(PreciousTypes.PRECIOUS, gem.getPrecious());
        Assertions.assertEquals(0.75D, gem.getTransparency(), 0.001);
        Assertions.assertEquals(karat * 21.98D, gem.getPrice(), 0.001);
    }
}
