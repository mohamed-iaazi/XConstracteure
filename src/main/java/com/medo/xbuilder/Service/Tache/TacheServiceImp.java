package com.medo.xbuilder.Service.Tache;

import com.medo.xbuilder.Dao.Task.TacheDao;
import com.medo.xbuilder.Model.Tache;

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
}
