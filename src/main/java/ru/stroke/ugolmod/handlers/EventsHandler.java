package ru.stroke.ugolmod.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import ru.stroke.ugolmod.UgolMod;

public class EventsHandler {
	public Block lastPlacedSign;
	public BlockPos lastPlacedSignPos;
	
	public boolean hasUgolMessaged = false;
	
	@SubscribeEvent
	public void onBlockPlaced(EntityPlaceEvent event) {
		Block block = event.getPlacedBlock().getBlock();
		if(block == Blocks.STANDING_SIGN || block == Blocks.WALL_SIGN) {
			lastPlacedSign = event.getPlacedBlock().getBlock();
			lastPlacedSignPos = event.getPos();
			hasUgolMessaged = false;
		}
	}
	
	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event) {
		if(UgolMod.MC.world == null) return;
		UgolMod.removeUgol();
	}
	
	@SubscribeEvent
	public void onWorldRender(RenderWorldLastEvent event) {
		if(UgolMod.needToDoSomething(false))
			UgolMod.spawnPenis(UgolMod.MC.player.getPosition());
		if(UgolMod.needToDoSomething(false))
			UgolMod.spawnCross(UgolMod.MC.player.getPosition());
		if(UgolMod.needToDoSomething(false))
			UgolMod.burnLeaves(UgolMod.MC.player.getPosition(), true);
		if(UgolMod.needToDoSomething(false))
			UgolMod.burnLeaves(UgolMod.MC.player.getPosition(), false);
		if(UgolMod.needToDoSomething(false))
			UgolMod.displayChatMessage("§eAllah joined the game");
		if(UgolMod.needToDoSomething(true))
			UgolMod.spawnUgol(UgolMod.MC.player.getPosition()); // ...SCARY!
		if(System.currentTimeMillis() - UgolMod.lastSpawnedUgolTime > 20000)
			UgolMod.removeUgol();
		if(UgolMod.needToCrashMinecraft())
			UgolMod.crashMinecraft();
		
		if(lastPlacedSignPos == null || lastPlacedSign == null) return;
		
		TileEntitySign sign = (TileEntitySign) UgolMod.MC.world.getTileEntity(lastPlacedSignPos);
		if(sign != null) {
			if(sign.signText != null && !hasUgolMessaged) {
				if(UgolMod.signContains(sign, "who are u") || UgolMod.signContains(sign, "who are you")) {
					UgolMod.displayChatMessage("I'M GAY...");
					hasUgolMessaged = true;
				}
				if(UgolMod.signContains(sign, "where are u") || UgolMod.signContains(sign, "where are you")) {
					UgolMod.displayChatMessage("blya mamy ebal(((");
					hasUgolMessaged = true;
				}
			}
		}
	}
}
