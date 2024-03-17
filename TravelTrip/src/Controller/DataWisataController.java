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
public class DataWisataController extends MouseAdapter implements ActionListener {
    DataWisata view;
    Database con;
    int selected;
    Pariwisata t;
    
    public DataWisataController() throws SQLException {
        this.view = new DataWisata();
        view.setController(this);
        view.addAdapter(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.viewAll(con.loadAllWisata());
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
                System.out.println(selected);
                System.out.println("ID : "+con.loadAllWisata().get(selected).getId());
                t = con.loadAllWisata().get(selected);
                EditWisataController c = new EditWisataController();
                c.view.view(t);
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(DataWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(source.equals(view.getBtn_hps())){
            try {
                int id = con.loadAllWisata().get(selected).getId();
                con.hapusWisata(id);
                JOptionPane.showMessageDialog(view, "Data wisata sudah dihapus!");
                this.view.setVisible(false);
                DataWisataController v = new DataWisataController();
            } catch (SQLException ex) {
                Logger.getLogger(DataWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(EditWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
