import java.util.List;
import java.util.Scanner;
public class View {
	public static void main(String[] args) {
		Controller c=new Controller();
		Scanner sc=new Scanner(System.in);
		System.out.println("!----------WELCOME----------!");
		System.out.println("Enter user name");
		String userName=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		if("Monisha".equals(userName)&&"Isiri".equals(pass)) {
			System.out.println("you are successfully Logged in");
			System.out.println("<!---------------------------------!>");
			do {
				System.out.println("Choose options to perform: ");
				System.out.println("1.To upload Employee details");
				System.out.println("2.To update Employee PhoneNumber");
				System.out.println("3.To update Employee Password");
				System.out.println("4.To delete Employee details");
				System.out.println("5.To find all Employee details");
				System.out.println("6.To find the Employee by their ID");
				System.out.println("7.To find the Employee by their Department");
				System.out.println("<!-------------------------------------------!>");
				switch(sc.nextInt()) {
				case 1:{
					Employee e = new Employee();
					System.out.println("Enter Employee Id");
					e.setId(sc.nextInt());
					System.out.println("Enter Employee Name");
					e.setName(sc.next());
					System.out.println("Enter Phonenumber");
					e.setPhone(sc.nextLong());
					System.out.println("Enter Password");
					e.setPassword(sc.next());
					System.out.println("Enter Department");
					e.setDepartment(sc.next());
					
					c.save(e);
				}
				break;
				case 2:{
					System.out.println("Enter Employee Id");
					int id=sc.nextInt();
					System.out.println("Enter new Phonenumber");
					long nPhone=sc.nextLong();
					Employee e = c.updatePhone(id, nPhone);
					System.out.println(e);
				}
				break;
				case 3:{
					System.out.println("Enter Employee Id");
					int id=sc.nextInt();
					System.out.println("Enter new Password");
					String nPass=sc.next();
					Employee e = c.updatePassword(id, nPass);
					System.out.println(e);
				}
				break;
				case 4:{
					System.out.println("Enter Employee ID to delete Employee");
					boolean res=c.delete(sc.nextInt());
					if(res) {
						System.out.println("Deleted successfully");
					}else {
						System.out.println("Wrong id");
					}
				}
				break;
				case 5:{ 
					System.out.println("All the Employee Details are ");
					List<Employee> listE=c.findAll();
					if(listE != null) {
						System.out.println(listE);
					    }else {
						System.out.println("There is no Employees!");
					    }
				}
				break;
				case 6:{
					System.out.println("Enter ID to find the Employee");
					Employee e=c.findById(sc.nextInt());
					if(e != null) {
						System.out.println(e);
					    }else {
						System.out.println("No Employee for given ID");
					    }
				}
				break;
				case 7:{
					System.out.println("Enter Department Name to find the Employee");
					List<Employee> listE=c.findByDepartment(sc.next());
				    if(listE != null) {
					System.out.println(listE);
				    }else {
					System.out.println("No Employee for given Department");
				    }
				}
				break;
				default:throw new IllegalArgumentException("Unexpected value");
			}
				System.out.println("Enter * to perform operation");
			}while("*".equals(sc.next()));
		}else {
			System.out.println("UserName and Password is incorrect");
			sc.close();
		}
		
	}

}

