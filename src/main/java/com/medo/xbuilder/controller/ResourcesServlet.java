package com.medo.xbuilder.controller;

import com.medo.xbuilder.model.Resource;
import com.medo.xbuilder.service.resources.ResourceServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;



@WebServlet("/Resources")
public class ResourcesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResourceServiceImp service = new ResourceServiceImp();
        RequestDispatcher dispatcher=req.getRequestDispatcher("/views/ResourceList.jsp");
        List<Resource> resources = service.DisplayALLResource();
        for (Resource resource : resources) {
            System.out.println(resource.getResourceName());
        }
        req.setAttribute("resources", resources);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        switch (action) {
            case "AddResource":
                AjouterResource(req,resp);
                break;
                case "UpdateResource":
                    UpdateResource(req,resp);
                    break;
                    case "DeleteResource":
                        DeleteResource(req,resp);
                        break;
        }

    }

    private void DeleteResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("resourceId"));
        ResourceServiceImp service = new ResourceServiceImp();
        service.DeleteResource(id);
        resp.sendRedirect(req.getContextPath()+"/Resources");
    }

    private void UpdateResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResourceServiceImp service = new ResourceServiceImp();

        int id = Integer.parseInt(req.getParameter("resourceId"));
        String name = req.getParameter("name");
        String detail = req.getParameter("detail");
        String type = req.getParameter("type");
        int quantite = Integer.parseInt(req.getParameter("quantite"));
        String fournisseur = req.getParameter("fournisseur");
        service.UpdateResource(new Resource(id,name,detail,type,quantite,fournisseur));
        resp.sendRedirect(req.getContextPath()+"/Resources");
    }

    private void AjouterResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResourceServiceImp service = new ResourceServiceImp();
        String name = req.getParameter("name");
        String detail = req.getParameter("detail");
        String type = req.getParameter("type");
        int quantite = Integer.parseInt(req.getParameter("quantité"));
        String fournisseur = req.getParameter("fournisseur");
        service.AddNewResource(new Resource(name,detail,type,quantite,fournisseur));
        resp.sendRedirect(req.getContextPath()+"/Resources");

    }
}
