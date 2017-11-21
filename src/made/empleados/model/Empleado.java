package made.empleados.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ejb de entidad que encapsula la info sobre un empleado
 * @author made
 *
 */
@Entity
@Table(name = "emp") 
public class Empleado implements Serializable, Comparable<Empleado>, Cloneable {
	
	/*
	 * Inicializamos los atributos para que funcionen bien las comparaciones
	 * en el jsf
	 */
	@Id
	private String cif = "";
	private String nombre = "";
	private String apellidos = "";
	private int edad;
	
	public Empleado() {
	}

	/**
	 * 
	 * @param cif Cif del empleado
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 */
	public Empleado(String cif, String nombre, String apellidos, int edad) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return cif + " - " + nombre + " - " + apellidos + " - " + edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

	@Override
	public int compareTo(Empleado emp) {
		if (this.apellidos.compareToIgnoreCase(emp.apellidos) != 0) {
			return this.apellidos.compareToIgnoreCase(emp.apellidos);
		} else if (this.nombre.compareToIgnoreCase(emp.nombre) != 0) {
			return this.nombre.compareToIgnoreCase(emp.nombre);
		} else {
			return this.cif.compareToIgnoreCase(emp.cif);
		}
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
