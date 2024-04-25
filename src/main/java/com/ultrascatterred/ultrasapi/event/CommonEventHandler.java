package com.ultrascatterred.ultrasapi.event;

import com.ultrascatterred.ultrasapi.classes.UltraWeapon;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEventHandler {
   @SubscribeEvent
    public void onWeaponHeld(LivingEquipmentChangeEvent event){
        Item switchedTo = event.getTo().getItem();
        if(switchedTo instanceof UltraWeapon){
            ((UltraWeapon) switchedTo).reloadAttributeMods(((UltraWeapon) switchedTo).reachMod, 1,1);
        }
    }
    @SubscribeEvent
    public void onWeaponReleased(LivingEquipmentChangeEvent event){
        Item switchedFrom = event.getFrom().getItem();
        if(switchedFrom instanceof UltraWeapon){
            ((UltraWeapon) switchedFrom).reloadAttributeMods(0, 1,1);
        }
    }
}
