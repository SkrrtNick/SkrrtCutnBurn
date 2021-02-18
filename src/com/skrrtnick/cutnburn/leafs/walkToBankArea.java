package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.Location;
import com.skrrtnick.cutnburn.data.State;
import com.skrrtnick.cutnburn.data.Tree;

public class walkToBankArea extends LeafTask
{
    private String name;

    public walkToBankArea(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute()
    {
        SkrrtCutnBurn.state= State.WALKING;
        ctx.webWalking().walkTo(Location.DRAYNOR_BANK.getArea().getRandomTile());
        System.out.println("Execute " + name);
    }
}
