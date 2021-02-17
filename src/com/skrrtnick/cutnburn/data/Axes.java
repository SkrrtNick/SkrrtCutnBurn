package com.skrrtnick.cutnburn.data;

public enum Axes {
    BRONZE_AXE("Bronze axe",1351,1,1),
    IRON_AXE("Iron axe",1349,1,1),
    STEEL_AXE("Steel axe",1353,6,5),
    BLACK_AXE("Black axe",1361,11,10),
    MITHRIL_AXE("Mithril axe",1355,21,20),
    ADAMANT_AXE("Adamant axe",1357,31,30),
    RUNE_AXE("Rune axe",1359,41,40);

String axeName;
int axeID, wcLevelRequired, atkLevelRequired;

Axes(String axeName, int axeID, int wcLevelRequired, int atkLevelRequired){
    this.axeName = axeName;
    this.axeID = axeID;
    this.wcLevelRequired = wcLevelRequired;
    this.atkLevelRequired = atkLevelRequired;
}




}
