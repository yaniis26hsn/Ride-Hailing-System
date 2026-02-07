public class Vehicule {
    enum Type {standard , premuim}
    Type type ;
    String board ; // as an id 
    Driver Owner ;

    public Vehicule(Type type, String board, Driver Owner) {
        this.type = type;
        this.board = board;
        this.Owner = Owner;
    }
    
    
     
    

}