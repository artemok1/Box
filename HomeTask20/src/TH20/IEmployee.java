package TH20;

import java.util.HashMap;

public interface IEmployee<E> {
	public int getId();

	public String getName();

	public abstract IEmployee<?> getChief();

	public void setChief(IEmployee<?> chief);

	public void setName(String name);

	public void fire();
	
	public void addSubordinate( IEmployee<? super Employee > subordinate);
	
	public void delSubordinate( IEmployee<? super Employee > subordinate);
	
	public HashMap<Integer, IEmployee<?>> getSubordinates();
}
