package roses.content.server;

import java.util.List;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import roses.content.ModUtils;
import roses.content.config.RosesConfig;

@EventBusSubscriber(modid = ModUtils.ID, bus = Bus.MOD)
public class BiomeConfig 
{
	public static List<? extends String> roseBiomes;
	
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) 
	{
		roseBiomes = RosesConfig.COMMON_CONFIG.roseBiomes.get();
    }
}
