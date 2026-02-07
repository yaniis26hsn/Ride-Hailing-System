public class Passenger extends User{
     static Passenger passengers[] ;

    public Passenger(String username, String password, ConnectionStatus status, String Phone, int xCoord, int yCoord, double rating) {
        super( username, password, status, Phone, xCoord,  yCoord);
    }

    Passenger(String phone , String username , String password){ // represents sign up
    super(phone, username, password);
    passengers[passengers.length] = this ;
    }

    Ride RequestRide (int x , int y , double minimalRating){
        // x and y are the coords where the passanger wants to go to 
        Driver driver = Driver.getTheClosestDriver(this , minimalRating) ;
        this.Rstatus = User.RidingStatus.onRequest;
       Ride ride =  new Ride(x, y, driver, this) ;
         driver.getRequest(ride); 
         return  ride;
    }
    void declareRideAsDone(){
     
    }
    void informPassenger(Ride ride){
        // we inform him that he got accepted by a driver . we will need a UI of course
        this.currantRide = ride ;

    }



    
}
