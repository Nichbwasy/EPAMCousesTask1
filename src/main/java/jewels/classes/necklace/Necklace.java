package jewels.classes.necklace;

import jewels.classes.filters.NecklaceFilter;
import jewels.classes.gems.Gem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Necklace<T extends Gem> {
    private List<T> gems;
    private Integer size;

    //Create necklace fixed size without gems.
    public Necklace(Integer size){
        this.gems = new ArrayList<>();
        if (size >= 0) {
            this.size = size;
        } else {
            this.size = 0;
            System.out.println("Size of the necklace can't be lesser than 0!");
        }
    }

    public Integer getSize() {
        return size;
    }

    //Create necklace with gems. Size of the necklace depends of count of gems.
    public Necklace(T... gems){
        this.gems = new ArrayList<>();
        for(T g : gems)
            this.gems.add(g);
        this.size = gems.length;
    }

    //Add new gem in the necklace
    public Boolean addGem(T gem) {
        if (gems.size() + 1 <= size) {
            gems.add(gem);
            return true;
        } else {
            System.out.println("The necklace is overflowed!");
            return false;
        }
    }

    //Add new gems in the necklace
    public Boolean addGems(T... gems) {
        if (this.gems.size() + gems.length <= size) {
            for (T g : gems)
                this.gems.add(g);
            return true;
        } else {
            System.out.println("Can't add gems in the necklace. Too many gems!");
            return false;
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

    public Gem getGem(Integer gemPosition) {
        if (gemPosition >= 0 && gemPosition < this.size)
            return this.gems.get(gemPosition);
        else
            return null;
    }


    public List<Gem> getGems() {
        return getGems(null, null);
    }

    public List<Gem> getGems(String sortName) {
        return getGems(null, sortName);
    }

    public List<Gem> getGems(NecklaceFilter filter) {
        return getGems(filter, null);
    }
    //Returns list of all gems in the necklace
    public List<Gem> getGems(NecklaceFilter filter, String sortName) {
        try {
            Stream<T> stream = gems.stream();
            Predicate<T> predicate = getPredicateByFilter(filter);
            if (predicate != null) {
                stream = stream.filter(predicate);
            }
            Comparator<T> comparator = getComparatorBySortName(sortName);
            if (comparator != null) {
                stream = stream.sorted(comparator);
            }
            return stream.collect(Collectors.toList());
        }catch (Exception e) {

            return null;
        }
    }

    private Predicate<T> getPredicateByFilter(NecklaceFilter filter) {
        try {
            if (filter == null) return null;
            return gem -> {
                if (filter.getExcludedNecklace().gems != null) {
                    if (filter.getGemType() != null) {
                        return filter.getGemType().equals(gem.getPrecious());
                    }
                    if (filter.getMinTransparency() != null && filter.getMaxTransparency() != null) {
                        return filter.getMinTransparency() <= gem.getTransparency() && filter.getMaxTransparency() >= gem.getTransparency();
                    }
                }
                return false;
            };
        }catch (Exception e) {
            return null;
        }
    }

    private Comparator<T> getComparatorBySortName(String sortName) {
        try {
            if (sortName == null) return null;
            switch (sortName.toLowerCase()) {
                case "precious" : {
                    return Comparator.comparing(Gem::getPrecious);
                }
                case "price" : {
                    return Comparator.comparing(Gem::getPrice);
                }
                case "karat" : {
                    return Comparator.comparing(Gem::getKarat);
                }
                case "transparency" : {
                    return Comparator.comparing(Gem::getTransparency);
                }
                default: {
                    return null;
                }
            }
        }catch (Exception e) {
            return null;
        }
    }

}
