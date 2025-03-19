package com.medo.xbuilder.Dao.Project;

import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImp implements ProjectDao {
    @Override
    public boolean AddNewProject(Project Project)  {
        String ADD_NEW_PROJECT = "insert into project(name, description , startdate , enddate  ,budget ) values(?,?,?,?,?)";
        try (Connection connection= DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PROJECT)) {
            preparedStatement.setString(1,Project.getName());
            preparedStatement.setString(2,Project.getProjectDescription());
            preparedStatement.setDate(3, Project.getStartDate());
            preparedStatement.setDate(4, Project.getEndDate());
            preparedStatement.setInt(5,Project.getBudget());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;

        }
    }

    @Override
    public boolean UpdateProject(int id, Project Project) {
        return false;
    }

    @Override
    public boolean DeleteProject(int id) {
        return false;
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
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Date startDate = resultSet.getDate("startdate");
                Date endDate = resultSet.getDate("enddate");
                int budget = resultSet.getInt("budget");
                Project project = new Project(name, description, startDate, endDate, budget);
                Projects.add(project);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Projects;
    }

    @Override
    public Project DisplayProjectById(int id) {
        return null;
    }
}
