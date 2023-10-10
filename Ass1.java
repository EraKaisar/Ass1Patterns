package com.journaldev.design.model; //This line declares the package to which this class belongs.
public abstract class Computer { //Here, a class named Computer is declared as public and abstract. This means that this class can be accessed from outside its package, and it cannot be instantiated directly (i.e., you cannot create objects of the Computer class).

 public abstract String getRAM(); 
 public abstract String getHDD();
 public abstract String getCPU(); //Inside the Computer class, there are three abstract methods declared: getRAM(), getHDD(), and getCPU().

 @Override
 public String toString(){
 return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+",
CPU="+this.getCPU(); //This code overrides the toString() method from the Object class. The toString() method is used to provide a textual representation of an object. In this case, it concatenates the values returned by the getRAM(), getHDD(), and getCPU() methods and returns a string in the format "RAM= [value], HDD= [value], CPU= [value]".
 }
}


package com.journaldev.design.model; 
public class PC extends Computer {
 private String ram; //The PC class extends the Computer class, which means it inherits the abstract methods getRAM(), getHDD(), and getCPU() from the Computer class.
 private String hdd;
 private String cpu;

 public PC(String ram, String hdd, String cpu){
 this.ram=ram; //It has three private instance variables, ram, hdd, and cpu, which store the specifications of the PC.
 this.hdd=hdd; //The constructor public PC(String ram, String hdd, String cpu) is used to initialize the ram, hdd, and cpu properties of a PC object.
 this.cpu=cpu;
 }
 @Override
 public String getRAM() {
 return this.ram; //The class provides concrete implementations of the abstract methods getRAM(), getHDD(), and getCPU() by simply returning the values stored in the corresponding instance variables.
 }
 @Override
 public String getHDD() {
 return this.hdd;
 }
 @Override
 public String getCPU() {
 return this.cpu;
 }
}


package com.journaldev.design.model; //The Server class is similar to the PC class in structure and behavior.
public class Server extends Computer { //It also extends the Computer class, inheriting the same abstract methods.
 private String ram; //It has three private instance variables, ram, hdd, and cpu, used to store the specifications of the server.
 private String hdd;
 private String cpu;

 public Server(String ram, String hdd, String cpu){ //The constructor public Server(String ram, String hdd, String cpu) initializes the server's specifications.
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public String getRAM() { //Like the PC class, it provides concrete implementations of the abstract methods by returning the values of its instance variables.
 return this.ram;
 }
 @Override
 public String getHDD() {
 return this.hdd;
 }
 @Override
 public String getCPU() {
 return this.cpu;
 }
}


package com.journaldev.design.factory; //This line declares the package in which the ComputerFactory class resides. 
import com.journaldev.design.model.Computer; //These import statements bring in the necessary classes from other packages (com.journaldev.design.model) that are used within the ComputerFactory class.
import com.journaldev.design.model.PC;
import com.journaldev.design.model.Server;
public class ComputerFactory { //This is the declaration of the ComputerFactory class. It's a public class, which means it can be accessed from outside the package.
 public static Computer getComputer(String type, String ram, String //This method is a static factory method named getComputer, which takes four parameters: type, ram, hdd, and cpu.
hdd, String cpu){
 if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu); //The type parameter is used to specify the type of computer to create. It is case-insensitive, so "PC" and "pc" would be treated the same.
 else if("Server".equalsIgnoreCase(type)) return new Server(ram, //Inside the method, it checks the value of the type parameter using conditional statements
hdd, cpu);

 return null;
 }
}


