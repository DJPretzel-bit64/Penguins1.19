package net.dylan.penguins.entity.client;

import net.dylan.penguins.Penguins;
import net.dylan.penguins.entity.custom.PenguinEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PenguinRenderer extends GeoEntityRenderer<PenguinEntity> {
    public PenguinRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PenguinModel());
    }

    @Override
    public Identifier getTextureResource(PenguinEntity instance) {
        return new Identifier(Penguins.MOD_ID, "textures/entity/penguin/penguin.png");
    }
}
