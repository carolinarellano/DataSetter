package rcy.minecraft;

public enum ArmorMaterials {
    CITRINE("citrine", "citrine"),
    CITRINE1("citrine1", "citrine"),
    CITRINE2("citrine2", "citrine"),
    LEATHER("leather", "leather"),
    LEATHER1("leather1", "leather"),
    LEATHER2("leather2", "leather"),
    CHAIN("chainmail", "chainmail"),
    CHAIN1("chainmail1", "chainmail"),
    CHAIN2("chainmail2", "chainmail"),
    IRON("iron", "iron"),
    IRON1("iron1", "iron"),
    IRON2("iron2", "iron"),
    GOLD("gold", "golden"),
    GOLD1("gold1", "golden"),
    GOLD2("gold2", "golden"),
    DIAMOND("diamond", "diamond"),
    DIAMOND1("diamond1", "diamond"),
    DIAMOND2("diamond2", "diamond"),
    HOLY_EMERALD("holy_emerald", "emerald"),
    HOLY_EMERALD1("holy_emerald1", "emerald"),
    HOLY_EMERALD2("holy_emerald2", "emerald")
    ;

    private String name;
    private String reference;

    ArmorMaterials(String material, String reference) {
        this.name = material;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }
}
