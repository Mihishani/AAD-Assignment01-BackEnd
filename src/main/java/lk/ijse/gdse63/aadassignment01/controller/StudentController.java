package lk.ijse.gdse63.aadassignment01.controller;

import lk.ijse.gdse63.aadassignment01.dto.Student;
import lk.ijse.gdse63.aadassignment01.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/student")
public class StudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
        Student student = jsonb.fromJson(req.getReader(), Student.class);
        System.out.println(student);

        try {
            int i = StudentModel.saveStudent(student);
            if (i>0){
                System.out.println("student save");
            }else {
                System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
       Student student = jsonb.fromJson(req.getReader(), Student.class);
        System.out.println(student);

        try {
            int i = StudentModel.updateStudent(student);
            if (i>0){
                System.out.println("student update");
            }else {
                System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
        Student student = jsonb.fromJson(req.getReader(), Student.class);
        System.out.println(student);

        try {
            int i = StudentModel.deleteStudent(student);
            if (i>0){
                System.out.println("student delete");
            }else {
                System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
        Student student = jsonb.fromJson(req.getReader(), Student.class);
        System.out.println(student);

        try {
            Student student1 = StudentModel.searchStudent(student.getId());
            if (student1!=null){
                System.out.println(student1);
            }else {
                System.out.println("something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
