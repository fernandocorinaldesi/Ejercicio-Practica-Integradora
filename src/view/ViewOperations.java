package view;

import controller.MainControllerOperations;
import model.Empleado;
import model.Jefe;

public interface ViewOperations {
    public void open();
    public void setController(MainControllerOperations controller);
    public void pagar(double monto);
    public void setDeuda(double monto);
    public void setDefaults(Empleado persona);
    public void actualizar(Empleado persona);
	public void limpiar();
	public void setFondos(Jefe jefe);
	public void setEmpleado(Empleado empleado);
}
