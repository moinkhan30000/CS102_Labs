//Author : Moin Khan
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class VerbDictionary {
    ArrayList<Verb> verbObjects = new ArrayList<Verb>();
    void processDictionary(String NameOfFile) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(NameOfFile)) ;
        Verb x;
        while(input.hasNext())
        {
            String j = input.nextLine();
            ArrayList<String> verbsForms = new ArrayList<String>();
            StringTokenizer token = new StringTokenizer(j,"\t ");
            while(token.hasMoreTokens())
            {
                verbsForms.add(token.nextToken());
            }
            x = new Verb(verbsForms.get(0), verbsForms.get(1), verbsForms.get(2), verbsForms.get(3), verbsForms.get(4));
            verbObjects.add(x);
            verbsForms.removeAll(verbsForms);
        }
    }
    int findVerbIndex(String word) throws FileNotFoundException
    {
        
        int z = verbObjects.size();
        boolean flag = false;
        Verb x;
        int index = -1;
        for(int i = 0; i < z; i++)
        {
            x = verbObjects.get(i);
            flag = x.checkString(word);
            if ( flag == true)
            {
                index = i;
            }
        }
       return index;
    }
    VerbDictionary() throws FileNotFoundException
    {
        processDictionary("verbs-dictionaries.txt");
    }
   
}
