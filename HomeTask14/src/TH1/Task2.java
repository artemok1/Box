package TH1;

/*
 * Если все сделали быстро, то тренируемся создавать json файлы их кода. Это можно делать как с помощью JSON Simple, так и с GSON.
 */

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Task2 {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("name", "Artsiom");
		obj.put("age", new Integer(28));

		JSONArray list = new JSONArray();
		list.add("item 1");
		list.add("item 2");
		list.add("item 3");

		obj.put("items", list);

		try {

			FileWriter file = new FileWriter("D:\\file1a.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}
		
		System.out.println("File saved!");
	}

}
