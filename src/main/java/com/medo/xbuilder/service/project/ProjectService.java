package com.medo.xbuilder.service.project;

import com.medo.xbuilder.model.Project;

import java.util.List;

public interface ProjectService {


    boolean AddNewProject(Project Project);
    boolean DeleteProject(int id);
    List<Project> DisplayALLProject();
    Project DisplayProjectById(int id);
    boolean UpdateProject(Project project);
}
