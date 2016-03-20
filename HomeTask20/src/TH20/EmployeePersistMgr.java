package TH20;

/*
 * Data Base
 */

import java.util.HashMap;

public class EmployeePersistMgr {
	private static HashMap<Integer, IEmployee<?>> employees = new HashMap<Integer, IEmployee<?>>();

	// add new employee
	public static void addEmployee(IEmployee<? super Employee> employee) {
		if (employee == null) {
			return;
		}

		employees.put(employee.getId(), employee);
	}

	// remove employee
	public static void delEmployee(IEmployee<? super Employee> employee) {
		if (employee == null) {
			return;
		}

		employees.remove(employee.getId());
	}
	
	// get employees
	public static IEmployee<?> getEmployee(int id) {
		return employees.get(id);
	}	

	// get employees
	public static HashMap<Integer, IEmployee<?>> getEmployees() {
		return employees;
	}

	// get employee for the chief
	public static HashMap<Integer, IEmployee<?>> getEmployees(
			IEmployee<? super Employee> chief) {
		if (chief == null) {
			return null;
		}

		HashMap<Integer, IEmployee<?>> employeesInt = new HashMap<Integer, IEmployee<?>>();

		for (int i = 1; i <= employees.size(); i++) {
			if (employees.get(i) == null || employees.get(i).getChief() == null) {
				continue;
			}
			
			if (employees.get(i).getChief().getId() == chief.getId()) {
				employeesInt.put(i, employees.get(i));
			}
		}

		return employeesInt;
	}
}
