/** Представляет имя человека, состоящее из фамилии, имени и отчества. */
public class Name {

  private String lastName;
  private String firstName;
  private String patronymic;

  /** Пустой конструктор. */
  public Name() {}

  /** Конструктор только с именем. */
  public Name(String firstName) {
    this(null, firstName, null);
  }

  /** Конструктор с фамилией и именем. */
  public Name(String lastName, String firstName) {
    this(lastName, firstName, null);
  }

  /** Полный конструктор со всеми параметрами. */
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

  /** Проверяет, заполнена ли фамилия. */
  public boolean hasLastName() {
    return lastName != null && !lastName.isEmpty();
  }

  /** Проверяет, заполнено ли имя. */
  public boolean hasFirstName() {
    return firstName != null && !firstName.isEmpty();
  }

  /** Проверяет, заполнено ли отчество. */
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