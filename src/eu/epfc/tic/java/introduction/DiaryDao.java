package eu.epfc.tic.java.introduction;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaryDao {
    private static final String CONNECTION_STRING = "jdbc:h2:./diary";

    public static void initialize() {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {
            String sql = "create table if not exists DIARY (" +
                    "ID integer primary key auto_increment," +
                    "TITLE varchar(100) not null," +
                    "DESCRIPTION varchar(1000)," +
                    "BEGIN TIMESTAMP not null," +
                    "ISPUBLIC boolean" +
                    ")";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Diary> fetch() {
        List<Diary> diaries = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {
            String sql = "select ID, TITLE, DESCRIPTION, BEGIN, ISPUBLIC from DIARY";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("TITLE");
                String description = resultSet.getString("DESCRIPTION");
                LocalDateTime begin = resultSet.getTimestamp("BEGIN").toLocalDateTime();
                boolean isPublic = resultSet.getBoolean("ISPUBLIC");
                diaries.add(new Diary(id, title, description, begin, isPublic));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return diaries;
    }

    public static void add(Diary diary) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {
            String sql = "insert into DIARY (TITLE, DESCRIPTION, BEGIN, ISPUBLIC) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diary.getTitle());
            preparedStatement.setString(2, diary.getDescription());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(diary.getBegin()));
            preparedStatement.setBoolean(4, diary.isPublic());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void update(Diary diary) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {
            String sql = "update DIARY set TITLE=?, DESCRIPTION=?, BEGIN=?, ISPUBLIC=? WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diary.getTitle());
            preparedStatement.setString(2, diary.getDescription());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(diary.getBegin()));
            preparedStatement.setBoolean(4, diary.isPublic());
            preparedStatement.setInt(5, diary.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {
            String sql = "delete DIARY where ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
