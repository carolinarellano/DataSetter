package rcy.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main_Window extends JFrame {

    public static final Color  WINDOW_COLOR = new Color(28, 28, 28);
    public static final Font   BUTTON_FONT  = new Font("CHEWY", Font.BOLD, 15);
    private ImageIcon titleIcon;
    private JLabel titleImage;
    private JButton weaponBtn = new JButton("Crear arma");
    private JButton armorBtn = new JButton("Crear armadura");
    private JButton testingBtn = new JButton("Testing");


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
        titleIcon = new ImageIcon(getClass().getResource("images/fondo.png"));
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
        testingBtn.setBounds(550,480,139,43);
        testingBtn.setFont(BUTTON_FONT);

        //Abrir minecraft
        testingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("Terminal");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        /*armorCmb.setBounds(100, 70, 200, 40);
        armorCmb.setFont(BUTTON_FONT);
        okBtn.setBounds(100, 130, 200, 50);
        okBtn.setMnemonic('S');
        okBtn.setFont(BUTTON_FONT);
        c.add(okBtn);
        c.add(armorCmb);*/
        armorBtn.addActionListener(e -> {
            Armor_Interface armor_Interface = new Armor_Interface();
            armor_Interface.setVisible(true);
        });
        weaponBtn.addActionListener(e -> {
            Weapon_interface weapon_Interface = new Weapon_interface();
            weapon_Interface.setVisible(true);
        });
        c.add(weaponBtn);
        c.add(armorBtn);
        c.add(testingBtn);
        c.add(titleImage);
    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme");
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Main_Window();
    }

}
