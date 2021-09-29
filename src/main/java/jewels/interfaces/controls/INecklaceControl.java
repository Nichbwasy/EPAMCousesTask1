package jewels.interfaces.controls;

import jewels.classes.necklace.Necklace;

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

}
