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
public class DataPelangganController extends MouseAdapter implements ActionListener {
    DataPelanggan view;
    Database con;
    int selected;
    Pelanggan t;
    
    public DataPelangganController() throws SQLException {
        this.view = new DataPelanggan();
        view.setController(this);
        view.addAdapter(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.viewAll(con.loadAllPelanggan());
        view.getBtn_ubah().setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        Object s = me.getSource();
        if(s.equals(view.getTable_wisata())){
            selected = view.getSelectedPelanggan();
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubah())){
            try {
                t = con.loadAllPelanggan().get(selected);
                EditPelangganController c = new EditPelangganController();
                c.view.view(t);
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DataPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(source.equals(view.getBtn_hps())){
            try {
                int id = con.loadAllPelanggan().get(selected).getId();
                con.hapusPelanggan(id);
                JOptionPane.showMessageDialog(view, "Data pelanggan sudah dihapus!");
                this.view.setVisible(false);
                DataPelangganController v = new DataPelangganController();
            } catch (SQLException ex) {
                Logger.getLogger(DataPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DataPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
