package TH20;

public class Manager extends Employee {

	private IEmployee<?> chief;

	public Manager(int id) {
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
	public void addSubordinate(IEmployee<? super Employee> subordinate) {
		if (subordinate == null) {
			return;
		}

		if (EmployeePersistMgr.getEmployee(subordinate.getId()) == null) {
			return;
		}

		subordinate.setChief(this);
	}

	@Override
	public void delSubordinate(IEmployee<? super Employee> subordinate) {
		if (subordinate == null) {
			return;
		}

		if (EmployeePersistMgr.getEmployee(subordinate.getId()) == null) {
			return;
		}

		subordinate.setChief(null);
	}

	@Override
	public String toString() {
		
		String name = "'" + this.getName() + "'";
	 
		return name;
	}
}
