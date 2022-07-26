package roses.server.entity;

import com.tterrag.registrate.util.entry.EntityEntry;

import net.minecraft.world.entity.MobCategory;
import roses.RosesMod;
import roses.server.util.RosesRegistrate;

public class RosesEntities {
	public static final RosesRegistrate REGISTRATE = RosesMod.getRegistrate();

	// 3.2.0 Content
	public static final EntityEntry<SittingEntity> CHAIR_ENTITY = REGISTRATE.entity("chair", SittingEntity.factory, MobCategory.MISC).renderer(() -> EmptyRenderer::new).properties(builder -> builder.sized(0.0001F, 0.0001F).updateInterval(20).clientTrackingRange(256)).register();

	public static void init() {
	}
}
