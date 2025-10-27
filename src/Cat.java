public class Cat {

  private String name;

  // Конструктор с именем
  public Cat(String name) {
    this.name = name;
  }

  // Приведение к строковой форме
  @Override
  public String toString() {
    return "кот: " + name;
  }

  // Мяукнуть один раз
  public void meow() {
    System.out.println(name + ": мяу!");
  }

  // Мяукнуть N раз
  public void meow(int n) {
    if (n <= 0) {
      System.out.println(name + ": ");
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append("мяу");
      if (i < n - 1) {
        sb.append("-");
      }
    }
    System.out.println(name + ": " + sb.toString() + "!");
  }
}