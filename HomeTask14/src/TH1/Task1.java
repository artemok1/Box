package TH1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/*
 * ���������� ��������� ���� �����, ��� � �� ������� (���������� test.json), �� ��������� ���������� Jackson
 * (��� ������ GSON). ��� ���������� �������������� ������� ���������, ���������� � ������ � ��������� ������������ 
 * ����������� ��� �� ������������. ���� ������ � ������������� �� ����� ���� ����� ����� �� Jackson. 
 * ����� ������� ���� �������� ������, ������ test.json.
 */

public class Task1 {

	public static void main(String[] args) {
		byte[] jsonData;

		// read json file data to String
		try {
			jsonData = Files.readAllBytes(Paths.get("test.json"));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		Root root;

		// convert json string to object
		try {
			root = objectMapper.readValue(jsonData, Root.class);
		} catch (JsonParseException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		} catch (JsonMappingException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

			return;
		}

		System.out.println("Result: " + root.toString());
	}
}
