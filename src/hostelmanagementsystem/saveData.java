/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostelmanagementsystem;

import database.DataBase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Abdul Waheed
 */
public class saveData extends JFrame{
       
    public saveData () throws SQLException, ClassNotFoundException
    {
      initUI();    
    }
    
    private void initUI() throws SQLException, ClassNotFoundException
    {
        database.DataBase db=new DataBase();
        FileInputStream fis = null;
        
        setBounds(0, 0, 900, 660);
        setName("mainFrame");
        setTitle("Great Student Hostel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Student dd = Student.getStudent();
        
        JPanel Registration = new JPanel();
        Registration.setBackground(new Color(43, 153, 166));
        add(Registration);
        Registration.setBounds(0,0, 900,660);
        Registration.setLayout(null);
        //deserialize
        
        //fis = new FileInputStream("student.ser");
        
        //ObjectInputStream ois;
        
        
        //ois = new ObjectInputStream(fis);
        //db = (database.DataBase)ois.readObject();
        int numberOfColoms;
        int numberOfRows;
        ResultSetMetaData resultSetMetaData;
        numberOfColoms = 0;
        numberOfRows=0;
        resultSetMetaData = null;
        ResultSet rs;
        String query1 = "select * from users";
        rs=db.displayAll(query1);
        //System.out.println(es);
        resultSetMetaData = rs.getMetaData();
        numberOfColoms = resultSetMetaData.getColumnCount();
        numberOfRows = rs.getRow();
        String id = null;
        String name = null;
        String fname = null;
        String cnic = null;
        String dob = null;
        String edu = null;
        String clg = null;
        String sfee=null;
        String [] columnNames={"ID", "Name", "Father Name","CNIC","Date of Birth" ,"Education Level","College Name","Security Fee"};
        //Object[][] row;
        //static JTable table;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model); 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

    /**
     *
     */
    
    
        
        
           
           
        
            
        
         model.addRow(new Object[]{"ID","Name", "Father Name","CNIC","Date of Birth" ,"Education Level","College Name","Security Fee"});   
        //String []col = { "ID","Name", "Father Name","CNIC","Date of Birth" ,"Education Level","College Name","Security Fee"};
        
        //for(int i = 1; i<= numberOfColoms;i++)
            //{
            //System.out.printf("%s\t",resultSetMetaData.getColumnName(i));
            
            while(rs.next())
            {
            id = rs.getString("id");
name = rs.getString("name");
fname = rs.getString("father_name");
cnic = rs.getString("cnic"); 
dob=rs.getString("date_of_birth");
edu=rs.getString("eductionLevel");
clg=rs.getString("college_name");
sfee=rs.getString("securityFee");
model.addRow(new Object[]{id, name, fname, cnic,dob,edu,clg,sfee});
            //}
            
            }
      
        
        
        //String []col = { "ID","Name", "Father Name","CNIC","Date of Birth" ,"Education Level","College Name","Security Fee"};
            
        //JTable table = new JTable(row,col);
        table.setFont(table.getFont().deriveFont(12f));
        table.setBounds(100, 50, 600, 400);
        //table.add(model);
        Registration.add(table);
        JButton backButton  = new JButton("Back");
        backButton.setBounds(100, 590, 100, 30);
        backButton.setFont(backButton.getFont().deriveFont(16f));
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(550, 590, 100, 30);
        exitButton.setFont(exitButton.getFont().deriveFont(16f));
        Registration.add(backButton);
        Registration.add(exitButton);
        this.setVisible(true);
        
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                saveData.this.setVisible(false);
                mainScreen obj = new  mainScreen();
                obj.setVisible(true);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                System.exit(0);
                
            }
        });
        }
        //}
}
