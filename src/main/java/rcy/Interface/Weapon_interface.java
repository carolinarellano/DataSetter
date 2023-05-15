package rcy.Interface;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

import rcy.minecraft.Tool;
import rcy.minecraft.Weapon;
import rcy.minecraft.WeaponMaterials;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Weapon_interface extends JFrame {
    public static final Color  WINDOW_COLOR = new Color(28, 28, 28);
    JButton backButton = new JButton("\u2190");
    private ImageIcon BackgroundIcon;
    private JLabel BackgroundImage;
    public static final Font FONT = new Font("CHEWY", Font.CENTER_BASELINE, 15);
    private JComboBox<WeaponMaterials> materialCmb = new JComboBox(WeaponMaterials.values());
    String selectedMaterial = (String) materialCmb.getSelectedItem();
    private JComboBox<Tool> weaponCmb = new JComboBox(Tool.values());
    SpinnerNumberModel damagelimit = new SpinnerNumberModel(1, 1, 10, 1);
    private JSpinner damageSpr = new JSpinner(damagelimit);
    SpinnerNumberModel speedlimit = new SpinnerNumberModel(1.0, 1.0, 10.0, 0.1);
    private JSpinner SpeedSpr = new JSpinner(speedlimit);

    private JButton okbtn = new JButton("Guardar");

    public Weapon_interface(){
        super("Crea tu arma");
        setSize(800, 400);
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
                dispose();
            }
        });
        backButton.setBounds(10,10,40,20);

        BackgroundIcon = new ImageIcon("C:/Users/Yochi/CODE/DataSetter/src/main/java/rcy/images/fondo_Arma.png");
        BackgroundImage = new JLabel(BackgroundIcon);
        BackgroundImage.setBounds(0,0,800,400);
        //System.out.println(BackgroundIcon.getIconWidth());

        //Lista despegable material
        materialCmb.setBounds(73,180,136,27);
        materialCmb.setFont(FONT);
        //Lista despegable arma
        weaponCmb.setBounds(245,180,136,27);
        weaponCmb.setFont(FONT);
        //Lista despegable daño
        damageSpr.setBounds(417,180,136,27);
        damageSpr.setFont(FONT);
        //Lista despegable velocidad
        SpeedSpr.setBounds(589,180,136,27);
        SpeedSpr.setFont(FONT);

        okbtn.setBounds(350,297,100,27);
        okbtn.setFont(FONT);
        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Weapon weapon = new Weapon();
                weapon.registerJava(materialCmb,weaponCmb,damageSpr,SpeedSpr);
                dispose();
            }
        });

        c.add(okbtn);
        c.add(materialCmb);
        c.add(weaponCmb);
        c.add(damageSpr);
        c.add(SpeedSpr);
        c.add(backButton);
        c.add(BackgroundImage);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme");
        JFrame.setDefaultLookAndFeelDecorated(true);
        //FlatLightLaf.install();
        new Weapon_interface();
    }
}
