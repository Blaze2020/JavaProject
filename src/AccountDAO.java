import java.sql.SQLException;


public interface AccountDAO {

    boolean insertAccount(Account ac) throws SQLException;
    void getAccountStatus();
    Account showAccountDetails(Account ac);
    boolean deleteAccount(Account ac);
    void depositAmount(Integer a,Integer b);
    void withdrawAmount(Integer a,Integer b);
    void transferAmount(Integer a,Integer b,Integer c);


}
