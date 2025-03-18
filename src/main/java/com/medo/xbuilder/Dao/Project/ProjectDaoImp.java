package com.medo.xbuilder.Dao.Project;

import com.medo.xbuilder.Model.Project;

import java.util.List;

public class ProjectDaoImp implements ProjectDao {
    @Override
    public boolean AddNewProject(Project Project) {
        String ADD_NEW_PROJECT = "insert into Project(name, description , startdate , enddate ,budget ) values(?,?,?,?,?)";
        return false;
    }

    @Override
    public boolean UpdateProject(int id, Project Project) {
        return false;
    }

    @Override
    public boolean DeleteProject(int id) {
        return false;
    }

    @Override
    public List<Project> DisplayALLProject() {
        return List.of();
    }

    @Override
    public Project DisplayProjectById(int id) {
        return null;
    }
}
