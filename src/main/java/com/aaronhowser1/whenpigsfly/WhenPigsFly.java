package com.aaronhowser1.whenpigsfly;

import com.aaronhowser1.whenpigsfly.entity.FlyingPigEntity;
import com.aaronhowser1.whenpigsfly.setup.ClientProxy;
import com.aaronhowser1.whenpigsfly.setup.IProxy;
import com.aaronhowser1.whenpigsfly.setup.ServerProxy;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("whenpigsfly")
public class WhenPigsFly {

    public static final String MODID = "whenpigsfly";

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public WhenPigsFly() {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.COMMON_CONFIG);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        ModConfig.loadConfig(ModConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("whenpigsfly-common.toml"));

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new FlyingPigEggItem());
        }
        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(EntityType.Builder.create(FlyingPigEntity::new, EntityClassification.CREATURE)
                    .size(1, 1)
                    .setShouldReceiveVelocityUpdates(false)
                    .build("flyingpig").setRegistryName(WhenPigsFly.MODID, "flyingpig"));

        }
    }
}
