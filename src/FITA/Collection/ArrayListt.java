package FITA.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListt {
    public static void main(String[] args) {
        List<EmployeePoJo1> list = new ArrayList<>();
        list.add(new EmployeePoJo1(56,"raja",60000,"EEE"));
        list.add(new EmployeePoJo1(57,"mani",40000,"ECE"));
        list.add(new EmployeePoJo1(58,"Roja",80000,"BEE"));
        list.add(new EmployeePoJo1(59,"Mohan",85000,"BCE"));
        list.add(new EmployeePoJo1(60,"roja",70000,"BBA"));

//        for(EmployeePoJo1 emp : list){
//            //can you both methods
//            if((emp.getName()).startsWith("m") || (emp.getName()).charAt(0)=='M'){
//                System.out.println(emp.toString());
//            }
//        }
//        List<EmployeePoJo1> new_list = new ArrayList<>();
//        Comparator<EmployeePoJo1> byName = (EmployeePoJo1 o1, EmployeePoJo1 o2) -> o1.getName ().compareTo (o2.getName ());
//        System.out.println(byName.toString());
//        Collections.sort (new_list, byName);
//        for(EmployeePoJo1 emp : new_list){
//            System.out.println(emp);
//        }
//        Comparator<EmployeePoJo1> bySalaryDesc = Comparator.comparingDouble(EmployeePoJo1::getSalary); //'::'-> method referencing (ContainingType::methodName)
//        Collections.sort(list,bySalaryDesc);
        Collections.sort(list);
        for(EmployeePoJo1 temp: list){
            System.out.println(temp);
        }
    }
}
