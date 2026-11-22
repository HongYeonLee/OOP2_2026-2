package week12.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import week12.DatabaseConnector;
import week12.Model.User;

public class UserDAO {
	//기본 CRUD 구현
	public void create(User user) throws SQLException {
		String sql = "INSERT INTO user (id, name, age) VALUES(?, ?, ?)";
		try (Connection conn = DatabaseConnector.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setInt(3, user.getAge());
			stmt.executeUpdate();
		}
	}
	
	public User read(int id) throws SQLException {
		String sql = "SELET * FROM user WHERE id = ?";
		try (Connection conn = DatabaseConnector.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
			}
			
		}
		return null;
	}
	
    public void update(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
