package View.gui.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmacionPanel extends JPanel{


	private JLabel lblMensaje = new JLabel("¿Desea ejecutar la operación?");
	private JButton btnAceptar;
	private JButton btnCancelar;
		
	public ConfirmacionPanel() {
		super();
		//Primero debo inicializar el controller ya que armarPanel requiere de controller
		//this.controller = new CamionService(this);
		this.armarPanel();
		
	}
		
	private void armarPanel() {
			
		//Agrega un Layout
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints constraints = new GridBagConstraints();
			
		//Titulo
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridwidth=4;
		constraints.insets = new Insets(0, 0, 15, 0);
		lblMensaje.setFont(new Font("System", Font.PLAIN, 15));
		lblMensaje.setForeground(Color.BLACK);
		this.add(lblMensaje,constraints);
		
		constraints.gridwidth=1;
		//Botón Aceptar
		constraints.gridx = 1;
		constraints.gridy = 1;	
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(20, 15, 15, 0);
		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setPreferredSize(new Dimension(90,25));
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
//			}
//		);
		this.add(btnAceptar,constraints);
		
		//Botón Cancelar
		constraints.gridx = 2;
		constraints.gridy = 1;	
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(20, 15, 15, 0);
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setPreferredSize(new Dimension(90,25));
//		this.btnCancelar.addActionListener( e ->
//			{
//				try {
//					controller.guardar();
//				} catch (DatosObligatoriosException | FormatoNumeroException | ControllerException e1) {
//					this.mostrarError("Error al guardar", e1.getMessage());
//				}
//				this.limpiarFormulario();
//				modeloTablaCamion.fireTableDataChanged();
//				
//			}
//		);
		this.add(btnCancelar,constraints);
			
			
			
	}
		
}


