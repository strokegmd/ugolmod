package ru.stroke.ugolmod.entity.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import ru.stroke.ugolmod.UgolMod;
import ru.stroke.ugolmod.entity.EntityUgol;
import ru.stroke.ugolmod.entity.model.ModelUgol;

public class RenderUgol extends RenderLiving<EntityUgol> {
	public static final ResourceLocation TEXTURES = new ResourceLocation(UgolMod.MODID, "ugol.png");
	
	public RenderUgol(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelUgol(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityUgol entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityUgol entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
