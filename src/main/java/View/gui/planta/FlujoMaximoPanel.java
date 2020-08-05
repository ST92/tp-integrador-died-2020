package View.gui.planta;

import View.controller.PlantaController;

import javax.swing.*;
import java.awt.*;

public class FlujoMaximoPanel extends JPanel {

    private JLabel lblTitulo = new JLabel("Gestión de Rutas - Flujo Máximo: ");
    private JLabel lblSubtitulo1 = new JLabel("Calcular Flujo Máximo: ");
    private JLabel lblSubtitulo2 = new JLabel("Agregar Ruta: ");

    private JLabel lblOrigen = new JLabel("Planta Origen:");
    private JComboBox<String> txtOrigen;
    private JLabel lblDestino = new JLabel("Planta Destino:");
    private JComboBox<String> txtDestino;

    private JButton btnFlujoMax;
    private JButton btnAgregarRuta;
    private JButton btnCancelar;

    //Flujo Máximo:
    private JLabel lblFlujoMax = new JLabel("Flujo Máximo (Kg):");
    private JTextField txtValorFlujo;
    //TODO Ver si agregar una lista o no.

    //Ruta:
    private JLabel lblDistancia = new JLabel("Distancia entre Plantas: (Km)");
    private JTextField txtDistancia;
    private JLabel lblHoras = new JLabel("Duración del Viaje: (Horas)");
    private JTextField txtHoras;
    private JLabel lblPeso = new JLabel("Peso Máximo de Transporte: (Kg/Dia)");
    private JTextField txtPeso;
    private JButton btnAgregar;

    private PlantaController controller;

    private GridBagConstraints constraintsTitulos = new GridBagConstraints();
    private GridBagConstraints constraintsSubtitulos = new GridBagConstraints();
    private GridBagConstraints constraintsLabels = new GridBagConstraints();
    private GridBagConstraints constraintsTextfields = new GridBagConstraints();
    private GridBagConstraints constraintsBotones = new GridBagConstraints();

    public FlujoMaximoPanel() {
        super();
        this.controller = PlantaController.getPlantaController();
        this.armarPanel();
    }

    private void armarPanel() {

        //Agrega un Layout
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);

        constraintsTitulos.fill = GridBagConstraints.VERTICAL;
        constraintsTitulos.anchor = GridBagConstraints.CENTER;
        constraintsTitulos.gridwidth=5;
        constraintsTitulos.insets = new Insets(0, 0, 15, 0);


        constraintsSubtitulos.gridwidth=5;
        constraintsSubtitulos.weightx=1.0; //Estira a lo largo, es decir, estira en columnas una misma fila
        constraintsSubtitulos.weighty=(double)(1/16);
        constraintsSubtitulos.insets = new Insets(10, 10, 10, 0);
        constraintsSubtitulos.fill = GridBagConstraints.HORIZONTAL;


        constraintsLabels.gridwidth = 1;
        constraintsLabels.weightx=0.12; //
        constraintsLabels.weighty=0;
        constraintsLabels.gridheight=1;
        constraintsLabels.insets = new Insets(5, 5, 5, 5); //-> Este determina la separación entre objetos.
        constraintsLabels.ipadx = 5;
        constraintsLabels.ipady=5;
        constraintsLabels.fill = GridBagConstraints.NONE;
        constraintsLabels.anchor = GridBagConstraints.LINE_END;


        constraintsTextfields.gridwidth = 1;
        constraintsTextfields.weightx=0.12; //
        constraintsTextfields.weighty=0;
        constraintsTextfields.gridheight=1;
        constraintsTextfields.insets = new Insets(5, 5, 5, 5); //-> Este determina la separación entre objetos.
        constraintsTextfields.ipadx = 5;
        constraintsTextfields.ipady=5;
        constraintsTextfields.anchor = GridBagConstraints.LINE_START;
        constraintsTextfields.fill = GridBagConstraints.HORIZONTAL;

        constraintsBotones.anchor = GridBagConstraints.LINE_END;
        constraintsBotones.fill = GridBagConstraints.NONE;
        constraintsBotones.insets = new Insets(20, 15, 15, 0);



        //Titulo
        constraintsTitulos.gridx = 0;
        constraintsTitulos.gridy = 0;
        lblTitulo.setFont(new Font("System", Font.BOLD, 20));
        lblTitulo.setForeground(Color.BLACK);
        this.add(lblTitulo,constraintsTitulos);


        //Subtitulo: Calcular Flujo Máximo
        constraintsSubtitulos.gridx = 0; //Columna 0
        constraintsSubtitulos.gridy = 1; //Fila 2
        lblSubtitulo1.setFont(new Font("Calibri", Font.BOLD, 15));
        lblSubtitulo1.setForeground(Color.BLACK);
        this.add(lblSubtitulo1,constraintsSubtitulos);


