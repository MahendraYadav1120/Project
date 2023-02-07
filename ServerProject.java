import java.net.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;


class server1
{
    static ServerSocket se;
    static Socket so;
    static Scanner sc = new Scanner(System.in);
    static Scanner sca;
    static  PrintWriter ps;
    static String str="",str1="";
    JFrame frame;
    JTextArea ctextarea;
    JTextField tswrite;

    Client1 obcli = new Client1();

    void maina()
    {
        try
        {
            se = new ServerSocket(8539);
            System.out.println("Server is running....");
            Socket s = se.accept();
            System.out.println("connection Established");

            sca = new Scanner(s.getInputStream());
            ps = new PrintWriter(s.getOutputStream(),true);

            read();
            write();          

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    void read()
    {
        Thread t= new Thread(
            new Runnable() {
            @Override
            public void run() {
                while (true) {

                                
                    str=sc.nextLine();
                    ps.println(str);
                                

                    }
                }

            });
            t.start();
    }

    void write()
    {
        Thread t1= new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                    while (true)
                    {
                        str1 = sca.nextLine();                       
                        ctextarea.append(str1+"\n");
                                          
                        if(str1.equals("bye"))
                        {
                            break;
                        }
                    }

                    }
                });
        t1.start();
    }

    void fram()
    {
        frame = new JFrame("ServerChat Room");   
        JLabel label = new JLabel(" Talking With Client");    
        JLabel swrite = new JLabel("Write Massage");       
        tswrite = new JTextField(); 
        JButton submit = new JButton("Send");
        ctextarea = new JTextArea();      
        
        frame.setBounds(50,50,400,600);   
        label.setBounds(90,10,200,25);   
        swrite.setBounds(10,50,100,20);       
        tswrite.setBounds(100,50,200,25);
        submit.setBounds(120,100,75,30);
        ctextarea.setBounds(15,150,350,380);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        ctextarea.setFont(new Font("Serif", Font.PLAIN, 20));
         
       
        frame.add(label);
        frame.add(swrite);       
        frame.add(tswrite);
        frame.add(ctextarea);
        frame.add(submit);       

         
        ActionListener click = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {                
                str=tswrite.getText(); 
                ps.println(str);
                tswrite.setText("");                     
               
            }
        };
        
        submit.addActionListener(click);


        frame.setLayout(null);
        frame.setVisible(true);
        maina();

    }

public class Server {

    public static void main(String[] args) {
        server1 obj = new server1();
        obj.fram();
    }
}
}