package com.medo.xbuilder.Service.Resources;

import com.medo.xbuilder.Dao.Resources.ResourceDao;
import com.medo.xbuilder.Model.Resource;

import java.util.List;

public class ResourceServiceImp implements ResourceService {
    ResourceDao resourceDao=new ResourceDao();
    @Override
    public boolean AddNewResource(Resource resource) {
        return resourceDao.AddNewResource(resource);
    }

    @Override
    public boolean DeleteResource(int id) {
        return resourceDao.DeleteResource(id);
    }

    @Override
    public List<Resource> DisplayALLResource() {
        return resourceDao.DisplayALLResource();
    }

    @Override
    public Resource DisplayResourceById(int id) {
        return resourceDao.DisplayResourceById(id);
    }

    @Override
    public boolean UpdateResource(Resource resource) {
        return resourceDao.UpdateResource(resource);
    }
}
