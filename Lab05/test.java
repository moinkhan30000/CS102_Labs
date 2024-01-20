import java.util.ArrayList;
import java.awt.*;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;

public class test extends JPanel implements ActionListener {
    private static ArrayList <Planet> arr = new ArrayList<Planet>();
    static int delay = 25;
    static int flag = 0;
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int size = arr.size();
        for(int i =0; i<size; i++)
        {
            arr.get(i).setCX(getWidth()/2);
            arr.get(i).setCY(getHeight()/2);
            arr.get(i).draw(g); 
        }

    }
        public void actionPerformed (ActionEvent event)
        {
            if(flag == 0)
            {
                int size = arr.size();
                for(int i =0; i<size; i++)
                {
                    arr.get(i).setCurrentAngle(arr.get(i).getCurrentAngle() - arr.get(i).getAngularSpeed());
                    arr.get(i).setPosition(arr.get(i).getCurrentAngle());
                    this.repaint();  
                }
            }
            else
            {
                int size = arr.size();
                for(int i =0; i<size; i++)
                {
                    arr.get(i).setCurrentAngle(arr.get(i).getCurrentAngle() + arr.get(i).getAngularSpeed());
                    arr.get(i).setPosition(arr.get(i).getCurrentAngle());
                    this.repaint();  
                }
            }


        }

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Solar Sytem");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
        Planet p1 = new Planet (400,300,60, 60, 1);
        Planet p2 = new Planet (300,400,130, 30,3);  
        Planet p3 = new Planet (350,300,350, 35,6);
        Planet p4 = new Planet (445,350,220, 40,10);
        test panel = new test();
        Timer t = new Timer(delay, panel);
        t.start();
        t.setRepeats(true);
        JTextField field = new JTextField(25);
        JLabel label = new JLabel("Enter in Format : Radius, Radius1 of Orbit, Radius2 of Orbit, Angle , Angular Speed : ");
        label.setForeground(Color.WHITE);
        class pause implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                t.stop();
            }
        }
        class play implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                flag = 0;
                t.start();;
            }
        }
        class rewind extends JPanel implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                flag =1;
                t.start();
            }
        }
        class input extends JLabel implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                int r;
                int r1;
                int r2;
                int angle;
                int speed;
                String temp;
                temp = field.getText();
                String[] array = temp.split(",");
                System.out.println();
                r = Integer.parseInt(array[0]);
                r1 = Integer.parseInt(array[1]);
                r2= Integer.parseInt(array[2]);
                angle = Integer.parseInt(array[3]);
                speed = Integer.parseInt(array[4]);
                Planet p = new Planet(r1, r2, angle, r, speed);
                arr.add(p);
                field.setText("");
                System.out.println(r + " " + r1 + "" + r2  + "" + angle + "" + speed);
                this.repaint();         
            }
        }
        play s = new play();
        pause p = new pause();
        rewind r = new rewind();
        input i = new input();
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        JButton button1 =  new JButton("Play");
        JButton button2 =  new JButton("Pause");
        JButton button3 =  new JButton("Rewind");
        JButton button4 =  new JButton("Enter");
        button1.addActionListener(s);
        button2.addActionListener(p);
        button3.addActionListener(r);
        button4.addActionListener(i);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        panel.add(label);
        panel.add(field);
        panel.add(button4);

        panel.setBackground(Color.BLACK);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
        
    }
    
}
