package teletubbies.armor.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTubbySkirt extends ModelBiped {
	ModelRenderer Piece1;
	ModelRenderer skirt1;
	ModelRenderer skirt2;
	ModelRenderer skirt3;
	ModelRenderer skirt4;
	ModelRenderer skirt5;
	ModelRenderer skirt6;
	ModelRenderer skirt7;

	public ModelTubbySkirt(float f) {
		super(f, 0, 64, 64);

		textureWidth = 64;
		textureHeight = 64;
		setTextureOffset("Piece1.skirt", 0, 0);

		Piece1 = new ModelRenderer(this, "Piece1");
		Piece1.setRotationPoint(0F, 0F, 0F);
		setRotation(Piece1, 0F, 0F, 0F);
		Piece1.mirror = true;
		skirt1 = new ModelRenderer(this, 0, 33);
		skirt1.addBox(-4F, 5F, -3F, 8, 1, 6);
		skirt1.setRotationPoint(0F, 0F, 0F);
		skirt1.setTextureSize(64, 32);
		skirt1.mirror = true;
		setRotation(skirt1, 0F, 0F, 0F);
		skirt2 = new ModelRenderer(this, 0, 40);
		skirt2.addBox(-4F, 6F, -3F, 8, 7, 1);
		skirt2.setRotationPoint(0F, 0F, 0F);
		skirt2.setTextureSize(64, 32);
		skirt2.mirror = true;
		setRotation(skirt2, -0.1745329F, 0F, 0F);
		skirt3 = new ModelRenderer(this, 0, 48);
		skirt3.addBox(-2F, 6F, -4F, 4, 7, 1);
		skirt3.setRotationPoint(0F, 0F, 0F);
		skirt3.setTextureSize(64, 32);
		skirt3.mirror = true;
		setRotation(skirt3, -0.1745329F, 0F, 0F);
		skirt4 = new ModelRenderer(this, 19, 40);
		skirt4.addBox(-4F, 6F, 2F, 8, 7, 1);
		skirt4.setRotationPoint(0F, 0F, 0F);
		skirt4.setTextureSize(64, 32);
		skirt4.mirror = true;
		setRotation(skirt4, 0.1745329F, 0F, 0F);
		skirt5 = new ModelRenderer(this, 19, 48);
		skirt5.addBox(-2F, 6F, 3F, 4, 7, 1);
		skirt5.setRotationPoint(0F, 0F, 0F);
		skirt5.setTextureSize(64, 32);
		skirt5.mirror = true;
		setRotation(skirt5, 0.1745329F, 0F, 0F);
		skirt6 = new ModelRenderer(this, 38, 46);
		skirt6.addBox(-4F, 6F, -3F, 1, 7, 6);
		skirt6.setRotationPoint(0F, 0F, 0F);
		skirt6.setTextureSize(64, 32);
		skirt6.mirror = true;
		setRotation(skirt6, 0F, 0F, 0.1308997F);
		skirt7 = new ModelRenderer(this, 38, 33);
		skirt7.addBox(3F, 6F, -3F, 1, 7, 6);
		skirt7.setRotationPoint(0F, 0F, 0F);
		skirt7.setTextureSize(64, 32);
		skirt7.mirror = true;
		setRotation(skirt7, 0F, 0F, -0.1308997F);

		this.bipedBody.addChild(skirt1);
		this.bipedBody.addChild(skirt2);
		this.bipedBody.addChild(skirt3);
		this.bipedBody.addChild(skirt4);
		this.bipedBody.addChild(skirt5);
		this.bipedBody.addChild(skirt6);
		this.bipedBody.addChild(skirt7);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}