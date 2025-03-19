package com.medo.xbuilder.Dao.Project;

import com.medo.xbuilder.Model.Project;

import java.util.List;

public interface ProjectDao {
    boolean AddNewProject(Project Project);
    boolean UpdateProject( Project Project);
    boolean DeleteProject(int id);
    List<Project> DisplayALLProject();
    Project DisplayProjectById(int id);
}
