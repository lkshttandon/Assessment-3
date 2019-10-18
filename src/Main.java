import java.util.*;


public class Main {

	private static List<Stockmodule> stocks ;
	//	private static List<Stockmodule> Invoice ;
	public static boolean isValid = true;

	public static void main(String[] args) {

		int opt = 0;
		String name,fname;
		float cost;
		int quantity,fquantity;
		int code = 0,fcode,ucode;
		stocks = new LinkedList<>();
		Scanner sc;
		do {
			System.out.println("\n1.Enter Item Data");
			System.out.println("2.Update Item Data");
			System.out.println("3.Show Item Data");
			System.out.println("4.Make Sales");
			System.out.println("5.Exit");
			System.out.println("Please enter an option[1,2,3,4,5]\n");
			sc = new Scanner(System.in);
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				Stockmodule p = new Stockmodule();

				do{
					try {

						System.out.print("Enter Item Code: ");
						code = sc.nextInt();
						if(code < 1000) {
							p.setCode(code);
						}else {
							throw new ValidException("Enter 3 digit code");
						}
						isValid = false;
					}catch(ValidException e) {
						System.err.println(e.getMessage());	
					}
				}while(isValid);
				System.out.print("Enter Item Name: ");
				name = sc.next();
				p.setName(name);
				System.out.print("Enter Cost of Individual item: ");
				cost = sc.nextFloat();
				p.setCost(cost);
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				p.setQuantity(quantity);
				//				p = new Stockmodule(code, name, cost, quantity);
				stocks.add(p);
				break;
			case 2:
				System.out.println("Enter Code to Update: ");
				ucode = sc.nextInt();
				int quant,ucost;
				System.out.println("Enter Quantity: ");
				quant = sc.nextInt();
				System.out.println("Enter Cost: ");
				ucost = sc.nextInt();
				for(Stockmodule k: stocks) {
					if(k.getCode() == ucode) {
						k.setQuantity(quant);
						k.setCost(ucost);
					}
				}
				System.out.println("Data Updated!");
				break;
			case 3:
				for(Stockmodule a: stocks) {
					System.out.println("Code: "+ a.getCode() + " Item: " + a.getName() + " Quantity: " + a.getQuantity() + " Cost: "+ a.getCost());
				}
				break;
			case 4:
				int opt1 = 0,sum = 0;
				List<Salesmodule> Invoice = new LinkedList<>();
				do {
					float tcost = 0;
					System.out.println("1.Make Purchase");
					System.out.println("2.Generate Invoice and Exit");
					opt1 = sc.nextInt();
					switch(opt1) {
					case 1:
						Salesmodule s = new Salesmodule();
						boolean isValid1 = true;
						int temp;
						System.out.println("Enter the Item Code to fetch:");
						fcode = sc.nextInt();
						do{
							System.out.println("Enter the quantity wanted: ");
							fquantity = sc.nextInt();
							for(Stockmodule k: stocks) {
								if(k.getCode() == fcode) {
									fname = k.getName();
									temp = k.getQuantity();
									try {

										if(fquantity <= k.getQuantity()) {

											tcost = fquantity*k.cost;
											s.setFcode(fcode);
											s.setFname(fname);
											s.setFquantity(fquantity);
											s.setTcost(tcost);
											Invoice.add(s);
											temp = temp - fquantity;
											k.setQuantity(temp);

										}else {
											throw new ValidException("Quantity Exceeds the limit!");

										}
										isValid1 = false;
									}catch(ValidException e) {
										System.err.println(e.getMessage());
									}

								}
							}
						}while(isValid1);
						sum += tcost;
						break;
					case 2:
						System.out.println("The Invoice: ");
						System.out.println(String.format("%-3s %-15s %-5s %-10s", "---", "---------------",
								"-----","----------"));
						System.out.println(String.format("%-3s|%-15s|%-5s|%-10s", "ID", "I.Name", "Quant","Cost"));
						System.out.println(String.format("%-3s %-15s %-5s %-10s", "---", "---------------",
								"-----","----------"));
						for(Salesmodule k:Invoice) {
							if (k != null) {
								System.out.println(String.format("%-3s|%-15s|%-5s|%.2f", k.getFcode(), k.getFname(),k.getFquantity(), k.getTcost()));}
						}
						System.out.println(String.format("%-3s %-15s %-5s %-10s", "---", "---------------",
								"-----","----------"));
						break;
					}
				}while(opt1 != 2);
				System.out.println("Total: " + sum);
				break;
			case 5:
				System.out.println("Thanks for Shopping!!");
				break;
			}
		}while(opt != 5);

		sc.close();
	}
}

