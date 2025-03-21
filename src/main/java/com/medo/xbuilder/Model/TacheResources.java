package com.medo.xbuilder.Model;

public class TacheResources {
    private int id;
    private  int quantité ;
    private  int tacheId ;
    private  int resourceId ;

    public TacheResources(int id, int quantité, int tacheId, int resourceId) {
        this.id = id;
        this.quantité = quantité;
        this.tacheId = tacheId;
        this.resourceId = resourceId;
    }

    public TacheResources(int quantité, int tacheId, int resourceId) {
        this.quantité = quantité;
        this.tacheId = tacheId;
        this.resourceId = resourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public int getTacheId() {
        return tacheId;
    }

    public void setTacheId(int tacheId) {
        this.tacheId = tacheId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
