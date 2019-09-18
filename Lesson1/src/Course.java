package Task1_1;

public class Course {

    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles){

        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        Participants[] teamMembers = team.getParticipants();
        if(teamMembers.length > 0) {
            for (Participants t: teamMembers) {
                for (Obstacle o: obstacles) {
                    o.doIt(t);
                    if (!t.isOnDistance()) break;
                }
            }
        } else {
            System.out.println("There aren't players in the team");
        }
    }



}
