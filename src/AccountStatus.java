import java.sql.Date;

public class AccountStatus {
    Integer customerid;
    Integer accountid;
    String accountype;
    String status;
    String message;
    Date lastupdated;

    public AccountStatus()
    {

    }

    public AccountStatus(Integer customerid, Integer accountid, String accountype, String status, String message, Date lastupdated) {
        this.customerid = customerid;
        this.accountid = accountid;
        this.accountype = accountype;
        this.status = status;
        this.message = message;
        this.lastupdated = lastupdated;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getAccountype() {
        return accountype;
    }

    public void setAccountype(String accountype) {
        this.accountype = accountype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }
}
