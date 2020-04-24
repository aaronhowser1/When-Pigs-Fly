package com.aaronhowser1.whenpigsfly;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlyingPigModel<T extends Entity> extends QuadrupedModel<T> {
    public FlyingPigModel() {
        this(0.0F);
    }

    public FlyingPigModel(float scale) {
        super(6, scale, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
        this.headModel.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, scale);
    }
}