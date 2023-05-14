package rcy.minecraft;

public enum ArmorMaterials {
    CITRINE("citrine"),
    LEATHER("leather"),
    CHAIN("chainmail"),
    IRON("iron"),
    GOLD("gold"),
    DIAMOND("diamond"),
    TURTLE("turtle"),
    NETHERITE("netherite"),
    PURE_GOLD("pure_gold"),
    REINFORCED_DIAMOND("reinforced_diamond"),
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
