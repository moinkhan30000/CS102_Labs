//Author : Moin Khan
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;

public class InputDocument {
    int size = 6710;
    int[] verbCount = new int [size];
    double[] frequencies = new double[size];
    VerbDictionary y = new VerbDictionary();
    String fileName;
    int totalVerbCount = 0;  
    InputDocument(String fileName) throws FileNotFoundException
    {
        int index;
        this.fileName = fileName;
        Scanner input = new Scanner(new File(fileName), "UTF-8");
        while(input.hasNext())
        {
            String j = input.nextLine();
            ArrayList<String> wordToCheck = new ArrayList<String>();
            StringTokenizer token = new StringTokenizer(j," \t.,;?!()[]{}'\"“”");
            while(token.hasMoreTokens())
            {
                wordToCheck.add(token.nextToken());
            }
            for(int i = 0; i < wordToCheck.size(); i++)
            {
                index = y.findVerbIndex(wordToCheck.get(i));
                if(index!=-1)
                {
                    verbCount[index] = verbCount[index] + 1 ;
                }
            }
            wordToCheck.removeAll(wordToCheck);
        }
        for(int i = 0; i<size; i++)
        {
            totalVerbCount = totalVerbCount + verbCount[i];
        }
    }
    void printTop5()  
    {
        int[] max = new int[5] ;
        int[] index = new int[5];
        int tempMax;
        int j = 0;
        int control = 0;
        int[] verbCountTemp = new int[size];
        for(int i = 0; i<verbCount.length; i++)
        {
            verbCountTemp[i] = verbCount[i];
        }
        tempMax = verbCountTemp[0];
        for (j = 0; j<5; j++)
        {
            for (int i = 0; i < verbCountTemp.length; i++)
            {
                if(tempMax < verbCountTemp[i])
                {
                    tempMax = verbCountTemp[i];
                    control = i;
                }
            }
            index[j] = control;
            verbCountTemp[control] = 0;
            max[j] = tempMax;
            tempMax = 0;
        }
        for (j = 0; j<5; j++)
        {
            System.out.print("\"" + y.verbObjects.get(index[j]).verb + "\": " + max[j] + "," );
        }
        System.out.println();

       
    }
    double getFrequency(int verbIndex)
    {
        double frequency;
        int index = verbIndex;
        frequency = (double)verbCount[index]/totalVerbCount;
        return frequency;
    }
    void calculateAllFrequencies()
    {
        for(int i =0; i < size; i++)
        {
            frequencies[i] = getFrequency(i);
        }
    }
    double calculateDissimilarity(InputDocument other)
    {
        double dissimilarity = 0;
        for(int i = 0; i < size; i++)
        {
            double difference = (frequencies[i] - other.frequencies[i]);
            if(difference < 0)
            {
                difference = difference*(-1);
            }
            dissimilarity = dissimilarity + difference;
        }
        return dissimilarity;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int w;
        int x;
        int y;
        int z;

        VerbDictionary s = new VerbDictionary();
        z = s.findVerbIndex("abandon");
        y = s.findVerbIndex("abandoned");
        x = s.findVerbIndex("enjoying");
        w = s.findVerbIndex("notaverb");
        System.out.println("Index of abandon is " + z + ".");
        System.out.println("Index of abandoned is " + y + ".");
        System.out.println("Index of enjoying is " + x + ".");
        System.out.println("Index of notaverb is " + w + ".");

        int numberOFDocuments = 10;
        InputDocument document[] = new InputDocument[numberOFDocuments];
        String nameOfDocument;
        for(int i = 0; i<numberOFDocuments; i++)
        {
            nameOfDocument = i + ".txt";
            document[i] = new InputDocument(nameOfDocument);
            System.out.print(i + ": ");
            document[i].printTop5();
            document[i].calculateAllFrequencies();
        }
        double result;
        System.out.println("Dissimilarity matrix:");
        System.out.println("N 0      1      2      3      4      5      6      7      8      9      ");
        for(int i = 0; i<numberOFDocuments; i++)
        {
            System.out.print(i + " " );
            for(int j=0; j<numberOFDocuments; j++)
            {
                result = document[i].calculateDissimilarity(document[j]);
                System.out.print(String.format("%,.4f", result));
                System.out.print(" ");
                
            }    
            System.out.println();
        }


    } 
} 
