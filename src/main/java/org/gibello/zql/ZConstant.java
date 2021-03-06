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

/**
 * ZConstant: a representation of SQL constants.
 * 
 * @author Bogdan Mariesan, Romania
 */
public class ZConstant implements ZExp {

	/**
	 * The serial version UID.
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * ZConstant types.
	 */
	public static final int		UNKNOWN				= -1;

	/**
	 * ZConstant types.
	 */
	public static final int		COLUMNNAME			= 0;

	/**
	 * ZConstant types.
	 */
	public static final int		NULL				= 1;

	/**
	 * ZConstant types.
	 */
	public static final int		NUMBER				= 2;

	/**
	 * ZConstant types.
	 */
	public static final int		STRING				= 3;

	/**
	 * ZConstant types.
	 */
	private int					zconstantType		= ZConstant.UNKNOWN;

	/**
	 * Values.
	 */
	private String				values				= null;

	/**
	 * Create a new constant, given its name and type.
	 * 
	 * @param values
	 *            the values.
	 * @param zconstantTypes
	 *            the types.
	 */
	public ZConstant(final String values, final int zconstantTypes) {
		this.values = new String(values);
		this.zconstantType = zconstantTypes;
	}

	/**
	 * @return the constant value
	 */
	public String getValue() {
		return this.values;
	}

	/**
	 * @return the constant type
	 */
	public int getType() {
		return this.zconstantType;
	}

	@Override
	public String toString() {
		String toString;

		if (this.zconstantType == ZConstant.STRING) {
			toString = '\'' + this.values + '\'';
		} else {
			toString = this.values;
		}

		return toString;
	}
};
