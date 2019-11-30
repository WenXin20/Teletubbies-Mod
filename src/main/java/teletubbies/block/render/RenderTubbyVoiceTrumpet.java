package teletubbies.block.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import teletubbies.block.model.ModelTubbyCustardMachine;
import teletubbies.block.model.ModelTubbyVoiceTrumpet;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTubbyVoiceTrumpet extends TileEntitySpecialRenderer{
    
	private final ModelTubbyVoiceTrumpet model;
    
    public RenderTubbyVoiceTrumpet() {  
    	this.model = new ModelTubbyVoiceTrumpet();
    }
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
    	renderModel((TileEntityTubbyVoiceTrumpet) te, x, y, z, scale);
    }
    
    private void renderModel(TileEntityTubbyVoiceTrumpet te, double x, double y, double z, float scale) {
    	while(te.isMaster() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		te.readFromNBT(data);
    	}
    	
    	if(te.isMaster()){
        	GL11.glPushMatrix();
        	GL11.glTranslatef((float) x + 0.5F, (float) y + 1.0F, (float) z + 0.5F);
            ResourceLocation textures = (new ResourceLocation("teletubbies:textures/blocks/TubbyVoiceTrumpet.png"));
            Minecraft.getMinecraft().renderEngine.bindTexture(textures);
            GL11.glPushMatrix();         
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glPushMatrix();           
            GL11.glRotatef(te.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);           
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);           
            GL11.glPopMatrix();            
            GL11.glPopMatrix();  
            GL11.glPopMatrix();
    	}
    	else{
    		
    	}
    }
}