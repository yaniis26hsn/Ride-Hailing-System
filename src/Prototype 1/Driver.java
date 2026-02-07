public class Driver extends User{
    int DriverPricing ;
    public Driver(int DriverPricing, String name, int Age, int Phone, String City) {
        super(name, Age, Phone, City);
        this.DriverPricing = DriverPricing;
    }
    void AcceptRide(Ride ride){
        if(this.status == User.Status.available){
        ride.rideStatus = Ride.RideStatus.accepted ; // we need to access the class before we access the enum
        this.status = User.Status.onRide ;
        }
    }

    void RejectRide(Ride ride){
        ride.rideStatus = Ride.RideStatus.rejected ; // we need to access the class before we access the enum
    }
    
}
