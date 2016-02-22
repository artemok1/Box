package TH7;

public interface IATM_UI {
	
	public void work();

	public void showSetNum20Message(int num20);

	public void showSetNum50Message(int num50);

	public void showSetNum100Message(int num100);
	
	public void showGetMoneyMessage(String message);
	
	public void close();

}
