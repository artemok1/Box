package TH17;

/*
 * ��� ����� ������� �������� XML � JSON (���� ������� �������) � ���������� ��. �������� ����� � ������ �������� ������,
 *  � ������� � ������ ��������� ������, ��� ���� ������� ����. � ��� ������ ���������� ��������� ������������������: 
 *  - ��������� XML - ����� 1 
 *  - ������������ XML - ����� 2 
 *  - ��������� JSON - ����� 1 
 *  - ������������ JSON - ����� 2 
 *  ��� ������ �������� �� ���������� ���� �������� (��������). 
 *  XML � JSON ����� ������� � ����� ��� �������� ����� ��������.
 */

public class Task1 {

	public static void main(String[] args) {
		Parser parser = new Parser();
		
		Reader reader = new Reader();
		
		parser.setReader(reader);
		
		reader.setParser(parser);
		
		System.out.println("start");
		reader.start();
		parser.start();
	}
}
