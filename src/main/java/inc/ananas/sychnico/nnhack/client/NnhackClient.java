package inc.ananas.sychnico.nnhack.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

@Environment(EnvType.CLIENT)
public class NnhackClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        AutoTotem totem = new AutoTotem();
        KillAura killAura = new KillAura();
        AutoLog autoLog = new AutoLog();
        FullBright bright = new FullBright();

    }

}
