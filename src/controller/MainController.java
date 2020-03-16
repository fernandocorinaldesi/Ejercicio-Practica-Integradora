package controller;

import java.math.BigDecimal;

import model.Empleado;
import model.EmpleadoEmpanada;
import model.EmpleadoFijo;
import model.Jefe;
import view.ViewOperations;

public class MainController implements MainControllerOperations{
	private ViewOperations mainview;
	private Empleado empleado;
	private Jefe jefe;
	public MainController(Jefe jefe,ViewOperations mainview) {
		this.mainview=mainview;
		this.jefe=jefe;
		this.mainview.setController(this);
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		mainview.open();
	}
	@Override
	public void pagar() {
		// TODO Auto-generated method stub
	jefe.pagarA(empleado);
	mainview.pagar(empleado.getDinero().doubleValue());
	mainview.setFondos(jefe);
		
	}
	@Override
	public void balance() {
		// TODO Auto-generated method stub
		jefe.ajustes();
		mainview.actualizar(empleado);
	}

	@Override
	public void gastar(Double monto) {
		// TODO Auto-generated method stub
		empleado.gastar(new BigDecimal(monto));
		mainview.setDeuda(empleado.getDeuda().doubleValue());
		
	}
	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		empleado.setDeuda(new BigDecimal(0));
		empleado.setDinero(new BigDecimal(0));
		jefe.setFondos(new BigDecimal(300000));
		mainview.limpiar();
		mainview.setFondos(jefe);
	}
	@Override
	public void setEmpleadoBaigorria() {
		// TODO Auto-generated method stub
		empleado=new EmpleadoEmpanada();
		mainview.setDefaults(empleado);
		mainview.limpiar();
		
	}
	@Override
	public void setEmpleadoGalvan() {
		// TODO Auto-generated method stub
		empleado=new EmpleadoFijo();
		mainview.setDefaults(empleado);
		mainview.limpiar();
		
	}
	
	

}
