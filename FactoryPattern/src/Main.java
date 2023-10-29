// Computer interface
interface Computer {
    void printComputerType();
}

// Concrete classes implementing the Computer interface
class PC implements Computer {
    @Override
    public void printComputerType() {
        System.out.println("PC");
    }
}

class Server implements Computer {
    @Override
    public void printComputerType() {
        System.out.println("Server");
    }
}

// Computer factory to generate objects of concrete classes based on given information
class ComputerFactory {
    public Computer getComputer(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("PC")) {
            return new PC();
        } else if (type.equalsIgnoreCase("Server")) {
            return new Server();
        }
        return null;
    }
}

// Example usage of the factory pattern
class FactoryPatternExample {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();

        // Get an object of PC and call its printComputerType method.
        Computer computer1 = computerFactory.getComputer("PC");
        computer1.printComputerType();

        // Get an object of Server and call its printComputerType method.
        Computer computer2 = computerFactory.getComputer("Server");
        computer2.printComputerType();
    }
}
