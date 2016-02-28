package TH11;

public class NumberZeroException extends Exception {

	private static final long serialVersionUID = 1L;

	public String getRussianMessage() {
		return "Нельзя делить на ноль!";
	}
}
