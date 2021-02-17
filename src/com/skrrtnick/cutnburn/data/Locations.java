package com.skrrtnick.cutnburn.data;

import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.model.Tile;

public enum Locations {
    DRAYNOR_BANK("Draynor Bank", new Area(new Tile(3092, 3245, 0), new Tile(3094, 3240, 0))),
    TREE_SPOT("Tree spot", new Area( new Tile(3239,3155), new Tile(3244,3151))),
    OAK_SPOT("Oak spot", new Area(new Tile(3092, 3245, 0), new Tile(3094, 3240, 0)));

    private Area area;
    private String name;

    public String getName() {
        return name;
    }

    Locations(String name, Area area) {
        this.name = name;
        this.area = area;
    }
    public Area getArea() {
        return area;
    }
}
