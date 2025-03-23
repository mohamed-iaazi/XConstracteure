package com.medo.xbuilder.service.tache;

import com.medo.xbuilder.model.Tache;
import com.medo.xbuilder.model.TacheResources;

import java.util.List;

public interface TacheService {
    boolean AddTask(Tache tache);
    boolean DeleteTask(int id);
    boolean UpdateTask(Tache tache);
    Tache GetTaskById(int id);
    List<Tache> GetAllTasks(int id);
    boolean AssociateRescource(TacheResources rescource);

}
