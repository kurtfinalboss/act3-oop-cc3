
package cc3.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Repository {
    private final String dbURL;
  
    private Repository(String dbURL){
        this.dbURL = dbURL;
    }
    public void save(Student student) {

        String sql = "INSERT INTO tbl_student(studentID, studentName, age, sex, course, yearLevel, nstpComp, email, contact, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, student.getStudentID());
            pstmt.setString(2, student.getStudentName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getSex());
            pstmt.setString(5, student.getCourse());
            pstmt.setInt(6, student.getYearLevel());
            pstmt.setString(7, student.getNstpComp());
            pstmt.setString(8, student.getEmail());
            pstmt.setString(9, student.getContact());
            pstmt.setString(10, student.getAddress());

            pstmt.executeUpdate();
            System.out.println("Student saved successfully!");

        } catch (SQLException e) {
            System.err.println("Failed to save student: " + e.getMessage());
        }
    }
    public List<Student> retrieveAll() { // Now it returns a LIST of students
    List<Student> students = new ArrayList<>(); // Create the container
    String sql = "SELECT * FROM tbl_student";

    try (Connection conn = DriverManager.getConnection(dbURL);
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Student s = new Student.StudentBuilder()
                .setStudentID(rs.getInt("studentID"))
                .setStudentName(rs.getString("studentName"))
                .setAge(rs.getInt("age"))
                .setSex(rs.getString("sex"))
                .setCourse(rs.getString("course"))
                .setYearLevel(rs.getInt("yearLevel"))
                .setNstpComp(rs.getString("nstpComp"))
                .setEmail(rs.getString("email"))
                .setContact(rs.getString("contact"))
                .setAddress(rs.getString("address"))
                .build();
            
                students.add(s); // Put the student into the box
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return students; // Return the whole box
    }
    public static class RepositoryBuilder{
        private String path;
        
        public RepositoryBuilder setDatabasePath(){
            this.path = "jdbc:sqlite:D:\\NitbensProject\\Test1.db";
            return this;
        }
        public Repository build() {
            if (path == null) throw new IllegalStateException("Database path not set!");
            return new Repository(path);
        }
    }
   
}
