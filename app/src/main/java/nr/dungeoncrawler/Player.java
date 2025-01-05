package nr.dungeoncrawler;

import java.util.ArrayList;

public class Player {

    private int health;
    private int mana;
    private int attack;
    private int armor;
    private String name;
    private Inventory inventory;
    private ArrayList<Spell> spells;
    public Player(String name){
        this.name=name;
        this.health=10;
        this.attack=10;
        this.armor=0;
        this.mana=3;
        inventory = new Inventory(this);
        this.spells = new ArrayList<Spell>();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void attack(Monster monster){
        System.out.println(name+" is attacking "+ monster.getName());
        monster.setHealth(monster.getHealth()-attack);
    }

    public void defend(){
        System.out.println(name+" is defending");
    }

    public void useSpell(Spell spell){
        System.out.println(name+" is using "+spell.getName());
    }

    public void setHealth(int health){
        this.health=health;
    }

    public int getHealth(){
        return health;
    }

    public int getAttack(){
        return attack;
    }
    
    public void setAttack(int attack){
        this.attack=attack;
    }

    public int getArmor(){
        return armor;
    }

    public void setArmor(int armor){
        this.armor=armor;
    }
    
    public void addConsumable(Consumable consumable){
        inventory.add(consumable);
    }

    public Inventory getInventory(){
        return inventory;
    }

    public ArrayList<Spell> getSpells(){
        return spells;
    }
    public void addSpell(Spell spell){
        spells.add(spell);
    }
}
