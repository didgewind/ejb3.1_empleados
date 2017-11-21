package made.empleados.daos.qualifiers;

/**
 * Enumerado con los tres tipos de daos posibles (fake, jpa con transacciones locales
 * y jpa con transacciones jta)
 * @author made
 *
 */
public enum DAOType {
    DAO_FAKE,
    DAO_JPA_LOCAL,
    DAO_JPA_JTA
}