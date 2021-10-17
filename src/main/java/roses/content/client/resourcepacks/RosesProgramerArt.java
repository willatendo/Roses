package roses.content.client.resourcepacks;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.IPackNameDecorator;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.util.ResourceLocation;
import roses.content.ModUtils;

public class RosesProgramerArt 
{
	public static void init()
	{
		registerResourcePack(ModUtils.rL("programerart"), "assets/" + ModUtils.ID + "/programerart/", "Roses's Programer Art");
	}

	private static void registerResourcePack(ResourceLocation packId, String subFolder, String packName) 
	{
		Minecraft mc = Minecraft.getInstance();
		mc.getResourcePackRepository().addPackFinder((consumer, factory) -> consumer.accept(ResourcePackInfo.create(packId.toString(), false, () -> new ResourcePack(subFolder, packName), factory, ResourcePackInfo.Priority.TOP, IPackNameDecorator.BUILT_IN)));
	}
}
