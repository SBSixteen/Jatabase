import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
//		Column g = new Column("Name", "String");
//		g.insertCol("Address", "String");
//		g.insertCol("Age", "Integer");
//		g.insertCol("PAKO", "boolean");
//		g.InsertRec("Haseeb:Khyaban e Rahat:30:F");
//		g.InsertRec("Nabeel:Khyaban e Rahat:29: ");
//
//		//g.DisplayColsJava();
//		//g.DeleteRec(0); g.DeleteRec(0); g.DeleteRec(0);g.DeleteRec(0);
//		//g.DeleteRec(0);
//		g.ModColSuff("Age", " Year");
//		g.ModColSuff("Age", " Years");
//		System.out.println();
//		
//		
//		
//		g.DisplayCols();
//		g.printRecs();
//		g.InsertRec("Nabeel:Khyaban e Rahat:23: ");
//		g.insertCol("Salary", "Integer");
//		System.out.println();
//		g.InsertRec("Nabeel:Khyaban e Rahat:23: :45000");
//		//g.ModColSuff("Salary", "$");
//		g.DisplayColsHuman();
//		g.ModColPref("Salary", "RUB");
//		String[] X= {"Name","Salary"};
//		g.printSelectiveRecs(X);
		
//		String[] X = {"Name", "Salary", "Age"};
//		String[] X_1 = {"Name", "MaxSpeed"};
//		String[] Y = {"String", "Integer", "Integer"};
//		String[] Y_1 = {"String", "Integer"};
//	
//		Interpretor.D[0] = new Table("Employee", X, Y);
//		Interpretor.D[1] = new Table("Cars", X_1, Y_1);
//	//	I.HitScan(I.MakeReadable("fetch * from Employee"));
//		Interpretor.D[0].InsertRec("Nabeel:34000:22");
//		Interpretor.D[0].InsertRec("Sabeel:34000:22");
//		Interpretor.D[0].InsertRec("Jabeel:34000:22");
//		//Interpretor.HitScan(Interpretor.MakeReadable("fetchr 2 Age:Name:Salary from Employee"));
//	//	System.out.println();
//		Interpretor.HitScan(Interpretor.MakeReadable("ADDR Imtiaz:34700:22 to Employee"));
//		Interpretor.HitScan(Interpretor.MakeReadable("ADDR RX-8:200 to Cars"));
//		Interpretor.HitScan(Interpretor.MakeReadable("ADDR RX-7:212 to Cars"));
	//	Interpretor.HitScan(Interpretor.MakeReadable("fetch * from Employee"));
	//	System.out.println();
		//Interpretor.HitScan(Interpretor.MakeReadable("fetchr 2 * from Cars"));
		
	//	System.out.println();
	//	Interpretor.HitScan(Interpretor.MakeReadable("fetch Age:Salary:Name from Employee"));
		
		
		Scanner Input = new Scanner(System.in);
		//Interpretor.Init(128);
		while(true) {
			
			System.out.print("Input :");
			String S = Input.nextLine();
			if(S.toLowerCase().equals("bye")) {
				ErrorWarning.Throw(3000);
				break;
			}
			Interpretor.HitScan(Interpretor.MakeReadable(S));
			System.out.println();
			
		}
		
		
		
		
	}
}