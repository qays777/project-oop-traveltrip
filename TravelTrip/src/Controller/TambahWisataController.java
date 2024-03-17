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
public class TambahWisataController implements ActionListener{
    Pariwisata model;
    TambahWisata view;
    Database con;

    public TambahWisataController() throws SQLException {
        this.view = new TambahWisata();
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
        if(source.equals(view.getBtn_tmbh_wisata())){
            String nm = view.getTxt_nama().getText();
            String kab = view.getTxt_kab();
            int biaya = Integer.parseInt(view.getTxt_biaya().getText());
            Pariwisata tw = new Pariwisata(nm, kab, biaya);
            try {
                con.saveWisata(tw);
                JOptionPane.showMessageDialog(view, "Data Tempat Wisata ditambahkan!");
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahWisataController.class.getName()).log(Level.SEVERE, null, ex);
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
