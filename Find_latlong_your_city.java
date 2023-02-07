import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.*;
import java.io.*;
import java.net.*;

class Findlatlong
{
    static String state,city,lat,lang;
    void latLong()
    {
        try
        {
            JSONParser pas = new JSONParser();
            FileReader fl =new FileReader("State.json");
            Object obe = pas.parse(fl);

            JSONObject ojs = (JSONObject)obe;



            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+","+(ojs.get(state))+",IN&appid=40a67ea8f8fa0636b7ea6339f82e2d31");
            HttpURLConnection obj = (HttpURLConnection) url.openConnection();
            obj.setRequestMethod("GET");


            InputStreamReader in = new InputStreamReader(obj.getInputStream());
            BufferedReader in1 = new BufferedReader(in);
            String st = in1.readLine();

            JSONParser pa = new JSONParser();
            JSONArray arr = (JSONArray) pa.parse(st);
            JSONObject obj1 = (JSONObject) arr.get(0);

            Object objlat =  obj1.get("lat");
            Object objlon = obj1.get("lon");

            lat = objlat.toString();
            lang = objlon.toString();

        }

        catch(Exception protException)
        {
            System.out.println(protException);
        }
    }

    void fram()
    {
        JFrame fram = new JFrame();
        fram.setBounds(0,0,450,400);

        JLabel title = new JLabel("Know Your City Latitude & Longitude");
        title.setBounds(50,10,350,25);
        title.setFont(new Font("Serif", Font.PLAIN, 20));
        fram.add(title);

        JLabel statel = new JLabel("Enter Your State");
        JLabel cityl = new JLabel("Enter Your City");
        JLabel stat = new JLabel("(Use Lower Case later)");
        JLabel cit = new JLabel("(Use Lower Case later)");
        statel.setBounds(30,70,150,25);
        cityl.setBounds(30,110,150,25);
        stat.setBounds(200,95,100,10);
        cit.setBounds(200,135,100,10);
        statel.setFont(new Font("Serif", Font.PLAIN, 16));
        cityl.setFont(new Font("Serif", Font.PLAIN, 16));
        stat.setFont(new Font("Serif",Font.PLAIN,10));
        cit.setFont(new Font("Serif",Font.PLAIN,10));
        fram.add(statel);
        fram.add(cityl);
        fram.add(stat);
        fram.add(cit);

        JTextArea state1 = new JTextArea();
        JTextArea city1 = new JTextArea();
        state1.setBounds(170,70,150,25);
        city1.setBounds(170,110,150,25);
        state1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        city1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fram.add(state1);
        fram.add(city1);

        JButton submit = new JButton("Submit");
        submit.setBounds(175,160,100,30);
        fram.add(submit);

        JLabel lats = new JLabel();
        JLabel langs = new JLabel();

        lats.setBounds(50,220,300,20);
        langs.setBounds(50,250,300,20);
        lats.setFont(new Font("Serif", Font.PLAIN, 18));
        langs.setFont(new Font("Serif", Font.PLAIN, 18));

        fram.add(lats);
        fram.add(langs);


        ActionListener click = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                state = state1.getText();
                city = city1.getText();
                latLong();

                lats.setText("Your City Latitude=  "+lat);
                langs.setText("Your City Longitude=  "+lang);

            }
        };

        submit.addActionListener(click);
        fram.setLayout(null);
        fram.setVisible(true);
    }
}
public class Find_latlong_your_city
{
    public static void main(String[] agrs)
    {
        Findlatlong obj = new Findlatlong();
        obj.fram();
    }
}