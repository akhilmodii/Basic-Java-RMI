import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{
    private Client(){}

    // Creating the Client.
    public static void main(String[] args) {
        String host;
        if(args.length < 1){
            host = null;
        }
        else{
            host = args[0];
        }

        try{
            Registry reg = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) reg.lookup("BarberCost");
            int cost = stub.barberCost();
            System.out.println("Your total cost: " + Integer.toString(cost));
        }
        catch(Exception e){

        }
    }
}
