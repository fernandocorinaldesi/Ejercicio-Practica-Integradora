package model;

import java.math.BigDecimal;

public class EmpleadoEmpanada extends Empleado{
	public final  BigDecimal valorEmpanada=new BigDecimal(15);
	private  Integer cantidadEmpanadasVendidas;
	
	public EmpleadoEmpanada() {
		this.nombre="Baigorria";
		this.empleado="Empanada";
		this.cantidadEmpanadasVendidas=200;
		
	}
	@Override
	public BigDecimal sueldo() {
		// TODO Auto-generated method stub
		return  valorEmpanada.multiply(new BigDecimal(cantidadEmpanadasVendidas));
	}
	
	public void setCantEmpanadasVendidas(Integer cantidadEmpanadasVendidas) {
		this.cantidadEmpanadasVendidas=cantidadEmpanadasVendidas;
	}

	@Override
	public void cobrar() {
		// TODO Auto-generated method stub
		this.dinero=this.dinero.add(this.sueldo());
		
	}
	
}
