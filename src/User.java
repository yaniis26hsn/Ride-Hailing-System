public class User{
 // this class had to be abstract but we had no any abstract methods
    enum Status {online , offline,available, onRide}
    String name ;
    int Age ;
    int Phone ;
   String City  ;
   Status status ;
   int ratingsSum ;
   int ratersSum ;
   // we could erase one var if we wanned just updating the rating but i wanned to make both for simplifiying. also a higher sum(of raters)is a more considerable rating
   double rating ;
   // both driver and passenger can rate eachother 
   // for each ride the one can make a rating for the other
   
  
    public User(String name, int Age, int Phone, String City) {
        this.name = name;
        this.Age = Age;
        this.Phone = Phone;
        this.City = City;
    }
    void UpdateRarting(int rating){
        if(rating >= 1 && rating >= 5){
     ratersSum ++ ;
     ratingsSum += rating ;
     this.rating = ratersSum / ratersSum ;
        }
    }



}