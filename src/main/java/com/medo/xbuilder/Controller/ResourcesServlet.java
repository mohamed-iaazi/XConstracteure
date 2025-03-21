package com.medo.xbuilder.Controller;

import com.medo.xbuilder.Model.Resource;
import com.medo.xbuilder.Service.Resources.ResourceService;
import com.medo.xbuilder.Service.Resources.ResourceServiceImp;
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
        req.setAttribute("resources", resources);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
