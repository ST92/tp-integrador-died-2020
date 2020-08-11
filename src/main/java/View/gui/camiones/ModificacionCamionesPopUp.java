package View.gui.camiones;

import View.guiController.CamionGuiController;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ModificacionCamionesPopUp extends JFrame {
	
	
	//Titulos
	private JLabel lblTitulo = new JLabel("Modificación de Camiones:");
	private JLabel lblSubtitulo = new JLabel("Modificar Camión:");
	
	//Campos
	private JLabel lblPatente = new JLabel("Patente:");
	private JTextField txtPatente;
	private JLabel lblModelo = new JLabel("Modelo:");
	private JTextField txtModelo;
	private JLabel lblMarca = new JLabel("Marca:");
	private JTextField txtMarca;
	private JLabel lblFecha = new JLabel("Fecha de Compra: \n  (DD/MM/YYYY)");
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JFormattedTextField txtFechaCompra = new JFormattedTextField(df);	
	private JLabel lblKm = new JLabel("Km Recorridos:");
	private JTextField txtKm;
	private JLabel lblCostoKm = new JLabel("Costo por KM: ");
	private JTextField txtCostoKm;
	private JLabel lblCostoHs = new JLabel("Costo por Hora: ");
	private JTextField txtCostoHs;
	private JButton btnAceptar;
	private JButton btnCancelar;

	//Errores
	private JLabel lblErrorPatente = new JLabel("Campo Alfanumérico y Obligatorio.");
	private JLabel lblErrorModelo = new JLabel("Campo Alfanumérico y Obligatorio.");
	private JLabel lblErrorMarca = new JLabel("Campo Alfanumérico y Obligatorio.");
	private JLabel lblErrorKm = new JLabel("Campo Numérico y Obligatorio.");
	private JLabel lblErrorFecha = new JLabel("Campo con Formato (DD/MM/YYYY) y Obligatorio.");
	private JLabel lblErrorCostoKm = new JLabel("Campo Numérico y Obligatorio.");
	private JLabel lblErrorCostoHs = new JLabel("Campo Numérico y Obligatorio.");

	//Otros
	private CamionGuiController controller;
	private BusquedaCamionesPanel busqueda; //Para tener acceso a los métodos de Busqueda de Camiones, como actualizar tabla
	
	private int fila;

	public ModificacionCamionesPopUp(BusquedaCamionesPanel bus) {

		super();
		this.controller = CamionGuiController.getCamionController();
		this.busqueda = bus;
		this.armarPanel();
		
	}
	
	private void armarPanel() {
		
		//Agrega un Layout
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);

		GridBagConstraints constraintsTitulos = new GridBagConstraints();
		constraintsTitulos.fill = GridBagConstraints.VERTICAL;
		constraintsTitulos.anchor = GridBagConstraints.CENTER;
		constraintsTitulos.gridwidth=6;
		constraintsTitulos.insets = new Insets(0, 0, 15, 0);

		GridBagConstraints constraintsSubtitulos = new GridBagConstraints();
		constraintsSubtitulos.gridwidth=6;
		constraintsSubtitulos.weightx=1.0; //Estira a lo largo, es decir, estira en columnas una misma fila
		constraintsSubtitulos.weighty=(double)(1/16);
		constraintsSubtitulos.insets = new Insets(0, 10, 20, 0);
		constraintsSubtitulos.fill = GridBagConstraints.HORIZONTAL;

		GridBagConstraints constraintsLabels = new GridBagConstraints();
		constraintsLabels.gridwidth = 1;
		constraintsLabels.gridheight=1;
		constraintsLabels.weightx=0.12; //
		constraintsLabels.weighty=0;
		constraintsLabels.insets = new Insets(5, 5, 5, 0); //-> Este determina la separación entre objetos.
		constraintsLabels.ipadx = 5;
		constraintsLabels.ipady=5;
		constraintsLabels.fill = GridBagConstraints.NONE;
		constraintsLabels.anchor = GridBagConstraints.LINE_END;

		GridBagConstraints constraintsTextFields = new GridBagConstraints();
		constraintsTextFields.gridwidth = 1;
		constraintsTextFields.gridheight=1;
		constraintsTextFields.weightx=0.12; //
		constraintsTextFields.weighty=0;
		constraintsTextFields.insets = new Insets(5, 5, 5, 0); //-> Este determina la separación entre objetos.
		constraintsTextFields.ipadx = 5;
		constraintsTextFields.ipady=5;
		constraintsTextFields.fill = GridBagConstraints.HORIZONTAL;
		constraintsTextFields.anchor = GridBagConstraints.LINE_START;

		GridBagConstraints constraintsErrores = new GridBagConstraints();
		constraintsErrores.gridwidth=2;
		constraintsErrores.gridheight=1;
		constraintsErrores.weightx=1.0; //Estira a lo largo, es decir, estira en columnas una misma fila
		constraintsErrores.weighty=(double)(1/16);
		constraintsErrores.insets = new Insets(0, 5, 10, 5);
		constraintsErrores.anchor = GridBagConstraints.LAST_LINE_END;
		constraintsErrores.fill = GridBagConstraints.VERTICAL;

		GridBagConstraints constraintsBotones = new GridBagConstraints();
		constraintsBotones.anchor = GridBagConstraints.LINE_END;
		constraintsBotones.insets = new Insets(20, 15, 15, 0);
		constraintsBotones.fill = GridBagConstraints.NONE;


		//Titulo
		constraintsTitulos.gridx = 0;
		constraintsTitulos.gridy = 0;
		lblTitulo.setFont(new Font("System", Font.BOLD, 20));
		lblTitulo.setForeground(Color.BLACK);
		this.add(lblTitulo,constraintsTitulos);


		//Subtitulo:
		constraintsSubtitulos.gridx = 0; //Columna 0
		constraintsSubtitulos.gridy = 1; //Fila 2
		lblSubtitulo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSubtitulo.setForeground(Color.BLACK);
		this.add(lblSubtitulo,constraintsSubtitulos);
		

		//Label Patente
		constraintsLabels.gridx = 0;
		constraintsLabels.gridy = 2;
		constraintsLabels.insets = new Insets(5, 15, 5, 0);
		lblPatente.setPreferredSize(new Dimension(55, 17));
		lblPatente.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblPatente,constraintsLabels);

		constraintsLabels.insets = new Insets(5, 5, 5, 0);
		
		//TextField Patente
		constraintsTextFields.gridx = 1; //Va al lado del Label
		constraintsTextFields.gridy = 2;
		this.txtPatente = new JTextField("");
		this.txtPatente.setMinimumSize(new Dimension(100,20));
		this.add(txtPatente,constraintsTextFields);

		//Error Patente
		constraintsErrores.gridx = 0; //Columna 0
		constraintsErrores.gridy = 3; //Fila 2
		this.lblErrorPatente.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorPatente.setForeground(Color.RED);
		this.add(this.lblErrorPatente,constraintsErrores);
		this.lblErrorPatente.setVisible(false);


		//Label Modelo
		constraintsLabels.gridx = 2;
		constraintsLabels.gridy = 2;
		this.lblModelo.setPreferredSize(new Dimension(55, 17));
		this.lblModelo.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblModelo,constraintsLabels);
		
		//TextField Modelo
		constraintsTextFields.gridx = 3; //Va al lado del Label
		constraintsTextFields.gridy = 2;
		this.txtModelo = new JTextField(0);
		this.txtModelo.setMinimumSize(new Dimension(100,20));
		this.add(txtModelo,constraintsTextFields);

		//Error Modelo
		constraintsErrores.gridx = 2; //Columna 0
		constraintsErrores.gridy = 3; //Fila 2
		this.lblErrorModelo.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorModelo.setForeground(Color.RED);
		this.add(this.lblErrorModelo,constraintsErrores);
		this.lblErrorModelo.setVisible(false);

		//Label Marca
		constraintsLabels.gridx = 4;
		constraintsLabels.gridy = 2;
		this.lblMarca.setPreferredSize(new Dimension(55, 17));
		this.lblMarca.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblMarca,constraintsLabels);
		
		//TextField Marca
		constraintsTextFields.gridx = 5; //Va al lado del Label
		constraintsTextFields.gridy = 2;
		constraintsTextFields.insets = new Insets(5, 5, 5, 20);
		this.txtMarca = new JTextField(0);
		this.txtMarca.setMinimumSize(new Dimension(100,20));
		this.add(txtMarca,constraintsTextFields);
		constraintsTextFields.insets = new Insets(5, 5, 5, 0);

		//Error Marca
		constraintsErrores.gridx = 4; //Columna 0
		constraintsErrores.gridy = 3; //Fila 2
		this.lblErrorMarca.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorMarca.setForeground(Color.RED);
		this.add(this.lblErrorMarca,constraintsErrores);
		this.lblErrorMarca.setVisible(false);


		//Label Km Recorridos
		constraintsLabels.gridx = 0;
		constraintsLabels.gridy = 4;
		this.lblKm.setPreferredSize(new Dimension(100, 17));
		this.lblKm.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblKm,constraintsLabels);
		
		//TextField Km Recorridos
		constraintsTextFields.gridx = 1;
		constraintsTextFields.gridy = 4;
		this.txtKm = new JTextField(0);	
		this.txtKm.setPreferredSize(new Dimension(200, 20));	
		this.add( txtKm, constraintsTextFields);

		//Error Km Recorridos
		constraintsErrores.gridx = 0; //Columna 0
		constraintsErrores.gridy = 5; //Fila 2
		this.lblErrorKm.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorKm.setForeground(Color.RED);
		this.add(this.lblErrorKm,constraintsErrores);
		this.lblErrorKm.setVisible(false);

		
		//Label Fecha de Compra
		constraintsLabels.gridx = 2;
		constraintsLabels.gridy = 4;
		//constraintsLabels.anchor = GridBagConstraints.CENTER;
		//constraints.fill = GridBagConstraints.LINE_END;
		this.lblFecha.setPreferredSize(new Dimension(180, 17));
		this.lblFecha.setFont(new Font("System", Font.PLAIN, 13));
		this.add(lblFecha,constraintsLabels);
		
		//TextField Fecha de Compra:
		constraintsTextFields.gridx = 3;
		constraintsTextFields.gridy = 4;
		this.txtFechaCompra = new JFormattedTextField();
		this.txtFechaCompra.setPreferredSize(new Dimension(300, 20));
		this.add(txtFechaCompra,constraintsTextFields);

		//Error Fecha de Compra
		constraintsErrores.gridx = 2; //Columna 0
		constraintsErrores.gridy = 5; //Fila 2
		this.lblErrorFecha.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorFecha.setForeground(Color.RED);
		this.add(this.lblErrorFecha,constraintsErrores);
		this.lblErrorFecha.setVisible(false);

		//Label Costo por Km:
		constraintsLabels.gridx = 0;
		constraintsLabels.gridy = 6;
		this.lblCostoKm.setPreferredSize(new Dimension(77, 17));
		this.lblCostoKm.setFont(new Font("System", Font.PLAIN, 12));
		this.add(lblCostoKm,constraintsLabels);
		
		//TextField Costo por Km:
		constraintsTextFields.gridx = 1;
		constraintsTextFields.gridy = 6;
		this.txtCostoKm = new JTextField(0);
		this.txtCostoKm.setPreferredSize(new Dimension(200, 20));	
		this.add(txtCostoKm,constraintsTextFields);

		//Error Costo por Km
		constraintsErrores.gridx = 0; //Columna 0
		constraintsErrores.gridy = 7; //Fila 2
		this.lblErrorCostoKm.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorCostoKm.setForeground(Color.RED);
		this.add(this.lblErrorCostoKm,constraintsErrores);
		this.lblErrorCostoKm.setVisible(false);

		//Label Costo por Hora:
		constraintsLabels.gridx = 2;
		constraintsLabels.gridy = 6;
		this.lblCostoHs.setPreferredSize(new Dimension(86, 17));
		this.lblCostoHs.setFont(new Font("System", Font.PLAIN, 12));
		this.add(lblCostoHs,constraintsLabels);
		
		//TextField Costo por Hora:
		constraintsTextFields.gridx = 3;
		constraintsTextFields.gridy = 6;
		this.txtCostoHs = new JTextField(0);
		this.txtCostoHs.setPreferredSize(new Dimension(200, 20));	
		this.add(txtCostoHs,constraintsTextFields);

		//Error Costo por Hora
		constraintsErrores.gridx = 2; //Columna 0
		constraintsErrores.gridy = 7; //Fila 2
		this.lblErrorCostoHs.setFont(new Font("Calibri", Font.PLAIN, 13));
		this.lblErrorCostoHs.setForeground(Color.RED);
		this.add(this.lblErrorCostoHs,constraintsErrores);
		this.lblErrorCostoHs.setVisible(false);


		//Botón Aceptar
		constraintsBotones.gridx = 4;
		constraintsBotones.gridy = 8;
		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setPreferredSize(new Dimension(85,25));
		this.btnAceptar.addActionListener( e ->
			{

				try{
					limpiarErrores();
					this.controller.modificar(this, this.fila);

				}catch (Exception e1){

					this.mostrarError("Error al Modificar Elemento", e1.getMessage());
					e1.printStackTrace();


					return;
				}

				System.out.println("se almacena la modificación");
				this.setVisible(false);

				this.limpiarFormulario();
				this.busqueda.actualizarTabla();
			}
		);
		this.add(btnAceptar,constraintsBotones);
		
		//Botón Cancelar
		constraintsBotones.gridx = 5;
		constraintsBotones.gridy = 8;
		constraintsBotones.anchor = GridBagConstraints.LINE_START;
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setPreferredSize(new Dimension(85,25));
		this.btnCancelar.addActionListener( e ->
		{

			this.setVisible(false);
			this.busqueda.actualizarTabla();

		}
	);
		this.add(btnCancelar,constraintsBotones);
		
	
		
	}
	
	public void mostrarError(String titulo,String detalle) {
		JFrame padre= (JFrame) SwingUtilities.getWindowAncestor(this);
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void limpiarFormulario() {
		
		this.txtPatente.setText("");
		this.txtModelo.setText("");
		this.txtMarca.setText("");
		this.txtKm.setText("");
		this.txtFechaCompra.setText("");
		this.txtCostoHs.setText("");
		this.txtCostoKm.setText("");
		
	}

	private void limpiarErrores(){
		this.lblErrorPatente.setVisible(false);
		this.lblErrorModelo.setVisible(false);
		this.lblErrorMarca.setVisible(false);
		this.lblErrorKm.setVisible(false);
		this.lblErrorFecha.setVisible(false);
		this.lblErrorCostoKm.setVisible(false);
		this.lblErrorCostoHs.setVisible(false);
	}

	public void mostrarErrores(List<Integer> campos){

		for(Integer campo : campos){
			switch (campo){
				case 0: this.lblErrorPatente.setVisible(true); break;
				case 1: this.lblErrorModelo.setVisible(true); break;
				case 2: this.lblErrorMarca.setVisible(true); break;
				case 3: this.lblErrorKm.setVisible(true); break;
				case 4: this.lblErrorFecha.setVisible(true); break;
				case 5: this.lblErrorCostoKm.setVisible(true); break;
				case 6: this.lblErrorCostoHs.setVisible(true); break;
			}
		}

	}

	//Getters para el Controller a la hora de ejecutar el save o guardar
	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}

	public DateTimeFormatter getDf() {
		return df;
	}

	public JFormattedTextField getTxtFechaCompra() {
		return txtFechaCompra;
	}

	public JTextField getTxtKm() {
		return txtKm;
	}

	public JTextField getTxtCostoKm() {
		return txtCostoKm;
	}

	public JTextField getTxtCostoHs() {
		return txtCostoHs;
	}

	public CamionGuiController getController() {
		return controller;
	}

	public void setTxtPatente(String txtPatente) {
		
		this.txtPatente.setText(txtPatente);
		
	}

	public void setTxtModelo(String txtModelo) {
		this.txtModelo.setText(txtModelo);
	}

	public void setTxtMarca(String txtMarca) {
		this.txtMarca.setText(txtMarca);
	}

	public void setTxtFechaCompra(String txtFechaCompra) {
		this.txtFechaCompra.setText(txtFechaCompra);
	}

	public void setTxtKm(String txtKm) {
		this.txtKm.setText(txtKm);
	}

	public void setTxtCostoKm(String txtCostoKm) {
		this.txtCostoKm.setText(txtCostoKm);
	}

	public void setTxtCostoHs(String txtCostoHs) {
		this.txtCostoHs.setText(txtCostoHs);
	}

	public void setFila(int fila) {
		this.fila = fila;
	}
	
	
}
