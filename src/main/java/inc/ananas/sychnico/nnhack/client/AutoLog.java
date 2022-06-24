package inc.ananas.sychnico.nnhack.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class AutoLog extends Module{

    MinecraftClient mc = MinecraftClient.getInstance();

    AutoLog() {
        super("AutoLog");
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            if (mc.player.getHealth() <= 10) {
                if (mc.player.getInventory().count(Items.TOTEM_OF_UNDYING) == 0) {
                    mc.getNetworkHandler().getConnection().disconnect(Text.of("Kicked by AutoLog"));
                }
                this.disable();
            }
        }
    }

}
