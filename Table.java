
public class Table {
	
	String  name;
	int    limit;
	Column  cols;
	
	Table(String N, String[] C_name, String[] C_type){
		

		name = N;
		
		if(C_name.length != C_type.length) {
			ErrorWarning.Throw(-18);
			return;
		}
		
		int x = 0;
		limit = C_name.length;
		

		
		cols = new Column(C_name[0], C_type[0]);
		x++;
		
		while(x<limit) {
			cols.insertCol(C_name[x], C_type[x]);
			x++;
		}
		
	}
	
	//Column Printing Functions
	void PrintCols(){
		
		cols.DisplayCols();
		return;
	}
	
	void PrintColsJava(){
		
		cols.DisplayColsJava();
		return;
	}
	
	void PrintColsHuman(){
		
		cols.DisplayColsHuman();
		return;
	}
	
	void PrintColsHumanSel(String[] X){
		
		cols.DisplayColsHumanSel(X);
		return;
	}
	
	void PrintColsJavaSel(String[] X){
		
		cols.DisplayColsJavaSel(X);
		return;
	}
	
	void PrintColsSel(String[] X){
		
		cols.DisplayColsSel(X);
		return;
	}
	
	
	//Record Insertion, Deletion, Viewing and Modification
	void InsertRec(String Rec) {
		
		cols.InsertRec(Rec);
		return;
	}
	
	void DeleteRec(int i) {
		cols.DeleteRec(i);
		return;
	}
	
	void TamperRecCords(int x, int y, String R) {
		cols.TamperRecTableCords(x, y, R);
		return;
	}
	
	void TamperRecWhole(int y, String R[]) {
		cols.TamperRecYCord(y, R);
		return;
	}

	void PrintAllRec() {
		cols.printRecs();
		return;
	}
	
	void PrintSelRecRow(int i) {
		
		cols.printSelRecRow(i);
		return;
	}
	
	void PrintSelRecRow(String X[], int i) {
		
		cols.printSelRecRow(X, i);
		return;
	}
	
	void PrintSelRec(String[] X) {
		cols.printSelectiveRecs(X);
		return;
	}
	
	//Column Modification Functions
	void insertCol(String n, String d) {
		cols.insertCol(n, d);
		return;
	}
	
	void ModColSuff(String N, String Suff) {
		cols.ModColSuff(N,Suff);
		return;
	}
	
	void ModColPref(String N, String Pref) {
		cols.ModColPref(N,Pref);
		return;
	}
	
	void ModColPK(String N, boolean PK) {
		cols.ModColPK(N,PK);
		return;
	}
   
	void ModColAtr(String N, boolean PK, String S, String P) {
		cols.ModColAttr(N, PK, S, P);
		return;
	}
	
	void DropAll() {
		
		if(cols.Head.data.size() == 0) {
			ErrorWarning.Throw(0);
			return;
		}
		
		cols.ResetCol();
		return;
		
	}
	


	//Interpretor Communicado
	void takeAction(int i) {
		
		if(i == 1) {
			PrintColsHuman();
			PrintAllRec();
			return;
		}
		
	}
	
	String numberofRecs() {
		
		return cols.Head.data.size() + "";
		
	}
	
}
