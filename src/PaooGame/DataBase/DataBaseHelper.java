package PaooGame.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {
    private static final String DATABASE_URL = "jdbc:sqlite:game.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String playersTable = "CREATE TABLE IF NOT EXISTS players (" +
                "id INTEGER PRIMARY KEY," +
                "worldX INTEGER," +
                "worldY INTEGER," +
                "direction TEXT" +
                ");";

        String entitiesTable = "CREATE TABLE IF NOT EXISTS entities (" +
                "id INTEGER PRIMARY KEY," +
                "worldX INTEGER," +
                "worldY INTEGER," +
                "type TEXT" +
                ");";

        String gameStateTable = "CREATE TABLE IF NOT EXISTS game_state (" +
                "id INTEGER PRIMARY KEY," +
                "currentMap INTEGER," +
                "pokeballs INTEGER" +
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(playersTable);
            stmt.execute(entitiesTable);
            stmt.execute(gameStateTable);
            System.out.println("Tables created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
