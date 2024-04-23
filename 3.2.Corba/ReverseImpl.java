import java.lang.string;
import ReverseModule.*;

public class ReverseImpl {
    ReverseImpl(){
        super();
        System.out.println("Reverse Object created");
    }

    public String reverse_string(string name){
        StringBuffer str = new StringBuffer(name);
        str.reverse();
        return (("Server send" + str));
        
    }
    
}
