package willatendo.roses.server.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import willatendo.roses.server.RosesBuiltInRegistries;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CopperHornItem extends Item {
    private final TagKey<CopperHornInstrument> copperHornInstruments;

    public CopperHornItem(TagKey<CopperHornInstrument> copperHornInstruments, Item.Properties properties) {
        super(properties);
        this.copperHornInstruments = copperHornInstruments;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
        Optional<ResourceKey<CopperHornInstrument>> copperHornOptional = this.getInstrument(itemStack).flatMap(Holder::unwrapKey);
        if (copperHornOptional.isPresent()) {
            MutableComponent mutableComponent = Component.translatable(Util.makeDescriptionId("copper_horn", copperHornOptional.get().location()));
            components.add(mutableComponent.withStyle(ChatFormatting.GRAY));
        }
    }

    public static ItemStack create(Item item, Holder<CopperHornInstrument> copperHornInstrument) {
        ItemStack itemStack = new ItemStack(item);
        itemStack.set(RosesDataComponents.COPPER_HORN_INSTRUMENT.get(), copperHornInstrument);
        return itemStack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Optional<? extends Holder<CopperHornInstrument>> copperHornInstrumentHolder = this.getInstrument(itemStack);
        if (copperHornInstrumentHolder.isPresent()) {
            CopperHornInstrument copperHornInstrument = copperHornInstrumentHolder.get().value();
            player.startUsingItem(interactionHand);
            play(level, player, copperHornInstrument);
            player.getCooldowns().addCooldown(this, copperHornInstrument.useDuration());
            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.consume(itemStack);
        } else {
            return InteractionResultHolder.fail(itemStack);
        }
    }

    @Override
    public int getUseDuration(ItemStack $$0, LivingEntity $$1) {
        Optional<Holder<CopperHornInstrument>> copperHornInstrumentHolder = this.getInstrument($$0);
        return copperHornInstrumentHolder.map((copperHornInstrument) -> {
            return copperHornInstrument.value().useDuration();
        }).orElse(0);
    }

    private Optional<Holder<CopperHornInstrument>> getInstrument(ItemStack itemStack) {
        Holder<CopperHornInstrument> instrumentHolder = itemStack.get(RosesDataComponents.COPPER_HORN_INSTRUMENT.get());
        if (instrumentHolder != null) {
            return Optional.of(instrumentHolder);
        } else {
            Iterator<Holder<CopperHornInstrument>> instruments = RosesBuiltInRegistries.COPPER_HORN_INSTRUMENTS.getTagOrEmpty(this.copperHornInstruments).iterator();
            return instruments.hasNext() ? Optional.of(instruments.next()) : Optional.empty();
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }

    private static void play(Level level, Player player, CopperHornInstrument copperHornInstrument) {
        SoundEvent soundEvents;
        if (player.isCrouching()) {
            soundEvents = copperHornInstrument.bass().value();
        } else if (player.getXRot() <= -60.0F) {
            soundEvents = copperHornInstrument.melody().value();
        } else {
            soundEvents = copperHornInstrument.call().value();
        }
        float volume = copperHornInstrument.range() / 16.0F;
        level.playSound(player, player, soundEvents, SoundSource.RECORDS, volume, 1.0F);
        level.gameEvent(GameEvent.INSTRUMENT_PLAY, player.position(), GameEvent.Context.of(player));
    }
}
