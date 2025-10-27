import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CheckInput checkInput = new CheckInput();
    int n = 0;

    System.out.println(
        "Добрый день! Вы рассматриваете лабораторную работу №2, введите номер задания, которое хотите проверить (всего имеется 7 заданий");

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
            "Ошибка ввода! Нужно ввести номер задания, а не текст. Пожалуйста, повторите попытку ввода.");
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

        String input1 = checkInput.getYN(scanner);
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

        String input2 = checkInput.getYN(scanner);
        PersonWithName pwn = checkInput.pwnByHand(scanner);
        System.out.println("Объект класса PersonWithName, созданный Вами: " + pwn.toString());
        break;

      case 3:
        System.out.println("Под №3 скрывается задание 2.3");
        System.out.println(
            "Оно подразумевает добавление к классу PersonWithName возможности задавать "
                + "третий параметр: Отец, где Отец — это тоже Человек.\n"
                + "- Если у данного человека нет фамилии, и есть отец, у которого фамилия задана, то "
                + "фамилию необходимо сделать такой же как у отца.\n"
                + "- Если у данного человека нет отчества, а у отца есть имя, то необходимо задать отчество "
                + "как имя отца с добавлением суффикса \"ович\".\n");
        System.out.println("Пример:");
        Name ivanName = new Name("Чудов", "Иван");
        PersonWithName ivan = new PersonWithName(ivanName, 180);
        Name petrName = new Name("Чудов", "Петр");
        System.out.println(ivanName.toString());
        System.out.println(petrName.toString());
        PersonWithName petr = new PersonWithName(petrName, 175, ivan);
        System.out.println("Теперь Иван - отец Петра: ");
        System.out.println(ivan.toString());
        System.out.println(petr.toString());
        System.out.println("Борис без отчества и фамилии: ");
        Name borisName = new Name("Борис");
        System.out.println(borisName.toString());
        System.out.println("Теперь Петр - отец Бориса: ");
        PersonWithName boris = new PersonWithName(borisName, 170, petr);
        System.out.println(boris.toString());

        String input3 = checkInput.getYN(scanner);

        System.out.println("Создайте объект, который является отцом: ");
        Name dad = checkInput.nameByHand(scanner);
        int dadHeight;
        while (true) {
          System.out.print("Введите рост отца (0 < рост < 300): ");
          try {
            dadHeight = Integer.parseInt(scanner.nextLine());
            if (dadHeight > 0 && dadHeight < 300) {
              break;
            }
          } catch (NumberFormatException e) {
          }
          System.out.println("Ошибка! Рост должен быть числом от 1 до 299.");
        }
        PersonWithName Dad = new PersonWithName(dad, dadHeight);
        System.out.println("Объект, созданный Вами: " + Dad.toString());

        System.out.println("Создайте объект, который является сыном: ");
        Name son = checkInput.nameByHand(scanner);
        int sonHeight;
        while (true) {
          System.out.print("Введите рост отца (0 < рост < 300): ");
          try {
            sonHeight = Integer.parseInt(scanner.nextLine());
            if (sonHeight > 0 && sonHeight < 300) {
              break;
            }
          } catch (NumberFormatException e) {
          }
          System.out.println("Ошибка! Рост должен быть числом от 1 до 299.");
        }
        PersonWithName Son = new PersonWithName(son, sonHeight, Dad);
        System.out.println("Объект, созданный Вами: " + Son.toString());
        break;

      case 4:
        System.out.println("Под №4 скрывается задание 3.3");
        System.out.println("Оно подразумевает создайте сущность Город, которая будет\n"
            + " представлять собой точку на карте со следующими характеристиками:\n"
            + "Название города\n"
            + "Набор путей к следующим городам, где путь представляет собой сочетание Города и\n"
            + "стоимости поездки в него.\n"
            + "Кроме того, Город может возвращать текстовое представление, "
            + "в виде названия города и списка\n"
            + "связанных с ним городов (в виде пары: “название:стоимость”).");
        System.out.println("Пример: ");

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

        System.out.println(
            "\nСтоимость маршрута из Москвы в Казань: " + moscow.getRouteCost(kazan));
        System.out.println("Стоимость маршрута из Казани в Москву: " + kazan.getRouteCost(moscow));

        String input4 = checkInput.getYN(scanner);
        ArrayList<City> cities = checkInput.citiesByHand(scanner);
        System.out.println("Список городов и маршрутов:\n");
        for (City city : cities) {
          System.out.println(city);
        }
        break;

      case 5:
        System.out.println("Под №5 скрывается задание 4.5");
        System.out.println("Оно предполагает изменение класса Name. Новые требования включают:\n"
            + "Имя можно создать указав только Личное имя\n"
            + "Имя можно создать указав Личное имя и Фамилию.\n"
            + "Имя можно создать указав все три параметра: Личное имя, Фамилию, Отчество.");
        System.out.println("Пример: ");
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Сергеевич", "Пушкин");
        Name name3 = new Name("Владимир", "Маяковский");
        Name name4 = new Name("Христофор", "Бонифатьевич");
        System.out.println(name1.toString());
        System.out.println(name2.toString());
        System.out.println(name3.toString());
        System.out.println(name4.toString());

        String input5 = checkInput.getYN(scanner);
        Name name5 = checkInput.nameByHand(scanner);
        System.out.println("Объект класса Name, созданный Вами: " + name5.toString());
        break;

      case 6:
        System.out.println("Под №6 скрывается задание 4.6");
        System.out.println(
            "Оно предполагает изменение класса PersonWithName. Новые требования включают:\n"
                + "Человека можно создать с указанием имени в виде строки и роста в виде целого числа.\n"
                + "При таком способе задания имени должно считаться, что Человеку задано только личное имя.\n"
                + "Человека можно создать с указанием имени в виде строки, роста в виде целого числа и\n"
                + "отца в виде Человека. В этом случае необходимо проставить отчество в соответствии с\n"
                + "именем отца и присвоить текущему человеку фамилию отца.\n"
                + "Человека можно создать с указанием имени в виде объекта типа Имя (из задачи 4.5) и\n"
                + "роста в виде целого числа.\n"
                + "Человека можно создать с указанием имени в виде объекта типа Имя (из задачи 4.5),\n"
                + "роста в виде целого числа и отца в виде Человека. В этом случае необходимо проверить\n"
                + "что в Имени задано отчество и фамилия, и если они не заданы, то необходимо их задать\n"
                + "(отчество в соответствии с именем отца и фамилию отца).\n"
                + "Реализуйте описанные способы создания Человека таким образом, чтобы операции\n"
                + "присвоения использовались только в одном из конструкторов.\n"
                + "Необходимо модифицировать способ приведения Человека к строке, теперь текстовая\n"
                + "форма должна быть представлена строкой: “Имя, рост”\n");

        PersonWithName lev = new PersonWithName("Лев", 170);
        System.out.println(lev.toString());
        Name sergeyName = new Name("Пушкин", "Сергей");
        PersonWithName sergey = new PersonWithName(sergeyName, 168, lev);
        System.out.println(sergey.toString());
        PersonWithName alex = new PersonWithName("Александр", 167, sergey);
        System.out.println(alex.toString());
        String input6 = checkInput.getYN(scanner);

        System.out.println("Создайте объект, который является отцом: ");
        Name father = checkInput.nameByHand(scanner);
        int fatherHeight;
        while (true) {
          System.out.print("Введите рост отца (0 < рост < 300): ");
          try {
            fatherHeight = Integer.parseInt(scanner.nextLine());
            if (fatherHeight > 0 && fatherHeight < 300) {
              break;
            }
          } catch (NumberFormatException e) {
          }
          System.out.println("Ошибка! Рост должен быть числом от 1 до 299.");
        }
        PersonWithName Father = new PersonWithName(father, fatherHeight);
        System.out.println("Объект, созданный Вами: " + Father.toString());

        System.out.println("Создайте объект, который является сыном: ");
        Name kid = checkInput.nameByHand(scanner);
        int kidHeight;
        while (true) {
          System.out.print("Введите рост отца (0 < рост < 300): ");
          try {
            kidHeight = Integer.parseInt(scanner.nextLine());
            if (kidHeight > 0 && kidHeight < 300) {
              break;
            }
          } catch (NumberFormatException e) {
          }
          System.out.println("Ошибка! Рост должен быть числом от 1 до 299.");
        }
        PersonWithName Kid = new PersonWithName(kid, kidHeight, Father);
        System.out.println("Объект, созданный Вами: " + Kid.toString());
        break;

      case 7:
        System.out.println("Под №7 скрывается задание 5.2");
        System.out.println(
            "Оно предполагает создание сущности кота, который имеет имя и может мяукать");
        Cat barsik = new Cat("Барсик");
        System.out.println(barsik.toString());
        barsik.meow();
        barsik.meow(3);
        String input7 = checkInput.getYN(scanner);
        Cat yourCat = checkInput.catByHand(scanner);
        System.out.println("Объект класса Name, созданный Вами: " + yourCat.toString());
        System.out.println("Сколько раз коту мяукнуть?");
        int meowCount;
        String count = scanner.nextLine();
        while (true) {
          if (checkInput.isInteger(count)) {
            meowCount = Integer.parseInt(count);
            break;
          }
        }
        yourCat.meow(meowCount);
        break;
    }
  }
}