import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JRadioButton;

class Que
{
      
    static int data=0;
    static int cnext=0,marks=0,qust,qust_count=1;
    static String qt,obj1,obj2,obj3,obj4,ans; 


    void queTest()
    {
        JFrame frame=new JFrame("MCQ Test");
        frame.setSize(450,500);

        JButton btn_val=new JButton("0");
        btn_val.setBounds(200,150,75,25);
        btn_val.setVisible(false);

        JLabel lb_top=new JLabel(); 
        lb_top.setBounds(300, 1, 200, 20);  
             
        JSONParser parser=new JSONParser();    
        try 
        {
            ButtonGroup G = new ButtonGroup();
            
            Object obj=parser.parse(new FileReader("Quiz.json")); 
            JSONArray arr=(JSONArray)obj; 

            btn_val.setText(String.valueOf(cnext));                           
            lb_top.setText("Total Questions: "+arr.size());

            JLabel mark_show=new JLabel("Your Marks"+marks);
            mark_show.setBounds(20, 400, 400,25);
            mark_show.setVisible(true);

            JSONObject objdata=(JSONObject)arr.get(0);    
            
            qt=(String)objdata.get("Question");
            obj1=(String)objdata.get("A");
            obj2=(String)objdata.get("B");
            obj3=(String)objdata.get("C");
            obj4=(String)objdata.get("D");
            ans=(String)objdata.get("ANS");

            JLabel Question=new JLabel(qust_count+". "+qt);
            Question.setBounds(10, 10, 400, 25);
                        
            JRadioButton op1=new JRadioButton(obj1);
            op1.setBounds(10, 50, 300, 25);
            JRadioButton op2=new JRadioButton(obj2);
            op2.setBounds(10, 90, 300, 25);
            JRadioButton op3=new JRadioButton(obj3);
            op3.setBounds(10, 130, 300, 25);
            JRadioButton op4=new JRadioButton(obj4);
            op4.setBounds(10, 170, 300, 25);

            JLabel answr=new JLabel(ans);
            answr.setBounds(20, 210, 150, 25);

            JLabel user_answr=new JLabel();
            user_answr.setBounds(240, 210, 150, 25);

            JButton next=new JButton("Next");
            next.setBounds(150,250,150,25);

            G.add(op1);
            G.add(op2);
            G.add(op3);
            G.add(op4);

            

            frame.add(Question);
            frame.add(op1);
            frame.add(op2);
            frame.add(op3);
            frame.add(op4);            
            frame.add(next);
            frame.add(mark_show);
            frame.setLayout(null);
            frame.setVisible(true);


            JLabel anshow = new JLabel();
            anshow.setBounds(100,300,400,25);
            anshow.setFont(new Font("Serif", Font.PLAIN, 20));
            frame.add(anshow);

            ActionListener click=new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                { 
                    G.clearSelection();
                    if(user_answr.getText().equals(answr.getText()))
                    {                        
                        marks++;
                        anshow.setText("Your Answer is Correct");
                        mark_show.setText(String.valueOf("Your Marks:-"+marks));                 
                    }
                    else
                    {                        
                        anshow.setText("Your Answer is Incorrect");
                    }
                        
                    JSONParser parser=new JSONParser();    
                    try 
                    {
                        Object obj=parser.parse(new FileReader("Quiz.json")); 
                        JSONArray arr=(JSONArray)obj; 
                            
                        cnext++;
                        btn_val.setText(String.valueOf(cnext));
                        qust_count++;

                        int data=Integer.parseInt(btn_val.getText());
                        JSONObject objdata=(JSONObject)arr.get(data--);                     
                        qt=(String)objdata.get("Question");
                        obj1=(String)objdata.get("A");
                        obj2=(String)objdata.get("B");
                        obj3=(String)objdata.get("C");
                        obj4=(String)objdata.get("D");
                        ans=(String)objdata.get("ANS");

                        Question.setText(qust_count+". "+qt); 
                        op1.setText(obj1);  
                        op2.setText(obj2); 
                        op3.setText(obj3); 
                        op4.setText(obj4);         
                        answr.setText(ans);

                    } 
                    catch (Exception ee) 
                    {
                        System.out.println(ee);
                    }      
                          
                    if(btn_val.getText().equals("9"))
                    {
                        next.setText("Submit");
                    }

                    if(btn_val.getText().equals("10"))
                    {
                        JFrame frame1 = new JFrame();
                        frame1.setSize(300,350);

                        JLabel title = new JLabel("Your Result");
                        title.setBounds(50,20,200,50);
                        title.setFont(new Font("Arial", Font.PLAIN, 25));
                        frame1.add(title);

                        JLabel result=new JLabel("Total Marks:- "+arr.size());
                        JLabel yresult = new JLabel("Your Marks:- "+marks);

                        result.setBounds(50, 70, 400, 50);
                        result.setFont(new Font("Arial", Font.PLAIN, 20));
                        frame1.add(result);

                        yresult.setBounds(50, 100, 400, 50);
                        yresult.setFont(new Font("Arial", Font.PLAIN, 20));
                        frame1.add(yresult);

                        frame1.setLayout(null);
                        frame.setVisible(false);
                        frame1.setVisible(true);
                       
                    }
                }
                                    
            };
            qust=Integer.parseInt(btn_val.getText());
       
            next.addActionListener(click);
            frame.add(lb_top);
        
        ActionListener opcheck=new ActionListener()
        {             
            public void actionPerformed(ActionEvent e)             
            {
                if(op1.isSelected())
                {    
                    user_answr.setText(op1.getText());
                } 
                else if(op2.isSelected())
                {    
                    user_answr.setText(op2.getText());
                } 
                else if(op3.isSelected())
                {    
                    user_answr.setText(op3.getText());
                } 
                else if(op4.isSelected())
                {    
                    user_answr.setText(op4.getText());
                } 
                anshow.setText("");                    
            }
        };

         op1.addActionListener(opcheck);
         op2.addActionListener(opcheck);
         op3.addActionListener(opcheck);
         op4.addActionListener(opcheck); 
        
    } 
    catch (Exception ee) 
    {
            System.out.println(ee);
    } 

    }
}


class Quiz{

    public static void main(String[] args) 
    {
        Que obj = new Que();
        obj.queTest();
    }    
}