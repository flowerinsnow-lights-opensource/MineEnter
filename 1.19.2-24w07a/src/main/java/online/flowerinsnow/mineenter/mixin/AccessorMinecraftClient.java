package online.flowerinsnow.mineenter.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MinecraftClient.class)
@Environment(EnvType.CLIENT)
public interface AccessorMinecraftClient {
    @Invoker("openChatScreen")
    void openChatScreen(String text);
}
