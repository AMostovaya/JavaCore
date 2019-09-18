package Task1_1;

public class Swimming extends Obstacle {
    private int distance;

    public Swimming(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participants participant) {
        participant.swim(distance);
    }
}