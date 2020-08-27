package teletubbies.init;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.entity.baby.BaEntity;
import teletubbies.entity.baby.DaaDaaEntity;
import teletubbies.entity.baby.DuggleDeeEntity;
import teletubbies.entity.baby.MiMiEntity;
import teletubbies.entity.baby.NinEntity;
import teletubbies.entity.baby.PingEntity;
import teletubbies.entity.baby.RuRuEntity;
import teletubbies.entity.baby.TiddlytubbyEntity;
import teletubbies.entity.baby.UmpiePumpieEntity;
import teletubbies.entity.item.PoScooterEntity;
import teletubbies.entity.monster.DipsyZombieEntity;
import teletubbies.entity.monster.LaaLaaZombieEntity;
import teletubbies.entity.monster.PoZombieEntity;
import teletubbies.entity.monster.TinkyWinkyZombieEntity;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.NooNooEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;
import teletubbies.item.ModSpawnEggItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Teletubbies.MODID);

    // Entity Types
    public static final RegistryObject<EntityType<TinkyWinkyEntity>> TINKYWINKY = ENTITY_TYPES.register("tinkywinky",
            () -> EntityType.Builder.create(TinkyWinkyEntity::new, EntityClassification.CREATURE)
                    .size(0.6F, 1.9F)
                    .build(new ResourceLocation(Teletubbies.MODID, "tinkywinky").toString()));

    public static final RegistryObject<EntityType<DipsyEntity>> DIPSY = ENTITY_TYPES.register("dipsy",
            () -> EntityType.Builder.create(DipsyEntity::new, EntityClassification.CREATURE)
                    .size(0.6F, 1.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "dipsy").toString()));
    
    public static final RegistryObject<EntityType<LaaLaaEntity>> LAALAA = ENTITY_TYPES.register("laalaa",
            () -> EntityType.Builder.create(LaaLaaEntity::new, EntityClassification.CREATURE)
                    .size(0.6F, 1.7F)
                    .build(new ResourceLocation(Teletubbies.MODID, "laalaa").toString()));
    
    public static final RegistryObject<EntityType<PoEntity>> PO = ENTITY_TYPES.register("po",
            () -> EntityType.Builder.create(PoEntity::new, EntityClassification.CREATURE)
                    .size(0.6F, 1.6F)
                    .build(new ResourceLocation(Teletubbies.MODID, "po").toString()));
    
    public static final RegistryObject<EntityType<NooNooEntity>> NOONOO = ENTITY_TYPES.register("noonoo",
            () -> EntityType.Builder.create(NooNooEntity::new, EntityClassification.CREATURE)
                    .size(1.0F, 1.0F)
                    .build(new ResourceLocation(Teletubbies.MODID, "noonoo").toString()));
    
    public static final RegistryObject<EntityType<MiMiEntity>> MIMI = ENTITY_TYPES.register("mimi",
            () -> EntityType.Builder.create(MiMiEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "mimi").toString()));
    
    public static final RegistryObject<EntityType<DaaDaaEntity>> DAADAA = ENTITY_TYPES.register("daadaa",
            () -> EntityType.Builder.create(DaaDaaEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "daadaa").toString()));
    
    public static final RegistryObject<EntityType<PingEntity>> PING = ENTITY_TYPES.register("ping",
            () -> EntityType.Builder.create(PingEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "ping").toString()));
    
    public static final RegistryObject<EntityType<BaEntity>> BA = ENTITY_TYPES.register("ba",
            () -> EntityType.Builder.create(BaEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "ba").toString()));
    
    public static final RegistryObject<EntityType<RuRuEntity>> RURU = ENTITY_TYPES.register("ruru",
            () -> EntityType.Builder.create(RuRuEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "ruru").toString()));
    
    public static final RegistryObject<EntityType<NinEntity>> NIN = ENTITY_TYPES.register("nin",
            () -> EntityType.Builder.create(NinEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "nin").toString()));
    
    public static final RegistryObject<EntityType<DuggleDeeEntity>> DUGGLEDEE = ENTITY_TYPES.register("duggledee",
            () -> EntityType.Builder.create(DuggleDeeEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "duggledee").toString()));
    
    public static final RegistryObject<EntityType<UmpiePumpieEntity>> UMPIEPUMPIE = ENTITY_TYPES.register("umpiepumpie",
            () -> EntityType.Builder.create(UmpiePumpieEntity::new, EntityClassification.CREATURE)
                    .size(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "umpiepumpie").toString()));
    
    public static final RegistryObject<EntityType<TinkyWinkyZombieEntity>> TINKYWINKY_ZOMBIE = ENTITY_TYPES.register("tinkywinky_zombie",
            () -> EntityType.Builder.create(TinkyWinkyZombieEntity::new, EntityClassification.MONSTER)
                    .size(0.6F, 1.9F)
                    .build(new ResourceLocation(Teletubbies.MODID, "tinkywinky_zombie").toString()));
    
    public static final RegistryObject<EntityType<DipsyZombieEntity>> DIPSY_ZOMBIE = ENTITY_TYPES.register("dipsy_zombie",
            () -> EntityType.Builder.create(DipsyZombieEntity::new, EntityClassification.MONSTER)
                    .size(0.6F, 1.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "dipsy_zombie").toString()));
    
    public static final RegistryObject<EntityType<LaaLaaZombieEntity>> LAALAA_ZOMBIE = ENTITY_TYPES.register("laalaa_zombie",
            () -> EntityType.Builder.create(LaaLaaZombieEntity::new, EntityClassification.MONSTER)
                    .size(0.6F, 1.7F)
                    .build(new ResourceLocation(Teletubbies.MODID, "laalaa_zombie").toString()));
    
    public static final RegistryObject<EntityType<PoZombieEntity>> PO_ZOMBIE = ENTITY_TYPES.register("po_zombie",
            () -> EntityType.Builder.create(PoZombieEntity::new, EntityClassification.MONSTER)
                    .size(0.6F, 1.6F)
                    .build(new ResourceLocation(Teletubbies.MODID, "po_zombie").toString()));
    
    public static final RegistryObject<EntityType<PoScooterEntity>> PO_SCOOTER = ENTITY_TYPES.register("po_scooter",
            () -> EntityType.Builder.<PoScooterEntity>create(PoScooterEntity::new, EntityClassification.MISC)
                    .size(1.15F, 0.3F)
                    .setCustomClientFactory((entity, world) -> new PoScooterEntity(world))
                    .build(new ResourceLocation(Teletubbies.MODID, "po_scooter").toString()));

	public static void setAttributes() {
		DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.TINKYWINKY.get(), CreatureEntity.func_233666_p_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DIPSY.get(), CreatureEntity.func_233666_p_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.LAALAA.get(), CreatureEntity.func_233666_p_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PO.get(), CreatureEntity.func_233666_p_().create());

            GlobalEntityTypeAttributes.put(ModEntityTypes.NOONOO.get(), NooNooEntity.setCustomAttributes().create());
            
        	GlobalEntityTypeAttributes.put(ModEntityTypes.MIMI.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DAADAA.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PING.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.BA.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.RURU.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.NIN.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DUGGLEDEE.get(), TiddlytubbyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.UMPIEPUMPIE.get(), TiddlytubbyEntity.setCustomAttributes().create());
           
            GlobalEntityTypeAttributes.put(ModEntityTypes.TINKYWINKY_ZOMBIE.get(), ZombieEntity.func_234342_eQ_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DIPSY_ZOMBIE.get(), ZombieEntity.func_234342_eQ_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.LAALAA_ZOMBIE.get(), ZombieEntity.func_234342_eQ_().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.PO_ZOMBIE.get(), ZombieEntity.func_234342_eQ_().create());
        });
	}
	
	@SubscribeEvent
	public static void registerEntityTypeEvent(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();
	}
}