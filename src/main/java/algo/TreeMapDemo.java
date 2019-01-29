import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee(4, "a");
		Employee e2 = new Employee(2, "b");
		Employee e3 = new Employee(1, "c");
		Employee e4 = new Employee(3, "d");

		TreeMap<Employee, String> map = new TreeMap<Employee, String>();
		map.put(e1, e1.getName());
		map.put(e2, e2.getName());
		map.put(e3, e3.getName());
		map.put(e4, e4.getName());
		
		System.out.println(map);
		
		Employee e5 = new Employee(3, "d");
		map.put(e5, e5.getName());
		System.out.println(map);
		
		Employee e6 = new Employee(3, "e");
		map.put(e6, e6.getName());
		System.out.println(map);
	}

}

class Employee implements Comparable<Employee>{
	private Integer id;
	private String name;
	public Employee(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Employee e) {
		return this.getId().compareTo(e.getId());
	}
}