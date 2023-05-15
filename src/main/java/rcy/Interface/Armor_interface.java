package rcy.Interface;

import com.formdev.flatlaf.FlatLightLaf;
import rcy.minecraft.Armor;
import rcy.minecraft.BasicArmorMaterials;
import rcy.minecraft.Levels;
import rcy.minecraft.ArmorMaterials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * Armor_interface class is the graphic interface to assign values to the customized armor
 *
 */

public class Armor_interface extends JFrame {
    public static final Color WINDOW_COLOR = new Color(28, 28, 28);
    public static final Font FONT = new Font("CHEWY", Font.CENTER_BASELINE, 15);
    private ImageIcon BackgroundIcon;
    private JLabel BackgroundImage;
    JButton backButton = new JButton("\u2190");
    public JComboBox<BasicArmorMaterials> MaterialCmb = new JComboBox(BasicArmorMaterials.values());
    public JComboBox<Levels> LevelCmb = new JComboBox(Levels.values());
    public BasicArmorMaterials material = (BasicArmorMaterials) MaterialCmb.getSelectedItem();
    public Levels level = (Levels) LevelCmb.getSelectedItem();
    private JButton okbtn = new JButton("Guardar todo");
    private JButton MaterialGbtn = new JButton("Guardar");
    private JButton LevelGbtn = new JButton("Guardar");


    public Armor_interface(){
        super("Crea tu armadura");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        setVisible(true);
    }
    private void initComponents(){
        Container c = getContentPane();
        c.setBackground(WINDOW_COLOR);
        c.setLayout(null);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Window mainInterface = new Main_Window();
                mainInterface.setVisible(true);
                dispose();
            }
        });
        backButton.setBounds(10,10,40,20);

        BackgroundIcon = new ImageIcon("C:/Users/arell/code/DataSetter/src/main/java/rcy/images/fondo_Armadura.png");
        BackgroundImage = new JLabel(BackgroundIcon);
        BackgroundImage.setBounds(0, 0, 800, 400);

        //Lista despegable material
        MaterialCmb.setBounds(157,200,136,27);
        MaterialCmb.setFont(FONT);
        MaterialCmb.setBackground(Color.decode("#1C1C1C"));
        //Lista despegable nivel
        LevelCmb.setBounds(504,200,136,27);
        LevelCmb.setFont(FONT);
        LevelCmb.setBackground(Color.decode("#1C1C1C"));

        MaterialGbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                material = (BasicArmorMaterials) MaterialCmb.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Material seleccionado: " + material);
            }
        });
        LevelGbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level = (Levels) LevelCmb.getSelectedItem();
                // Aquí puedes realizar cualquier acción adicional con el material seleccionado

                JOptionPane.showMessageDialog(null, "Nivel seleccionado: " + level);
            }
        });
        MaterialGbtn.setBounds(175,230,100,27);
        MaterialGbtn.setFont(FONT);
        LevelGbtn.setBounds(525,230,100,27);
        LevelGbtn.setFont(FONT);
        okbtn.setBounds(330,297,150,27);
        okbtn.setFont(FONT);
        okbtn.setBackground(Color.decode("#1C1C1C"));
        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MaterialCmb.setSelectedIndex(-1);
                    LevelCmb.setSelectedIndex(-1);
                    ArmorMaterials a = null;
                    switch (material){
                        case GOLD:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.GOLD;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.GOLD1;
                            else a = ArmorMaterials.GOLD2;
                            break;

                        case IRON:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.IRON;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.IRON1;
                            else a = ArmorMaterials.IRON2;
                            break;

                        case LEATHER:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.LEATHER;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.LEATHER1;
                            else a = ArmorMaterials.LEATHER2;
                            break;

                        case DIAMOND:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.DIAMOND;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.DIAMOND1;
                            else a = ArmorMaterials.DIAMOND2;
                            break;

                        case CHAIN:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.CHAIN;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.CHAIN1;
                            else a = ArmorMaterials.CHAIN2;
                            break;

                        case CITRINE:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.CITRINE;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.CITRINE1;
                            else a = ArmorMaterials.CITRINE2;
                            break;

                        case HOLY_EMERALD:
                            if (level == Levels.NIVEL1) a = ArmorMaterials.HOLY_EMERALD;
                            else if (level == Levels.NIVEL2) a = ArmorMaterials.HOLY_EMERALD1;
                            else a = ArmorMaterials.HOLY_EMERALD2;
                            break;
                    }
                    Armor.registerJson(a);
                    Armor.registerJava(a);

                } catch (IOException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
                Main_Window mainInterface = new Main_Window();
                mainInterface.setVisible(true);
                dispose();
            }
        });
        c.add(MaterialGbtn);
        c.add(LevelGbtn);
        c.add(okbtn);
        c.add(LevelCmb);
        c.add(MaterialCmb);
        c.add(backButton);
        c.add(BackgroundImage);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme");
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Armor_interface();
    }

    public BasicArmorMaterials getMaterial() {
        return material;
    }
}
