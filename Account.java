package WeeklyAssignment3_Atm_Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account
{
    private String cardNumber;//Card Number
    private int pin;//Pin
    private String name;//Name of account holder
    private double balance;// Balance in the Account
    private boolean blocked=false;

    public Account(String cardNumber,int pin, String name, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.cardNumber = cardNumber;

    }
    //Method to set the status of the card
    public void setBlocked(){
        blocked = true;
    }
    //Blocking the card
    public boolean getBlocked(){
        return blocked;
    }
    public String getName(){
        return name;
    }

    public int getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public void setBalance(double remaining){
        balance = remaining;
    }



    public void addBalance(double amount){
        balance += amount;
        System.out.println("Amount: " + amount+" added to account "+ getName());
    }
    public void deduct(double amount, double charges) throws insufficientFund{

        double accountBalance = getBalance();
        if(accountBalance < (amount + amount*charges)){
            throw new insufficientFund(getName()+"  Insufficient funds in your account ");
        }
        accountBalance -= amount;
        accountBalance -= (amount*charges);
        System.out.println("Your account balance is deducted "+(amount*charges+amount));
        setBalance(accountBalance);
        System.out.println("remaining balance :"+ balance);

    }

    public void withdraw(Scanner sc) throws insufficientFund
    {
        System.out.println("Enter amount you want to withdraw:");
        double amount = sc.nextDouble();
        if(amount > balance)
        {
            throw new insufficientFund(getName()+" Insufficient funds in your account ");
        }
        balance = getBalance();
        balance -= amount;
        setBalance(balance);
        System.out.println("your account is deducted "+amount);
        System.out.println("Remaining Balance:"+balance);
    }
}

