package TH20;

import java.util.HashMap;

public abstract class Employee implements IEmployee<Object> {
	private int id;
	private String name;

	public Employee(int id) {
		this.id = id;
		
		EmployeePersistMgr.addEmployee(this);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void fire(){
		EmployeePersistMgr.delEmployee(this);
	} 
	
	public void addSubordinate( IEmployee<? super Employee > subordinate){
		
	}
	
	public void delSubordinate( IEmployee<? super Employee > subordinate){
		
	}

	@Override
	public IEmployee<?> getChief() {
		return null;
	}

	@Override
	public void setChief(IEmployee<?> chief) {
	
	}

	@Override
	public HashMap<Integer, IEmployee<?>> getSubordinates() {
		return EmployeePersistMgr.getEmployees(this);
	}
}
