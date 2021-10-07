package jewels.interfaces.controls;

import jewels.classes.gems.Gem;
import jewels.classes.necklace.Necklace;

import java.util.List;

public interface INecklaceControl {
    /**
     * Returns necklace weight in karats.
     * @param necklace Weighed necklace.
     * @return Weight of the necklace in karats.
     */
    Double getNecklaceWeight(Necklace necklace);

    /**
     * Returns cost of all gems in the necklace.
     * @param necklace Necklace to assess the cost.
     * @return Weight of the necklace in karats.
     */
    Double getNecklacePrice(Necklace necklace);

    /**
     * Sorting gems in the necklace by precious type.
     * @param necklace Necklace to sort.
     * @param field Field for sorting.
     * @return Return necklace with sorted gems.
     */
    Necklace sortGemsByField(Necklace necklace, String field);

    /**
     * Returns gems from the necklace with selected transparency diapason.
     * @param necklace Necklace to sort.
     * @param minTransparency Min transparency to sort.
     * @param maxTransparency Max transparency to sort.
     * @return List of gems in selected transparency diapason.
     */
    List<Gem> getGemsByTransparency(Necklace necklace, Double minTransparency, Double maxTransparency);
}
