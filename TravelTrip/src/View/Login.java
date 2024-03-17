package View;

import javax.swing.JButton;
import javax.swing.JTextField;
import Controller.*;
import javax.swing.JPasswordField;

/**
 *
 * @author raybnsr
 */
public class Login extends javax.swing.JFrame {
    
    private LoginController control;

    /**
     * Creates new form Login
     */
    public Login() {
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
        txt_user = new javax.swing.JTextField();
        btn_signin = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setFont(new java.awt.Font("Futura Md BT", 0, 12)); // NOI18N
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 190, 30));

        btn_signin.setBackground(new java.awt.Color(255, 102, 0));
        btn_signin.setFont(new java.awt.Font("Futura Md BT", 1, 12)); // NOI18N
        btn_signin.setForeground(new java.awt.Color(255, 255, 255));
        btn_signin.setText("Login");
        btn_signin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(btn_signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 84, 30));

        txt_password.setFont(new java.awt.Font("Futura Md BT", 0, 12)); // NOI18N
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 190, 33));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/background-Login.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        setSize(new java.awt.Dimension(616, 387));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_signin;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_signin(){
        return btn_signin;
    }
    
    public JPasswordField getTxt_password() {
        return txt_password;
    }

    public JTextField getTxt_user() {
        return txt_user;
    }

    public void setController(LoginController c){
        this.control = c;
        btn_signin.addActionListener(c);
    }


}
