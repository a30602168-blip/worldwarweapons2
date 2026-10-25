package com.example;

import java.util.List;

/** Alle Waffenwerte an einer Stelle. rpm = Schuss/min, range in Blöcken, moveSpeed = Faktor. */
public final class WeaponDefs {
	private WeaponDefs() {}

	public record Gun(String id, String category, String ammoId, float damage, int rpm, float recoil,
			int magSize, int reloadTicks, int range, float spread, float moveSpeed) {
		public int cooldownTicks() { return Math.max(1, Math.round(1200f / rpm)); }
	}
	public record Melee(String id, float damage, float attackSpeed, float reach) {}
	public record Ammo(String id, int stackSize) {}

	public static final List<Gun> GUNS = List.of(
		new Gun("ak47", "assault_rifle", "ammo_r762x39", 7.0f, 600, 1.6f, 30, 50, 70, 1.4f, 0.9f),
		new Gun("m4a1", "assault_rifle", "ammo_r556", 5.5f, 750, 1.0f, 30, 44, 75, 1.0f, 0.93f),
		new Gun("scar_h", "assault_rifle", "ammo_r762x51", 8.0f, 550, 1.9f, 20, 52, 80, 1.2f, 0.88f),
		new Gun("aug", "assault_rifle", "ammo_r556", 5.5f, 700, 0.9f, 30, 48, 80, 0.8f, 0.92f),
		new Gun("famas", "assault_rifle", "ammo_r556", 5.0f, 900, 1.1f, 25, 46, 65, 1.3f, 0.93f),
		new Gun("mp5", "smg", "ammo_mm9", 3.5f, 800, 0.7f, 30, 36, 40, 1.1f, 1.0f),
		new Gun("ump45", "smg", "ammo_acp45", 4.5f, 600, 0.9f, 25, 40, 45, 1.2f, 0.98f),
		new Gun("p90", "smg", "ammo_mm9", 3.0f, 900, 0.6f, 50, 52, 40, 1.3f, 1.0f),
		new Gun("vector", "smg", "ammo_acp45", 3.8f, 1100, 0.8f, 25, 38, 35, 1.6f, 1.0f),
		new Gun("glock17", "pistol", "ammo_mm9", 3.5f, 400, 0.8f, 17, 30, 35, 1.2f, 1.0f),
		new Gun("desert_eagle", "pistol", "ammo_acp45", 9.0f, 180, 3.0f, 7, 40, 50, 1.0f, 0.98f),
		new Gun("usp", "pistol", "ammo_acp45", 4.0f, 380, 0.9f, 12, 32, 38, 0.9f, 1.0f),
		new Gun("revolver", "pistol", "ammo_acp45", 8.0f, 120, 2.8f, 6, 70, 50, 1.0f, 0.98f),
		new Gun("awp", "sniper", "ammo_sniper", 20.0f, 40, 4.0f, 5, 70, 200, 0.05f, 0.8f),
		new Gun("kar98k", "sniper", "ammo_r762x51", 14.0f, 45, 3.2f, 5, 80, 160, 0.1f, 0.85f),
		new Gun("barrett_m82", "sniper", "ammo_sniper", 24.0f, 60, 4.5f, 10, 90, 220, 0.1f, 0.75f),
		new Gun("pumpgun", "shotgun", "ammo_shells", 2.5f, 70, 3.0f, 8, 16, 25, 5.0f, 0.95f),
		new Gun("double_barrel", "shotgun", "ammo_shells", 3.0f, 150, 3.5f, 2, 40, 22, 6.0f, 0.95f),
		new Gun("lmg", "lmg", "ammo_r762x51", 6.0f, 650, 1.5f, 100, 120, 75, 1.8f, 0.8f),
		new Gun("grenade_launcher", "launcher", "ammo_grenade", 14.0f, 40, 3.0f, 1, 60, 90, 0.5f, 0.85f));
	public static final List<Melee> MELEE = List.of(
		new Melee("combat_knife", 5f, 1.8f, 3.0f),
		new Melee("butterfly_knife", 4f, 2.2f, 2.8f),
		new Melee("karambit", 4f, 2.4f, 2.8f),
		new Melee("katana", 8f, 1.4f, 3.5f),
		new Melee("machete", 7f, 1.2f, 3.2f),
		new Melee("baseball_bat", 7f, 1.0f, 3.4f),
		new Melee("tactical_baton", 5f, 1.6f, 3.0f),
		new Melee("tactical_axe", 9f, 0.9f, 3.2f));
	public static final List<Ammo> AMMO = List.of(
		new Ammo("ammo_mm9", 64),
		new Ammo("ammo_acp45", 64),
		new Ammo("ammo_r556", 64),
		new Ammo("ammo_r762x39", 64),
		new Ammo("ammo_r762x51", 64),
		new Ammo("ammo_shells", 32),
		new Ammo("ammo_sniper", 32),
		new Ammo("ammo_grenade", 16));
	public static final List<String> ATTACHMENTS = List.of(
		"attachment_red_dot_sight",
		"attachment_holo_sight",
		"attachment_scope",
		"attachment_suppressor",
		"attachment_foregrip",
		"attachment_laser",
		"attachment_flashlight",
		"attachment_extended_mag");
}
