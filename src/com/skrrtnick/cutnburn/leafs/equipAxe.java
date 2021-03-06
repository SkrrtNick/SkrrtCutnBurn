package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.State;

public class equipAxe extends LeafTask {
    private String name;

    public equipAxe(APIContext ctx, String name) {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute() {
        ctx.inventory().interactItem("Wield", Axe.getBestAxe(ctx.skills().woodcutting().getRealLevel()).getAxeName());
        SkrrtCutnBurn.state=State.EQUIPPING;
        System.out.println("Execute " + name);
    }
}