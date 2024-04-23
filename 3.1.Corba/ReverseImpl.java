import java.lang.String;
import ReverseModule.ReversePOA;


public class ReverseImpl extends ReversePOA{
    ReverseImpl(){
        super();
        System.out.println("Reverse Object Created");
    }
    public String reverse_String(String name){
        StringBuffer str = new StringBuffer(name);
        str.reverse();
        return (("The reversed string is "+ str));
    }
    
}
