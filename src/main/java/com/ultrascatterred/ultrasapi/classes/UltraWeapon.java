package com.ultrascatterred.ultrasapi.classes;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraftforge.common.ForgeMod;

public class UltraWeapon extends SwordItem {
    public double reachMod;
    public boolean twoHanded;
    public Multimap<Attribute, AttributeModifier> AttributeMods;
    public UltraWeapon(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_,
                       double reachMod, boolean twoHanded) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
        this.reachMod = reachMod;
        this.twoHanded = twoHanded;
        reloadAttributeMods(reachMod,1,1);
    }
    // set player's reach distance to this instance's custom value when equipped in main hand
    /*public void SetPlayerReach() {
        Player player = Minecraft.getInstance().player;
        assert player != null;
        if(player.isHolding(this)){
            // add reachMod to player reach

        }
    }
    // reset player reach once this instance is unequipped
    public void ResetPlayerReach() {

    }*/
    // applies input modifiers to their respective attributes
    public void reloadAttributeMods(double reachMod, double speedMod, double attackMod) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> mapBuilder =
                ImmutableMultimap.builder();
        mapBuilder.put(ForgeMod.ENTITY_REACH.get(),
                new AttributeModifier(Mth.createInsecureUUID(),
                        "UltraWeapon modifier", reachMod - 5.0,
                        AttributeModifier.Operation.ADDITION));
        mapBuilder.put(Attributes.ATTACK_SPEED,
                new AttributeModifier(Mth.createInsecureUUID(),
                        "UltraWeapon modifier", speedMod,
                        AttributeModifier.Operation.MULTIPLY_TOTAL));
        mapBuilder.put(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(Mth.createInsecureUUID(),
                        "UltraWeapon modifier", attackMod,
                        AttributeModifier.Operation.MULTIPLY_TOTAL));
        AttributeMods = mapBuilder.build();

    }
}
