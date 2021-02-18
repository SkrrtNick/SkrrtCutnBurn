package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.withdrawAxe;
import com.skrrtnick.cutnburn.leafs.withdrawNextBestAxe;

public class doesBankHaveNextBestAxe extends BranchTask {
    private String name;

    public doesBankHaveNextBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new withdrawNextBestAxe(ctx, name + " -> Withdrawing axe");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new canAffordNextBestAxe(ctx, name + " -> Do I have the next best axe?");
    }

    @Override
    public boolean validate() {
        return ctx.bank().contains(Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeID());
    }
}


