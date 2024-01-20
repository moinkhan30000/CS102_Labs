import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class Planet extends JPanel {
    private int x;
    private int y;
    private int a;
    private int b;
    private int angularSpeed;
    
    private int radius;
    private int currentAngle;
    private int cX = getWidth()/2;
    private int cY = getHeight()/2;
    Random random = new Random();
    int R = random.nextInt(256);
    int G = random.nextInt(256);
    int B = random.nextInt(256);
    private Color color = new Color(R,G,B);
    public void setAngularSpeed(int m)
    {
        this.angularSpeed = m;
    }
    public void setPosition(double angle)
    {
        angle = Math.toRadians(angle);
        this.x = (int)Math.round(a*Math.cos(angle));
        this.y = (int)Math.round(b*Math.sin(angle));

    }
    public void setCX(int m)
    {
        this.cX = m;
    }
    public void setCY(int m)
    {
        this.cY = m;
    }
    public void setA(int m)
    {
        this.a = m;
    }
    public void setB(int m)
    {
        this.b = m;
    }
    public void setXC(int m)
    {
        this.x = m;
    }
    public void setYC(int m)
    {
        this.y = m;
    }
    public void setCurrentAngle(int m)
    {
        this.currentAngle = m;
    }
    public void setRadius(int m)
    {
        this.radius = m;
    }
    public int getA()
    {
        return this.a;
    }
    public int getB()
    {
        return this.b;
    }
    public int getXC()
    {
        return this.x;
    }
    public int getYC()
    {
        return this.y;
    }
    public int getCurrentAngle()
    {
        return this.currentAngle;
    }
    public int getRadius()
    {
        return this.radius;
    }
    public int getAngularSpeed()
    {
        return this.angularSpeed;
    }
    public void draw(Graphics g)
    {
        int pX;
        int pY;
        int tempX = (radius/2);
        int tempY = (radius/2);

        if(currentAngle>=0 && currentAngle <=90)
        {
            pX =(cX + x-tempX);
            pY = (cY - y-tempY);

        }
        else if(currentAngle>=270 && currentAngle <=360)
        {
            pX =(cX + x-tempX);
            pY =(cY - y-tempY);
        }
        else if(currentAngle>90 && currentAngle <=180)
        {
            pX = (cX + x-tempX);
            pY = (cY - y-tempY);
        }
        else
        {
            pX =(cX + x-tempX);
            pY =(cY - y-tempY);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        g2.fillOval((int)(cX- 80), (int)(cY- 80), 2*80, 2*80);
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(5));
        g2.drawOval((int)(cX-a), (int)(cY-b), (int)(2*a),(int) (2*b));
        g2.setColor(color);
        g2.fillOval((pX),(pY), 2*radius, 2*radius);
        setBackground(Color.BLACK);
        g2.setStroke(new BasicStroke(0));
    }
    public Planet (int a, int b, int angle, int radius, int speed)
    {
        this.a = a;
        this.b = b;
        this.currentAngle = angle;
        this.radius =radius;
        this.setPosition(currentAngle);
        this.angularSpeed = speed;
    }


}
