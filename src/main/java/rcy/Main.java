package rcy;

import rcy.minecraft.Armor;
import rcy.minecraft.Weapon;
import rcy.minecraft.WeaponMaterials;

import java.io.IOException;
import java.text.ParseException;

import static rcy.minecraft.ArmorMaterials.*;

/**
 *
 * We can create the new armors or weapons from main or using the graphic interface, both work!
 *
 */

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Armor.registerJson(GOLD1);
        Armor.registerJava(GOLD1);
        
    }
}