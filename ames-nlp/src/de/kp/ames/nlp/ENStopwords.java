package de.kp.ames.nlp;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

import de.kp.ames.nlp.data.DataLoader;

public class ENStopwords extends Stopwords {
	
	private static String STOPWORD_FILE = "stopwords_en.txt";
	
	private static HashSet<String> stopwords = null;
	
	public ENStopwords() {
		
		stopwords = new HashSet<String>();
		
		InputStreamReader is = null;
		String stopword      = null;
		
		try {

			is = new InputStreamReader(DataLoader.load(STOPWORD_FILE), "UTF-8");
			BufferedReader reader = new BufferedReader(is);				

			while ((stopword = reader.readLine()) != null)  {
					stopwords.add(stopword);   
				}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean isStopword(String stopword) {
		return stopwords.contains(stopword.toLowerCase());
	}
		
}
		
		

