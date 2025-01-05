package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Spell;

public class FireSpell implements Spell {
    private String name;
    private int damage;
    private int manaCost;

    public FireSpell(String name, int damage, int manaCost){
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public int getManaCost(){
        return manaCost;
    }
    private void use(Monster monster){
        monster.setHealth(monster.getHealth()-damage);

    }
}
