import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

class Password
{
    static int num;
    static String pass;
    String generet()
    {
        int length = num;
        String repass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$1234567890";

        Random random = new Random();
        char[] password = new char[8];

        for(int i=0;i<8;i++)
        {
            password[i] = repass.charAt(random.nextInt(repass.length()));
        }
        String str = new String();
        pass = str.valueOf(password);
        return pass;
    }

    void frams()
    {
        JFrame fram = new JFrame();
        fram.setBounds(10,25,350,350);

        JLabel title = new JLabel("Random Password Generator");
        title.setBounds(70,10,200,25);
        fram.add(title);

        JLabel length = new JLabel("Enter Your Name");
        length.setBounds(10,50,100,25);
        fram.add(length);


        JTextArea tlength = new JTextArea();
        tlength.setBounds(120,50,200,25);
        tlength.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fram.add(tlength);


        JButton get = new JButton("Get Password");
        get.setBounds(100,100,120,30);
        fram.add(get);

        JLabel id = new JLabel();
        JLabel pass = new JLabel();
        id.setBounds(20,175,300,25);
        pass.setBounds(20,200,300,25);

        id.setFont(new Font("Serif", Font.PLAIN,20));
        pass.setFont(new Font("Serif",Font.PLAIN,20));
        fram.add(id);
        fram.add(pass);



        ActionListener click = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ee)
            {
                String name=tlength.getText();
                id.setText("Your Id is = "+name);

                pass.setText("Your Password is = "+generet());

                tlength.setText("");
            }
        };

        get.addActionListener(click);
        fram.setLayout(null);
        fram.setVisible(true);
    }
}

public class Generatepassword
{
    public static void main(String[] args)
    {
        Password obj = new Password();
        obj.frams();
    }
}
