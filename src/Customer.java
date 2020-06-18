public class Customer {
	private int ws_ssn;
	private int ws_cust_id;
	private String ws_name;
	private String ws_adrs;
	private int ws_age;

	public Customer(int ws_ssn, int ws_cust_id, String ws_name, String ws_adrs, int ws_age) {
		this.ws_ssn = ws_ssn;
		this.ws_cust_id = ws_cust_id;
		this.ws_name = ws_name;
		this.ws_adrs = ws_adrs;
		this.ws_age = ws_age;
	}

	public int getWs_ssn() {
		return ws_ssn;
	}

	public void setWs_ssn(int ws_ssn) {
		this.ws_ssn = ws_ssn;
	}

	public int getWs_cust_id() {
		return ws_cust_id;
	}

	public void setWs_cust_id(int ws_cust_id) {
		this.ws_cust_id = ws_cust_id;
	}

	public String getWs_name() {
		return ws_name;
	}

	public void setWs_name(String ws_name) {
		this.ws_name = ws_name;
	}

	public String getWs_adrs() {
		return ws_adrs;
	}

	public void setWs_adrs(String ws_adrs) {
		this.ws_adrs = ws_adrs;
	}

	public int getWs_age() {
		return ws_age;
	}

	public void setWs_age(int ws_age) {
		this.ws_age = ws_age;
	}
}
