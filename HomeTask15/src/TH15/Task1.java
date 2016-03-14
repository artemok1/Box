package TH15;

import java.util.Arrays;

/*
 * ¬ывести все слова из заданного текста в пор€дке возрастани€ количества букв в каждом из них. 
 * “екст выбрать произвольный, но не менее 300 символов.
 */

public class Task1 {

	public static void main(String[] args) {
		// generate text
		StringBuilder sb = new StringBuilder();

		sb.append("Anyone who reads Old and Middle English literary texts will be familiar with the mid-brown volumes ");
		sb.append("of the EETS, with the symbol of Alfred's jewel embossed on the front cover. Most of the works attributed ");
		sb.append("to King Alfred or to Aelfric, along with some of those by bishop Wulfstan and much anonymous prose and ");
		sb.append("verse from the pre-Conquest period, are to be found within the Society's three series; all of the surviving ");
		sb.append("medieval drama, most of the Middle English romances, much religious and secular prose and verse including ");
		sb.append("the English works of John Gower, Thomas Hoccleve and most of Caxton's prints all find their place in the publications. ");
		sb.append("Without EETS editions, study of medieval English texts would hardly be possible. ");

		String text = sb.toString();

		// replace all special chars
		text = text.replaceAll("(\\,+|\\.+|\\!+|\\?+|\\;+|\\:+)", " ");

		text = text.trim();

		// get array of words
		String[] array = text.split(" +");

		Arrays.sort(array, new StringComporator());

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
