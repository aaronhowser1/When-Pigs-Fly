package com.aaronhowser1.whenpigsfly;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlyingPigRenderer extends MobRenderer<FlyingPigEntity, FlyingPigModel<FlyingPigEntity>> {
    private static final ResourceLocation PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");

    public FlyingPigRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FlyingPigModel<>(), 0.7F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(FlyingPigEntity entity) {
        return PIG_TEXTURES;
    }
}