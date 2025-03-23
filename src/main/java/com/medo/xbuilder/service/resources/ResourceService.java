package com.medo.xbuilder.service.resources;


import com.medo.xbuilder.model.Resource;
import java.util.List;

public interface ResourceService {

    boolean AddNewResource(Resource resource);
    boolean DeleteResource(int id);
    List<Resource> DisplayALLResource();
    Resource DisplayResourceById(int id);
    boolean UpdateResource(Resource resource);
    boolean UpdateResourceQantity(Resource resource);
}

