/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Estructuras.LinkedList;
import Control.*;
//import Estructuras.AVL_vehiculos;
import Modelo.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Character;

/**
 *
 * @author Santiago Mendoza
 */
public class Ingresar extends javax.swing.JFrame {

    /**
     * Creates new form Ingresar
     */
    private Usuario usu;
    private AdministrarUsuario admiusu;
    public static Principal princi;
    public static AdministrarVehiculo admivehi;
    public static LinkedList<Vehiculo> listaVehiculos = new LinkedList<>();
    public Ingresar() {
        initComponents();
        usu= new Usuario();
        admiusu= new AdministrarUsuario();
        princi = new Principal();
        admivehi=new AdministrarVehiculo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuarioTF = new javax.swing.JTextField();
        contrasenaPF = new javax.swing.JPasswordField();
        ingresarBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BIENVENIDO");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        ingresarBT.setText("Ingresar");
        ingresarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuarioTF, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(contrasenaPF))
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ingresarBT)
                        .addGap(5, 5, 5)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(usuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contrasenaPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(ingresarBT)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBTActionPerformed
        // TODO add your handling code here:
        Usuario u= new Usuario();
        u= null;
        u=admiusu.buscarUsuario(usuarioTF.getText());
        if (u!=null){
            if(contrasenaPF.getText().equals(u.getClave())){
                usu=u;
            
                this.setVisible(false);
                princi.setVisible(true); 
                princi.requestFocus();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"La Contraseña es incorrecta.");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"El ususario no existe.");
        }  
        
        //Leer el archivo
        
        try{
            Scanner input = new Scanner(new File("MOCK_DATA_100000.txt"));
            int numeroPlaca=0;
            
            
            char placa2_0='A';
            char placa2_1='A';
            char placa2_2='A';
            char placa2_3='0';
            char placa2_4='0';
            char placa2_5='0';
            
            while(input.hasNextLine()){
                input.nextLine();
                String placa = input.next();
                //generacion placa
                //System.out.println(numeroPlaca);
                //char[] placa2= {placa2_0,placa2_1,placa2_2,placa2_3,placa2_4,placa2_5};
                String placafinal=String.valueOf(placa2_0)+String.valueOf(placa2_1)+String.valueOf(placa2_2)+String.valueOf(placa2_3)+String.valueOf(placa2_4)+String.valueOf(placa2_5);
                //System.out.println(placafinal);
                placa=placafinal;
                if(numeroPlaca%10==0 &&numeroPlaca!=0){
                    placa2_5='0';
                    placa2_4++;
                }
                else{
                    placa2_5++;
                }
                if(numeroPlaca%100==0 &&numeroPlaca!=0){
                    placa2_4='0';
                    placa2_3++;
                }
                if(numeroPlaca%1000==0 &&numeroPlaca!=0){
                    placa2_3='0';
                    placa2_2++;
                }
                if(numeroPlaca%26000==0 &&numeroPlaca!=0){
                    placa2_2='A';
                    placa2_1++;
                }
                if(numeroPlaca%260000==0 &&numeroPlaca!=0){
                    placa2_1='A';
                    placa2_0++;
                }
                
                //if(numeroPlaca%20==0&&numeroPlaca!=0){
                //    placa2_4++;
                //}
                //if(numeroPlaca%100==0&&numeroPlaca!=0){
                //    placa2_4++;
                //}
                
                
                
                
                
                
    
                
                
                
                numeroPlaca++;
                
                
                Float kilom = input.nextFloat();
                int year = input.nextInt();
                String marca = input.next();
                String ref = input.next();
                int cilind = input.nextInt();
                int puestos = input.nextInt();
                Vehiculo vehiculo = new Vehiculo(kilom,year,marca,ref,cilind,placa,puestos);
                //listaVehiculos.pushFront(vehiculo);
                //System.out.println(vehiculo.getReferencia()+vehiculo.getMarca());
                //System.out.println(listaVehiculos.size() + " " + listaVehiculos.topFront().getPlaca() + " " + listaVehiculos.topFront().getMarca());
                admivehi.agregarVehiculo(vehiculo);  //No quitar
                //admivehi.agregarVehiculoArbol(vehiculo);
                //admivehi.agregarVehiculoArbolPlacas(vehiculo);
                
            }
            input.close();
            
                       
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        princi.setListaVehiculos(listaVehiculos);
        princi.setAdministrarVehiculos(admivehi);
        
        
        
        
        
    }//GEN-LAST:event_ingresarBTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contrasenaPF;
    private javax.swing.JButton ingresarBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
}
