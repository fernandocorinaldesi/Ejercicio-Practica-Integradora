package model;

import java.math.BigDecimal;

public class EmpleadoFijo extends Empleado{
	private BigDecimal sueldo;
	
	public EmpleadoFijo() {
		this.nombre="Galvan";
		this.empleado="fijo";
		this.sueldo=new BigDecimal(15000);
	}

	@Override
	public BigDecimal sueldo() {
		// TODO Auto-generated method stub
		return sueldo;
	}
	@Override
	public void cobrar() {
		// TODO Auto-generated method stub
		this.dinero=this.dinero.add(this.sueldo);
		
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo=sueldo;
	}
	

}
