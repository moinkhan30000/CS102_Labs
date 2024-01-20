//Author : Moin Khan
import java.util.Random;

public class human extends character implements rogue,fighter,mage {
    public void calculateHp()
    {
        int y = this.getLevel();
        int x = 35 + (3*y);
        setHP(x);
    }
    public human()
    {
        super();
        this.setCharacterRace("Human");
    }
    public boolean struggle(character x)
    {
        boolean flag; 
        if(this.getCurrentHp() > 10)
        {
            double y = 0.25*this.getHp();
            int z = (int)Math.round(y);
            x.decreaseCurrentHp(z);
            this.decreaseCurrentHp(10);
            System.out.println("Struggle Ability Used -> " + z + " HP lost at the cost of 10 HP of User");
            flag = true;
            return flag;
        }
        else
        {
        System.out.println("You do not have enough MP for this ability, choose another abaility");
        }
        flag = false;
        return flag;

    }
    public boolean fighterAbilities(character x, int y)
    {
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Fighter") && this.getCharacterRace().equalsIgnoreCase("Human"))
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
            //Struggle Ability
            else if(y==3)
            {
                flag = struggle(x);
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
                    flag = true;
                    System.out.println("Slash Ability Used -> " + this.getBaseAttack()*2 + " HP Lost at the cost of 5 MP");
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
    public boolean rogueAbilities(character x, int y)
    {
        this.calculateSpeed();
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Rogue") && this.getCharacterRace().equalsIgnoreCase("Human"))
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
            //Struggle Ability
            else if(y==3)
            {
                flag = struggle(x);
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
                    flag = true;
                    System.out.println("Quick Attack Used (Makes Your Attack Hit First Unless used by Other Side as Well) -> " + attack + " HP lost at the cost of 2 MP ");
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
        flag = false;
        return flag;
    }
    public boolean mageAbilities(character x , int y)  
    {
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Mage") && this.getCharacterRace().equalsIgnoreCase("Human"))
        {
            //Attack Ability
            if(y==1)
            {
                int attack = this.getBaseMagic();
                x.decreaseCurrentHp(attack);
                flag = true;
                System.out.println("Attack Ability Used->  Loss of " + this.getBaseMagic() + " HP");
                return flag = true;
            }
            // Defend Ability
            else if(y==2)
            {
                flag = defendAbility();
                return flag;
            }
            //Struggle Ability
            else if(y==3)
            {
            flag = struggle(x);
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
        else
        {
            flag = false;
            return flag;
        }

    }
    public human randomHuman(character p)
    {
        Random random = new Random();
        int y = random.nextInt(2);
        int selectClass  = random.nextInt(3);
        human c = new human();
        int l = p.getLevel();
        if (y==0)
        {
            if(l-1!=0)
            {
                l = l-1;
            }
        }
        c.setLevel(l);
        c.calculateValues();
        if(selectClass == 0)
        {
            c.setcharacterClass("Fighter");
        }
        else if (selectClass == 1 )
        {
            c.setcharacterClass("Rogue");
        }
        else if (selectClass == 2)
        {
            c.setcharacterClass("Mage");
        }
        return c;   
    }
    public boolean useAbilities(character x , int y)
    {
        boolean flag;
        boolean flag2;
        boolean flag3;
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
        flag3 = this.rogueAbilities(x, y);
        if(flag3 == true)
        {
            return flag3;
        }
        return flag;
    }
    public static void main(String[] args) {
        human x = new human();
        //human y = new human();
        x.setcharacterClass("Mage");
        elves y = new elves();
        y.setcharacterClass("Rogue");
        System.out.println(x.useAbilities(y, 1));
    }
}


