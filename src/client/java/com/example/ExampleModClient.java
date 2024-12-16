package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.START_WORLD_TICK.register(client -> {
			if (MinecraftClient.getInstance().player != null) {
				MinecraftClient.getInstance().player.setPos(200.0, 200.0, 200.0);
				System.out.println("HAHAHAHHAHAHAHAHHAHAHAHAH WHY SO SERIOUS????");
			}
		});
	}
}
