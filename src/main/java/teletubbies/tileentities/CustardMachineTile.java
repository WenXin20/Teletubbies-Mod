package teletubbies.tileentities;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import teletubbies.lists.BlockList;
import teletubbies.lists.ItemList;
import teletubbies.util.Converter;

public class CustardMachineTile extends TileEntity implements ITickableTileEntity {

	private static final long DROPTICKS = Converter.SecondsToTicks(3);
	private static final long CLICKTICKS = Converter.SecondsToTicks(4);

	private long ticksSinceLastClick;
	
	public CustardMachineTile() {
		super(BlockList.CUSTARD_MACHINE_TILE);
		ticksSinceLastClick = CLICKTICKS;
	}

	@Override
	public void tick() {
		if (ticksSinceLastClick < CLICKTICKS) {
			ticksSinceLastClick++;
		}
		if (ticksSinceLastClick == DROPTICKS) {
			dropCustard(new ItemStack(ItemList.CUSTARD));
		}
	}
	
	public boolean canDrop() {
		return ticksSinceLastClick >= CLICKTICKS;
	}
	
	public void reset() {
		ticksSinceLastClick = 0;
	}
	
	public void dropCustard(ItemStack stack) {
		if (!world.isRemote) {
        	ItemEntity item = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.1, pos.getZ() + 0.5, stack);
        	item.setMotion(0, 0, 0);
        	world.addEntity(item);
    	}
	}

}