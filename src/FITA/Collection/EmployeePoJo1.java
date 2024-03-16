package FITA.Collection;

public class EmployeePoJo1 implements Comparable<EmployeePoJo1> {
    private int id;
    private String name;
    private float salary;
    private String dept;

    public EmployeePoJo1(){

    }

    public EmployeePoJo1(int id, String name, float salary, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' ;
    }

    @Override
    public int compareTo(EmployeePoJo1 o) {
        if(o.getSalary()>salary)
            return 1;
        else if(o.getSalary()<salary)
            return -1;
        else
            return 0;
        //{OR}
        // return Float.compare(o.getSalary(), salary);
    }
}
//learn comparables & comparator
//stream in collection and lots of functions
