package rcy.Interface;

import com.formdev.flatlaf.FlatLightLaf;
import rcy.minecraft.Armor;
import rcy.minecraft.BasicArmorMaterials;
import rcy.minecraft.Levels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Armor_interface extends JFrame {
    public static final Color WINDOW_COLOR = new Color(28, 28, 28);
    public static final Font FONT = new Font("CHEWY", Font.CENTER_BASELINE, 15);
    private ImageIcon BackgroundIcon;
    private JLabel BackgroundImage;
    JButton backButton = new JButton("\u2190");
    private JComboBox<BasicArmorMaterials> MaterialCmb = new JComboBox(BasicArmorMaterials.values());
    private JComboBox<Levels> LevelCmb = new JComboBox(Levels.values());
    private JButton okbtn = new JButton("Guardar");
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

        BackgroundIcon = new ImageIcon("C:/Users/Yochi/CODE/DataSetter/src/main/java/rcy/images/fondo_Armadura.png");
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

        okbtn.setBounds(350,297,100,27);
        okbtn.setFont(FONT);
        okbtn.setBackground(Color.decode("#1C1C1C"));

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
}
