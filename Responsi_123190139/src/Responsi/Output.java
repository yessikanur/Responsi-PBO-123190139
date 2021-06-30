/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Responsi;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Output {
    int jmlData;
    String data[][] = new String[500][4];
    
    Connector connector = new Connector();    
    
    JFrame window = new JFrame("Lihat Barang");
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Id Barang","Nama Barang","Massa Barang","Harga Barang"}; 

    public Output(){
        window.setLayout(null);
        window.setSize(550,600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        try{
            int jmlData = 0; 
            String query = "Select * from `barang`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("massa");
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        
        tabel = new JTable(data,namaKolom); 
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
    }
    
    public int getBanyakBarang(){ 
        int jmlData = 0;
        try{
            connector.statement = connector.koneksi.createStatement();
            String query = "Select * from `barang`";
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                jmlData++;
            }
            return jmlData; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
        
    }
    
    public String[][] readBarang(){ 
        try{
            int jmlData = 0; 
            String data[][] = new String[getBanyakBarang()][4];
            String query = "Select * from `barang`"; 
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("massa");
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++; 
                
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
