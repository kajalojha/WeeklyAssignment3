package WeeklyAssignment3_Atm_Simulation;

import java.util.ArrayList;
import java.util.List;

class Bank
{
    public List<Account>hdfc;
    public List<Account>sbi;
    public List<Account>icici;

    Account account = null;

    public Bank()
    {
      this.hdfc = new ArrayList<>();
       this. sbi = new ArrayList<>();
       this. icici = new ArrayList<>();
    }


    //Adds Account to the bank
    public void Addaccount() {
        for (int i = 0; i < 10; i++) {
            String name = String.format("Customer" + (i + 1));
            int pin = 1000 + i;
            double balance = 2000000;
            String cardNumber = String.format("%012d", i + 100100);
            account = new Account(cardNumber, pin, name, balance);
            hdfc.add(account);
            cardNumber = String.format("%012d", i + 200200);
            account = new Account(cardNumber, pin, name, balance);
            sbi.add(account);
            cardNumber = String.format("%012d", i + 300300);
            account = new Account(cardNumber, pin, name, balance);
            icici.add(account);

        }
    }

    //Method to select bank list based on the user's bank
    public List<Account>getbank(String bank){
        if(bank.equals("hdfc"))return hdfc;
        if(bank.equals("sbi"))return sbi;
        return icici;
    }
    //Method to get charges according to the bank
    public double getCharges(String bank){
        if(bank.equals("hdfc"))return 0.03;
        if(bank.equals("sbi"))return 0.01;
        return 0.02;
    }
    //deposits to account

    public void deposit(String recipientcardNumber, double amount,String bank) throws accountNotFound, accountNotFound {
        Account recipientAccount = null;
        for (Account account : getbank(bank))
            if (account != null && account.getCardNumber()!= null && account.getCardNumber().equals(recipientcardNumber))
                recipientAccount = account;
        if (recipientAccount == null) { throw new accountNotFound("Account of recipient does not exist");
        } recipientAccount.addBalance(amount);

    }

    //Deduct charges of transfer from account
    public void deduct(Account userAccount, double amount,String bank)throws insufficientFund,accountNotFound
    {
        Account senderAccount = null;
        for (Account account : getbank(bank))
            if (account != null && account == userAccount)
                senderAccount = account;
        if (senderAccount == null){
            throw new accountNotFound("Account of recipient does not exist");
        }else
        {senderAccount.deduct(amount, getCharges(bank));}
    }

}


