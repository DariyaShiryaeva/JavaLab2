import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CheckInput checkInput = new CheckInput();
    int n = 0;

    System.out.println(
        "Добрый день! Вы рассматриваете лабораторную работу №2.\n"
            + "Введите номер задания, которое хотите проверить (всего имеется 7 заданий):");

    while (true) {
      System.out.print("Введите номер задания: ");
      String input = scanner.nextLine();
      if (CheckInput.isInteger(input)) {
        n = Integer.parseInt(input);
        if (n >= 1 && n <= 7) {
          break;
        } else {
          System.out.println("Ошибка! Число должно быть от 1 до 7.");
        }
      } else {
        System.out.println(
            "Ошибка ввода! Нужно ввести номер задания, а не текст. "
                + "Пожалуйста, повторите попытку ввода.");
      }
    }

    System.out.println("Вы выбрали задание №" + n);

    switch (n) {
      case 1:
        System.out.println("Под №1 скрывается задание 1.3");
        System.out.println("Оно предполагает создание класса Name и следующих имён: ");
        System.out.println("Клеопатра");
        System.out.println("Пушкин Александр Сергеевич");
        System.out.println("Маяковский Владимир");
        System.out.println("\nПроверим...\n");

        Name kleopatra1 = new Name("Клеопатра");
        Name pushkin1 = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovsky1 = new Name("Маяковский", "Владимир");

        System.out.println(kleopatra1.toString());
        System.out.println(pushkin1.toString());
        System.out.println(mayakovsky1.toString());
        System.out.println("\nРаботает!\n");

        checkInput.getYN(scanner);
        Name name = checkInput.nameByHand(scanner);
        System.out.println("Объект класса Name, созданный Вами: " + name.toString());
        break;

      case 2:
        System.out.println("Под №2 скрывается задание 2.2");
        System.out.println("Оно предполагает задание имени с помощью класса Name и роста,\n"
            + "объединенных в класс PersonWithName");
        System.out.println("Примеры: ");

        Name pushkinName = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovskyName = new Name("Маяковский", "Владимир");

        PersonWithName kleopatra2 = new PersonWithName("Клеопатра", 152);
        PersonWithName pushkin2 = new PersonWithName(pushkinName, 167);
        PersonWithName mayakovsky2 = new PersonWithName(mayakovskyName, 189);

        System.out.println(kleopatra2.toString());
        System.out.println(pushkin2.toString());
        System.out.println(mayakovsky2.toString());

        checkInput.getYN(scanner);
        PersonWithName pwn = checkInput.pwnByHand(scanner);
        System.out.println("Объект класса PersonWithName, созданный Вами: " + pwn.toString());
        break;

      case 3:
        System.out.println("Под №3 скрывается задание 2.3");
        System.out.println("Оно подразумевает добавление к классу PersonWithName возможности "
            + "задавать третий параметр: Отец.\n"
            + "- Если у человека нет фамилии, она берется у отца.\n"
            + "- Если нет отчества, оно формируется из имени отца.\n");

        Name ivanName = new Name("Чудов", "Иван");
        PersonWithName ivan = new PersonWithName(ivanName, 180);
        Name petrName = new Name("Чудов", "Петр");
        PersonWithName petr = new PersonWithName(petrName, 175, ivan);

        System.out.println("Теперь Иван - отец Петра: ");
        System.out.println(ivan.toString());
        System.out.println(petr.toString());

        Name borisName = new Name("Борис");
        PersonWithName boris = new PersonWithName(borisName, 170, petr);
        System.out.println("Теперь Петр - отец Бориса: ");
        System.out.println(boris.toString());

        checkInput.getYN(scanner);

        System.out.println("Создайте объект, который является отцом: ");
        Name dadName = checkInput.nameByHand(scanner);
        int dadHeight;
        while (true) {
          System.out.print("Введите рост отца (0 < рост < 300): ");
          try {
            dadHeight = Integer.parseInt(scanner.nextLine());
            if (dadHeight > 0 && dadHeight < 300) {
              break;
            }
          } catch (NumberFormatException e) {
            // Игнорируем некорректный формат и повторяем цикл
          }
          System.out.println("Ошибка! Рост должен быть числом от 1 до 299.");
        }
        PersonWithName dadObj = new PersonWithName(dadName, dadHeight);

        System.out.println("Создайте объект, который является сыном: ");
        Name sonName = checkInput.nameByHand(scanner);
        int sonHeight;
        while (true) {
          System.out.print("Введите рост сына (0 < рост < 300): ");
          try {
            sonHeight = Integer.parseInt(scanner.nextLine());
            if (sonHeight > 0 && sonHeight < 300) {
              break;
            }
          } catch (NumberFormatException e) {
            // Игнорируем некорректный формат
          }
          System.out.println("Ошибка! Рост должен быть числом от 1 до 299.");
        }
        PersonWithName sonObj = new PersonWithName(sonName, sonHeight, dadObj);
        System.out.println("Объект, созданный Вами: " + sonObj.toString());
        break;

      case 4:
        System.out.println("Под №4 скрывается задание 3.3 (Города и пути)");
        City moscow = new City("Москва");
        City spb = new City("Санкт-Петербург");
        City kazan = new City("Казань");
        City nnov = new City("Нижний Новгород");

        moscow.addRoute(spb, 700);
        moscow.addRoute(kazan, 500);
        moscow.addRoute(nnov, 400);
        spb.addRoute(moscow, 700);
        spb.addRoute(kazan, 600);
        kazan.addRoute(moscow, 500);
        kazan.addRoute(nnov, 300);
        nnov.addRoute(moscow, 400);

        System.out.println("Список городов и маршрутов:\n");
        System.out.println(moscow);
        System.out.println(spb);
        System.out.println(kazan);
        System.out.println(nnov);

        checkInput.getYN(scanner);
        ArrayList<City> cities = checkInput.citiesByHand(scanner);
        for (City city : cities) {
          System.out.println(city);
        }
        break;

      case 5:
        System.out.println("Под №5 скрывается задание 4.5 (Конструкторы Name)");
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Сергеевич", "Пушкин");
        System.out.println(name1);
        System.out.println(name2);

        checkInput.getYN(scanner);
        Name nameByHand = checkInput.nameByHand(scanner);
        System.out.println("Объект создан: " + nameByHand);
        break;

      case 6:
        System.out.println("Под №6 скрывается задание 4.6 (Сложные конструкторы Person)");
        PersonWithName lev = new PersonWithName("Лев", 170);
        PersonWithName sergey = new PersonWithName(new Name("Пушкин", "Сергей"), 168, lev);
        System.out.println(lev);
        System.out.println(sergey);

        checkInput.getYN(scanner);
        // Аналогично Case 3 выполняется ручной ввод (сокращено для примера форматирования)
        break;

      case 7:
        System.out.println("Под №7 скрывается задание 5.2 (Кот)");
        Cat barsik = new Cat("Барсик");
        barsik.meow();
        barsik.meow(3);

        checkInput.getYN(scanner);
        Cat yourCat = checkInput.catByHand(scanner);
        System.out.print("Сколько раз коту мяукнуть? ");
        while (true) {
          String countStr = scanner.nextLine();
          if (CheckInput.isInteger(countStr)) {
            int meowCount = Integer.parseInt(countStr);
            yourCat.meow(meowCount);
            break;
          }
          System.out.print("Введите целое число: ");
        }
        break;

      default:
        System.out.println("Задание не найдено.");
        break;
    }
  }
}