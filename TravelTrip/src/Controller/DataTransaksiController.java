package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raybnsr
 */
public class DataTransaksiController extends MouseAdapter implements ActionListener, ItemListener {
    DataTransaksi view;
    Database con;
    int selected;
    Pelanggan t;
    
    public DataTransaksiController() throws SQLException {
        this.view = new DataTransaksi();
        view.setController(this);
        view.addAdapter(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
        view.viewAll();
        view.InitCombo();
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        Object s = me.getSource();
        if(s.equals(view.getTabel_all())){
            selected = view.getSelectedPelanggan();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(EditWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        int select = view.getCombo_view().getSelectedIndex();
        if(select == 0){
            try {
                view.viewAll();
            } catch (SQLException ex) {
                Logger.getLogger(DataTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(select == 1){
            try {
                view.viewTransaksi();
            } catch (SQLException ex) {
                Logger.getLogger(DataTransaksiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
