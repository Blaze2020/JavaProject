public class AccountOperations {

    //To show customer details
    public static void getAccountDetails(int customerId)
    {
        System.out.println(customerId);
    }

    //To deposit
    public  static void depositAmount(int deposit)
    {
        System.out.println("Amount deposited successfully"+deposit);
    }

    //TO withdraw

    public static void withdrawAmount(int withdraw)
    {

        System.out.println("Amount withdrawn successfully");
    }

    //To transfer amount
    public static void transferAmount(int transferAmount,int sourceAccount,int targetAccount)
     {
         System.out.println("Amount transfer completed successfully");

     }

     //To get statment

    public static void getStatment(int accountId)
    {
        System.out.println("MiniStatment Generated");
    }
}
