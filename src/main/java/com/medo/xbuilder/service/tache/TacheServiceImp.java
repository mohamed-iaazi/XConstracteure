package com.medo.xbuilder.service.tache;

import com.medo.xbuilder.dao.resources.ResourceDao;
import com.medo.xbuilder.dao.task.TacheDao;
import com.medo.xbuilder.model.Resource;
import com.medo.xbuilder.model.Tache;
import com.medo.xbuilder.model.TacheResources;

import java.util.List;

public class TacheServiceImp implements TacheService {
    TacheDao tacheDao=new TacheDao();
    ResourceDao resourceDao=new ResourceDao();
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
        if (tacheDao.AssociateRescource(rescource)) {
            int resourceId = rescource.getId();
            int quantity = resourceDao.DisplayResourceById(resourceId).getResourceQuantite();
            resourceDao.UpdateResourceQantity(new Resource(resourceId, quantity));
            return true;
        }

        return false;
    }
}
