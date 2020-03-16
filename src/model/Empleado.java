package model;

import java.math.BigDecimal;

public abstract class Empleado extends Persona {
	
	protected BigDecimal dinero=new BigDecimal(0);
	protected BigDecimal deuda=new BigDecimal(0);
	public abstract BigDecimal sueldo();
	public abstract void cobrar(); 

	public BigDecimal getDeuda() {
		return deuda;

	}
	public BigDecimal getDinero() {
		return dinero;
	}

	public void setDinero(BigDecimal dinero) {
		this.dinero = dinero;
	}

	public void setDeuda(BigDecimal deuda) {
		this.deuda = deuda;
	}

	public void gastar(BigDecimal bigDecimal) {
		   this.deuda=deuda.add(bigDecimal);
          
	}

}
