import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String.*;
import java.security.cert.X509CRLSelector;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.lang.NullPointerException;
public class Calculator{
  static  String temp_str="",opr,outstring;  
  static int i=0,num=0,count=0,finaldata,tmp1,tmp2,sum=0;
  static String data_in[]=new String[20]; 
  static int add=0;
  static int ln_count;
  static int mul,sub,rest_data=0;
  static JButton reset_data;
  static  String data,y="",indata;   
    public static void main(String[] args) {
        String div_data[]=new String[30];
        String mul_data[]=new String[30];
        String add_data[]=new String[30];
        String sub_data[]=new String[30];
       
        
        JFrame frame=new JFrame("Panel Calculator");
        frame.setSize(500,600);
        JTextArea txt=new JTextArea();
        txt.setBounds(10, 10, 460, 100);
        txt.setBackground(Color.white);        
        JPanel panel=new JPanel();
        panel.setBounds(0,120,500,320);    
       
        GridLayout layout = new GridLayout(5,4);       
        panel.setLayout(layout);
        reset_data=new JButton("Reset");
    
       String bt[]={"1","2","3","+","4","5","6","-","7","8","9","*","/",".","0","="};
       
       for(i=0;i<bt.length;i++)
       {
         JButton btn;
         btn=new JButton();  
         btn.setText(""+bt[i]);
         panel.add(btn);   
            ActionListener click=new ActionListener(){
              public void actionPerformed(ActionEvent e)
              {  
                               
                char in_num[]=new char[20];          
                            
                data=btn.getText(); 
                indata=txt.getText(); 
                outstring=indata+data;
                txt.setText(outstring);
              
                if(!data.equals("+") && !data.equals("*") && !data.equals("-")
                && !data.equals("/") && !data.equals("="))
                {
                        temp_str=temp_str+data;  
                      // System.out.println(temp_str);
                              
                }                
                else
                {  
                   
                        data_in[count]=temp_str;                         
                        count++;  
                        data_in[count]=data;                        
                        count++;                                           
                        temp_str="";
                                           
                  
                  if(data.equals("="))
                  {     
                    
                    int count_arr=0;
                                for(int aj=0;aj<data_in.length;aj++)
                                {
                                    if(data_in[aj]!=null)
                                    {
                                        count_arr++;                                        
                                    }                                 
                                    
                                }
                               
                    for(int ai=0;ai<count_arr;ai++)
                            {                   
                                if(data_in[ai].equals("/"))
                                {
                                    double temp;
                                    temp=Double.parseDouble(data_in[ai-1])/Double.parseDouble(data_in[ai+1]);
                                    data_in[ai-1]=Double.toString(temp);
                                    data_in[ai]="_";data_in[ai+1]="_";
                                   
                                   for(int j=0,k=0;j<count_arr;j++)
                                   {
                                       if(!data_in[j].equals("_"))
                                       {
                                        data_in[k]=data_in[j];
                                           k++;
                                       }
                                       ai=0;
                                   }
                                   
                                }  
                                                                 
                                        
                            }
                            
                            int countd=0;
                                    for(String ad:data_in)
                                    {      
                                           
                                        if(ad.equals("="))
                                        {
                                            ln_count=countd;
                                            break;
                                        }
                                        countd++;             
                                                    
                                    }
                                   

                                for(int i=0;i<ln_count+1;i++)
                                    {
                                    
                                        if(data_in[i].equals("*"))
                                        {
                                            double temp;
                                                    temp=Double.parseDouble(data_in[i-1])*Double.parseDouble(data_in[i+1]);
                                                    data_in[i-1]=Double.toString(temp);
                                                    data_in[i]="_";data_in[i+1]="_";
                                                
                                                for(int j=0,k=0;j<count_arr;j++)
                                                {
                                                    if(!data_in[j].equals("_"))
                                                    {
                                                        data_in[k]=data_in[j];
                                                        k++;
                                                    }
                                                    i=0;
                                                }
                                        }  
                                               
                                    }
                                    int countm=0;
                                    for(String am:data_in)
                                    {      
                                    // System.out.println(a);       
                                        if(am.equals("="))
                                        {
                                            ln_count=countm;
                                            break;
                                        }
                                        countm++;             
                                                    
                                    }
    
                            for(int m=0;m<ln_count+1;m++)
                            {     
                               // System.out.println(data_in[m]);      
                                if(data_in[m].equals("+"))
                                {
                                    double temp;
                                    temp=Double.parseDouble(data_in[m-1])+Double.parseDouble(data_in[m+1]);
                                    data_in[m-1]=Double.toString(temp);
                                    data_in[m]="_";data_in[m+1]="_";
                                   
                                   for(int j=0,k=0;j<count_arr;j++)
                                   {
                                       if(!data_in[j].equals("_"))
                                       {
                                        data_in[k]=data_in[j];
                                           k++;
                                       }
                                       m=0;
                                   }
                                }
                               
                   }
                int counta=0;
                for(String aa:data_in)
                {
                    
                    if(aa.equals("="))
                    {
                        ln_count=counta;
                        break;
                    }
                    counta++;
                    
                }
                   for(int i=0;i<ln_count+1;i++)
                        {
                            if(data_in[i].equals("-"))
                                {
                                    double temp;
                                    temp=Double.parseDouble(data_in[i-1])-Double.parseDouble(data_in[i+1]);
                                    data_in[i-1]=Double.toString(temp);
                                    data_in[i]="_";data_in[i+1]="_";
                                   
                                   for(int j=0,k=0;j<count_arr;j++)
                                   {
                                       if(!data_in[j].equals("_"))
                                       {
                                        data_in[k]=data_in[j];
                                           k++;
                                       }
                                       i=0;
                                   }
                                }
                               
                        }
                        int count3=0;
                        for(String ct:data_in)
                        {
                            //System.out.println(c);           
                            
                        }
                        if(data_in[1].equals("="))
                        {
                           
                           String result_data=data_in[0];                          
                           txt.setText(outstring+result_data);
                          
                           
                        }
                  }  
                  
                }
                  
                }          
                
              

          };
          btn.addActionListener(click);   
          
          ActionListener click_rst=new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { 
                data="";  
                indata=""; 
                outstring="";
                txt.setText("");   
                temp_str="";
                count=0;         
               
               
            }
        };
        reset_data.addActionListener(click_rst);       
       }   
           
        panel.add(reset_data);
        frame.add(txt); 
        frame.add(panel);       
        frame.setLayout(null);
        frame.setVisible(true);       

   
      
      
      

    }
}