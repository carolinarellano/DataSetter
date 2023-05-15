package main.java.rcy;

import main.java.rcy.minecraft.Armor;

import java.io.IOException;
import java.text.ParseException;

import static main.java.rcy.minecraft.ArmorMaterials.GOLD1;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Armor.registerJson(GOLD1);
        Armor.registerJava(GOLD1);
    }
}