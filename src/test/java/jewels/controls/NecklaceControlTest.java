package jewels.controls;

import static org.junit.jupiter.api.Assertions.*;

import jewels.classes.commom.PreciousTypes;
import jewels.classes.controls.NecklaceControl;
import jewels.classes.gems.*;
import jewels.classes.necklace.Necklace;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.List;


public class NecklaceControlTest {
    private static Necklace<Gem> necklace;
    private static NecklaceControl necklaceControl;

    @BeforeAll
    public static void init(){
        necklace = new Necklace<>(5);
        necklaceControl = new NecklaceControl();
        Gem[] gems = new Gem[]{
            new Emerald(1D),
            new Amethyst(1D),
            new Ruby(1D),
            new Topaz(1D),
            new Sapphire(1D),
        };
        necklace.addGems(gems);
        for (int i = 0; i < gems.length; i++)
            assertEquals(gems[i], necklace.getGem(i));
    }

    @Test
    public void getNecklaceWeightTest(){
        assertEquals(5, necklaceControl.getNecklaceWeight(necklace), 0.001);
    }

    @Test
    public void getNecklacePriceTest(){
        assertEquals(148.1, necklaceControl.getNecklacePrice(necklace), 0.001);
    }

    @Test
    public void sortGemsByPreciousFieldTest(){
        Necklace sortedNecklace = necklaceControl.sortGemsByField(necklace, "precious");
        List<Gem> gems = sortedNecklace.getGems();
        Boolean isCorrect = true;
        if (gems.get(0).getPrecious() != PreciousTypes.PRECIOUS) isCorrect = false;
        if (gems.get(1).getPrecious() != PreciousTypes.PRECIOUS) isCorrect = false;
        if (gems.get(2).getPrecious() != PreciousTypes.PRECIOUS) isCorrect = false;
        if (gems.get(3).getPrecious() != PreciousTypes.SEMI_PRECIOUS) isCorrect = false;
        if (gems.get(4).getPrecious() != PreciousTypes.SEMI_PRECIOUS) isCorrect = false;
        assertEquals(true, isCorrect);
    }

    @Test
    public void sortGemsByPriceFieldTest(){
        Necklace sortedNecklace = necklaceControl.sortGemsByField(necklace, "price");
        List<Gem> gems = sortedNecklace.getGems();
        Double minPrice = gems.get(0).getPrice();
        Boolean isCorrect = true;
        for (Gem g : gems)
            if (g.getPrice() < minPrice) isCorrect = false;
        assertEquals(true, isCorrect);
    }

    @Test
    public void sortGemsByKaratFieldTest(){
        Necklace<Gem> sortedNecklace = necklaceControl.sortGemsByField(necklace, "Karat");
        List<Gem> gems = sortedNecklace.getGems();
        Double minKarat = gems.get(0).getKarat();
        Boolean isCorrect = true;
        for (Gem g : gems)
            if (g.getKarat() < minKarat) isCorrect = false;
        assertEquals(true, isCorrect);
    }

    @Test
    public void sortGemsByTransparencyFieldTest(){
        Necklace sortedNecklace = necklaceControl.sortGemsByField(necklace, "transparency");
        List<Gem> gems = sortedNecklace.getGems();
        Double minTransparency = gems.get(0).getTransparency();
        Boolean isCorrect = true;
        for (Gem g : gems)
            if (g.getTransparency() < minTransparency) isCorrect = false;
        assertEquals(true, isCorrect);
    }


    @Test
    public void getGemsByTransparencyTest(){
        Double min = 0.7D;
        Double max = 0.99D;
        List<Gem> gems = necklaceControl.getGemsByTransparency(necklace, min, max);
        Boolean isCorrect = true;
        for (Gem g : gems)
            if (g.getTransparency() > max || g.getTransparency() < min) isCorrect = false;
        assertEquals(true, isCorrect);
    }
}
