/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Input extends JFrame{
    public String namaB, massaB, hargaB;
    Connector connector = new Connector();
    
    
    JLabel lInputB = new JLabel("Input Barang");

    JLabel lNamaB = new JLabel("Nama Barang");
    final JTextField tfNamaB = new JTextField();
    JLabel lMassaB = new JLabel("Massa (gr)");
    final JTextField tfMassaB = new JTextField();
    JLabel lHargaB = new JLabel("Harga Satuan");
    final JTextField tfHargaB = new JTextField();

    JButton tombolSubmit = new JButton("Submit");
    JButton tombolReset = new JButton("Reset");
    JButton tombolKembali = new JButton("Kembali");

    public Input() {
        setTitle("Input Barang");
        setSize(400, 300);

        
        setLayout(null);
        add(lInputB);
        add(lNamaB);
        add(lMassaB);
        add(lHargaB);
        add(tfNamaB);
        add(tfMassaB);
        add(tfHargaB);
        add(tombolSubmit);
        add(tombolReset);
        add(tombolKembali);

        
        lInputB.setBounds(150, 20, 80, 20);
        lNamaB.setBounds(10, 45, 80, 20);
        tfNamaB.setBounds(130, 45, 240, 20);
        lMassaB.setBounds(10, 70, 80, 20);
        tfMassaB.setBounds(130, 70, 240, 20);
        lHargaB.setBounds(10, 95, 80, 20);
        tfHargaB.setBounds(130, 95, 240, 20);
        tombolSubmit.setBounds(40, 155, 145, 25);
        tombolReset.setBounds(205, 155, 145, 25);
        tombolKembali.setBounds(40, 200, 145, 25);

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        tombolSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `barang`(`nama`,`massa`,`harga`) VALUES ('"+getNama()+"','"+getMassa()+"','"+getHarga()+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        tombolReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tfNamaB.setText(null);
                tfMassaB.setText(null);
                tfHargaB.setText(null);
            }
        });
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0)  {
                Menu mm = new Menu();
            }
        });
    }
    
      public String getNama() {
        return tfNamaB.getText();
    }

    public String getMassa() {
        return tfMassaB.getText();
    }

    public String getHarga() {
        return tfHargaB.getText();
    }
    
    public void inputDB(){
        
    }
}
