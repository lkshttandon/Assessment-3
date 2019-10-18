
public class Salesmodule {
	int fcode;
	int fquantity;
	String fname;
	float tcost;
	
	public Salesmodule() {
		super();
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
	}

	public int getFquantity() {
		return fquantity;
	}

	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public float getTcost() {
		return tcost;
	}

	public void setTcost(float tcost) {
		this.tcost = tcost;
	}

	public Salesmodule(int fcode,String fname, int fquantity, float tcost) {
		super();
		this.fcode = fcode;
		this.fname = fname;
		this.fquantity = fquantity;
		this.tcost = tcost;
	}
}

