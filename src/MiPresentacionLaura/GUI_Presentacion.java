package MiPresentacionLaura ;


/* Usamos los mouse listener, botones y escuchas*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.util.Objects;
import java.lang.Override;


/**
 * Este es el programa de la presentación de Laura Murillas
 * Codigo: 201944153
 * Ultima actualizacion: 28/11
 *
 */
public class GUI_Presentacion extends JFrame {
    /**Aqui van los atributos de la parte grafica, o sea la ventana*/

    private JButton fotoLaura, hobbyLaura, expectativasLaura;
    private Header headerProject;

    /**El JPanel es como un contenedor de objetos*/
    private JPanel panelMouse;
    private JPanel panelBotones, panelDatos;
    private JTextArea mensajes;
    private Escucha escucha;
    private JLabel labelImage;
    private JTextArea textoExpectativa;
    private ImageIcon imagen1;
    private ImageIcon imagen2;
   // private Titulos titulo;





    /**
     * Este es el constructor de la clase GUI . Estos son los metodos
     */
    public GUI_Presentacion(){
        initGUI();

        /*Aqui van la configuracion de la ventana*/

        this.setTitle("Presentacion de Laura"); //Titulo
        this.pack();
        this.setSize(1340,720);
        //this.setResizable(true); //Tamaño automatico
        this.setVisible(true);  //Que se vea la ventana
        this.setLocationRelativeTo(null);
        //Esto es para no relacionar la ventana con ningun componente y la deja centrada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Este es el boton de salida
    }



    /**
     *Este método se utiliza para configurar la configuración predeterminada de JComponent
     *  crear Listener y controlar los objetos utilizados para la clase GUI.
     */
    private void initGUI() {
        //Pasos:
        //Se debe definir el container y el layout del JFrame
        //Crear los objetos escucha y controles
        //Configurar elos JComponentes
        //Aqui se empieza a armar la ventada

        escucha = new Escucha();
        //Los JComponents

        headerProject = new Header("Mi nombre es Laura ¡Conoceme vé!", Color.BLACK);
        //El metodo add adiciona las cosas a la ventana
        this.add(headerProject,BorderLayout.NORTH); //Diseño del contenedor Frame

        panelDatos= new JPanel();
        //panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poquito de mi...", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.PLAIN, Color.BLACK))); //Para darle borde al texto

        fotoLaura = new JButton("Mi foto");
        fotoLaura.addActionListener(escucha);
        fotoLaura.setVisible(true);
        //Esto hace que se vean los botones en la pantalla :D
        this.add(fotoLaura,BorderLayout.WEST);


        hobbyLaura = new JButton("Mi Hobby es");
        hobbyLaura.addActionListener(escucha);
        hobbyLaura.setVisible(true);
        this.add(hobbyLaura,BorderLayout.CENTER);


        expectativasLaura= new JButton("Mis expectativas son");
        expectativasLaura.setText("Mis expectativas son");
        expectativasLaura.addActionListener(escucha);
        expectativasLaura.setVisible(true);
        this.add(expectativasLaura,BorderLayout.EAST);

        textoExpectativa = new JTextArea(10,12);
        this.add(textoExpectativa,BorderLayout.CENTER);




        //Aqui se ponen los botones
        panelBotones = new JPanel();
        panelBotones.add(fotoLaura);
        panelBotones.add(hobbyLaura);
        panelBotones.add(expectativasLaura);
     //   panelBotones.addKeyListener(escucha);
        panelBotones.setFocusable(true);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImage = new JLabel();

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addMouseMotionListener(escucha);
      //panelMouse.addKeyListener(escucha);
        panelMouse.setFocusable(true);
        panelMouse.setBackground(Color.BLUE);
        panelMouse.setPreferredSize(new Dimension(600,120));

        mensajes = new JTextArea(7,3);
        mensajes.setEditable(true);
        //JScrollPane scroll = new JScrollPane(mensajes);

        add(labelImage,BorderLayout.CENTER);
        //add(scroll,BorderLayout.SOUTH);
    }

