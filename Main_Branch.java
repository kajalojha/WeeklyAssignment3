package WeeklyAssignment3_Atm_Simulation;
import java.util.Scanner;

public class Main_Branch {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bank b=new Bank();
        b.Addaccount();
        Simulation simulate = new Simulation();
        Account account = null;

        String user=null;
        char choice;
        while(true){
            System.out.println("         ATM");
            System.out.println("    1.Login");
            System.out.println("   2.Transfer Money");
            System.out.println("   3.Withdraw");
            System.out.println("   4.Check Balance");
            System.out.println("   5.Log Out ");
            choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    try{

                        boolean loop = true;
                        do{
                            System.out.println("Select your bank:");
                            System.out.println("1. hdfc\n2. sbi\n3. icici\n4. Exit..");
                            char choice1 = sc.next().charAt(0);
                            switch(choice1) {
                                case '1':
                                    user = "hdfc";
                                    account = simulate.login(user, sc,b);
                                    loop = false;
                                    break;
                                case '2':
                                    user = "sbi";
                                    account = simulate.login(user, sc,b);
                                    loop = false;
                                    break;
                                case '3':
                                    user = "icici";
                                    account = simulate.login(user, sc,b);
                                    loop = false;
                                    break;
                                case '4':
                                    System.exit(0);
                                default:
                                    System.out.println("Enter valid choice");
                            }
                        }while(loop);
                    }
                    catch(InvalidPinException | accountNotFound e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case '2':
                    // if user not logged in
                    if(account == null){
                        System.out.println("Login first...");
                        break;
                    }
                    try{
                        String recipientBank;
                        boolean loop = true;
                        do{
                            System.out.println("Select recipient bank:");
                            System.out.println("1. hdfc\n2. sbi\n3. icici\n4. Exit..");
                            char choice1 = sc.next().charAt(0);
                            if(user == null){
                                System.out.println("Please login first");
                                break;
                            }

                            switch(choice1) {
                                case '1':
                                    recipientBank = "hdfc";
                                    simulate.transaction(recipientBank, account, user, sc,b);
                                    loop = false;
                                    break;
                                case '2':
                                    recipientBank = "sbi";
                                    simulate.transaction(recipientBank, account, user, sc,b);
                                    break;
                                case '3':
                                    recipientBank = "icici";
                                    simulate.transaction(recipientBank, account,user, sc,b);
                                    loop = false;
                                    break;
                                case '4':
                                    System.exit(0);
                                default:
                                    System.out.println("Enter valid choice");
                            }
                        }while(loop);
                    }
                    catch(accountNotFound | insufficientFund e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case '3':
                    try{
                        if(account == null){
                            throw new accountNotFound("Please Login first...");
                        }
                        account.withdraw(sc);
                    }
                    catch(insufficientFund |accountNotFound e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case '4':
                    if(account == null){
                        System.out.println("Login first...");
                        break;
                    }
                    System.out.println( "Balance"+account.getBalance());
                    break;
                case '5':
                    account = null;
                    System.out.println("Logged out successfully");
                    break;
                default:
                    System.out.println("Enter valid choice");
            }

        }
    }
}

