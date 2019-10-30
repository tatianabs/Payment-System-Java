package com.mycompany.payment;

public class Employee
{
    
    //fields
    
   private int employeeId;
   private String name;
   private int department;
    
  
  
    //constructor
    public Employee(int _empId, String _name, int _department)
    {     
        this.employeeId= _empId;
        this.name = _name;
        this.department = _department;
       
       
    }
    
    //getters and setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int empId) {
        this.employeeId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int dep) {
        this.department = dep;
    
    }   


    void Display() 
    {
       
        System.out.println("==============================================");
        System.out.println("************List of Employees**************** ");
        System.out.println("Your id is: "+this.getEmployeeId());
        System.out.println("Your name is: " +this.getName());
        System.out.println("Your department is: "+ this.getDepartment());
    }

    public boolean isSales()
    {
        if (this.getDepartment()==4 ) 
        { 
          
            return true;
        }
       return false;
    }
    
 
    

    void DisplayRateEmployees() 
    {
        System.out.println("=============================================");
        System.out.println("*********List of Hourly Rate Employees*******");
        System.out.println("Employee's Id: " + this.getEmployeeId());
        System.out.println("Name: " + this.getName());
      
       
    }

    void DisplayCommEmployee() 
    {
        Pay pp= new Pay();  
        System.out.println("=============================================");
        System.out.println("********List of Commission Employees*********");
        System.out.println("Employee's Id: " + this.getEmployeeId());
        System.out.println("Name: " + this.getName());
      //  System.out.println("Gross sales: " + pp.getGrossSales());
    }
    
    
    
  
    
}
