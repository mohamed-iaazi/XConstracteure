package com.medo.xbuilder.dao.project;

import com.medo.xbuilder.model.Project;
import com.medo.xbuilder.service.project.ProjectService;
import com.medo.xbuilder.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDao implements ProjectService {
    DBConnection DBConnection=new DBConnection();
    private  static final  Logger log = Logger.getLogger(ProjectDao.class.getName());
    @Override
    public boolean AddNewProject(Project Project)  {
        String ADD_NEW_PROJECT = "insert into project(name, description , startdate , enddate  ,budget ) values(?,?,?,?,?)";
        try (Connection connection= DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PROJECT)) {
            preparedStatement.setString(1,Project.getName());
            preparedStatement.setString(2,Project.getProjectDescription());
            preparedStatement.setDate(3, Project.getStartDate());
            preparedStatement.setDate(4, Project.getEndDate());
            preparedStatement.setFloat(5,Project.getBudget());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;

        }
    }

    @Override
    public boolean UpdateProject( Project Project) {
     String UPDATE_PROJECT="update project set name=? ,  description =? , startdate =? , enddate =? ,budget=?  where projectId=? ";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_PROJECT);
            preparedStatement.setString(1,Project.getName());
            preparedStatement.setString(2,Project.getProjectDescription());
            preparedStatement.setDate(3,Project.getStartDate());
            preparedStatement.setDate(4,Project.getEndDate());
            preparedStatement.setFloat(5,Project.getBudget());
            preparedStatement.setInt(6,Project.getProjectId());
                return true;


        } catch (Exception e) {
         log.log(Level.SEVERE,"Error occurred",e );

            return false;

        }
    }

    @Override
    public boolean DeleteProject(int id) {
        String DELETE_PROJECT = "delete  from project where projectId=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_PROJECT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            return false;

        }
    }

    @Override
    public List<Project> DisplayALLProject() {
        List<Project> Projects = new ArrayList<>();
        String SELECT_ALL_PROJECT = "select * from project";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int projectId = resultSet.getInt("projectId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Date startDate = resultSet.getDate("startdate");
                Date endDate = resultSet.getDate("enddate");
                int budget = resultSet.getInt("budget");
                Project project = new Project(projectId,name, description, startDate, endDate, budget);
                Projects.add(project);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error occurred",e );
            throw new RuntimeException(e);
        }
        return Projects;
    }

    @Override
    public Project DisplayProjectById(int id) {
        String SELECT_PROJECT = "select * from project where projectId=?";
        Project project=null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_PROJECT);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int projectId = resultSet.getInt("projectId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Date startDate = resultSet.getDate("startdate");
                Date endDate = resultSet.getDate("enddate");
                int budget = resultSet.getInt("budget");
                project = new Project(projectId,name, description, startDate, endDate, budget);

            }

        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            throw new RuntimeException(e);
        }
        return project;
    }
}
