package TH10;

/*
 * ������� ����� City (�����) � ���������� �������, � ������� �������� �������� ����� ������� ���������� 
 * � ����������, ������, ��������. ���������� ����� � ������� ������ ���� ���� ��� ��������, ���� ��� ���� � ��. 
 * ������ � ���������� String, ������� ������ ������ � �������� ���� � �������� ��������. 
 * �.e. ����� City �������� ��������� ���������� � ����� ����������� ������ � ������� �������� �������� ����� 
 * ��������� � ��.
 */

public class Task2 {

	public static void main(String[] args) {
		City minsk = new City("Minsk");

		// add avenues
		minsk.setAvenue("Masherova");
		minsk.setAvenue("Pobedy");
		
		// add streets
		minsk.setStreet("Kulman");
		minsk.setStreet("Panchenko");
		minsk.setStreet("Scriganova");
		minsk.setStreet("Brilevskaya");
		
		// add squares
		minsk.setSquare("Lenina");
		minsk.setSquare("Svobody");	
		minsk.setSquare("Pobedy");	

		String[] avenues = minsk.getAvenues();
		String[] streets = minsk.getStreets();
		String[] squares = minsk.getSquares();

		System.out.println("In city " + minsk.getName() + " we have:");
		System.out.println("Avenues:");

		for (int i = 0; i < avenues.length; i++) {
			System.out.println((i + 1) + " - " + avenues[i]);
		}
		
		System.out.println();
		System.out.println("Streets:");

		for (int i = 0; i < streets.length; i++) {
			System.out.println((i + 1) + " - " + streets[i]);
		}	
		
		System.out.println();
		System.out.println("Squares:");

		for (int i = 0; i < squares.length; i++) {
			System.out.println((i + 1) + " - " + squares[i]);
		}			
	}
}
