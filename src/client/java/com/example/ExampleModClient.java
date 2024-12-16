package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.START_WORLD_TICK.register(client -> {
			if (MinecraftClient.getInstance().player != null) {
				ClientPlayerEntity player = MinecraftClient.getInstance().player;

				player.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

//				player.setHealth(player.getMaxHealth());

				player.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
				player.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
				player.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
				player.equipStack(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
			}
		});
	}
}
