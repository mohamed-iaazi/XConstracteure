package com.medo.xbuilder.service.resources;

import com.medo.xbuilder.dao.resources.ResourceDao;
import com.medo.xbuilder.model.Resource;

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
