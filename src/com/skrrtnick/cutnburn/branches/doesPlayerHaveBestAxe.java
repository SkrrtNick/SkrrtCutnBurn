package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;

public class doesPlayerHaveBestAxe extends BranchTask
{
    private String name;

    public doesPlayerHaveBestAxe(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx)
    {
        return new canPlayerEquipBestAxe(ctx, name + " -> We have the best axe");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx)
    {
        return new isPlayerInBankArea(ctx, name + " -> We don't have the best axe");
    }

    @Override
    public boolean validate()
    {
        System.out.println("We need a " + Axe.getBestAxe(Stats.getWcLvl(ctx)).getAxeName());
        return ctx.inventory().contains(Axe.getBestAxe(Stats.getWcLvl(ctx)).getAxeID()) | ctx.equipment().contains(Axe.getBestAxe(Stats.getWcLvl(ctx)).getAxeID());
    }
}


