/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Browser extends JFrame{
    
    private JTextField addressBar;
    private JEditorPane display;
    
    //constructor
    public Browser(){
        super("Awesome Browser");
        
        addressBar = new JTextField("Enter a valid Browser \n For eg:http://www.***.***");
        addressBar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        loadData(event.getActionCommand());
                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);
        
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener(){
                    public void hyperlinkUpdate(HyperlinkEvent event){
                        if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                            loadData(event.getURL().toString());
                    }
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);    
    }
    
    //load data to display on the screen
    private void loadData(String userText){
        try{
                display.setPage(userText);
                addressBar.setText(userText);            
    }catch(Exception e) {
        System.out.println("Please enter valid URL");
    }   
    }
        
    
}
