package TH20;

public class Director extends Employee {

	public Director(int id) {
		super(id);
	}

	@Override
	public IEmployee<?> getChief() {
		return null;
	}

	@Override
	public void setChief(IEmployee<?> chief) {
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
}
