package Task1_1;
public class Team {

    private String nameTeam;
    private String resultOfMaraphon;
    private Participants[] members = new Participants[4];

    public String getName(){
        return "Name of team: " + nameTeam;
    }

    public Team(String nameTeam, Participants[] members) {
        this.nameTeam = nameTeam;
        this.members = members;
    }

    public void setResult(String result) {
        resultOfMaraphon = result;
    }

    public Participants[] getParticipants() {
        return members;
    }

    public void showResults() {
        System.out.println("Результаты команды: " + nameTeam);
        System.out.print(resultOfMaraphon);
    }


}
