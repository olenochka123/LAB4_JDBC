package db.lab4.view;

import java.sql.SQLException;

import db.lab4.controller.implementation.*;
import db.lab4.model.implementation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final PostOfficeController postOfficeController = new PostOfficeController();
    private final DriverController driverController = new DriverController();
    private final PostOfficeHasDriverController postOfficeHasDriverController = new PostOfficeHasDriverController();
    private final CarController carController = new CarController();
    private final DriverHasCarController driverHasCarController = new DriverHasCarController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    public static final Scanner INPUT = new Scanner(System.in, "UTF-8");

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();


        menu.put("11", "11 - Get all postOffices");
        menu.put("12", "12 - Get postOffice by ID");
        menu.put("13", "13 - Create postOffice");
        menu.put("14", "14 - Delete postOffice by ID");
        menu.put("15", "15 - Update postOffice by ID");

        menu.put("21", "21 - Get all drivers");
        menu.put("22", "22 - Get driver by ID");
        menu.put("23", "23 - Create driver");
        menu.put("24", "24 - Delete driver by ID");
        menu.put("25", "25 - Update driver by ID");

        menu.put("31", "31 - Get all postOfficeHasDrivers");
        menu.put("32", "32 - Get postOfficeHasDriver by id");
        menu.put("33", "33 - Create postOfficeHasDriver");
        menu.put("34", "34 - Delete postOfficeHasDriver by ID");
        menu.put("35", "35 - Update postOfficeHasDriver");

        menu.put("41", "41 - Get all cars");
        menu.put("42", "42 - Get car by ID");
        menu.put("43", "43 - Create car");
        menu.put("44", "44 - Delete car by ID");
        menu.put("45", "45 - Update car by ID");

        menu.put("51", "51 - Get all driverHasCars");
        menu.put("52", "52 - Get driverHasCar by ID");
        menu.put("53", "53 - Create driverHasCar");
        menu.put("54", "54 - Delete driverHasCar by ID");
        menu.put("55", "55 - Update driverHasCar by ID");

        methodsMenu.put("11", this::getAllPostOffices);
        methodsMenu.put("12", this::getPostOfficeById);
        methodsMenu.put("13", this::createPostOffice);
        methodsMenu.put("14", this::deletePostOfficeById);
        methodsMenu.put("15", this::updatePostOfficeById);

        methodsMenu.put("21", this::getAllDrivers);
        methodsMenu.put("22", this::getDriverById);
        methodsMenu.put("23", this::createDriver);
        methodsMenu.put("24", this::deleteDriverById);
        methodsMenu.put("25", this::updateDriverById);

        methodsMenu.put("31", this::getAllPostOfficeHasDrivers);
        methodsMenu.put("32", this::getPostOfficeHasDriverById);
        methodsMenu.put("33", this::createPostOfficeHasDriver);
        methodsMenu.put("34", this::deletePostOfficeHasDriverById);
        methodsMenu.put("35", this::updatePostOfficeHasDriverById);

        methodsMenu.put("41", this::getAllCars);
        methodsMenu.put("42", this::getCarById);
        methodsMenu.put("43", this::createCar);
        methodsMenu.put("44", this::deleteCarById);
        methodsMenu.put("45", this::updateCarById);

        methodsMenu.put("51", this::getAllDriverHasCars);
        methodsMenu.put("52", this::getDriverHasCarById);
        methodsMenu.put("53", this::createDriverHasCar);
        methodsMenu.put("54", this::deleteDriverHasCarById);
        methodsMenu.put("55", this::updateDriverHasCarById);

    }

    private void getAllPostOffices() throws SQLException {
        System.out.println("\nTable: PostOffices");
        postOfficeController.getAll();
    }

    private void getPostOfficeById() throws SQLException {
        System.out.println("Enter ID for PostOffice: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        postOfficeController.getById(id);
    }

    private void createPostOffice() throws SQLException {
        System.out.println("Enter new PostOffice capacity: ");
        int capacity = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new PostOffice phone_number: ");
        String phone_number = INPUT.nextLine();
        System.out.println("Enter new PostOffice hours_of_working: ");
        String hours_of_working = INPUT.nextLine();
        PostOffice entity = new PostOffice(0, capacity, phone_number, hours_of_working);
        postOfficeController.create(entity);
    }

    private void deletePostOfficeById() throws SQLException {
        System.out.println("Enter ID to delete PostOffice: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        postOfficeController.delete(id);
    }

    private void updatePostOfficeById() throws SQLException {
        System.out.println("Enter PostOffice id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PostOffice oldPostOffice = postOfficeController.getService().getById(id);
        System.out.println("Enter new capacity for PostOffice: ");
        int capacity = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new phone_number for PostOffice: ");
        String phone_number = INPUT.nextLine();
        System.out.println("Enter new hours_of_working for PostOffice: ");
        String hours_of_working = INPUT.nextLine();

        Integer newCapacity = capacity;
        String newPhoneNumber = phone_number;
        String newHoursOfWorking = hours_of_working;

        if (capacity < 0) newCapacity = oldPostOffice.getCapacity();
        if (phone_number.equals("")) newPhoneNumber = oldPostOffice.getPhoneNumber();
        if (hours_of_working.equals("")) newHoursOfWorking = oldPostOffice.getHoursOfWorking();

        PostOffice entity = new PostOffice(id, newCapacity, newPhoneNumber, newHoursOfWorking);
        postOfficeController.update(entity);
    }

    private void getAllDrivers() throws SQLException {
        System.out.println("\nTable: Driver");
        driverController.getAll();
    }

    private void getDriverById() throws SQLException {
        System.out.println("Enter id for Driver: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        driverController.getById(id);
    }

    private void createDriver() throws SQLException {

        System.out.println("Enter new Driver name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new Driver surname: ");
        String surname = INPUT.nextLine();
        System.out.println("Enter new Driver last_name: ");
        String last_name = INPUT.nextLine();
        System.out.println("Enter new Driver age: ");
        int age = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new Driver telephone_number: ");
        String telephone_number = INPUT.nextLine();
        System.out.println("Enter new Driver email: ");
        String email = INPUT.nextLine();

        Driver entity = new Driver(0, name, surname, last_name, age, telephone_number, email);
        driverController.create(entity);
    }

    private void deleteDriverById() throws SQLException {
        System.out.println("Enter ID to delete Driver: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        driverController.delete(id);
    }

    private void updateDriverById() throws SQLException {

        System.out.println("Enter Driver id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Driver oldDriver = driverController.getService().getById(id);


        System.out.println("Enter new Driver name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new Driver surname: ");
        String surname = INPUT.nextLine();
        System.out.println("Enter new Driver last_name: ");
        String last_name = INPUT.nextLine();
        System.out.println("Enter new Driver age: ");
        int age = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new Driver telephone_number: ");
        String telephone_number = INPUT.nextLine();
        System.out.println("Enter new Driver email: ");
        String email = INPUT.nextLine();

        String newName = name;
        String newSurname = surname;
        String newLastName = last_name;
        Integer newAge = age;
        String newTelephoneNumber = telephone_number;
        String newEmail = email;


        if (name.equals("")) newName = oldDriver.getName();
        if (surname.equals("")) newSurname = oldDriver.getSurname();
        if (last_name.equals("")) newLastName = oldDriver.getLastName();
        if (age < 0) newAge = oldDriver.getAge();
        if (telephone_number.equals("")) newTelephoneNumber = oldDriver.getTelephoneNumber();
        if (email.equals("")) newEmail = oldDriver.getEmail();


        Driver entity = new Driver(id, newName, newSurname, newLastName, newAge, newTelephoneNumber, newEmail);
        driverController.update(entity);
    }

    private void getAllPostOfficeHasDrivers() throws SQLException {
        System.out.println("\nTable: PostOfficeHasDriver");
        postOfficeHasDriverController.getAll();
    }

    private void getPostOfficeHasDriverById() throws SQLException {
        System.out.println("Enter ID for PostOfficeHasDriver: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        postOfficeHasDriverController.getById(id);
    }

    private void createPostOfficeHasDriver() throws SQLException {
        System.out.println("Enter new PostOfficeHasDriver postOfficeId: ");
        int post_office_id = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new PostOfficeHasDriver driverId: ");
        int driver_id = INPUT.nextInt();
        INPUT.nextLine();

        PostOfficeHasDriver entity = new PostOfficeHasDriver(post_office_id, driver_id);
        postOfficeHasDriverController.create(entity);
    }

    private void deletePostOfficeHasDriverById() throws SQLException {
        System.out.println("Enter ID to delete PostOfficeHasDriver: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        postOfficeHasDriverController.delete(id);
    }

    private void updatePostOfficeHasDriverById() throws SQLException {
        System.out.println("Enter PostOfficeHasDriver id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PostOfficeHasDriver oldPostOfficeHasDriver = postOfficeHasDriverController.getService().getById(id);


        System.out.println("Enter new PostOfficeHasDriver postOfficeId: ");
        int post_office_id = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new PostOfficeHasDriver driverId: ");
        int driver_id = INPUT.nextInt();
        INPUT.nextLine();

        Integer newPostOfficeId = post_office_id;
        Integer newDriverId = driver_id;


        if (post_office_id < 0) newPostOfficeId = oldPostOfficeHasDriver.getPostOfficeId();
        if (driver_id < 0) newDriverId = oldPostOfficeHasDriver.getDriverId();


        PostOfficeHasDriver entity = new PostOfficeHasDriver(newPostOfficeId, newDriverId);
        postOfficeHasDriverController.update(entity);
    }

    private void getAllCars() throws SQLException {
        System.out.println("\nTable: Car");
        carController.getAll();
    }

    private void getCarById() throws SQLException {
        System.out.println("Enter ID for Car: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        carController.getById(id);
    }

    private void createCar() throws SQLException {
        System.out.println("Enter new Car brand : ");
        String brand = INPUT.nextLine();
        System.out.println("Enter new Car number : ");
        Integer number = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new Car color : ");
        String color = INPUT.nextLine();
        Car entity = new Car(0, brand, number, color);
        carController.create(entity);
    }

    private void deleteCarById() throws SQLException {
        System.out.println("Enter ID to delete Car: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        carController.delete(id);
    }

    private void updateCarById() throws SQLException {
        System.out.println("Enter Car id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Car oldCar = carController.getService().getById(id);
        System.out.println("Enter new brand for Car: ");
        String brand = INPUT.nextLine();
        System.out.println("Enter new number for Car: ");
        int number = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new Car color : ");
        String color = INPUT.nextLine();


        String newBrand = brand;
        Integer newNumber = number;
        String newColor = color;


        if (brand.equals("")) newBrand = oldCar.getBrand();
        if (number < 0) newNumber = oldCar.getNumber();
        if (color.equals("")) newColor = oldCar.getColor();


        Car entity = new Car(id, newBrand, newNumber, newColor);
        carController.update(entity);
    }

    private void getAllDriverHasCars() throws SQLException {
        System.out.println("\nTable: DriverHasCar");
        driverHasCarController.getAll();
    }

    private void getDriverHasCarById() throws SQLException {
        System.out.println("Enter ID for DriverHasCar: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        driverHasCarController.getById(id);
    }

    private void createDriverHasCar() throws SQLException {

        System.out.println("Enter new DriverHasCar driverId: ");
        int driver_id = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new DriverHasCar carId: ");
        int car_id = INPUT.nextInt();
        INPUT.nextLine();

        DriverHasCar entity = new DriverHasCar(driver_id, car_id);
        driverHasCarController.create(entity);
    }

    private void deleteDriverHasCarById() throws SQLException {
        System.out.println("Enter ID to delete DriverHasCar: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        driverHasCarController.delete(id);
    }

    private void updateDriverHasCarById() throws SQLException {
        System.out.println("Enter DriverHasCar id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        DriverHasCar oldDriverHasCar = driverHasCarController.getService().getById(id);

        System.out.println("Enter new DriverHasCar driverId: ");
        int driver_id = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new DriverHasCar carId: ");
        int car_id = INPUT.nextInt();
        INPUT.nextLine();

        Integer newDriverId = car_id;
        Integer newCarId = driver_id;


        if (driver_id < 0) newDriverId = oldDriverHasCar.getDriverId();
        if (car_id < 0) newCarId = oldDriverHasCar.getCarId();

        DriverHasCar entity = new DriverHasCar(newDriverId, newCarId);
        driverHasCarController.create(entity);
    }


    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));


    }

}
