package ru.stroke.ugolmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelUgol extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg2;
    private final ModelRenderer left_leg;
    private final ModelRenderer body2;
    private final ModelRenderer head2;
    private final ModelRenderer right_leg2;
    private final ModelRenderer left_leg3;
    
    public ModelUgol() {
      this.textureWidth = 64;
      this.textureHeight = 64;
      this.body = new ModelRenderer(this);
      this.body.setRotationPoint(0.0F, -15.0F, 0.0F);
      this.head = new ModelRenderer(this);
      this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body.addChild(this.head);
      this.right_leg = new ModelRenderer(this);
      this.right_leg.setRotationPoint(-2.0F, 9.0F, 0.0F);
      this.head.addChild(this.right_leg);
      this.left_leg2 = new ModelRenderer(this);
      this.left_leg2.setRotationPoint(4.0F, 0.0F, 0.0F);
      this.right_leg.addChild(this.left_leg2);
      this.left_leg = new ModelRenderer(this);
      this.left_leg.setRotationPoint(2.0F, -6.0F, 0.0F);
      this.body2 = new ModelRenderer(this);
      this.body2.setRotationPoint(0.0F, -15.0F, 0.0F);
      this.body2.cubeList.add(new ModelBox(this.body2, 17, 16, -4.0F, -8.0F, -2.0F, 8, 12, 4, 0.0F, false));
      this.body2.cubeList.add(new ModelBox(this.body2, 40, 16, -8.0F, -8.0F, -2.0F, 4, 23, 4, 0.0F, false));
      this.body2.cubeList.add(new ModelBox(this.body2, 40, 16, 4.0F, -8.0F, -2.0F, 4, 23, 4, 0.0F, true));
      this.head2 = new ModelRenderer(this);
      this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body2.addChild(this.head2);
      this.head2.cubeList.add(new ModelBox(this.head2, 0, 0, -4.0F, -16.0F, -4.0F, 8, 8, 8, 0.0F, false));
      this.right_leg2 = new ModelRenderer(this);
      this.right_leg2.setRotationPoint(-2.0F, 9.0F, 0.0F);
      this.head2.addChild(this.right_leg2);
      this.right_leg2.cubeList.add(new ModelBox(this.right_leg2, 0, 16, -2.0F, -5.0F, -2.0F, 4, 35, 4, 0.0F, true));
      this.left_leg3 = new ModelRenderer(this);
      this.left_leg3.setRotationPoint(4.0F, 0.0F, 0.0F);
      this.right_leg2.addChild(this.left_leg3);
      this.left_leg3.cubeList.add(new ModelBox(this.left_leg3, 0, 16, -2.0F, -5.0F, -2.0F, 4, 35, 4, 0.0F, true));
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      this.body.render(f5);
      this.left_leg.render(f5);
      this.body2.render(f5);
    }
    
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
    }
}