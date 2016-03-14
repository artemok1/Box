package TH17;

// abstract security paper class

public abstract class SecurityPaper implements ISecurityPaper {
	private String name;

	@Override
	public abstract int getId();

	@Override
	public abstract void setId(int id);

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
