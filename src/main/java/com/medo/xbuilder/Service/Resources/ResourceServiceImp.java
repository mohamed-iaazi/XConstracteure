package com.medo.xbuilder.Service.Resources;

import com.medo.xbuilder.Model.Resource;

import java.util.List;

public class ResourceServiceImp implements ResourceService {
    @Override
    public boolean AddNewResource(Resource resource) {
        return false;
    }

    @Override
    public boolean DeleteResource(int id) {
        return false;
    }

    @Override
    public List<Resource> DisplayALLResource() {
        return List.of();
    }

    @Override
    public Resource DisplayResourceById(int id) {
        return null;
    }

    @Override
    public boolean UpdateResource(Resource resource) {
        return false;
    }
}
