package cz.knourekdaniel.cashbox.Tools;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ServiceLoader;

//DBsuperUser= su
//DBpassword= nN4b^YvJT5Vx=8Bt
//DBpath= jdbc:h2:D:\School\TUL\TUL\1_ZS_ALG2\Knourek_ALG2_sem_reastauraceAPP\out\artifacts\cashbox_jar\data
//DBpath= D:\School\TUL\TUL\1_ZS_ALG2\Knourek_ALG2_sem_reastauraceAPP\out\artifacts\cashbox_jar

public class DBhandler {
    private String dbURL;
    private String DBsuperUser = "su";
    private String DBpassword = "nN4b^YvJT5Vx=8Bt";
    public  DBhandler(){
        try {
            Class.forName ("org.h2.Driver");
            this.dbURL = "jdbc:h2:./data/data";



            Connection conn = DriverManager.getConnection(this.dbURL, this.DBsuperUser, this.DBpassword);

            String sql = "SELECT * from TEST";
            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
            ResultSet rs = stmt.executeQuery(("SELECT * from TEST"));
            rs.next();
            rs.next();
            System.out.println(rs.getString("testcol"));


            this.dbURL = "jdbc:h2:./data/data.mv.db";


        } catch (SQLException | ClassNotFoundException e) {
            //TODO catch
            e.printStackTrace();
        }

    }
}
