// Файл: Player.java
public class Player {
    private String username;
    private String colorStyle; // Текущий цвет стиля

    // 8 доступных стилей
    private static final String[] STYLES = {
        "Красный", "Синий", "Зеленый", "Розовый", 
        "Желтый", "Оранжевый", "Фиолетовый", "Черный"
    };

    public Player(String username) {
        this.username = username;
        this.colorStyle = STYLES[0]; // По умолчанию Красный
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public void setStyle(int index) {
        if (index >= 1 && index <= 8) {
            this.colorStyle = STYLES[index - 1];
            System.out.println(" Свойства аватара изменены! Ваш новый стиль: " + colorStyle);
        } else {
            System.out.println("Неверный индекс стиля!");
        }
    }

    public void showAvatarMenu() {
        System.out.println("\n--- НАСТРОЙКА АВАТАРА (Всего 8 стилей) ---");
        for (int i = 0; i < STYLES.length; i++) {
            System.out.println((i + 1) + ". Стиль: " + STYLES[i]);
        }
    }

    // Отрисовка 3D-персонажа в стиле 2005 года
    public void draw3DCharacter() {
        System.out.println("\n[3D РЕНДЕР ПЕРСОНАЖА (" + username + ")]");
        System.out.println("      ( o  o )   <- Желтая круглая голова с улыбкой");
        System.out.println("        \\__/   ");
        System.out.println("     /| " + colorStyle.toUpperCase() + " |\\  <- Желтые руки, кофта цвета: " + colorStyle);
        System.out.println("    | |======| | ");
        System.out.println("      | " + colorStyle.toUpperCase() + " |   <- Штаны и носки цвета: " + colorStyle);
        System.out.println("      |__|__|    ");
    }
}
