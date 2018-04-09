package lab_tasks;

import java.sql.SQLException;

public class TestStatements {
	
	
	public static void main(String[] args) throws SQLException{
		
		long startTime;
		long endTime;
		long duration;
		boolean flage;
		

        DBConnect insertRecord = new DBConnect();
        
        for(int i=0; i<2; i++) {
        	if(i==1)
    		{
    	        flage = true;
    		}
    		else
    		{
    	        flage = false;
    		}
        	
        	System.out.println("FOR COMMIT="+flage+"\n\n");

            
    		System.out.println("Data insertion Using Statement Class");
            startTime = System.nanoTime();
            insertRecord.statementClass(flage);
            endTime = System.nanoTime();
            duration = (endTime - startTime)/1000000000;  //divide by 1000000 to get milliseconds.
    		System.out.println("Statement Class Took "+ duration +" seconds to insert 5000 data When commit="+flage);
    		
    		
    		insertRecord.truncateStudentTable();

    		
    		System.out.println("Data insertion Using Prepared Statement Class");
            startTime = System.nanoTime();
            try {
    			insertRecord.preparedStatementClass(flage);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            endTime = System.nanoTime();
            duration = (endTime - startTime)/1000000000;  //divide by 1000000 to get milliseconds.
    		System.out.println("Prepared Statement Class Took "+ duration +" seconds to insert 5000 data When commit="+flage);
    		
    		
    		insertRecord.truncateStudentTable();
    		
    		
    		System.out.println("Data insertion Using Batch Update");
    		startTime = System.nanoTime();
            try {
    			insertRecord.batchUpdate(flage);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            endTime = System.nanoTime();
            duration = (endTime - startTime)/1000000000;  //divide by 1000000 to get milliseconds.
    		System.out.println("Batch Update Took "+ duration +" seconds to insert 5000 data When commit="+flage);
        	
        }
        
		
		
	}

}
