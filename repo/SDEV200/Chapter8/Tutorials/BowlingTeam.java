package Chapter8.Tutorials;

public class BowlingTeam {
    private String teamName;
    private String[] members = new String[4];

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String team) {
        teamName = team;
    }

    public String getMembers(int number) {
        return members[number];
    }

    public void setMembers(int number, String name) {
        members[number] = name;
    }

}
