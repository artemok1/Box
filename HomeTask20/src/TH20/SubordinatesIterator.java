package TH20;

/*
 * Iterator
 */

import java.util.Iterator;
import java.util.Map;

public class SubordinatesIterator implements
		Iterator<IEmployee<? super Employee>> {
	private IEmployee<? super Employee> employee;
	private Iterator<?> it;

	public SubordinatesIterator(IEmployee<? super Employee> employee) {
		this.setEmployee(employee);

		it = employee.getSubordinates().entrySet().iterator();
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public IEmployee<? super Employee> next() {

		@SuppressWarnings("rawtypes")
		Map.Entry pair = (Map.Entry) it.next();

		@SuppressWarnings("unchecked")
		IEmployee<? super Employee> entry = (IEmployee<? super Employee>) pair
				.getValue();

		return entry;
	}

	public IEmployee<? super Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(IEmployee<? super Employee> employee) {
		this.employee = employee;
	}
}
