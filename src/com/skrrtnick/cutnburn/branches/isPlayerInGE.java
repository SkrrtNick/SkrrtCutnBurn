package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Item;
import com.skrrtnick.cutnburn.data.Location;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.walkToGrandExchange;

public class isPlayerInGE extends BranchTask {
    private String name;

    public isPlayerInGE(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new isPlayerInGE(ctx, name + " -> Traversing to GE");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new walkToGrandExchange(ctx, name + " -> We're walking to the Grand Exchange");
    }

    @Override
    public boolean validate() {
        return Location.GRAND_EXCHANGE.getArea().contains(ctx.localPlayer().get());
    }
}


