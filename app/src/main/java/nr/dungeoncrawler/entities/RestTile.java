package nr.dungeoncrawler.entities;

import nr.dungeoncrawler.interfaces.Node;

public class RestTile implements Node {
    private String type = "Rest";

    @Override
    public String getType() {
        return type;
    }
}
