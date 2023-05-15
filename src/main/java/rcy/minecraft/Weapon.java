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
 * Weapon class is where all the constructors, methods, setters and getters take place for the creation of any weapon
 *
 */
public class Weapon {

    private WeaponMaterials name;

    public Weapon(){}

    /**
     * Weapon constructor, assigns the material o their respective tool
     *
     * @param material taken from WeaponMaterials
     *
     */
    public Weapon(WeaponMaterials material){this.name = material;}

    /**
     *
     * Registration for a new weapon in LangFormat
     *
     * @param material taken from WeaponMaterials
     * @throws IOException
     * @throws ParseException
     *
     */
    public static void registerJson(WeaponMaterials material) throws IOException, ParseException {
        String formattedMaterial = LangFormat(material);
        writeToLangFile(formattedMaterial);
    }

    /**
     *
     * Registration for the new weapon in ModItems
     *
     * @param material taken from Weapon Materials
     * @param t type of weapon
     * @param atk attack power
     * @param spAtk attack speed
     * @throws IOException
     */

    public static void registerJava(WeaponMaterials material, Tool t, int atk, float spAtk) throws IOException {
            String formattedString = generateModItemString(material, t, atk, spAtk);
            if (!modItemExists(formattedString)){
                try{
                    insertModItemString(formattedString);
                } catch (IOException e){
                    System.out.println("Error inserting formated string: " + e.getMessage());
                }
            } else {
                System.out.println("Mod item already exists: " + formattedString);
            }
    }

    /**
     *
     * Verifies if the item created already exists
     *
     * @param formattedString string with the format required to create the new Weapon
     * @throws IOException
     */

    public static boolean modItemExists(String formattedString) throws IOException{
        File file = new File("C:\\Users\\arell\\code\\Minecraft\\src\\main\\java\\net\\rcy\\modbuilder\\item\\ModItems.java");
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        for (String line : lines) {
            if (line.equals(formattedString)) {
                return true;
            }
        }
        return false;
    }


    //Getters y setters
    public WeaponMaterials getName(){
        return name;
    }

    public void setMaterial(WeaponMaterials material){
        this.name = material;
    }
}
