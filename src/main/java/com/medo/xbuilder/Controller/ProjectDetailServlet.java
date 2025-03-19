package com.medo.xbuilder.Controller;

import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Service.Project.ProjectServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/ProjectDetail")
public class ProjectDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProjectServiceImp service = new ProjectServiceImp();
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/views/ProjectDetail.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Project  project= service.DisplayProjectById(id);
        req.setAttribute("project", project);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
