package roses.library.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.level.Level;
import roses.content.ModRegistry;

public class FreeGhastEntity extends Ghast {
	public FreeGhastEntity(EntityType<? extends Ghast> ghast, Level leve) {
		super(ghast, leve);
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return this.level.dimension() == Level.OVERWORLD ? ModRegistry.AFFECTIONATE_GHAST : SoundEvents.GHAST_DEATH;
	}
}
