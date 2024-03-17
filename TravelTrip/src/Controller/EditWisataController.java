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
public class EditWisataController implements ActionListener{
    Pariwisata model;
    EditWisata view;
    Database con;
    
    public EditWisataController() throws SQLException {
        this.view = new EditWisata();
        this.model = new Pariwisata();
        view.setController(this);
        view.setVisible(true);
        view.InitCombo();
        con = new Database();
        con.connect();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubh_wisata())){
            
            try {
                model.setBiaya(Integer.parseInt(view.getTxt_biaya().getText()));
                model.setKab(view.getTxt_kab());
                model.setNama(view.getTxt_nama().getText());
                model.setId(Integer.parseInt(view.getTxt_id().getText()));
                System.out.println("ID YANG DIUBAH "+model.getId());
                con.updateWisata(model);
                JOptionPane.showMessageDialog(view, "Data wisata sudah diubah!");
                DataWisataController v = new DataWisataController();
                this.view.setVisible(false); 
            } catch (SQLException ex) {
                Logger.getLogger(EditWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                DataWisataController m = new DataWisataController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(EditWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
    
    
}
