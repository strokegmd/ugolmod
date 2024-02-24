package ru.stroke.ugolmod.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import ru.stroke.ugolmod.UgolMod;
import ru.stroke.ugolmod.entity.EntityUgol;
import ru.stroke.ugolmod.entity.renderer.RenderUgol;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityUgol.class, new IRenderFactory<EntityUgol>()
		{
			@Override
			public Render<? super EntityUgol> createRenderFor(RenderManager manager) {
				return new RenderUgol(manager);
			}
		});
	}
}
