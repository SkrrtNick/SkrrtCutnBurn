package com.skrrtnick.cutnburn.data;

import com.epicbot.api.shared.APIContext;

public enum Item {
    TINDERBOX("Tinderbox",590),
    COINS("Coins",995),
    ASHES("Ashes", 592);

    String name;
    int itemID;

    Item(String name, int itemID){
        this.name = name;
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public static int getItemStack(APIContext ctx,int itemID){
        int inv = 0,bank = 0;
        if(ctx.inventory().contains(itemID)){
            inv = ctx.bank().getItem(itemID).getStackSize();
        }
        if(ctx.bank().contains(itemID)){
            bank = ctx.bank().getItem(itemID).getStackSize();
        }
        return inv + bank;
    }


}
