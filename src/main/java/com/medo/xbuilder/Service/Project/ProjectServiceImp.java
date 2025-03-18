package com.medo.xbuilder.Service.Project;

import com.medo.xbuilder.Dao.Project.ProjectDaoImp;
import com.medo.xbuilder.Model.Project;

import java.util.List;

public class ProjectServiceImp implements ProjectService{
    ProjectDaoImp dao = new ProjectDaoImp();
    @Override
    public boolean AddNewProject(Project Project) {
        return dao.AddNewProject(Project);
    }

    @Override
    public boolean UpdateProject(int id, Project Project) {
        return dao.UpdateProject(id, Project);
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
}
