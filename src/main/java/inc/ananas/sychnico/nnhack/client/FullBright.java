package inc.ananas.sychnico.nnhack.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FullBright extends Module{

    MinecraftClient mc = MinecraftClient.getInstance();

    FullBright() {
        super("FullBright");
    }


    public void onTick(){
        mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 500, 0));
    }

    public void onDisable(){
        mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
    }


}
