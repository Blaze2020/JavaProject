import java.util.Date;
public class Account{
	private Integer ws_cust_id;
	private Integer ws_acct_id;
	private String ws_acct_type;
	private Integer ws_acct_balance;
	private Date ws_acct_crdate;
	private Date ws_acct_lasttrdate;
	private Integer ws_acct_duration;

	public Account()
	{

	}

	public Account(Integer ws_cust_id, Integer ws_acct_id, String ws_acct_type, Integer ws_acct_balance, Date ws_acct_crdate, Date ws_acct_lasttrdate, Integer ws_acct_duration) {
		this.ws_cust_id = ws_cust_id;
		this.ws_acct_id = ws_acct_id;
		this.ws_acct_type = ws_acct_type;
		this.ws_acct_balance = ws_acct_balance;
		this.ws_acct_crdate = ws_acct_crdate;
		this.ws_acct_lasttrdate = ws_acct_lasttrdate;
		this.ws_acct_duration = ws_acct_duration;
	}


	public Integer getWs_cust_id() {
		return ws_cust_id;
	}

	public void setWs_cust_id(Integer ws_cust_id) {
		this.ws_cust_id = ws_cust_id;
	}

	public Integer getWs_acct_id() {
		return ws_acct_id;
	}

	public void setWs_acct_id(Integer ws_acct_id) {
		this.ws_acct_id = ws_acct_id;
	}

	public String getWs_acct_type() {
		return ws_acct_type;
	}

	public void setWs_acct_type(String ws_acct_type) {
		this.ws_acct_type = ws_acct_type;
	}

	public Integer getWs_acct_balance() {
		return ws_acct_balance;
	}

	public void setWs_acct_balance(Integer ws_acct_balance) {
		this.ws_acct_balance = ws_acct_balance;
	}

	public Date getWs_acct_crdate() {
		return ws_acct_crdate;
	}

	public void setWs_acct_crdate(Date ws_acct_crdate) {
		this.ws_acct_crdate = ws_acct_crdate;
	}

	public Date getWs_acct_lasttrdate() {
		return ws_acct_lasttrdate;
	}

	public void setWs_acct_lasttrdate(Date ws_acct_lasttrdate) {
		this.ws_acct_lasttrdate = ws_acct_lasttrdate;
	}

	public Integer getWs_acct_duration() {
		return ws_acct_duration;
	}

	public void setWs_acct_duration(Integer ws_acct_duration) {
		this.ws_acct_duration = ws_acct_duration;
	}
}
