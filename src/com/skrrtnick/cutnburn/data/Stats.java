package com.skrrtnick.cutnburn.data;

import com.epicbot.api.shared.APIContext;

public class Stats {
    public int wcLvl, fmLvl, logPrice, oakPrice;


    public static int getWcLvl(APIContext ctx){
        return ctx.skills().woodcutting().getRealLevel();
    }
    public static int getAtkLvl(APIContext ctx){
        return ctx.skills().attack().getRealLevel();
    }

    public static int getFmLvl(APIContext ctx){
        return ctx.skills().firemaking().getRealLevel();
    }
    public static int getAshPrice(APIContext ctx){
        return ctx.grandExchange().getItemDetails(Item.ASHES.getItemID()).getCurrentPrice();
    }
    public static int getAxePrice(APIContext ctx){
        return ctx.grandExchange().getItemDetails(Axe.getBestAxe(getWcLvl(ctx)).getAxeID()).getCurrentPrice();
    }

}
