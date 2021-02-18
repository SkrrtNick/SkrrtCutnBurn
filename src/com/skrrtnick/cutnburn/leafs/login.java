package com.skrrtnick.cutnburn.leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

public class login extends LeafTask
{
    private String name;

    public login(APIContext ctx, String name)
    {
        super(ctx);
        this.name = name;
    }

    @Override
    public void execute()
    {
        Time.sleep(6000);
        System.out.println("Execute " + name);
    }
}