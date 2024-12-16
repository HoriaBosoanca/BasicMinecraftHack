package com.example;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class ExampleModClient implements ClientModInitializer {
	private static final MinecraftClient client = MinecraftClient.getInstance();
	private KeyBinding keyBinding;

	@Override
	public void onInitializeClient() {
		// Register key binding (F key)
		keyBinding = new KeyBinding("key.examplemod.sendmessage", GLFW.GLFW_KEY_F4, "key.categories.misc");
		KeyBindingHelper.registerKeyBinding(keyBinding);

		// Register client tick callback to check key press every tick
		ClientTickEvents.END_CLIENT_TICK.register(client -> tick());
	}

	private void tick() {
		// Check if the key is pressed and log it to console for debugging
		if (keyBinding.isPressed()) {
			sendMessageToChat();
		}
	}

	private void sendMessageToChat() {
		// Make sure the player is not null
		if (client.player != null) {
			client.player.sendMessage(Text.of("Hello from the mod!"), false);
		}
	}
}
