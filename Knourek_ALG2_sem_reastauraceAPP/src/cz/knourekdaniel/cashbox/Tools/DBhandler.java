package cz.knourekdaniel.cashbox.Tools;

import cz.knourekdaniel.cashbox.App_UI.MainView;
import cz.knourekdaniel.cashbox.Main;

import java.sql.*;

public class DBhandler{
    private String dbURL = "jdbc:h2:file:";;
    private String DBsuperUser = "su";
    private String DBpassword = "nN4b^YvJT5Vx=8Bt";
    private Connection conn;
    private Statement stmt;

    /**
     * creates connection to the database specified in Conf.xml
     * accessed by Conf.conf.get("database-url")
     */
    public  DBhandler(){
        try {
            Class.forName ("org.h2.Driver");
            String dbURL_Data = this.dbURL +"./"+ Conf.conf.get("database-url");

            this.conn = DriverManager.getConnection(dbURL_Data, this.DBsuperUser, this.DBpassword);
            this.stmt = conn.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            MainView.app.exitError("Nelze se připojit k databázi", true);
        }
    }

    /**
     * Safely closes statement and connection to the database.
     * @throws SQLException
     */
    public void close() throws SQLException {
        this.stmt.close();
        this.conn.close();
    }

    /**
     * Execute your SQL query and returns result set with answer provided by database
     * @param SQLquery basic SQL querry
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet executeQuery(String SQLquery) throws SQLException {
        return this.stmt.executeQuery(SQLquery);
    }
    public int executeUpdate(String SQLquery) throws SQLException {
        return this.stmt.executeUpdate(SQLquery);
    }

    /**
     * Helps to create SQL select statement of desired table and columns
     * @param table String name of table
     * @param cols Array of string with names of columns
     * @return
     */
    public static String getSelectSQL(String table, String... cols){
//        "SELECT ID, NAME, PRICE, QTY, UNIT, DPH, CATEGORY, DESCRIPTION, KEYWORDS from ITEMS"
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        for (String col : cols) {
            sql.append(col).append(",");
        }
        sql.deleteCharAt(sql.length()-1).append(" from ").append(table);
        return sql.toString();
    }
}
