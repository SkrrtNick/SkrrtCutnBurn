package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;
import com.skrrtnick.cutnburn.leafs.withdrawAxe;

public class doesBankHaveBestAxe extends BranchTask {
    private String name;

    public doesBankHaveBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new withdrawAxe(ctx, name + " -> Withdrawing axe");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new canAffordBestAxe(ctx, name + " -> Do I have the next best axe?");
    }

    @Override
    public boolean validate() {
        return ctx.bank().contains(Axe.getBestAxe(Stats.getWcLvl(ctx)).getAxeID());
    }
}


