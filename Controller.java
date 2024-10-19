import java.util.ArrayList;
import java.util.List;
public class Controller {
	List<Employee>list = new ArrayList<Employee>();
	public Employee save(Employee e) {
		list.add(e);
		return e;
	}
	public boolean delete(int id) {
		for (Employee e : list) {
			if(e.getId()== id) {
				list.remove(e);
				return true;
			}
		}
		return false;
	}
	public Employee findById(int id) {
		for (Employee e : list) {
			if(e.getId()== id) {
				return e;
			}
		}
		return null;
	}
	public Employee updatePhone(int id,long newPhone) {
		for (Employee e : list) {
			if(e.getId()== id) {
				e.setPhone(newPhone);
				return e;
			}
		}
		return null;
	}
	public Employee updatePassword(int id,String newPass) {
		for (Employee e : list) {
			if(e.getId()== id) {
				e.setPassword(newPass);
				return e;
			}
		}
		return null ;
	}
	public List<Employee> findAll(){
		return list;
	}
	public List<Employee> findByDepartment(String dName){
		List<Employee> dList = new ArrayList<Employee>();
		for (Employee e:list) {
			if(e.getDepartment().equals(dName)) {
				dList.add(e);
			}
		}
		return dList;
     }
}
