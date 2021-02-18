package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.equipAxe;
import com.skrrtnick.cutnburn.leafs.equipNextBestAxe;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;

public class canPlayerEquipNextBestAxe extends BranchTask {
    private String name;

    public canPlayerEquipNextBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        return new equipNextBestAxe(ctx, name + " -> Equipping next best axe");
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        return new isPlayerInTreeArea(ctx, name + " -> Walking to tree area");
    }

    @Override
    public boolean validate() {
//        System.out.println("We need a " + Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeName());
        return Stats.getAtkLvl(ctx) >= Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAtkLevelRequired() && !ctx.equipment().contains(Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeID());
    }
}


