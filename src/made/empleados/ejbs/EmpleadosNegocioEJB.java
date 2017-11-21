package made.empleados.ejbs;

import java.util.SortedSet;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import made.empleados.daos.EmpDAO;
import made.empleados.daos.qualifiers.DAOType;
import made.empleados.daos.qualifiers.DAOTypeQ;
import made.empleados.model.Empleado;

@Stateless
@RolesAllowed(value={"ROLE_ADMIN", "ROLE_GUEST"})
@Remote(EmpleadosNegocioRemoto.class)
@Local(EmpleadosNegocioLocal.class)
public class EmpleadosNegocioEJB implements EmpleadosNegocioRemoto {

	@Inject @DAOTypeQ(DAOType.DAO_FAKE)
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public Empleado getEmpleado(String cif) {
		return dao.getEmpleado(cif);
	}

	@Override
	public SortedSet<Empleado> getAllEmpleados() {
		return dao.getAllEmpleados();
	}

	@Override
	@RolesAllowed("ROLE_ADMIN")
	public boolean eliminaEmpleado(String cif) {
		return dao.eliminaEmpleado(cif);
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		return dao.insertaEmpleado(emp);
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		return dao.modificaEmpleado(emp);
	}

}
