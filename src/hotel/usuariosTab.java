package hotel;

import hotel.Usuarios;
import javax.swing.table.DefaultTableModel;
import hotel.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class usuariosTab extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();
    DefaultTableModel model;
    
    public usuariosTab() {
        initComponents();
        
    }
    
    public LinkedList<Usuarios> listar(){
        
        String sql = "select * from usuarios";
        
        try {
            // Inicia la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            LinkedList<Usuarios> lista = new LinkedList<Usuarios>();
            
            while(rs.next()) {
                
                lista.add(new Usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), 
                rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9))); 
             
            }
            
            return lista;
        } catch (Exception e) {
            
        }
        
        return null;
    }
    
    // Se escribe el metodo para crear usuarios
    public void crear(Usuarios usuarios) {
        
        String sql = "insert into usuarios(codigo, nombre, apellido, telefono, direccion, \n" +
"            correo, dob, pass, role) values(?,?,?,?,?,?,?,?,?);";
        
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuarios.getCodigo());
            ps.setString(2, usuarios.getNombre());
            ps.setString(3, usuarios.getApellido());
            ps.setInt(4, usuarios.getTelefono());
            ps.setString(5, usuarios.getDireccion());
            ps.setString(6, usuarios.getCorreo());
            ps.setString(7, usuarios.getDob());
            ps.setString(8, usuarios.getPass());
            ps.setInt(9, usuarios.isRole());
            ps.executeUpdate();
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
    // Se escribe el metodo para actualizar usuarios
    public void modificar(Usuarios usuarios) {
        
        String sql = "update usuarios set nombre=?, apellido=?, telefono=?, direccion=?, correo=?, dob=? where codigo=?;";
        
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(2, usuarios.getNombre());
            ps.setString(3, usuarios.getApellido());
            ps.setInt(4, usuarios.getTelefono());
            ps.setString(5, usuarios.getDireccion());
            ps.setString(6, usuarios.getCorreo());
            ps.setString(7, usuarios.getDob());
            ps.setInt(8, usuarios.getCodigo());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    // Se escribe el metodo para eliminar usuarios
    public void eliminar(int codigo) {
        
        String sql = "delete from usuarios where codigo=?;";
        
        try {
            
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
        } catch(Exception e){
            
        }
    }
    
    public Usuarios obtener(int codigo) {
        
        String sql = "select * from usuarios where codigo=?;";
        //2.22.31
        try {
            // Inicia la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                Usuarios lista = new Usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), 
                rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)); 
                
                return lista;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
        
    }
    
    public void login(String correo, String pass) {
        
        String sql = "From * usuarios where correo=?, pass=?;";
        
    }
    
    public void tab(int codigo) {
        
        String columnas[] = {"Codigo", "Nombre", "Dirección", "Correo", "Telefono"};
        model = new DefaultTableModel(null, columnas);
            for ( Usuarios.Usuarios datos : columnas) {
                
                Object ayuda[] = new Object[5];
                
                ayuda[0] = datos.getCodigo();
                ayuda[1] = datos.getCodigo();
                ayuda[2] = datos.getCodigo();
                ayuda[3] = datos.getCodigo();
                ayuda[4] = datos.getCodigo();
                
                model.addRow(ayuda);
            }
        
        }
        String query = "Select * from evalti;";
        //ResultSet rs1 = ps.executeQuery();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        labelName = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        Tab1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        btnAgregar.setText("Agregar Usuario");
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setMaximumSize(new java.awt.Dimension(85, 30));
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setMaximumSize(new java.awt.Dimension(60, 30));
        btnSalir.setPreferredSize(new java.awt.Dimension(40, 21));
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        Tab1.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPane.setViewportView(Tab1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPane)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        login nuevoLog = new login();
        nuevoLog.show();
        
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        updateUsuario nuevoMod = new updateUsuario();
        
        nuevoMod.show();
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        addUsuario nuevo = new addUsuario();
        nuevo.show();
    
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        deleteUsuario nuevoDel = new deleteUsuario();
        
        nuevoDel.show();
        
    }//GEN-LAST:event_btnEliminarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuariosTab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelName;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
