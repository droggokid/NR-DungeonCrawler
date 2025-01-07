package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.enums.ConsumableNames;
import nr.dungeoncrawler.interfaces.Item;

public class Monster {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int experience;
    private int gold;
    private Item drop;

    public Monster(String name, int health, int damage, int experience){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.experience = experience;
        drop = new Potion(ConsumableNames.HEALTH_POTION);
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getDamage(){
        return damage;
    }

    public int getDefense(){
        return defense;
    }

    public int getExperience(){
        return experience;
    }

    public int getGold(){
        return gold;
    }

    public void attack(Player player){
        int damage = this.damage - player.getArmor();
        if(damage < 0){
            player.setArmor(player.getArmor()-damage);
        }
        player.setHealth(player.getHealth()-damage);
    }
    public Item getDrop(){
        return drop;
    }

    public void setDrop(Item drop){
        this.drop = drop;
    }

}
