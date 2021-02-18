package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Item;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.withdrawAxe;

public class canAffordBestAxe extends BranchTask {
    private String name;

    public canAffordBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new isPlayerInGE(ctx, name + " -> Traversing to GE");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new doesPlayerHaveNextBestAxe(ctx, name + " -> We're going to have to use the next best axe, price of " + Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeName() + "is "+ Stats.getAxePrice(ctx) + "gp and we have " + (Stats.getAshPrice(ctx) * Item.getItemStack(ctx,Item.ASHES.getItemID()) + Item.getItemStack(ctx, Item.COINS.getItemID()) + "gp"));
    }

    @Override
    public boolean validate() {
        return (Stats.getAshPrice(ctx) * Item.getItemStack(ctx,Item.ASHES.getItemID()) + Item.getItemStack(ctx, Item.COINS.getItemID()) > Stats.getAxePrice(ctx));
    }
}


