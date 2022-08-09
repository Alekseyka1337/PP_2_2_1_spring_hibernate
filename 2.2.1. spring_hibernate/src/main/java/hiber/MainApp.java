package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        User user5 = new User("User5", "Lastname5", "user5@mail.ru");

        Car car1 = new Car("Model1", 10);
        Car car2 = new Car("Model2", 20);
        Car car3 = new Car("Model2", 20);
        Car car4 = new Car("Model2", 30);

        user1.setUserCar(car1);
        user2.setUserCar(car2);
        user3.setUserCar(car3);
        user4.setUserCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);

        for (User user : userService.listUsers()) {
            System.out.println(user);
        }
        for (User user : userService.getUserByCar("Model1", 10)) {
            System.out.println(user);
        }
        for (User user : userService.getUserByCar("Model2", 20)) {
            System.out.println(user);
        }
        for (User user : userService.getUserByCar("Model3", 0)) {
            System.out.println(user);
        }
        context.close();
    }
}
