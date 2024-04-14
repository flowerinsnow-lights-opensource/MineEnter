package online.flowerinsnow.mineenter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import online.flowerinsnow.mineenter.mixin.AccessorMinecraftClient;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class MineEnter implements ClientModInitializer {
	public static final KeyBinding SECONDARY_OPEN_CHAT = new KeyBinding("mine-enter.key.secondary-open-chat", GLFW.GLFW_KEY_KP_ENTER, "mine-enter.key.category");

	@Override
	public void onInitializeClient() {
		KeyBindingHelper.registerKeyBinding(SECONDARY_OPEN_CHAT);
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			AccessorMinecraftClient mc = (AccessorMinecraftClient) client;
			if (client.getOverlay() == null && client.currentScreen == null) {
				while (SECONDARY_OPEN_CHAT.wasPressed()) {
					mc.openChatScreen("");
                }
			}
		});
	}
}