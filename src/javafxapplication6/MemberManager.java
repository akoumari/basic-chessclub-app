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
public class MemberManager {
    private Member[] memberList;
    private int maxNumMembers;
    private int numMembers;
    private static int currentMemberId =0;

    public MemberManager(int maxNumMembers) {
        this.maxNumMembers = maxNumMembers;
        numMembers = 0;
        memberList = new Member[maxNumMembers];
    }
    public boolean addMember(String firstName, String lastName){
        if(numMembers < maxNumMembers){
            memberList[numMembers] = new Member(currentMemberId, firstName, lastName);
            numMembers++;
            currentMemberId++;
            return true;
        }
        return false;
    }
    private int findAccount(int an){
        for(int x = 0; x<numMembers;x++){
            if(an == memberList[x].getID()){
                return x;
            }
        }
        return -1;
    }
    public boolean checkAccount(int an){
        for(int x = 0; x<numMembers;x++){
            if(an == memberList[x].getID()){
                return true;
            }
        }
        return false;
    }
    public boolean addGame(int an, boolean isWinner){
        int x = findAccount(an);
        if(x != -1 ){
            memberList[x].addGame(isWinner);
            return true;
        }
        return false;
    }
    public String[] getBestPlayer(){
        double rate = 0;
        String[] best = new String[numMembers];
        int loc = 0;
        for(int x = 0; x<numMembers;x++){
            if(memberList[x].getWinRate() > rate){
                rate = memberList[x].getWinRate();
            }
        }
        for(int x = 0; x<numMembers;x++){
            if(memberList[x].getWinRate() == rate){
                best[loc++] = memberList[x].toString();
            }
        }
        return best;
    }
    public String[] getMostWinner(){
       double wins = 0;
        String[] best = new String[numMembers];
        int loc = 0;
        for(int x = 0; x<numMembers;x++){
            if(memberList[x].getWins() > wins){
                wins = memberList[x].getWins();
            }
        }
        for(int x = 0; x<numMembers;x++){
            if(memberList[x].getWins() == wins){
                best[loc++] = memberList[x].toString();
            }
        }
        return best; 
    }
    public Member[] getMembers(){
        return memberList;
    }
    public String[] getMembersStrings(){
        String[] s = new String[numMembers];
        for(int x = 0; x<numMembers;x++){
            s[x]= memberList[x].toString();
        }
        return s;
    }
    public String toString(){
        String s = "Chess Club Members";
        s+= "\n***********************\n";
        for(int x = 0; x < numMembers;x++){
            s+= memberList[x].toString()+"\n";
        }
        return s;
    }
}
