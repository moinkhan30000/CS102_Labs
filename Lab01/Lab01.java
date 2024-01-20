// Author Moin Khan
// Reference taken from TestData.java from Moddle for exporting txt file 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab01 {
    public static double question1(double x, double y)
    {
        if(x==0)
        {
            return 0;
        }
        else if (y==0)
        {
            return 0;
        }
        else 
        {
            double temp = 1;
            String num1 = "" + x;
            String num2 = "" + y;
            int decimal1 = num1.substring(num1.indexOf(".")+1).length();
            int decimal2 = num2.substring(num2.indexOf(".")+1).length();
            if(decimal1> decimal2)
            {
                for(int i = 1; i<=decimal1; i++)
                {
                    x = x*10;
                }
                for(int i = 1; i<=decimal1; i++)
                {
                    y = y*10;
                }
            }
            else
            {
                for(int i = 1; i<=decimal2; i++)
                {
                    x = x*10;
                }
                for(int i = 1; i<=decimal2; i++)
                {
                    y = y*10;
                }
            }
            int z = 0;
            while( z<=x && z<=y)
            {
                z++;
                if(x%z == 0 && y%z == 0)
                {
                    temp = z;
                }
            }

            if(decimal1> decimal2)
            {
                for(int j = 1; j<=decimal1; j++)
                {
                    temp = temp/10;
                }               
            }
            else
            {
                for(int j = 1; j<=decimal2; j++)
                {
                    temp = temp/10;
                }
            }
            return temp;

    }
        
        
    }
    public static ArrayList<Integer> question2(int a,int b, int x, int y,int z)
    {
        int temp;
        ArrayList<Integer> listOfAnswers = new ArrayList<Integer>();
        int difference = (a-b);
        if(difference < 0)
        {
           difference = difference*(-1);
        }
        for(int i=0; i<= difference; i++)
        {
            if(b>a)
            {
                temp = a+i;
                if(temp % x ==0 && temp % y == 0 && temp % z ==0)
                {
                    listOfAnswers.add(temp);
                }

            }
            else if (a>b)
            {
                temp = b+i;
                if(temp % x ==0 && temp % y == 0 && temp % z ==0)
                {
                    listOfAnswers.add(temp);
                }

            }
        }
        return listOfAnswers;
    }
    public static int question3(int l, int d)
    {
        // Because age of father can never be less than that of the daughter.
        if(l>d && d!=0)
        {
            int x = l-2*d;
            return x;
        }
        else return 0;
        
    }
    public static void main(String[] args) throws IOException
    {
        int control = 0;
        Scanner input = new Scanner(System.in);
        while(control<5)
        {
            System.out.print("1 : Find the the distance to plant Roses equally Spaced in a flowerbed with X and ");
            System.out.println("Y Dimensions\n    with Plants in every Corner with as little as possible space Consumed.");
            System.out.println("2 : Find whole numbers between A and B divisible by X, Y, and Z.");
            System.out.println("3 : If Louise is X years old. Her daughter is Y years old. In how many years will Louise be \n    double her daughter's age?");
            System.out.println("4 : Generate 5 random questions from the 3 problem templates with their solution and export it as a txt file.");
            System.out.println("5 : Exit the Program.");
            System.out.println();
            System.out.print("Enter your choice as a number : ");
            control = input.nextInt();
            if(control==1)
            {
                double x;
                double y;
                double distance;
                System.out.println("Enter the First Dimension of Flowerbed X");
                x = input.nextDouble();
                System.out.println("Enter the Second Dimension of Flowerbed Y");
                y = input.nextDouble();
                distance = question1(x, y);
                if(distance == 0)
                {
                    System.out.println("Either X or Y is 0 which is not possible in dimensions of a Flowerbed. Please Try again with proper values.");
                }
                else
                {
                    System.out.println("The distance to Plant The Roses is " + distance + ".");
                    System.out.println();
                }
                

            }
            else if (control == 2)
            {
                int x;
                int y;
                int z;
                int a;
                int b;
                ArrayList<Integer> listOfAnswers = new ArrayList<Integer>();   
                System.out.print("Enter A : ");
                a = input.nextInt();
                System.out.print("Enter B : ");
                b = input.nextInt();
                System.out.print("Enter X : ");
                x = input.nextInt();
                System.out.print("Enter Y : ");
                y = input.nextInt();
                System.out.print("Enter Z : ");
                z = input.nextInt();
                listOfAnswers = question2(a, b, x, y, z);
                if (listOfAnswers.isEmpty())
                {
                    System.out.println("There are no whole numbers divisible by X,Y,Z between A and B");
                    System.out.println();
                    System.out.println();
                }
                else
                {
                    System.out.println("Whole numbers between A and B divisible by X,Y,Z are " + listOfAnswers.toString());
                }
            
            }
            else if (control == 3)
            {
                int x;
                int y;
                int result;
                System.out.print("Enter age of Louise X : ");
                x = input.nextInt();
                System.out.print("Enter age of Daughter of Louise Y : ");
                y = input.nextInt();
                result = question3(x, y);
                //This condition is to make sure the equation is not giving out negative result as it does for certain ages as all ages are not solvable. 
                if(result <= 0)
                {
                    System.out.println("Data entered is Incorrect or unsolvable. Please try again with correct Data.");
                    System.out.println();
                }
                else if (result>0)
                {
                    System.out.println("Louise will be double her daughter's age in " + result + " years.");
                    System.out.println();
                }

            }
            else if (control == 4)
            {
                input.nextLine();
                System.out.print("Enter the name of File to Export : ");
                String fileExportName = input.nextLine();
                
                fileExportName = fileExportName + ".txt";
                //Referenced code from TestData.java start here.
                FileWriter fileWrite = new FileWriter (fileExportName);
                BufferedWriter bufferWrite = new BufferedWriter (fileWrite);
                PrintWriter Export = new PrintWriter (bufferWrite);
                //Referenced code from TestData.java ends here.
                Random r = new Random();
                Random r2 = new Random();
                int control2 = 1;
                while(control2<6)
                {
                    int randomInteger = r.nextInt(3);
                    if(randomInteger == 0)
                    {
                        int x;
                        int y;
                        int result;
                        x = r2.nextInt(1000) + 1;
                        y = r2.nextInt(1000) + 1;
                        result = (int) question1(x, y);
                        Export.println("Question "+ control2 + ": Find the distance to plant Roses equally Spaced in a flowerbed with " + x + " and " + y + " Dimensions with Plants in every Corner with as little as possible space Consumed ");
                        Export.println();
                        Export.println("Answer "+ control2 + ": The distance to Plant The Roses is " + result + ".");
                        Export.println();
                    }
                    else if(randomInteger == 1)
                    {
                        int x=0;
                        int y=0;
                        int z=0;
                        int a=0;
                        int b=0;
                        ArrayList<Integer> listOfAnswers = new ArrayList<Integer>();
                        int temp = 0;
                        while(temp == 0)
                        {     
                            a = r2.nextInt(1000);
                            b = r2.nextInt(1000);
                            x = r2.nextInt(100) + 1;
                            y = r2.nextInt(100) + 1;
                            z = r2.nextInt(100) + 1;
                            listOfAnswers = question2(a, b, x, y, z);
                            if(listOfAnswers.isEmpty())
                            {
                                temp = 0;
                            }
                            else
                            {
                                temp = 1;
                            }

                        }
                        Export.println("Question "+ control2 + ": Find whole numbers between "+ a +" and "+ b +" divisible by "+ x +", "+ y +", and "+ z +".");
                        Export.println();
                        Export.println("Answer "+ control2 + ": Whole numbers between " + a + " and " + b + " divisible by "+ x +", "+ y +", and "+ z + " are " + listOfAnswers.toString() );
                        Export.println();

                    }
                    else if(randomInteger == 2)
                    {
                        int temp = 0;
                        int x = 0;
                        int y = 0;
                        int answer = 0;
                        while(temp == 0)
                        {
                            x = r2.nextInt(100) + 18;
                            y = r2.nextInt(100) + 1;
                            answer = question3(x, y);
                            if(answer <= 0)
                            {
                                temp = 0;
                            }
                            else
                            {
                                temp = 1;
                            }
                        }
                        Export.println("Question "+ control2 + ": If Louise is "+ x +" years old. Her daughter is "+ y +" years old. In how many years will Louise be double her daughter's age?");
                        Export.println();
                        Export.println("Answer "+ control2 + ": Louise will be double her daughter's age in " + answer + " years.");
                        Export.println();
                    }
                    control2++;

                }
                System.out.println();
                System.out.println("File Exported Sucessfully");
                System.out.println();
                Export.close();   
            }
        }
        System.out.println("Program Closed Succesfully");
        input.close();
    }
}

