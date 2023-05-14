package rcy.minecraft;

public enum EquipmentSlot {
    FEET("BOOTS"),
    LEGS("LEGGING"),
    CHEST("CHESTPLATE"),
    HEAD("HELMET");

    private final String element;

    EquipmentSlot(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
