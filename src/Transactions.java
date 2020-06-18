import java.util.Date;

public class Transactions {
	private Integer ws_cust_id;
	private Character ws_accnt_type;
	private Integer ws_amt;
	private Date ws_trxn_date;
	private Character ws_src_typ;
	private Character ws_tgt_typ;

	public Transactions()
	{


	}

	public Transactions(Integer ws_cust_id, Character ws_accnt_type, Integer ws_amt, Date ws_trxn_date, Character ws_src_typ, Character ws_tgt_typ) {
		this.ws_cust_id = ws_cust_id;
		this.ws_accnt_type = ws_accnt_type;
		this.ws_amt = ws_amt;
		this.ws_trxn_date = ws_trxn_date;
		this.ws_src_typ = ws_src_typ;
		this.ws_tgt_typ = ws_tgt_typ;
	}

	public Integer getWs_cust_id() {
		return ws_cust_id;
	}

	public void setWs_cust_id(Integer ws_cust_id) {
		this.ws_cust_id = ws_cust_id;
	}

	public Character getWs_accnt_type() {
		return ws_accnt_type;
	}

	public void setWs_accnt_type(Character ws_accnt_type) {
		this.ws_accnt_type = ws_accnt_type;
	}

	public Integer getWs_amt() {
		return ws_amt;
	}

	public void setWs_amt(Integer ws_amt) {
		this.ws_amt = ws_amt;
	}

	public Date getWs_trxn_date() {
		return ws_trxn_date;
	}

	public void setWs_trxn_date(Date ws_trxn_date) {
		this.ws_trxn_date = ws_trxn_date;
	}

	public Character getWs_src_typ() {
		return ws_src_typ;
	}

	public void setWs_src_typ(Character ws_src_typ) {
		this.ws_src_typ = ws_src_typ;
	}

	public Character getWs_tgt_typ() {
		return ws_tgt_typ;
	}

	public void setWs_tgt_typ(Character ws_tgt_typ) {
		this.ws_tgt_typ = ws_tgt_typ;
	}
}
