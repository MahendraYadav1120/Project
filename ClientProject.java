import java.net.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;


class Client1
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
    
    void mainb()
    {
        try
        {
            so  = new Socket(InetAddress.getLocalHost(),8539);
            System.out.println("Connected to server");

            sca = new Scanner(so.getInputStream());
            ps = new PrintWriter(so.getOutputStream(),true);

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
                           str1=sc.nextLine();
                            ps.println(str1);                           
                       

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
                            str = sca.nextLine();                           
                            ctextarea.append(str+"\n");                             

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
        frame = new JFrame("Client Chat Room");   
        JLabel label = new JLabel("Talking With Server");    
        JLabel swrite = new JLabel("Write Massage");       
        tswrite = new JTextField(); 
        ctextarea = new JTextArea();
        JButton submit = new JButton("Send"); 
        
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

        mainb();

        
        
        ActionListener click = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                str1=tswrite.getText();
                ps.println(str1);
                tswrite.setText("");

            }
        };
        
        submit.addActionListener(click);
        frame.setLayout(null);
        frame.setVisible(true);
       
    }

    public class Client {

        public static void main(String[] args) {
            Client1 obj = new Client1();
            obj.fram();
        }
    }
}
