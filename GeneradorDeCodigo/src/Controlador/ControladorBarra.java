package Controlador;

import Vista.Generador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorBarra implements ActionListener, KeyListener {

    private Generador generador;

    public ControladorBarra(Generador generador) {
        this.generador = generador;
        this.generador.txt_cantidad.addKeyListener(this);
        this.generador.btn_generar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generador.btn_generar) {
            int proveedor1 = 10;
            int proveedor2 = 11;
            int proveedor3 = 12;
            int categoria1 = 20;
            int categoria2 = 21;
            int categoria3 = 22;
            int categoria4 = 23;
            int categoria5 = 24;
            int categoria6 = 25;
            int categoria7 = 26;
            String proveedor = generador.cmb_proveedor.getSelectedItem().toString();
            int pro = 0;
            String categoria = generador.cmb_categoria.getSelectedItem().toString();
            int cat = 0;

            switch (proveedor) {
                case "Quesos y Cosas" ->
                    pro = proveedor1;
                case "Laurent" ->
                    pro = proveedor2;
                case "Fiambres" ->
                    pro = proveedor3;
            }
            switch (categoria) {
                case "Queso Cremoso" ->
                    cat = categoria1;
                case "Papas Sueltas" ->
                    cat = categoria2;
                case "Mani Sueltos" ->
                    cat = categoria3;
                case "Palitos Sueltos" ->
                    cat = categoria4;
                case "Chizitos Sueltos" ->
                    cat = categoria5;
                case "Pororos Sueltos" ->
                    cat = categoria6;
                case "Fiambres" ->
                    cat = categoria7;
            }
            int cantidad = Integer.parseInt(generador.txt_cantidad.getText());
            double total = Double.parseDouble(generador.txt_precioVenta.getText());
            int random = (int) (Math.random() * 10000000 + 1);

            generador.txt_codigoDeBarra.setText("" + pro + cat + cantidad + random);
            generador.jLabelNombre.setText(categoria);
            generador.txt_precioFinal.setText(String.format("%.2f", total).replace(",", "."));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == generador.txt_cantidad) {
            int cantidad = 0;
            double precio = 0.0;

            cantidad = Integer.parseInt(generador.txt_cantidad.getText());
            precio = Double.parseDouble(generador.txt_precioxkg.getText());
            generador.txt_precioVenta.setText("" + cantidad * precio);
        }
    }

}
