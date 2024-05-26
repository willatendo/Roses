package willatendo.roses.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import willatendo.roses.server.RosesCreativeModeTabs;
import willatendo.roses.server.block.RosesBlocks;
import willatendo.roses.server.item.RosesItems;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RosesLanguageProvider extends LanguageProvider {
    private final String modId;

    public RosesLanguageProvider(PackOutput packOutput, String modId, String locale) {
        super(packOutput, modId, locale);
        this.modId = modId;
    }

    @Override
    protected void addTranslations() {
        this.add(RosesItems.RUBY.get());
        this.add(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get(), "Music Disc");
        this.addDesc(RosesItems.MUSIC_DISC_MAGNETIC_CIRCUIT.get(), "Notch - Magnetic Circuit");
        this.add(RosesBlocks.ROSE.get());
        this.add(RosesBlocks.POTTED_ROSE.get());
        this.add(RosesBlocks.CYAN_FLOWER.get());
        this.add(RosesBlocks.POTTED_CYAN_FLOWER.get());
        this.add(RosesBlocks.CAPRI_CLOTH.get());
        this.add(RosesBlocks.CHARTREUSE_CLOTH.get());
        this.add(RosesBlocks.CYAN_CLOTH.get());
        this.add(RosesBlocks.DARK_GRAY_CLOTH.get());
        this.add(RosesBlocks.GREEN_CLOTH.get());
        this.add(RosesBlocks.LIGHT_GRAY_CLOTH.get());
        this.add(RosesBlocks.MAGENTA_CLOTH.get());
        this.add(RosesBlocks.ORANGE_CLOTH.get());
        this.add(RosesBlocks.PURPLE_CLOTH.get());
        this.add(RosesBlocks.RED_CLOTH.get());
        this.add(RosesBlocks.ROSE_CLOTH.get());
        this.add(RosesBlocks.SPRING_GREEN_CLOTH.get());
        this.add(RosesBlocks.ULTRAMARINE_CLOTH.get());
        this.add(RosesBlocks.VIOLET_CLOTH.get());
        this.add(RosesBlocks.WHITE_CLOTH.get());
        this.add(RosesBlocks.YELLOW_CLOTH.get());
        this.add(RosesBlocks.OAK_CHAIR.get());
        this.add(RosesBlocks.SPRUCE_CHAIR.get());
        this.add(RosesBlocks.BIRCH_CHAIR.get());
        this.add(RosesBlocks.JUNGLE_CHAIR.get());
        this.add(RosesBlocks.ACACIA_CHAIR.get());
        this.add(RosesBlocks.DARK_OAK_CHAIR.get());
        this.add(RosesBlocks.CRIMSON_CHAIR.get());
        this.add(RosesBlocks.WARPED_CHAIR.get());
        this.add(RosesBlocks.MANGROVE_CHAIR.get());
        this.add(RosesBlocks.CHERRY_CHAIR.get());
        this.add(RosesBlocks.BAMBOO_CHAIR.get());
        this.add(RosesBlocks.OAK_TABLE.get());
        this.add(RosesBlocks.SPRUCE_TABLE.get());
        this.add(RosesBlocks.BIRCH_TABLE.get());
        this.add(RosesBlocks.JUNGLE_TABLE.get());
        this.add(RosesBlocks.ACACIA_TABLE.get());
        this.add(RosesBlocks.DARK_OAK_TABLE.get());
        this.add(RosesBlocks.CRIMSON_TABLE.get());
        this.add(RosesBlocks.WARPED_TABLE.get());
        this.add(RosesBlocks.MANGROVE_TABLE.get());
        this.add(RosesBlocks.CHERRY_TABLE.get());
        this.add(RosesBlocks.BAMBOO_TABLE.get());
        this.add(RosesBlocks.RUBY_ORE.get());
        this.add(RosesBlocks.DEEPSLATE_RUBY_ORE.get());
        this.add(RosesBlocks.RUBY_BLOCK.get(), "Block of Ruby");
        this.add(RosesBlocks.COG.get());
        this.addDesc(RosesBlocks.COG.get(), "Distracting Vibrations");
        this.add(RosesCreativeModeTabs.ROSES.get(), "Roses");
    }


    public void add(Block key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(Item key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(ItemStack key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(Enchantment key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(MobEffect key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(EntityType<?> key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(Item item) {
        this.add(item, SimpleUtils.autoName(BuiltInRegistries.ITEM.getKey(item).getPath()));
    }

    public void add(Block block) {
        this.add(block, SimpleUtils.autoName(BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }

    public void add(Enchantment enchantment) {
        this.add(enchantment, SimpleUtils.autoName(BuiltInRegistries.ENCHANTMENT.getKey(enchantment).getPath()));
    }

    public void add(MobEffect mobEffect) {
        this.add(mobEffect, SimpleUtils.autoName(BuiltInRegistries.MOB_EFFECT.getKey(mobEffect).getPath()));
    }

    public void add(EntityType<?> entityType) {
        this.add(entityType, SimpleUtils.autoName(BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath()));
    }

    public void add(SoundEvent soundEvent) {
        this.add(soundEvent, SimpleUtils.autoName(BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getPath()));
    }

    public void add(MenuType menuType) {
        this.add(menuType, SimpleUtils.autoName(BuiltInRegistries.MENU.getKey(menuType).getPath()));
    }

    public void add(String category, String advancement, String title, String desc) {
        this.add("advancements." + this.modId + "." + category + "." + advancement + ".title", title);
        this.add("advancements." + this.modId + "." + category + "." + advancement + ".desc", desc);
    }

    public void add(SoundEvent soundEvent, String name) {
        this.add("sound." + BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getNamespace() + BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getPath(), name);
    }

    public void add(MenuType menuType, String name) {
        this.add("menu." + BuiltInRegistries.MENU.getKey(menuType).getNamespace() + BuiltInRegistries.MENU.getKey(menuType).getPath(), name);
    }

    public void add(CreativeModeTab creativeModeTab, String name) {
        this.add(creativeModeTab.getDisplayName().getString(), name);
    }

    public void addDesc(Item item, String... descs) {
        for (int i = 0; i < descs.length; i++) {
            this.add(item.getDescriptionId() + ".desc" + i, descs[i]);
        }
    }

    public void addDesc(Item item, String desc) {
        this.add(item.getDescriptionId() + ".desc", desc);
    }

    public void addDesc(Block block, String... descs) {
        for (int i = 0; i < descs.length; i++) {
            this.add(block.getDescriptionId() + ".desc" + i, descs[i]);
        }
    }

    public void addDesc(Block block, String name) {
        this.add(block.getDescriptionId() + ".desc", name);
    }
}
