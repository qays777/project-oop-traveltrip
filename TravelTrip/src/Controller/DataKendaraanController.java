package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author raybnsr
 */
public class DataKendaraanController extends MouseAdapter implements ActionListener {
    DataKendaraan view;
    Database con;
    int selected;
    Kendaraan t;
    
    public DataKendaraanController() throws SQLException {
        this.view = new DataKendaraan();
        view.setController(this);
        view.addAdapter(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.viewAll(con.loadAllKendaraan());
        view.getBtn_ubah().setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        Object s = me.getSource();
        if(s.equals(view.getTable_wisata())){
            selected = view.getSelectedWisata();
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubah())){
            try {
                t = con.loadAllKendaraan().get(selected);
                EditKendaraanController c = new EditKendaraanController();
                c.view.view(t);
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DataKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(source.equals(view.getBtn_hps())){
            try {
                String plat = con.loadAllKendaraan().get(selected).getPlat();
                con.hapusKendaraan(plat);
                JOptionPane.showMessageDialog(view, "Data Kendaraan sudah dihapus!");
                this.view.setVisible(false);
                DataKendaraanController v = new DataKendaraanController();
            } catch (SQLException ex) {
                Logger.getLogger(DataKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DataKendaraanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
