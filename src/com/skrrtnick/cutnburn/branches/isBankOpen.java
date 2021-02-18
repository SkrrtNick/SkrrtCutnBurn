package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.leafs.openBank;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;

public class isBankOpen extends BranchTask {
    private String name;

    public isBankOpen(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new doesBankHaveBestAxe(ctx, name + " -> We have the best axe in our bank");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new openBank(ctx, name + " -> We don't have the best axe in our bank");
    }

    @Override
    public boolean validate() {
        return ctx.bank().isOpen();
    }
}


