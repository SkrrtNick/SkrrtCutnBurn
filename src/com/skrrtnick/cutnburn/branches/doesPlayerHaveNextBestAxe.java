package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Stats;

public class doesPlayerHaveNextBestAxe extends BranchTask
{
    private String name;

    public doesPlayerHaveNextBestAxe(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx)
    {
        return new canPlayerEquipNextBestAxe(ctx, name + " -> We have the next best axe");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx)
    {
        return new isPlayerInBankArea(ctx, name + " -> Are we in the bank?");
    }

    @Override
    public boolean validate()
    {
        System.out.println("We need a " + Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeName());
        return ctx.inventory().contains(Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeID()) | ctx.equipment().contains(Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeID());
    }
}


