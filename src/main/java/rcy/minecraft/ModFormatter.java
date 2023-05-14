package rcy.minecraft;

import java.io.*;
import java.util.Scanner;

public class ModFormatter {
    /**
     * Gets the new ArmorItem created and creates a string that will be written into ModItems
     *
     * @param material the material taken from ArmorMaterial enum
     * @param slot then type of the armor slot FEET, HAND, CHEST, ...
     *
     */

    public static String generateModItemString(ArmorMaterials material, EquipmentSlot slot) {
        String formattedString = "\tpublic static final RegistryObject<Item> " + material.getName().toUpperCase() + "_" + slot.getElement().toUpperCase() + " = ITEMS.register(\"" + material.getReference() + "_" + slot.getItem() + "\",\n"
                + "\t\t() -> new ArmorItem(ModArmorMaterials." + material.toString().toUpperCase() + ", EquipmentSlot." + slot + ",\n"
                + "\t\t\t\tnew Item.Properties().tab(ModCreativeModeTab.MODBUILDER_TAB)));\n";
        return formattedString;
    }

    public static String LangFormat(ArmorMaterials material) {
        String str = material.name().toLowerCase();
        String cap = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
        return  "\"item.modbuilder." + str + "\": \"" + cap + "\",\n" +
                "  \"item.modbuilder." + str + "_helmet\": \"" + cap + " Helmet\",\n" +
                "  \"item.modbuilder." + str + "_chestplate\": \"" + cap + " Chestplate\",\n" +
                "  \"item.modbuilder." + str + "_leggings\": \"" + cap + " Leggings\",\n" +
                "  \"item.modbuilder." + str + "_boots\": \"" + cap + " Boots\"";
    }

    public static void insertModItemString(String formattedString) throws IOException {
        File file = new File("C:\\Users\\arell\\code\\Minecraft\\src\\main\\java\\net\\rcy\\modbuilder\\item\\ModItems.java");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        StringBuilder content = new StringBuilder();
        boolean inserted = false;

        while ((line = reader.readLine()) != null) {
            if (!inserted && line.contains("public static final RegistryObject<Item>")) {
                content.append(formattedString).append('\n');
                inserted = true;
            }
            content.append(line).append('\n');
        }
        reader.close();

        if (!inserted) {
            throw new IOException("Failed to insert formatted string into ModItems.java");
        }

        FileWriter writer = new FileWriter(file);
        PrintWriter printer = new PrintWriter(writer);
        printer.print(content.toString());
        printer.close();
    }

    public static void writeToLangFile(String str) throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\arell\\code\\Minecraft\\src\\main\\resources\\assets\\modbuilder\\lang\\en_us.json");
        boolean isDuplicate = false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("\"")) {
                    String key = line.split("\":", 2)[0].substring(1);
                    if (key.equals(str.split("\":", 2)[0].substring(1))) {
                        isDuplicate = true;
                        break;
                    }
                }
            }
        }

        if (!isDuplicate) {
            if (file.length() == 0) { // if file is empty, write the JSON object with str as its content
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.print("{\n" + str + "\n}");
                }
            } else { // otherwise, append the new entry to the existing JSON object
                String fileContent;
                try (Scanner scanner = new Scanner(file)) {
                    fileContent = scanner.useDelimiter("\\Z").next();
                }
                int lastClosingBraceIndex = fileContent.lastIndexOf('}');
                String newContent = fileContent.substring(0, lastClosingBraceIndex) + ",\n  " + str + "\n}";
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.print(newContent);
                }
            }
        } else {
            System.out.println("Duplicate entry found, not adding to lang file.");
        }
    }

}

