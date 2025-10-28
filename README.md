# JavaLab2

Лабораторная работа по Java, реализующая систему различных классов для работы с объектами: людьми, городами и котами.

## 📋 Содержание

- [Структура проекта](#структура-проекта)
- [Класс CheckInput](#Класс-CheckInput)
- [Класс Name](#Класс-Name)
- [Класс PersonWithName](#Класс-PersonWithName)
- [Класс City](#Класс-City)
- [Класс Cat](#Класс-Cat)
- [Демонстрация работы заданий](#Демонстрация-работы-заданий)

## 📁 Структура проекта

JavaLab2/

├── src/ # Исходный код  
│ ├── Main.java  
│ ├── CheckInput.java  
│ ├── Name.java  
│ ├── PersonWithName.java  
│ ├── Cat.java  
│ └── City.java  
├── README.md # Этот файл  
└── .gitignore # Git ignore файл  

### Основные классы

- **`Main.java`** - главный класс приложения с интерактивным меню
- **`CheckInput.java`** - утилитарный класс для валидации ввода и создания объектов

### Классы предметной области

#### Классы для работы с именами и людьми
- **`Name.java`** - класс для представления имени (фамилия, имя, отчество)
- **`PersonWithName.java`** - класс человека с именем, ростом и ссылкой на отца
- **`Cat.java`** - класс кота с возможностью мяукать

#### Классы для работы с городами
- **`City.java`** - класс города с маршрутами и стоимостью поездок  

## 🧩 CheckInput

Класс CheckInput содержит набор вспомогательных статических методов для безопасного и удобного взаимодействия с пользователем через консоль.
Он используется для создания объектов вручную (например, Name, PersonWithName, City, Cat) с проверкой корректности введённых данных.

---

### Реализованные методы:

1. **Проверка, можно ли преобразовать строку в целое число.** - `public static boolean isInteger(String str)`  
- Пытается выполнить `Integer.parseInt(str)`.  
- Если операция успешна — возвращает `true`.  
- Если выбрасывается исключение `NumberFormatException` — возвращает `false`.  
<img width="1328" height="169" alt="{008E7333-E8ED-416A-A38B-AACDC8D4620D}" src="https://github.com/user-attachments/assets/d675398f-a650-4f69-99e9-d584f206b03d" />
<img width="484" height="91" alt="{EE8AE0F9-7D37-4B8B-8BBF-386C01D97F87}" src="https://github.com/user-attachments/assets/8a1ce822-9ecb-4c39-9c1d-93e2c0e27e64" />  

2. **Получение ответа `y` или `n` от пользователя.** — `public static String getYN(Scanner scanner)`  
   - Выводит сообщение *«Хотите попробовать создать объекты самостоятельно? (y/n)»*.  
   - Считывает ввод пользователя в цикле.  
   - Если введено `y` или `n` (в любом регистре) — возвращает ответ.  
   - Иначе выводит сообщение *«Ошибка! Введите y или n.»* и повторяет запрос.  
<img width="655" height="306" alt="{8436F733-AC8C-4AF9-8B46-EDA73D66496C}" src="https://github.com/user-attachments/assets/074eebe0-bedb-46e8-a717-cc34098df692" />
<img width="602" height="90" alt="{1F9BA061-8D69-41FA-B1AE-33E099CC3BFC}" src="https://github.com/user-attachments/assets/917b5ee0-41cd-459a-bc7f-2e629ff245cf" />
<img width="589" height="86" alt="{F9DB70B3-1832-4BF9-A49D-645B1A878E5A}" src="https://github.com/user-attachments/assets/0f0b4916-21b6-448b-8662-6ecf4ca7f146" />
<img width="654" height="98" alt="{28511A9B-EC1D-421F-A34E-9EE05B2D265C}" src="https://github.com/user-attachments/assets/4da700bc-f4fc-44c3-a036-3cf5c4352d15" />  

3. **Создание объекта `Name` вручную.** — `public static Name nameByHand(Scanner scanner)`  
   - Запрашивает фамилию:  
     - Пустая строка -> `null`.  
     - Если содержит цифры -> повторяет ввод.  
   - Запрашивает имя:  
     - Обязательно должно быть заполнено.  
     - Не должно содержать цифр.  
   - Запрашивает отчество:  
     - Пустая строка -> `null`.  
     - Если содержит цифры -> повторяет ввод.  
   - Создаёт объект `Name(lastName, firstName, patronymic)`.  
   - Выводит результат и возвращает объект `Name`.
<img width="566" height="234" alt="{505B117C-BEFE-4B7E-A773-29633D9B59F4}" src="https://github.com/user-attachments/assets/f82b7014-9c10-43d8-a128-90b9348c41c7" />
<img width="603" height="228" alt="{0B895010-1410-4661-8C02-F631B35FD62E}" src="https://github.com/user-attachments/assets/560587b7-5f8a-49b6-bd32-ba1bf80f6ce6" />
<img width="594" height="159" alt="{A6E0F1BA-E760-4268-B578-F1341047EB9F}" src="https://github.com/user-attachments/assets/6cde598a-1cb9-4e31-852b-f43c91c994a2" />  
  
4. **Создание объекта `PersonWithName` вручную.** — `public static PersonWithName pwnByHand(Scanner scanner)`  
   - Вызывает `nameByHand(scanner)` для получения имени.  
   - Запрашивает рост человека:  
     - Считывает строку и преобразует в число.  
     - Проверяет, чтобы рост был в диапазоне `1–299`.  
     - При ошибке ввода повторяет запрос.  
   - Создаёт объект `PersonWithName(name, height)`.  
   - Выводит данные созданного человека и возвращает объект.
<img width="820" height="324" alt="{28AC7559-7844-44D4-8858-66FDC3364BB7}" src="https://github.com/user-attachments/assets/ae12d4ed-8da0-484d-b398-b45a97bf8e60" />  

5. **Создание списка городов и маршрутов.** — `public static ArrayList<City> citiesByHand(Scanner scanner)`  
   - Создаёт пустой список `ArrayList<City>`.  
   - В цикле запрашивает название города:  
     - Пустая строка -> завершение ввода.  
     - Иначе создаёт объект `City` и добавляет его в список.  
   - Если список пуст — выводит сообщение *«Города не были добавлены.»*.  
   - Для каждого города `fromCity`:  
     - Для каждого другого города `toCity`:  
       - Пропускает, если это тот же город.  
       - Запрашивает стоимость маршрута (`0` — если маршрута нет).  
       - Если значение корректное и `> 0` — добавляет маршрут `fromCity.addRoute(toCity, cost)`.  
   - После завершения выводит сообщение *«Создание завершено!»* и возвращает список городов.
<img width="890" height="764" alt="{A05BAFE3-F511-4BCB-A681-DCD2CA043C32}" src="https://github.com/user-attachments/assets/6a75d1ff-4c65-4fd4-ad20-b1e29da27808" />
<img width="690" height="180" alt="{62C339D9-351F-41A7-A9CC-EB3689FE3855}" src="https://github.com/user-attachments/assets/a94de9b3-1fc7-4efd-b925-9e2c62f47b81" />  

6. **Создание объекта `Cat` вручную.** — `public static Cat catByHand(Scanner scanner)`  
   - Запрашивает имя кота.  
   - Если строка пустая — устанавливает имя `"Безымянный"`.  
   - Создаёт объект `Cat(catName)` и возвращает его.  
<img width="524" height="157" alt="{86C7B042-FC24-4CDF-851B-A3A7409F33BA}" src="https://github.com/user-attachments/assets/485fecba-dad6-4797-8357-a1c049283ec5" />
<img width="568" height="267" alt="{9E8AC1CE-F1E8-4D6E-AB0E-C30DC9739AAE}" src="https://github.com/user-attachments/assets/ad4cfb71-59bc-456f-90a7-24fb4b890395" />  

## 🎮 Демонстрация работы заданий

При запуске программы появляется интерактивное меню с 7 заданиями для тестирования различных аспектов объектно-ориентированного программирования.

---

### Задание 1: Класс Name (1.3)

**Работа с именами человека**

<img width="1306" height="451" alt="{1161BE22-9CF5-4180-A489-B55405404059}" src="https://github.com/user-attachments/assets/196d51ea-992f-4eb6-9d42-4038a06db895" />
<img width="616" height="231" alt="{D6C4B16F-B3BE-4CFE-94C3-09FF2B3E9E61}" src="https://github.com/user-attachments/assets/9c891c82-0ba6-4b90-97bc-80de2de2baa5" />  

---

### Задание 2: Класс PersonWithName (2.2)

**Человек с именем и физическими характеристиками**

<img width="633" height="251" alt="{4DC7E67A-2B5B-4179-97CD-3BFD78C66A2F}" src="https://github.com/user-attachments/assets/684f6227-ceef-4ba5-8c7e-fe2acb476f48" />
<img width="678" height="253" alt="{415BC8AB-320E-4CF6-8A11-247928267FF6}" src="https://github.com/user-attachments/assets/9b057381-d170-4ba6-8fc2-32a86ce72bec" />  

---

### Задание 3: Наследование от отца (2.3)

**Семейные связи и наследование атрибутов**

<img width="1361" height="536" alt="{600B34BE-ABA6-41AF-A036-2A59373EC3C1}" src="https://github.com/user-attachments/assets/24817e47-e714-4f6f-8dbe-0ca0c0ee28bf" />
<img width="587" height="467" alt="{177C44F5-DF3B-4DC5-963F-E85D75FBA4EF}" src="https://github.com/user-attachments/assets/b1a93099-97a6-4407-ac0d-f4a7fdd9341d" />  

---

### Задание 4: Система городов (3.3)

**Географическая система с маршрутами**

<img width="1283" height="609" alt="{4415A2C2-9D30-4B06-91C7-D1F94AC96A5C}" src="https://github.com/user-attachments/assets/8eb84220-ff02-4c6f-8a3e-29e04644ee6c" />
<img width="753" height="786" alt="{AFAD06D0-5C82-49C8-8E17-B972129936A2}" src="https://github.com/user-attachments/assets/82bc6222-f1ac-4b49-a4f6-8371fd3f1cc3" />
<img width="378" height="244" alt="{CFE71FA6-6F37-4685-A578-6A3949520E15}" src="https://github.com/user-attachments/assets/84e48f81-db9d-4684-9813-415364fe448d" />  

---

### Задание 5: Расширенный Name (4.5)

**Усовершенствованная работа с именами**

<img width="756" height="400" alt="{4779CB02-3CBA-4214-B238-6078D9A2AFAC}" src="https://github.com/user-attachments/assets/42b179ec-9d6e-45b0-9c9d-4c381c19f379" />
<img width="588" height="248" alt="{8162F382-2BDC-4D2C-8429-0AD2A064C8AF}" src="https://github.com/user-attachments/assets/d042a8e2-767b-4b1e-bc7a-e308d406e18b" />
<img width="613" height="210" alt="{C1379445-1356-4E76-ABE9-FBEDB2665CA2}" src="https://github.com/user-attachments/assets/a18ba048-042d-4134-a5ba-946a06e1a87c" />
<img width="631" height="211" alt="{861D74A6-67D2-4D51-980F-E3886D513EEB}" src="https://github.com/user-attachments/assets/5b96d6d9-b53c-49bd-b542-6f713fccfc33" />

---

### Задание 6: Расширенный PersonWithName (4.6)

**Расширенная система персонажей**

<img width="895" height="654" alt="{7A1ACD93-0EC8-4577-9B21-7EE035D6BFC4}" src="https://github.com/user-attachments/assets/00b9dbd0-1def-45f6-b3a8-056a6b076b6c" />
<img width="616" height="450" alt="{BFE4030B-2F11-408D-9133-E104DE8EA904}" src="https://github.com/user-attachments/assets/6fc48432-7659-41cd-aff0-a9c7eb940569" />
<img width="650" height="471" alt="{0CD24282-F986-47D1-A21F-5DC55F5FE193}" src="https://github.com/user-attachments/assets/27cab979-1b67-4f1e-94ff-b106cecbd28b" />  

---

### Задание 7: Класс Cat (5.2)

**Интерактивная работа с животными**

<img width="796" height="260" alt="{514DFE1B-ECB2-4A03-9408-0435595EF7D3}" src="https://github.com/user-attachments/assets/c98a7173-ca5a-4d45-bb17-0722ac3cdfba" />
<img width="682" height="211" alt="{D60828A6-2401-471F-BE70-87291B5EF704}" src="https://github.com/user-attachments/assets/e2f4d637-f983-4883-8cd9-05d40d13d614" />
<img width="656" height="237" alt="{FFFE5044-E805-4695-AA67-14E2CCF48E42}" src="https://github.com/user-attachments/assets/6802e0ff-c590-4bb4-a779-461c053c5799" />

---











