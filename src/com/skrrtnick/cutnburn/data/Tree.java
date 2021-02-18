package com.skrrtnick.cutnburn.data;

import com.epicbot.api.shared.model.Area;

public enum Tree {
    TREE("Tree", Location.TREE_AREA.getArea(),1,1),
    OAK("Oak", Location.OAKS_AREA.getArea(),15,15),
    WILLOW("Willow", Location.WILLOWS_AREA.getArea(),30,15);
//    YEW("Yew", new Area(new Tile(3092, 3245, 0), new Tile(3094, 3240, 0)));

    private Area area;
    private String name;
    private int wcRequiredLevel;
    private int fmRequiredLevel;

    public String getName() {
        return name;
    }

    Tree(String name, Area area, int wcRequiredLevel, int fmRequiredLevel) {
        this.name = name;
        this.area = area;
        this.wcRequiredLevel = wcRequiredLevel;
        this.fmRequiredLevel = fmRequiredLevel;
    }

    public Area getArea() {
        return area;
    }

    public int getFmRequiredLevel() {
        return fmRequiredLevel;
    }

    public int getWcRequiredLevel() {
        return wcRequiredLevel;
    }

    public static Tree getBestTree(int fm, int wc) {
        Tree temp = null;
        for (Tree t : Tree.values()) {
            if (t.getFmRequiredLevel() <= fm && t.getWcRequiredLevel() <= wc) {
                temp = t;
            } else {
                return temp;
            }
        } return temp;

    }
}
