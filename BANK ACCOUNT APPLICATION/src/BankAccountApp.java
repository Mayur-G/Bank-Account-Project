import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        /*
        Checking ch1 = new Checking("Tom Wilson","123456789",1500);

        Savings s1 = new Savings("Rich Lowe","436721237",2500);

        s1.showInfo();
        System.out.println("**********************");
        ch1.showInfo();
        */

        List<Account> accounts = new LinkedList<Account>();

        String file = "F:\\CODING BOI\\Uttara Info Solutions\\Test\\BANK ACCOUNT APPLICATION\\NewBankAccounts.txt";

        List<String[]> newAccountHolder  = CSV.read(file);
        for (String[] accountHolder: newAccountHolder) {
          String name = accountHolder[0];
          String sSN = accountHolder[1];
          String accountType = accountHolder[2];
          double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name+" "+sSN+" "+accountType+" $"+initDeposit);
            if(accountType.equals("Savings")) {
               accounts.add(new Savings(name,sSN,initDeposit));
            }
            else if(accountType.equals("Checking")) {
                accounts.add(new Checking(name,sSN,initDeposit));
            }
            else
            {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc: accounts) {
            System.out.println("\n********************");
            acc.showInfo();
        }
    }
}
