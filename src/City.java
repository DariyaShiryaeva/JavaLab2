import java.util.ArrayList;

/** Представляет город как узел в графе с маршрутами и их стоимостью. */
public class City {

  private String name;
  private final ArrayList<City> targetCities;
  private final ArrayList<Integer> costs;

  /**
   * Конструктор города.
   *
   * @param name Название города.
   */
  public City(String name) {
    this.name = name;
    this.targetCities = new ArrayList<>();
    this.costs = new ArrayList<>();
  }

  /** Возвращает название города. */
  public String getName() {
    return name;
  }

  /** Устанавливает название города. */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Добавляет маршрут к другому городу.
   *
   * @param targetCity Город назначения.
   * @param cost Стоимость поездки (должна быть больше 0).
   */
  public void addRoute(City targetCity, int cost) {
    if (targetCity != null && targetCity != this && cost > 0) {
      targetCities.add(targetCity);
      costs.add(cost);
    }
  }

  /**
   * Возвращает стоимость маршрута до конкретного города.
   *
   * @param targetCity Город назначения.
   * @return Стоимость маршрута или null, если пути не существует.
   */
  public Integer getRouteCost(City targetCity) {
    for (int i = 0; i < targetCities.size(); i++) {
      if (targetCities.get(i) == targetCity) {
        return costs.get(i);
      }
    }
    return null;
  }

  /** Возвращает список всех доступных из данного города направлений. */
  public ArrayList<City> getTargetCities() {
    return targetCities;
  }

  /** Возвращает список стоимостей всех маршрутов. */
  public ArrayList<Integer> getCosts() {
    return costs;
  }

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
        sb.append(targetCities.get(i).getName()).append(":").append(costs.get(i));
      }
    } else {
      sb.append(" (нет маршрутов)");
    }

    return sb.toString();
  }
}