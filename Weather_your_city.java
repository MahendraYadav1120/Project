import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.w3c.dom.Text;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.*;
import java.io.*;
import java.net.*;

class weath
{
    static String state, city;
    static Double temp;
    static String humidity,pressure,visibility,speed;
    void wea()
    {
        try
        {

            JSONParser pas = new JSONParser();
            FileReader fl =new FileReader("State.json");
            Object obe = pas.parse(fl);

            JSONObject ojs = (JSONObject)obe;

           // System.out.println(ojs.get(state));
            // connection karne ke liye code.
            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+","+(ojs.get(state))+",IN&appid=40a67ea8f8fa0636b7ea6339f82e2d31");
            HttpURLConnection obj = (HttpURLConnection) url.openConnection();
            obj.setRequestMethod("GET");

            // site se data read karne ke kiye.
            InputStreamReader in = new InputStreamReader(obj.getInputStream());
            BufferedReader in1 = new BufferedReader(in);
            String st = in1.readLine();

            JSONParser pa = new JSONParser();
            JSONArray arr = (JSONArray) pa.parse(st);
            JSONObject obj1 = (JSONObject) arr.get(0);
            System.out.println(obj1.get("lat"));
            System.out.println(obj1.get("lon"));

            URL url1 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+(obj1.get("lat"))+"&lon="+(obj1.get("lon"))+"&appid=40a67ea8f8fa0636b7ea6339f82e2d31");
            HttpURLConnection obh = (HttpURLConnection) url1.openConnection();
            obh.setRequestMethod("GET");

            InputStreamReader ins = new InputStreamReader(obh.getInputStream());
            BufferedReader in2 = new BufferedReader(ins);
            String sts = in2.readLine();

            System.out.println(sts);
            JSONObject obj2 = (JSONObject)pa.parse(sts);
            System.out.println(obj2.get("main"));
            JSONObject man = (JSONObject)obj2.get("main");
            JSONObject wind = (JSONObject)obj2.get("wind");
            double temp1 = (Double) man.get("temp");

            temp = temp1 -273.15;
            humidity =man.get("humidity").toString();
            pressure =man.get("pressure").toString();
            visibility = obj2.get("visibility").toString();
            speed = wind.get("speed").toString();


        }
        catch(Exception protException)
        {
            System.out.println(protException);
        }
    }

    void fram()
    {
        JFrame fram = new JFrame();
        fram.setBounds(0,0,500,450);

        JLabel title = new JLabel("Know your city weather");
        title.setBounds(135,10,400,25);
        title.setFont(new Font("Serif",Font.PLAIN,22));
        fram.add(title);

        JLabel stat = new JLabel("(Use Lower Case)");
        stat.setBounds(200,55,100,10);
        stat.setFont(new Font("Serif",Font.PLAIN,10));
        fram.add(stat);

        JLabel statel = new JLabel("Enter your State");
        JLabel cityl = new JLabel("Enter your City");
        statel.setBounds(20,65,100,25);
        cityl.setBounds(20,95,100,25);
        fram.add(statel);
        fram.add(cityl);

        JTextArea state1 = new JTextArea();
        JTextArea city1 = new JTextArea();
        state1.setBounds(130,70,310,25);
        city1.setBounds(130,100,310,25);
        state1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        city1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fram.add(state1);
        fram.add(city1);

        JButton submit = new JButton("Submit");
        submit.setBounds(200,150,100,30);
        fram.add(submit);



        JLabel tem = new JLabel("Temperature - ");
        JLabel wind = new JLabel("Wind_Speed - ");
        JLabel humidit = new JLabel("Humidity - ");
        JLabel visibilit = new JLabel("Visibility - ");
        JLabel press = new JLabel("Pressure - ");

        tem.setFont(new Font("Serif", Font.PLAIN, 18));
        wind.setFont(new Font("Serif",Font.PLAIN,18));
        humidit.setFont(new Font("Serif",Font.PLAIN,18));
        visibilit.setFont(new Font("Serif",Font.PLAIN,18));
        press.setFont(new Font("Serif",Font.PLAIN,18));


        tem.setBounds(20,200,130,25);
        wind.setBounds(20,230,130,25);
        humidit.setBounds(20,260,130,25);
        visibilit.setBounds(20,290,130,25);
        press.setBounds(20,320,130,25);

        fram.add(tem);
        fram.add(wind);
        fram.add(humidit);
        fram.add(visibilit);
        fram.add(press);

        JTextField temt = new JTextField();
        JTextField windt = new JTextField();
        JTextField humiditt = new JTextField();
        JTextField visibilitt = new JTextField();
        JTextField presst = new JTextField();

        temt.setFont(new Font("Serif", Font.PLAIN, 18));
        windt.setFont(new Font("Serif",Font.PLAIN,18));
        humiditt.setFont(new Font("Serif",Font.PLAIN,18));
        visibilitt.setFont(new Font("Serif",Font.PLAIN,18));
        presst.setFont(new Font("Serif",Font.PLAIN,18));


        temt.setBounds(130,202,305,25);
        windt.setBounds(130,232,305,25);
        humiditt.setBounds(130,262,305,25);
        visibilitt.setBounds(130,292,305,25);
        presst.setBounds(130,322,305,25);

        fram.add(temt);
        fram.add(windt);
        fram.add(humiditt);
        fram.add(visibilitt);
        fram.add(presst);


        ActionListener click = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                temt.setText("");
                windt.setText("");
                humiditt.setText("");
                visibilitt.setText("");
                presst.setText("");

                state = state1.getText();
                city = city1.getText();


                wea();
                String temps = String.valueOf(temp);
                temt.setText(temps+" °C");
                windt.setText(speed+" M/S");
                humiditt.setText(humidity+" %");
                visibilitt.setText(visibility+" Metres");
                presst.setText(pressure+" \"Hg");

            }
        };

        submit.addActionListener(click);
        fram.setLayout(null);
        fram.setVisible(true);
    }
}

public class Weather_your_city
{
    public static void main(String[] agrs)
    {
        weath obj = new weath();

        obj.fram();
    }
}