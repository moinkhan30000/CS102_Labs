//Author : Moin Khan
import java.util.Random;
import java.util.Scanner;
public class character {
    private int level;
    private int hp;
    private int mp;
    private int speed;
    private int baseAttack;
    private int baseMagic;
    private int currentHp;
    private int currentMp;
    private String characterClass;
    private String characterRace;
    private int autoBattle;
    Scanner input1 = new Scanner(System.in);
    public character()
    {
        level = 1;
        autoBattle = 2;
        characterClass = "";
        characterRace = "";
        calculateValues();
        currentHp = hp;
        currentMp = mp;
    }
    public int getAutoBattle()
    {
        return this.getAutoBattle();
    }
    public String getCharacterRace()
    {
        String x = this.characterRace;
        return x;
    }
    public String getcharacterClass()
    {
        String x = this.characterClass;
        return x;
    }
    public int getLevel()
    {
        int x = this.level;
        return x;
    }
    public int getHp()
    {
        int x = this.hp;
        return x;
    }
    public int getMp()
    {
        int x = this.mp;
        return x;
    }
    public int getSpeed()
    {
        int x = this.speed;
        return x;
    }
    public int getBaseAttack()
    {
        int x = this.baseAttack;
        return x;
    }
    public int getBaseMagic()
    {
        int x = this.baseMagic;
        return x;
    }
    public int getCurrentHp()
    {
        int x = this.currentHp;
        return x;
    }
    public int getCurrentMp()
    {
        int x = this.currentMp;
        return x;
    }
    public void setcharacterClass(String x)
    {
        this.characterClass = x;
    }
    public void setCharacterRace(String x)
    {
        this.characterRace = x;
    }
    public void setHP(int x)
    {
        this.hp = x;
    }
    public void setMp(int x)
    {
        this.mp = x;
    }
    public void setSpeed(int x)
    {
        this.speed = x;
    }
    public void setLevel(int x)
    {
        this.level = x;
        this.calculateHp();
        this.calculateMP();
        this.calculateSpeed();
        int updateHp = this.getHp()*10/100;
        int updateMP = this.getMp()*10/100;
        if(this.getHp() > this.getCurrentHp() + updateHp)
        {
            this.setCurrentHp(this.getCurrentHp() + updateHp);
        }
        if(this.getMp() > this.getCurrentMp() + updateMP)
        {
            this.setCurrentMp(this.getCurrentMp() + updateMP);
        }

    }
    public void setBaseAttack(int x)
    {
        this.baseAttack = x;
    }
    public void setBaseMagic(int x)
    {
        this.baseMagic = x;
    }
    public void setCurrentHp(int x)
    {
        this.currentHp = x;
    }
    public void setCurrentMp(int x)
    {
        this.currentMp = x;
    }
    public void setAutoBattle(int x)
    {
        this.autoBattle = x;
    }
    public void increaseCurrentHp(int x)
    {
        int temp = currentHp;
        temp = temp + x;
        if(temp <= hp)
        {
            currentHp = temp;
        }
        else if (temp >hp)
        {
            currentHp = hp;
        }
    }
    public void decreaseCurrentHp(int x)
    {
        int minHp = 0;
        int temp = currentHp;
        temp = temp - x;
        if(temp >= minHp)
        {
            currentHp = temp;
        }
        else if (temp < minHp)
        {
            currentHp = minHp;
        }
    }
    public void increaseLevel()
    {
        this.level = this.level +1;
    }
    public void calculateHp()
    {
        int x = getLevel();
        this.hp = 20 + (4*x);
    }
    public void calculateMP()
    {
        double tempMp;
        tempMp =(double) this.hp/2;
        tempMp = Math.round(tempMp);
        this.mp = (int) tempMp;
    }
    public void calculateBaseAttack()
    {
        double tempAttack;
        tempAttack = (double) this.hp/10 +1;
        this.baseAttack = (int) tempAttack;
    }
    public void calculateBaseMagic()
    {
        double tempMagic;
        tempMagic = (double) this.mp/10 +1;
        this.baseMagic = (int) tempMagic;
    }
    public void calculateSpeed()
    {
        this.speed = this.level;
    }
    public boolean attackAbility(character x)
    {
        boolean flag;
        //Attack Ability
        int attack = baseAttack;
        x.decreaseCurrentHp(attack);
        flag = true;
        System.out.println("Attack Ability Used->  Loss of " + this.getBaseAttack() + " HP");
        return flag;    
        

    }
    public boolean defendAbility()
    {
        boolean flag =false;
        int hp = getHp();
        int chp = hp*10/100;
        this.increaseCurrentHp(chp);
        flag = true;
        System.out.println("Recovered " + chp + "HP by Use of Defend Ability ");
        return flag;
    }
    public void calculateValues()
    {
        calculateHp();
        calculateMP();
        calculateBaseAttack();
        calculateBaseMagic();
        calculateSpeed();
    }
    public int checkSpeed(character x)
    {
        int c = 0;
        int s1 = this.getSpeed();
        int s2 = x.getSpeed();
        if ((s1 != -1 && s2 != -1) || (s1 == -1 && s2 == -1))
        {
            if(s1 > s2)
            {
                c=1;
            }
            else if(s2>s1)
            {
                c=2;
            }
            else if(s2== s1)
            {
                c = 1;
            }
        }
        else if (s1 ==-1)
        {
            c = 1;
        }
        else if (s2 == -1)
        {
            c = 2;
        }
        else if ((s1 == s2) && !(s1 == -1 && s2 == -1))
        {
            c = 1;
        }
        return c;
    }   
public void showStats(character x)
{
    this.calculateSpeed();
    x.calculateSpeed();
    System.out.println(" Player Stats \n Level : " + this.getLevel());
    System.out.println(" Race : " + this.getCharacterRace() + " / " + " Class : " + this.getcharacterClass());
    System.out.println(" HP : " + this.getCurrentHp() + "/" + this.getHp());
    System.out.println(" MP : " + this.getCurrentMp() + "/" + this.getMp());
    System.out.println(" Speed : " + this.getSpeed());
    System.out.println(" Base Attack : " + this.getBaseAttack());
    System.out.println(" Base Magic : " + this.getBaseMagic());
    System.out.println(" Opponent Stats \n Level : " + x.getLevel());
    System.out.println(" Race : " + x.getCharacterRace() + " / " + " Class : " + x.getcharacterClass());
    System.out.println(" HP : " + x.getCurrentHp() + "/" + x.getHp());
    System.out.println(" MP : " + x.getCurrentMp() + "/" + x.getMp());
    System.out.println(" Speed : " + x.getSpeed());
    System.out.println(" Base Attack : " + x.getBaseAttack());
    System.out.println(" Base Magic : " + x.getBaseMagic());

}
public int userInput()
{
    int y = 0;
    Random random = new Random();
    if(this.getcharacterClass().equalsIgnoreCase("Fighter") && this.getCharacterRace().equalsIgnoreCase("Human"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Struggle Ability \n 4 : Slash Ability \n 5 : Burst Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(6);
        }
    }
    else if(this.getcharacterClass().equalsIgnoreCase("Rogue") && this.getCharacterRace().equalsIgnoreCase("Human"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Struggle Ability \n 4 : Quick Attack Ability \n 5 : Shoot Arrow Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(6);
        }

    }
    else if(this.getcharacterClass().equalsIgnoreCase("Mage") && this.getCharacterRace().equalsIgnoreCase("Human"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Struggle Ability \n 4 : Fire Ability \n 5 : Thunder Ability \n 6 : Blizzard Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(7);
        }

    }
    else if(this.getcharacterClass().equalsIgnoreCase("Rogue") && this.getCharacterRace().equalsIgnoreCase("Elve"))
    { 
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Mana Restore Ability \n 4 : Quick Attack Ability \n 5 : Shoot Arrow Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(6);
        }

    }
    else if(this.getcharacterClass().equalsIgnoreCase("Mage") && this.getCharacterRace().equalsIgnoreCase("Elve"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Mana Restore Ability \n 4 : Fire Ability \n 5 : Thunder Ability \n 6 : Blizzard Ability \n Enter Your Selection : ");
            y =input1.nextInt();  
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(7);
        }

    }
    else if(this.getcharacterClass().equalsIgnoreCase("Fighter") && this.getCharacterRace().equalsIgnoreCase("Dwarf"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Rest Ability \n 4 : Slash Ability \n 5 : Burst Ability \n Enter Your Selection : ");
            y =input1.nextInt(); 
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(6);
        }

    }
    else if(this.getcharacterClass().equalsIgnoreCase("Mage") && this.getCharacterRace().equalsIgnoreCase("Dwarf"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Rest Ability \n 4 : Fire Ability \n 5 : Thunder Ability \n 6 : Blizzard Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(7);
        }  
    }
    else if(this.getcharacterClass().equalsIgnoreCase("Fighter") && this.getCharacterRace().equalsIgnoreCase("HalfLing"))
    {
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Second breakfast Ability \n 4 : Mimic Ability \n 5 : Slash Ability \n 6 : Burst Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(7);
        }     
    }
    else if(this.getcharacterClass().equalsIgnoreCase("Rogue") && this.getCharacterRace().equalsIgnoreCase("HalfLing"))
    { 
        if(autoBattle == 2)
        {
            System.out.print(" 1 : Attack Ability \n 2 : Defend Ability \n 3 : Second breakfast Ability \n 4 : Mimic Ability  \n 5 : Quick Attack Ability \n 6 : Shoot Arrow Ability \n Enter Your Selection : ");
            y =input1.nextInt();
        }
        else if(autoBattle == 1)
        {
            y = random.nextInt(7);
        }  


    } 
    return y;        
}
}

interface fighter
{
    public boolean fighterAbilities(character x , int y );
}
interface rogue
{
    public boolean rogueAbilities(character x , int y);
}
interface mage
{
    public boolean mageAbilities(character x , int y);
}

