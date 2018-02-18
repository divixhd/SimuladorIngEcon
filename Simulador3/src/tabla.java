
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class tabla extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("0.00");

    public String nombre, cedula, periodovencido, plazo, años, anual, nominal, graciastring, interesperiodicostring, montostring;
    public double monto, anualidad, interesperiodico, acapital, ainteres;
    public int periodo, gracia, cuotas, n;
    String[][] tabla;

    Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
    Calendar cal = new GregorianCalendar();


    public void asignar(String nombre, String cedula, String periodovencido, double monto,
            double anualidad, double interesperiodico, double acapital,
            double ainteres, String anual, String nominal, int cuotas, int gracia, String años, String graciastring, int periodo) {

        this.nombre = nombre;
        this.cedula = cedula;
        this.periodovencido = periodovencido;
        this.monto = monto;
        this.anualidad = anualidad;
        this.interesperiodico = interesperiodico;
        this.acapital = acapital;
        this.ainteres = ainteres;
        this.anual = anual;
        this.nominal = nominal;
        this.cuotas = cuotas;
        this.gracia = gracia;
        this.años = años;
        this.graciastring = graciastring;
        this.periodo = periodo;
        interesperiodicostring = df.format(interesperiodico * 100);
        montostring = df.format(monto);
    }

    public String ahora() {

        return (formateador.format(ahora));
    }

    public String fecha(int meses) {

        cal.setTimeInMillis(ahora.getTime());
        cal.add(Calendar.MONTH, meses);
        return (formateador.format(cal.getTime()));
    }

    public void iniciartabla() {
        tabla = new String[cuotas + 1][7];
        System.out.println("cuotas tabla interfaz" + cuotas);
        tabla[0][0] = "" + 0;
        tabla[0][1] = "" + ahora();
        tabla[0][2] = "$ " +df.format(monto);
        tabla[0][3] = "----------";
        tabla[0][4] = "----------";
        tabla[0][5] = "----------";
        tabla[0][6] = "$ " +df.format(monto);

        for (int i = 1; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                tabla[i][j] = "---------";
            }

        }
    }

    public void tabla() {
        System.out.println("este es la gracia de la tabla +++ " + gracia);

        for (int i = 1; i <= cuotas; i++) {

            if (i <= gracia) {
                tabla[i][0] = "" + i;

                tabla[i][1] = fecha(periodo * i);
                tabla[i][2] = "$ " + df.format(monto);
                tabla[i][3] = "----------";
                tabla[i][4] = "$ " + df.format(ainteres);
                tabla[i][5] = "----------";
                tabla[i][6] = "-$ " + df.format(ainteres);

            } else {
                tabla[i][0] = "" + i;

                tabla[i][1] = fecha(periodo * i);

                ainteres = monto * interesperiodico;
                acapital = anualidad - ainteres;
                monto = monto - acapital;

                tabla[i][2] = "$ " + df.format(monto);
                tabla[i][3] = "$ " + df.format(acapital);
                tabla[i][4] = "$ " + df.format(ainteres);
                tabla[i][5] = "$ " + df.format(anualidad);
                tabla[i][6] = "-$ " + df.format(anualidad);
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                System.out.print(tabla[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public tabla() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icno.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("SIMULADOR DE CREDITO BANCO MINUTERO");

        TablaDatos.setFont(new java.awt.Font("Bebas", 0, 11)); // NOI18N
        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cuota #", "Fecha", "Saldo Capital", "Am. Capital", "Am. Intereses", "Cuota Fija", "Flujo de Caja"
            }
        ));
        jScrollPane1.setViewportView(TablaDatos);

        jButton1.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        jButton1.setText("Enviar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        jButton2.setText("Enviar a Tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N
        Back.setText("Atras");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bebas", 0, 18)); // NOI18N
        jLabel1.setText("CUADRO DE AMORTIZACION CUOTAS FIJAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(Back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String[] columna = {"Cuota", "Fecha", "Saldo capital", "Amortizacion capital", "Amortizacion intereses", "Cuota fija", "Flujo de caja"};
        iniciartabla();
        tabla();
        DefaultTableModel dtm = new DefaultTableModel(null, columna);
        for (int i = 0; i < cuotas + 1; i++) {
            String[] fila = {tabla[i][0], tabla[i][1], tabla[i][2], tabla[i][3], tabla[i][4], tabla[i][5], tabla[i][6]};
            dtm.addRow(fila);
        }

        TablaDatos.setModel(dtm);
        TablaDatos.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(nombre +".pdf"));
            JOptionPane.showMessageDialog(null, "El Reporte con PDF ha Sido Creado con Exito");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.open();
        try {
            
            doc.add(new Paragraph("Cliente: " + nombre, FontFactory.getFont(FontFactory.HELVETICA, 7)));
            doc.add(new Paragraph("Numero de documento: " + cedula, FontFactory.getFont(FontFactory.HELVETICA, 7)));
            doc.add(new Paragraph("Valor del credito: $" + montostring, FontFactory.getFont(FontFactory.HELVETICA, 7)));
            doc.add(new Paragraph("Plazo: " + años + " años", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            doc.add(new Paragraph("Periodo de gracia: " + graciastring + " años", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            doc.add(new Paragraph("Periodo: " + periodovencido, FontFactory.getFont(FontFactory.HELVETICA, 7)));
            
           

            PdfPTable table = new PdfPTable(7);

            PdfPCell cell = new PdfPCell(new Paragraph("Cuota #", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Saldo capital", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Amortizacion capital", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Amortiacion intereses", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Cuota fija", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Flujo de caja", FontFactory.getFont(FontFactory.HELVETICA, 7)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            for (int i = 1; i < tabla.length; i++) {
                for (int j = 0; j < tabla[0].length; j++) {
                    cell = new PdfPCell(new Paragraph(tabla[i][j], FontFactory.getFont(FontFactory.HELVETICA, 7)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                }
            }

            doc.add(table);

        } catch (DocumentException ex) {
            Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Insercion spg=new Insercion();
        spg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTable TablaDatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
