/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package made.empleados.ejbs;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Base for bean implementation classes of the CalculatorEJB, provides business
 * logic for required contracts
 *
 * @author <a href="mailto:andrew.rubinger@jboss.org">ALR</a>
 */
@Stateless(name="calculator")
@Remote(CalculatorNegocioRemoto.class)
@Local(CalculatorNegocioLocal.class)
public class CalculatorEJB implements CalculatorNegocioRemoto {

	/**
	 * Logger
	 */
	private static final Logger log = Logger.getLogger(CalculatorEJB.class
			.getName());

	@Override
	public int add(List<Integer> arguments) {
		// Initialize
		final StringBuffer sb = new StringBuffer();
		sb.append("Adding arguments: ");
		int result = 0;

		// Add all arguments
		for (final int arg : arguments) {
			result += arg;
			sb.append(arg);
			sb.append(" ");
		}

		// Return
		log.info(sb.toString());
		log.info("Result: " + result);
		return result;
	}

}
