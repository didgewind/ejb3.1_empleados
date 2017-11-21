package made.empleados.ejbs;

/**
 * Interfaz de negocio para el stateful bean keep track
 * @author made
 *
 */
public interface KeepTrackNegocio {

	public abstract int add(int sumando);
	public abstract int getValue();

}