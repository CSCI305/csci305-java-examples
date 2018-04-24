/*
 * Created by JFormDesigner on Mon Apr 23 04:05:11 MDT 2018
 */

package concurrent.prodcons;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

/**
 * @author Isaac Griffith
 */
public class ProdConVis extends JFrame {

    private AtomicInteger[][] pc = new AtomicInteger[2][2];
    private ProducerConsumer prodCon;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            ProdConVis inst = ProdConVis.getInstance();
            inst.setVisible(true);
        });
    }

    public static ProdConVis getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        public static final ProdConVis INSTANCE = new ProdConVis();
    }

    private ProdConVis() {
        prodCon = new ProducerConsumer();
        initComponents();
        reset();
    }

    private void reset() {
        labelPC11.setText("0");
        labelPC12.setText("0");
        labelPC21.setText("0");
        labelPC22.setText("0");
        tfProd2.setText("10");
        tfProd1.setText("10");
        tfCons1.setText("10");
        tfCons2.setText("10");
        tfThreads.setText("3");
        pc[0][0] = new AtomicInteger();
        pc[0][1] = new AtomicInteger();
        pc[1][0] = new AtomicInteger();
        pc[1][1] = new AtomicInteger();
    }

    private void resetActionPerformed(ActionEvent e) {
        reset();
    }

    private void startActionPerformed(ActionEvent e) {
        SwingWorker worker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {
                prodCon.process(Integer.parseInt(tfThreads.getText()), Integer.parseInt(tfProd1.getText()),
                        Integer.parseInt(tfProd2.getText()), Integer.parseInt(tfCons1.getText()), Integer.parseInt(tfCons2.getText()));

                return 1;
            }
        };
        worker.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label5 = new JLabel();
        label6 = new JLabel();
        label2 = new JLabel();
        labelPC11 = new JLabel();
        labelPC12 = new JLabel();
        tfProd1 = new JTextField();
        label3 = new JLabel();
        labelPC21 = new JLabel();
        labelPC22 = new JLabel();
        tfProd2 = new JTextField();
        tfCons1 = new JTextField();
        tfCons2 = new JTextField();
        label8 = new JLabel();
        tfThreads = new JTextField();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setTitle("Producer Consumer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label5 ----
        label5.setText("Consumer 1");
        contentPane.add(label5, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- label6 ----
        label6.setText("Consumer 2:");
        contentPane.add(label6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("Prod 1:");
        contentPane.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- labelPC11 ----
        labelPC11.setText("text");
        labelPC11.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelPC11.setForeground(new Color(102, 153, 255));
        contentPane.add(labelPC11, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- labelPC12 ----
        labelPC12.setText("text");
        labelPC12.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelPC12.setForeground(new Color(102, 153, 255));
        contentPane.add(labelPC12, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(tfProd1, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        //---- label3 ----
        label3.setText("Prod 2:");
        contentPane.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- labelPC21 ----
        labelPC21.setText("text");
        labelPC21.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelPC21.setForeground(new Color(255, 102, 102));
        contentPane.add(labelPC21, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- labelPC22 ----
        labelPC22.setText("text");
        labelPC22.setFont(new Font("Roboto", Font.PLAIN, 20));
        labelPC22.setForeground(new Color(255, 102, 102));
        contentPane.add(labelPC22, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(tfProd2, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(tfCons1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(tfCons2, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- label8 ----
        label8.setText("Threads:");
        contentPane.add(label8, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        contentPane.add(tfThreads, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- button2 ----
        button2.setText("Reset");
        button2.addActionListener(e -> resetActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- button1 ----
        button1.setText("Start");
        button1.addActionListener(e -> startActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label5;
    private JLabel label6;
    private JLabel label2;
    private JLabel labelPC11;
    private JLabel labelPC12;
    private JTextField tfProd1;
    private JLabel label3;
    private JLabel labelPC21;
    private JLabel labelPC22;
    private JTextField tfProd2;
    private JTextField tfCons1;
    private JTextField tfCons2;
    private JLabel label8;
    private JTextField tfThreads;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public synchronized void update(String element, String con) {
        String prod = element.split("-")[1];
        int c = Integer.parseInt(con);
        int p = Integer.parseInt(prod);

        updateLabel(p, c, pc[p - 1][c - 1].incrementAndGet());
    }

    private void updateLabel(int p, int c, int i) {
        if (p == 1) {
            if (c == 1) {
                labelPC11.setText(Integer.toString(i));
            } else {
                labelPC12.setText(Integer.toString(i));
            }
        } else {
            if (c == 1) {
                labelPC21.setText(Integer.toString(i));
            } else {
                labelPC22.setText(Integer.toString(i));
            }
        }
    }
}
