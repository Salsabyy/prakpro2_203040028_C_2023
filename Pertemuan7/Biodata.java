package Pertemuan7;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Salsabila Firdausi
 */

public class Biodata extends JFrame{
    
    public Biodata() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);

                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        JLabel labelInputNama = new JLabel("Input Nama:");
        labelInputNama.setBounds(15, 40, 350, 15);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 65, 350, 30);

        JLabel labelInputNotelp = new JLabel("Input NoTelp:");
        labelInputNotelp.setBounds(15, 100, 350, 15);
        JTextField textFieldNotelp = new JTextField();
        textFieldNotelp.setBounds(15, 125, 350, 30);
        
        JLabel labelInputJenisKelamin = new JLabel("Jenis Kelamin:");
        labelInputJenisKelamin.setBounds(15, 150, 350, 45);
        
        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true);
        radioButtonL.setBounds(15, 175, 350, 30);

        JRadioButton radioButtonP = new JRadioButton("Perempuan");
        radioButtonP.setBounds(15, 200, 350, 30);

        JLabel labelInputAlamat = new JLabel("Input Alamat:");
        labelInputAlamat.setBounds(15, 225, 350, 30);
        JTextField textFieldAlamat = new JTextField();
        textFieldAlamat.setBounds(15, 255, 350, 70);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 330, 100, 40);
        
        JButton button1 = new JButton("Edit");
        button1.setBounds(120, 330, 100, 40);

        JButton button2 = new JButton("Hapus");
        button2.setBounds(225, 330, 100, 40);
        
        JButton button3 = new JButton("Simpan Ke File");
        button3.setBounds(330, 330, 125, 40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 380, 500, 200);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);

        BiodataTableModel tableModel = new BiodataTableModel();
        table.setModel(tableModel);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String alamat = textFieldAlamat.getText();
                String jenisKelamin = "";

                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }

                if (nama.trim().isEmpty() || noTelp.trim().isEmpty() || alamat.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Form tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                            "Masukan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, noTelp, alamat, jenisKelamin)));
                        textFieldNama.setText("");
                        textFieldNotelp.setText("");
                        textFieldAlamat.setText("");
                    } else {
                        JOptionPane.showMessageDialog(Biodata.this, "Anda tidak memasukan data");
                    }
                }
            }

        });
       
        
     button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String nama = textFieldNama.getText();
            String noTelp = textFieldNotelp.getText();
            String alamat = textFieldAlamat.getText();
            String jenisKelamin = "";

            if (radioButtonL.isSelected()) {
                jenisKelamin = radioButtonL.getText();
            }
            if (radioButtonP.isSelected()) {
                jenisKelamin = radioButtonP.getText();
            }

            if (nama.trim().isEmpty() || noTelp.trim().isEmpty() || alamat.trim().isEmpty()) {
                JOptionPane.showMessageDialog(Biodata.this, "Form tidak boleh ada yang kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this, "Edit Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    tableModel.setValueAt(nama, selectedRow, 0);
                    tableModel.setValueAt(noTelp, selectedRow, 1);
                    tableModel.setValueAt(alamat, selectedRow, 2);
                    tableModel.setValueAt(jenisKelamin, selectedRow, 3);
                    textFieldNama.setText("");
                    textFieldNotelp.setText("");
                    textFieldAlamat.setText("");
                }
            }
        }
    }
});

    button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int confirmation = JOptionPane.showConfirmDialog(Biodata.this, "Hapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                textFieldNama.setText("");
                textFieldNotelp.setText("");
                textFieldAlamat.setText("");
            }
        }
    }
});


        this.add(button);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputNotelp);
        this.add(textFieldNotelp);
        this.add(labelInputJenisKelamin);
        this.add(labelInputAlamat);
        this.add(textFieldAlamat);
        this.add(radioButtonL);
        this.add(radioButtonP);
        this.add(scrollableTable);

        this.setSize(700, 700);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata b = new Biodata();
                b.setVisible(true);
            }
  });
    }
}