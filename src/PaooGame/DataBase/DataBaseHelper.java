package PaooGame.DataBase;

import java.sql.*;

public class DataBaseHelper {
    private final String DATABASE_URL = "jdbc:sqlite:game.db";

    public float worldX;
    public float worldY;
    public String direction;
    public int life;
    public int hasCoin;
    public int hasKey;

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void saveProgress(float worldX, float worldY, String direction, int life, int hasCoin, int hasKey){
        String sql = "INSERT INTO sheriffData(worldX, worldY, direction, life, hasCoin, hasKey) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, (double)worldX);
                stmt.setDouble(2, (double)worldY);
                stmt.setString(3, direction);
                stmt.setInt(4, life);
                stmt.setInt(5, hasCoin);
                stmt.setInt(6, hasKey);

            System.out.println("SALVAT x" + worldX + " y " + worldY + " direction " + direction + " life " + life + " hascoin " + hasCoin + "haskey " + hasKey);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadProgress(){
        String sql = "SELECT worldX, worldY, direction, life, hasCoin, hasKey FROM sheriffData";

        try(Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                worldX = (float) rs.getDouble("worldX");
                worldY = (float) rs.getDouble("worldY");
                direction = rs.getString("direction");
                life = rs.getInt("life");
                hasCoin = rs.getInt("hasCoin");
                hasKey = rs.getInt("hasKey");
            }

            System.out.println("x" + worldX + " y " + worldY + " direction " + direction + " life " + life + " hascoin " + hasCoin + "haskey " + hasKey);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTables() {
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

        String sheriffData = "CREATE TABLE \"sheriffData\" (\n" +
                "\t\"worldX\"\tREAL DEFAULT 0,\n" +
                "\t\"worldY\"\tREAL DEFAULT 0,\n" +
                "\t\"life\"\tINTEGER DEFAULT 0,\n" +
                "\t\"hasCoin\"\tINTEGER DEFAULT 0,\n" +
                "\t\"hasKey\"\tINTEGER DEFAULT 0,\n" +
                "\t\"direction\"\tTEXT DEFAULT 0\n" +
                ")";

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
