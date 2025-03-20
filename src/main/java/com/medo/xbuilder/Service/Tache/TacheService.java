package com.medo.xbuilder.Service.Tache;

import com.medo.xbuilder.Model.Tache;

import java.util.List;

public interface TacheService {
    boolean AddTask(Tache tache);
    boolean DeleteTask(int id);
    boolean UpdateTask(Tache tache);
    Tache GetTaskById(int id);
    List<Tache> GetAllTasks(int id);

}
