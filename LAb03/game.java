//Author : Moin Khan
import java.util.Random;
import java.util.Scanner;
public class game extends character {

    public static void main(String[] args) {
        int controlMenu = 0;
        int auto = 0;
        Scanner input = new Scanner(System.in);
        while(controlMenu!=2)
        {
            System.out.println(" Select an Option ");
            System.out.println("1 : Play Game");
            System.out.println("2 : Quit Game");
            System.out.print("Enter Your Choice : ");
            controlMenu = input.nextInt();
            while(auto != 1 && auto != 2)
            {
                System.out.println(" 1: AutoBattle ON for this Game");
                System.out.println(" 2: AutoBattle OFF for this Game");
                auto = input.nextInt();
                if(auto != 1 && auto != 2)
                {
                    System.out.println("Invalid Option Please Try Again");
                }
            }


            if(controlMenu == 1)
            {
                int choiceRace = 0;
                int choiceClass = 0;
                character p = new character();
                character o = new character();
                human h = new human();
                human enemyH = new human();
                elves e = new elves();
                elves enemyE = new elves();
                dwarfs d = new dwarfs();
                dwarfs enemyD = new dwarfs();
                halflings hl = new halflings();
                halflings enemyHL = new halflings();
                while(!(choiceRace == 1 || choiceRace == 2 || choiceRace == 3 || choiceRace ==4))
                {
                    System.out.println("Character Race 1 : Human    -> Availaible Class : Fighter, Rogue, Mage");
                    System.out.println("Character Race 2 : Elve     -> Availaible Class : Rogue  , Mage       ");
                    System.out.println("Character Race 3 : Dwarf    -> Availaible Class : Fighter, Mage       ");
                    System.out.println("Character Race 4 : HalfLing -> Availaible Class : Fighter, Rogue      ");
                    System.out.print("Select Race by Entering the Number : ");
                    choiceRace = input.nextInt();
                    if(!(choiceRace == 1 || choiceRace == 2 || choiceRace == 3 || choiceRace ==4))
                    {
                        System.out.println("Your choice is Invalid! Please Try Again");
                    }
                }
                if(choiceRace == 1)
                {
                    h = new human();
                    while(!(choiceClass == 1 || choiceClass == 2 || choiceClass == 3))
                    {
                        System.out.println("Class 1 : Fighter");
                        System.out.println("Class 2 : Rogue");
                        System.out.println("Class 3 : Mage");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                        if(!(choiceClass == 1 || choiceClass == 2 || choiceClass == 3))
                        {
                            System.out.println("Your choice is Invalid! Please Try Again");
                        }
                    }
                    if(choiceClass == 1)
                    {
                        h.setcharacterClass("Fighter");
                    }
                    else if (choiceClass == 2)
                    {
                        h.setcharacterClass("Rogue");
                    }
                    else if (choiceClass == 3)
                    {
                        h.setcharacterClass("Mage");
                    }
                    p = h;
                }
                else if (choiceRace == 2)
                {
                    e = new elves();
                    while(!(choiceClass == 1 || choiceClass == 2))
                    {
                        System.out.println("Class 1 : Rogue");
                        System.out.println("Class 2 : Mage");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                        if(!(choiceClass == 1 || choiceClass == 2))
                        {
                            System.out.println("Your choice is Invalid! Please Try Again");
                        }
                    }
                    if (choiceClass == 1)
                    {
                        e.setcharacterClass("Rogue");
                    }
                    else if (choiceClass == 2)
                    {
                        e.setcharacterClass("Mage");
                    }
                    p =e;
                }
                else if (choiceRace == 3)
                {
                    d = new dwarfs();
                    while(!(choiceClass == 1 || choiceClass == 2))
                    {
                        System.out.println("Class 1 : Fighter");
                        System.out.println("Class 2 : Mage");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                        if(!(choiceClass == 1 || choiceClass == 2))
                        {
                            System.out.println("Your choice is Invalid! Please Try Again");
                        }
                    }
                    if (choiceClass == 1)
                    {
                        d.setcharacterClass("Fighter");
                    }
                    else if (choiceClass == 2)
                    {
                        d.setcharacterClass("Mage");
                    }
                    p =d;
                }
                else if (choiceRace == 4)
                {
                    hl = new halflings();
                    while(!(choiceClass == 1 || choiceClass == 2))
                    {
                        System.out.println("Class 1 : Fighter");
                        System.out.println("Class 2 : Rogue");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                        if(!(choiceClass == 1 || choiceClass == 2))
                        {
                            System.out.println("Your choice is Invalid! Please Try Again");
                        }
                    }
                    if (choiceClass == 1)
                    {
                        hl.setcharacterClass("Fighter");
                    }
                    else if (choiceClass == 2)
                    {
                        hl.setcharacterClass("Rogue");
                    }
                    p = hl;
                }
                int health = 1;
                int enemyhealth = 1;
                int winCount = 0;
                int tempLevel = 1;
                while(health!=0)
                {
                    Random random = new Random();
                    int control = random.nextInt(4);
                    if (control == 0)
                    {
                        if(choiceRace == 1)
                        {
                            enemyH = enemyH.randomHuman(h);
                        }
                        else if (choiceRace == 2)
                        {
                           enemyH = enemyH.randomHuman(e);
                        }
                        else if (choiceRace == 3)
                        {
                           enemyH = enemyH.randomHuman(d);
                        }
                        else if (choiceRace == 4)
                        {
                           enemyH = enemyH.randomHuman(hl);
                        }
                        o = enemyH;
                   }
                else if (control == 1)
                {
                    if(choiceRace == 1)
                    {
                        enemyE = enemyE.randomElve(h);
                    }
                    else if (choiceRace == 2)
                    {
                        enemyE = enemyE.randomElve(e);
                    }
                    else if (choiceRace == 3)
                    {
                        enemyE = enemyE.randomElve(d);
                    }
                    else if (choiceRace == 4)
                    {
                        enemyE = enemyE.randomElve(hl);
                    } 
                    o = enemyE; 
                }
                else if (control == 2)
                {
                    if(choiceRace == 1)
                    {
                        enemyD = enemyD.randomDwarfs(h);
                    }
                    else if (choiceRace == 2)
                    {
                        enemyD = enemyD.randomDwarfs(e);
                    }
                    else if (choiceRace == 3)
                    {
                        enemyD = enemyD.randomDwarfs(d);
                    }
                    else if (choiceRace == 4)
                    {
                        enemyD = enemyD.randomDwarfs(hl);
                    }
                    o = enemyD;
                }
                else if (control == 3)
                {
                    if(choiceRace == 1)
                    {
                        enemyHL = enemyHL.randomHalfLings(h);
                    }
                    else if (choiceRace == 2)
                    {
                        enemyHL = enemyHL.randomHalfLings(e);
                    }
                    else if (choiceRace == 3)
                    {
                        enemyHL = enemyHL.randomHalfLings(d);
                    }
                    else if (choiceRace == 4)
                    {
                        enemyHL = enemyHL.randomHalfLings(hl);
                    }
                    o = enemyHL;
                }
                while(!(enemyhealth==0 || health==0)) 
                {
                    int speedSelection = p.checkSpeed(o);
                    boolean flag = false;
                    boolean flag2 = false;
                    //int control2 = 1;
                    int abilityChoice = 0;
                        if(speedSelection == 1)
                        {
                            if(choiceRace == 1 && control == 0)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyH);
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyH, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyH);                
                            }
                            else if(choiceRace == 1 && control == 1)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyE);
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyE, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 = enemyE.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyE);               
                            }
                            else if(choiceRace == 1 && control == 2)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyD);
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyD, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                h.showStats(enemyD);
                                System.out.println(" Used By Player ");
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyD);                
                            }
                            else if(choiceRace == 1 && control == 3)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyHL);
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyHL, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyHL);               
                            }
                            else if(choiceRace == 2 && control == 0)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyH);
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyH, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent "); 
                                e.showStats(enemyH);               
                            }
                            else if(choiceRace == 2 && control == 1)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyE);
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyE, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyE.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyE);                
                            }
                            else if(choiceRace == 2 && control == 2)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyD);
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyD, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyD);               
                            }
                            else if(choiceRace == 2 && control == 3)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyHL);
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyHL, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyHL);                
                            }
                            else if(choiceRace == 3 && control == 0)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyH);
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyH, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");  
                                d.showStats(enemyH);              
                            }
                            else if(choiceRace == 3 && control == 1)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyE);
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyE, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyE.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyE);                
                            }
                            else if(choiceRace == 3 && control == 2)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyD);
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyD, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
            
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyD);                
                            }
                            else if(choiceRace == 3 && control == 3)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyHL);
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyHL, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyHL);               
                            }
                            else if(choiceRace == 4 && control == 0)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyH);
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyH, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyH);               
                            }
                            else if(choiceRace == 4 && control == 1)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyE);
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyE, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyE.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyE);                
                            }
                            else if(choiceRace == 4 && control == 2)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyD);
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyD, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyD);               
                            }
                            else if(choiceRace == 4 && control == 3)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyHL);
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyHL, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyHL);               
                            }
                        }
                        // If opponent is faster or is Going to move first due to an ability speedselection is 0
                        else if(speedSelection == 2)
                        {
                            if(choiceRace == 1 && control == 0)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyH); 
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyH, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyH);               
                            }
                            else if(choiceRace == 1 && control == 1)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 = enemyE.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyE); 
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyE, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyE);              
                            }
                            else if(choiceRace == 1 && control == 2)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyD); 
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyD, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyD);               
                            }
                            else if(choiceRace == 1 && control == 3)
                            {
                                h.setLevel(tempLevel);
                                h.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    h.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(h, choice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                h.showStats(enemyHL); 
                                while(flag == false)
                                {
                                    h.setAutoBattle(auto);
                                    abilityChoice = h.userInput();
                                    flag = h.useAbilities(enemyHL, abilityChoice);
                                    health = h.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                h.showStats(enemyHL);              
                            }
                            else if(choiceRace == 2 && control == 0)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyH); 
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyH, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyH);              
                            }
                            else if(choiceRace == 2 && control == 1)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyE.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyE); 
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyE, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyE);               
                            }
                            else if(choiceRace == 2 && control == 2)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyD);   
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyD, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyD);            
                            }
                            else if(choiceRace == 2 && control == 3)
                            {
                                e.setLevel(tempLevel);
                                e.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    e.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(e, choice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                e.showStats(enemyHL); 
                                while(flag == false)
                                {
                                    e.setAutoBattle(auto);
                                    abilityChoice = e.userInput();
                                    flag = e.useAbilities(enemyHL, abilityChoice);
                                    health = e.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                e.showStats(enemyHL);               
                            }
                            else if(choiceRace == 3 && control == 0)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }  
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyH); 
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyH, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyH);             
                            }
                            else if(choiceRace == 3 && control == 1)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyE.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyE);    
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyE, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyE);            
                            }
                            else if(choiceRace == 3 && control == 2)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyD);  
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyD, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
            
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyD);              
                            }
                            else if(choiceRace == 3 && control == 3)
                            {
                                d.setLevel(tempLevel);
                                d.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    d.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(d, choice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                d.showStats(enemyHL); 
                                while(flag == false)
                                {
                                    d.setAutoBattle(auto);
                                    abilityChoice = d.userInput();
                                    flag = d.useAbilities(enemyHL, abilityChoice);
                                    health = d.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                d.showStats(enemyHL);              
                            }
                            else if(choiceRace == 4 && control == 0)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyH);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyH.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyH);   
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyH, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyH.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyH);            
                            }
                            else if(choiceRace == 4 && control == 1)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyE);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyE.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyE); 
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyE, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyE.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyE);               
                            }
                            else if(choiceRace == 4 && control == 2)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyD);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyD.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyD);  
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyD, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyD.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyD);             
                            }
                            else if(choiceRace == 4 && control == 3)
                            {
                                hl.setLevel(tempLevel);
                                hl.showStats(enemyHL);
                                while(flag2 == false)
                                {
                                    hl.setAutoBattle(auto);
                                    int choice = random.nextInt(7);
                                    flag2 =enemyHL.useAbilities(hl, choice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                } 
                                System.out.println(" Used By Opponent ");
                                hl.showStats(enemyHL);   
                                while(flag == false)
                                {
                                    hl.setAutoBattle(auto);
                                    abilityChoice = hl.userInput();
                                    flag = hl.useAbilities(enemyHL, abilityChoice);
                                    health = hl.getCurrentHp();
                                    enemyhealth = enemyHL.getCurrentHp();
                                }
                                System.out.println(" Used By Player ");
                                hl.showStats(enemyHL);            
                            }    
                        }  
                }
                if(health !=0)
                {
                    winCount++;
                    int change = 0;
                while(change !=2)
                {
                    System.out.println("1 : Change Class ");
                    System.out.println("2: Continue WIth Game Now");
                    change = input.nextInt();
                    if(change == 1)
                    {
                    if(choiceRace == 1)
                    {
                        System.out.println("Class 1 : Fighter");
                        System.out.println("Class 2 : Rogue");
                        System.out.println("Class 3 : Mage");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                    if(choiceClass == 1)
                    {
                        h.setcharacterClass("Fighter");
                    }
                    else if (choiceClass == 2)
                    {
                        h.setcharacterClass("Rogue");
                    }
                    else if (choiceClass == 3)
                    {
                        h.setcharacterClass("Mage");
                    }
                }
                else if (choiceRace == 2)
                {
                        System.out.println("Class 1 : Rogue");
                        System.out.println("Class 2 : Mage");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                    if (choiceClass == 1)
                    {
                        e.setcharacterClass("Rogue");
                    }
                    else if (choiceClass == 2)
                    {
                        e.setcharacterClass("Mage");
                    }
                }
                else if (choiceRace == 3)
                {
                        System.out.println("Class 1 : Fighter");
                        System.out.println("Class 2 : Mage");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                    if (choiceClass == 1)
                    {
                        d.setcharacterClass("Fighter");
                    }
                    else if (choiceClass == 2)
                    {
                        d.setcharacterClass("Mage");
                    }
                }
                else if (choiceRace == 4)
                {
                        System.out.println("Class 1 : Fighter");
                        System.out.println("Class 2 : Rogue");
                        System.out.print("Select Class by entering the Number : ");
                        choiceClass = input.nextInt();
                    if (choiceClass == 1)
                    {
                        hl.setcharacterClass("Fighter");
                    }
                    else if (choiceClass == 2)
                    {
                        hl.setcharacterClass("Rogue");
                    }
                }
                }
                else if(change !=2 || change !=1)
                {
                    System.out.println("Your choice is invalid select Again");
                }
                }
                }
                tempLevel = winCount+1;
                enemyhealth =1;
                if(health>0)
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("New Opponent is Ready");
                    System.out.println();
                    System.out.println();
                }
                
                }
                auto = 0;
                System.out.println("You Lost this Fight  \n Number of enemies Defeated : " + winCount);
                       
            }
            else if (controlMenu!=1 && controlMenu !=2)
            {
                System.out.println("Invalid Option Choose Again");
            }
        }
        input.close();
    }
    
}
