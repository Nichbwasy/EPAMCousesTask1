package jewels.classes.necklace;

import jewels.classes.filters.NecklaceFilter;
import jewels.classes.gems.Gem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Necklace<T extends Gem> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Necklace.class);

    private List<T> gems;
    private Integer size;

    //Create necklace fixed size without gems.
    public Necklace(Integer size){
        this.gems = new ArrayList<>();
        if (size >= 0) {
            this.size = size;
            LOGGER.info("New necklace with size = {} has been created.", size);
        } else {
            this.size = 0;
            LOGGER.warn("Size of the necklace can't be lesser than 0! Size was set to 0.");
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
        LOGGER.info("New necklace with size = {} has been created.", this.size);
    }

    //Add new gem in the necklace
    public Boolean addGem(T gem) {
        if (gems.size() + 1 <= size) {
            gems.add(gem);
            LOGGER.info("New gem {} has been added to the necklace.", gem.toString());
            return true;
        } else {
            LOGGER.warn("Can't add the gem {}. The necklace is overflowed!", gem.toString());
            return false;
        }
    }

    //Add new gems in the necklace
    public Boolean addGems(T... gems) {
        if (this.gems.size() + gems.length <= size) {
            for (T g : gems)
                this.gems.add(g);
            LOGGER.info("New gems {} was added to the necklace.", gems.toString());
            return true;
        } else {
            LOGGER.warn("Can't add gems {} in the necklace. Too many gems!", gems.toString());
            return false;
        }
    }

    //Remove gem from the necklace
    public Boolean removeGem(Integer gemPosition) {
        if (gemPosition >= 0 && gemPosition < size) {
            Gem removedGem = this.getGem(gemPosition);
            gems.remove(gemPosition);
            LOGGER.info("Gem {} with position {} was removed from the necklace."
                    , removedGem.toString(), gemPosition);
            return true;
        } else {
            LOGGER.warn("Can't remove the gem with position {}. Gem position is put of range!", gemPosition);
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
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    private Predicate<T> getPredicateByFilter(NecklaceFilter filter) {
        try {
            if (filter == null) return null;
            return gem -> {
                if (filter.getExcludedNecklace().gems != null) {
                    if (filter.getGemType() != null) {
                        LOGGER.debug("Predicate was returned by gem type");
                        return filter.getGemType().equals(gem.getPrecious());
                    }
                    if (filter.getMinTransparency() != null && filter.getMaxTransparency() != null) {
                        LOGGER.debug("Predicate was returned by gem transparency");
                        return filter.getMinTransparency() <= gem.getTransparency() && filter.getMaxTransparency() >= gem.getTransparency();
                    }
                }
                LOGGER.warn("Can't return predicate. Excluded necklace is null");
                return false;
            };
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    private Comparator<T> getComparatorBySortName(String sortName) {
        try {
            if (sortName == null) return null;
            switch (sortName.toLowerCase()) {
                case "precious" : {
                    LOGGER.debug("Comparator was returned by field {}", sortName);
                    return Comparator.comparing(Gem::getPrecious);
                }
                case "price" : {
                    LOGGER.debug("Comparator was returned by field {}", sortName);
                    return Comparator.comparing(Gem::getPrice);
                }
                case "karat" : {
                    LOGGER.debug("Comparator was returned by field {}", sortName);
                    return Comparator.comparing(Gem::getKarat);
                }
                case "transparency" : {
                    LOGGER.debug("Comparator was returned by field {}", sortName);
                    return Comparator.comparing(Gem::getTransparency);
                }
                default: {
                    LOGGER.warn("Can't return comparator by field {}", sortName);
                    return null;
                }
            }
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Necklace("+ this.size +")";
    }
}
