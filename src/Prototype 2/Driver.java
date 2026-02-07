
import static java.lang.Math.* ;
public class Driver extends User {
    static Driver drivers[] ;
    Vehicule vehicule ;
    Ride requests[] ; 
    public Driver(String username, String password, ConnectionStatus status, String Phone, int xCoord, int yCoord, double rating) {
        super(null, null, null, null, 0, 0);
    }
    
    Driver(String phone , String username , String password){ // represents sign up
    super(phone, username, password);
    drivers[drivers.length] = this ;
    }
    static Driver getTheClosestDriver(Passenger passenger , double minimalRating){
       Driver tmpClosestDriver = null ;
        double tmpDist = 0 ;
      double minDistance = 1000 ; // we shouldn't get a very far driver anyway

      for (int i = 0; i < drivers.length; i++) {
        tmpDist = sqrt( pow((drivers[i].xCoord - passenger.xCoord), 2)  + pow(drivers[i].yCoord - passenger.yCoord, 2) ) ;
         
        if(minDistance > tmpDist && drivers[i].rating >= minimalRating) {
            minDistance = tmpDist ;
            tmpClosestDriver = drivers[i] ;
          }

      }
      return tmpClosestDriver ;
    }
    
    void getRequest(Ride ride ){
     this.requests[requests.length] = ride ;
    }
    void acceptRequest(int requestNumber){
        // accpeting one means rejecting the others 
         for (int i = 0; i < requests.length; i++) {
            if(i != requestNumber)
            requests[i].status = Ride.Status.cancelled ;
        else{
            requests[i].status = Ride.Status.started ;
            this.currantRide = requests[i];
          requests[i].passenger.informPassenger(requests[i]) ;
        }
        }

    }
    void rejectAllRequests(){
        for (int i = 0; i < requests.length; i++) {
            requests[i].status = Ride.Status.cancelled ;
        }

    }
}
