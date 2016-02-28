package TH11;

public class CalculatorEngine {
	public double parseDouble(String data) throws NumberException {
		double num = 0;

		try {
			num = Double.parseDouble(data);
		} catch (NumberFormatException e) {

			throw new NumberException();
		}

		return num;
	}

	public double add(double param1, double param2) {
		double res = 0;

		res = param1 + param2;

		return res;
	}

	public double sub(double param1, double param2) {
		double res = 0;

		res = param1 - param2;

		return res;
	}

	public double div(double param1, double param2) throws NumberZeroException {
		double res = 0;

		if (param2 == 0) {
			throw new NumberZeroException();
		}

		res = param1 / param2;

		return res;
	}

	public double mult(double param1, double param2) {
		double res = 0;

		res = param1 * param2;

		return res;
	}
}
