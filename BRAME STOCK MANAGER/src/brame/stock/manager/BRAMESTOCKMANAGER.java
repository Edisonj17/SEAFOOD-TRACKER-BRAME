/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package brame.stock.manager;

/**
 *
 * @author ediso
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BRAMESTOCKMANAGER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String usuario = "root";
        String password = "Salamanc@2117";
        String url = "jdbc:mysql://127.0.0.1:3306/bramestockmanager";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BRAMESTOCKMANAGER.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO usuarios    (nombre,contrasena,rol) VALUES('Edison','Edisonj17','Developer')");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do {
                System.out.println(rs.getInt("id_usuario")+ " : " +rs.getString("nombre"));
            } while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(BRAMESTOCKMANAGER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
