
public class Stockmodule {
 String name;
 float cost;
 int quantity;
 int code;
 
 public Stockmodule() {
	 super();
 }
public Stockmodule(int code,String name, float cost, int quantity) {
	super();
	this.name = name;
	this.cost = cost;
	this.quantity = quantity;
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
 
 
}
