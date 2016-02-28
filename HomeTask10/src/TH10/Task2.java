package TH10;

/*
 * —оздать класс City (город) с внутренним классом, с помощью объектов которого можно хранить информацию 
 * о проспектах, улицах, площад€х. ¬нутренний класс в задании должен быть один дл€ площадей, один дл€ улиц и тд. 
 * ѕросто с переменной String, котора€ сможет хранит и названи€ улиц и названи€ площадей. 
 * “.e. класс City содержит несколько переменных с типом внутреннего класса в которых записано название улици 
 * проспекта и тд.
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
