// Author: Tam Nguyen Cu
// Date Written: September 20 2024
// Assignments: Module 04: Programming Assignment Chapter 4 5a and 5b
// Program: TestTeam.java

package Chapter4.Exercises;

// import library
import java.util.Scanner;

public class TestTeam {
    public static void main(String[] args) {
        // create constants
        final int TEAM_NUMBERS = 3;

        // create list of 3 teams
        Team[] teams = new Team[TEAM_NUMBERS];
        
        // set data for each team
        for (int i = 0; i< TEAM_NUMBERS; i++) {
            System.out.println("Enter team " + (i+1) + " information: ");
            teams[i] = setTeamData();
        }
        
        // display teams information
        display(teams);
    }

    public static Team setTeamData() {
        Scanner input = new Scanner(System.in);
        // create temporary Team object
        Team team = new Team();
        // set team information
        System.out.print("High school name >> ");
        team.setSchoolName(input.nextLine());
        System.out.print("Team name >> ");
        team.setTeamName(input.nextLine());
        System.out.print("Sports >> ");
        team.setSport(input.nextLine());
        System.out.println();
        return team;
    }

    public static void display(Team[] teams) {
        // display each team's information
        for (Team team : teams) {
            System.out.println(team.MOTTO);
            System.out.println("High School: " + team.getSchoolName());
            System.out.println("Team Name: " + team.getTeamName());
            System.out.println("Sports: " + team.getSport());
            System.out.println();
        }
    }
}
