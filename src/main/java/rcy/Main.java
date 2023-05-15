package rcy;

import rcy.minecraft.Armor;
import rcy.minecraft.ArmorMaterials;
import rcy.minecraft.Weapon;
import rcy.minecraft.WeaponMaterials;

import java.io.IOException;
import java.text.ParseException;

import static rcy.minecraft.Tool.*;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Armor.registerJava(ArmorMaterials.LEATHER);
        Armor.registerJson(ArmorMaterials.DIAMOND);
        Weapon.registerJava(WeaponMaterials.CITRINE, SWORD, 6, 3.2f);
        Weapon.registerJava(WeaponMaterials.IRON, PICKAXE, 3, 2f);
        Weapon.registerJava(WeaponMaterials.DIAMOND, AXE, 8, 7f);
        Weapon.registerJava(WeaponMaterials.STONE, SHOVEL, 2, 1.3f);
        Weapon.registerJava(WeaponMaterials.NETHERITE, HOE, 1, 0.3f);
    }
}
