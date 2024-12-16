package com.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MyClient {

    private static final MinecraftClient client = MinecraftClient.getInstance();

    public void sendMessageToChat() {
        assert client.player != null;
        client.player.sendMessage(Text.of("Hello from the mod!"), false);
    }
}
