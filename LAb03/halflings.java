//Author : Moin Khan
import java.util.Random;

public class halflings extends character implements fighter,rogue {
    public boolean secondBreakfast()
    {
        boolean flag =false;
        int m;
        m = this.getCurrentMp();
        m = m + 5;
        if(m>this.getMp())
        {
            this.setCurrentMp(this.getMp());
        }
        else
        {
            this.setCurrentMp(m);
        }
        this.increaseCurrentHp(5);
        System.out.println("Second BreakFast Ability Used -> It restores 5 MP and 5 HP");
        flag = true;
        return flag;
    }
    public halflings()
    {
        super();
        this.setCharacterRace("HalfLing");
    }
    public boolean mimic(character x)
    {
        boolean flag = false;;
        String race = x.getCharacterRace();
        if(race.equalsIgnoreCase("Human"))
        {
            human h = new human();
            h.setMp(this.getMp());
            h.setHP(this.getHp());
            h.setLevel(this.getLevel());
            h.setSpeed(this.getSpeed());
            h.setBaseAttack(this.getBaseAttack());
            h.setBaseMagic(this.getBaseMagic());
            h.setCurrentHp(this.getCurrentHp());
            h.setCurrentMp(this.getCurrentMp());
            h.setcharacterClass(x.getcharacterClass());
            while(flag == false)
            {
                Random random = new Random();
                int z = random.nextInt(7);
                flag = h.useAbilities(x, z);
            }
            this.setMp(h.getMp());
            this.setHP(h.getHp());
            this.setLevel(h.getLevel());
            this.setSpeed(h.getSpeed());
            this.setBaseAttack(h.getBaseAttack());
            this.setBaseMagic(h.getBaseMagic());
            this.setCurrentHp(h.getCurrentHp());
            this.setCurrentMp(h.getCurrentMp());
            System.out.println("Mimic Ability Used -> It lets you used one random Ability of Opponent");

            return flag;
        }
        else if(race.equalsIgnoreCase("Elve"))
        {
            elves h = new elves();
            h.setMp(this.getMp());
            h.setHP(this.getHp());
            h.setLevel(this.getLevel());
            h.setSpeed(this.getSpeed());
            h.setBaseAttack(this.getBaseAttack());
            h.setBaseMagic(this.getBaseMagic());
            h.setCurrentHp(this.getCurrentHp());
            h.setCurrentMp(this.getCurrentMp());
            h.setcharacterClass(x.getcharacterClass());
            while(flag == false)
            {
                Random random = new Random();
                int z = random.nextInt(7);
                flag = h.useAbilities(x, z);
            }
            this.setMp(h.getMp());
            this.setHP(h.getHp());
            this.setLevel(h.getLevel());
            this.setSpeed(h.getSpeed());
            this.setBaseAttack(h.getBaseAttack());
            this.setBaseMagic(h.getBaseMagic());
            this.setCurrentHp(h.getCurrentHp());
            this.setCurrentMp(h.getCurrentMp());
            System.out.println("Mimic Ability Used -> It lets you used one random Ability of Opponent");

            return flag;    
        }
        else if(race.equalsIgnoreCase("Dwarf"))
        {
            dwarfs h = new dwarfs();
            h.setMp(this.getMp());
            h.setHP(this.getHp());
            h.setLevel(this.getLevel());
            h.setSpeed(this.getSpeed());
            h.setBaseAttack(this.getBaseAttack());
            h.setBaseMagic(this.getBaseMagic());
            h.setCurrentHp(this.getCurrentHp());
            h.setCurrentMp(this.getCurrentMp());
            h.setcharacterClass(x.getcharacterClass());
            while(flag == false)
            {
                Random random = new Random();
                int z = random.nextInt(7);
                flag = h.useAbilities(x, z);
            }
            this.setMp(h.getMp());
            this.setHP(h.getHp());
            this.setLevel(h.getLevel());
            this.setSpeed(h.getSpeed());
            this.setBaseAttack(h.getBaseAttack());
            this.setBaseMagic(h.getBaseMagic());
            this.setCurrentHp(h.getCurrentHp());
            this.setCurrentMp(h.getCurrentMp());
            System.out.println("Mimic Ability Used -> It lets you used one random Ability of Opponent");

            return flag;    
        }
        else if(race.equalsIgnoreCase("HalfLing"))
        {
            halflings h = new halflings();
            h.setMp(this.getMp());
            h.setHP(this.getHp());
            h.setLevel(this.getLevel());
            h.setSpeed(this.getSpeed());
            h.setBaseAttack(this.getBaseAttack());
            h.setBaseMagic(this.getBaseMagic());
            h.setCurrentHp(this.getCurrentHp());
            h.setCurrentMp(this.getCurrentMp());
            h.setcharacterClass(x.getcharacterClass());
            while(flag == false)
            {
                Random random = new Random();
                int z = random.nextInt(7);
                flag = h.useAbilities(x, z);
            }
            this.setMp(h.getMp());
            this.setHP(h.getHp());
            this.setLevel(h.getLevel());
            this.setSpeed(h.getSpeed());
            this.setBaseAttack(h.getBaseAttack());
            this.setBaseMagic(h.getBaseMagic());
            this.setCurrentHp(h.getCurrentHp());
            this.setCurrentMp(h.getCurrentMp());
            System.out.println("Mimic Ability Used -> It lets you used one random Ability of Opponent");
            return flag;    
        }
        flag = false;
        return flag;

    }
    public boolean fighterAbilities(character x , int y)
    {

        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Fighter") && this.getCharacterRace().equalsIgnoreCase("HalfLing"))
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
                flag = defendAbility();
                return flag;
            }
            //Second BreakFast Ability
            else if(y==3)
            {
                flag = secondBreakfast();
                return flag;
            }
            //Mimic Ability
            else if (y==4)
            {
                flag = mimic(x);
                return flag;
            }
            //Slash Ability
            else if(y == 5)
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
            else if (y==6)
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
        flag =false;
        return flag;
    } 
    public boolean rogueAbilities(character x , int y)
    {

        this.calculateSpeed();
        boolean flag;
        if(this.getcharacterClass().equalsIgnoreCase("Rogue") && this.getCharacterRace().equalsIgnoreCase("HalfLing"))
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
            //Second BreakFast Ability
            else if(y==3)
            {
                flag = secondBreakfast();
                return flag;
            }
            else if (y==4)
            {
                flag = mimic(x);
                return flag;
            }
            //Quick Attack Ability
            else if (y==5)
            {
                if(this.getCurrentMp()>=2)
                {
                    this.setSpeed(-1);
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
            else if(y==6)
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
    public halflings randomHalfLings(character p)
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
        halflings c = new halflings();
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
        return c;
    }
    public boolean useAbilities(character x , int y)
    {
        boolean flag;
        boolean flag3;
        flag = this.fighterAbilities(x , y);
        if(flag == true)
        {
            return flag;
        }
        flag3 = this.rogueAbilities(x, y);
        if(flag3 == true)
        {
            return flag3;
        }
        return flag;
    }
}
