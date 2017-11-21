package made.empleados.daos;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.context.ApplicationScoped;

import made.empleados.model.Empleado;

/**
 * Stateless sesion bean para dao jta
 * 
 * @author made
 *
 */
@Named
@ApplicationScoped
public class DAOEmpJPACMT implements EmpDAO {

	@PersistenceContext(unitName = "EmpleadosPUJTA")
	private EntityManager em;

	@Override
	public SortedSet<Empleado> getAllEmpleados() {
		return new TreeSet<Empleado>(em.createQuery("select e from Empleado e")
				.getResultList());
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		em.persist(emp);
		return true;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		int queryCount = em
				.createQuery("DELETE FROM Empleado e WHERE e.cif = :cif")
				.setParameter("cif", cif).executeUpdate();
		return queryCount == 1;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		// Esto deberíamos codificarlo mejor, porque parece que
		// si emp no existe lo crea
		em.merge(emp);
		return true;
	}

	@Override
	public Empleado getEmpleado(String cif) {
		return em.find(Empleado.class, cif);
	}

	public void eliminaAllEmpleados() {
		em.createQuery("delete Empleado").executeUpdate();
	}

}
