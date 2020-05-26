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

    public void close() throws SQLException {
        this.stmt.close();
        this.conn.close();
    }

    public ResultSet executeQuery(String SQLquery) throws SQLException {
        return this.stmt.executeQuery(SQLquery);
    }
    public int executeUpdate(String SQLquery) throws SQLException {
        return this.stmt.executeUpdate(SQLquery);
    }

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
