package com.mycompany.payment;
import java.util.*;

public class Main 
{
    static ArrayList<Employee>myEmployees= new ArrayList<Employee>();
    static ArrayList<Pay>myPays= new ArrayList<Pay>();
    static HashMap<Integer, Double> rates = new HashMap<Integer, Double>();

     static int count=0;
     static Employee emp;  

    Scanner input= new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        rates.put(1,8.50);
         rates.put(2,12.50);
          rates.put(3,15.75);
           rates.put(4,15.00);
        String choice;
        
        do {
        System.out.println("----------------------------------------------------------");    
        System.out.println("----------WELCOME TO FLEUR DE LYS INN PAY SYSTEM----------");
        System.out.println("----------------------------------------------------------");   
        System.out.println("Enter your menu choice:");
        System.out.println("1-Add Employee");
        System.out.println("2-Add Pay");
        System.out.println("3-Calculate contributions to the Pension Fund ");
        System.out.println("4-Calculate contributions to EI");
        System.out.println("5-Display List of hourly rate employees");
        System.out.println("6-Display List of commission employees");
        System.out.println("7-Exit");
        System.out.println("-----------------------------------------------");
        
        Scanner input= new Scanner(System.in);
        
        choice=input.nextLine();
        
        
        switch(choice)
        {
            case "1":
                AddEmployee();
                break;
            case "2":
                AddPay();
                break;
            case "3":
                System.out.println("The total of Pension Fund is: "+TotalContPensionFund());
                break;
            case "4":
                System.out.println("The total of EI is: "+TotalContEI());
                break;
            case "5":
                DisplayListHrRateEmpl();
                break;
            case "6":    
                DisplayListCommissionEMp();
                break;
            case "7":
                System.out.println("You are going to exit the program!");
                break;
             default:
                System.out.println("Invalid menu choice,please try again.");
                    break;    
            
        }
        
      } while (choice !="7");    
        
    }
   
     private static void AddEmployee()
     {
         Scanner input= new Scanner(System.in);
         System.out.println("Please enter  a number for the employee's id: ");
         int id=0;
          
         try {
            
             id= input.nextInt();
         } catch (Exception e)
         {
             System.out.println("Wrong input,please try again");
             return;
         }
         if ( GetEmployee(id)!=null )
         {
             System.out.println(" This ID already exists, please try again!");
             return;
         }
          int dept =0; 
          boolean success =false;
         System.out.println("Please enter employee's name: ");
         String name= input.next();
         do {
             
             System.out.println("Please enter number of the department: ");
         System.out.println("1-Restaurant ");
         System.out.println("2-Maintenance ");
         System.out.println("3-Clerk/Landscapers ");
         System.out.println("4-Sales");
             try {
                    dept= input.nextInt();
             } catch (Exception e) 
             {
                 success=false;
             }
         
             if (dept<=4 && dept>0)
             {
                 success=true;
             }input.nextLine();
         } while (!success );
         
         
        
         Employee emp= new Employee(id,name,dept);
         myEmployees.add(emp);
         for (int i = 0; i < myEmployees.size(); i++) 
         {
            myEmployees.get(i).Display();
         }
        
     }
     private static void AddPay() 
     {
        Scanner input= new Scanner(System.in);
        
         System.out.println("Please enter the week number: ");
         int wkNumber=0;
         try {
              wkNumber= input.nextInt();
         } catch (Exception e)
         {
             System.out.println("Wrong input,please try again");
             return;
         }
          if ( GetWkNumber(wkNumber) !=null )
         {
             System.out.println(" This week has been already paid, please try again!");
             return;
         }
        
         System.out.println("Please enter a number for the Id's Employee: ");
         int id=0;
         try {
           id= input.nextInt();
         } catch (Exception e)
         {
              System.out.println("Wrong input,please try again");
             return;
         }
          if ( GetEmployee(id)==null )
         {
             System.out.println(" This Employee's ID doesn't exist please try again!");
             return;
         }
         
         System.out.println("Please enter the hours worked in the week: ");
         double hrs=0;
         try {
          hrs=input.nextDouble();
         } catch (Exception e)
         {
             System.out.println("Wrong input, please try again!");
             return;
         }
         if (CheckHours(hrs)!=null) 
         {
             System.out.println("Wrong input,please try again!");  
             return;
         }
         
         
        Employee emp= GetEmployee(id);
        
        
        double comm=0;
          double sales=0;
          double rate = rates.get(emp.getDepartment());

         double ttPay=0;
         if (emp.isSales())
         {  
            System.out.println("Please enter the gross sales: ");
            sales=input.nextDouble();
            comm= CalcCommission(sales);
             
             if (hrs>44) 
             {
                
                 ttPay=44*rate+comm; 
               System.out.println("Your gross pay is: "+ttPay);
             }
             else
             {
             ttPay= hrs * rate+comm;
             System.out.println("Your gross pay is: "+ttPay);
             }
            
         }
        else if (hrs<=44)
         {
            
             ttPay= hrs * rate;
             System.out.println("Your gross pay is: "+ttPay);
         }
         else
         {
             ttPay=(44* rate)+( (hrs - 44)* (rate *1.5));
             System.out.println("Your gross pay is: "+ ttPay);
         }
    
            Pay pp= new Pay(wkNumber,id,hrs,rate,sales,comm,ttPay);
            myPays.add(pp);
            for (int i = 0; i < myPays.size(); i++) 
            {
              myPays.get(i).DisplayPays();
            }
     }
     
     private static double CalcCommission(double sales) {
         if (sales>=2500 && sales<=4250) 
             {
                 
                return sales *1.5/100;
             }
             else if (sales>4250 && sales<=7000) 
             {
                 return sales *2.5/100;
             }
             else if (sales>7000) {
                  return sales *5/100;
             }
         return 0;
    }
 
   
        private static Employee GetEmployee( int id)
        {
             for (int i = 0; i < myEmployees.size(); i++) 
            {  if (myEmployees.get(i).getEmployeeId() == id) 

            {
               return myEmployees.get(i);
            }

            }
            return null; 
        }
        
        private static Pay GetWkNumber (int wk)
        {
            for (int i = 0; i < myPays.size(); i++) 
            {
                if (myPays.get(i).getWeekNumber()== wk) 
                {
                    return myPays.get(i);
                }
            }
            return null;
        }
        private static Pay CheckHours(double hrs){
            
            for (int i = 0; i < myPays.size(); i++) 
            {
                if (myPays.get(i).getNumberHours()==hrs)
                {
                    return myPays.get(i);
                }
            }
            return null;
        }

     private static double  TotalContPensionFund()
     {
        double amount=0;
         for (int i = 0; i < myPays.size(); i++)
         {
             amount += myPays.get(i).CalcPensionFund();
         }
         return amount;
        
    }


    private  static double TotalContEIEmployee() 
    {
        double amount=0;
        for (int i = 0; i < myPays.size(); i++) 
        {
            amount += myPays.get(i).CalcEIEmployee();
        }
        return amount;
    }

    private static double TotalContEIEmployeer() 
    {
        double amount=0;
        for (int i = 0; i < myPays.size(); i++) 
        {
            amount += myPays.get(i).CalcEIEmployeer();
        }
          return amount ; 
    }

    private static double TotalContEI()
    {
          double totalEI=0;
      totalEI= TotalContEIEmployeer() + TotalContEIEmployee() ;
       return totalEI;
    }
    
     private static void DisplayListHrRateEmpl()
    {
        double nbSupp = 0;
        for (int i = 0; i < myPays.size(); i++) 
        {
            Employee emp=GetEmployee(myPays.get(i).getEmployeeId());
        }
        for (int i = 0; i < myEmployees.size(); i++)
        {
            nbSupp=0;
            if(myEmployees.get(i).getDepartment() < 4 && myEmployees.get(i).getDepartment() >0 )
         
            {
                myEmployees.get(i).DisplayRateEmployees();
                for(Pay p: myPays)
                {
                    if(p.getEmployeeId() == myEmployees.get(i).getEmployeeId() )
                    {
                        if(p.getNumberHours() > 44)
                        {
                            nbSupp += p.getNumberHours()-44;
                        }
                    }
                }
                System.out.println("Number of overtime hours: " + nbSupp);
                
            }
        }
        
    }

    private static void DisplayListCommissionEMp() 
    {
        double ttSales=0;
        
          //  Employee emp= getEmployee(myPays.get(i).getEmployeeId());
            for (int j = 0; j < myEmployees.size(); j++)
            {
                 ttSales=0;
                if (myEmployees.get(j).getDepartment() == 4)
                {
                    myEmployees.get(j).DisplayCommEmployee();
                       for(Pay p : myPays) 
                       {
                           if (p.getEmployeeId()== myEmployees.get(j).getEmployeeId()) 
                           {
                               ttSales += p.getGrossSales();
                           }
                       }
                       System.out.println(" Total of gross sales: "+ ttSales);
                }
                
            }
        
    }
 
    
    
    
    
    
    
}    

   

