package cz.knourekdaniel.cashbox.Tools;

import java.sql.*;
import java.util.ServiceLoader;

//DBsuperUser= su
//DBpassword= nN4b^YvJT5Vx=8Bt
//DBpath= jdbc:h2:D:\School\TUL\TUL\1_ZS_ALG2\Knourek_ALG2_sem_reastauraceAPP\out\artifacts\cashbox_jar\data
//DBpath= D:\School\TUL\TUL\1_ZS_ALG2\Knourek_ALG2_sem_reastauraceAPP\out\artifacts\cashbox_jar

public class DBhandler{
    private String dbURL_Data = "jdbc:h2:file:./data/data";;
    private String DBsuperUser = "su";
    private String DBpassword = "nN4b^YvJT5Vx=8Bt";
    private Connection conn;
    private Statement stmt;

    public  DBhandler(){
        try {
            Class.forName ("org.h2.Driver");

            this.conn = DriverManager.getConnection(this.dbURL_Data, this.DBsuperUser, this.DBpassword);
            this.stmt = conn.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            //TODO catch
            e.printStackTrace();
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
