package Task1_1;

public class Run extends Obstacle {
    private int distance;

    public Run(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participants participant) {
        participant.run(distance);
    }
}