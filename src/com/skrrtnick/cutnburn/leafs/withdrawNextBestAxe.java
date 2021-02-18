package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.State;
import com.skrrtnick.cutnburn.data.Stats;

public class withdrawNextBestAxe extends LeafTask {
    private String name;

    public withdrawNextBestAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute() {
        SkrrtCutnBurn.state = State.BANKING;
        ctx.bank().withdraw(1, Axe.getNextBestAxe(Stats.getWcLvl(ctx)).getAxeID());
        System.out.println("Execute " + name);
    }
}