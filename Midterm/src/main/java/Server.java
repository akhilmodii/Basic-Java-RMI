import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server implements Hello{
    public Server(){ }

    public String sayHello() {
        return "Hello World";
    }

    public int barberCost(){
        int numCustomers = 10;
        int numChairs = 5;
        float cost = (float) 10.0;
        float deltaCost = (float) 2.5;
        float money = (float) 15.0;
        int time = 20;
        int totalCost = 0;
        boolean cutting = false;
        boolean sleeping = false;

        if(numCustomers == 0){
            // barber is sleeping in a chair.
            sleeping = true;
            numChairs -= 1;
        }

        if(numCustomers != 0){
            if(money < cost){
                // Customer leaves because he has less money.
                return totalCost;
            }
            if(cutting){
                // customer grabs a chair.
                numChairs -= 1;
            }
            if(numChairs == 0){
                // Customer pays extra cost because all chairs are taken.
                totalCost = (int)cost + (int)deltaCost;
            }
            if(numChairs == 5){
                // Customer pays less because all chairs are empty.
                totalCost = (int)cost + (int)deltaCost;
            }
            else{
                return (int)cost;
            }
        }

        return totalCost;
    }


    // Creating the Server.
    public static void main(String[] args) {
        try{
            Server server = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject((Remote) server, 0);
            Registry reg = LocateRegistry.createRegistry(0);
            reg.bind("BarberCost", stub);
            System.out.println("Server is ready.");
        }

        catch(Exception e){
                System.out.println("Server exception: " + e.toString());
                e.printStackTrace();
        }
    }
}
