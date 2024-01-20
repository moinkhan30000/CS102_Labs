//Author : Moin Khan
import java.io.FileNotFoundException;
public class Verb {
    String verb;
    String[] verbArray = new String [4];
    Verb(String a, String b ,String c, String d, String e) throws FileNotFoundException
    {
        this.verb = a;
        this.verbArray[0] = b;
        this.verbArray[1] = c;
        this.verbArray[2] = d;
        this.verbArray[3] = e;
    }
    boolean checkString(String x)
    {
        boolean j = false;
        if (this.verb.equalsIgnoreCase(x))
        {
            j = true;
        }
        else
        {
            for(int i = 0; i<this.verbArray.length; i++)
            {
                if (this.verbArray[i].equalsIgnoreCase(x))
                {
                    j = true;
                    return j;
                }
            }
            j = false;
        }
        return j;

    }
}
