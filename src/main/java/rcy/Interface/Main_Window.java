package rcy.Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Main_Window extends JFrame {

    public static final Color  WINDOW_COLOR = new Color(28, 28, 28);
    public static final Font   BUTTON_FONT  = new Font("CHEWY", Font.BOLD, 15);
    private ImageIcon titleIcon;
    private JLabel titleImage;
    private JButton weaponBtn = new JButton("Crear arma");
    private JButton armorBtn = new JButton("Crear armadura");


    public Main_Window() {
        super("MineCreator");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        //initMenu();
        setVisible(true);
    }
    private void initComponents() {
        titleIcon = new ImageIcon("C:/Users/arell/code/DataSetter/src/main/java/rcy/images/fondo.png");
        titleImage = new JLabel(titleIcon);
        titleImage.setBounds(0,0,800,600);
        System.out.println(titleIcon.getIconWidth());

        Container c = getContentPane();
        c.setBackground(WINDOW_COLOR);
        c.setLayout(null);

        weaponBtn.setBounds(550,159,139,43);
        weaponBtn.setFont(BUTTON_FONT);
        armorBtn.setBounds(540,238,155,43);
        armorBtn.setFont(BUTTON_FONT);

        armorBtn.addActionListener(e -> {
            Armor_interface armorInterface = new Armor_interface();
            armorInterface.setVisible(true);
            dispose();
        });
        weaponBtn.addActionListener(e -> {
            Weapon_interface weaponInterface = new Weapon_interface();
            weaponInterface.setVisible(true);
            dispose();
        });
        c.add(weaponBtn);
        c.add(armorBtn);
        c.add(titleImage);
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme");
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Main_Window();
    }

}
