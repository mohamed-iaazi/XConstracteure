package com.medo.xbuilder.model;

import java.sql.Date;

public class Project {
   private  int projectId  ;
   private  String name;
   private  String projectDescription ;
   private Date startDate ;
   private Date endDate ;
   private  float budget;

    public Project(String name, String projectDescription, Date startDate, Date endDate, float budget) {
        this.name = name;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Project(int projectId, String name, String projectDescription, Date startDate, Date endDate, float budget) {
        this.projectId = projectId;
        this.name = name;
        this.projectDescription = projectDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Project() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
}
