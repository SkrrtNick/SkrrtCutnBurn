package com.skrrtnick.cutnburn;

import com.epicbot.api.os.model.game.GameState;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.GameType;
import com.epicbot.api.shared.script.ScriptManifest;
import com.epicbot.api.shared.script.TreeScript;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.epicbot.api.shared.util.paint.frame.PaintFrame;
import com.epicbot.api.shared.util.time.Time;
import com.skrrtnick.cutnburn.branches.doesPlayerHaveBestAxe;
import com.skrrtnick.cutnburn.data.Axe;
import com.skrrtnick.cutnburn.data.State;
import com.skrrtnick.cutnburn.data.Stats;
import com.skrrtnick.cutnburn.leafs.login;

import java.awt.*;

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
    private final long startTime = System.currentTimeMillis();
    public static State state = State.STARTING;
    @Override
    public boolean onStart(String... args)
    {
        setIterationDelay(1000);

//        System.out.println("Ashes: " + Stats.getAshPrice(getAPIContext()) + "gp");
//        System.out.println(Axe.getBestAxe(Stats.getWcLvl(getAPIContext())).getAxeName() + ": " + getAPIContext().grandExchange().getItemDetails(Axe.getBestAxe(Stats.getWcLvl(getAPIContext())).getAxeID()).getCurrentPrice() + "gp");
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
    @Override
    protected void onPaint(Graphics2D g, APIContext a) {
        PaintFrame pf = new PaintFrame("Cut n Burn");
        pf.addLine("Runtime", Time.getFormattedRuntime(startTime));
        pf.addLine("State:", state.getName());
        pf.draw(g, 4, 204, a);
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
            return new doesPlayerHaveBestAxe(ctx, name + " -> Success");
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