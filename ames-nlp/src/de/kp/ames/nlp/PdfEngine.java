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

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfEngine {

	public PdfEngine() {		
	}
		
	/**
	 * @param stream
	 * @return
	 */
	public Set<String> pdfToText(InputStream stream) {

		try {

			ENStopwords stopwords = new ENStopwords();
			
			PDFParser parser = new PDFParser(stream);
			parser.parse();
			
			/* 
			 * Build pdf stripper and extract text content
			 */
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(parser.getPDDocument());

			Set<String> terms = new HashSet<String>();
			
			String[] phrases = text.split("\n");
			for (String phrase:phrases) {	
				
				phrase = phrase.trim();				
				if (phrase.length() == 0) continue;
				
				String[] words = phrase.split(" ");
				for (String word:words) {
					
					/* 
					 * Filter stopwords
					 */
					if (stopwords.isStopword(word)) continue;
					terms.add(word);

				}

			}

			return terms;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {}
		
		return null;
	}

}
