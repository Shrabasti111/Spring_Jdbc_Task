package com.stackroute.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        //Inserting values into the Employee table
        EmployeeDAO dao=applicationContext.getBean("edao",EmployeeDAO.class);
        int status=dao.insertEmployee(new Employee(8,"Jim",27,"male"));
        System.out.println(status);
        //Updating the Employee table
        System.out.println("----Updating Record with ID -----" );
        dao.updateEmployee(5, "Pam","female");
        //Performing delete operation
        System.out.println("delete");
        Employee e=new Employee();
        e.setId(2);
        status=dao.deleteEmployee(e);
        System.out.println(status);
        //Performing select query
        System.out.println("select query");
        List<Employee> list=dao.retreiveEmployees();
        for(Employee e1:list)
            System.out.println(e1);
    }
}