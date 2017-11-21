package made.empleados.daos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import made.empleados.daos.qualifiers.DAOType;
import made.empleados.daos.qualifiers.DAOTypeQ;
import made.empleados.model.Empleado;

@DAOTypeQ(DAOType.DAO_FAKE)
@ApplicationScoped
public class EmpDAOFake implements EmpDAO {

	private Map<String, Empleado> bdEmpleados = new HashMap<String, Empleado>();
	
	/**
	 * Inicializa la estructura de datos que representa la bd en memoria
	 */
	public EmpDAOFake() {
		Empleado e2 = new Empleado("34523453G", "Luis", "Esquivias", 22);
		Empleado e3 = new Empleado("42534534T", "Almudena", "Nieto", 42);
		Empleado e4 = new Empleado("11325987A", "Inaru", "Escribano", 55);
		Empleado e5 = new Empleado("09856783B", "Jesús", "Escribano", 12);
		bdEmpleados.put("23452345H", new Empleado("23452345H", "Ángel", "Nieto", 65));
		bdEmpleados.put("34523453G", e2);
		bdEmpleados.put("42534534T", e3);
		bdEmpleados.put("11325987A", e4);
		bdEmpleados.put("09856783B", e5);
	}
	
	@Override
	public Empleado getEmpleado(String cif) {
		return bdEmpleados.get(cif);
	}

	@Override
	public SortedSet<Empleado> getAllEmpleados() {
		Collection<Empleado> empleados = bdEmpleados.values();
		SortedSet<Empleado> sortedEmpleados = new TreeSet<Empleado>(empleados);
		return sortedEmpleados;
	}
	
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAOFake();
		System.out.println("Recuperando un empleado");
		System.out.println(dao.getEmpleado("34523453G"));
		System.out.println();
		System.out.println("Recuperando todos los empleados ordenados por apellidos y nombre");
		for (Empleado emp : dao.getAllEmpleados()) {
			System.out.println(emp);
		}
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		Empleado empAux = bdEmpleados.remove(cif);
		if (empAux != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean eliminaAllEmpleados() {
		bdEmpleados.clear();
		return true;
	}

	public boolean insertaEmpleado(Empleado emp) {
		try {
			bdEmpleados.put(emp.getCif(), (Empleado) emp.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		if (bdEmpleados.containsKey(emp.getCif())) {
			insertaEmpleado(emp);
			return true;
		} else {
			return false;
		}
	}
}
