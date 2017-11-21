package made.empleados.ejbs;

import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Ejb stateful que va sumando enteros según le van invocando
 */
@Stateful(name="keepTrack")
@Remote(KeepTrackNegocioRemoto.class)
@Local(KeepTrackNegocioLocal.class)
public class KeepTrackEJB implements KeepTrackNegocioRemoto {

	private static final Logger log = Logger.getLogger(KeepTrackEJB.class
			.getName());

	private int suma = 0;
	
	@Override
	public int add(int sumando) {
		suma += sumando;
		return suma;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return suma;
	}

}
