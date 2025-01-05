package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Node;
import nr.dungeoncrawler.utils.Dice;

public class MobTile implements Node {
    private String type = "Mob";
    private Dice dice;
    private Node previous;
    private boolean visited;
    private boolean start;
    private boolean end;
    private String mobs;

    public MobTile() {
        this.start = false;
        this.end = false;
        this.mobs = "Goblin";
    }

    @Override
    public String getType() {
        return type;
    }
}