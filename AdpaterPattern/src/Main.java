// Target interface
interface Cat {
    void scratch();
    void makeSound();
}

// Adaptee
class Lion implements Cat {
    public void scratch() {
        System.out.println("Lion scratches fiercely!");
    }

    public void makeSound() {
        System.out.println("Roar! Roar!");
    }
}

// Adapter
class PlasticToyKitten {
    public void meow() {
        System.out.println("Meow Meow");
    }
}

class CatAdapter implements Cat {
    private final PlasticToyKitten toyKitten;

    CatAdapter(PlasticToyKitten toyKitten) {
        this.toyKitten = toyKitten;
    }

    public void scratch() {
        // Do nothing since the toy kitten can't scratch
    }

    public void makeSound() {
        toyKitten.meow(); // In place of the lion's roar, the toy kitten will meow
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Lion Lion = new Lion();
        PlasticToyKitten toyKitten = new PlasticToyKitten();

        Cat toyKittenAdapter = new CatAdapter(toyKitten);

        System.out.println("Lion:");
        Lion.scratch();
        Lion.makeSound();

        System.out.println("\nToyKitten:");
        toyKitten.meow();

        System.out.println("\nToyKittenAdapter:");
        toyKittenAdapter.scratch();
        toyKittenAdapter.makeSound();
    }
}
