package com.medo.xbuilder.Dao.Task;

import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Model.Tache;
import com.medo.xbuilder.Service.Tache.TacheService;
import com.medo.xbuilder.Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacheDao implements TacheService {
    DBConnection DBConnection = new DBConnection();
    @Override
    public boolean AddTask(Tache tache) {
        String ADD_NEW_Task = "insert into tache( taskdesc , startdate , enddate  , projectid) values(?,?,?,?)";
        try (Connection connection= DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_Task)) {
            preparedStatement.setString(1,tache.getDescTache());
            preparedStatement.setDate(2, tache.getStartdateTache());
            preparedStatement.setDate(3, tache.getEnddateTache());
            preparedStatement.setInt(4,tache.getProjectId());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;

        }    }

    @Override
    public boolean DeleteTask(int id) {
        String DELETE_TACHE = "delete  from tache where TacheId=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_TACHE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }    }

    @Override
    public boolean UpdateTask(Tache tache) {
        return false;
    }

    @Override
    public Tache GetTaskById(int id) {
        return null;
    }

    @Override
    public List<Tache> GetAllTasks(int id) {
        List<Tache> taches = new ArrayList<>();
        String SELECT_ALL_TACHE = "select * from tache where projectid=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TACHE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int tacheId = resultSet.getInt("TacheId");
                int projectId = resultSet.getInt("projectId");
                String description = resultSet.getString("taskdesc");
                Date startDate = resultSet.getDate("startdate");
                Date endDate = resultSet.getDate("enddate");
                Tache tache = new Tache(tacheId,description, startDate, endDate,projectId );
                taches.add(tache);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return taches;    }
}
