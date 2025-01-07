package nr.dungeoncrawler.services;

import nr.dungeoncrawler.entities.EventTile;
import nr.dungeoncrawler.entities.MobTile;
import nr.dungeoncrawler.entities.RestTile;
import nr.dungeoncrawler.interfaces.Node;
import nr.dungeoncrawler.utils.Dice;

public class DungeonService {

    private int currentPlayerLevel; // can services hold variables?? 
    Node[][] level;
    public DungeonService() {
        this.currentPlayerLevel = 0;
    }

    public Node[][] generateLevel(int rows, int columns) {
        Node[][] level = new Node[rows][columns];
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < columns; y++) {
                if(x == 0) {
                    level[x][y] = new EventTile();
                } else if(x == rows - 1) {
                    level[x][y] = new RestTile();
                } else {
                    level[x][y] = createTile();
                }
            }
        }
        return level;
    }

    public void printLevel(Node[][] level) {
        for(int x = 0; x < level.length; x++) {
            System.out.printf("%d: ",x);
            for(int y = 0; y < level[x].length; y++) {
                System.out.print(level[x][y].getType() + " ");
            }
            System.out.println();
        }
    }

    private Node createTile() {
        int roll = Dice.rollDice();
        if(roll < 3) {
            return new EventTile();
        } else if(roll < 6) {
            return new MobTile();
        } else {
            return new RestTile();
        }
    }

    public void setCurrentPlayerLevel(int currentPlayerLevel) {
        this.currentPlayerLevel = currentPlayerLevel;
    }
    public int getCurrentPlayerLevel() {
        return currentPlayerLevel;
    }
    public Node[][] getLevel() {
        return level;
    }
    public void setLevel(Node[][] level) {
        this.level = level;
    }
}
