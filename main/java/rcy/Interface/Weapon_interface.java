package main.java.rcy.Interface;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Weapon_interface extends JFrame {
    public static final Color WINDOW_COLOR = new Color(28, 28, 28);
    JButton backButton = new JButton("\u2190");
    private ImageIcon BackgroundIcon;
    private JLabel BackgroundImage;
    public static final Font FONT = new Font("CHEWY", Font.BOLD, 15);
    public enum weapon {A,B,C};
    private JComboBox<weapon> weaponCmb = new JComboBox(weapon.values());
    public enum level {A,B,C};
    private JComboBox<level> levelCmb = new JComboBox(level.values());
    public enum use {A,B,C};
    private JComboBox<use> useCmb = new JComboBox(use.values());
    public enum damage {A,B,C};
    private JComboBox<weapon> damageCmb = new JComboBox(damage.values());
    public enum speed {A,B,C};
    private JComboBox<weapon> speedCmb = new JComboBox(speed.values());
    public enum potion_level {A,B,C};
    private JComboBox<weapon> potion_levelCmb = new JComboBox(potion_level.values());
    public enum material {A,B,C};
    private JComboBox<material> materialCmb = new JComboBox(material.values());
    private JButton okbtn = new JButton("Guardar");
    public Weapon_interface(){
        super("Crea tu arma");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        //initMenu();
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
            }
        });
        backButton.setBounds(10,10,50,50);

        BackgroundIcon = new ImageIcon(getClass().getResource("/images/fondo_Arma.png"));
        BackgroundImage = new JLabel(BackgroundIcon);
        BackgroundImage.setBounds(0,0,800,600);
        //System.out.println(BackgroundIcon.getIconWidth());

        //Lista despegable arma
        weaponCmb.setBounds(170,250,50,40);
        weaponCmb.setFont(FONT);
        //Lista despegable nivel
        levelCmb.setBounds(375,250,50,40);
        levelCmb.setFont(FONT);
        //Lista despegable uso
        useCmb.setBounds(585,250,50,40);
        useCmb.setFont(FONT);
        //Lista despegable velocidad
        speedCmb.setBounds(170,400,50,40);
        speedCmb.setFont(FONT);
        //Lista despegable encantamiento valor
        potion_levelCmb.setBounds(375,400,50,40);
        potion_levelCmb.setFont(FONT);
        //Lista despegable daño
        damageCmb.setBounds(585,400,50,40);
        damageCmb.setFont(FONT);
        //Lista despegable material (Por ver)
        materialCmb.setBounds(650,400,50,40);
        materialCmb.setFont(FONT);

        okbtn.setBounds(325,500,139,43);
        okbtn.setFont(FONT);

        c.add(okbtn);
        c.add(weaponCmb);
        c.add(levelCmb);
        c.add(useCmb);
        c.add(damageCmb);
        c.add(speedCmb);
        c.add(potion_levelCmb);
        c.add(backButton);
        c.add(BackgroundImage);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme");
        JFrame.setDefaultLookAndFeelDecorated(true);
        FlatLightLaf.install();
        new Weapon_interface();
    }
}
