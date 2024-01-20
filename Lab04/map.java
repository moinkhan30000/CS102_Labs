import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class map {
    public char mapStore[][]; 
    int rows;
    int col;
    int currentRow = 0;
    int currentCol = 0;
    public  ArrayList<ArrayList<String>> pathStore = new ArrayList<ArrayList<String>>();
    public char[][] readMAp(String fileName) throws FileNotFoundException
    {
        char map[][]; 
        ArrayList<String> temp = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNext())
        {
            temp.add(input.nextLine());
        }
        rows = temp.size();
        col = temp.get(0).length();
        map = new char[rows][col];
        for(int i=0; i <rows; i++)
        {
            String x = temp.get(i);
            for(int j = 0; j<col; j++)
            {
                map[i][j] = x.charAt(j);
            }

        }
        return map;
    }
    public void setMap (String fileName) throws FileNotFoundException
    {
        mapStore = this.readMAp(fileName);
    }
    public void createPath(String fileName) throws FileNotFoundException
    {
        ArrayList<String> temp = new ArrayList<String>();
        String x = fileName.substring(fileName.indexOf("\\") + 1);
        temp.add(x);
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNext())
        {
            temp.add(input.nextLine());
        }
        pathStore.add(temp);
    }
    public void readFromFolder(String foldereName) throws FileNotFoundException
    {
        File file = new File(foldereName);
        File[] address = file.listFiles();
        int size = address.length;
        for(int i = 0; i<size; i++)
        {
            this.createPath(address[i].toString());
        }
    }
    public void printMap()
    {
        int rows = this.mapStore.length;
        int col = this.mapStore[0].length;
        for(int i=0; i< rows; i++)
        {
            for(int j = 0; j < col; j++)
            {
                System.out.print(this.mapStore[i][j]);
            }
            System.out.println();
        }
    }
    public void findStartingPoint()
    {
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<col; j++)
            {
                char temp = mapStore[i][j];
                if(temp == 'S' || temp == 's')
                {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
    }
    public boolean isMovePossible(String move)
    {
        boolean possible;
        int flag = 0;
        char direction = move.charAt(0);
        int tempRow = currentRow;
        int tempCol = currentCol;
        int numberOfMove = Integer.parseInt(move.substring(2));
        for(int i = 0; i<numberOfMove; i++)
        {
            if(direction == 'N')
            {
                tempRow--;
                if(tempRow<0)
                {
                    return possible = false;
                }
                else if(mapStore[tempRow][tempCol] != 'B')
                {
                    flag = 1;
                }
                else
                {
                    return possible = false;
                }
            }
            else if(direction == 'S')
            {
                tempRow++;
                if(tempRow>rows)
                {
                    return false;
                }
                else if(mapStore[tempRow][tempCol] != 'B')
                {
                    flag = 1;
                }
                else
                {
                    return possible = false;
                }  
            }
            else if(direction == 'E')
            {
                tempCol++;
                if(tempCol>col)
                {
                    return possible = false;
                }
                else if(mapStore[tempRow][tempCol] != 'B')
                {
                    flag = 1;
                }
                else
                {
                    return possible = false;
                }  
            }
            else if(direction == 'W')
            {
                tempCol--;
                if(tempCol<0)
                {
                    return possible = false;
                }
                else if(mapStore[tempRow][tempCol] != 'B')
                {
                    flag = 1;
                }
                else
                {
                    return possible = false;
                }     
            }
        }
        if(flag == 1)
        {
            possible = true;
            return possible;
        }
        possible = false;
        return possible;
    }
    public boolean isPathToTreasure(ArrayList<String> x)
    {
        int size = x.size();
        boolean possible;
        String temp;
        for(int i = 1; i< size; i++)
        {
            boolean check;
            temp = x.get(i);
            char direction = temp.charAt(0);
            int numberOfMove = Integer.parseInt(temp.substring(2));
            check = isMovePossible(temp);
            if(check == true)
            {
                if(direction == 'N')
                {
                    currentRow = currentRow - numberOfMove;
                }
                else if(direction == 'S')
                {
                    currentRow = currentRow + numberOfMove;
                }
                else if(direction == 'W')
                {
                    currentCol= currentCol - numberOfMove;
                }
                else if(direction == 'E')
                {
                    currentCol= currentCol + numberOfMove;
                }
            }
        }
        if(mapStore[currentRow][currentCol] == 'T')
        {
            possible = true;
            return possible;
        }
        else
        {
            possible = false;
            return possible;
        }
    }
    public void processPaths() throws FileNotFoundException
    {
        int size = this.pathStore.size();
        for(int i = 0; i<size; i++)
        {
            boolean flag;
            this.findStartingPoint();
            flag = this.isPathToTreasure(this.pathStore.get(i));
            if(flag==true)
            {
                System.out.println(this.pathStore.get(i).get(0)+ " will Lead us to Treasure");
            }
        }  
    }
    public boolean checkPathCombinations(ArrayList<String> x, ArrayList<String> y)
    {
        ArrayList <String> comb = new ArrayList<String>();
        int size1 = x.size();
        for(int i = 0; i<size1; i++)
        {
            comb.add(x.get(i));
        }
        int size2 = y.size();
        for(int i = 1; i<size2; i++)
        {
            comb.add(y.get(i));
        }
        this.findStartingPoint();
        boolean flag = isPathToTreasure(comb);
        if(flag == true)
        {
            System.out.println("Combination of " + x.get(0) + " and " + y.get(0) + " will lead to the Treasure");
        }
        return flag;
    }
    public void processPathCombinations()
    {
        int size = this.pathStore.size();
        for(int i = 0; i<size; i++)
        {
            for(int j = 0 ; j<size; j++)
            {
                this.checkPathCombinations(this.pathStore.get(i), this.pathStore.get(j));
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        map m = new map();
        m.setMap("Map.txt");
        m.readFromFolder("Paths");
        int control = 0 ;
        Scanner input = new Scanner(System.in);
        while(control != 4)
        {
            System.out.println(" Options : \n 1 : Print Map \n 2 : Name of Paths Leading to Treasure \n 3 : Names of Combinations of Paths leading to Treasure \n 4 : Quit");
            System.out.print("Enter Your Choice : ");
            control = input.nextInt();
            if(control == 1)
            {
                m.printMap();
            }
            else if (control == 2)
            {
                m.processPaths();
            }
            else if (control == 3)
            {
                m.processPathCombinations();
            }
            else if (control != 1 && control != 2 && control != 3 && control != 4) 
            {
                System.out.println(" Wrong Option Selected! \n Please Choose Again");
            }
        }
        System.out.println("Program Closed Successfully!");
        input.close();
    }

    
}
