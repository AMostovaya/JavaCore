package Task1_1;

public class Human implements Participants{
    String name;
    int DistanceForRun;
    int RouteForBicycle;
    int DistanceForSwimming;

    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Human(String name) {
        this.name = name;
        this.DistanceForRun = 2000;
        this.DistanceForSwimming = 500;
        this.RouteForBicycle = 7500;
        this.onDistance = true;
    }

    public void run(int distance){
        if (distance <=DistanceForRun){
            System.out.println(name + " " + " successfully coped with cross");
        } else {
            System.out.println(name + " " + " could not overcome the cross");
            onDistance = false;
        }
    }

    public void ride(int route){
        if (route <= RouteForBicycle){
            System.out.println(name + " " + " successfully overcame the route");
        } else {
            System.out.println(name + " " + " could not overcome the route");
            onDistance = false;
        }
    }

    public void swim(int distance){
        if (distance <= DistanceForSwimming){
            System.out.println(name + " " + " successfully swam the distance");
        } else {
            System.out.println(name + " " + " could not swim the distance");
            onDistance = false;
        }
    }

    public void showResults(){
        System.out.println(name + ": " + onDistance);
    }

}