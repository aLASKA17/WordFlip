package org.a1aska17.view;

import org.a1aska17.controller.StudyController;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.*;

public class StudyView {
    private static final StudyController studyController = new StudyController();

    private static void displayMenu() {
        out.println("Меню");
        out.println("1) Играть");
        out.println("2) Добавить карточку в список");
        out.println("3) Удалить карточку из списка");
        out.println("4) Изменить карточку из списка");
        out.println("5) Выход");
        out.print("Выберете пункт меню: ");
    }

    public static void controllerMenu() throws SQLException {
        Scanner choosePoint = new Scanner(in);
        while (true) {
            displayMenu();
            try {
                int pointMenu = choosePoint.nextInt();
                switch (pointMenu) {
                    case 1: studyController.startFlashcards(); break;
                    case 2: studyController.addFlashcard(); break;
                    case 3: studyController.deleteFlashcard(); break;
                    case 4: studyController.changeFlashcard(); break;
                    case 5: exit(0); break;
                    default: out.println("Такого пункта нет!");
                }
            } catch (InputMismatchException ex) {
                out.println("Ошибка: Вы ввели текст вместо числа!");
                choosePoint.next();
            }
        }
    }
}
