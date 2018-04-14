package task;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class task{
public static void main(String[] args) throws ParseException {
	    Employee sysEngineer = new Employee("Robert", "Cortes", "Programmer");
	    IdCard card = new IdCard(123);
	    card.setDateExpire(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-10"));
		sysEngineer.setIdCard(card);
	    System.out.println(sysEngineer.getName() +" работает в должности "+ sysEngineer.getPosition());
	    System.out.println("Удостоверение действует до " + sysEngineer.getIdCard().getDateExpire());
	    Department programmersDepartment = new Department("Программисты");
	    programmersDepartment.addEmployee(sysEngineer);
	    System.out.println("Относится к отделу "+sysEngineer.getDepartment().getName());
	    sysEngineer.setPosition("Сторож");
	    System.out.println("В прошлом работал как:");
	    Iterator<PastPosition> iter = sysEngineer.getPastPosition().iterator();
	    while(iter.hasNext()){
	    	System.out.println( ((PastPosition) iter.next()).getName());
	    }
	    Employee director = new Employee("Федор", "Дубов", "Директор");
	    Menu menu = new Menu();
	    Employee employees[] = new Employee[10];
	    employees[0]= sysEngineer;
	    employees[1] = director;
	    Menu.showEmployees(employees);
	    System.out.println("В отделе "+sysEngineer.getDepartment().getName()+" работает "
	    		+sysEngineer.getDepartment().getPersonCount()+" человек.");
	    }

}

class Man {
	protected String name;
	protected String surname;
	protected String getSurname() {
		return surname;
	}
	public void setName(String newName){
		name = newName;
	}
	public void setSurName(String newSurname){
		surname = newSurname;
	}
	public String getName(){
		return name;
	}
	public String getSurName(){
		return surname;
	}
}
class Employee extends Man {
	private String position;
	private IdCard iCard; 
	private Department department;
	private Set<PastPosition> pastPosition = new HashSet<PastPosition>();
	public Employee(String n,String s, String p) {
		name = n;
		surname = s;
		position = p;
	}
	public void setPosition(String newPosition) {
		position = newPosition;
	}
	public String getPosition() {
		return position;
	}
	public void setIdCard(IdCard c) {
		iCard = c;
	}
	public IdCard getIdCard() {
		return iCard;
	}
	public void setDepartment(Department d){
	    department = d;
	}
	public Department getDepartment(){
	    return department;
	}
	public void setPastPosition(PastPosition p){
	     pastPosition.add(p);
	}
	public Set<PastPosition> getPastPosition(){
	     return pastPosition;
	}
	public void deletePastPosition(PastPosition p){
	     pastPosition.remove(p);
	}
}
class IdCard {
	private Date dateExpire;
	private int number;
	public IdCard(int n){
		number = n;
	}
	public void setNumber(int newNumber){
		number = newNumber;
	}
	public int getNumber(){
		return number;
	}
	public void setDateExpire(Date newDateExpire){
		dateExpire = newDateExpire;
	}
	public Date getDateExpire(){
		return dateExpire;
	}
}
class Department implements Unit{
    private String name;
    private Set<Employee> employees = new HashSet<Employee>();
    
    public Department(String n){
        name = n;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public void addEmployee(Employee newEmployee){
        employees.add(newEmployee);
        newEmployee.setDepartment(this);
    }
    public Set<Employee> getEmployees(){
        return employees;
    }
    public void removeEmployee(Employee e){
        employees.remove(e);
    }
	@Override
	public int getPersonCount(){
        return getEmployees().size();
    }
}
class PastPosition{
    private String name;
     private Department department;
     public PastPosition(String position, Department dep){
         name = position;
         department = dep;
     }
     public void setName(String newName){
         name = newName;
     }
     public String getName(){
         return name;
     }
     public void setDepartment(Department d){
         department = d;
     }
     public Department getDepartment(){
         return department;
     }
}
class Menu{
    private static int i=0;
    public static void showEmployees(Employee[] employees){
        System.out.println("Список сотрудников:");
        for (i=0; i<employees.length; i++){
            if(employees[i] instanceof Employee){
                System.out.println(employees[i].getName() +" - " + employees[i].getPosition());
			}
		}
    }
}
interface Unit{
    int getPersonCount();
}

