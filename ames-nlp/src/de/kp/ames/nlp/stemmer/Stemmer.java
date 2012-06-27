package de.kp.ames.nlp.stemmer;
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

public abstract class Stemmer {

	/**
	 * @param text
	 * @return
	 */
	public abstract String stem(String text);

	/**
	 * @param text
	 * @return
	 */
	public String stemText(String text) {

		text = text.toLowerCase();
  
		StringBuffer result = new StringBuffer();
  
		int start = -1;
		for (int j = 0; j < text.length(); j++) {
  
			char c = text.charAt(j);
			if (Character.isLetterOrDigit(c)) {
				if (start == -1) {
					start = j;
				}
			} else if (c == '\'') {
			
				if (start == -1) {
					result.append(c);
				}
			
			} else {
				if (start != -1) {

					result.append(stem(text.substring(start, j)));
					start = -1;
      
				}
      
				result.append(c);
			}
		
		}
		
		if (start != -1) {
			result.append(stem(text.substring(start, text.length())));
		}
  
		return result.toString();  
		
	}
	
}
    

