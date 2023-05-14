package rcy;

import rcy.minecraft.Armor;

import java.io.IOException;
import java.text.ParseException;

import static rcy.minecraft.ArmorMaterials.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Armor.registerJson(GOLD1);
        Armor.registerJava(GOLD1);
    }
}