package inc.ananas.sychnico.nnhack.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.util.Hand;

public class KillAura extends Module{

    MinecraftClient mc = MinecraftClient.getInstance();

    KillAura() {
        super("KillAura");
    }

    @Override
    public void onTick() {

        if (mc.player != null) {
            if (target() != null) {
                if (mc.player.getAttackCooldownProgress(mc.getTickDelta()) == 1.0f) {
                    attack(target());
                }
            }
        }

    }

    private Entity target() {

        net.minecraft.entity.Entity last = null;
        double min = 25.0;

        for (net.minecraft.entity.Entity e : mc.world.getEntities()) {
            if (e.isAlive() && e.isAttackable() && e != mc.player) {
                if (e instanceof Monster || e.isPlayer()) {

                    if (mc.player.squaredDistanceTo(e) < min) {
                        min = mc.player.squaredDistanceTo(e);
                        last = e;
                    }

                }
            }
        }

        return last;

    }

    private void attack(Entity entity) {
        mc.interactionManager.attackEntity(mc.player, entity);
        System.out.println("attacking " + entity.getType());
        mc.player.swingHand(Hand.MAIN_HAND);
    }

}
