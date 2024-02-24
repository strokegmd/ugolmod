package ru.stroke.ugolmod;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.stroke.ugolmod.entity.EntityUgol;
import ru.stroke.ugolmod.handlers.EventsHandler;
import ru.stroke.ugolmod.handlers.RenderHandler;
import ru.stroke.ugolmod.init.EntityInit;

@Mod(modid = UgolMod.MODID, name = UgolMod.NAME, version = UgolMod.VERSION)
public class UgolMod
{
    public static final String MODID = "ugolmod";
    public static final String NAME = "UGOLMod";
    public static final String VERSION = "1.4.8.8";
    
    public static final Minecraft MC = Minecraft.getMinecraft();
    
    public static long lastSpawnedUgolTime;
    
    @Instance
    public static UgolMod instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }
    
    public static void displayChatMessage(String message) {
    	UgolMod.MC.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(message));
    }
    
    public static void spawnPenis(BlockPos pos) {
    	Random rng = new Random();
    	BlockPos near = pos.subtract(new Vec3i(rng.nextInt(30), 0, rng.nextInt(30)));
    	
    	UgolMod.MC.world.setBlockState(near, Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.east(), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.west(), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(1), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(2), Blocks.BEDROCK.getDefaultState());
    }
    
    public static void crashMinecraft() {
    	JOptionPane.showMessageDialog(new JFrame(), "your minecraft got detonated!!11", "error HUI SOSI!", JOptionPane.ERROR_MESSAGE);
    	UgolMod.MC.shutdown();
    }
    
    public static void spawnCross(BlockPos pos) {
    	Random rng = new Random();
    	BlockPos near = pos.subtract(new Vec3i(rng.nextInt(30), 0, rng.nextInt(30))).down();
    	
    	UgolMod.MC.world.setBlockState(near.up(1), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(2), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(3), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(4), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(3).east(), Blocks.BEDROCK.getDefaultState());
    	UgolMod.MC.world.setBlockState(near.up(3).west(), Blocks.BEDROCK.getDefaultState());
    }
    
    public static void spawnUgol(BlockPos pos) {
    	Random rng = new Random();
    	BlockPos near = pos.subtract(new Vec3i(rng.nextInt(30), 0, rng.nextInt(30)));
    	
    	if(UgolMod.MC.world.getBlockState(pos).getBlock() != Blocks.AIR) return;
    	
    	EntityUgol ugol = new EntityUgol(UgolMod.MC.world);
    	ugol.setPosition(near.getX(), near.getY(), near.getZ());
    	
    	for(Entity entity : UgolMod.MC.world.loadedEntityList) {
    		if(entity instanceof EntityUgol) return;
    	}
    	
    	UgolMod.MC.world.addEntityToWorld(-1488, ugol);
    	lastSpawnedUgolTime = System.currentTimeMillis();
    }
    
    public static void removeUgol() {
    	for(Entity entity : UgolMod.MC.world.loadedEntityList) {
    		if(entity instanceof EntityUgol) {
    			entity.setDead();
    		}
    	}
    }
    
    public static boolean signContains(TileEntitySign sign, String text) {
    	return sign.signText[0].getFormattedText().contains(text);
    }
    
    public static void burnLeaves(BlockPos pos, boolean burn) {
    	int radius = 30;
    	for(int x = pos.getX()-radius; x < pos.getX()+radius; x++) {
    		for(int y = pos.getY()-radius; y < pos.getY()+radius; y++) {
    			for(int z = pos.getZ()-radius; z < pos.getZ()+radius; z++) {
    				BlockPos blockPos = new BlockPos(x, y, z);
    				if(UgolMod.MC.world.getBlockState(blockPos).getBlock() == Blocks.LEAVES) {
    					if(burn) {
    						if(UgolMod.chance(20)) {
    							UgolMod.MC.world.setBlockState(blockPos.up(), Blocks.FIRE.getDefaultState());
    						}
    					} else {
    						UgolMod.MC.world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
    					}
    				}
    			}
    		}
    	}
    }
    
    public static boolean needToCrashMinecraft() {
    	for(Entity entity : UgolMod.MC.world.loadedEntityList) {
    		if(entity instanceof EntityUgol) {
    			if(entity.getDistance(UgolMod.MC.player) < 5) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    public static boolean needToDoSomething(boolean spawn) {
		Random rng = new Random();
		
		int number = rng.nextInt(1000000);
		if(spawn)
			return number < 50;
		
		return number < 100;
    }
    
    public static boolean chance(int percent) {
    	Random rng = new Random();
    	
    	int number = rng.nextInt(100);
    	return number < percent;
    }
}
