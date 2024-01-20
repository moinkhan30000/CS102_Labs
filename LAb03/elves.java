//Author : Moin Khan
import java.util.Random;

public class elves extends character implements rogue,mage {
    public void calculateMP()
    {
        int x = getHp() - 10 ;
        setMp(x);
    }
    public void calculateSpeed()
    {
        int x = getLevel() + 4;
        setSpeed(x);
    }
    public elves()
    {
        super();
        this.setCharacterRace("Elve");
    }
    public boolean manaRestore()
    {
        boolean flag = false;
        int x = this.getLevel();
        x = x*2;
        int y = this.getCurrentMp();
        y = y + x;
        if(y>=this.getMp())
        {
            this.setCurrentMp(this.getMp());
        }
        else
        {
            setCurrentMp(y);
        }
        this.decreaseCurrentHp(2);
        System.out.println("Mana Restore Ability Used-> " + x + " MP to add in Current MP at the cost of 2 HP");
        flag = true;
        return flag;
    }
    public boolean rogueAbilities(character x , int y)
    {
        this.calculateSpeed();
        x.calculateSpeed();
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Rogue") && this.getCharacterRace().equalsIgnoreCase("Elve"))
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
            //Mana Restore Ability
            else if(y==3)
            {
                flag = manaRestore();
                return flag;
            }
            //Quick Attack Ability
            else if (y==4)
            {
                if(this.getCurrentMp()>=2)
                {
                    setSpeed(-1);
                    int attack = getBaseAttack();
                    x.decreaseCurrentHp(attack);
                    int z = this.getCurrentMp();
                    z = z-2;
                    this.setCurrentMp(z);
                    System.out.println("Quick Attack Used (Makes Your Attack Hit First Unless used by Other Side as Well) -> " + attack + " HP lost at the cost of 2 MP ");
                    flag = true;
                    return flag;
                }
                else
                {
                    System.out.println("You do not have enough MP for this ability, choose another abaility");
                }     
            }
            //Shoot Arrow Ability
            else if(y==5)
            {
                int z = this.getBaseAttack() + this.getSpeed() + 2;
                x.decreaseCurrentHp(z);
                if (x.getCurrentHp() > 0)
                {
                    this.decreaseCurrentHp(3);
                }
                System.out.println("Shoot Arrow Ability Used -> " + z + " HP lost at Cost of 3 HP unless Opponet has Lost");
                flag = true;
                return flag;
            }
            flag = false;
            return flag;
        }
        flag =false;
        return flag;
    }
    public boolean mageAbilities(character x , int y)  
    {
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Mage") && this.getCharacterRace().equalsIgnoreCase("Elve"))
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
            //Mana Restore Ability
            else if(y==3)
            {
                flag = manaRestore();
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
                if(this.getCurrentMp()>=8)
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
        flag =false;
        return flag;
    }
    public elves randomElve(character p)
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
        elves c = new elves();
        c.setLevel(l);
        c.calculateValues();
        if (selectClass == 0 )
        {
            c.setcharacterClass("Rogue");
        }
        else if (selectClass == 1)
        {
            c.setcharacterClass("Mage");
        }
        return c;
    }
    public boolean useAbilities(character x , int y)
    {
        boolean flag2;
        boolean flag3;
        flag2 = this.mageAbilities(x , y );
        if(flag2 == true)
        {
            return flag2;
        }
        flag3 = this.rogueAbilities(x, y);
        if(flag3 == true)
        {
            return flag3;
        }
        return flag2;
    }
}
