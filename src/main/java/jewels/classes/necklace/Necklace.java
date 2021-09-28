package jewels.classes.necklace;

import jewels.classes.gems.Gem;

import java.util.ArrayList;
import java.util.List;

public class Necklace {
    private List<Gem> gems;
    private Integer size;

    //Create necklace fixed size without gems.
    public Necklace(Integer size){
        this.gems = new ArrayList<>();
        if (size >= 0) {
            this.size = size;
        } else {
            this.size = size;
            System.out.println("Size of the necklace can't be lesser than 0!");
        }
    }

    //Create necklace with gems. Size of the necklace depends of count of gems.
    public Necklace(Gem... gems){
        this.gems = new ArrayList<Gem>();
        for(Gem g : gems)
            this.gems.add(g);
        this.size = gems.length;
    }

    //Add new gem in the necklace
    public void addGem(Gem gem) {
        if (gems.size() + 1 <= size) {
            gems.add(gem);
        } else {
            System.out.println("The necklace is overflowed!");
        }
    }

    //Add new gems in the necklace
    public void addGems(Gem... gems) {
        if (this.gems.size() + gems.length <= size) {
            for (Gem g : gems)
                this.gems.add(g);
        } else {
            System.out.println("Can't add gems in the necklace. Too many gems!");
        }
    }

    //Remove gem from the necklace
    public Boolean removeGem(Integer gemPosition) {
        if (gemPosition >= 0 && gemPosition < size) {
            gems.remove(gemPosition);
            return true;
        } else {
            System.out.println("Gem position is put of range!");
            return false;
        }
    }
}
