package Tema6;

import javax.swing.JOptionPane;
import org.nfunk.jep.ParseException;

/**
 *
 * @author mig
 */
public class Metodos extends javax.swing.JFrame {

  private double[] f;
  private Funcion fun;
  public Metodos() {
    initComponents();
    setLocationRelativeTo(null);
    metodo.removeAllItems();
    metodo.addItem("Método de Euler");
    metodo.addItem("Método de Taylor");
    metodo.addItem("Método de Runge-Kutta");
    fx.requestFocus();
  }
  
public String euler(int a, double h) throws ParseException{
  String re="";
  for (int i = 0; i < f.length-1; i++) {
    double x = a + (i*h);
    f[i+1] = fun.Redondear(f[i] + h*(fun.Evaluar(x, f[i])));
    re += (String.format("Iteración # %d:\nX = %.4f\nW = %.4f", i, x, f[i]));
    if (i < f.length-2) {
      re +="\n\n";
    }
  }
  return re + "/nEquipo:" + "\n" + "\nMiguel Angel Cupul Osorio         18070011"
                          + "\nWilbert Jesus del Valle Sierra         18070043";
}


public int fact(int n){
  int ret=1;
  for (int i = 2; i <= n; i++)
    ret *= n;
  return ret;
}


public String reemplazar(String ori, String cambio, String reem){
  while(ori.indexOf(cambio) != -1){
    ori = ori.replace(cambio, reem);
  }
  return ori;
}


public String t(int n, double h){
  String ret="";
  String der = fun.getF();
  for (int i = 0; i < n; i++) {
    if(i != 0){
      String der1 = JOptionPane.showInputDialog(null, "Ingrese la derivada de "+der+":",der);
      der = reemplazar(der1, "'diff(y,x,1)", fun.getF());
    }
    if(i != n-1)
      ret += String.format("(%.4f)(%s) + ", (i!=0 ? fun.Redondear(h/fact(i+1)) : 1.0), der);
    else
      ret += String.format("(%.4f)(%s)", (i!=0 ? fun.Redondear(h/fact(i+1)) : 1.0), der);
  }
  return ret;
}


public String taylor(int a, double h, int n) throws ParseException{
  String re="";
  String t = t(n,h);
  fun.setF(t);
  for (int i = 0; i < f.length-1; i++) {
    if(i!=0){
      double x = a + ((i-1)*h);
      double xi = a + (i*h);
      f[i] = fun.Redondear(f[i-1] + h*fun.Evaluar(x, f[i-1]));
      re += String.format("Iteración # %d:\nX = %.4f\nW = %.4f", i,xi,f[i]);
    }else
      re += String.format("Iteración # 0:\nX = %d\nW = %.4f", a, f[i]);
    if (i < f.length-2) {
      re +="\n\n";
    }
  }
  return re;
}


public String runge(int a, double h) throws ParseException{
  String re="";
  for (int i = 0; i < f.length-1; i++) {
    if(i!=0){
      double x = a + ((i-1)*h);
      double xi = a + (i*h);
      double k1=fun.Redondear(h*fun.Evaluar(x, f[i-1]));
      double k2=fun.Redondear(h*fun.Evaluar((x+(h/2)), f[i-1]+(k1/2)));
      double k3=fun.Redondear(h*fun.Evaluar(x+(h/2), f[i-1]+(k2/2)));
      double k4=fun.Redondear(h*fun.Evaluar(xi, f[i-1]+k3));
      f[i] = fun.Redondear(f[i-1] + (k1+(2*k2)+(2*k3)+k4)/6);
      re += String.format("Iteración # %d:\nK1 = %.4f\nK2 = %.4f\nK3 = %.4f\nK4 = %.4f\nX = %.4f\nW = %.4f", i,k1,k2,k3,k4,xi,f[i]);
    }else
      re += String.format("Iteración # 0:\nK1 = ---\nK2 = ---\nK3 = ---\nK4 = ---\nX = %d\nW = %.4f", a, f[i]);
    if (i < f.length-2) {
      re +="\n\n";
    }
  }
  return re;
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
        metodo = new javax.swing.JComboBox();
        B = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        A = new javax.swing.JSpinner();
        fx = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        n = new javax.swing.JSpinner();
        lblin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        condicion = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        res = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        metodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        metodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        metodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                metodoItemStateChanged(evt);
            }
        });
        metodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                metodoFocusLost(evt);
            }
        });
        metodo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                metodoCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        metodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoActionPerformed(evt);
            }
        });
        metodo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                metodoPropertyChange(evt);
            }
        });
        metodo.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                metodoVetoableChange(evt);
            }
        });

        B.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        B.setNextFocusableComponent(n);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("≤ x ≤");

        A.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        A.setNextFocusableComponent(B);

        fx.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fx.setNextFocusableComponent(A);
        fx.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fxFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Función a Integrar");

        n.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        n.setNextFocusableComponent(condicion);

        lblin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblin.setText("N");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Y(a)");

        condicion.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        condicion.setNextFocusableComponent(aceptar);

        aceptar.setBackground(new java.awt.Color(255, 255, 255));
        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema6/calculadora (1).png"))); // NOI18N
        aceptar.setText("Calcular");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema6/actualizar.png"))); // NOI18N
        limpiar.setText("Limpiar Campos");
        limpiar.setToolTipText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(metodo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(aceptar)
                        .addGap(43, 43, 43)
                        .addComponent(limpiar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblin)
                                .addGap(4, 4, 4)
                                .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(condicion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fx, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(metodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(A)
                    .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(n)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblin)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(condicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(limpiar))
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 410));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jScrollPane1.setEnabled(false);

        res.setEditable(false);
        res.setColumns(20);
        res.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        res.setRows(5);
        res.setFocusable(false);
        jScrollPane1.setViewportView(res);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tema6/salida (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 420, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void metodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_metodoItemStateChanged

  }//GEN-LAST:event_metodoItemStateChanged

  private void metodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoActionPerformed

 }//GEN-LAST:event_metodoActionPerformed

  private void metodoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_metodoFocusLost

 }//GEN-LAST:event_metodoFocusLost

  private void metodoCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_metodoCaretPositionChanged

 }//GEN-LAST:event_metodoCaretPositionChanged

  private void metodoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_metodoPropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_metodoPropertyChange

  private void metodoVetoableChange(java.beans.PropertyChangeEvent evt) throws java.beans.PropertyVetoException {//GEN-FIRST:event_metodoVetoableChange

 }//GEN-LAST:event_metodoVetoableChange

  private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
    n.setValue(0);
    A.setValue(0);
    B.setValue(0);
    res.setText(null);
    fx.setText(null);
    fx.requestFocus();
  }//GEN-LAST:event_limpiarActionPerformed

  private void fxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fxFocusGained

 }//GEN-LAST:event_fxFocusGained

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
         f = new double[Integer.parseInt(n.getValue().toString()) + 2];
    double h = (Double.parseDouble(B.getValue().toString()) - Double.parseDouble(A.getValue().toString())) / Double.parseDouble(n.getValue().toString());
    fun = new Funcion(fx.getText());
    String msg = "";
    int a = Integer.parseInt(A.getValue().toString());
    f[0] = Double.parseDouble(condicion.getText().toString());
    String re="";
    boolean correcto = true;
    
    switch(metodo.getSelectedIndex()){
      case 0:
        try {
          re = euler(a, h);
        } catch (ParseException ex) {
          msg = "Función Incorrecta";
          correcto = false;
        }
        break;
        
      case 1:
        try {
          int nu = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Orden", 2));
          re = taylor(a, h, nu);
        } catch (ParseException ex) {
          msg = "Función Incorrecta";
          correcto = false;
        }
        break;
        
      case 2:
        try {
          re = runge(a,h);
        } catch (ParseException ex) {
          msg = "Función Incorrecta";
          correcto = false;
        }
        break;
    }
    if(correcto)
      res.setText(re);
    else
      JOptionPane.showMessageDialog(null, msg, "Error", 0);
    fx.requestFocus();
    }//GEN-LAST:event_aceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /*
     * Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the
     * default look and feel. For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Metodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Metodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Metodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Metodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /*
     * Create and display the form
     */
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new Metodos().setVisible(true);
      }
    });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner A;
    private javax.swing.JSpinner B;
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField condicion;
    private javax.swing.JTextField fx;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblin;
    private javax.swing.JButton limpiar;
    private javax.swing.JComboBox metodo;
    private javax.swing.JSpinner n;
    private javax.swing.JTextArea res;
    // End of variables declaration//GEN-END:variables
}
