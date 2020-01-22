package Sys;

import MySQL.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Pro
 */
public class Principal extends javax.swing.JFrame {

    Conexion cone = new Conexion();
    Connection c = cone.getConnection();

    public Principal() {
        initComponents();
        txtId.setVisible(false);
        txtIdC.setVisible(false);
        txtIdPro.setVisible(false);
        mostrarProduct();
        mostrarClientes();
        mostrarProveedores();

    }

    private void crearRespaldo() {
        int resp;
        JFileChooser RealizarBackupMySQL = new JFileChooser();
        resp = RealizarBackupMySQL.showSaveDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            try {
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(RealizarBackupMySQL.getSelectedFile().toString()) + ".sql");
                FileWriter fw = new FileWriter(backupFile);
                Process p = runtime.exec("C:\\Archivos de programa\\MySQL\\MySQL Server 5.7\\bin\\mysqldump --opt --password=root --user=root --databases maxdb");

                InputStreamReader irs = new InputStreamReader(p.getInputStream());
                BufferedReader br = new BufferedReader(irs);

                String line;
                while ((line = br.readLine()) != null) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();

                JOptionPane.showMessageDialog(null, "Archivo generado correctamente.", "Verificar", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo:::" + e.getMessage(), "Verificar", JOptionPane.ERROR_MESSAGE);
            }

        } else if (resp == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Ha sido cancelada la generación del Backup.");
        }
    }

    public void mostrarProveedores() {
        DefaultTableModel mC = new DefaultTableModel();
        mC.addColumn("Id");
        mC.addColumn("Codigo");
        mC.addColumn("Nombre");
        mC.addColumn("Direccion");
        mC.addColumn("Telefono");
        mC.addColumn("Mail");
        tbPro.setModel(mC);
        tbPro.getColumnModel().getColumn(0).setMaxWidth(0);
        tbPro.getColumnModel().getColumn(0).setMinWidth(0);
        tbPro.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbPro.getColumnModel().getColumn(0).setResizable(false);
        try {
            String data[] = new String[6];
            ResultSet rs = null;
            String query = "SELECT * FROM proveedores";
            Statement st = c.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                mC.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public void mostrarClientes() {
        DefaultTableModel mC = new DefaultTableModel();
        mC.addColumn("Id");
        mC.addColumn("Codigo");
        mC.addColumn("Nombre");
        mC.addColumn("Direccion");
        mC.addColumn("Telefono");
        mC.addColumn("Mail");
        tbClientes.setModel(mC);
        tbClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tbClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tbClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbClientes.getColumnModel().getColumn(0).setResizable(false);
        try {
            String data[] = new String[6];
            ResultSet rs = null;
            String query = "SELECT * FROM clientes";
            Statement st = c.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                mC.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    public void limpiarPro() {
        txtCodPro.setText("");
        txtNamePro.setText("");
        txtDirPro.setText("");
        txtTelPro.setText("");
        txtMailPro.setText("");
    }

    public void limpiarC() {
        txtCodC.setText("");
        txtNameC.setText("");
        txtDirC.setText("");
        txtTelC.setText("");
        txtMailC.setText("");
    }

    public void limpiar() {
        txtCod.setText("");
        txtName.setText("");
        txtDes.setText("");
        txtPre.setText("");
    }

    public void mostrarProduct() {
        mostrarClientes();
        DefaultTableModel m = new DefaultTableModel();
        m.addColumn("Id");
        m.addColumn("Codigo");
        m.addColumn("Nombre");
        m.addColumn("Descripcion");
        m.addColumn("Precio");
        tbProduct.setModel(m);
        tbProduct.getColumnModel().getColumn(0).setMaxWidth(0);
        tbProduct.getColumnModel().getColumn(0).setMinWidth(0);
        tbProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
        tbProduct.getColumnModel().getColumn(0).setResizable(false);
        try {
            String data[] = new String[5];
            ResultSet rs = null;
            String query = "SELECT * FROM productos";
            Statement st = c.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                m.addRow(data);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        etiName = new javax.swing.JLabel();
        etiDes = new javax.swing.JLabel();
        etiPre = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDes = new javax.swing.JTextField();
        txtPre = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        txtCod = new javax.swing.JTextField();
        etiCod = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnMod = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        etiNameC = new javax.swing.JLabel();
        etiDirC = new javax.swing.JLabel();
        etiTelC = new javax.swing.JLabel();
        etiMailC = new javax.swing.JLabel();
        txtNameC = new javax.swing.JTextField();
        txtDirC = new javax.swing.JTextField();
        txtTelC = new javax.swing.JTextField();
        txtMailC = new javax.swing.JTextField();
        btnModC = new javax.swing.JButton();
        btnAddC = new javax.swing.JButton();
        btnDelC = new javax.swing.JButton();
        txtCodC = new javax.swing.JTextField();
        etiCodC = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        etiTelPro = new javax.swing.JLabel();
        etiMailPro = new javax.swing.JLabel();
        txtNamePro = new javax.swing.JTextField();
        txtDirPro = new javax.swing.JTextField();
        txtTelPro = new javax.swing.JTextField();
        txtMailPro = new javax.swing.JTextField();
        btnModPro = new javax.swing.JButton();
        etiNamePro = new javax.swing.JLabel();
        btnAddPro = new javax.swing.JButton();
        etiDirPro = new javax.swing.JLabel();
        btnDelPro = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPro = new javax.swing.JTable();
        txtCodPro = new javax.swing.JTextField();
        etiCodPro = new javax.swing.JLabel();
        txtIdPro = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        etiOpera = new javax.swing.JLabel();
        comboOperaciones = new javax.swing.JComboBox<>();
        etiReg = new javax.swing.JLabel();
        comboEntidades = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBitProduct = new javax.swing.JTable();
        btnMostrarBitacora = new javax.swing.JButton();
        btnRespaldo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnGenReport = new javax.swing.JButton();
        etiSelect = new javax.swing.JLabel();
        tablaOp = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbProduct1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 255, 0), null, null));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/tienda-online-alfonsopuig-copy.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel2);

        etiName.setText("Nombre ");

        etiDes.setText("Descripcion");

        etiPre.setText("Precio");

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tbProduct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbProduct.getTableHeader().setReorderingAllowed(false);
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        etiCod.setText("Codigo");

        btnMod.setText("Modificar");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnDel.setText("Eliminar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(etiDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(etiPre)
                                .addComponent(etiCod))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName)
                                .addComponent(txtDes)
                                .addComponent(txtPre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(txtCod)
                                .addComponent(txtId)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiCod))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiDes)
                            .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiPre)
                            .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnMod))
                        .addGap(18, 18, 18)
                        .addComponent(btnDel)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Productos", jPanel3);

        etiNameC.setText("Nombre");

        etiDirC.setText("Direccion");

        etiTelC.setText("Telefono");

        etiMailC.setText("Mail");

        btnModC.setText("Modificar");
        btnModC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCActionPerformed(evt);
            }
        });

        btnAddC.setText("Agregar");
        btnAddC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCActionPerformed(evt);
            }
        });

        btnDelC.setText("Eliminar");
        btnDelC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelCActionPerformed(evt);
            }
        });

        etiCodC.setText("Codigo");

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbClientes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnModC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                        .addComponent(btnAddC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiNameC)
                                            .addComponent(etiDirC)
                                            .addComponent(etiTelC)
                                            .addComponent(etiMailC))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDirC)
                                            .addComponent(txtTelC)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtNameC, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtMailC, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(etiCodC)
                                        .addGap(38, 38, 38)
                                        .addComponent(txtCodC))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnDelC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 22, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiCodC)
                            .addComponent(txtCodC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiNameC)
                            .addComponent(txtNameC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiDirC)
                            .addComponent(txtDirC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiTelC)
                            .addComponent(txtTelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiMailC)
                            .addComponent(txtMailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddC)
                            .addComponent(btnModC))
                        .addGap(18, 18, 18)
                        .addComponent(btnDelC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel4);

        etiTelPro.setText("Telefono");

        etiMailPro.setText("Mail");

        btnModPro.setText("Modificar");
        btnModPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProActionPerformed(evt);
            }
        });

        etiNamePro.setText("Nombre");

        btnAddPro.setText("Agregar");
        btnAddPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProActionPerformed(evt);
            }
        });

        etiDirPro.setText("Direccion");

        btnDelPro.setText("Eliminar");
        btnDelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelProActionPerformed(evt);
            }
        });

        tbPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPro);

        txtCodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProActionPerformed(evt);
            }
        });

        etiCodPro.setText("Codigo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(btnModPro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddPro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etiNamePro)
                                        .addComponent(etiDirPro)
                                        .addComponent(etiMailPro))
                                    .addGap(200, 200, 200))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(etiTelPro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTelPro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(etiCodPro)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamePro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDirPro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMailPro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnDelPro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiCodPro)
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiNamePro)
                    .addComponent(txtNamePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiDirPro)
                    .addComponent(txtDirPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiTelPro)
                    .addComponent(txtTelPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiMailPro)
                    .addComponent(txtMailPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModPro)
                    .addComponent(btnAddPro))
                .addGap(18, 18, 18)
                .addComponent(btnDelPro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel5);

        etiOpera.setText("Operacion");

        comboOperaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insertar", "Modificar", "Eliminar" }));

        etiReg.setText("Tabla de registros");

        comboEntidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos", "Clientes", "Proveedores" }));

        tbBitProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbBitProduct);

        btnMostrarBitacora.setText("Mostrar");
        btnMostrarBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarBitacoraActionPerformed(evt);
            }
        });

        btnRespaldo.setText("Realizar Respaldo");
        btnRespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespaldoActionPerformed(evt);
            }
        });

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiReg)
                            .addComponent(etiOpera))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboEntidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboOperaciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMostrarBitacora, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(btnRespaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiOpera)
                    .addComponent(comboOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiReg)
                    .addComponent(comboEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnMostrarBitacora)
                .addGap(56, 56, 56)
                .addComponent(btnRespaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bitacora", jPanel6);

        btnGenReport.setText("Generar Reporte");
        btnGenReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenReportActionPerformed(evt);
            }
        });

        etiSelect.setText("Selecciona Tabla");

        tablaOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos", "Clientes", "Proveedores" }));

        jButton2.setText("Mostrar Tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbProduct1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbProduct1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(etiSelect)
                        .addGap(18, 18, 18)
                        .addComponent(tablaOp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(27, 27, 27)
                        .addComponent(btnGenReport)))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiSelect)
                    .addComponent(tablaOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnGenReport))
                .addContainerGap(445, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reportes", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarBitacoraActionPerformed
        String opEnt = comboEntidades.getSelectedItem().toString();
        String opOpera = comboOperaciones.getSelectedItem().toString();

        if (opEnt.equals("Productos")) {
            if (opOpera.equals("Insertar")) {
                DefaultTableModel mBitProduct = new DefaultTableModel();
                mBitProduct.addColumn("Id Bitacora");
                mBitProduct.addColumn("Id Producto");
                mBitProduct.addColumn("Codigo");
                mBitProduct.addColumn("Nombre");
                mBitProduct.addColumn("Descripcion");
                mBitProduct.addColumn("Precio");
                mBitProduct.addColumn("Usuario");
                mBitProduct.addColumn("Fecha");
                mBitProduct.addColumn("Accion");
                tbBitProduct.setModel(mBitProduct);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitProduct);
                String query = "SELECT * FROM bitacoraproducto WHERE accion=?";
                try {
                    String data[] = new String[9];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "INSERTAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        mBitProduct.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins BitPro:::" + e.toString());
                }
            }
            if (opOpera.equals("Modificar")) {
                DefaultTableModel mBitProduct = new DefaultTableModel();
                mBitProduct.addColumn("Id Bitacora");
                mBitProduct.addColumn("Id Producto");
                mBitProduct.addColumn("Codigo");
                mBitProduct.addColumn("Nombre");
                mBitProduct.addColumn("Descripcion");
                mBitProduct.addColumn("Precio");
                mBitProduct.addColumn("Usuario");
                mBitProduct.addColumn("Fecha");
                mBitProduct.addColumn("Accion");
                tbBitProduct.setModel(mBitProduct);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitProduct);
                String query = "SELECT * FROM bitacoraproducto WHERE accion=?";
                try {
                    String data[] = new String[9];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "MODIFICAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        mBitProduct.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error MOD BitPro:::" + e.toString());
                }

            }
            if (opOpera.equals("Eliminar")) {
                DefaultTableModel mBitProduct = new DefaultTableModel();
                mBitProduct.addColumn("Id Bitacora");
                mBitProduct.addColumn("Id Producto");
                mBitProduct.addColumn("Codigo");
                mBitProduct.addColumn("Nombre");
                mBitProduct.addColumn("Descripcion");
                mBitProduct.addColumn("Precio");
                mBitProduct.addColumn("Usuario");
                mBitProduct.addColumn("Fecha");
                mBitProduct.addColumn("Accion");
                tbBitProduct.setModel(mBitProduct);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitProduct);
                String query = "SELECT * FROM bitacoraproducto WHERE accion=?";
                try {
                    String data[] = new String[9];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "ELIMINAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        mBitProduct.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error DEL BitPro:::" + e.toString());
                }

            }
        }
        if (opEnt.equals("Clientes")) {
            if (opOpera.equals("Insertar")) {
                DefaultTableModel mBitClientes = new DefaultTableModel();
                mBitClientes.addColumn("Id Bitacora");
                mBitClientes.addColumn("Id Cliente");
                mBitClientes.addColumn("Codigo");
                mBitClientes.addColumn("Nombre");
                mBitClientes.addColumn("Direccion");
                mBitClientes.addColumn("Telefono");
                mBitClientes.addColumn("Mail");
                mBitClientes.addColumn("Usuario");
                mBitClientes.addColumn("Fecha");
                mBitClientes.addColumn("Accion");
                tbBitProduct.setModel(mBitClientes);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitClientes);
                String query = "SELECT * FROM bitacoracliente WHERE accion=?";
                try {
                    String data[] = new String[10];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "INSERTAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        data[9] = rs.getString(10);
                        mBitClientes.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins BitCliente:::" + e.toString());
                }
            }
            if (opOpera.equals("Modificar")) {
                DefaultTableModel mBitClientes = new DefaultTableModel();
                mBitClientes.addColumn("Id Bitacora");
                mBitClientes.addColumn("Id Cliente");
                mBitClientes.addColumn("Codigo");
                mBitClientes.addColumn("Nombre");
                mBitClientes.addColumn("Descripcion");
                mBitClientes.addColumn("Precio");
                mBitClientes.addColumn("Usuario");
                mBitClientes.addColumn("Fecha");
                mBitClientes.addColumn("Accion");
                tbBitProduct.setModel(mBitClientes);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitClientes);
                String query = "SELECT * FROM bitacoracliente WHERE accion=?";
                try {
                    String data[] = new String[10];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "ACTUALIZAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        data[9] = rs.getString(10);
                        mBitClientes.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins BitClientes:::" + e.toString());
                }
            }
            if (opOpera.equals("Eliminar")) {
                DefaultTableModel mBitClientes = new DefaultTableModel();
                mBitClientes.addColumn("Id Bitacora");
                mBitClientes.addColumn("Id Cliente");
                mBitClientes.addColumn("Codigo");
                mBitClientes.addColumn("Nombre");
                mBitClientes.addColumn("Descripcion");
                mBitClientes.addColumn("Precio");
                mBitClientes.addColumn("Usuario");
                mBitClientes.addColumn("Fecha");
                mBitClientes.addColumn("Accion");
                tbBitProduct.setModel(mBitClientes);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitClientes);
                String query = "SELECT * FROM bitacoracliente WHERE accion=?";
                try {
                    String data[] = new String[10];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "ELIMINAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        data[9] = rs.getString(10);
                        mBitClientes.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins BitPro:::" + e.toString());
                }

            }

        }
        if (opEnt.equals("Proveedores")) {
            if (opOpera.equals("Insertar")) {
                DefaultTableModel mBitClientes = new DefaultTableModel();
                mBitClientes.addColumn("Id Bitacora");
                mBitClientes.addColumn("Id Proveedor");
                mBitClientes.addColumn("Codigo");
                mBitClientes.addColumn("Nombre");
                mBitClientes.addColumn("Direccion");
                mBitClientes.addColumn("Telefono");
                mBitClientes.addColumn("Mail");
                mBitClientes.addColumn("Usuario");
                mBitClientes.addColumn("Fecha");
                mBitClientes.addColumn("Accion");
                tbBitProduct.setModel(mBitClientes);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitClientes);
                String query = "SELECT * FROM bitacoraproveedores WHERE accion=?";
                try {
                    String data[] = new String[10];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "INSERTAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        data[9] = rs.getString(10);
                        mBitClientes.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins Bitproveedores:::" + e.toString());
                }
            }
            if (opOpera.equals("Modificar")) {
                DefaultTableModel mBitClientes = new DefaultTableModel();
                mBitClientes.addColumn("Id Bitacora");
                mBitClientes.addColumn("Id Proveedor");
                mBitClientes.addColumn("Codigo");
                mBitClientes.addColumn("Nombre");
                mBitClientes.addColumn("Descripcion");
                mBitClientes.addColumn("Precio");
                mBitClientes.addColumn("Usuario");
                mBitClientes.addColumn("Fecha");
                mBitClientes.addColumn("Accion");
                tbBitProduct.setModel(mBitClientes);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitClientes);
                String query = "SELECT * FROM bitacoraproveedores WHERE accion=?";
                try {
                    String data[] = new String[10];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "ACTUALIZAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        data[9] = rs.getString(10);
                        mBitClientes.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins BitProveedores:::" + e.toString());
                }
            }
            if (opOpera.equals("Eliminar")) {
                DefaultTableModel mBitClientes = new DefaultTableModel();
                mBitClientes.addColumn("Id Bitacora");
                mBitClientes.addColumn("Id Proveedores");
                mBitClientes.addColumn("Codigo");
                mBitClientes.addColumn("Nombre");
                mBitClientes.addColumn("Descripcion");
                mBitClientes.addColumn("Precio");
                mBitClientes.addColumn("Usuario");
                mBitClientes.addColumn("Fecha");
                mBitClientes.addColumn("Accion");
                tbBitProduct.setModel(mBitClientes);
                tbBitProduct.getColumnModel().getColumn(0).setMaxWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setMinWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
                tbBitProduct.getColumnModel().getColumn(0).setResizable(false);
                tbBitProduct.setModel(mBitClientes);
                String query = "SELECT * FROM bitacoraproveedores WHERE accion=?";
                try {
                    String data[] = new String[10];
                    PreparedStatement ps = c.prepareStatement(query);
                    ps.setString(1, "ELIMINAR");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        data[0] = rs.getString(1);
                        data[1] = rs.getString(2);
                        data[2] = rs.getString(3);
                        data[3] = rs.getString(4);
                        data[4] = rs.getString(5);
                        data[5] = rs.getString(6);
                        data[6] = rs.getString(7);
                        data[7] = rs.getString(8);
                        data[8] = rs.getString(9);
                        data[9] = rs.getString(10);
                        mBitClientes.addRow(data);
                    }
                } catch (Exception e) {
                    System.out.println("Error Ins BitProveedores:::" + e.toString());
                }

            }
        }
    }//GEN-LAST:event_btnMostrarBitacoraActionPerformed

    private void txtCodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProActionPerformed

    private void tbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProMouseClicked
        txtIdPro.setText(tbPro.getValueAt(tbPro.getSelectedRow(), 0).toString());
        txtCodPro.setText(tbPro.getValueAt(tbPro.getSelectedRow(), 1).toString());
        txtNamePro.setText(tbPro.getValueAt(tbPro.getSelectedRow(), 2).toString());
        txtDirPro.setText(tbPro.getValueAt(tbPro.getSelectedRow(), 3).toString());
        txtTelPro.setText(tbPro.getValueAt(tbPro.getSelectedRow(), 4).toString());
        txtMailPro.setText(tbPro.getValueAt(tbPro.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbProMouseClicked

    private void btnDelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelProActionPerformed
        DefaultTableModel m = (DefaultTableModel) tbPro.getModel();
        String query = "DELETE FROM proveedores WHERE idproveedores = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtIdPro.getText());
            ps.executeUpdate();
            if (tbPro.getSelectedRow() != -1) {
                m.removeRow(tbPro.getSelectedRow());
                limpiarPro();
                JOptionPane.showMessageDialog(null, "Eliminado Correctamente!!");
                txtCodPro.grabFocus();
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.toString());
        }
    }//GEN-LAST:event_btnDelProActionPerformed

    private void btnAddProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProActionPerformed
        String query = "INSERT INTO proveedores VALUES(0,?,?,?,?,?)";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtCodPro.getText());
            ps.setString(2, txtNamePro.getText());
            ps.setString(3, txtDirPro.getText());
            ps.setString(4, txtTelPro.getText());
            ps.setString(5, txtMailPro.getText());
            ps.executeUpdate();
            limpiarPro();
            mostrarProveedores();
            JOptionPane.showMessageDialog(null, "Guardado Correctamente!");
            txtCodPro.grabFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }//GEN-LAST:event_btnAddProActionPerformed

    private void btnModProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProActionPerformed
        String query = "UPDATE proveedores SET codigo = ?, nombre = ?, direccion = ?, telefono = ?, mail = ? WHERE idproveedores = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtCodPro.getText());
            ps.setString(2, txtNamePro.getText());
            ps.setString(3, txtDirPro.getText());
            ps.setString(4, txtTelPro.getText());
            ps.setString(5, txtMailPro.getText());
            ps.setInt(6, Integer.parseInt(txtIdPro.getText()));
            ps.executeUpdate();
            mostrarProveedores();
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta!");
            limpiarPro();
            txtCodPro.grabFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.toString());
        }
    }//GEN-LAST:event_btnModProActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        txtIdC.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 0).toString());
        txtCodC.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 1).toString());
        txtNameC.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 2).toString());
        txtDirC.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 3).toString());
        txtTelC.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 4).toString());
        txtMailC.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbClientesMouseClicked

    private void btnDelCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelCActionPerformed
        DefaultTableModel m = (DefaultTableModel) tbClientes.getModel();
        String query = "DELETE FROM clientes WHERE idclientes = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtIdC.getText());
            ps.executeUpdate();
            if (tbClientes.getSelectedRow() != -1) {
                m.removeRow(tbClientes.getSelectedRow());
                limpiarC();
                JOptionPane.showMessageDialog(null, "Eliminado Correctamente!!");
                txtCodC.grabFocus();
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.toString());
        }
    }//GEN-LAST:event_btnDelCActionPerformed

    private void btnAddCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCActionPerformed
        String query = "INSERT INTO clientes VALUES(0,?,?,?,?,?)";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtCodC.getText());
            ps.setString(2, txtNameC.getText());
            ps.setString(3, txtDirC.getText());
            ps.setString(4, txtTelC.getText());
            ps.setString(5, txtMailC.getText());
            ps.executeUpdate();
            limpiarC();
            mostrarClientes();
            JOptionPane.showMessageDialog(null, "Guardado Correctamente!");
            txtCodC.grabFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }//GEN-LAST:event_btnAddCActionPerformed

    private void btnModCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCActionPerformed
        String query = "UPDATE clientes SET codigo = ?, nombre = ?, direccion = ?, telefono = ?, mail = ? WHERE idclientes = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtCodC.getText());
            ps.setString(2, txtNameC.getText());
            ps.setString(3, txtDirC.getText());
            ps.setString(4, txtTelC.getText());
            ps.setString(5, txtMailC.getText());
            ps.setInt(6, Integer.parseInt(txtIdC.getText()));
            ps.executeUpdate();
            mostrarClientes();
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta!");
            limpiarC();
            txtCodC.grabFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.toString());
        }
    }//GEN-LAST:event_btnModCActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        DefaultTableModel m = (DefaultTableModel) tbProduct.getModel();
        String query = "DELETE FROM productos WHERE idproductos = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtId.getText());
            ps.executeUpdate();
            if (tbProduct.getSelectedRow() != -1) {
                m.removeRow(tbProduct.getSelectedRow());
                limpiar();
                JOptionPane.showMessageDialog(null, "Eliminado Correctamente!!");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.toString());
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        String query = "UPDATE productos SET codigo = ?, nombre = ?, descripcion = ?, precio = ? WHERE idproductos = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtCod.getText());
            ps.setString(2, txtName.getText());
            ps.setString(3, txtDes.getText());
            ps.setString(4, txtPre.getText());
            ps.setInt(5, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            mostrarProduct();
            JOptionPane.showMessageDialog(null, "Actualizacion Correcta!");
            limpiar();
            txtCod.grabFocus();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.toString());
        }
    }//GEN-LAST:event_btnModActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        txtId.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString());
        txtCod.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 1).toString());
        txtName.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 2).toString());
        txtDes.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 3).toString());
        txtPre.setText(tbProduct.getValueAt(tbProduct.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String query = "INSERT INTO productos VALUES(0,?,?,?,?)";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, txtCod.getText());
            ps.setString(2, txtName.getText());
            ps.setString(3, txtDes.getText());
            ps.setString(4, txtPre.getText());
            ps.executeUpdate();
            limpiar();
            mostrarProduct();
            JOptionPane.showMessageDialog(null, "Guardado Correctamente!");
            txtCod.grabFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldoActionPerformed
        crearRespaldo();
    }//GEN-LAST:event_btnRespaldoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String dir = "C:\\Users\\Pro\\Documents\\NetBeansProjects\\SysDb\\src\\Reports\\clientes.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(dir);
            JasperPrint mostrar = JasperFillManager.fillReport(reporte, null, this.c);

            JasperViewer.viewReport(mostrar, false);
        } catch (Exception e) {
            System.out.println("Error de Reporte::::" + e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String op = tablaOp.getSelectedItem().toString();
        String query = "SELECT * FROM " + op;
        if (op.equalsIgnoreCase("productos")) {
            DefaultTableModel m = new DefaultTableModel();
            m.addColumn("Id");
            m.addColumn("Codigo");
            m.addColumn("Nombre");
            m.addColumn("Descripcion");
            m.addColumn("Precio");
            tbProduct1.setModel(m);
            tbProduct1.getColumnModel().getColumn(0).setMaxWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setMinWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setResizable(false);
            try {
                String data[] = new String[5];
                ResultSet rs = null;
                Statement st = c.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    data[0] = rs.getString(1);
                    data[1] = rs.getString(2);
                    data[2] = rs.getString(3);
                    data[3] = rs.getString(4);
                    data[4] = rs.getString(5);
                    m.addRow(data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            }
        } else if (op.equalsIgnoreCase("clientes")) {
            DefaultTableModel mC = new DefaultTableModel();
            mC.addColumn("Id");
            mC.addColumn("Codigo");
            mC.addColumn("Nombre");
            mC.addColumn("Direccion");
            mC.addColumn("Telefono");
            mC.addColumn("Mail");
            tbProduct1.setModel(mC);
            tbProduct1.getColumnModel().getColumn(0).setMaxWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setMinWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setResizable(false);
            try {
                String data[] = new String[6];
                ResultSet rs = null;

                Statement st = c.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    data[0] = rs.getString(1);
                    data[1] = rs.getString(2);
                    data[2] = rs.getString(3);
                    data[3] = rs.getString(4);
                    data[4] = rs.getString(5);
                    data[5] = rs.getString(6);
                    mC.addRow(data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            }

        } else if (op.equalsIgnoreCase("proveedores")) {
            DefaultTableModel mC = new DefaultTableModel();
            mC.addColumn("Id");
            mC.addColumn("Codigo");
            mC.addColumn("Nombre");
            mC.addColumn("Direccion");
            mC.addColumn("Telefono");
            mC.addColumn("Mail");
            tbProduct1.setModel(mC);
            tbProduct1.getColumnModel().getColumn(0).setMaxWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setMinWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbProduct1.getColumnModel().getColumn(0).setResizable(false);
            try {
                String data[] = new String[6];
                ResultSet rs = null;

                Statement st = c.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    data[0] = rs.getString(1);
                    data[1] = rs.getString(2);
                    data[2] = rs.getString(3);
                    data[3] = rs.getString(4);
                    data[4] = rs.getString(5);
                    data[5] = rs.getString(6);
                    mC.addRow(data);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGenReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenReportActionPerformed
        String file = (tablaOp.getSelectedItem().toString().toLowerCase())+".jrxml";
        try {

            String dir = "C:\\Users\\Pro\\Documents\\NetBeansProjects\\SysDb\\src\\Reports\\"+file;
            JasperReport reporte = JasperCompileManager.compileReport(dir);
            JasperPrint mostrar = JasperFillManager.fillReport(reporte, null, this.c);
            JasperViewer.viewReport(mostrar, false);
        } catch (Exception e) {
            System.out.println("Error de Reporte::::" + e.toString());
        }
    }//GEN-LAST:event_btnGenReportActionPerformed

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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddC;
    private javax.swing.JButton btnAddPro;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDelC;
    private javax.swing.JButton btnDelPro;
    private javax.swing.JButton btnGenReport;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnModC;
    private javax.swing.JButton btnModPro;
    private javax.swing.JButton btnMostrarBitacora;
    private javax.swing.JButton btnRespaldo;
    private javax.swing.JComboBox<String> comboEntidades;
    private javax.swing.JComboBox<String> comboOperaciones;
    private javax.swing.JLabel etiCod;
    private javax.swing.JLabel etiCodC;
    private javax.swing.JLabel etiCodPro;
    private javax.swing.JLabel etiDes;
    private javax.swing.JLabel etiDirC;
    private javax.swing.JLabel etiDirPro;
    private javax.swing.JLabel etiMailC;
    private javax.swing.JLabel etiMailPro;
    private javax.swing.JLabel etiName;
    private javax.swing.JLabel etiNameC;
    private javax.swing.JLabel etiNamePro;
    private javax.swing.JLabel etiOpera;
    private javax.swing.JLabel etiPre;
    private javax.swing.JLabel etiReg;
    private javax.swing.JLabel etiSelect;
    private javax.swing.JLabel etiTelC;
    private javax.swing.JLabel etiTelPro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> tablaOp;
    private javax.swing.JTable tbBitProduct;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbPro;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTable tbProduct1;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCodC;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtDirC;
    private javax.swing.JTextField txtDirPro;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdC;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtMailC;
    private javax.swing.JTextField txtMailPro;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameC;
    private javax.swing.JTextField txtNamePro;
    private javax.swing.JTextField txtPre;
    private javax.swing.JTextField txtTelC;
    private javax.swing.JTextField txtTelPro;
    // End of variables declaration//GEN-END:variables
}
