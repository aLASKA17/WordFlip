package org.a1aska17.controller;

import org.a1aska17.db.DatabaseConfig;
import org.a1aska17.model.Flashcard;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class StudyController {
    private final Scanner inputData = new Scanner(in);

    private Flashcard createFlashcard() {
        out.print("Введите колоду: ");
        String deck = inputData.next();
        out.print("\nВведите термин: ");
        String term = inputData.next();
        out.print("\nВведите ответ: ");
        String answer = inputData.next();
        return new Flashcard(deck, term, answer);
    }

    private void displayFlashcards() {
        String path = "/display_data.sql";
        try (Connection connectDB = DatabaseConfig.getConnection();
            Statement stmt = connectDB.createStatement();
             ResultSet rs = stmt.executeQuery(SqlReader.readSqlFile(path))) {
               while (rs.next()) {
                   int id = rs.getInt("id");
                   String deck = rs.getString("deck");
                   String term = rs.getString("term");
                   String answer = rs.getString("answer");
                   out.println("ID: " + id + "; DECK: " + deck + "; TERM: " + term + "; ANSWER: " + answer + ";");
               }
        } catch (SQLException ex) {
            System.err.println("Error Database: " + ex.getMessage());
        }
    }

    public void addFlashcard() {
        String path = "/insert_data.sql";
        try (Connection connectDB = DatabaseConfig.getConnection();
            PreparedStatement stmt = connectDB.prepareStatement(SqlReader.readSqlFile(path))) {
                Flashcard data = createFlashcard();
                stmt.setString(1, data.getDeck());
                stmt.setString(2, data.getTerm());
                stmt.setString(3, data.getAnswer());
                stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error Database: " + ex.getMessage());
        }
    }

    public void startFlashcards() {

    }

    public void changeFlashcard() {
        displayFlashcards();
    }

    public void deleteFlashcard() {

    }

}
