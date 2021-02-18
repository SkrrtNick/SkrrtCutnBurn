package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;
import com.skrrtnick.cutnburn.SkrrtCutnBurn;
import com.skrrtnick.cutnburn.data.State;

public class openBank extends LeafTask
{
    private String name;

    public openBank(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute()
    {
        ctx.bank().open();
        SkrrtCutnBurn.state= State.BANKING;
        System.out.println("Execute " + name);
    }
}