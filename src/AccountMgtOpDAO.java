import java.sql.*;


//DAO pattern to access perform the database operations

public class AccountMgtOpDAO implements AccountDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/bank";
    public static final String USER = "Username";
    public static final String PASS = "Password";


    //Creating the connection
    public static Connection connectionToDataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//new driver version but not neccessary to load as auto loading in IDEA
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection Success");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection Failed" + e);
        }
        return null;

    }

    @Override
    public boolean insertAccount(Account ac) {

        Connection con;
        PreparedStatement st;
        int i = 0;
        try {
            con = connectionToDataBase();

            String sql = "INSERT INTO account () VALUES(?,?,?,?,?,\n" +
                    "crdata,?);";
            assert con != null;
            st = con.prepareStatement(sql);
            st.setInt(1, ac.getWs_cust_id());
            st.setInt(2, ac.getWs_acct_id());
            st.setString(3, ac.getWs_acct_type());
            st.setInt(4, ac.getWs_acct_balance());
            st.setDate(5, (java.sql.Date) ac.getWs_acct_crdate());
            st.setInt(6, ac.getWs_acct_duration());
            i = st.executeUpdate();

            //closing the connection
            st.close();
            con.close();

            return i == 1;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i == 0;
    }

    @Override
    public boolean deleteAccount(Account ac) {

        Connection con;
        PreparedStatement st;
        int i=0;
        try {
            con = connectionToDataBase();
            String sql1 ="DELETE FROM account WHERE customerid=?;";
            String sql2 ="SELECT * FROM account WHERE customerid=?;";
            assert con != null;
            st = con.prepareStatement(sql2);
            st.setInt(1,ac.getWs_cust_id());
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                ac.setWs_cust_id(rs.getInt(1));
                ac.setWs_acct_id(rs.getInt(2));
                ac.setWs_acct_type(rs.getString(3));
                ac.setWs_acct_balance(rs.getInt(4));
                ac.setWs_acct_crdate(rs.getDate(5));
                ac.setWs_acct_lasttrdate(rs.getDate(6));
                ac.setWs_acct_duration(rs.getInt(7));
            }

            System.out.println("The customer data before deletion");
            System.out.println(ac.getWs_cust_id()+" "+ac.getWs_acct_id()+" "+ac.getWs_acct_type()
            +" "+ac.getWs_acct_balance()+" "+ac.getWs_acct_crdate()+" "+ac.getWs_acct_lasttrdate()
            +" "+ac.getWs_acct_duration());

            //After deletion
            st=con.prepareStatement(sql1);
            st.setInt(1,ac.getWs_cust_id());
            i=st.executeUpdate();

            st.close();
            con.close();

            return i==1;


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return i==0;
    }

    @Override
    public void getAccountStatus() {
        AccountStatus as=new AccountStatus();
        Connection con;
        Statement st;
        try {
            con = connectionToDataBase();
            String sql ="SELECT * FROM accountstatus;";
            assert con != null;
            st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                as.setCustomerid(rs.getInt(1));
                as.setAccountid(rs.getInt(2));
                as.setAccountype(rs.getString(3));
                as.setStatus(rs.getString(4));
                as.setMessage(rs.getString(5));
                as.setLastupdated(rs.getDate(6));
                System.out.println(as.getCustomerid()+" "+as.getAccountid()+" "+as.getAccountype()+"" +
                        " "+as.getStatus()+" "+as.getMessage()+" "+as.getLastupdated());

            }
            st.close();
            con.close();


        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }


    }

    @Override
    public Account showAccountDetails(Account ac) {
        Connection con;
        PreparedStatement st;
        try {
            con = connectionToDataBase();
            String sql = "SELECT * FROM account WHERE customerid=?;";
            assert con != null;
            st = con.prepareStatement(sql);
            st.setInt(1, ac.getWs_cust_id());
            ResultSet rs=st.executeQuery();

            while (rs.next()) {
                ac.setWs_cust_id(rs.getInt(1));
                ac.setWs_acct_id(rs.getInt(2));
                ac.setWs_acct_type(rs.getString(3));
                ac.setWs_acct_balance(rs.getInt(4));
            }
            return ac;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void depositAmount(Integer customerid,Integer amount) {
        Connection con;
        PreparedStatement st;
        int i;
        try
        {
            Account ac=new Account();
            con=AccountMgtOpDAO.connectionToDataBase();
            String sql1="SELECT balance,accountid,customerid FROM account WHERE customerid=?";
            String sql2="UPDATE account SET balance=?\n" +
                    "WHERE customerid=?;";
            assert con != null;
            st=con.prepareStatement(sql1);
            st.setInt(1,customerid);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                ac.setWs_acct_balance(rs.getInt("balance"));
                ac.setWs_acct_id(rs.getInt("accountid"));
                ac.setWs_cust_id(rs.getInt("customerid"));
            }

            System.out.println("Customerid:"+ac.getWs_cust_id()+" "+"Accountid:"+ac.getWs_acct_id());
            System.out.println("Balance before deposit:"+ac.getWs_acct_balance());
            Integer tempbalance=ac.getWs_acct_balance()+amount;

            st=con.prepareStatement(sql2);
            st.setInt(1,tempbalance);
            st.setInt(2,ac.getWs_cust_id());
            i=st.executeUpdate();

            if (i==1)
            {
                System.out.println("Latest balance:"+tempbalance);
                System.out.println("Amount deposited successfully");
            }
            else
            {
                System.out.println("Error depositing");
            }
            st.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void withdrawAmount(Integer customerid, Integer amount) {

        Connection con;
        PreparedStatement st;
        int i;
        try
        {
            Account ac=new Account();
            con=AccountMgtOpDAO.connectionToDataBase();
            String sql1="SELECT balance,accountid,customerid FROM account WHERE customerid=?";
            String sql2="UPDATE account SET balance=?\n" +
                    "WHERE customerid=?;";
            assert con != null;
            st=con.prepareStatement(sql1);
            st.setInt(1,customerid);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                ac.setWs_acct_balance(rs.getInt("balance"));
                ac.setWs_acct_id(rs.getInt("accountid"));
                ac.setWs_cust_id(rs.getInt("customerid"));
            }

            System.out.println("Accountid:"+ac.getWs_acct_id());
            System.out.println("Balance before withdraw:"+ac.getWs_acct_balance());
            Integer tempbalance=ac.getWs_acct_balance()-amount;

            if(tempbalance<0)
                System.out.println("Amount greater than balance enter less amount than balance");
            else if(amount.equals(ac.getWs_acct_balance()))
                tempbalance=ac.getWs_acct_balance();


            st=con.prepareStatement(sql2);
            st.setInt(1,tempbalance);
            st.setInt(2,ac.getWs_cust_id());
            i=st.executeUpdate();

            if (i==1)
            {
                System.out.println("Latest balance:"+tempbalance);
                System.out.println("Amount withdrawn successfully");
            }
            else
            {
                System.out.println("Error withdrawing");
            }

            st.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void transferAmount(Integer transferamount, Integer srcaccount, Integer trgtaccount) {

        Connection con;
        PreparedStatement st;
        int srcamt=0,trgtamt=0;

        try
        {
            con=AccountMgtOpDAO.connectionToDataBase();
            String sql1="SELECT balance FROM account WHERE accountid=?;";
            //String sql2="SELECT accountid,balance FROM account WHERE accountid=?;";
            //String sql3="UPDATE account SET balance=? WHERE accountid=?;";
            String sql2="UPDATE account SET  balance=? WHERE accountid=?;";

            System.out.println("Source accountid:"+srcaccount+" "+"Target accountid:"+trgtaccount);
            System.out.println("Balance before transfer for both the accounts:");
            //selecting money from srcaccount
            assert con != null;
            st=con.prepareStatement(sql1);
            st.setInt(1,srcaccount);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                srcamt=rs.getInt("balance");
            }
            System.out.print(srcamt+" ");
            if (srcamt<transferamount)
            {
                System.out.println("Transfer not allowed, please choose smaller amount");
                return;
            }


            //updating the srcaccount value
            st=con.prepareStatement(sql2);
            st.setInt(1,srcamt-transferamount);
            st.setInt(2,srcaccount);
            int i=st.executeUpdate();

            //selecting money from trgtaccount
            st=con.prepareStatement(sql1);
            st.setInt(1,trgtaccount);
            rs=st.executeQuery();
            while(rs.next())
            {
                trgtamt=rs.getInt("balance");
            }
            System.out.println(trgtamt);
            //updating the trgtaccount value
            st=con.prepareStatement(sql2);
            st.setInt(1,trgtamt+transferamount);
            st.setInt(2,trgtaccount);
            int j=st.executeUpdate();

            System.out.println("Latest balance for both accounts");
            System.out.print(srcamt-transferamount+" ");
            System.out.println(trgtamt+transferamount);

            if (i==1 && j==1)
            {
                System.out.println("Amount transfer completed successfully");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
