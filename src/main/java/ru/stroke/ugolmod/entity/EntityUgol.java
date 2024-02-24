package ru.stroke.ugolmod.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;
import ru.stroke.ugolmod.UgolMod;

public class EntityUgol extends EntityCow {
	public EntityUgol(World worldIn) {
		super(worldIn);
		this.setEntityInvulnerable(true);
	}
}