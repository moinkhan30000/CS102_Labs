
import java.util.Random;

public class dwarfs extends character implements fighter,mage {
    public void calculateHp()
    {
        int x = 40 + this.getLevel();
        setHP(x);      
    }
    public void calculateMP()
    {
        int x = 10 + this.getLevel();
        setMp(x);
    }
    public void calculateSpeed()
    {
        double x = (double) this.getLevel()/2 + 1;
        int y = (int) Math.round(x);
        setSpeed(y);
    }
    public dwarfs()
    {
        super();
        this.setCharacterRace("Dwarf");
    }
    public boolean restAbility()
    {
        boolean flag;
        if(this.getCurrentMp()>8)
        {
            increaseCurrentHp(20);
            int x = getCurrentMp();
            x = x- 7;
            setCurrentMp(x);
            System.out.println("Rest Ability Used -> 20 HP restored to Current HP at the cost of 7 MP");
            flag = true;
            return flag;    
        }
        else
        {
            System.out.println("You do not have enough MP for this ability, choose another abaility");  
        }
        flag =false;
        return flag;
    }
    public boolean fighterAbilities(character x , int y)
    {
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Fighter") && this.getCharacterRace().equalsIgnoreCase("Dwarf"))
        {
            //Attack Ability
            if(y==1)
            {
                flag = attackAbility(x);
                return flag;
            }
            // Defend Ability
            else if(y==2)
            {
                flag =defendAbility();
                return flag;
            }
            //Rest Ability
            else if(y==3)
            {
                flag = restAbility();
                return flag;
            }
            //Slash Ability
            else if(y == 4)
            {
                if(this.getCurrentMp() >=5)
                {
                    int z = this.getBaseAttack();
                    z = z*2;
                    x.decreaseCurrentHp(z);
                    z = this.getCurrentMp();
                    z = z-5;
                    this.setCurrentMp(z);
                    System.out.println("Slash Ability Used -> " + this.getBaseAttack()*2 + " HP Lost at the cost of 5 MP");
                    flag = true;
                    return flag;
                }
                else
                {
                System.out.println("You do not have enough MP for this ability, choose another abaility");
                }
            }
            //Burst Ability
            else if (y==5)
            {
                if(this.getCurrentMp()>0)
                {
                    int z = this.getCurrentMp();
                    z = z*3;
                    x.decreaseCurrentHp(z);
                    this.setCurrentMp(0);
                    flag = true;
                    System.out.println("Burst Ability Used -> " + z + " HP lost  at the cost of ALL MP");
                    return flag;
                }
                else
                {
                    System.out.println("You do not have enough MP for this ability, choose another abaility");
                }
            } 
            flag = false;
            return flag;
        }
        flag = false;
        return flag;
    } 
    public boolean mageAbilities(character x , int y)  
    {
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Mage") && this.getCharacterRace().equalsIgnoreCase("Dwarf"))
        {
            //Attack Ability
            if(y==1)
            {
                int attack = this.getBaseMagic();
                x.decreaseCurrentHp(attack);
                System.out.println("Attack Ability Used->  Loss of " + this.getBaseMagic() + " HP");
                flag = true;
                return flag;

            }
            // Defend Ability
            else if(y==2)
            {
                flag =defendAbility();
                return flag;
            }
            //Rest Ability
            else if(y==3)
            {
                flag = restAbility();
                return flag;
            }
            // Fire Ability
            else if ( y == 4)
            {
                if(this.getCurrentMp() >= 2)
                {
                    int speed1 = this.getSpeed();
                    int speed2 = x.getSpeed();
                    int maxSpeed = 0;
                    if(speed1 > speed2)
                    {
                        maxSpeed = speed1;
                    }
                    else if (speed2 > speed1)
                    {
                        maxSpeed = speed2;
                    }  
                    int damage = maxSpeed*3;
                    x.decreaseCurrentHp(damage);
                    int z = this.getCurrentMp();
                    z = z-2;
                    this.setCurrentMp(z);
                    System.out.println("Fire Ability Used-> " + damage + " HP lost at the cost of 2 MP");
                    flag = true;
                    return flag;
                }
                else
                {
                    int speed1 = this.getSpeed();
                    int speed2 = x.getSpeed();
                    int maxSpeed = 0;
                    if(speed1 > speed2)
                    {
                        maxSpeed = speed1;
                    }
                    else if (speed2 > speed1)
                    {
                        maxSpeed = speed2;
                    }
                    int damage = maxSpeed*3;
                    x.decreaseCurrentHp(damage);
                    if(x.getCurrentHp()>0)
                    {
                        this.decreaseCurrentHp(3);
                    }
                    System.out.println("Fire Ability Used-> " + damage + " HP lost at the cost of 3 HP");
                    flag = true;
                    return flag;
                }
            }
            //Thunder Ability
            else if( y == 5)
            {
                if(this.getCurrentMp()>8)
                {
                    int damage = this.getBaseMagic() * 2;
                    x.decreaseCurrentHp(damage);
                    int z = this.getCurrentMp();
                    z = z-8;
                    this.setCurrentMp(z);
                    System.out.println("Thunder Ability Used -> " + damage +" HP lost at the cost of 8 MP");
                    flag = true;
                    return flag;
                }
                else
                {
                    System.out.println("You do not have enough MP for this ability, choose another abaility");
                }
            }
            // Blizzard Ability
            else if (y==6)
            {
                int check = this.getCurrentHp()+ this.getCurrentMp();
                if(check >= 12)
                {
                    x.decreaseCurrentHp(12);
                    int z = this.getCurrentMp();
                    z = z-12;
                    if(z>=0)
                    {
                        this.setCurrentMp(z);
                    }
                    else if(z<0)
                    {
                        z= z*(-1);
                        this.decreaseCurrentHp(z);
                        this.setCurrentMp(0);
                    }
                    System.out.println("Blizzard Ability Used -> " + 12 + " HP lost by Opponent at the cost of 12 MP or combination of HP and MP equivalent of 12");
                    flag = true;
                    return flag;
                }
                else
                {
                    System.out.println("You do not have enough MP or a combination of MP and HP for this ability, choose another abaility");
                }
            }
            flag = false; 
            return flag;   
        }
        flag = false;
        return flag;
    }
    public dwarfs randomDwarfs(character p)
    {
        Random random = new Random();
        int y = random.nextInt(2);
        int l = p.getLevel();
        if (y==0)
        {
            if(l-1!=0)
            {
                l = l-1;
            }
        }
        int selectClass = random.nextInt(2);
        dwarfs c = new dwarfs();
        c.setLevel(l);
        c.calculateValues();
        if(selectClass == 0)
        {
            c.setcharacterClass("Fighter");
        }
        else if (selectClass == 1)
        {
            c.setcharacterClass("Mage");
        }
        return c;
    }
    public boolean useAbilities(character x , int y)
    {
        boolean flag;
        boolean flag2;
        flag = this.fighterAbilities(x , y);
        if(flag == true)
        {
            return flag;
        }
        flag2 = this.mageAbilities(x , y );
        if(flag2 == true)
        {
            return flag2;
        }
        return flag;
    }
}
