package com.medo.xbuilder.service.project;

import com.medo.xbuilder.dao.project.ProjectDao;
import com.medo.xbuilder.model.Project;

import java.util.List;

public class ProjectServiceImp implements ProjectService{
    ProjectDao dao = new ProjectDao();
    @Override
    public boolean AddNewProject(Project Project) {
        return dao.AddNewProject(Project);
    }



    @Override
    public boolean DeleteProject(int id) {
        return dao.DeleteProject(id);
    }

    @Override
    public List<Project> DisplayALLProject() {
                return dao.DisplayALLProject();
    }

    @Override
    public Project DisplayProjectById(int id) {
        return dao.DisplayProjectById(id);
    }

    @Override
    public boolean UpdateProject(Project project) {
        return dao.UpdateProject(project);

    }
}
