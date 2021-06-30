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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author ASUS
 */

    public class Menu extends JFrame implements ActionListener{
    JButton tombolTambah, tombolLihat;
    JLabel menu;
    public Menu(){
        setTitle ("-");
        
        tombolTambah = new JButton ("Tambah Barang");
        tombolLihat = new JButton ("Lihat Barang");
        menu = new JLabel("Main Menu");
        
        setLayout(null);
        add(tombolTambah);
        add(tombolLihat);
        add(menu);
        
        menu.setBounds(55,5,100,20);
        tombolTambah.setBounds(10,30,150,20);
        tombolLihat.setBounds(10,50,150,20);
        
        tombolTambah.addActionListener(this);
        tombolLihat.addActionListener(this);
        
        setVisible(true);
        
        setSize(188,120);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolTambah) {
            Input ib = new Input();
        }
        if (e.getSource() == tombolLihat) {
            Output lb = new Output();
        }
    }
}
