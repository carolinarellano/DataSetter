package rcy.minecraft;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.List;

import static rcy.minecraft.ModFormatter.*;

/**
 *
 * Armor class is where all the constructors, methods, setters and getters take place for the creation of any armor, by using the register based on the ModFormatter class
 *
 */

public class Armor {

    private ArmorMaterials name;

    public Armor() {
    }

    public Armor(ArmorMaterials material) {
        this.name = material;
    }

    public static void registerJson(ArmorMaterials material) throws IOException, ParseException {
        String formattedMaterial = LangFormat(material);
        writeToLangFile(formattedMaterial);
    }

    public static void registerJava(ArmorMaterials material) throws IOException {
        for (EquipmentSlot eq : EquipmentSlot.values()) {
            String formattedString = generateModItemString(material, eq);
            if (!modItemExists(formattedString)) {
                try {
                    insertModItemString(formattedString);
                } catch (IOException e) {
                    System.out.println("Error inserting formatted string: " + e.getMessage());
                }
            } else {
                System.out.println("Mod item already exists: " + formattedString);
            }
        }
    }


    private static boolean modItemExists(String formattedString) throws IOException {
        File file = new File("C:\\Users\\arell\\code\\Minecraft\\src\\main\\java\\net\\rcy\\modbuilder\\item\\ModItems.java");
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        for (String line : lines) {
            if (line.equals(formattedString)) {
                return true;
            }
        }
        return false;
    }


    // Getters y setters
    public ArmorMaterials getName() {
        return name;
    }

    public void setMaterial(ArmorMaterials material) {
        this.name = material;
    }
}
