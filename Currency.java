import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Converter
    {
        static float val1,val2;
        JFrame frame;

        void frame()
        {
            frame = new JFrame();
            frame.setBounds(10,20,400,400);

            JLabel title = new JLabel("All Converter");
            title.setBounds(120,20,100,15);
            frame.add(title);

            JLabel temp = new JLabel("Convert to Temprecher");
            temp.setBounds(25,75,150,25);
            frame.add(temp);


            JButton btem = new JButton("Click Here");
            btem.setBounds(200,75,100,25);
            frame.add(btem);


            JLabel currency = new JLabel("Convert to Currency");
            currency.setBounds(25,125,150,25);
            frame.add(currency);

            JButton bcurrency = new JButton("Click Here");
            bcurrency.setBounds(200,125,100,25);
            frame.add(bcurrency);


            JLabel distance = new JLabel("Convert to Distance");
            distance.setBounds(25,175,150,25);
            frame.add(distance);

            JButton bdistance = new JButton("Click Here");
            bdistance.setBounds(200,175,100,25);
            frame.add(bdistance);


// Connevet to temperature
            ActionListener tempre = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    temp();
                }
            };

    //Canvert to Currency

            ActionListener curren = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    curr();
                }
            };

    //Convert to distance

            ActionListener distan = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    dist();
                }
            };

            btem.addActionListener(tempre);
            bcurrency.addActionListener(curren);
            bdistance.addActionListener(distan);
            frame.setLayout(null);
            frame.setVisible(true);
        }




        void temp()
        {
            JFrame tefram = new JFrame();
            tefram.setBounds(10,20,600,300);

            JLabel tetitle = new JLabel("Temperature Converter");
            tetitle.setBounds(200,20,150,25);
            tefram.add(tetitle);

            JLabel value = new JLabel("Enter Celcius");
            value.setBounds(20,75,200,25);
            tefram.add(value);

            JLabel value2 = new JLabel("Enter Fahrenheit");
            value2.setBounds(20,110,200,25);
            tefram.add(value2);

            JTextArea txvalue = new JTextArea();
            txvalue.setBounds(130,77,100,25);
            txvalue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tefram.add(txvalue);

            JTextArea txvalue2 = new JTextArea();
            txvalue2.setBounds(130,110,100,25);
            txvalue2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tefram.add(txvalue2);

            JButton inrbutton = new JButton("To Celcius");
            JButton usdbutton = new JButton("To Fahrenheit");
            inrbutton.setBounds(250,110,110,25);
            usdbutton.setBounds(250,77,110,25);
            tefram.add(inrbutton);
            tefram.add(usdbutton);

            JLabel fina = new JLabel();
            fina.setBounds(380,77,200,25);
            tefram.add(fina);

            JLabel fina2 = new JLabel();
            fina2.setBounds(380,110,200,25);
            tefram.add(fina2);



            ActionListener celvalue = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String tval2 =txvalue2.getText();
                    float ival2 = Float.parseFloat(tval2);
                    val1 = ((ival2 - 32) * 5) / 9;
                    fina2.setText("Celcius=  "+val1+" °C");
                    fina2.setFont(new Font("Serif", Font.PLAIN, 20));
                    txvalue2.setText("");
                }
            };

            ActionListener forvalue = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String tval =txvalue.getText();
                    float ival = Float. parseFloat(tval) ;
                    val2 =  ((ival * 9) / 5) + 32;
                    fina.setText("Fahrenheit=  "+val2+" °F");
                    fina.setFont(new Font("Serif", Font.PLAIN, 20));
                    txvalue.setText("");
                }
            };

            JButton bhome = new JButton("HOME");
            bhome.setBounds(200,165,100,25);
            tefram.add(bhome);

            ActionListener home = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    tefram.setVisible(false);
                    frame.setVisible(true);
                }
            };

            bhome.addActionListener(home);
            inrbutton.addActionListener(celvalue);
            usdbutton.addActionListener(forvalue);
            tefram.setLayout(null);
            frame.setVisible(false);
            tefram.setVisible(true);
        }


    void curr()
            {
                JFrame cufram = new JFrame();
                cufram.setBounds(10,20,600,300);

                JLabel tetitle = new JLabel("Currency Converter");
                tetitle.setBounds(200,20,150,25);
                cufram.add(tetitle);

                JLabel value = new JLabel("Enter INR");
                value.setBounds(40,77,150,25);
                cufram.add(value);

                JLabel value2 = new JLabel("Enter USD");
                value2.setBounds(40,110,150,25);
                cufram.add(value2);

                JTextArea txvalue = new JTextArea();
                txvalue.setBounds(130,77,100,25);
                txvalue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cufram.add(txvalue);

                JTextArea txvalue2 = new JTextArea();
                txvalue2.setBounds(130,110,100,25);
                txvalue2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cufram.add(txvalue2);

                JButton inrbutton = new JButton("To INR");
                JButton usdbutton = new JButton("To USD");
                inrbutton.setBounds(250,110,100,25);
                usdbutton.setBounds(250,77,100,25);
                cufram.add(inrbutton);
                cufram.add(usdbutton);

                JLabel fina = new JLabel();
                fina.setBounds(370,77,200,25);
                cufram.add(fina);

                JLabel fina2 = new JLabel();
                fina2.setBounds(370,110,200,25);
                cufram.add(fina2);



                ActionListener inrval = new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String tval =txvalue2.getText();
                        float ival = Float. parseFloat(tval);
                        val1 = ival * 80;
                        fina2.setText("INR value=  "+val1+" ₹");
                        fina2.setFont(new Font("Serif", Font.PLAIN, 20));
                    }
                };

                ActionListener usdval = new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String tval =txvalue.getText();
                        float ival = Float. parseFloat(tval) ;
                        val2 = ival / 80;
                        fina.setText("USD value=  "+val2+" $");
                        fina.setFont(new Font("Serif", Font.PLAIN, 20));
                    }
                };

                JButton bhome = new JButton("HOME");
                bhome.setBounds(200,165,100,25);
                cufram.add(bhome);
                ActionListener home = new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        cufram.setVisible(false);
                        frame.setVisible(true);
                    }
                };

                bhome.addActionListener(home);
                inrbutton.addActionListener(inrval);
                usdbutton.addActionListener(usdval);
                cufram.setLayout(null);
                frame.setVisible(false);
                cufram.setVisible(true);
            }

        void dist()
        {
            JFrame difram = new JFrame();
            difram.setBounds(10,20,600,300);

            JLabel tetitle = new JLabel("Distance Converter");
            tetitle.setBounds(200,20,150,25);
            difram.add(tetitle);

            JLabel value = new JLabel("Enter KM =");
            value.setBounds(20,75,200,25);
            difram.add(value);

            JLabel value2 = new JLabel("Enter Meter =");
            value2.setBounds(20,110,200,25);
            difram.add(value2);

            JTextArea txvalue = new JTextArea();
            txvalue.setBounds(130,77,100,25);
            txvalue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            difram.add(txvalue);

            JTextArea txvalue2 = new JTextArea();
            txvalue2.setBounds(130,110,100,25);
            txvalue2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            difram.add(txvalue2);

            JButton inrbutton = new JButton("To KM");
            JButton usdbutton = new JButton("To Meter");
            inrbutton.setBounds(250,110,100,25);
            usdbutton.setBounds(250,77,100,25);
            difram.add(inrbutton);
            difram.add(usdbutton);

            JLabel fina = new JLabel();
            fina.setBounds(370,77,200,25);
            difram.add(fina);

            JLabel fina2 = new JLabel();
            fina2.setBounds(370,110,200,25);
            difram.add(fina2);



        ActionListener inrval = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tval =txvalue2.getText();
                float ival = Float. parseFloat(tval) ;
                val1 = ival/1000;
                fina2.setText("KiloMeter is =  "+val1+" KM");
                fina2.setFont(new Font("Serif", Font.PLAIN, 17));
            }
        };

        ActionListener usdval = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String tval =txvalue.getText();
                float ival = Float. parseFloat(tval) ;
                val2 =  ival*1000;
                fina.setText("Meter is =  "+val2+" Meter");
                fina.setFont(new Font("Serif", Font.PLAIN, 17));
            }
        };

        JButton bhome = new JButton("HOME");
        bhome.setBounds(200,165,100,25);
        difram.add(bhome);

        ActionListener home = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                difram.setVisible(false);
                frame.setVisible(true);
            }
        };
        bhome.addActionListener(home);
        inrbutton.addActionListener(inrval);
        usdbutton.addActionListener(usdval);
        difram.setLayout(null);
        frame.setVisible(false);
        difram.setVisible(true);
    }
    }
public class Currency
{
    public static void main(String[] args)
    {
        Converter obj = new Converter();
        obj.frame();
    }
}
