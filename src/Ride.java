public class Ride {
   enum  RideStatus {requested, rejected,completed,accepted}
    enum PayingMeth {Cash , Card} 
    double Price ;
    Vehicule vehicule ;
    Passenger passengers[] ; // it must be less or equal the vehicule capacity
    int Distance ;
    boolean IsPayed ;
    PayingMeth payingMeth ;
    RideStatus rideStatus;
    String Start ;
    String Destination ;
    public Ride( Vehicule vehicule, Passenger[] passengers, int Distance) {
        if(passengers.length > vehicule.Capacity) {
            System.out.println("Vehicule Capacity is not enough"); 
            rideStatus = RideStatus.rejected ;
            return;
        }
        this.Price = vehicule.Owner.DriverPricing * Distance * vehicule.VehiculePricing; // i wish i made a driver var instead of using vehicule.owner all the time
        this.vehicule = vehicule;
        this.passengers = passengers;
        this.Distance = Distance;
        this.rideStatus = RideStatus.requested ;
    }
   public void PayProced(PayingMeth payingMeth , int driverRatings[], int passengerRatings[]){
    this.payingMeth = payingMeth ;
    if(payingMeth == PayingMeth.Card) Price = Price * 0.95 ;
   
     int i = 0 ;
    for(Passenger passenger : passengers){
        
         vehicule.Owner.UpdateRarting(passengerRatings[i]) ; 
         passenger.UpdateRarting(driverRatings[i])  ;
         i ++ ;
    }
    
   }
    
   public void Payed(){
    IsPayed = true ;
    rideStatus = RideStatus.completed ;
    vehicule.Owner.status = User.Status.available ;
    // since user is always available he can make rides anytime . if you change that , you must update his status then
    for(Passenger passenger : passengers){
        passenger.status = User.Status.available ;
    }
   }
    

}
