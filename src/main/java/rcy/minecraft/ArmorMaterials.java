package rcy.minecraft;

public enum ArmorMaterials {
    CITRINE("citrine"),
    LEATHER("leather"),
    CHAIN("chainmail"),
    IRON("iron"),
    GOLD("gold"),
    DIAMOND("diamond"),
    HOLY_EMERALD("holy_emerald")
    ;

    private String name;

    ArmorMaterials(String material) {
        this.name = material;
    }

    public String getName() {
        return name;
    }
}
