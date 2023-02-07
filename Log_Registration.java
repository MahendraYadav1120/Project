import com.sun.source.tree.TryTree;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
class Gvalue
{
    void getv()
    {
        JFrame fr = new JFrame("Login Form");
        fr.setSize(350,400);

        JTextArea tx = new JTextArea();
        tx.setBounds(100,25,150,25);
        tx.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fr.add(tx);

        JPasswordField tx2 = new JPasswordField();
        tx2.setBounds(100,65,150,25);
        tx2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fr.add(tx2);

        JLabel l1 = new JLabel("User Name");
        l1.setBounds(30,25,80,25);
        fr.add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(30,65,80,25);
        fr.add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(30,200,200,25);
        fr.add(l3);

        JButton ob1 = new JButton("Login");
        ob1.setBounds(110,110,100,25);
        fr.add(ob1);

        JButton ob2 = new JButton("Create new user");
        ob2.setBounds(95,150,130,25);
        fr.add(ob2);

        ActionListener cl = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFrame j2 = new JFrame();
                j2.setSize(350, 400);
                j2.setLayout(null);

                JLabel j = new JLabel();
                j.setBounds(100, 10, 200, 30);

                JButton back = new JButton("Back");
                back.setBounds(0,10,75,25);
                j2.add(back);

                String na =tx.getText();
                String pa = tx2.getText();

                try
                {
                   File r = new File("file.txt");
                   Scanner o = new Scanner(r);
                    int count=0;
                    while(o.hasNextLine())
                    {
                        String da = o.nextLine();
                        if (da.contains(na)&&da.contains(pa))
                        {
                            j2.setVisible(true);
                            j2.add(j);
                            j.setText("Welcome " +na);
                            count=1;
                        }
                    }
                    if(count==0)
                    {
                        l3.setText("Your name or password incorect");
                    }
                }
                catch (Exception a) {
                    System.out.println(a);
                }

                ActionListener backbu = new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        j2.setVisible(false);
                        j.setVisible(true);
                    }
                };
                tx.setText("");
                tx2.setText("");
                back.addActionListener(backbu);
            }
        };

        ActionListener lc = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                fr.setVisible(false);
                registration();
            }
        };
        fr.setLayout(null);
        ob1.addActionListener(cl);
        ob2.addActionListener(lc);
        fr.setVisible(true);
    }

    void registration()
    {
        JFrame fr = new JFrame("Registration Form");
        fr.setSize(350,400);

        JTextArea tx = new JTextArea();
        tx.setBounds(100,25,200,25);
        tx.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fr.add(tx);

        JTextArea tx1 = new JTextArea();
        tx1.setBounds(100,65,200,25);
        tx1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fr.add(tx1);

        JPasswordField tx2 = new JPasswordField();
        tx2.setBounds(100,105,200,25);
        tx2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fr.add(tx2);

        JTextField tx3 = new JTextField();
        tx3.setBounds(110,145,190,25);
        tx3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fr.add(tx3);

        JLabel l1 = new JLabel("User Name");
        l1.setBounds(30,25,80,25);
        fr.add(l1);

        JLabel l2 = new JLabel("User Email");
        l2.setBounds(30,65,80,25);
        fr.add(l2);

        JLabel l3 = new JLabel("User Password");
        l3.setBounds(10,102,100,25);
        fr.add(l3);

        JLabel l4 = new JLabel(" Reset Password");
        l4.setBounds(10,145,100,25);
        fr.add(l4);

        JLabel l5 = new JLabel();
        l5.setBounds(50,300,200,25);
        fr.add(l5);

        JButton ob1 = new JButton("Submit");
        ob1.setBounds(100,200,100,25);
        fr.add(ob1);

        JButton ob2 = new JButton("User Login");
        ob2.setBounds(90,240,120,25);
        fr.add(ob2);

        ActionListener cl = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String na = tx.getText();
                String ea = tx1.getText();
                String pa = tx2.getText();
                String rpa = tx3.getText();

                if(pa.equals(rpa))
                { 
                    try 
                    {
                        FileWriter f = new FileWriter("file.txt", true);
                        if (pa.contains(rpa))
                        {
                            f.append(na + " " + ea + " " + pa + "\n");
                            f.close();
                            l5.setText("Your Registation successfuly");
                        } 
                        else 
                        {
                            l5.setText("No match Enter password");
                        }

                    } 
                    catch (Exception a) 
                    {
                        System.out.println(a);
                    }
                }
                else
                {
                    l5.setText("No Match Renter password");

                }
            }
       };

            ActionListener cl1 = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fr.setVisible(false);
                    getv();
                }
            };
        fr.setLayout(null);
        ob1.addActionListener(cl);
        ob2.addActionListener(cl1);
        fr.setVisible(true);
    }
}
public class Log_Registration 
{
    public static void main(String[] args) 
    {
        
        Gvalue obj = new Gvalue();
        obj.getv();
    }
}
