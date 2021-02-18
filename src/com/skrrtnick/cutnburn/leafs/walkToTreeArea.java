package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.State;
import com.skrrtnick.cutnburn.data.Tree;

public class walkToTreeArea extends LeafTask
{
    private String name;

    public walkToTreeArea(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute()
    {
        SkrrtCutnBurn.state= State.WALKING;
        ctx.webWalking().walkTo(Tree.getBestTree(ctx.skills().firemaking().getRealLevel(),ctx.skills().woodcutting().getRealLevel()).getArea().getRandomTile());
        System.out.println("Execute " + name);
    }
}
