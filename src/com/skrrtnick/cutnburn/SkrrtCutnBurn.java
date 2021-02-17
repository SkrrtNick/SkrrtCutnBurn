package com.skrrtnick.cutnburn;

import com.epicbot.api.os.model.game.GameState;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.GameType;
import com.epicbot.api.shared.script.LoopScript;
import com.epicbot.api.shared.script.ScriptManifest;
import com.epicbot.api.shared.script.TreeScript;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.epicbot.api.shared.util.Random;
import com.skrrtnick.cutnburn.leafs.login;
import com.skrrtnick.cutnburn.leafs.walkToArea;

//public class SkrrtCutnBurn extends LoopScript {
//    @Override
//    protected int loop() {
//        return 800;
//    }
//
//    @Override
//    public boolean onStart(String... strings) {
//        return false;
//    }
//}
@ScriptManifest(name = "Skrrt Cut n Burn", gameType = GameType.OS)
public class SkrrtCutnBurn extends TreeScript
{
    @Override
    public boolean onStart(String... args)
    {
        Branch rootBranch = new Branch(getAPIContext(), "Root")
        {
            @Override
            protected TreeTask createSuccessTask(APIContext ctx)
            {
                return new Branch(getAPIContext(), "A");
            }

            @Override
            protected TreeTask createFailureTask(APIContext ctx)
            {
                return new Branch(getAPIContext(), "B");
            }
        };
        setRootTask(rootBranch);

        return true;
    }

    private class Branch extends BranchTask
    {
        private String name;

        public Branch(APIContext ctx, String name)
        {
            super(ctx);
            this.name = name;
        }

        @Override
        protected TreeTask createSuccessTask(APIContext ctx)
        {
            return new walkToArea(ctx, name + " -> Success");
        }

        @Override
        protected TreeTask createFailureTask(APIContext ctx)
        {
            return new login(ctx, name + " -> Failure");
        }

        @Override
        public boolean validate()
        {
            return ctx.game().getGameState().equals(GameState.LOGGED_IN);
        }
    }

    private class Leaf extends LeafTask
    {
        private String name;

        public Leaf(APIContext ctx, String name)
        {
            super(ctx);
            this.name = name;
        }

        @Override
        public void execute()
        {
            System.out.println("Execute " + name);
        }
    }
}