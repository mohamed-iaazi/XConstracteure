package com.medo.xbuilder.Service;

import com.medo.xbuilder.Model.Project;

import java.util.List;

public interface ProjectService {


    boolean AddNewProject(Project Project);
    boolean UpdateProject(int id, Project Project);
    boolean DeleteProject(int id);
    List<Project> DisplayALLProject();
    Project DisplayProjectById(int id);


}
