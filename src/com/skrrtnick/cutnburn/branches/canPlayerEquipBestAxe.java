package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.equipAxe;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;

public class canPlayerEquipBestAxe extends BranchTask {
    private String name;

    public canPlayerEquipBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new equipAxe(ctx, name + " -> Equipping axe");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new walkToTreeArea(ctx, name + " -> Walking to tree area");
    }

    @Override
    public boolean validate() {
        System.out.println("We need a " + Axe.getBestAxe(Stats.getWcLvl(ctx)).getAxeName());
        return Stats.getAtkLvl(ctx) >= Axe.getBestAxe(Stats.getWcLvl(ctx)).getAtkLevelRequired();
    }
}


