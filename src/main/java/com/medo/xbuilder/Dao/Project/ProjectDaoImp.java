package com.medo.xbuilder.Dao.Project;

import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return List.of();
    }

    @Override
    public Project DisplayProjectById(int id) {
        return null;
    }
}
