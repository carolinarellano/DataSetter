package rcy.minecraft;

/**
 *
 * WeaponMaterials enum is where all the key materials are available, if the user types one inexistent material, it will throw an exception
 *
 */
public enum WeaponMaterials {

    CITRINE("citrine"),
    WOOD("wood"),
    STONE("stone"),
    IRON("iron"),
    GOLD("gold"),
    DIAMOND("diamond"),
    NETHERITE("netherite"),
    PURE_GOLD("pure_gold"),
    REINFORCED_DIAMOND("reinforced_diamond"),
    HOLY_EMERALD("holy_emerald");

    private String name;

    WeaponMaterials(String material){this.name = material;}

    public String getName(){return name;}
}
