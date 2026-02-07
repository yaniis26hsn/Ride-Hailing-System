import static java.lang.Math.*;

public class Ride {
    enum Status {requested , started , completed , cancelled} 
    // started means the driver accepted to take the ride 
    static Ride rides[] ;
    int startingPassengerX ;
    int startingPassengerY ;
    int destinationX ;
    int destinationY ;
    int startingDriverX ;
    int startingDriverY ; 
    double distance ; // full distance pickup + to distination
    // storing it is better than storing dist of pickup and distance to distination cz it is more usefull 
    double pickupDistance ;
    Driver driver ;
    Passenger passenger ;
    double price ;
    Status status ;

    public Ride( int distinationX, int distinationY,  Driver driver, Passenger passenger) {
        this.startingPassengerX = passenger.xCoord ;
        this.startingPassengerY = passenger.yCoord ;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.driver = driver;
        this.passenger = passenger;
        this.startingDriverX = driver.xCoord ;
        this.startingDriverY = driver.yCoord ;
        this.pickupDistance = sqrt( pow((startingDriverX - startingPassengerX), 2)  + pow((startingDriverY - startingPassengerY), 2)); 
        this.distance = pickupDistance + sqrt( pow((distinationX - startingPassengerX), 2)  + pow((distinationY - startingPassengerY), 2)); 
        rides[rides.length] = this ;
        this.price = getPrice() ;
        this.status = Status.requested ;
        
    }
   double getPrice(){
    return (driver.vehicule.type == Vehicule.Type.standard) ? distance * 10 : distance * 13 ;
   }
    
    void completeRide(){
        if(destinationX == passenger.xCoord && destinationY == passenger.yCoord){
            // or we can check that the distance is very small instead of exact equality
         status = Status.completed ;
         driver.updateRating(passenger.getRating()) ;
         passenger.updateRating(driver.getRating()) ; 
        }
    }


}
