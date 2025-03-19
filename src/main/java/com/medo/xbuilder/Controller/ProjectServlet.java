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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


@WebServlet("/")
public class ProjectServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/ProjectView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");


    switch (action) {
        case "AjouterProject":
            AjouterProject(req, resp);
            break;
        case "SupprimerProject":
            AjouterProject(req, resp);
            break;

    }


    }

    private  void AjouterProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(LocalDate.parse(req.getParameter("startdate")));
        Date endDate = Date.valueOf(LocalDate.parse(req.getParameter("enddate")));
        int budget = Integer.parseInt(req.getParameter("budget"));
        ProjectServiceImp service = new ProjectServiceImp();
        service.AddNewProject(new Project(name, description, startDate, endDate, budget));
        doGet(req, resp);

    }
}
