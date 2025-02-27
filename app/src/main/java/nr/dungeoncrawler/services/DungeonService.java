package nr.dungeoncrawler.services;

import nr.dungeoncrawler.entities.EventTile;
import nr.dungeoncrawler.entities.MobTile;
import nr.dungeoncrawler.entities.RestTile;
import nr.dungeoncrawler.interfaces.Node;
import nr.dungeoncrawler.utils.Dice;

public class DungeonService {
    public DungeonService() {
    }

    public Node[][] generateLevel(int width, int height) {
        Node[][] level = new Node[width][height];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(x == 0) {
                    level[x][y] = new EventTile();
                } else if(x == width - 1) {
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
}
