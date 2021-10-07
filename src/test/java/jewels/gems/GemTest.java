package jewels.gems;

import jewels.classes.common.PreciousTypes;
import jewels.classes.gems.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GemTest {

    @Test
    public void createGemTest() {
        Gem gem = new Gem();
        assertEquals(0.0D, gem.getKarat(), 0.001);
        assertEquals(PreciousTypes.ORDINARY, gem.getPrecious());
        assertEquals(0.0D, gem.getTransparency(), 0.001);
        assertEquals(0.0D, gem.getPrice(), 0.001);
    }

}
