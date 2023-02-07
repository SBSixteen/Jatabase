
public class Interpretor {
	
	static Table[] D = new Table[128];
	int counter;
	static int LINES = 0;
	
	static void Init(int x) {
		D = new Table[x];
		return;
	}

	static String[] MakeReadable(String S){
		String[] X = S.split(" ");
		return X;
	}
	
	static void HitScan(String[] X) {
		
		LINES++;
		X[0] = X[0].toLowerCase();
		int locale = -1;
		
		if(X.length == 2) {
			
			if(X[0].equals("det") && X[1].toLowerCase().equals("tables")) {
				infoTables();
			}
			
		}
		
		if(X.length == 3) {
			
			int i = 0;
			while(D[i] != null) {
				if(X[2].equals(D[i].name)) {
					locale = i;
					break;
				}
				i++;
			}
			
			if(locale <0) {
				ErrorWarning.Throw(-13);
				ErrorWarning.Throw(1605);
				return;
			}
			
			if(X[0].equals("det") && X[1].toLowerCase().equals("table")) {
				infoTable(locale);
				return;
			}
			
			if(X[0].equals("erase") && X[1].toLowerCase().equals("table")) {
				
				D[i] = null;
				ErrorWarning.Throw(3001);
				return;
			}
			
			if(X[0].equals("erasedata") && X[1].toLowerCase().equals("table")) {
				
				D[i].DropAll();
				ErrorWarning.Throw(3002);
				return;
			}
			
		}
		
		if(X.length == 4) {
			
			int i = 0;
			
			while(D[i] != null) {
				if(X[3].equals(D[i].name)) {
					locale = i;
					break;
				}
				i++;
			}
			
			if(locale <0) {
				ErrorWarning.Throw(1605);
				return;
			}
			
			X[0] = X[0].toLowerCase();
			
			if(X[0].equals("fetch") && X[2].toLowerCase().equals("from")) {
				Fetch(X, locale);
				return;
			}
			
			if(X[0].equals("addr") && X[2].toLowerCase().equals("to")) {
				Addrow(X[1], locale);
				return;
			}
			
			if(X[0].equals("addc") && X[2].toLowerCase().equals("to")) {
				String[] ND = X[1].split(":");
				D[locale].insertCol(ND[0], ND[1]);
				return;
			}
			
			if(X[0].equals("tampercell") && X[2].toLowerCase().equals("of")) {
				String[] ND = X[1].split(":");
				int x = Integer.parseInt(ND[0]);
				int y = Integer.parseInt(ND[1]);
				D[locale].TamperRecCords(x, y, ND[2]);
				return;
			}
			
			if(X[0].equals("erase") && X[2].toLowerCase().equals("of")) {
				int x = Integer.parseInt(X[1]);
				x--;
				D[locale].DeleteRec(x);
				return;
			}
			
		}
		
		if(X.length == 5) {
			
			int i = 0;
			
			if(X[0].equals("create") && X[1].toLowerCase().equals("table")) {
				//ADD TABLE CARS Name:Speed:RegNo String:Double:String
				AddTable(X);
				return;
			}
			
			
			while(D[i] != null) {
				if(X[4].equals(D[i].name)) {
					locale = i;
					break;
				}
				i++;
			}
			
			if(locale <0) {
				ErrorWarning.Throw(1605);
				return;
			}
			
			if(X[0].toLowerCase().equals("fetchr") && X[3].toLowerCase().equals("from")) {
				Fetchr(X, Integer.parseInt(X[1]), locale);
			}
			
			if(X[0].toLowerCase().equals("tamperrow") && X[3].toLowerCase().equals("of")) {
				//TAMPERROW 3 RX8:400:ABC-123 of Cars
				int y = Integer.parseInt(X[1]);
				String R[] = X[2].split(":");
				D[locale].TamperRecWhole(y, R);
			}
			
		}
		
	}
	
	//fetchr 3 * from Employee
	
	static void Fetch(String X[], int i) {
		
		if(X[1].equals("*")) {
			
			D[i].PrintColsHuman();
			D[i].PrintAllRec();
			return;
		}
		
		else{
			//System.out.println(X[1]);
			String[] Y = X[1].split(":");
			D[i].PrintColsHumanSel(Y);
			D[i].PrintSelRec(Y);
			
		}		
	}
	
	static void Fetchr(String X[], int i, int locale) {
		
		if(X[2].equals("*")) {
			
			D[locale].PrintColsHuman();
			D[locale].PrintSelRecRow(i);
			return;
		}
		
		else{
			String[] Y = X[2].split(":");
			D[locale].PrintColsHumanSel(Y);
			D[locale].PrintSelRecRow(Y, i);
		}		
	}
	
	static void Addrow(String X, int locale) {
		D[locale].InsertRec(X);
	}
	
	static void AddTable(String[] X) {
		
		String[] C_name = X[3].split(":");
		String[] C_type = X[4].split(":");
		
		int i = 0;
		
		while(D[i] != null) {
			i++;
		}
		
		D[i] = new Table(X[2], C_name, C_type);
		
	}
	
	static void infoTables() {
		
		int i = 0;
		
		while(D[i] != null) {
			System.out.print(D[i].name + " [" + D[i].numberofRecs() + "] :");
			D[i].PrintCols();
			i++;
		}
		
	}
	
	static void infoTable(int locale) {
		
		D[locale].PrintCols();
		
	}
	
	static int LocateTable(String N) {
		
		int i = 0;
		int locale = -1;
		
		while(D[i] != null) {
			if(N.equals(D[i].name)) {
				locale = i;
				break;
			}
			i++;
		}
		
		if(locale<0) {
			ErrorWarning.Throw(-13);
		}
		return locale;
		
	}
}
