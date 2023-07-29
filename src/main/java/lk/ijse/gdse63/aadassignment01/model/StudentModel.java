package lk.ijse.gdse63.aadassignment01.model;

import lk.ijse.gdse63.aadassignment01.DB.DBConnection;
import lk.ijse.gdse63.aadassignment01.dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModel {
    public static int saveStudent(Student student) throws SQLException {
        int status = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Student VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getCity());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getLevel());
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return status;
    }

    public static int deleteStudent(Student student) throws SQLException {
        int status = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Student WHERE id =?");
            preparedStatement.setString(1,student.getId());
            status = preparedStatement.executeUpdate();
            connection.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return status;
    }

    public static Student searchStudent(String id) throws SQLException {
        Student student1=null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Student WHERE id =?");
            preparedStatement.setString(1,id);

            ResultSet rst = preparedStatement.executeQuery();
            if(rst.next()){
                student1 = new Student(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getInt(5));
            }
            connection.close();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        return student1;
    }
}
