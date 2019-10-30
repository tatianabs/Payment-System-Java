package com.mycompany.payment;

import java.util.Date;

public class Pay
{
    //fields
   private int weekNumber;
   private int employeeId;
   private double numberHours;
   private double hourRate;
   private double grossSales;
   private double commission;
   private double ttPay;
     
   
    //constructors
    public Pay(int _wkNumber, int _empId, double _numHours, double _hrRate, double _grsSales,double _comm,double _ttPay) {
        this.weekNumber = _wkNumber;
        this.employeeId = _empId;
        this.numberHours = _numHours;
        this.hourRate = _hrRate;
        this.grossSales = _grsSales;
        this.commission= _comm;
        this.ttPay= _ttPay;
    }

    Pay() {
        
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double comm) {
        this.commission = comm;
    }
    
    
    
    
    //getters aand setters

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int wkNum) {
        this.weekNumber = wkNum;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int empId) {
        this.employeeId = empId;
    }

    public double getNumberHours() {
        return numberHours;
    }

    public void setNumberHours(double numHrs) {
        this.numberHours = numHrs;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hrRt) {
        this.hourRate = hrRt;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grsales) {
        this.grossSales = grsales;
    }

    
    public double getTtPay() {
        return ttPay;
    }

    public void setTtPay(double ttPay) {
        this.ttPay = ttPay;
    }
    
    
    //methods
    public double CalcFederalIncome()
    {
        if (getTtPay()>35000) 
        {
            double parcialPay=35000 * 16/100;
            return (getTtPay() - 35000 *22/100) + parcialPay;
        }else
        {
          return  getTtPay() *16/100;
        }
        
    }
   
      public double CalcProvincialIncome()
    {
        if (getTtPay() >35000) 
        {
            double parcialPay=35000 * 6.05/100;
            return (getTtPay() - 35000 *7.25/100) + parcialPay;
        }else
        {
          return  getTtPay() *6.05/100;
        }
        
    }
    public double CalcPensionFund()
       {
          return  getTtPay()*4.95/100; 
          
       }
    
      public double CalcEIEmployee()
      {
          return getTtPay()*1.98/100;
      }
      
      public double CalcEIEmployeer()
      {
          return getTtPay()*2.77/100;
      }

    void DisplayPays()
    {
       System.out.println("==============================================");
        System.out.println("************List of Payments**************** ");
        System.out.println("Week number: " +this.getWeekNumber());
        System.out.println("Employee's id: "+this.getEmployeeId());
        System.out.println("Hours worked " +this.getNumberHours());
        System.out.println("Hourly rate : "+ this.getHourRate());
        System.out.println("Gross sales : "+ this.getGrossSales());
        System.out.println("Commission : "+ this.getCommission());
        System.out.println("Gross pay : "+ this.getTtPay());
    }
    
   
    
    
    
    
    
}
