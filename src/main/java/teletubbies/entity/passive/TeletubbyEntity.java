package teletubbies.entity.passive;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesItems;

public abstract class TeletubbyEntity extends CreatureEntity {

	protected boolean hasTransferredToZombie = false;
	
	public TeletubbyEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
		Arrays.fill(this.inventoryArmorDropChances, 1.0F);
		Arrays.fill(this.inventoryHandsDropChances, 1.0F);
	}
	
	public static boolean canSpawn(EntityType<? extends TeletubbyEntity> entityType, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
	    this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.45F));
		this.goalSelector.addGoal(3, new PanicGoal(this, 0.55F));
		this.goalSelector.addGoal(4, new TemptGoal(this, 0.45F, false, Ingredient.fromItems(TeletubbiesItems.TOAST.get(), TeletubbiesItems.CUSTARD.get())));
		this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.45F));
		this.goalSelector.addGoal(6, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 0.9F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}
	
	@Override
	protected boolean canDropLoot() {
		return super.canDropLoot() && !hasTransferredToZombie;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		int i = this.rand.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.TUTU.get());
			int damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.LEGS, stack);
			break;
		}
	}
	
	@Override
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData,
			@Nullable CompoundNBT dataTag) {
		spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
		this.setEquipmentBasedOnDifficulty(difficulty);
		return spawnData;
	}
	
	public abstract EntityType<?> getZombie();
	
	public void transferToZombie() {
		ZombieEntity zombie = (ZombieEntity) this.getZombie().create(world);
		zombie.copyLocationAndAnglesFrom(this);
		this.hasTransferredToZombie = true;
		this.remove();
		
		zombie.setChild(false);
		zombie.setNoAI(this.isAIDisabled());
		if (this.hasCustomName()) {
			zombie.setCustomName(this.getCustomName());
			zombie.setCustomNameVisible(this.isCustomNameVisible());
		}

		world.addEntity(zombie);
		world.playEvent(null, 1026, zombie.getPosition(), 0);
	}
}
