/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.AdministrarVehiculo;
import Estructuras.*;
import Modelo.Vehiculo;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago Mendoza
 */
public class BuscarPanel extends javax.swing.JPanel {

    private AdministrarVehiculo admivehi;
    DefaultTableModel modelo;
    String tipo=null;
    
    
    public BuscarPanel() {
        initComponents();
        this.jTable1.setVisible(false);
        this.jTable1.setDefaultRenderer(Object.class, new Render()); //renderizar la tabla permitiendo añadir botones
        this.jTable1.setRowHeight(22);
        modelo = new CustomTableModel();  //usamos la clase customTableModel donde se reescribio un metodo para que las celdas de botones no sean editables
        modelo.addColumn("Placa");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año");
        modelo.addColumn("Kilom.");
        modelo.addColumn("Cilindraje");
        modelo.addColumn("Puestos");
        modelo.addColumn("Alquilado");
        modelo.addColumn("Editar");
        modelo.addColumn("Eliminar");
        this.jTable1.setModel(modelo);
        
    }
    public void setAdministrarVehiculo(AdministrarVehiculo av){
        this.admivehi=av;
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
        jCheckBoxPlaca = new javax.swing.JCheckBox();
        jCheckBoxMarca = new javax.swing.JCheckBox();
        jCheckBoxModelo = new javax.swing.JCheckBox();
        jTextFieldValor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("BUSCAR");

        jCheckBoxPlaca.setText("Placa");
        jCheckBoxPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPlacaActionPerformed(evt);
            }
        });

        jCheckBoxMarca.setText("Marca");
        jCheckBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMarcaActionPerformed(evt);
            }
        });

        jCheckBoxModelo.setText("Modelo");
        jCheckBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxModeloActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxPlaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxMarca))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(190, 190, 190)
                        .addComponent(jCheckBoxModelo)))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPlaca)
                    .addComponent(jCheckBoxMarca)
                    .addComponent(jCheckBoxModelo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMarcaActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxMarca.isSelected()){
            tipo = "marca";
            jCheckBoxPlaca.setEnabled(false);
            jCheckBoxModelo.setEnabled(false);
            
        }else{
            tipo = null;
            jCheckBoxPlaca.setEnabled(true);
            jCheckBoxModelo.setEnabled(true);
        }
        
    }//GEN-LAST:event_jCheckBoxMarcaActionPerformed

    private void jCheckBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxModeloActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxModelo.isSelected()){
            tipo = "modelo";
            jCheckBoxMarca.setEnabled(false);
            jCheckBoxPlaca.setEnabled(false);
            
        }else{
            tipo = null;
            jCheckBoxMarca.setEnabled(true);
            jCheckBoxPlaca.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBoxModeloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (int i = jTable1.getRowCount()-1; i>=0; i--){
            modelo.removeRow(i);
        }
        long inicio = System.currentTimeMillis();
        Stack<Vehiculo> pilaVehiculos = new Stack<>();
        Stack<Vehiculo> pilaVehiculos2 = new Stack<>();
        if(tipo!=null){
            
            String valor = jTextFieldValor.getText().replace(' ', '-');
            switch (tipo){
                case "placa":
                    pilaVehiculos = admivehi.buscarHashPlaca(valor);
                    pilaVehiculos2 = admivehi.buscarAlquiladosHashPlaca(valor);     
                    break;
                case "marca":
                    pilaVehiculos = admivehi.buscarHashMarca(valor);
                    pilaVehiculos2 = admivehi.buscarAlquiladosHashMarca(valor);
                    break;
                case "modelo":
                    pilaVehiculos = admivehi.buscarHashReferencia(valor);
                    pilaVehiculos2 = admivehi.buscarAlquiladosHashModelo(valor);
            }
            int coincidencias=pilaVehiculos.size()+pilaVehiculos2.size();
            
            System.out.println(coincidencias + " coincidencias");
            if(coincidencias==0){
                JOptionPane.showMessageDialog(this, "No se encontraron coincidencias");
            }else{
                this.jTable1.setVisible(true);
                
                while(!pilaVehiculos.isEmpty()){
                    Vehiculo vehic = pilaVehiculos.pop();
                    Object [] Datos = new Object[10];
                    JButton btn_editar = new JButton("Editar");
                    btn_editar.setName("editar");
                    JButton btn_eliminar = new JButton("Eliminar");
                    btn_eliminar.setName("eliminar");
                    Datos[0] = vehic.getPlaca();
                    Datos[1] = vehic.getMarca();
                    Datos[2] = vehic.getReferencia();
                    Datos[3] = String.valueOf(vehic.getYear());
                    Datos[4] = String.valueOf(vehic.getKilometraje());
                    Datos[5] = String.valueOf(vehic.getCilindraje());
                    Datos[6] = String.valueOf(vehic.getPuestos());
                    Datos[7] = "No";
                    Datos[8] = btn_editar;
                    Datos[9] = btn_eliminar;
                            
                    modelo.addRow(Datos);
                }
                while(!pilaVehiculos2.isEmpty()){
                    Vehiculo vehic = pilaVehiculos2.pop();
                    Object[] Datos = new Object[10];
                    JButton btn_editar = new JButton("Editar");
                    btn_editar.setName("editar");
                    JButton btn_eliminar = new JButton("Eliminar");
                    btn_eliminar.setName("eliminar");
                    Datos[0] = vehic.getPlaca();
                    Datos[1] = vehic.getMarca();
                    Datos[2] = vehic.getReferencia();
                    Datos[3] = String.valueOf(vehic.getYear());
                    Datos[4] = String.valueOf(vehic.getKilometraje());
                    Datos[5] = String.valueOf(vehic.getCilindraje());
                    Datos[6] = String.valueOf(vehic.getPuestos());
                    Datos[7] = "Si";
                    Datos[8] = btn_editar;
                    Datos[9] = btn_eliminar;
                    
                    modelo.addRow(Datos);
                }
            }     
        }else{
            JOptionPane.showMessageDialog(this, "Escoja la variable por la que desea Buscar");
        }

//        Queue<Vehiculo> colaVehiculos = new Queue<>();
//        Queue<Vehiculo> colaVehiculos2 = new Queue<>();
//        if(tipo!=null){
//            
//            String valor = jTextFieldValor.getText().replace(' ', '-');
//            switch (tipo){
//                case "placa":
//                    colaVehiculos = admivehi.buscarVehiculoArbolPlaca2_2(valor);
//                    colaVehiculos2 = admivehi.buscarVehiculoAlquiladosPlaca_2(valor);
//                    break;
//                case "marca":
//                    colaVehiculos = admivehi.buscarVehiculoArbolMarca_2(valor);
//                    colaVehiculos2 = admivehi.buscarVehiculoAlquiladosMarca_2(valor);
//                    break;
//                case "modelo":
//                    colaVehiculos = admivehi.buscarVehiculoArbolModelo_2(valor);
//                    colaVehiculos2 = admivehi.buscarVehiculoAlquiladosModelo_2(valor);
//            }
//            int coincidencias=colaVehiculos.lista.size()+colaVehiculos2.lista.size();
//            
//            System.out.println(coincidencias + " coincidencias");
//            if(coincidencias==0){
//                JOptionPane.showMessageDialog(this, "No se encontraron coincidencias");
//            }else{
//                this.jTable1.setVisible(true);
//                
//                while(!colaVehiculos.isEmpty()){
//                    Vehiculo vehic = colaVehiculos.dequeue();
//                    Object [] Datos = new Object[10];
//                    JButton btn_editar = new JButton("Editar");
//                    btn_editar.setName("editar");
//                    JButton btn_eliminar = new JButton("Eliminar");
//                    btn_eliminar.setName("eliminar");
//                    Datos[0] = vehic.getPlaca();
//                    Datos[1] = vehic.getMarca();
//                    Datos[2] = vehic.getReferencia();
//                    Datos[3] = String.valueOf(vehic.getYear());
//                    Datos[4] = String.valueOf(vehic.getKilometraje());
//                    Datos[5] = String.valueOf(vehic.getCilindraje());
//                    Datos[6] = String.valueOf(vehic.getPuestos());
//                    Datos[7] = "No";
//                    Datos[8] = btn_editar;
//                    Datos[9] = btn_eliminar;
//                            
//                    modelo.addRow(Datos);
//                }
//                while(!colaVehiculos2.isEmpty()){
//                    Vehiculo vehic = colaVehiculos2.dequeue();
//                    Object[] Datos = new Object[10];
//                    JButton btn_editar = new JButton("Editar");
//                    btn_editar.setName("editar");
//                    JButton btn_eliminar = new JButton("Eliminar");
//                    btn_eliminar.setName("eliminar");
//                    Datos[0] = vehic.getPlaca();
//                    Datos[1] = vehic.getMarca();
//                    Datos[2] = vehic.getReferencia();
//                    Datos[3] = String.valueOf(vehic.getYear());
//                    Datos[4] = String.valueOf(vehic.getKilometraje());
//                    Datos[5] = String.valueOf(vehic.getCilindraje());
//                    Datos[6] = String.valueOf(vehic.getPuestos());
//                    Datos[7] = "Si";
//                    Datos[8] = btn_editar;
//                    Datos[9] = btn_eliminar;
//                    
//                    modelo.addRow(Datos);
//                }
//            }     
//        }else{
//            JOptionPane.showMessageDialog(this, "Escoja la variable por la que desea Buscar");
//        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo busqueda: " + (fin-inicio));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPlacaActionPerformed
        // TODO add your handling code here:
        if (jCheckBoxPlaca.isSelected()){
            tipo = "placa";
            jCheckBoxMarca.setEnabled(false);
            jCheckBoxModelo.setEnabled(false);
            
        }else{
            tipo = null;
            jCheckBoxMarca.setEnabled(true);
            jCheckBoxModelo.setEnabled(true);
        }
        
    }//GEN-LAST:event_jCheckBoxPlacaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //este long para hacer la prueba de tiempo
        long inicio; 
        long fin;
        
        int column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTable1.getRowHeight();
        
        if(row < jTable1.getRowCount() && row >= 0 && column < jTable1.getColumnCount() && column >= 0){
            Object value = jTable1.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton btn = (JButton) value;
                if(btn.getName().equals("editar")){
                    String alquilado = String.valueOf(jTable1.getValueAt(row, 7));
                    if("No".equals(alquilado)){
                        int selection = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este vehículo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(selection == 0){
                            inicio = System.currentTimeMillis();
                            String[] datos = new String[8];
                            for(int i=0; i<8; i++){
                                datos[i] = String.valueOf(jTable1.getValueAt(row, i));
                            }
                            Vehiculo v = new Vehiculo(Float.valueOf(datos[4]),Integer.valueOf(datos[3]),datos[1],datos[2],Integer.valueOf(datos[5]),datos[0],Integer.valueOf(datos[6]));
                            admivehi.borrarVehiculoHash(v);
                            admivehi.agregarVehiculoHash(v);
                            //AVLTreeNode2String<Vehiculo> vehiPlaca = admivehi.arbolDeVehiculosPlacas.contains(v.getPlaca());
                            //Stack<Vehiculo> vehiPlaca = admivehi.buscarVehiculoArbolPlaca2(v.getPlaca());
                            //Vehiculo vehi = vehiPlaca.pop();
                            /*if(vehiPlaca!=null){
                                AVLTreeNode2String<Vehiculo> vehiArbDeArb = (AVLTreeNode2String) vehiPlaca.listaEquivalentes.top.key;
                                AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolReferencias=new AVLTreeNode2String();
                                nodoArbolReferencias=admivehi.arbolDeVehiculos.contains(vehiArbDeArb.key.getMarca());
                                if(nodoArbolReferencias!=null){
                                    BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolReferencias.key;
                                    AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDePlacas= arbolDeReferencias.contains(vehiArbDeArb.key.getReferencia());
                                    if(nodoArbolDePlacas!=null){
                                        BinarySearchTree_AVL2 arbolDePlacas=nodoArbolDePlacas.key;
                                        arbolDePlacas.eliminarAVL(vehiArbDeArb);
                                    }
                                }
                            }*/
                            //admivehi.borrarVehiculoArbolConPlaca(vehi.getMarca(), vehi.getReferencia(), vehi.getPlaca());
                            //admivehi.borrarVehiculoArbolConPlaca(vehiPlaca.key.getMarca(), vehiPlaca.key.getReferencia(), vehiPlaca.key.getPlaca());
                            //admivehi.arbolDeVehiculosPlacas.eliminar(vehiPlaca);
                            //admivehi.agregarVehiculoArbol(v);
                            setAdministrarVehiculo(admivehi);

                            //nuevo tiempo al acabar
                            fin = System.currentTimeMillis();
                            //calculo e impresion del tiempo
                            double tiempo = (double) (fin - inicio);
                            System.out.println(tiempo +" mili"); //imprimir tiempo
                        }else{
                            
                        }
                    }

                    if("Si".equals(alquilado)){
                        JOptionPane.showMessageDialog(this, "No es posible editar un vehículo alquilado");
                    }
                    
                }if(btn.getName().equals("eliminar")){
                    //ir y eliminar con ayuda de la placa
                    String alquilado = String.valueOf(jTable1.getValueAt(row, 7));
                    if("No".equals(alquilado)){
                        int selection = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este vehículo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(selection == 0){
                            inicio = System.currentTimeMillis();
                            String[] datos = new String[8];
                            for(int i=0; i<8; i++){
                                datos[i] = String.valueOf(jTable1.getValueAt(row, i));
                            }
                            Vehiculo v = new Vehiculo(Float.valueOf(datos[4]),Integer.valueOf(datos[3]),datos[1],datos[2],Integer.valueOf(datos[5]),datos[0],Integer.valueOf(datos[6]));
                            admivehi.borrarVehiculoHash(v);
                            //AVLTreeNode2String<Vehiculo> vehiPlaca = admivehi.arbolDeVehiculosPlacas.contains(v.getPlaca());
                            //Stack<Vehiculo> vehiPlaca = admivehi.buscarVehiculoArbolPlaca2(v.getPlaca());
                            //Vehiculo vehi = vehiPlaca.pop();
                            /*if(vehiPlaca!=null){
                                AVLTreeNode2String<Vehiculo> vehiArbDeArb = (AVLTreeNode2String) vehiPlaca.listaEquivalentes.top.key;
                                AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolReferencias=new AVLTreeNode2String();
                                nodoArbolReferencias=admivehi.arbolDeVehiculos.contains(vehiArbDeArb.key.getMarca());
                                if(nodoArbolReferencias!=null){
                                    BinarySearchTree_AVL2<BinarySearchTree_AVL2> arbolDeReferencias=nodoArbolReferencias.key;
                                    AVLTreeNode2String<BinarySearchTree_AVL2> nodoArbolDePlacas= arbolDeReferencias.contains(vehiArbDeArb.key.getReferencia());
                                    if(nodoArbolDePlacas!=null){
                                        BinarySearchTree_AVL2 arbolDePlacas=nodoArbolDePlacas.key;
                                        arbolDePlacas.eliminar(vehiArbDeArb);
                                    }

                                }

                            }*/
                            //admivehi.borrarVehiculoArbolConPlaca(vehi.getMarca(), vehi.getReferencia(), vehi.getPlaca());
                            //admivehi.borrarVehiculoArbolConPlaca(vehiPlaca.key.getMarca(), vehiPlaca.key.getReferencia(), vehiPlaca.key.getPlaca());
                            //admivehi.arbolDeVehiculosPlacas.eliminar(vehiPlaca);
                            setAdministrarVehiculo(admivehi);
                            modelo.removeRow(row);

                            //nuevo tiempo al acabar
                            fin = System.currentTimeMillis();
                            //calculo e impresion del tiempo
                            double tiempo = (double) (fin - inicio);
                            System.out.println(tiempo +" mili"); //imprimir tiempo
                        }else{
                            
                        }
                    }
                    
                    if("Si".equals(alquilado)){
                        JOptionPane.showMessageDialog(this, "No es posible eliminar un vehículo alquilado");
                    }
                }
            } 
        }
        //setAdministrarVehiculo(admivehi);
    }//GEN-LAST:event_jTable1MouseClicked

    //}                                    


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxMarca;
    private javax.swing.JCheckBox jCheckBoxModelo;
    private javax.swing.JCheckBox jCheckBoxPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
