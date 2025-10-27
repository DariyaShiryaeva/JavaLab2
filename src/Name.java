public class Name {

  private String lastName;
  private String firstName;
  private String patronymic;

  // Конструкторы
  public Name() {
  }

  public Name(String firstName) {
    this.firstName = firstName;
  }

  public Name(String lastName, String firstName) {
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public Name(String lastName, String firstName, String patronymic) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.patronymic = patronymic;
  }

  // Геттеры и сеттеры
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  // Проверка, заполнены ли компоненты имени
  public boolean hasLastName() {
    return lastName != null && !lastName.isEmpty();
  }

  public boolean hasFirstName() {
    return firstName != null && !firstName.isEmpty();
  }

  public boolean hasPatronymic() {
    return patronymic != null && !patronymic.isEmpty();
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    if (hasLastName()) {
      result.append(lastName);
    }
    if (hasFirstName()) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(firstName);
    }
    if (hasPatronymic()) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(patronymic);
    }
    return result.toString();
  }
}