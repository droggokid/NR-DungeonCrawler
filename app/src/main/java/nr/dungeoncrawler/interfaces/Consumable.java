package nr.dungeoncrawler.interfaces;

import nr.dungeoncrawler.enums.ConsumableNames;

public interface Consumable extends Item{

    void use();
    ConsumableNames getName();

}
