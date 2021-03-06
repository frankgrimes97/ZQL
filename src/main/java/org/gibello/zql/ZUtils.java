/*
 * This file is part of Zql.
 *
 * Zql is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Zql is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zql.  If not, see http://www.gnu.org/licenses.
 */

package org.gibello.zql;

import java.util.Hashtable;

/**
 * Utils class.
 * 
 * @author Bogdan Mariesan, Romania
 */
public final class ZUtils {

	/**
	 * The count operator.
	 */
	private static final String					COUNT_OPERATOR	= "COUNT";

	/**
	 * The min operator.
	 */
	private static final String					MIN_OPERATOR	= "MIN";

	/**
	 * The max operator.
	 */
	private static final String					MAX_OPERATOR	= "MAX";

	/**
	 * The average operator.
	 */
	private static final String					AVG_OPERATOR	= "AVG";

	/**
	 * The sum operator.
	 */
	private static final String					SUM_OPERATOR	= "SUM";

	/**
	 * Functions hash table.
	 */
	private static Hashtable<String, Integer>	fcts			= null;

	/**
	 * Variable plist.
	 */
	public static final int						VARIABLE_PLIST	= 10000;

	/**
	 * Default constructor.
	 */
	private ZUtils() {

	}

	/**
	 * Add custom function.
	 * 
	 * @param fct
	 *            the function
	 * @param noParams
	 *            the number of parammeters.
	 */
	public static void addCustomFunction(final String fct, final int noParams) {
		int params = noParams;

		if (ZUtils.fcts == null) {
			ZUtils.fcts = new Hashtable<String, Integer>();
		}

		if (params < 0) {
			params = 1;
		}

		ZUtils.fcts.put(fct.toUpperCase(), new Integer(params));
	}

	/**
	 * Check if function is custom.
	 * 
	 * @param fct
	 *            the function name
	 * @return the result of the check.
	 */
	public static int isCustomFunction(final String fct) {
		Integer nparam;

		nparam = (Integer) ZUtils.fcts.get(fct.toUpperCase());
		if (fct == null || fct.length() < 1 || fcts == null || nparam == null) {
			nparam = -1;
		}

		return nparam.intValue();
	}

	/**
	 * Check if is aggregate.
	 * 
	 * @param operator
	 *            the operator.
	 * @return result of the aggregate check.
	 */
	public static boolean isAggregate(final String operator) {
		final String tmp = operator.toUpperCase().trim();
		boolean result = false;

		if (tmp.equals(ZUtils.SUM_OPERATOR)) {
			result = true;
		} else
			if (tmp.equals(ZUtils.AVG_OPERATOR)) {
				result = true;
			} else
				if (tmp.equals(ZUtils.MAX_OPERATOR)) {
					result = true;
				} else
					if (tmp.equals(ZUtils.MIN_OPERATOR)) {
						result = true;
					} else
						if (tmp.equals(ZUtils.COUNT_OPERATOR)) {
							result = true;
						} else
							if (fcts != null && fcts.get(tmp) != null) {
								result = true;
							}

		return result;
	}

	/**
	 * Get the aggregate call.
	 * 
	 * @param c
	 *            the call string.
	 * @return the aggregate call.
	 */
	public static String getAggregateCall(final String c) {
		final int pos = c.indexOf('(');

		String result;
		if (pos <= 0) {
			result = null;
		}
		final String call = c.substring(0, pos);
		if (ZUtils.isAggregate(call)) {
			result = call.trim();
		} else {
			result = null;
		}

		return result;
	}

};
