package View;

import Controller.*;
import Model.*;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raybnsr
 */
public class DataTransaksi extends javax.swing.JFrame {
    DataTransaksiController control;

    /**
     * Creates new form DataTransaksi
     */
    public DataTransaksi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_all = new javax.swing.JTable();
        combo_view = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Futura Md BT", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Transaction_64px.png"))); // NOI18N
        jLabel1.setText("Daftar Transaksi Travel");

        btn_back.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(308, 308, 308)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_back))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabel_all.setFont(new java.awt.Font("Futura Md BT", 0, 13)); // NOI18N
        tabel_all.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_all);

        combo_view.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_view, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(combo_view, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1069, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> combo_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_all;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_back() {
        return btn_back;
    }

    public JComboBox<String> getCombo_view() {
        return combo_view;
    }

    public JTable getTabel_all() {
        return tabel_all;
    }
    
    public void setController(DataTransaksiController c){
        this.control = c;
        btn_back.addActionListener(c);
        combo_view.addItemListener(c);
    }
    
    public void addAdapter(MouseAdapter e){
        this.tabel_all.addMouseListener(e);
    }
    
    public int getSelectedPelanggan(){
        return this.tabel_all.getSelectedRow();
    }
    
    public void viewAll() throws SQLException{
        Database con = new Database();
        con.connect();
        Statement st = con.getStatement();
        String query = "SELECT no_pesan 'No Transaksi', id_pel 'Id Pelanggan', nama_pel 'Nama Pelanggan', nama_tempat 'Tempat Wisata', tanggal 'Tanggal', plat 'Plat', jenis 'Mobil', pesan.biaya 'Biaya', id_ptgs 'Id Petugas'"
                + "from pesan JOIN pelanggan USING(id_pel)"
                + "JOIN wisata USING(id_wisata)"
                + "JOIN petugas USING(id_ptgs)"
                + "JOIN kendaraan USING(plat)";
        ResultSet rs = st.executeQuery(query);
        resultSetToTableModel(rs, this.tabel_all);
    }
    
    public void viewTransaksi() throws SQLException{
        Database con = new Database();
        con.connect();
        Statement st = con.getStatement();
        String query = "SELECT id_pel 'Id Pelanggan', nama_pel 'Nama Pelanggan', SUM(pesan.biaya) 'Total Transaksi' from pesan join pelanggan using(id_pel) group by (id_pel)";
        ResultSet rs = st.executeQuery(query);
        resultSetToTableModel(rs, this.tabel_all);
    }
    
    public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();

        //Retrieve meta data from ResultSet
        
        ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = metaData.getColumnCount();

        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];

        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
        }

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel);
    }
    
    public void InitCombo(){
        combo_view.removeAllItems();
        combo_view.addItem("Lihat Semua");
        combo_view.addItem("Lihat Transaksi Pelanggan");
        combo_view.setSelectedIndex(0);
    }


}