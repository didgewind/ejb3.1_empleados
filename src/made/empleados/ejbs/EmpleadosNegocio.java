package made.empleados.ejbs;

import java.util.SortedSet;

import made.empleados.model.Empleado;


public interface EmpleadosNegocio {

	public abstract Empleado getEmpleado(String cif);
	public abstract SortedSet<Empleado> getAllEmpleados();
	public abstract boolean eliminaEmpleado(String cif);
	public abstract boolean insertaEmpleado(Empleado emp);
	public abstract boolean modificaEmpleado(Empleado emp);
	
}
