package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Consumable;
import nr.dungeoncrawler.enums.ConsumableNames;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Consumable> consumables;
    private boolean isOpen;
    private Player player;

    public Inventory(Player player){
        this.player = player;
        isOpen = false;
        consumables = new ArrayList<Consumable>();
    }

    public ArrayList<Consumable> getConsumables(){
        return consumables;
    }

    public void add(Consumable consumable){
        consumables.add(consumable);
    }
    public boolean isOpen(){
        return isOpen;
    }

    public void useConsumable(Consumable consumable){
        consumable.use();
        if(consumable.getName() == ConsumableNames.HEALTH_POTION){
            player.setHealth(player.getHealth()+((Potion) consumable).getHealth());
        }
    }

}
