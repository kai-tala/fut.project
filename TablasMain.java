/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;

/**
 *
 * @author mxkai
 */
public class TablasMain {
    
    public static int factorial(int n){
        int res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
    
    public static int combination(List teams){
        //n represents total amount of elements
        //2 is in the place of r in the combination formula since 2! = 2
        int n = teams.size();
        int res = factorial(n) / (2 * factorial(n - 2));
        return res;
    
    }
    
    public static void change(List teams, int[] pts){
        int n1goal, n2goal;
        int n1points = 0, n2points = 0;
        
        for(int i = 0; i < teams.size(); i++){
            for(int j = i+1; j < teams.size(); j++){
                
                String nom1 = teams.get(i).toString();
                String nom2 = teams.get(j).toString();
                
                System.out.println("\n" + nom1 + " vs. " + nom2);
                
                Scanner scan = new Scanner(System.in);
        
                System.out.println("Enter number of goals for " + nom1);
                n1goal = scan.nextInt();
                System.out.println("Enter number of goals for " + nom2);
                n2goal = scan.nextInt();
        
                if(n1goal > n2goal){
                    n1points = 3;
                }
                else if(n1goal < n2goal){
                    n2points = 3;
                }
                else{
                    n1points = 1;
                    n2points = 1;
                }
        
                if(teams.contains(nom1) && teams.contains(nom2)){
                    int index1 = teams.indexOf(nom1);
                    int index2 = teams.indexOf(nom2);
            
                    pts[index1] += n1points;
                    pts[index2] += n2points;   
                }
            }
        
        
        }  
        System.out.println("Phase done! Check scores to see who is winning!");
    }
    
    public static void chart(List teams, int[] points){
        
        System.out.println("\nPoint Chart:\n");
        for(int i = 0; i < teams.size(); i++){
            System.out.println(teams.get(i) + ": " + points[i]);
        }
    }
    
    public static void bracket(List teams){
        //verify if power of 2 by using bits (powers of two always have just one bit on 1)
        int i = 0;
        int n1goal, n2goal;
        String win;
        
        if((teams.size() & (teams.size() - 1)) == 0){
            System.out.println("The number of teams must be a power of 2 (2, 4, 8, 16, 32, etc)");
        }
        else{
            while(i < teams.size()){
                String nom1 = teams.get(i).toString();
                String nom2 = teams.get(i+1).toString();
            
                i +=2;
                
                System.out.println("\n" + nom1 + " vs. " + nom2);
                
                Scanner scan = new Scanner(System.in);
        
                System.out.println("Enter number of goals for " + nom1);
                n1goal = scan.nextInt();
                System.out.println("Enter number of goals for " + nom2);
                n2goal = scan.nextInt();
                
                if(n1goal > n2goal){
                    win = nom1;
                }
                else if(n2goal > n1goal){
                    win = nom2;
                }
                else{
                    System.out.println("Enter extra time goals for " + nom1);
                    n1goal = scan.nextInt();
                    System.out.println("Enter extra time goals for " + nom2);
                    n2goal = scan.nextInt();
                    
                    if(n1goal > n2goal){
                    win = nom1;
                    }
                    else if(n2goal > n1goal){
                        win = nom2;
                    }
                    else{
                        System.out.println("Enter 1 if " + nom1 + " won at penalties\nEnter 2 if " + nom2 + " won at penalties");
                        int ans = scan.nextInt();
                        if(ans == 1){
                            win = nom1;
                        }
                        else if(ans == 2){
                            win = nom2;
                        }
                        
                    }
                }
                //not done, have to register who wins in each match
                System.out.println("Winner is " + win + "!!");
            }
            
            
        }
        
    }
    
    
    public static void menu(List teams, int[] points){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter:\n1 for entering the match data for next phase\n2 for viewing scores\n0 to quit");
        int answer = scan.nextInt();
        
        int matchCount = 0;
        
        while(answer != 0){
            
            if(answer == 1 && matchCount < combination(teams)){
                change(teams, points);
                matchCount++;
            }
            else if(answer == 2){
                chart(teams, points);
            }
            else if(answer == 0){
                break;
            }
            else if(matchCount >= combination(teams)){
                System.out.println("The max amount of matches has been inserted: " + combination(teams));
            }
            
            
            System.out.println("\nEnter:\n1 for entering the match data for next phase\n2 for viewing scores\n0 to quit");
                answer = scan.nextInt();
        }
        
        System.out.println("Goodbye!");

        
    }
    
    public static void main(String[] args) {
        
        //get team names
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of teams in number form: ");
        int teamNum = scan.nextInt();
        
        List<String> teams = new ArrayList<>();

        for (int x = 0; x <teamNum; x++){
            System.out.print("\nEnter a team name: ");
            String teamName = scan.next();
            teams.add(teamName);
        }
        
        System.out.println("The teams are: " + teams);

        
        
        //points
        int[] points = new int[teamNum];

        //menu(teams, points);
    }
}
