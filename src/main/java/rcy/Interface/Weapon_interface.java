package rcy.Interface;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

import rcy.minecraft.BasicArmorMaterials;
import rcy.minecraft.Tool;
import rcy.minecraft.Weapon;
import rcy.minecraft.WeaponMaterials;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Weapon_interface extends JFrame {
    public static final Color  WINDOW_COLOR = new Color(28, 28, 28);
    JButton backButton = new JButton("\u2190");
    private ImageIcon BackgroundIcon;
    private JLabel BackgroundImage;
    public static final Font FONT = new Font("CHEWY", Font.CENTER_BASELINE, 15);
    private JComboBox<WeaponMaterials> materialCmb = new JComboBox(WeaponMaterials.values());
    private JComboBox<Tool> weaponCmb = new JComboBox(Tool.values());
    SpinnerNumberModel damagelimit = new SpinnerNumberModel(1, 1, 10, 1);
    private JSpinner damageSpr = new JSpinner(damagelimit);
    SpinnerNumberModel speedlimit = new SpinnerNumberModel(1.0, 1.0, 10.0, 0.1);
    private JSpinner SpeedSpr = new JSpinner(speedlimit);
    private JButton okbtn = new JButton("Guardar todo");
    private JButton MaterialGbtn = new JButton("Guardar");
    private JButton WeaponGbtn = new JButton("Guardar");
    private JButton damageGbtn = new JButton("Guardar");
    private JButton speedGbtn = new JButton("Guardar");

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

        BackgroundIcon = new ImageIcon("C:/Users/arell/code/DataSetter/src/main/java/rcy/images/fondo_Arma.png");
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
        MaterialGbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeaponMaterials material = (WeaponMaterials) materialCmb.getSelectedItem();
                // Aquí puedes realizar cualquier acción adicional con el material seleccionado

                JOptionPane.showMessageDialog(null, "Material seleccionado: " + material);
            }
        });

        WeaponGbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tool tool = (Tool) weaponCmb.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Arma seleccionada: " + tool);
            }
        });

        damageGbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int damage = (int) damageSpr.getValue();
                // Aquí puedes realizar cualquier acción adicional con el daño seleccionado

                JOptionPane.showMessageDialog(null, "Daño seleccionado: " + damage);
            }
        });

        speedGbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double speed = (double) SpeedSpr.getValue();
                // Aquí puedes realizar cualquier acción adicional con la velocidad seleccionada

                JOptionPane.showMessageDialog(null, "Velocidad seleccionada: " + speed);
            }
        });
        MaterialGbtn.setBounds(92,210,100,27);
        MaterialGbtn.setFont(FONT);
        WeaponGbtn.setBounds(262,210,100,27);
        WeaponGbtn.setFont(FONT);
        damageGbtn.setBounds(432,210,100,27);
        damageGbtn.setFont(FONT);
        speedGbtn.setBounds(602,210,100,27);
        speedGbtn.setFont(FONT);
        okbtn.setBounds(330,297,150,27);
        okbtn.setFont(FONT);

        /*damageSpr.setValue(-1);
        SpeedSpr.setValue(-1);*/

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeaponMaterials material = (WeaponMaterials) materialCmb.getSelectedItem();
                Tool tool = (Tool) weaponCmb.getSelectedItem();
                int damage = (int) damageSpr.getValue();
                double speed = (double) SpeedSpr.getValue();

                try {
                    Weapon.registerJava(material, tool, damage, (float) speed);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Main_Window mainInterface = new Main_Window();
                mainInterface.setVisible(true);
                dispose();
            }
        });
        c.add(MaterialGbtn);
        c.add(WeaponGbtn);
        c.add(damageGbtn);
        c.add(speedGbtn);
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
