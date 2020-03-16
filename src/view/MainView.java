package view;

import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.border.TitledBorder.TOP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.MainControllerOperations;
import model.Empleado;
import model.Jefe;

public class MainView extends JFrame implements ViewOperations {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton pagar;
	JButton gastar;
	JButton balance;
	JButton limpiar;
	JButton acerca;
	JButton galvan;
	JButton baigorria;
	
	JLabel sueldo;
	JLabel dinero;
	JLabel deuda;
	JLabel nombre;
	JLabel empleado;
	JLabel fondos;
	JTextField sueldoText;
	JTextField dineroText;
	JTextField deudaText;
	JTextField nombreText;
	JTextField empleadoText;
	JTextField fondosText;

	JTextField gastarfield;

	public MainView() {
		initConfig();
		initPanels();

	}

	public void initConfig() {
		setSize(500, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
	}

	public void initPanels() {
		MyTitleBar titleView = new MyTitleBar(this);
		getContentPane().add(titleView, BorderLayout.NORTH);
		getContentPane().add(createCenter(), BorderLayout.CENTER);
		getContentPane().add(createSouth(), BorderLayout.SOUTH);
		getContentPane().add(createEast(), BorderLayout.WEST);

	}

	private JPanel createCenter() {
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(5, 2, 0, 0));
		pane.setBorder(new EmptyBorder(10, 100, 10, 100));
		sueldo = new JLabel("Sueldo");
		dinero = new JLabel("Dinero");
		deuda = new JLabel("Deuda");
		nombre = new JLabel("Nombre");
		empleado = new JLabel("Empleado");
		sueldoText = new JTextField(15);
		dineroText = new JTextField(15);
		deudaText = new JTextField(15);
		nombreText = new JTextField(15);
		empleadoText = new JTextField(15);

		
		sueldoText.setEditable(false);
		empleadoText.setEditable(false);
		nombreText.setEditable(false);

		pane.add(nombre);
		pane.add(nombreText);

		pane.add(empleado);
		pane.add(empleadoText);

		pane.add(sueldo);
		pane.add(sueldoText);

		pane.add(deuda);
		pane.add(deudaText);

		pane.add(dinero);
		pane.add(dineroText);

		return pane;

	}

	private JPanel createSouth() {
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		pagar = new JButton("Pagar");
		balance = new JButton("Balance");
		gastar = new JButton("Gastar");
		limpiar = new JButton("Limpiar");
		acerca = new JButton(" ? ");
		acerca.addActionListener((event) -> {
			JOptionPane.showMessageDialog(this, "Este software fue desarrollado por : Fernando Corinaldesi");
		});
		
		gastarfield = new JTextField(5);

		pane.add(gastar);
		pane.add(gastarfield);
		pane.add(pagar);
		pane.add(balance);
		pane.add(limpiar);
		pane.add(acerca);
	    pane.setBackground(Color.BLACK);
		return pane;
	}
	private JPanel createEast() {
		JPanel mainpane=new JPanel();
		mainpane.setLayout(new BoxLayout(mainpane,BoxLayout.Y_AXIS));
				
		JPanel pane=new JPanel();
		JPanel epane=new JPanel();
		//pane.setLayout(new GridLayout(3,1));
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		//pane.setBorder(createTitledBorder(new LineBorder(Color.BLACK),"Fondos", TitledBorder.CENTER, TOP));
		fondos=new JLabel("Fondos");
		fondos.setAlignmentX(CENTER_ALIGNMENT);
		fondos.setForeground(Color.BLACK);
		//fondos.setFont(Fonts.SIDEPANEL);
		fondosText=new JTextField(7);
		fondosText.setMaximumSize(fondosText.getPreferredSize() );
		fondosText.setEditable(false);
		//pane.setBackground(Color.BLACK);
		
		baigorria=new JButton("Baigorria");
		galvan=new JButton("  Galvan  ");
		//epane.setLayout(new GridLayout(2,1));
		epane.setLayout(new BoxLayout(epane,BoxLayout.Y_AXIS));
		epane.add(galvan);
		epane.add(baigorria);
		epane.setBorder(createTitledBorder(new LineBorder(Color.BLACK),"Empleados", TitledBorder.CENTER, TOP));
		//epane.setBackground(Color.BLACK);
		
		pane.add(fondos);
		pane.add(fondosText);
		pane.setAlignmentX(CENTER_ALIGNMENT);
		epane.setAlignmentX(CENTER_ALIGNMENT);
		mainpane.add(pane);
		mainpane.add(epane);
		return mainpane;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		setVisible(true);
	}

	@Override
	public void setController(MainControllerOperations controller) {
		// TODO Auto-generated method stub
		pagar.addActionListener((event) -> {
			if(!nombreText.getText().isEmpty()){
				controller.pagar();
			}else {
				JOptionPane.showMessageDialog(this, "campos vacios");
			}
			
		});
		gastar.addActionListener((event) -> {
			// System.out.println(Integer.valueOf(gastarfield.getText()));
			if (!gastarfield.getText().isEmpty() && esDouble(gastarfield.getText())) {
				controller.gastar(Double.valueOf(gastarfield.getText()));
			} else {
				JOptionPane.showMessageDialog(this, "Caracter invalido o vacio");
			}

		});
		balance.addActionListener((event) -> {
			if(!dineroText.getText().isEmpty() || !deudaText.getText().isEmpty()){
				controller.balance();
			}else {
				JOptionPane.showMessageDialog(this, "campos vacios");
			}
			
			
		});
		limpiar.addActionListener((event) -> {
			if(!nombreText.getText().isEmpty()){
				controller.limpiar();
			}else {
				JOptionPane.showMessageDialog(this, "campos vacios");
			}
			
		});
		baigorria.addActionListener((event)->{
			controller.setEmpleadoBaigorria();
		});
	    galvan.addActionListener((event)->{
			controller.setEmpleadoGalvan();
		});

	}

	@Override
	public void pagar(double monto) {
		// TODO Auto-generated method stub
		if (!dineroText.getText().isEmpty()) {
			Double result = Double.valueOf(dineroText.getText()) + monto;
			dineroText.setText(Double.toString(result));
		}
		dineroText.setText(Double.toString(monto));
	}

	@Override
	public void setDefaults(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoText.setText(empleado.getEmpleado());
		nombreText.setText(empleado.getNombre());
		sueldoText.setText(empleado.sueldo().toPlainString());
   		fondosText.setText("300000");
	}

	@Override
	public void setDeuda(double monto) {
		// TODO Auto-generated method stub
		deudaText.setText(Double.toString(monto));

	}

	public boolean esDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		dineroText.setText("");
		deudaText.setText("");;
		gastarfield.setText("");;
		
	}

	@Override
	public void actualizar(Empleado persona) {
		// TODO Auto-generated method stub
		dineroText.setText(persona.getDinero().toPlainString());
		deudaText.setText(persona.getDeuda().toPlainString());;
	}

	@Override
	public void setFondos(Jefe jefe) {
		fondosText.setText(jefe.getFondos().toPlainString());
	// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

}