        //Label Planta Origen
        constraintsLabels.gridx = 0;
        constraintsLabels.gridy = 2;
        constraintsLabels.insets = new Insets(5, 15, 5, 0);
        lblOrigen.setPreferredSize(new Dimension(100, 17));
        lblOrigen.setFont(new Font("System", Font.PLAIN, 13));
        this.add(lblOrigen,constraintsLabels);

        constraintsTextfields.insets = new Insets(5, 5, 5, 5);


        //ComboBox Planta Origen
        constraintsTextfields.gridx = 1; //Va al lado del Label
        constraintsTextfields.gridy = 2;
        String[] plantas = this.controller.getPlantas();
        this.txtOrigen = new JComboBox<String>(plantas);
        this.txtOrigen.setPreferredSize(new Dimension(300, 20));
        this.add(txtOrigen,constraintsTextfields);


        //Label Planta Destino
        constraintsLabels.gridx = 2;
        constraintsLabels.gridy = 2;
        this.lblDestino.setPreferredSize(new Dimension(100, 17));
        this.lblDestino.setFont(new Font("System", Font.PLAIN, 13));
        this.add(lblDestino,constraintsLabels);

        //ComboBox Planta Destino
        constraintsTextfields.gridx = 3; //Va al lado del Label
        constraintsTextfields.gridy = 2;
        constraintsTextfields.fill = GridBagConstraints.HORIZONTAL;
        constraintsTextfields.insets = new Insets(5, 15, 5, 20);
        this.txtDestino= new JComboBox<String>(plantas); //plantas está definido en ComboBox Planta Origen
        this.txtDestino.setPreferredSize(new Dimension(300, 20));
        this.add(txtDestino,constraintsTextfields);

        constraintsTextfields.insets = new Insets(5, 5, 5, 5);

        //Botón Calcular Flujo Máximo
        constraintsBotones.gridx = 2;
        constraintsBotones.gridy = 3;
        this.btnFlujoMax = new JButton("Flujo Máximo");
        this.btnFlujoMax.setPreferredSize(new Dimension(120,25));
        this.btnFlujoMax.addActionListener(e-> {
            //TODO Invocar al controller para que calcule el flujo maximo
//		this.btnAgregar.addActionListener( e ->
//			{
//				try {
//					controller.guardar();
//				} catch (DatosObligatoriosException | FormatoNumeroException | ControllerException e1) {
//					this.mostrarError("Error al guardar", e1.getMessage());
//				}
//				this.limpiarFormulario();
//				modeloTablaCamion.fireTableDataChanged();
//
			}
        );
        this.add(btnFlujoMax,constraintsBotones);

        //Botón Agregar Nueva Ruta
        constraintsBotones.gridx = 3;
        constraintsBotones.gridy = 3;
        constraintsBotones.anchor = GridBagConstraints.LINE_START;
        constraintsBotones.insets = new Insets(20, 10, 15, 0);
        this.btnAgregarRuta = new JButton("Agregar Ruta");
        this.btnAgregarRuta.setPreferredSize(new Dimension(120,25));
        this.btnAgregarRuta.addActionListener(e-> {

            armarPantallaAgregarRuta();
//		this.btnAgregar.addActionListener( e ->
//			{
//				try {
//					controller.guardar();
//				} catch (DatosObligatoriosException | FormatoNumeroException | ControllerException e1) {
//					this.mostrarError("Error al guardar", e1.getMessage());
//				}
//				this.limpiarFormulario();
//				modeloTablaCamion.fireTableDataChanged();
//
                }
        );
        this.add(btnAgregarRuta,constraintsBotones);

        //Botón Cancelar
        constraintsBotones.gridx = 3;
        constraintsBotones.gridy = 3;
        constraintsBotones.anchor = GridBagConstraints.CENTER;
        constraintsBotones.insets = new Insets(20, 15, 15, 0);
        this.btnCancelar = new JButton("Cancelar");
        this.btnCancelar.setPreferredSize(new Dimension(120,25));
        this.btnCancelar.addActionListener(e-> {

            limpiarFormulario();
//		this.btnAgregar.addActionListener( e ->
//			{
//				try {
//					controller.guardar();
//				} catch (DatosObligatoriosException | FormatoNumeroException | ControllerException e1) {
//					this.mostrarError("Error al guardar", e1.getMessage());
//				}
//				this.limpiarFormulario();
//				modeloTablaCamion.fireTableDataChanged();
//
                }
        );
        this.add(btnCancelar,constraintsBotones);

        //Flujo Máximo:
        //Label Flujo Máximo:
        constraintsLabels.gridx = 0;
        constraintsLabels.gridy = 3;
        this.lblFlujoMax.setPreferredSize(new Dimension(120, 17));
        this.lblFlujoMax.setFont(new Font("System", Font.BOLD, 13));
        this.add(lblFlujoMax,constraintsLabels);


