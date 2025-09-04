package selenium.WebAssignment;
import java.util.HashMap;
import java.util.Map;


class Car {
    private String model;
    private boolean isAvailable;

    public Car(String model) {
        this.model = model;
        this.isAvailable = true; // Available by default when added
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }
}

class CarRentalService {
    private Map<String, Car> cars = new HashMap<>();

    // Add a car to the rental service
    public void addCar(String model) {
        if (!cars.containsKey(model)) {
            cars.put(model, new Car(model));
            System.out.println("Car added: " + model);
        } else {
            System.out.println("Car already exists: " + model);
        }
    }

    // Rent a car if it's available
    public boolean rentCar(String model) {
        Car car = cars.get(model);
        if (car != null && car.isAvailable()) {
            car.rent();
            System.out.println("Car rented: " + model);
            return true;
        } else {
            System.out.println("Car not available for rent: " + model);
            return false;
        }
    }

    // Return a rented car
    public boolean returnCar(String model) {
        Car car = cars.get(model);
        if (car != null && !car.isAvailable()) {
            car.returnCar();
            System.out.println("Car returned: " + model);
            return true;
        } else {
            System.out.println("Car not found or already available: " + model);
            return false;
        }
    }

    // Check availability
    public boolean isCarAvailable(String model) {
        Car car = cars.get(model);
        boolean available = car != null && car.isAvailable();
        System.out.println("Availability of " + model + ": " + available);
        return available;
    }
}
public class Main {
    public static void main(String[] args) {
        CarRentalService service = new CarRentalService();

        service.addCar("Toyota Corolla");
        service.addCar("Honda Civic");

        service.isCarAvailable("Toyota Corolla");
        service.rentCar("Toyota Corolla");
        service.isCarAvailable("Toyota Corolla");

        service.returnCar("Toyota Corolla");
        service.isCarAvailable("Toyota Corolla");

        service.rentCar("Ford Mustang"); // Car not in service
        service.returnCar("Ford Mustang"); // Car not in service
    }
}

