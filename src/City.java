import java.util.ArrayList;

public class City {

  private String name;
  private ArrayList<City> targetCities;
  private ArrayList<Integer> costs;

  // Конструктор
  public City(String name) {
    this.name = name;
    this.targetCities = new ArrayList<>();
    this.costs = new ArrayList<>();
  }

  // Геттер для имени города
  public String getName() {
    return name;
  }

  // Сеттер для имени города (если нужно изменить)
  public void setName(String name) {
    this.name = name;
  }

  // Добавление маршрута к другому городу
  public void addRoute(City targetCity, int cost) {
    if (targetCity != null && targetCity != this && cost > 0) {
      targetCities.add(targetCity);
      costs.add(cost);
    }
  }

  // Получение стоимости маршрута до конкретного города
  public Integer getRouteCost(City targetCity) {
    for (int i = 0; i < targetCities.size(); i++) {
      if (targetCities.get(i) == targetCity) {
        return costs.get(i);
      }
    }
    return null; // если маршрута нет
  }

  // Получение списка всех целевых городов
  public ArrayList<City> getTargetCities() {
    return targetCities;
  }

  // Получение списка стоимостей маршрутов
  public ArrayList<Integer> getCosts() {
    return costs;
  }

  // Вывод всех маршрутов в виде строки
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);

    if (!targetCities.isEmpty()) {
      sb.append(" -> ");
      for (int i = 0; i < targetCities.size(); i++) {
        if (i > 0) {
          sb.append(", ");
        }
        sb.append(targetCities.get(i).getName())
            .append(":")
            .append(costs.get(i));
      }
    } else {
      sb.append(" (нет маршрутов)");
    }

    return sb.toString();
  }
}