        //TextField Valor Flujo Máximo
        constraintsTextfields.gridx = 1; //Va al lado del Label
        constraintsTextfields.gridy = 3;
        this.txtValorFlujo = new JTextField();
        this.txtValorFlujo.setPreferredSize(new Dimension(300, 20));
        this.txtValorFlujo.setEditable(false);
        this.add(txtValorFlujo,constraintsTextfields);


        //Subtitulo "Rutas"
        constraintsSubtitulos.gridx = 0; //Columna 0
        constraintsSubtitulos.gridy = 5; //Fila 2
        lblSubtitulo2.setFont(new Font("Calibri", Font.BOLD, 15));
        lblSubtitulo2.setForeground(Color.BLACK);
        this.add(lblSubtitulo2,constraintsSubtitulos);
        lblSubtitulo2.setVisible(false);

        //Label Distancia entre plantas
        constraintsLabels.gridx = 0;
        constraintsLabels.gridy = 6;
        constraintsLabels.insets = new Insets(5, 15, 5, 0);
        this.lblDistancia.setPreferredSize(new Dimension(200, 17));
        this.lblDistancia.setFont(new Font("System", Font.PLAIN, 13));
        this.add(lblDistancia,constraintsLabels);
        this.lblDistancia.setVisible(false);

        constraintsLabels.insets = new Insets(5, 5, 5, 0);

        //TextField Distancia entre plantas
        constraintsTextfields.gridx = 1;
        constraintsTextfields.gridy = 6;
        this.txtDistancia = new JTextField(0);
        this.txtDistancia.setPreferredSize(new Dimension(200, 20));
        this.add(txtDistancia,constraintsTextfields);
        this.txtDistancia.setVisible(false);

        //Label Duración viaje
        constraintsLabels.gridx = 0;
        constraintsLabels.gridy = 7;
        this.lblHoras.setPreferredSize(new Dimension(170, 17));
        this.lblHoras.setFont(new Font("System", Font.PLAIN, 13));
        this.add(lblHoras,constraintsLabels);
        this.lblHoras.setVisible(false);

        //TextField Duración de viaje
        constraintsTextfields.gridx = 1;
        constraintsTextfields.gridy = 7;
        this.txtHoras = new JTextField(0);
        this.txtHoras.setPreferredSize(new Dimension(200, 20));
        this.add(txtHoras,constraintsTextfields);
        this.txtHoras.setVisible(false);

        //Label Peso Máximo
        constraintsLabels.gridx = 0;
        constraintsLabels.gridy = 8;
        this.lblPeso.setPreferredSize(new Dimension(220, 17));
        this.lblPeso.setFont(new Font("System", Font.PLAIN, 13));
        this.add(lblPeso,constraintsLabels);
        this.lblPeso.setVisible(false);

        //TextField Duración de viaje
        constraintsTextfields.gridx = 1;
        constraintsTextfields.gridy = 8;
        this.txtPeso = new JTextField(0);
        this.txtPeso.setPreferredSize(new Dimension(200, 20));
        this.add(txtPeso,constraintsTextfields);
        this.txtPeso.setVisible(false);

        //Botón Agregar Ruta
        constraintsBotones.gridx = 1;
        constraintsBotones.gridy = 9;
        constraintsBotones.anchor = GridBagConstraints.LINE_END;
        this.btnAgregar = new JButton("Agregar");
        this.btnAgregar.setPreferredSize(new Dimension(105,25));
        this.add(btnAgregar,constraintsBotones);
        this.btnAgregar.setVisible(false);


    }

    private void armarPantallaAgregarRuta(){

        this.lblSubtitulo2.setVisible(true);
        this.lblDistancia.setVisible(true);
        this.txtDistancia.setVisible(true);
        this.lblHoras.setVisible(true);
        this.txtHoras.setVisible(true);
        this.lblPeso.setVisible(true);
        this.txtPeso.setVisible(true);
        this.btnAgregar.setVisible(true);

    }

    public void mostrarError(String titulo,String detalle) {
        JFrame padre= (JFrame) SwingUtilities.getWindowAncestor(this);
        JOptionPane.showMessageDialog(padre,
                detalle,titulo,
                JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarFormulario() {

        this.txtDistancia.setText("");
        this.txtHoras.setText("");
        this.txtPeso.setText("");
        this.txtOrigen.setSelectedIndex(0);
        this.txtDestino.setSelectedIndex(0);

        this.lblSubtitulo2.setVisible(false);
        this.lblDistancia.setVisible(false);
        this.txtDistancia.setVisible(false);
        this.lblHoras.setVisible(false);
        this.txtHoras.setVisible(false);
        this.lblPeso.setVisible(false);
        this.txtPeso.setVisible(false);
        this.btnAgregar.setVisible(false);

    }

}