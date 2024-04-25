package com.ultrascatterred.ultrasapi.itemtemp;

import com.ultrascatterred.ultrasapi.UltrasApi;
import com.ultrascatterred.ultrasapi.classes.UltraWeapon;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UltrasApi.MODID);
    public static final RegistryObject<UltraWeapon> testWeapon =
            ITEMS.register("test_weapon",
                    () -> new UltraWeapon(Tiers.IRON,
                            5,
                            -2.9f,
                            new Item.Properties(),
                            10.0,
                            false));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
