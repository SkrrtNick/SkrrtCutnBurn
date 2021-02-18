package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.Location;
import com.skrrtnick.cutnburn.data.State;

public class walkToGrandExchange extends LeafTask
{
    private String name;

    public walkToGrandExchange(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute()
    {
        SkrrtCutnBurn.state= State.WALKING;
        ctx.webWalking().walkTo(Location.GRAND_EXCHANGE.getArea().getRandomTile());
        System.out.println("Execute " + name);
    }
}
