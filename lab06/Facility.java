import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Facility {
    private int totaleNoOfRooms;
    public Room[] Rooms;
    public void setTotalNoOfRooms(int x)
    {
        this.totaleNoOfRooms = x;
    }
    public int getTotalNoOfRooms()
    {
        return this.totaleNoOfRooms;
    }
    public void importfile(String fileName) throws FileNotFoundException
    {
        int size;
        int arrSize;
        ArrayList <String> temp = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNextLine())
        {
            temp.add(input.nextLine());
        }
        size = Integer.parseInt(temp.get(0));
        arrSize = temp.size();
        Rooms = new Room[size];
        for(int i=1; i<=size; i++)
        {
            Room x = new Room();
            x.initialize();
            int length = temp.get(i).indexOf(" ");
            x.setName(temp.get(i).substring(0,length));
            x.setSecurityLevel(Integer.parseInt(temp.get(i).substring(length+1)));
            for(int j = size+1; j<arrSize; j++)
            {
                int index = temp.get(j).indexOf("-");
                String first = temp.get(j).substring(0,index);
                String second = temp.get(j).substring(index+1);
                if(first.equalsIgnoreCase(x.getName()))
                {
                    x.setRefernce(second);
                }
                else if (second.equalsIgnoreCase(x.getName()))
                {
                    x.setRefernce(first);
                }
            }
            Rooms[i-1] = x;
        }
    }
    public void resetRooms()
    {
        int size = Rooms.length;
        for(int i = 0; i<size; i++)
        {
            Rooms[i].setBreachFlag(0);
        }
    }
    public void securityAttack(String roomName, int attackLevel)
    {
        int temp = Rooms.length;
        int index = -1;
        
        for(int i = 0; i<temp; i++)
        {
            if(Rooms[i].getName().equalsIgnoreCase(roomName))
            {
                index = i;
            }
        }
        if(index!=-1)
        {
            if(Rooms[index].getSecurityLevel() < attackLevel && Rooms[index].getBrachFlag()!=1)
            {
                Rooms[index].setBreachFlag(1);
                System.out.print("Security level of Room " + Rooms[index].getName() + ": " + Rooms[index].getSecurityLevel() + " to ");
                Rooms[index].setSecurityLevel(Rooms[index].getSecurityLevel()+1);
                System.out.print(Rooms[index].getSecurityLevel() + "\n");
                System.out.println(Rooms[index].getName() + " is Breached");
                for(int j = 0; j<Rooms[index].getReference().length; j++)
                {
                    securityAttack(Rooms[index].getReference()[j], attackLevel);
                }
            }



        }

    }
    public void simulateAttack(int tries) throws FileNotFoundException
    {
        int room = Rooms.length;
        int randomIndex;
        int x = tries;
        Random random = new Random();
        for(int i = 0; i<x; i++)
        {
            randomIndex = random.nextInt(room);
            securityAttack(Rooms[randomIndex].getName(), i+1);
            resetRooms();
        }
        importfile("sample_input.txt");

        
    }
    public static void main(String[] args) throws FileNotFoundException {
        Facility f =new Facility();
        f.importfile("sample_input.txt");
        f.simulateAttack(15);
        System.out.println();
        f.securityAttack("twrm", 7);
        
    }
}
