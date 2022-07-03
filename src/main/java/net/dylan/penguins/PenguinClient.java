package net.dylan.penguins;

import net.dylan.penguins.entity.ModEntities;
import net.dylan.penguins.entity.client.PenguinRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class PenguinClient implements ClientModInitializer  {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.PENGUIN, PenguinRenderer::new);
    }
}
