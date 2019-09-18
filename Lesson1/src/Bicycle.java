package Task1_1;

public class Bicycle extends Obstacle {
    private int route;

    public Bicycle(int route) {
        this.route = route;
    }

    @Override
    public void doIt(Participants participant) {
        participant.ride(route);
    }
}