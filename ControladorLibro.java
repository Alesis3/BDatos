import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorLibro  extends MouseAdapter {
    private VentanaLibro view;
    private ModeloTablaLibro modelo;

    public ControladorLibro(VentanaLibro view) {
        this.view = view;
        modelo = new ModeloTablaLibro();
        this.view.getTblLibro().setModel(modelo);
        this.view.getBoton2().addMouseListener(this);
        this.view.getBoton().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== this.view.getBoton2()){

            modelo.cargarDatos();
            this.view.getTblLibro().setModel(modelo);
            this.view.getTblLibro().updateUI();
        }
        if(e.getSource()== this.view.getBoton()){
            Libro libro = new Libro();
            libro.setId(0);
            libro.setTitulo(this.view.getTxtTitulo().getText());
            libro.setAutor(This.view.getTxtAutor().getText());
            if(modelo.agregarLibro(libro)){
                JOptionPane.showMessageDialog(view,"se agrego", "aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblLibro().updateUI();
            }
            else{
                JOptionPane.showMessageDialog(view, " no se pudo agregar", "Error al insertar", JOptionPane.ERROR_MESSAGE);

            }
            this.view.limpiar();
        }
    }

}