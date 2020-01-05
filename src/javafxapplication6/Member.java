/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

/**
 *
 * @author alexk
 */
public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private int numGames;
    private int wins;
    private int losses;


    public Member(int memberId, String firstName, String lastName) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        numGames =0;
        wins = 0;
        losses = 0;
    }

    public int getID(){
        return memberId;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getNumGames(){
        return numGames;
    }

    public int getWins(){
        return wins;
    }
    public double getWinRate(){
        if(numGames > 0){return wins*1.0/numGames*1.0;}
        return 0;
    }

    public int getLosses(){
        return losses;
    }
    
    public boolean addGame(boolean isWinner){
        numGames++;
        if(isWinner){
            wins++;
        }else{ 
            losses++; 
        }
        return true;
    }

    public String toString(){
        return  "Member ID: "+memberId+
                "\nFirst Name: "+firstName+
                "\nLast Name: "+lastName+
                "\nNumber of Games: "+numGames+
                "\nWins: "+wins+
                "\nWin Rate: "+getWinRate()+
                "\nLosses: "+losses;
    }
}
