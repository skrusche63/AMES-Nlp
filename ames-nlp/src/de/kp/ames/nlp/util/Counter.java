package de.kp.ames.nlp.util;
/**
 *	Copyright 2012 Dr. Krusche & Partner PartG
 *
 *	AMES-NLP is free software: you can redistribute it and/or 
 *	modify it under the terms of the GNU General Public License 
 *	as published by the Free Software Foundation, either version 3 of 
 *	the License, or (at your option) any later version.
 *
 *	AMES-NLP is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * 
 *  See the GNU General Public License for more details. 
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this software. If not, see <http://www.gnu.org/licenses/>.
 *
 */

public class Counter {

	private int value = 1;

	/**
	 * Constructor
	 */
	public Counter() {
		value = 1;
	}

	/**
	 * @param val
	 */
	public Counter(int val) {
		value = val;
	}

	/**
	 * Increment
	 */
	public void increment() {
		value++;
	}

	/**
	 * @param number
	 */
	public void increment(int number) {
		value += number;
	}

	/**
	 * @return
	 */
	public int value() {
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.valueOf(value);
	}
}
