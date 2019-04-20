package core;

import entities.Director;
import entities.Employee;
import entities.Operator;
import entities.Supervisor;
import utils.Global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Callcenter {
    private Map<String, List<Employee>> employees;
    private static Callcenter callcenter = new Callcenter();

    public Callcenter() {
        this.employees = new HashMap<>();
        List<Employee> operators = new ArrayList<>();
        List<Employee> supervisors = new ArrayList<>();
        List<Employee> directors = new ArrayList<>();
        Operator operator = new Operator("Mariana");
        Operator operator2 = new Operator("Sofía");
        Operator operator3 = new Operator("Carlos");
        Operator operator4 = new Operator("Mario");
        operators.add(operator);
        operators.add(operator2);
        operators.add(operator3);
        operators.add(operator4);
        Supervisor supervisor = new Supervisor("Estefanía");
        Supervisor supervisor2 = new Supervisor("Martina");
        Supervisor supervisor3 = new Supervisor("Rogelio");
        Supervisor supervisor4 = new Supervisor("Ruperto");
        supervisors.add(supervisor);
        supervisors.add(supervisor2);
        supervisors.add(supervisor3);
        supervisors.add(supervisor4);
        Director director = new Director("María Antonieta");
        Director director2 = new Director("Logan Estefán");
        directors.add(director);
        directors.add(director2);

        this.employees.put(Operator.class.getSimpleName(), operators);
        this.employees.put(Supervisor.class.getSimpleName(), supervisors);
        this.employees.put(Director.class.getSimpleName(), directors);
    }

    public static Callcenter getInstance(){
        return callcenter;
    }

    public Employee getNext(){
        List<Employee> employees;
        Employee employee = null;
        for(String employeeType : Global.EMPLOYEE_TYPES){
            employees = this.employees.get(employeeType);
            if(employees.size() > 0){
                employee = employees.get(0);
                employees.remove(employee);
                break;
            }
        }
        return employee;
    }

    public void add(Employee employee){
        this.employees.get(employee.getClass().getSimpleName()).add(employee);
    }
}
