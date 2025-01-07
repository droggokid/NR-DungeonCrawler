package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Consumable;
import nr.dungeoncrawler.enums.ConsumableNames;

public class Potion implements Consumable {
    private static int POTION_HEALTH = 5;
    private boolean used;
    private ConsumableNames name;

    
    public Potion(ConsumableNames name){
        this.name = name;
        used = false;
    }

    public int getHealth(){
        return POTION_HEALTH;
    }
    public boolean isUsed(){
        return used;
    }

    public void use(){;
        used = true;
    }
    public ConsumableNames getName(){
        return name;
    }

}
