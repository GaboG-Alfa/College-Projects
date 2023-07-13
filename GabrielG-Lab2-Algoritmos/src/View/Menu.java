package View;

import Controller.Validar;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    private String formula;
    private Validar balancear;
    private JButton opcionA, exit; // Botones de mostrar y salir
    private boolean balanceo;

    public Menu() {
        super("Balanceador de fórmulas");

        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

        opcionA = new JButton("Ingresar otra fórmula");

        exit = new JButton("Salir");
        add(opcionA);
        add(exit);

        //Instanciar balanceo
        balancear = new Validar();

        formula = JOptionPane.showInputDialog(null, "Ingrese la fórmula: ", "Fórmula a balancear",
                JOptionPane.INFORMATION_MESSAGE);

        balanceo = balancear.recorrerString(formula);

        JOptionPane.showMessageDialog(null, "La fórmula está balanceada? : " + balanceo, "Resultados del balanceo de fórmula", JOptionPane.INFORMATION_MESSAGE);

        // Programamos los Listener de cada Boton
        opcionA.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {

                balancear.vaciarPila();
                balanceo=false;

                formula = JOptionPane.showInputDialog(null, "Ingrese la fórmula: ", "Fórmula",
                        JOptionPane.INFORMATION_MESSAGE);

                balanceo = balancear.recorrerString(formula);

                JOptionPane.showMessageDialog(null, "La fórmula está balanceada? : " + balanceo, "Resultados del balanceo de fórmula", JOptionPane.INFORMATION_MESSAGE);

            }

        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                JOptionPane.showMessageDialog(null, "Saldra de la aplicacion", "WARNING", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        });

    }

    // Metodo main()
    public static void main(String args[]) {
        Menu listen = new Menu();
        listen.setLocationRelativeTo(null);
        listen.setSize(300, 175);
        listen.setVisible(true);
    }

}
