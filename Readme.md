Problem 1
Consider a barber shop with a single barber, B, one barber chair, and N chairs for customers who are waiting for their turn for
a haircut at some cost, C, before the covid epidemics, of course. If there are no customers, B sleeps in her chair.
On entering, a customer has some amount of money, M, and s/he either awakens B or if B is cutting someone else's hair,
the customer sits down in one of the chairs for waiting customers. If M <C the customer simply leaves.
If all of the waiting chairs are taken, the newly arrived customer offers a delta C increase to pay for the haircust and C+deltaC
becomes the new price, C=C+deltaC. If a chair is empty and there are no customers for some predefined duration of time,
T then the price is decreased by deltaC if it above some predefined price threshold.
Assume that there is one Java client object for each customer and one one JavaRMI object for the barber.
Implement the system using JavaRMI or Twitter Finagle. Explain your solution and describe how it works using a small toy example in this
file or as a comment in your source code.

Problem 2
Describe the design of a system for RPC called Active-JavaRMI where active messages are used to reduce the communication costs for JavaRMI.



====================================================================================================================================================================
                                                            SOLUTION
====================================================================================================================================================================


Reference to code for Problem 1:

The code I wrote implements a very basic cost-calculating program Using the Java Remote Method Invocation (Java RMI). I followed the following steps for implementing my solution:
1. First of all I defined the Remote interface which declares two methods.
2. The second thing I did was to implement the server. The server contains a main method that creates an instance of the remote object implementation,
and then binds the instance to a name in the Java RMI registry. The server also contains the method that calculates the cost of cutting hair by
implementing the different conditions as discussed in the question.
3. he third thing to do on the list was to implement a client. The client class obtains a stub for the registry of the server's host, looks up on the remote
object's stub by the name in the registry and then invokes the cost calculating method on the remote object using the stub.
4. The last part was to compile the code. I compiled the code using Maven compiler version: 3.6.1 and Java version: 1.8.0_221 on IntelliJ Ultimate Edition.

I will add my Maven project in the BitBucket repo usnder the folder named 'Midterm'.




Solution for Problem 2:

The Java Remote Method Invocation (Java RMI) is a Java API that performs remote method invocation or in other words, it is equivalent to remote procedure calls (RPC), which is object-oriented.
The Java RMIsystem allows an object running in one Java virtual machine (JVM) to invoke methods on an object running on another Java Virtual Machine. i.e, it provides
remote communication between programs.
RMI usually compromises of two seperate programs - Server and Client. A server program creates remote objects, makes the references to these objects and then waits for the client
to invoke these object's methods. On the other hand, a client program obtains a remote reference to one or more remote objects on the server and then invokes their methods.

The basic RMI design would look like this:

        Client  <------>  Stub  <------>  Network  <------>  Server


To implement an active message using Java RMI and reduce cost for the communications, we can do the following:
We can implement the RMI design in such a way that we can make the clients act as server too. We can do that by implementing a remote interface for the client too.
When the client connects to the server, we can pass it as a reference to an instance in remote interface. We can then export that object as remote RMI object without
registering the object into the registry. The server would keep the register of all the clients so that it can be called back when needed. And then, when the client is disconnected,
the client needs to be unregistered. And lastly, we can make the server to do periodic checks of all the clients in the registry so that it does not keep the
reference to all the dead clients.





