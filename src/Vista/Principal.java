/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Estructuras.*;
import Modelo.*;
import Control.*;
/**
 *
 * @author Santiago Mendoza
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    BuscarPanel bp;
    AgregarPanel ap;
    AlquilarPanel alp;
    LinkedList listaVehiculos;
    AdministrarVehiculo admivehi;
    LinkedList<Vehiculo> listaToyota;
    LinkedList<Vehiculo> listaCheverolet;
    
    public Principal() {
        initComponents();
        bp= new BuscarPanel();
        ap= new AgregarPanel();
        alp= new AlquilarPanel();
        listaToyota= new LinkedList<Vehiculo>();
        listaCheverolet= new LinkedList<Vehiculo>();
        
        
        int sizeInstante=admivehi.size();
        Nodo<Vehiculo> vehiculoSentinela=admivehi.listaDeVehiculos.top;
        for(int i=0;i<sizeInstante;i++){
            System.out.println(i);
            if(vehiculoSentinela.key.getMarca().equals("Toyota")){
                listaToyota.pushBack(vehiculoSentinela.key);
            }
            if(vehiculoSentinela.key.getMarca().equals("Cheverolet")){
                listaCheverolet.pushBack(vehiculoSentinela.key);
            }
            vehiculoSentinela=vehiculoSentinela.next;
        }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        buscarBoton = new javax.swing.JButton();
        agregarBoton = new javax.swing.JButton();
        alquilarBoton = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ALQUILER DE VEHÍCULOS");

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        panelPrincipal.add(jPanel1, java.awt.BorderLayout.CENTER);

        buscarBoton.setText("Buscar");
        buscarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBotonActionPerformed(evt);
            }
        });

        agregarBoton.setText("Agregar");
        agregarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBotonActionPerformed(evt);
            }
        });

        alquilarBoton.setText("Alquilar");
        alquilarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buscarBoton)
                        .addGap(39, 39, 39)
                        .addComponent(alquilarBoton)
                        .addGap(30, 30, 30)
                        .addComponent(agregarBoton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarBoton)
                    .addComponent(agregarBoton)
                    .addComponent(alquilarBoton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setAdministrarVehiculos(AdministrarVehiculo adv){
        this.admivehi=adv;
    }
    public void setListaVehiculos(LinkedList lista){
        this.listaVehiculos=lista;
    }
    private void buscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBotonActionPerformed
        // TODO add your handling code here:
        panelPrincipal.setVisible(false);
        panelPrincipal.removeAll();
        panelPrincipal.add(bp);
        panelPrincipal.setVisible(true);
        
    }//GEN-LAST:event_buscarBotonActionPerformed

    private void agregarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBotonActionPerformed
        // TODO add your handling code here:
        panelPrincipal.setVisible(false);
        panelPrincipal.removeAll();
        panelPrincipal.add(ap);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_agregarBotonActionPerformed

    private void alquilarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarBotonActionPerformed
        // TODO add your handling code here:
        alp.setListaVehiculosAlP(listaVehiculos);
        alp.setAdministrarVehiculo(admivehi);
        alp.setListaToyota(listaToyota);
        alp.setListaCheverolet(listaCheverolet);
        panelPrincipal.setVisible(false);
        panelPrincipal.removeAll();
        panelPrincipal.add(alp);
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_alquilarBotonActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBoton;
    private javax.swing.JButton alquilarBoton;
    private javax.swing.JButton buscarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelPrincipal;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    // End of variables declaration//GEN-END:variables
}
