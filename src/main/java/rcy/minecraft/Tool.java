package rcy.minecraft;


/**
 *
 * Tool enum is used to declare the type of weapon the user wants to create
 *
 */
public enum Tool {

    SWORD("SWORD"),
    PICKAXE("PICKAXE"),
    AXE("AXE"),
    SHOVEL("SHOVEL"),
    HOE("HOE");

    private final String element;

    Tool(String element){this.element = element;}

    public String getElement(){return element;}
}
