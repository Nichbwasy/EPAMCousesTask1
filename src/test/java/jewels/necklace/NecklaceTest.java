package jewels.necklace;

import static org.junit.jupiter.api.Assertions.*;

import jewels.classes.gems.*;
import jewels.classes.necklace.Necklace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NecklaceTest {
    public static Necklace<Gem> necklace;
    Gem[] gems = new Gem[] {
            new Emerald(3D),
            new Ruby(5D),
            new Amethyst(2D)
    };

    @BeforeAll
    public static void init() {
        necklace = new Necklace<>(3);
        assertEquals(3, necklace.getSize());
        assertEquals(0, necklace.getGems().size());
    }

    @AfterEach
    public void reset() {
        necklace = new Necklace<>(3);
    }

    @Test
    public void AddGemTest() {
        Sapphire sapphire = new Sapphire(10D);
        assertEquals(true, necklace.addGem(sapphire));
    }

    @Test
    public void AddGemOverflowTest() {
        Sapphire sapphire = new Sapphire(10D);
        assertEquals(true, necklace.addGems(gems));
        assertEquals(false, necklace.addGems(sapphire));
    }

    @Test
    public void AddGemsTest() {
        assertEquals(true, necklace.addGems(gems));
    }

    @Test
    public void AddGemsOverflowTest() {
        Gem[] gems = new Gem[] {
                new Emerald(3D),
                new Ruby(5D),
                new Amethyst(2D),
                new Topaz(4D)
        };
        assertEquals(false, necklace.addGems(gems));
    }

    @Test
    public void getGemTest() {
        assertEquals(true, necklace.addGems(gems));
        assertEquals(gems[1], necklace.getGem(1));
    }

    @Test
    public void getGemsTest() {
        assertEquals(true, necklace.addGems(gems));
        assertArrayEquals(gems, necklace.getGems().toArray());
    }

}
