
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Insercion extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("0.00");
    public String nombre, cedula;
    public double monto, anualidad, interesperiodico, acapital, ainteres, efectivo, nominal;
    public int periodo, gracia, cuotas, n;
    Calendar calendar = Calendar.getInstance();
    Date fecha = calendar.getTime();
    String[][] tabla;
    int vpg = 0;

    public Double ipanual(double i, double periodo) {
        double a = 1 + (i / 100);
        double b = (360 / periodo) / 360;
        interesperiodico = (Math.pow(a, b) - 1);
        return interesperiodico * 100;
    }

    public Double nominal(double i, double periodo) {
        return i * periodo;
    }

    public Double ipnominal(double i, double periodo) {
        interesperiodico = (i / periodo) / 100;
        return interesperiodico * 100;
    }

    public Double anual(double i, double periodo) {
        double a = 1 + (i / 100);
        double b = 360 / (360 / periodo);

        return 100 * (Math.pow(a, b) - 1);
    }

    public int periodos(String vencido) {
        if (vencido.equals("Mensual")) {
            periodo = 12;
        }
        if (vencido.equals("Bimestral")) {
            periodo = 6;
        }
        if (vencido.equals("Trimestral")) {
            periodo = 4;
        }
        if (vencido.equals("Semestral")) {
            periodo = 2;
        }
        return periodo;
    }

    public void datos(int pg, int cuo, double mon) {
        gracia = pg * periodo;
        cuotas = cuo * periodo;
        n = cuotas - gracia;
        monto = mon;
        ainteres = monto * (interesperiodico);
    }

    public void anualidad() {
        double mi = 1 + interesperiodico;
        anualidad = monto * (((Math.pow(mi, n)) * interesperiodico) / ((Math.pow(mi, n)) - 1));
    }

    public Insercion() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icno.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tnombre = new javax.swing.JTextField();
        tcedula = new javax.swing.JTextField();
        tmonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tna = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        convertirefe = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pdf = new javax.swing.JButton();
        pergracia = new javax.swing.JCheckBox();
        cbpg = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbaños = new javax.swing.JComboBox<>();
        exit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbperiodo = new javax.swing.JComboBox<>();
        creditos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel2.setText("Cedula");

        jLabel3.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel3.setText("Monto  cop");

        jLabel4.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel4.setText("Efectivo Anual");

        jLabel5.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel5.setText("Nominal Anual");

        jLabel6.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel6.setText("Interes Periodico");

        jLabel7.setText("%");

        jLabel8.setText("%");

        jLabel9.setText("%");

        convertirefe.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        convertirefe.setText("Convertir Tasas");
        convertirefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertirefeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel10.setText("Periodo ");

        pdf.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        pdf.setText("Siguiente");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        pergracia.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        pergracia.setText("Periodo de Gracia");
        pergracia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pergraciaMouseClicked(evt);
            }
        });
        pergracia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pergraciaActionPerformed(evt);
            }
        });

        cbpg.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        cbpg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jLabel11.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        jLabel11.setText("Ano");

        cbaños.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        cbaños.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "6", "7", "8", "9", "10" }));

        exit.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("SIMULADOR DE CREDITO BANCO MINUTERO");

        cbperiodo.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        cbperiodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mensual", "Bimestral", "Trimestral ", "Semestral", " " }));

        creditos.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        creditos.setText("Creditos");
        creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbaños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(pergracia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbpg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tnombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tmonto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcedula))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tna, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tip))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tfa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(convertirefe, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(creditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(convertirefe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pdf)
                        .addGap(3, 3, 3)
                        .addComponent(creditos)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cbperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(tfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pergracia)
                        .addComponent(cbpg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(cbaños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(exit)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convertirefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertirefeActionPerformed
        int periodos = periodos((String) cbperiodo.getSelectedItem());

        if (tfa.getText().compareTo("") == 0) {
            double p = ipnominal(Double.parseDouble(tna.getText()), periodos);

            efectivo = anual(p, periodos);
            nominal = nominal(p, periodos);
            tfa.setText(df.format(efectivo));
        } else {
            double p = ipanual(Double.parseDouble(tfa.getText()), periodos);

            nominal = nominal(p, periodos);
            efectivo = anual(p, periodos);
            tna.setText(df.format(nominal));
        }

        int cuotas = Integer.parseInt((String) cbaños.getSelectedItem());
        int pe = periodos((String) cbperiodo.getSelectedItem());
        int pg = 0;

        if (vpg == 1) {
            pg = Integer.parseInt((String) cbpg.getSelectedItem());
        }

        datos(pg, cuotas, Double.parseDouble(tmonto.getText()));
        anualidad();
        tip.setText(df.format(interesperiodico*100));
        
        nombre = tnombre.getText();
        cedula = tcedula.getText();
        
    }//GEN-LAST:event_convertirefeActionPerformed


    private void pergraciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pergraciaActionPerformed

    }//GEN-LAST:event_pergraciaActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        dispose();
        tabla t = new tabla();
        t.setVisible(true);
        t.asignar(nombre, cedula, cbperiodo.getSelectedItem().toString(), monto,
                anualidad, interesperiodico, acapital, ainteres, df.format(efectivo), df.format(nominal),
                this.cuotas, gracia, cbaños.getSelectedItem().toString(), cbpg.getSelectedItem().toString(), 12 / periodo);
    }//GEN-LAST:event_pdfActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void pergraciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pergraciaMouseClicked
        vpg = 1;
        System.out.println("hay pg");
    }//GEN-LAST:event_pergraciaMouseClicked

    private void creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosActionPerformed
        JOptionPane.showMessageDialog(null, "Presentado por David Benitez - 375881");
    }//GEN-LAST:event_creditosActionPerformed

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
            java.util.logging.Logger.getLogger(Insercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insercion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insercion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbaños;
    private javax.swing.JComboBox<String> cbperiodo;
    private javax.swing.JComboBox<String> cbpg;
    private javax.swing.JButton convertirefe;
    private javax.swing.JButton creditos;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton pdf;
    private javax.swing.JCheckBox pergracia;
    private javax.swing.JTextField tcedula;
    private javax.swing.JTextField tfa;
    private javax.swing.JTextField tip;
    private javax.swing.JTextField tmonto;
    private javax.swing.JTextField tna;
    private javax.swing.JTextField tnombre;
    // End of variables declaration//GEN-END:variables
}
