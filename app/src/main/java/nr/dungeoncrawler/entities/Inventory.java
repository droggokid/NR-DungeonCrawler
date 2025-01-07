package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Consumable;
import nr.dungeoncrawler.interfaces.Item;
import nr.dungeoncrawler.enums.ConsumableNames;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private boolean isOpen;
    private Player player;

    public Inventory(Player player){
        this.player = player;
        isOpen = false;
        items = new ArrayList<Item>();
    }

    public ArrayList<Item> getConsumables(){
        return items;
    }

    public void add(Item item){
        items.add(item);
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
