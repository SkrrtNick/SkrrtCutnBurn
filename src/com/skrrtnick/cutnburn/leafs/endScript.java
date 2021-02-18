package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.State;

public class endScript extends LeafTask {
    private String name;

    public endScript(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute() {
        ctx.script().stop("We don't have enough gp for the next best axe. Killing script.");
        SkrrtCutnBurn.state = State.EQUIPPING;
        System.out.println("Execute " + name);
    }
}