import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    int barberCost() throws RemoteException;
}
