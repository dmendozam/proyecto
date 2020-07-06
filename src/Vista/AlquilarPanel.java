/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.*;
import Control.*;
import Estructuras.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Mendoza
 */
public class AlquilarPanel extends javax.swing.JPanel {

    /**
     * Creates new form Alquilar
     */
    private AdministrarVehiculo admivehi;
    LinkedList listaVehiculosAlP;
    
    
    public AlquilarPanel() {
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

        jLabel1 = new javax.swing.JLabel();
        placaTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        devolverBT = new javax.swing.JButton();
        alquilarPlacaBoton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ALQUILAR");

        jLabel4.setText(" PLACA");

        devolverBT.setText("Devolver");
        devolverBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverBTActionPerformed(evt);
            }
        });

        alquilarPlacaBoton.setText("Alquilar");
        alquilarPlacaBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilarPlacaBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(placaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(devolverBT)
                                .addGap(67, 67, 67)
                                .addComponent(alquilarPlacaBoton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(84, 84, 84)))))
                .addGap(0, 105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(155, 155, 155)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(devolverBT)
                    .addComponent(alquilarPlacaBoton))
                .addContainerGap(213, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
     
    public void setAdministrarVehiculo(AdministrarVehiculo adv){
        this.admivehi=adv;
    }
    public void setListaVehiculosAlP(LinkedList lista){
        this.listaVehiculosAlP= lista;
    }
    
    private void devolverBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverBTActionPerformed
        // TODO add your handling code here:
        //System.out.println("rr");
        Vehiculo devuelto= admivehi.borrarVehiculoHashAlquilados(placaTF.getText());
        if(devuelto!=null){
            admivehi.agregarVehiculoHash(devuelto);
            JOptionPane.showMessageDialog(this, "Se ha devuelto el vehiculo "+devuelto.getMarca()+" "+devuelto.getReferencia()+" "+devuelto.getPlaca());
        
        }
        else{
            JOptionPane.showMessageDialog(this, "No hay ningun vehiculo alquilado con esta placa");
        }
        
        
        
        
        
        
    }//GEN-LAST:event_devolverBTActionPerformed

    private void alquilarPlacaBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarPlacaBotonActionPerformed
        // TODO add your handling code here:
        long inicio = System.currentTimeMillis();
        long fin;
        String placa=placaTF.getText();
        Vehiculo vehiculoAEliminar= admivehi.borrarVehiculoHashPlacas(placa);
        if(vehiculoAEliminar!=null){
                        //JOptionPane.showMessageDialog(this,vehiculoAEliminar.getMarca()+" "+vehiculoAEliminar.getReferencia()+" "+vehiculoAEliminar.getPlaca());

            Vehiculo eliminadoMarca=admivehi.eliminarVehiculosHashMarcaPlaca(vehiculoAEliminar.getMarca(), vehiculoAEliminar.getPlaca());
            Vehiculo eliminadoReferencia=admivehi.eliminarVehiculosHashReferenciaPlaca(vehiculoAEliminar.getReferencia(), vehiculoAEliminar.getPlaca());
        
            admivehi.agregarVehiculoHashAlquilados(vehiculoAEliminar);
            fin = System.currentTimeMillis();
            //calculo e impresion del tiempo
            double tiempo = (double) (fin - inicio);
            System.out.println(tiempo +" mili"); //imprimir tiempo 
            JOptionPane.showMessageDialog(this,vehiculoAEliminar.getMarca()+" "+vehiculoAEliminar.getReferencia()+" "+vehiculoAEliminar.getPlaca());
        }
        else{
            JOptionPane.showMessageDialog(this, "No hay un vehiculo con esta marca, referencia y placa disponible para alquilar");
        }
    }//GEN-LAST:event_alquilarPlacaBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alquilarPlacaBoton;
    private javax.swing.JButton devolverBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField placaTF;
    // End of variables declaration//GEN-END:variables
}
