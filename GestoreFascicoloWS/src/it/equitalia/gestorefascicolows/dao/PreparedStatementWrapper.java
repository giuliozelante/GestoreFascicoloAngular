package it.equitalia.gestorefascicolows.dao;


 

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class  PreparedStatementWrapper{ 
	static Logger logger = Logger.getLogger( PreparedStatementWrapper.class );
    PreparedStatement preparedStatement;
    String query;
    
    Map<Integer, Object> parameters= new HashMap<Integer, Object>(); 
    
    
    public PreparedStatementWrapper(Connection conn, String query) throws SQLException{
        this.preparedStatement = conn.prepareStatement(query); 
        this.query = query;
    }

    public PreparedStatementWrapper(Connection connection, String query, String[] columnNames) throws SQLException { 
        this.preparedStatement = connection.prepareStatement(query, columnNames);
        this.query = query;
	}

	public void setString(int i, String param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setString(i, param);
        
    }
    public void setInt(int i, int param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setInt(i, param);  
    }

	public void setObject(int i, Object param) throws SQLException {
        parameters.put(i, param);
		preparedStatement.setObject(i, param); 
	}


    public void setNull(int parameterIndex, int sqlType) throws SQLException{
        parameters.put(parameterIndex, null);
        preparedStatement.setNull(parameterIndex, sqlType);
        
    }
    
    public void setBigDecimal(int i, BigDecimal param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setBigDecimal(i, param);
        
    }

    public void setLong(int i, long param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setLong(i, param);
        
        
    }
    
    public void setTimestamp(int i, Timestamp param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setTimestamp(i, param);
        
        
    }

    public void setBlob(int i, Blob param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setBlob(i, param);
        
    }
    
    public void setClob(int i, Clob param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setClob(i, param);
        
    }
    
    public void setDate(int i, java.sql.Date param) throws SQLException{
        parameters.put(i, param);
        preparedStatement.setDate(i, param);
         
    }
    
    public void setDate(int i, java.util.Calendar param) throws SQLException{        
        java.sql.Date date = null;
        if (param != null ) {
             date= new java.sql.Date( param.getTimeInMillis());
        }
        parameters.put(i,  date );
        preparedStatement.setDate(i, date);
         
    }
     

    
    

    public ResultSet  getResultSet( ) throws SQLException{
        return preparedStatement.getResultSet( ); 
        
    }
 
    

    public boolean  getMoreResults( ) throws SQLException {
        return  preparedStatement.getMoreResults() ; 
    }
    
    public String toString(){
    	String queryToWrite = this.query;
        
        List<Integer> keyList = new ArrayList<Integer>( parameters.keySet());
        
        Collections.sort(keyList);  
        
          
        
        for (Integer key: keyList ) {
            Object param = parameters.get(key) ;
//            if (param instanceof Blob 
//                || param instanceof Clob    
//                ) {
//                resBuffer.append( "[BYTE ARRAY]" ); 
//            } 
            
            if( param instanceof String){ 
            	
            	queryToWrite = queryToWrite.replaceFirst( "\\?",  "'"+ param + "'"  );

            } else{
            	queryToWrite = queryToWrite.replaceFirst( "\\?", String.valueOf( param ) ); 
            }
            
             
             
        }
        
        return queryToWrite.toString();
    }
     
    public static PreparedStatementWrapper prepareStatement(Connection conn, String query) throws SQLException{
    	 
        return new PreparedStatementWrapper( conn, query );
    }


	public static PreparedStatementWrapper prepareStatement( Connection connection, String query, String[] columnNames) throws SQLException { 
		return new PreparedStatementWrapper( connection, query, columnNames ); 
	}
    
    
    public int executeUpdate()  throws SQLException{ 
    	logger.debug(toString()); 
    	return preparedStatement.executeUpdate();
    }
     
    
    public  ResultSet  executeQuery() throws SQLException{
    	logger.debug(toString()); 
    	return preparedStatement.executeQuery();
    }

	public boolean execute()  throws SQLException {
    	logger.debug(toString()); 
		return preparedStatement.execute();
	}
 
	
    public void  close() throws SQLException{
    	preparedStatement.close();
    }

	public void clearParameters() throws SQLException {
		preparedStatement.clearParameters(); 
	}

	public ResultSet getGeneratedKeys() throws SQLException { 
		return preparedStatement.getGeneratedKeys();
	}
 
}
