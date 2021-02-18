package com.skrrtnick.cutnburn.data;

public enum Axe {
    BRONZE_AXE("Bronze axe", 1351, 1, 1),
    IRON_AXE("Iron axe", 1349, 1, 1),
    STEEL_AXE("Steel axe", 1353, 6, 5),
    BLACK_AXE("Black axe", 1361, 11, 10),
    MITHRIL_AXE("Mithril axe", 1355, 21, 20),
    ADAMANT_AXE("Adamant axe", 1357, 31, 30),
    RUNE_AXE("Rune axe", 1359, 41, 40);

    String axeName;
    int axeID, wcLevelRequired, atkLevelRequired;

    Axe(String axeName, int axeID, int wcLevelRequired, int atkLevelRequired) {
        this.axeName = axeName;
        this.axeID = axeID;
        this.wcLevelRequired = wcLevelRequired;
        this.atkLevelRequired = atkLevelRequired;
    }

    public int getAtkLevelRequired() {
        return atkLevelRequired;
    }

    public int getAxeID() {
        return axeID;
    }

    public int getWcLevelRequired() {
        return wcLevelRequired;
    }

    public String getAxeName() {
        return axeName;
    }

    public static Axe getBestAxe(int wc) {
        Axe temp = null;
        for (Axe a : Axe.values()) {
            if (a.getWcLevelRequired() <= wc) {
                temp = a;
            } else {
                return temp;
            }
        }
        return temp;

    }

    public static Axe getNextBestAxe(int wc) {
        Axe temp = Axe.values()[0];
        for (int i = 1; i <= Axe.values().length - 1; i++) {
            if (Axe.values()[i].getWcLevelRequired() <= wc) {
                temp = Axe.values()[i - 1];
            } else {
                return temp;
            }
        }
        return temp;

    }


}
