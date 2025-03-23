package com.medo.xbuilder.service.tache;

import com.medo.xbuilder.dao.task.TacheDao;
import com.medo.xbuilder.model.Tache;
import com.medo.xbuilder.model.TacheResources;

import java.util.List;

public class TacheServiceImp implements TacheService {
    TacheDao tacheDao=new TacheDao();
    @Override
    public boolean AddTask(Tache tache) {
        return tacheDao.AddTask(tache);
    }

    @Override
    public boolean DeleteTask(int id) {
        return tacheDao.DeleteTask(id);
    }

    @Override
    public boolean UpdateTask(Tache tache) {
        return tacheDao.UpdateTask(tache);
    }

    @Override
    public Tache GetTaskById(int id) {
        return null;
    }

    @Override
    public List<Tache> GetAllTasks(int id) {
        return tacheDao.GetAllTasks(id);
    }

    @Override
    public boolean AssociateRescource(TacheResources rescource) {
        return tacheDao.AssociateRescource(rescource);
    }
}
