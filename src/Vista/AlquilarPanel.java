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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        alquilarBoton = new javax.swing.JButton();
        marcaTF = new javax.swing.JTextField();
        referenciaTF = new javax.swing.JTextField();
        placaTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        devolverBT = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ALQUILAR");

        jLabel2.setText("MARCA");

        jLabel3.setText("REFERENCIA");

        alquilarBoton.setText("Alquilar");
        alquilarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilarBotonActionPerformed(evt);
            }
        });

        jLabel4.setText(" PLACA");

        devolverBT.setText("Devolver");
        devolverBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(marcaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(referenciaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(80, 80, 80)))
                        .addGap(27, 27, 27)
                        .addComponent(alquilarBoton)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(placaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(devolverBT)
                        .addGap(171, 171, 171))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alquilarBoton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marcaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(referenciaTF)))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(devolverBT)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
     
    public void setAdministrarVehiculo(AdministrarVehiculo adv){
        this.admivehi=adv;
    }
    public void setListaVehiculosAlP(LinkedList lista){
        this.listaVehiculosAlP= lista;
    }
    
    private void alquilarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarBotonActionPerformed
        // TODO add your handling code here:
        String marca= marcaTF.getText();
        String referencia= referenciaTF.getText();
        /*int cantidadVehiculos= admivehi.size();
        //System.out.println(cantidadVehiculos);
        Nodo<Vehiculo> sentinela= admivehi.listaDeVehiculos.top;
        boolean estado=false;
        for(int i=0;i<cantidadVehiculos;i++){
            //System.out.println(sentinela.key.getMarca()+" "+sentinela.key.getReferencia());
            if(sentinela.key.getMarca().equals(marca)){
                
                if(sentinela.key.getReferencia().equals(referencia)){
                    admivehi.borrarVehiculo(sentinela.key);
                    Vehiculo alquilado=sentinela.key;
                    
                    admivehi.vehiculosAlquilados.pushBack(alquilado);
                    //System.out.println(vehiculosAlquilados.size());
                    //System.out.println(admivehi.size());
                    estado=true;
                    JOptionPane.showMessageDialog(this, "El vehiculo alquilado es:"+alquilado.getMarca()+" "+alquilado.getReferencia()+" de placa "+alquilado.getPlaca());
                    
                    break;
                }
            }
            sentinela=sentinela.next;
        }
        if(!estado){
            JOptionPane.showMessageDialog(this, "No hay un vehiculo de esta marca y referencia disponible para alquilar");
        }
        System.out.println(admivehi.size());
        System.out.println(admivehi.vehiculosAlquilados.size());
        */
        Vehiculo vehiculoAEliminar =admivehi.borrarVehiculoArbol(marca, referencia);
        
        //Vehiculo alquilado=colaMarca.dequeue();
        if(vehiculoAEliminar==null){
                JOptionPane.showMessageDialog(this, "No hay un vehiculo de esta marca y referencia disponible para alquilar");
        }
        else{
            //admivehi.agregarVehiculoArbolAlquilados(vehiculoAEliminar);
            admivehi.agregarVehiculoArbolAlquilados(vehiculoAEliminar);
            JOptionPane.showMessageDialog(this,vehiculoAEliminar.getMarca()+" "+vehiculoAEliminar.getReferencia()+" "+vehiculoAEliminar.getPlaca());
        }
        
        
        //JOptionPane.showMessageDialog(this,"El vehiculo alquilado es el: "+alquilado.getMarca()+" "+alquilado.getReferencia()+" de placa "+alquilado.getPlaca());
    }//GEN-LAST:event_alquilarBotonActionPerformed

    private void devolverBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverBTActionPerformed
        // TODO add your handling code here:
        System.out.println("rr");
        Vehiculo devuelto= admivehi.borrarVehiculoArbolAlquilados(placaTF.getText());
        if(devuelto!=null){
            admivehi.agregarVehiculoArbol(devuelto);
            
            JOptionPane.showMessageDialog(this, "Se ha devuelto el vehiculo "+devuelto.getMarca()+" "+devuelto.getReferencia()+" "+devuelto.getPlaca());
        
        }
        else{
            JOptionPane.showMessageDialog(this, "No hay ningun vehiculo alquilado con esta placa");
        }
        
        
        
        
        
        
    }//GEN-LAST:event_devolverBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alquilarBoton;
    private javax.swing.JButton devolverBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField marcaTF;
    private javax.swing.JTextField placaTF;
    private javax.swing.JTextField referenciaTF;
    // End of variables declaration//GEN-END:variables
}
