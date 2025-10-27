import java.util.Scanner;
import java.util.ArrayList;

public class CheckInput {

  public static boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static String getYN(Scanner scanner) {
    System.out.println("Хотите попробовать создать объекты самостоятельно? (y/n)");
    String m;
    while (true) {
      m = scanner.nextLine();
      if (m.equalsIgnoreCase("y") || m.equalsIgnoreCase("n")) {
        break;
      } else {
        System.out.println("Ошибка! Введите y или n.");
      }
    }
    return m;
  }

  public static Name nameByHand(Scanner scanner) {
    String lastName, firstName, patronymic;

    System.out.print("Введите фамилию (можно оставить пустой): ");
    while (true) {
      lastName = scanner.nextLine().trim();
      if (lastName.isEmpty()) {
        lastName = null;
        break;
      } else if (lastName.matches(".*\\d.*")) {
        System.out.print("Фамилия не должна содержать цифры. Введите снова: ");
      } else {
        break;
      }
    }

    System.out.print("Введите имя (обязательно): ");
    while (true) {
      firstName = scanner.nextLine().trim();
      if (firstName.isEmpty()) {
        System.out.print("Имя не может быть пустым. Введите имя: ");
      } else if (firstName.matches(".*\\d.*")) {
        System.out.print("Имя не должно содержать цифры. Введите снова: ");
      } else {
        break;
      }
    }

    // Ввод отчества
    System.out.print("Введите отчество (можно оставить пустым): ");
    while (true) {
      patronymic = scanner.nextLine().trim();
      if (patronymic.isEmpty()) {
        patronymic = null;
        break;
      } else if (patronymic.matches(".*\\d.*")) {
        System.out.print("Отчество не должно содержать цифры. Введите снова: ");
      } else {
        break;
      }
    }

    Name name = new Name(lastName, firstName, patronymic);
    System.out.println("Создан объект: " + name);
    return name;
  }

  public static PersonWithName pwnByHand(Scanner scanner) {
    Name name = nameByHand(scanner);
    int height = 0;
    while (true) {
      System.out.print("Введите рост (в см, от 1 до 299): ");
      String input = scanner.nextLine();
      try {
        height = Integer.parseInt(input);
        if (height > 0 && height < 300) {
          break;
        } else {
          System.out.println("Рост должен быть в пределах от 1 до 299.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: введите число!");
      }
    }
    PersonWithName person = new PersonWithName(name, height);
    System.out.println("Создан человек: " + person);
    return person;
  }

  public static ArrayList<City> citiesByHand(Scanner scanner) {
    ArrayList<City> cities = new ArrayList<>();
    System.out.println("Создание списка городов ");
    while (true) {
      System.out.print("Введите название города (или пустую строку, чтобы завершить): ");
      String name = scanner.nextLine();

      if (name.isEmpty()) {
        break;
      }

      City city = new City(name);
      cities.add(city);
      System.out.println("Добавлен город: " + name);
    }

    if (cities.isEmpty()) {
      System.out.println("Города не были добавлены.");
      return cities;
    }

    System.out.println("\nДобавление маршрутов между городами");
    for (City fromCity : cities) {
      System.out.println("\nДобавляем маршруты из города " + fromCity.getName());

      for (City toCity : cities) {
        if (toCity == fromCity) {
          continue; // маршрут в самого себя
        }

        System.out.print("Введите стоимость поездки до города " + toCity.getName()
            + " (0 — если маршрута нет): ");

        String input = scanner.nextLine();
        if (input.isEmpty()) {
          continue;
        }

        try {
          int cost = Integer.parseInt(input);
          if (cost > 0) {
            fromCity.addRoute(toCity, cost);
            System.out.println("Добавлен маршрут: " + fromCity.getName()
                + " -> " + toCity.getName() + " : " + cost);
          }
        } catch (NumberFormatException e) {
          System.out.println("Некорректное значение. Пропускаем.");
        }
      }
    }
    System.out.println("\nСоздание завершено!");
    return cities;
  }

  public static Cat catByHand(Scanner scanner) {
    System.out.print("Введите имя кота: ");
    String catName = scanner.nextLine().trim();
    if (catName.isEmpty()) {
      System.out.println("Имя не может быть пустым. Используем 'Безымянный'.");
      catName = "Безымянный";
    }
    return new Cat(catName);
  }

}
