package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Item;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.endScript;

public class canAffordNextBestAxe extends BranchTask {
    private String name;

    public canAffordNextBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new isPlayerInGE(ctx, name + " -> Traversing to GE");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new endScript(ctx, name + " -> Exiting Script");
    }

    @Override
    public boolean validate() {
        return (Stats.getAshPrice(ctx) * Item.getItemStack(ctx,Item.ASHES.getItemID()) + Item.getItemStack(ctx, Item.COINS.getItemID()) > Stats.getNextBestAxePrice(ctx));
    }
}


