import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class AccountManagment {

    //For creating account
    static Scanner s=new Scanner(System.in);


    public static void  createAccount() {



            System.out.println("Enter customer id");
            Integer customerId = s.nextInt();
            System.out.println("Enter account type");
            String accountType = s.next();
            System.out.println("Enter deposit amount");
            Integer depositAmount = s.nextInt();
            Integer accountid = generateRandomNo();
            Date date = getcurrentDate();
            System.out.println("Enter duration");
            Integer duration=s.nextInt();

            Account ac = new Account();
            //setters
            ac.setWs_cust_id(customerId);
            ac.setWs_acct_type(accountType);
            ac.setWs_acct_balance(depositAmount);
            ac.setWs_acct_id(accountid);
            ac.setWs_acct_crdate(date);
            ac.setWs_acct_duration(duration);

            //Pushing the values into database
            AccountMgtOpDAO dao=new AccountMgtOpDAO();

            if(dao.insertAccount(ac))
                System.out.println("Account creation initiated successfully");
            else
                System.out.println("Error creating account");



    }

    //For deleting account
    public static void deleteAccount()
    {
        Integer customerid;
        System.out.println("Enter customer id for deleting the account");
        customerid=s.nextInt();
        Account ac=new Account();
        ac.setWs_cust_id(customerid);

        //deleting the account
        AccountMgtOpDAO dao=new AccountMgtOpDAO();

        if (dao.deleteAccount(ac))
        {
            System.out.println("Account deletion initiated successfully");
        }
        else
        {
            System.out.println("Error deleting account");
        }



    }

    //For viewing account status

    public static void accountStatus ()
    {
        System.out.println("Account Status");
        AccountMgtOpDAO dao=new AccountMgtOpDAO();
        dao.getAccountStatus();

    }


    //For viewing account details
    public static void accountDetails() {
        Integer customerid;
        System.out.println("Enter customer id for viewing the account");
        customerid=s.nextInt();
        Account ac=new Account();
        ac.setWs_cust_id(customerid);

        //account details
        AccountMgtOpDAO dao=new AccountMgtOpDAO();
        Account result=dao.showAccountDetails(ac);
        if (result!=null)
        {

            System.out.println(result.getWs_cust_id() + " " + result.getWs_acct_id() + " " + result.getWs_acct_type()
                    + " " + result.getWs_acct_balance());
        }
        else
        {
            System.out.println("Error fetching data");
        }


    }

    //Generating random No
    public static Integer generateRandomNo()
    {
        Random r=new Random();
        //from 0 to 9999
        int no=r.nextInt(10000);
        if (no>999)
            return no;
        else if (no<999 && no>100)
            return no*10;
        else if (no<100 && no>9)
            return no*100;
        else if (no<10 && no>0)
            return no*1000;
        else
            return r.nextInt(10000) ;
    }


    //Get current date
    public static Date getcurrentDate()
    {
        long millis=System.currentTimeMillis();
        return new java.sql.Date(millis);
    }


}
