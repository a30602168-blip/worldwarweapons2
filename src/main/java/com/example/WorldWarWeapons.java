package com.example;

import com.example.WeaponDefs.Ammo;
import com.example.WeaponDefs.Gun;
import com.example.WeaponDefs.Melee;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class WorldWarWeapons implements ModInitializer {
	public static final String MOD_ID = "world-war-weapons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		initItems();
		LOGGER.info("World War Weapons geladen: {} Items", ALL.size());
	}

	public static final Map<String, Item> ALL = new LinkedHashMap<>();

	/** Registriert ein Item; sein Aussehen kommt aus items/<name>.json. */
	private static void register(String name, int stack) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id(name));
		Item.Properties props = new Item.Properties().stacksTo(stack);
		Item item = new Item(props.setId(key));
		Registry.register(BuiltInRegistries.ITEM, key, item);
		ALL.put(name, item);
	}

	private static void initItems() {
		for (Ammo a : WeaponDefs.AMMO) register(a.id(), a.stackSize());
		for (Gun g : WeaponDefs.GUNS) register(g.id(), 1);
		for (Melee m : WeaponDefs.MELEE) register(m.id(), 1);
		for (String s : WeaponDefs.ATTACHMENTS) register(s, 16);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(e -> ALL.values().forEach(e::accept));
	}
}
