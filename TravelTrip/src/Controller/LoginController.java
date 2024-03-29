package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author raybnsr
 */
public class LoginController implements ActionListener{
    Login view;
    Database con;
    
    public LoginController() throws SQLException {
        this.view = new Login();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_signin())){
            try {
                con.connect();
                String user = view.getTxt_user().getText();
                String pass = String.valueOf(view.getTxt_password().getPassword());
                String query = "SELECT * FROM petugas WHERE username = '"+user+"' and password = '"+pass+"'";
                ResultSet rs = con.statement.executeQuery(query);
                if(rs.next()){
                    con.setLoginpetugas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    JOptionPane.showMessageDialog(view, "Selamat Datang");
                    MainMenuController m = new MainMenuController();
                    view.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(view, "Username atau password salah!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
