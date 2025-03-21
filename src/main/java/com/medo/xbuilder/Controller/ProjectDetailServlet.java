package com.medo.xbuilder.Controller;

import com.medo.xbuilder.Dao.Task.TacheDao;
import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Model.Resource;
import com.medo.xbuilder.Model.Tache;
import com.medo.xbuilder.Service.Project.ProjectServiceImp;
import com.medo.xbuilder.Service.Resources.ResourceServiceImp;
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
        ResourceServiceImp resourceServiceImp = new ResourceServiceImp();
        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/views/ProjectDetail.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        List<Tache> taches =serviceImp.GetAllTasks(id);
        List<Resource> resources=resourceServiceImp.DisplayALLResource();
        req.setAttribute("project", id);
        req.setAttribute("taches", taches);
        req.setAttribute("resources", resources);
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
            case "UpdateTask":
                UpdateTask(req,resp);
                break;

        }


    }

    private void UpdateTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TacheServiceImp service = new TacheServiceImp();
        int taskId = Integer.parseInt(req.getParameter("TaskId"));
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(req.getParameter("startdate"));
        Date endDate = Date.valueOf(req.getParameter("enddate"));
        Tache tache = new Tache(taskId,description, startDate, endDate, projectId);
        service.UpdateTask(tache);
        resp.sendRedirect(req.getContextPath() + "/ProjectDetail?id=" + projectId);
    }

    private void SupprimerTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TacheServiceImp service = new TacheServiceImp();
        int taskId = Integer.parseInt(req.getParameter("id"));
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        service.DeleteTask(taskId);
        resp.sendRedirect(req.getContextPath() + "/ProjectDetail?id=" + projectId);
    }

    private void AjouterTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TacheServiceImp service = new TacheServiceImp();
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        Date endDate = Date.valueOf(req.getParameter("endDate"));
        int projectId = Integer.parseInt(req.getParameter("projectId"));
        Tache tache = new Tache(description, startDate, endDate, projectId);
        service.AddTask(tache);
        resp.sendRedirect(req.getContextPath() + "/ProjectDetail?id=" + projectId);


    }
}
