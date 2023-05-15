package main.java.rcy.Interface;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Armor_Interface extends JFrame {
    public static final Color WINDOW_COLOR = new Color(28, 28, 28);
    public static final Font FONT = new Font("CHEWY", Font.BOLD, 15);
    private ImageIcon BackgroundIcon;
    private JLabel BackgroundImage;
    JButton backButton = new JButton("\u2190");
    /*public enum Material {NIVEL1, NIVEL2, NIVEL3};
    private JComboBox<Material> MaterialCmb = new JComboBox(Material.values());
    */
    public enum Durability { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Durability> DurabilityCmb = new JComboBox(Durability.values());
    public enum Tenacity { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Tenacity> TenacityCmb = new JComboBox(Tenacity.values());
    public enum Resistence { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Resistence> ResistenceCmb = new JComboBox(Resistence.values());
    public enum Helmet { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Helmet> helmetCmb = new JComboBox(Helmet.values());
    public enum Chest { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Chest> chestCmb = new JComboBox(Chest.values());
    public enum Pants { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Pants> pantsCmb = new JComboBox(Pants.values());
    public enum Boots { NIVEL1, NIVEL2, NIVEL3 };
    private JComboBox<Boots> bootsCmb = new JComboBox(Boots.values());
    private JButton okbtn = new JButton("Guardar");
    public Armor_Interface(){
        super("Crea tu armadura");
        setSize(800, 600);
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
            }
        });
        backButton.setBounds(10,10,50,50);

        URL location = getClass().getResource("/images/fondo_Armadura.png");
        BackgroundIcon = new ImageIcon(location);
        BackgroundImage = new JLabel(BackgroundIcon);
        BackgroundImage.setBounds(0, 0, 800, 600);

        //Lista despegable material (Por ver)
        /*MaterialCmb.setBounds(650,200,50,40);
        MaterialCmb.setFont(FONT);*/
        //Lista despegable durabilidad
        DurabilityCmb.setBounds(200, 200, 50, 40);
        DurabilityCmb.setFont(FONT);
        //Lista despegable tenacidad
        TenacityCmb.setBounds(375, 200, 50, 40);
        TenacityCmb.setFont(FONT);
        //Lista despegable tenacidad
        ResistenceCmb.setBounds(550, 200, 50, 40);
        ResistenceCmb.setFont(FONT);
        //Lista despegable casco
        helmetCmb.setBounds(140, 400, 50, 40);
        helmetCmb.setFont(FONT);
        //Lista despegable pechera
        chestCmb.setBounds(300, 400, 50, 40);
        chestCmb.setFont(FONT);
        //Lista despegable pantalones
        pantsCmb.setBounds(480, 400, 50, 40);
        pantsCmb.setFont(FONT);
        //Lista despegable botas
        bootsCmb.setBounds(650, 400, 50, 40);
        bootsCmb.setFont(FONT);

        okbtn.setBounds(325,500,139,43);
        okbtn.setFont(FONT);

        c.add(okbtn);
        c.add(bootsCmb);
        c.add(pantsCmb);
        c.add(chestCmb);
        c.add(helmetCmb);
        //c.add(MaterialCmb);
        c.add(ResistenceCmb);
        c.add(TenacityCmb);
        c.add(DurabilityCmb);
        c.add(backButton);
        c.add(BackgroundImage);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme");
        JFrame.setDefaultLookAndFeelDecorated(true);
        FlatLightLaf.install();
        new Armor_Interface();
    }
}
