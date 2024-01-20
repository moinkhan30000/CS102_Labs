public class Room {
    private int securityLevel;
    private String nameOfRoom;
    private int BreachFlag = 0;
    private String[] reference = new String[10];
    public void initialize()
    {
        for(int i = 0; i<10; i++)
        {
            reference[i] = "";
        }
    }

    private int index = 0;
    public void setSecurityLevel(int x)
    {
        this.securityLevel = x;
    }
    public void setBreachFlag(int x)
    {
        this.BreachFlag = x;
    }
    public void setName(String x)
    {
        this.nameOfRoom = x;
    }
    public void setRefernce(String x)
    {
        if(index<10)
        {
            for(int i = 0; i<10; i++)
            {
                if(!(reference[i].equalsIgnoreCase(x)))
                {
                    this.reference[index] = x;
                }

            }
            index++;
        }


    }
    public int getSecurityLevel()
    {
        return this.securityLevel;
    }
    public String getName()
    {
        return this.nameOfRoom;
    }
    public String[] getReference()
    {
        return this.reference;
    }
    public int getBrachFlag()
    {
        return this.BreachFlag;
    }


}
