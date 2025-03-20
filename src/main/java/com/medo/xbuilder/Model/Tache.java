package com.medo.xbuilder.Model;

import java.sql.Date;

public class Tache {
    private  int idTache ;
    private  String descTache ;
    private Date startdateTache ;
    private Date enddateTache ;
    private int projectId;

    public Tache(int idTache, String descTache, Date startdateTache, Date enddateTache, int projectId) {
        this.idTache = idTache;
        this.descTache = descTache;
        this.startdateTache = startdateTache;
        this.enddateTache = enddateTache;
        this.projectId = projectId;
    }

    public Tache(String descTache, Date startdateTache, Date enddateTache, int projectId) {
        this.descTache = descTache;
        this.startdateTache = startdateTache;
        this.enddateTache = enddateTache;
        this.projectId = projectId;
    }

    public Tache() {
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public String getDescTache() {
        return descTache;
    }

    public void setDescTache(String descTache) {
        this.descTache = descTache;
    }

    public Date getStartdateTache() {
        return startdateTache;
    }

    public void setStartdateTache(Date startdateTache) {
        this.startdateTache = startdateTache;
    }

    public Date getEnddateTache() {
        return enddateTache;
    }

    public void setEnddateTache(Date enddateTache) {
        this.enddateTache = enddateTache;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
