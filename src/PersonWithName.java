public class PersonWithName {

  private Name name;
  private int height;
  private PersonWithName father;

  // Приватный конструктор для централизованного присвоения
  public PersonWithName(Name name, int height, PersonWithName father) {
    this.name = name != null ? name : new Name();
    this.height = (height > 0 && height < 300) ? height : 0;
    this.father = father;
    if (father != null) {
      inheritFromFather();
    }
  }

  // Конструкторы
  public PersonWithName(String firstName, int height) {
    this(new Name(firstName), height, null);
  }

  public PersonWithName(String firstName, int height, PersonWithName father) {
    this(new Name(firstName), height, father);
  }

  public PersonWithName(Name name, int height) {
    this(name, height, null);
  }

  // Геттеры и сеттеры
  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name != null ? name : new Name();
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = (height > 0 && height < 300) ? height : 0;
  }

  public PersonWithName getFather() {
    return father;
  }

  public void setFather(PersonWithName father) {
    this.father = father;
    if (father != null) {
      inheritFromFather();
    }
  }

  // Наследование фамилии и отчества от отца
  private void inheritFromFather() {
    if (father != null && father.name != null) {
      // Наследуем фамилию
      if (!name.hasLastName() && father.name.hasLastName()) {
        name.setLastName(father.name.getLastName());
      }
      // Наследуем отчество
      if (!name.hasPatronymic() && father.name.hasFirstName()) {
        name.setPatronymic(generatePatronymic(father.name.getFirstName()));
      }
    }
  }

  // Генерация отчества по имени отца
  private String generatePatronymic(String fathersName) {
    if (fathersName == null || fathersName.isEmpty()) {
      return null;
    }
    if (fathersName.endsWith("й")) {
      return fathersName + "евич";
    }
    return fathersName + "ович";
  }

  @Override
  public String toString() {
    return name.toString() + ", " + height;
  }
}