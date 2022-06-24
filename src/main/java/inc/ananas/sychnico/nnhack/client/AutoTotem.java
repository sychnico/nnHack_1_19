package inc.ananas.sychnico.nnhack.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;

public class AutoTotem extends Module{

    MinecraftClient mc = MinecraftClient.getInstance();

    AutoTotem() {
        super("AutoTotem");
    }

    @Override
    public void onTick() {

        if (mc.player != null) {
            if (!mc.player.getOffHandStack().getItem().equals(Items.TOTEM_OF_UNDYING)) {
                if (mc.currentScreen instanceof InventoryScreen || mc.currentScreen == null) {
                    for (int slot = 9; slot < 45; slot++) {
                        if (mc.player.getInventory().getStack(slot >= 36 ? slot - 36 : slot).getItem() == Items.TOTEM_OF_UNDYING) {
                            mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, slot, 0, SlotActionType.PICKUP, mc.player);
                            mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, 45, 0, SlotActionType.PICKUP, mc.player);
                            if (!mc.player.getOffHandStack().isEmpty()) {
                                mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, slot, 0, SlotActionType.PICKUP, mc.player);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
