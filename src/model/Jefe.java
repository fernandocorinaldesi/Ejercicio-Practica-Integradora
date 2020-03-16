package model;

import java.math.BigDecimal;

public class Jefe extends Persona{
	private BigDecimal fondos=new BigDecimal(300000);
	Empleado empleado;
	
	public void pagarA(Empleado empleado) {
	    this.empleado=empleado;
	    this.empleado.cobrar();
	    fondos=fondos.subtract(empleado.sueldo());
	}

	public BigDecimal getFondos() {
		return fondos;
	}
	
	public void ajustes() {
		
		if(empleado.getDeuda().intValue()>=empleado.getDinero().intValue()) {
			empleado.setDeuda(empleado.getDeuda().subtract(empleado.getDinero()));
			empleado.setDinero(new BigDecimal(0));
		}
		else{
			empleado.setDinero(empleado.getDinero().subtract(empleado.getDeuda()));
			empleado.setDeuda(new BigDecimal(0));
		}
	}

	public void setFondos(BigDecimal fondos) {
		// TODO Auto-generated method stub
		this.fondos=fondos;
		
	}

}
