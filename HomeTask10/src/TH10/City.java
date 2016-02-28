package TH10;

import java.util.ArrayList;

public class City {
	String name;

	ArrayList<Avenue> avenues = new ArrayList<Avenue>();
	ArrayList<Street> streets = new ArrayList<Street>();
	ArrayList<Square> squares = new ArrayList<Square>();

	public City(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean setAvenue(String name) {
		for (int i = 0; i < avenues.size(); i++) {
			if (avenues.get(i).getName() == name) {
				return false;
			}
		}

		Avenue avenue = new Avenue(name);

		avenues.add(avenue);

		return true;
	}
	
	public String[] getAvenues(){
		String[] avenue = new String[avenues.size()];
		
		for (int i = 0; i < avenues.size(); i++) {
			avenue[i] = avenues.get(i).getName();
		}
		
		return avenue;
	}
	
	public boolean setStreet(String name) {
		for (int i = 0; i < streets.size(); i++) {
			if (streets.get(i).getName() == name) {
				return false;
			}
		}

		Street street = new Street(name);

		this.streets.add(street);

		return true;
	}
	
	public String[] getStreets(){
		String[] streets = new String[this.streets.size()];
		
		for (int i = 0; i < this.streets.size(); i++) {
			streets[i] = this.streets.get(i).getName();
		}
		
		return streets;
	}	
	
	public boolean setSquare(String name) {
		for (int i = 0; i < squares.size(); i++) {
			if (squares.get(i).getName() == name) {
				return false;
			}
		}

		Square square = new Square(name);

		this.squares.add(square);

		return true;
	}
	
	public String[] getSquares(){
		String[] squares = new String[this.squares.size()];
		
		for (int i = 0; i < this.squares.size(); i++) {
			squares[i] = this.squares.get(i).getName();
		}
		
		return squares;
	}		

	// Avenue
	class Avenue {
		String name;

		Avenue(String name) {
			super();

			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	// Street
	class Street {
		String name;

		Street(String name) {
			super();

			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	// Square
	class Square {
		String name;

		Square(String name) {
			super();

			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}
}
