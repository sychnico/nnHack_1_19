package inc.ananas.sychnico.nnhack.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class Module {

    private KeyBinding ModuleKey;
    private boolean isEnable = false;

    Module(String name){

        ModuleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                name, // name
                InputUtil.Type.KEYSYM, // type, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_N, // keycode
                "nnHack" // category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (ModuleKey.wasPressed()){
                if (isEnable){
                    isEnable = false;
                    onDisable();
                    client.player.sendMessage(Text.literal(name + " OFF").styled(style -> style.withColor(Formatting.AQUA)), false);
                }
                else {
                    isEnable = true;
                    onEnable();
                    client.player.sendMessage(Text.literal(name + " ON").styled(style -> style.withColor(Formatting.AQUA)), false);
                }
            }

            if (isEnable){onTick();}

        });

    }

    public void onTick(){}

    public void onEnable(){}

    public void onDisable(){}

    public void disable(){
        isEnable = false;
    }

    public void enable(){
        isEnable = true;
    }

}
