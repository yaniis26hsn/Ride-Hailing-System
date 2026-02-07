public class User {
    enum RidingStatus {onRide , onRequest , available}
    enum ConnectionStatus {online, offline } 
    // onRequest means that requesting(passanger) or receiving request (driver) 
    // for the riding status 
    
    
    Ride currantRide ;
    String username  ;
    String password ; 
    ConnectionStatus status ; 
    RidingStatus  Rstatus ;
    String phone ;
    int xCoord ;
    int yCoord ;
    double rating ; // for a driver he can get an idea of which passenger to accept 
    // for a passanger , when he will search for a ride , he must give a value of the least rating of a driver

    public User(String username, String password, ConnectionStatus status, String Phone, int xCoord, int yCoord) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.phone = Phone;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.rating = 0;
    }
    User(String phone , String username , String password){ // represents sign up

    }
    void getLocation(){
        // we will need access to the location of the device somehow
        // we must get and update the coords using it and it should be called each a small range
        
        
    }
    int getRating(){
        int rate = 3 ;
        // ui implementation
        // if(rate > 0 && rate<= 5) 
         return rate ;
    }
    void updateRating(int newRating){

    }
    




}