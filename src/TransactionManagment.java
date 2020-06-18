import java.util.Scanner;

public class TransactionManagment {

    static Scanner s=new Scanner(System.in);
    //Deposit money
    public static void depositMoney()
    {
        System.out.println("To deposit the amount");
        System.out.println("Enter the customerid and amount to be deposited");
        Integer customerid=s.nextInt();
        Integer amount=s.nextInt();
        AccountMgtOpDAO dao=new AccountMgtOpDAO();
        //Account ac=new Account();
        dao.depositAmount(customerid,amount);

    }

    //Withdraw money

    public static void withdrawMoney()
    {
        System.out.println("To withdraw the amount");
        System.out.println("Enter the customerid and amount to be withdrawn");
        Integer customerid=s.nextInt();
        Integer amount=s.nextInt();
        AccountMgtOpDAO dao=new AccountMgtOpDAO();
        //Account ac=new Account();
        dao.withdrawAmount(customerid,amount);

    }

    //Transfer money
    public static void transferMoney() {
        System.out.println("Enter the amount to be transfered:");
        Integer transferamount=s.nextInt();
        System.out.println("Enter the src account:");
        Integer srcaccount=s.nextInt();
        System.out.println("Enter the target account:");
        Integer trgtaccount=s.nextInt();
        AccountMgtOpDAO dao=new AccountMgtOpDAO();
        dao.transferAmount(transferamount,srcaccount,trgtaccount);

    }
}
