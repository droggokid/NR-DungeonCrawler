package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Node;
import nr.dungeoncrawler.utils.Dice;

public class EventTile implements Node{
    private String type = "Event";
    private Dice dice;
    private Node previous;
    private boolean visited;
    private boolean start;
    private boolean end;
    private String mobs;

    @Override
    public String getType() {
        return type;
    }
}