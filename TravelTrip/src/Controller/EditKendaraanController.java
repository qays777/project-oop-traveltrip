package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author raybnsr
 */
public class EditKendaraanController implements ActionListener{
    Kendaraan model;
    EditKendaraan view;
    Database con;
    
    public EditKendaraanController() throws SQLException {
        this.view = new EditKendaraan();
        view.setController(this);
        view.setVisible(true);
        view.InitCombo();
        con = new Database();
        con.connect();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubh_kend())){
            
            try {
                model = new Kendaraan(view.getTxt_plat().getText(), view.getTxt_jenis().getText(), view.getTxt_status());
                con.updateKendaraan(model);
                JOptionPane.showMessageDialog(view, "Data Kendaraan sudah diubah!");
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false); 
            } catch (SQLException ex) {
                Logger.getLogger(EditKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(EditKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
    
}