package com.journaldev.design.test; //This line declares the package in which the TestFactory class resides.
import com.journaldev.design.abstractfactory.PCFactory; //These import statements bring in the necessary classes and interfaces that are used within the TestFactory class.
import com.journaldev.design.abstractfactory.ServerFactory;
import com.journaldev.design.factory.ComputerFactory;
import com.journaldev.design.model.Computer;
public class TestFactory {
 public static void main(String[] args) { //This is the entry point of the program, where the execution begins.
 Computer pc = ComputerFactory.getComputer("pc","2 GB","500 
GB","2.4 GHz"); //The main method uses the ComputerFactory class to create two instances of computers, one of type "PC" and another of type "Server".
 Computer server = ComputerFactory.getComputer("server","16
GB","1 TB","2.9 GHz"); //The getComputer method of the ComputerFactory class is used to create these instances. It takes the type of computer ("pc" or "server") and the specifications (RAM, HDD, CPU) as parameters and returns the corresponding Computer object.
 System.out.println("Factory PC Config::"+pc); //After creating the pc and server objects, the program prints out their configurations using the System.out.println statements.
 System.out.println("Factory Server Config::"+server); //The toString() method of the Computer class is called automatically when you concatenate pc and server with the string, which provides a human-readable representation of the computer objects.
 }
}


package com.journaldev.design.model;

public abstract class Computer { //Computer is an abstract class, which means it cannot be instantiated directly, and it's meant to be subclassed.

 public abstract String getRAM(); //It declares three abstract methods: getRAM(), getHDD(), and getCPU(). These methods do not have implementations in the Computer class; instead, they are meant to be implemented by subclasses.
 public abstract String getHDD();
 public abstract String getCPU();

 @Override //The toString() method is overridden in the Computer class. It provides a common implementation for converting a Computer object to a human-readable string, showing its RAM, HDD, and CPU specifications. This method is inherited by subclasses but can be customized further.
 public String toString(){
 return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+",
CPU="+this.getCPU();
 }
}


package com.journaldev.design.model;


public class PC extends Computer { //PC is a concrete class that extends the Computer abstract class. This means it inherits the abstract methods getRAM(), getHDD(), and getCPU() from the Computer class and must provide concrete implementations for them.

 private String ram; //It has three private instance variables, ram, hdd, and cpu, used to store the specifications of a PC.
 private String hdd;
 private String cpu;

 public PC(String ram, String hdd, String cpu){ //The constructor public PC(String ram, String hdd, String cpu) initializes the PC's specifications with the provided values.
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public String getRAM() { //The getRAM(), getHDD(), and getCPU() methods are implemented to return the respective specifications stored in the instance variables.
 return this.ram;
 }

 @Override
 public String getHDD() {
 return this.hdd;
 }

 @Override
 public String getCPU() {
 return this.cpu;
 }

}



package com.journaldev.design.model;


public class Server extends Computer { //Server is another concrete class that extends the Computer abstract class. It follows the same principles as the PC class.

 private String ram; //It has three private instance variables, ram, hdd, and cpu, used to store the specifications of a server
 private String hdd;
 private String cpu;

 public Server(String ram, String hdd, String cpu){ //The constructor public Server(String ram, String hdd, String cpu) initializes the server's specifications.
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public String getRAM() { //Like the PC class, it provides concrete implementations of the abstract methods getRAM(), getHDD(), and getCPU() by returning the values stored in its instance variables.
 return this.ram;
 }

 @Override
 public String getHDD() {
 return this.hdd;
 }

 @Override
 public String getCPU() {
 return this.cpu;
 }

}


package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
public interface ComputerAbstractFactory { //In this step, you define an interface called ComputerAbstractFactory. This interface declares a single method, createComputer(), which is responsible for creating an instance of the Computer class or its subclasses.
 public Computer createComputer();
}

package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
import com.journaldev.design.model.PC;
public class PCFactory implements ComputerAbstractFactory { //In this step, you create a concrete factory class (PCFactory) that implements the ComputerAbstractFactory interface. This factory is responsible for creating instances of the PC class.
 private String ram; //The constructor of PCFactory initializes the values for RAM, HDD, and CPU.
 private String hdd;
 private String cpu;

 public PCFactory(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }
 @Override
 public Computer createComputer() { //The createComputer() method creates and returns a PC object with the specified specifications.
 return new PC(ram,hdd,cpu);
 }
}


package com.journaldev.design.abstractfactory;
import com.journaldev.design.model.Computer;
import com.journaldev.design.model.Server;
public class ServerFactory implements ComputerAbstractFactory { //Similar to the PCFactory, you create another concrete factory class (ServerFactory) that implements the ComputerAbstractFactory interface. This factory is responsible for creating instances of the Server class.
 private String ram; //The constructor of ServerFactory initializes the values for RAM, HDD, and CPU.
 private String hdd;
 private String cpu;

 public ServerFactory(String ram, String hdd, String cpu){
 this.ram=ram;
 this.hdd=hdd;
 this.cpu=cpu;
 }

 @Override
 public Computer createComputer() { //The createComputer() method creates and returns a Server object with the specified specifications.
 return new Server(ram,hdd,cpu);
 }
}


package com.journaldev.design.test;
import com.journaldev.design.abstractfactory.PCFactory;
import com.journaldev.design.abstractfactory.ServerFactory;
import com.journaldev.design.factory.ComputerFactory;
import com.journaldev.design.model.Computer;
public class TestDesignPatterns { //In this step, you create a test class TestDesignPatterns to demonstrate the usage of the Abstract Factory pattern.
 public static void main(String[] args) { //The testAbstractFactory() method shows how to create instances of computers (PC and Server) using the abstract factory. It calls ComputerFactory.getComputer() with specific factory instances (PCFactory and ServerFactory) to create the desired computer objects.
 testAbstractFactory(); //The configurations of the created computers are then printed to the console.
 }
 private static void testAbstractFactory() { //In summary, the Abstract Factory design pattern is used to create families of related objects without specifying their concrete classes. This allows for the creation of objects with consistent interfaces, making it easier to switch between different implementations or families of objects.
 Computer pc =
com.journaldev.design.abstractfactory.ComputerFactory.getComputer(new
PCFactory("2 GB","500 GB","2.4 GHz"));
 Computer server =
com.journaldev.design.abstractfactory.ComputerFactory.getComputer(new
ServerFactory("16 GB","1 TB","2.9 GHz"));
 System.out.println("AbstractFactory PC Config::"+pc);
 System.out.println("AbstractFactory Server Config::"+server); //The provided code demonstrates how to implement and use the Abstract Factory pattern for creating instances of different computer types.
 }
}
