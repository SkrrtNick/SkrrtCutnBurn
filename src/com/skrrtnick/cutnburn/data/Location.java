package com.skrrtnick.cutnburn.data;

import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.model.Tile;

public enum Location {

    TREE_AREA("Tree area", new Area(new Tile(3172, 3215), new Tile(3160, 3223))),
    OAKS_AREA("Oaks area", new Area(new Tile(3211, 3239), new Tile(3164, 3261))),
    WILLOWS_AREA("Willows area", new Area(new Tile(3180, 3264), new Tile(3162, 3272))),
    BOBS_AXES("Bobs axes", new Area(new Tile(3232, 3201), new Tile(3228, 3205))),
    GRAND_EXCHANGE("Grand Exchange", new Area(new Tile(3170, 3484), new Tile(3158, 3495))),
    DRAYNOR_BANK("Draynor bank", new Area(new Tile(3092, 3245, 0), new Tile(3094, 3240, 0)));

    private Area area;
    private String name;

    public String getName() {
        return name;
    }

    Location(String name, Area area) {
        this.name = name;
        this.area = area;
    }

    public Area getArea() {
        return area;
    }


}




