package com.skrrtnick.cutnburn.branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.data.Tree;
import com.skrrtnick.cutnburn.leafs.chopTree;
import com.skrrtnick.cutnburn.leafs.walkToTreeArea;

    public class isPlayerInTreeArea extends BranchTask
    {
        private String name;

        public isPlayerInTreeArea(APIContext ctx, String name)
        {
            super(ctx);
            this.name = name;
        }

        @Override
        protected TreeTask createSuccessTask(APIContext ctx)
        {
            return new chopTree(ctx, name + " -> Success");
        }

        @Override
        protected TreeTask createFailureTask(APIContext ctx)
        {
            return new walkToTreeArea(ctx, name + " -> Failure");
        }

        @Override
        public boolean validate()
        {
            return Tree.getBestTree(Stats.getFmLvl(ctx),Stats.getWcLvl(ctx)).getArea().contains(ctx.localPlayer().getLocation());
        }
    }


