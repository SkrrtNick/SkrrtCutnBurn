package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Location;
import com.skrrtnick.cutnburn.data.Tree;
import com.skrrtnick.cutnburn.leafs.openBank;
import com.skrrtnick.cutnburn.leafs.walkToBankArea;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;

public class isPlayerInBankArea extends BranchTask
{
    private String name;

    public isPlayerInBankArea(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx)
    {
        return new isBankOpen(ctx, name + " -> We are in the bank area");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx)
    {
        return new walkToBankArea(ctx, name + " -> We aren't in the bank area");
    }

    @Override
    public boolean validate()
    {
        return Location.DRAYNOR_BANK.getArea().contains(ctx.localPlayer().get());
    }
}