    /**
      Este es el metodo main. Por aqui arranca el programa
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI_Presentacion MiPresentacionLauraGUI = new GUI_Presentacion();
        });
    }
//El args es un nombre que se usa como acuerdo entre programadores
// Este objeto es el que hace la cola de eventos, muy importante



    /**
     La clase escucha, es lo principal de la programacion orientada a eventos, escucha lo que el usuario hace en el programa
     Esto nos dice sobre que boton estan dando click
     */

    private class Escucha implements ActionListener, MouseListener, MouseMotionListener {

        @Override

        public void actionPerformed(ActionEvent e) {
            //Aqui introduzco que quiero que hagan cuando toquen los botones
            //JOptionPane.showMessageDialog(null,"Oprimiste el boton"); //Este es un ejemplo de sacar una ventana cuando oprimen un boton


            //Este carga la imagen que se va a mostrar

            if(e.getSource()==fotoLaura){
                //image = new ImageIcon(getClass().getResource("src/MiPresentacionLaura/Recursos/yo.jpg"));
                //labelImage.setIcon(image);
                 //panelMouse.setBackground(Color.CYAN);
                 labelImage.addMouseListener(this);
                 labelImage.setIcon(new ImageIcon("src/MiPresentacionLaura/Recursos/yo.jpg"));
                 labelImage.setVisible(true);

                 imagen1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("src/MiPresentacionLaura/Recursos/yo.jpg")));
                 panelDatos.add(labelImage, BorderLayout.CENTER);
                 panelBotones.add(labelImage,BorderLayout.SOUTH);


            }else{
                if(e.getSource()== hobbyLaura){
                    labelImage.addMouseListener(this);
                    labelImage.setIcon(new ImageIcon("src/MiPresentacionLaura/Recursos/logo.png"));
                    labelImage.setVisible(true);
                    panelDatos.add(labelImage, BorderLayout.CENTER);
                    panelBotones.add(labelImage,BorderLayout.SOUTH);
                    imagen2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("MiPresentacionLaura/Recursos/logo.png")));


                }else{
                    JOptionPane.showMessageDialog(null,"¡Espero aprender mucho de JAVA!");

                    textoExpectativa.setText("¡Espero aprender mucho de Java!" +
                            "quiero aprender a programar adecuadamente");
                    //textoExpectativa.setBackground(Color.blue);
                    //textoExpectativa.setFont(new Font(Font.MONOSPACED, Font.BOLD+
                      //      Font.ITALIC, 200));
                    //textoExpectativa.setVisible(true);
                    panelDatos.add(textoExpectativa);

                }

            }
            revalidate();  //Para validar que las imagenes esten correctas
            repaint();
        }


        @Override
        public void mouseClicked(MouseEvent e) {

            panelMouse.setBackground(Color.CYAN);
            mensajes.append("mouseClicked was detected \n");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            panelMouse.setBackground(Color.pink);
            mensajes.append("mousePressed was detected \n");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            panelMouse.setBackground(Color.BLACK);
            mensajes.append("mouseReleased was detected \n");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panelMouse.setBackground(Color.GRAY);
            mensajes.append("mouseEntered was detected \n");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panelMouse.setBackground(Color.YELLOW);
            mensajes.append("mouseExited was detected \n");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mensajes.append("mouseDragged was detected \n"+
                    "Mouse position x = "+e.getX()+" Mouse position y = "+e.getY()+"\n");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mensajes.append("mouseMoved was detected \n"+
                    "Mouse position x = "+e.getX()+" Mouse position y = "+e.getY()+"\n");
        }

       // @Override
        //public void keyTyped(KeyEvent e) {
        //    mensajes.append("keyTyped was detected \n"+
        //            "Tecla alfa numérica = "+e.getKeyChar()+"\n");
        //}

        //@Override
        //public void keyPressed(KeyEvent e) {
        //    mensajes.append("keyTyped was detected \n"+
        //            "Tecla = "+e.getKeyChar()+"\n");
        //}

        //@Override
        //public void keyReleased(KeyEvent e) {
        //    mensajes.append("keyReleased was detected \n"+
        //            "Tecla = "+e.getKeyChar()+"\n");
        //}
    }

}
