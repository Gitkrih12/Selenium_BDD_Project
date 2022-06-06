package Automation.Utilities;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DatabaseUtils extends SeleniumUtils {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    String url = prop.getProperty("dbUrl");
    String username = prop.getProperty("dbUsername");
    String password = prop.getProperty("dbPassword");

    public synchronized ResultSet runDBAndGetQueryDetails(String query)
    {
            con = null;
            try {
                con = DriverManager.getConnection(url, username, password);

                if (con != null) {
                    System.out.println("Connected to DB Successfully");
                }

                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(query);
                System.out.println("Query Name : " + query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        return rs;
    }

    public void closeConnection() throws SQLException {
        if(con != null)
        {
            con.close();
            System.out.println("Closed DB Connection successfully");
        }
    }

    public int getRowCount(String QUERY)
    {
        rs = null;
        int rc = 0;
        int cc;

        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("Column Count : " + cc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rc;
    }

    public void getColumnHeader(String QUERY) throws SQLException, ClassNotFoundException, IOException
    {
        try
        {
            rsmd = null;
            Map<String, ArrayList> RowColumnlist = new HashMap<>();
            ArrayList<String> Header = new ArrayList<>();
            int rc;
            int cc;
            String sa = null;
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc= rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count :" + rc);
            System.out.println("Column count: " + cc);
            for (int i=1; i<=cc;i++)
            {
                System.out.println("Column Name : " + i + "---" + rsmd.getColumnName(i));
                System.out.println("Column Type : " + i + "---" + rsmd.getColumnType(i));
                System.out.println("Column Display Size : " + i + "---" + rsmd.getColumnDisplaySize(i));
                System.out.println("Column Precision :" + i + "---" + rsmd.getPrecision(i));
                System.out.println("Column Scale : " + i + "---" + rsmd.getScale(i));
            }
        }catch(SQLException e)
        {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
    }

    public int getColumnCount(String QUERY) throws SQLException, ClassNotFoundException, IOException
    {
        rs = null;
        int rc;
        int cc;
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count :" + rc);
            System.out.println("Column Count :" + cc);
        }finally {
            rs.close();
        }
        return cc;
    }

    public ArrayList<String> getMultipleRowValues(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        ArrayList<String> Row = new ArrayList<>();
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count :" + rc);
            System.out.println("column Count : " + cc);

            while (rs.next())
            {
                for(int i=1;i<=cc;i++)
                {
                    Row.add(rs.getString(i));
                }

            }
            System.out.println("Row Array Size : " + Row.size());
        }catch (Exception e)
        {
            System.out.println("connection failed! Check output console");
            e.printStackTrace();
        }
        return Row;
    }

    public Map<String, ArrayList> getMapListColumnValues(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        Map<String, ArrayList> RowColumnlist = new HashMap<>();
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc= rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count :" + rc);
            System.out.println("Column Count :" + cc);
            int rows = 0;
            for(int i=1;i<=cc; i++)
            {
                ArrayList<String> ColumnList = new ArrayList<>();
                rs.beforeFirst();
                while (rs.next())
                {
                    ColumnList.add(rs.getString(i));
                }
                RowColumnlist.put(rsmd.getColumnLabel(i), ColumnList);
            }
            Iterator iter = RowColumnlist.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry or = (Map.Entry) iter.next();
                //Doubt here
//                Entry or = (Entry) iter.next();
                System.out.println(or.getKey() + " : " + or.getValue());
            }
            System.out.println("column Array Size : " + RowColumnlist.size());
        }catch (Exception e)
        {
            System.out.println("Query returned no records ! Check output console");
            e.printStackTrace();
        }
        return RowColumnlist;
    }

    public ArrayList<String> getColumnNameAndValue(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        ArrayList<String> ColumnNameandValue = new ArrayList<>();
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("column Count : " + cc);
            int rows = 0;
            for(int i=1;i<=cc;i++)
            {
                String ColumnList = null;
                rs.beforeFirst();
                while (rs.next())
                {
                    ColumnList = rs.getString(i);
                }
                String s = rsmd.getColumnLabel(i)+ "=" + ColumnList;
                ColumnNameandValue.add(s);
            }
        }catch (Exception e)
        {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
            ColumnNameandValue = null;
        }
        return ColumnNameandValue;
    }


    public String getSingleColumnValue(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        String ColumnValue = null;
        String s = null;
        try
        {
            System.out.println("Query : " + QUERY);
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("Column Count : " + cc);
            int rows = 0;
            for(int i=1;i<=cc; i++)
            {
                rs.beforeFirst();
                while (rs.next())
                {
                    ColumnValue = rs.getString(i);
                }
                s = rsmd.getColumnLabel(i) + "=" + ColumnValue;
            }
        }catch (Exception e)
        {
            System.out.println("connection failed! Check output console");
            e.printStackTrace();
            s= null;
        }
        return s;
    }

    public ArrayList<String> getMultipleColumnValues(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        ArrayList<String> Column = new ArrayList<>();
        try
        {
            rs= runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("Column Count : " + cc);
            while (rs.next())
            {
                for (int i=1;i<=cc;i++)
                {
                    Column.add(rs.getString(i));
                }
            }
            System.out.println("Column Array Size : " + Column.size());
        }catch (Exception e)
        {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
        return Column;
    }

    public String getSingleColumnValueWithoutColumnName(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        String ColumnValue = null;
        String s = null;
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("Column Count : " + cc);
            int rows = 0;
            for(int i=1;i<=cc;i++)
            {
                rs.beforeFirst();
                while (rs.next())
                {
                    ColumnValue = rs.getString(i);
                }
                s = ColumnValue;
            }
        }catch (Exception e)
        {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
            s= null;
        }
        return s;
    }

    public String recordsExistOrNot(String QUERY) throws SQLException, ClassNotFoundException
    {
        String recordexist = null;
        rs = null;
        Map<String, ArrayList> RowColumnlist = new HashMap<>();
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            boolean rec = rs.last();
            if (rec == false)
            {
                System.out.println("No records are obtained from the query: " + QUERY);
                recordexist = "No";
            }
            else
            {
                System.out.println("Records exist for query : " + QUERY);
                recordexist = "Yes";
            }
        }catch (Exception e)
        {
            System.out.println("Query returned no records! Check output console");
            e.printStackTrace();
        }
        return recordexist;
    }

    public boolean columnPresentOrNot(String TableName, String column) throws SQLException, ClassNotFoundException
    {
        boolean value;
        try
        {
            String QUERY = "Select * from " + TableName;
            rsmd = null;
            Map<String, ArrayList> RowColumnlist = new HashMap<>();
            ArrayList<String> Header = new ArrayList<>();
            int rc;
            int cc;
            String sa = null;
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row count : " + rc);
            System.out.println("Column Count : " + cc);
            int count = 0;
            for(int i=1;i<=cc;i++)
            {
                if(rsmd.getColumnName(i).contains(column))
                {
                    count++;
                }
            }
            if(count>0)
            {
                value = true;
            }
            else
            {
                value = false;
            }
        }catch (Exception e)
        {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
            return false;
        }
        return value;
    }

    public synchronized void updateOrDeleteQuery(String QUERY) throws SQLException, ClassNotFoundException
    {
        con = null;
        try {
                con = DriverManager.getConnection(url, username, password);
                if (con != null) {
                    System.out.println("Connected to DB Successfully");
                }

                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                stmt.executeUpdate(QUERY);
                System.out.println("Query Name : " + QUERY);

        }catch (Exception e)
        {
            System.out.println("Query not updated correctly! Check output console");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMultipleColumns(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        ArrayList<String> Column = new ArrayList<>();
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("Column count : " + cc);

            while (rs.next()) {
                for (int i = 1; i <= cc; i++)
                {
                    Column.add(rs.getString(i));
                }
            }
            System.out.println("Column Array Size : " + Column.size());
        }catch (Exception e)
        {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
        return Column;
    }

    public Map<String, List<String>> getColumnDataTypeLength(String QUERY) throws SQLException, ClassNotFoundException
    {
        rs = null;
        int rc;
        int cc;
        Map<String, List<String>> propertyList = new HashMap<>();
        List<String> columnProperty = new ArrayList<>();
        try
        {
            rs = runDBAndGetQueryDetails(QUERY);
            rs.last();
            rc = rs.getRow();
            rsmd = rs.getMetaData();
            cc = rsmd.getColumnCount();
            rs.beforeFirst();
            System.out.println("Row Count : " + rc);
            System.out.println("Column Count : " + cc);
            for(int i=1;i<=cc;i++)
            {
                columnProperty.add(String.valueOf(rsmd.getColumnDisplaySize(i)));
                columnProperty.add(rsmd.getColumnTypeName(i));
                propertyList.put(rsmd.getColumnLabel(i), columnProperty);
            }
            Iterator iter = propertyList.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry or = (Map.Entry) iter.next();
                //Doubt here Actaul has only "Entry" instead of Map.entry
                System.out.println(or.getKey() + " : " + or.getValue());
            }
            System.out.println("Array Size : " + propertyList.size());
        }catch (Exception e)
        {
            System.out.println("Query returned no records! check output console");
            propertyList = null;
            e.printStackTrace();
        }
        return propertyList;
    }

}

