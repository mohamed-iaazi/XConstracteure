package com.medo.xbuilder.Controller;

import com.medo.xbuilder.Dao.Task.TacheDao;
import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Model.Tache;
import com.medo.xbuilder.Service.Project.ProjectServiceImp;
import com.medo.xbuilder.Service.Tache.TacheServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet("/ProjectDetail")
public class ProjectDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TacheServiceImp serviceImp = new TacheServiceImp();
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/views/ProjectDetail.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        List<Tache> taches =serviceImp.GetAllTasks(id);
        for (Tache tache : taches) {
            System.out.println(tache);
        }
        req.setAttribute("project", id);
        req.setAttribute("taches", taches);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "AjouterTask":
                AjouterTask(req,resp);
                  break;
            case "SupprimerTask":
                      SupprimerTask(req,resp);
                      break;

        }


    }

    private void SupprimerTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        TacheServiceImp service = new TacheServiceImp();
        service.DeleteTask(taskId);
        int projectId = Integer.parseInt(req.getParameter("project"));
        resp.sendRedirect(req.getContextPath() + "/ProjectDetail?id=" + projectId);
    }

    private void AjouterTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TacheServiceImp service = new TacheServiceImp();
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));

        int ProjectId = Integer.parseInt(req.getParameter("id"));

        Tache tache = new Tache( description, startDate, endDate, ProjectId);
        service.AddTask(tache);
        doGet(req,resp);



    }
}
