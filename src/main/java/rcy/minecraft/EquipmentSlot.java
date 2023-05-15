package rcy.minecraft;

/**
 *
 * EquipmentSlot enum has the different parts of the armor that can be created and they are used to set the format of the methods
 *
 */

public enum EquipmentSlot {
    FEET("BOOTS", "boots"),
    LEGS("LEGGING", "leggings"),
    CHEST("CHESTPLATE", "chestplate"),
    HEAD("HELMET", "helmet");

    private final String element;
    private final String item;

    EquipmentSlot(String element, String item) {
        this.element = element;
        this.item = item;
    }

    public String getElement() {
        return element;
    }

    public String getItem() {
        return item;
    }
}
