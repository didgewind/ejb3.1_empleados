package made.empleados.daos;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import made.empleados.daos.qualifiers.DAOType;
import made.empleados.daos.qualifiers.DAOTypeQ;
import made.empleados.model.Empleado;

@DAOTypeQ(DAOType.DAO_JPA_LOCAL)
@ApplicationScoped
public class DAOEmpJPALocalTx implements EmpDAO {

	private EntityManager em;

	@PostConstruct
	public void init() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmpleadosPULOCAL");
		em = emf.createEntityManager();
	}

	@PreDestroy
	public void destroy() {
		em.close();
	}

	@Override
	public SortedSet<Empleado> getAllEmpleados() {
		return new TreeSet<Empleado>(em.createQuery("select e from Empleado e")
				.getResultList());
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		em.getTransaction().begin();
		int queryCount = em
				.createQuery("DELETE FROM Empleado e WHERE e.cif = :cif")
				.setParameter("cif", cif).executeUpdate();
		em.getTransaction().commit();
		return queryCount == 1;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		em.getTransaction().begin();
		em.merge(emp);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Empleado getEmpleado(String cif) {
		return em.find(Empleado.class, cif);
	}

	public void eliminaAllEmpleados() {
		em.getTransaction().begin();
		em.createQuery("delete Empleado").executeUpdate();
		em.getTransaction().commit();
	}

}
