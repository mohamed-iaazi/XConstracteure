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
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
public class ProjectServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectServiceImp service = new ProjectServiceImp();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/ProjectView.jsp");
        List<Project> projects =service.DisplayALLProject();
        req.setAttribute("projects", projects);
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
                SupprimerProject(req, resp);
                break;
            case "UpdateProject":
                UpdateProject(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/"); // default redirect to home if no action matches
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
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private void UpdateProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt((String) req.getParameter("projectId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(LocalDate.parse(req.getParameter("startdate")));
        Date endDate = Date.valueOf(LocalDate.parse(req.getParameter("enddate")));
        int budget = Integer.parseInt(req.getParameter("budget"));
        ProjectServiceImp service = new ProjectServiceImp();
        Project project=new Project(id, name, description, startDate, endDate, budget);
        service.UpdateProject(project);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private void SupprimerProject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProjectServiceImp service = new ProjectServiceImp();
        service.DeleteProject(id); // Assuming this method works as expected
        resp.sendRedirect(req.getContextPath() + "/"); // Redirect to the homepage after deletion
    }


}
