package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Node;


public class Dungeon {
    private int width;
    private int height;
    private Node[][] level;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.level = new Node[width][height];
    }

    public Node[][] getLevel() {
        return level;
    }

    public void setLevel(Node[][] level) {
        this.level = level;
    }
}
