
public class ErrorWarning {

	//EC >=0 are Warnings, EC <0 are Errors.
	static void Throw(int EC) {
		
		switch(EC) {
		
		case -19:
			System.out.println("(EC -19): Table Out of Bounds Error. Your ERASE contains a row location that does not exist in the table."); 
			break;
		
		case -18:
			System.out.println("(EC -18): Typing Error. Your CREATE TABLE contains unequal number of column names and their corresponding datatypes."); 
			break;
		
		case -17:
			System.out.println("(EC -17): Data Entry Error. Your TAMPERCELL statement is entering a value with illegal datatype for a numerical field."); 
			break; //java.illegalnumberformat exception
		
		case -16:
			System.out.println("(EC -16): Coordinate Definition Error. Your TAMPERCELL statement references to a location that is reserved for the columns of this table."); 
			break; //y<1 for tamperrow
		
		case -15:
			System.out.println("(EC -15): Coordinate Definition Error. Your TAMPERCELL statement references to a location that is reserved for row indexing purposes."); 
			break; //x<1 for tamperrow
		
		case -14:
			System.out.println("(EC -14): Table Out of Bounds Error. Your TAMPERCELL statement references to a location that does not exist in the current table."); 
			break; // (x y) > bounds of table
		
		case -13:
			System.out.println("(EC -13): Typing Error. Your DET statement references to a table which currently does not exist inside the knowledge of interpretor."); 
			break; //Table not found
		
		case -12:
			System.out.println("(EC -12): Typing Error. Zero (0) cannot be used with FETCHR. Zero is reserved for Column Names."); 
			break; //0 leads to -1 due to decrement in the function where this EC is called
		
		case -11:
			System.out.println("(EC -11): Typing Error. Your FETCHR statement is fetching a row out of Table bounds."); 
			break; 
		
		case -10:
			System.out.println("(EC -10): Table Integrity Error. Your Insertion Statement contains an empty value for a column that serves as the Primary Key for records."); 
			break;
		
		case -9:
			System.out.println("(EC -9): Table Integrity Error. Using Boolean as a Primary Key will only allow a maximum of 2 records per table."); 
			break;
		
		case -8:
			System.out.println("(EC -8): Table Column Search Error. There is no column with that name that exists in the table."); 
			break;
		
		case -7:
			System.out.println("(EC -7): Table Integrity Error. Your Record Insertion Statement contains an identical value of a row of the column that keeps the Primary Key for this Table."); 
			break;
		
		case -6:
			System.out.println("(EC -6): Table Integrity Error. The Column you are trying to construct has it's name and datatype identical to another column of this table."); 
			break;
		
		case -5:
			System.out.println("(EC -5): Table Integrity Error. The Column you are trying to construct has a name identical to another column of this table.");
			break;
		
		case -4:
			System.out.println("(EC -4): Typing Error. Your Record Insertion Statement contains less values than the columns that exist in this table."); 
			break;
		
		case -3:
			System.out.println("(EC -3): Typing Error. Your Record Insertion Statement contains more values than the columns that exist in this table."); 
			break;
		
		case -2:
			System.out.println("(EC -2): Syntax Error. Incorrect DataType Declared for a column. Recheck Table/Column Constructor.");
			break;
		
		case -1:
			System.out.println("(EC -1): Records Error. The current table has no records inside. Cannot Delete Records that do not exist.");
			break;
		
		case 0:
			System.out.println("(EC 0): Table Warning. The current table has no records inside. Try Inserting Records.");
			break;
			
		case 1:
			System.out.println("(EC 1): Table Integrity Warning. It is unwise to have more than one primary key for a table."); 
			break;
			
		case 1601:
			System.out.println("(EC 1601): Ineffective Statement Warning. The current column is either already a primary key field or vice versa."); 
			break;
			
		case 1602:
			System.out.println("(EC 1602): Ineffective Statement Warning. The current column's prefix is same as the new prefix."); 
			break;
			
		case 1603:
			System.out.println("(EC 1603): Ineffective Statement Warning. The current column's suffix is same as the new suffix."); 
			break;
			
		case 1604:
			System.out.println("(EC 1604): Ineffective Statement Warning. One of the columns that you've asked to fetch does not exist."); 
			break;
			
		case 1605:
			System.out.println("(EC 1605): Ineffective Statement Warning. One of the tables that you've asked to fetch from does not exist."); 
			break;
			
		case 3000:
			System.out.println("(SC 3000): Stable Shutdown. Exiting Jatabase v0.2"); 
			break;
			
		case 3001:
			System.out.println("(SC 3001): ERASE TABLE Success. One of the tables that you've asked to erase was succesfully erased."); 
			break;
			
		case 3002:
			System.out.println("(SC 3001): ERASEDATA TABLE Success. One of the tables that you've asked to erase all rows from had its rows succesfully erased."); 
			break;
		}
		
	}
	
}
