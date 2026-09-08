// Файл: Roblox.java
import java.util.Scanner;
import java.util.Random;

public class Roblox {
    private static Player currentPlayer;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // Список из 26 игр согласно канону
    private static final String[] GAMES = new String[26];

    static {
        GAMES[0] = "Машина против машины робота";
        GAMES[1] = "Сражалки на мечах (Классика)";
        GAMES[2] = "Онлайн игра с мячом (Бегай и убивай)";
        GAMES[3] = "Выкидывать кровать";
        GAMES[4] = "Сменить Аватар на боя лучший";
        GAMES[5] = "Закрыть двери (Мультиплеер)";
        GAMES[6] = "Сражалки на мечах (Продолжение 7)";
        GAMES[7] = "Машины против робота (Продолжение 8)";
        GAMES[8] = "Сражалки на мечах (Часть 9)";
        GAMES[9] = "Сражалки на мечах (Часть 10)";
        // Заполняем остальные слоты до 26
        for (int i = 10; i < 18; i++) GAMES[i] = "Рандомная игра 2005 года #" + (i + 1);
        GAMES[18] = "Продолжение меча ONLINE (Часть 19)";
        for (int i = 19; i < 25; i++) GAMES[i] = "Рандомная карта #" + (i + 1);
        GAMES[25] = "Продолжение меча ONLINE (Финальная часть 26)";
    }

    public static void main(String[] args) {
        // По умолчанию мы заходим как Гость (Guest)
        currentPlayer = new Player("Guest" + random.nextInt(9000) + 1000);
        
        boolean running = true;
        while (running) {
            Logo.drawLogo();
            System.out.println("Вы вошли как: " + currentPlayer.getUsername());
            currentPlayer.draw3DCharacter();

            System.out.println("\n[ГЛАВНОЕ МЕНЮ ROBLOX.JAVA]:");
            System.out.println("1. Список игр (Всего 26 игр)");
            System.out.println("2. Сменить Аватар (8 стилей)");
            System.out.println("3. Пожаловаться на игрока (Мгновенный бан)");
            System.out.println("4. Регистрация / Смена имени (Без пароля!)");
            System.out.println("5. Выход из игры");
            System.out.print("\nВыберите действие: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showGamesMenu();
                    break;
                case "2":
                    changeAvatarMenu();
                    break;
                case "3":
                    reportPlayer();
                    break;
                case "4":
                    registerUser();
                    break;
                case "5":
                    running = false;
                    System.out.println("Спасибо за игру в Roblox 2005! Bloxik закрывается...");
                    break;
                default:
                    System.out.println("Неверная кнопка, попробуй еще раз!");
            }
            
            if (running) {
                System.out.println("\nНажмите Enter, чтобы вернуться в меню...");
                scanner.nextLine();
            }
        }
    }

    private static void showGamesMenu() {
        System.out.println("\n--- СПИСОК ИГР (1-26) ---");
        for (int i = 0; i < GAMES.length; i++) {
            System.out.println((i + 1) + ". " + GAMES[i]);
        }
        System.out.print("\nВ какую игру хочешь сыграть? Введи номер: ");
        try {
            int gameNum = Integer.parseInt(scanner.nextLine());
            if (gameNum >= 1 && gameNum <= 26) {
                System.out.println("\n[ЗАГРУЗКА ИГРЫ...] " + GAMES[gameNum - 1]);
                System.out.println("Подключение к серверу 2005 года...");
                
                // Симуляция других игроков-гостей
                System.out.println("[ONLINE] В комнате с вами: Guest5521, Guest9012, BloxikFan.");
                System.out.println("[ИГРА] Вы успешно повеселились с другими гостями в " + GAMES[gameNum - 1] + "!");
            } else {
                System.out.println("Такой игры нет, тут всего 26 игр!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода номера игры.");
        }
    }

    private static void changeAvatarMenu() {
        currentPlayer.showAvatarMenu();
        System.out.print("Выберите номер стиля (1-8): ");
        try {
            int styleNum = Integer.parseInt(scanner.nextLine());
            currentPlayer.setStyle(styleNum);
        } catch (Exception e) {
            System.out.println("Нужно ввести число от 1 до 8!");
        }
    }

    private static void reportPlayer() {
        System.out.print("\nВведите имя читера или нарушителя: ");
        String badPlayer = scanner.nextLine();
        System.out.println("Жалоба отправлена... Слава Богу, " + badPlayer + " успешно забанен навсегда!");
    }

    private static void registerUser() {
        System.out.println("\n--- РЕГИСТРАЦИЯ БЕЗ ПАРОЛЯ ---");
        System.out.print("Введите ваше новое имя (пароль не нужен, любой может его угнать!): ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            currentPlayer.setUsername(newName);
            System.out.println("Вы успешно сменили аккаунт на: " + newName);
        } else {
            System.out.println("Имя не может быть пустым!");
        }
    }
}
