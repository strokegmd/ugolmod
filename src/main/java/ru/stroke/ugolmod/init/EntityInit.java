package ru.stroke.ugolmod.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import ru.stroke.ugolmod.UgolMod;
import ru.stroke.ugolmod.entity.EntityUgol;

public class EntityInit {
	public static void registerEntities() {
		EntityInit.registerEntity("ugol", EntityUgol.class, 120, 50, 000000, 000000);
	}
	
	public static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(UgolMod.MODID, name), entity, name, id, UgolMod.instance, range, 1, true, color1, color2);
	}
}
