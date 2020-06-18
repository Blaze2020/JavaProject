import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner s=new Scanner(System.in);
        //AccountMgtOpDAO.connectionToDataBase();

        //Account creation
        //AccountManagment.createAccount();
        //Account Deletion
        //AccountManagment.deleteAccount();
        //Account status
        //AccountManagment.accountStatus();
        //Display account details
        //AccountManagment.accountDetails();

        //Transactions
        //Deposit money
        //TransactionManagment.depositMoney();
        //Withdraw money
        //TransactionManagment.withdrawMoney();
        //Transfer amount
        //TransactionManagment.transferMoney();
        //s.close();

    }
}




//Databse options
/*System.out.println("Enter the username");
        String username=s.nextLine();
        System.out.println("Enter the password");
        String pass=s.nextLine();
        String email = null;
        String password=null;
        System.out.println("DataBase Programming");
        try {
            String host = "jdbc:mysql://localhost:3306/bank";
            String uname = "";
            String upass = "";
            //Class.forName("com.mysql.jdbc.Driver"); depriciated driver
            Class.forName("com.mysql.cj.jdbc.Driver");//new driver version but not neccessary to load as auto loading in IDEA
            Connection con = DriverManager.getConnection(host, uname, upass);
            System.out.println("connection success");

            //Statement st=con.createStatement();
            String sql="SELECT * FROM employee WHERE email=? AND password=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,pass);
            ResultSet rs=st.executeQuery();

            while(rs.next())
            {
                email=rs.getString("email");
                password=rs.getString("password");
            }
            if (username.equals(email) && pass.equals(password))
            {
                System.out.println("Authentication succesfull");
            }
            else
            {
                System.out.println("Authentication failed");
            }

            /*while(rs.next()) {
                int id = rs.getInt(1);
                String email = rs.getString(2);
                String password = rs.getString(3);
                if (username.equals(email) && pass.equals(password))
                {
                    System.out.println("Success fully logged in");
                }
                else
                {
                    System.out.println("Authentication failed");
                }
                //String job = rs.getString(4);

                //String p = id + " " + firstname + " " + lastname + " ";//+ job;
                //System.out.println(p);
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }*/