package top.sonack.crud.dao.utils;

import java.sql.*;

public class JdbcUtils
{
    private static Connection connection;
    private static Statement statement;
    private static final String DATABASE_NAME = "database1";
    /*private static final String USERNAME = "root";
    private static final String PASSWORD = "qiao280011";*/
    private static final String USERNAME = "mz1w5yynny";
    private static final String PASSWORD = "4w112x11wwimmzhxwhl3ilmyzz051mhjwjxy2m1y";
    
    static
    {
	String d = "com.mysql.jdbc.Driver";
	try
	{
	    Class.forName(d);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    //jintai
    public static Connection getConnection() throws SQLException
    {
	if(connection == null || connection.isClosed())
	{
	    
//	    本地服务器
	  // String url = "jdbc:mysql://localhost:3306/database1";   
	    
//	    
	   String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_hitpglab2?autoReconnect=true";
	    try
	    {
		connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
	    }
	    catch(Exception e)
	    {
		System.out.println("数据库连接异常!");
		e.printStackTrace();
	    }
	}
	
	return connection;
    }
    
    //jintai
    public static Statement getStatement() throws SQLException
    {
	if(statement == null || statement.isClosed())
	    statement = JdbcUtils.getConnection().createStatement();
	return statement;
    }
    
    //jintai
    public static void release(ResultSet res,Statement stmt,Connection conn)
    {
	if(res != null)
	{
	    try
	    {
		res.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	if(stmt != null)
	{
	    try
	    {
		stmt.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	if(conn != null)
	{
	    try
	    {
		conn.close();
	    } 
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
    }
    //jintai
    public static void release(Object o)
    {
	try
	{
	    if(o instanceof ResultSet)
	    {
		((ResultSet)o).close();
	    }else if (o instanceof Statement)
	    {
		((Statement) o).close();
	    } else if (o instanceof Connection)
	    {
		((Connection) o).close();
	    }
	    
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    
}
