package com.example;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.function.Supplier;

public class ExampleMod implements ModInitializer {
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");

		// Register command to give speed boost to player
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			dispatcher.register(
					LiteralArgumentBuilder.<ServerCommandSource>literal("speedboost")
							.executes(context -> {
								// Get the player from the command source
								ServerCommandSource source = context.getSource();
								if (source.getEntity() instanceof PlayerEntity) {
									PlayerEntity player = (PlayerEntity) source.getEntity();
									applySpeedEffectToPlayer(player);
									source.sendFeedback((Supplier<Text>) Text.of("Speed boost applied!"), false);
									return Command.SINGLE_SUCCESS;
								}
								return 0;
							})
			);
		});
	}

	public void applySpeedEffectToPlayer(PlayerEntity player) {
		if (player != null) {
			// Apply Speed effect to the player
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 1)); // 600 ticks (30 seconds), level 1
		}
	}
}
