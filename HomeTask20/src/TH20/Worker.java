package TH20;

public class Worker extends Employee {
	private IEmployee<?> chief;

	public Worker(int id) {
		super(id);
	}

	@Override
	public IEmployee<?> getChief() {
		if (this.chief == null) {
			return null;
		}

		if (EmployeePersistMgr.getEmployee(chief.getId()) == null) {
			this.chief = null;
		}

		return this.chief;
	}

	@Override
	public void setChief(IEmployee<?> chief) {
		if (chief == null) {
			this.chief = null;

			return;
		}

		if (EmployeePersistMgr.getEmployee(chief.getId()) == null) {
			return;
		}

		this.chief = chief;
	}

	@Override
	public String toString() {
		return "'" + this.getName() + "'";
	}

}
