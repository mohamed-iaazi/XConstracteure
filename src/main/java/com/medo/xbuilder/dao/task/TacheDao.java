package com.medo.xbuilder.dao.task;

import com.medo.xbuilder.model.Tache;
import com.medo.xbuilder.model.TacheResources;
import com.medo.xbuilder.service.tache.TacheService;
import com.medo.xbuilder.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TacheDao implements TacheService {
    DBConnection DBConnection = new DBConnection();
    private  static final  Logger log = Logger.getLogger(TacheDao.class.getName());

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
            log.log(Level.SEVERE,"Error occurred",e );            return  false;

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
            log.log(Level.SEVERE,"Error occurred",e );
            return false;

        }    }

    @Override
    public boolean UpdateTask(Tache tache) {
        String UPDATE_PROJECT="update tache set taskdesc=?  , startdate =? , enddate =?   where TacheId=? ";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_PROJECT);
            preparedStatement.setString(1,tache.getDescTache());
            preparedStatement.setDate(2,tache.getStartdateTache());
            preparedStatement.setDate(3,tache.getEnddateTache());
            preparedStatement.setInt(4,tache.getIdTache());
            if (preparedStatement.executeUpdate()!=0){
                return true;
            }
            return true;

        } catch (Exception e) {
            log.log(Level.SEVERE,"Error occurred",e );
            return false;

        }
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
            log.log(Level.SEVERE,"Error occurred",e );
            throw new RuntimeException(e);
        }
        return taches;    }

    @Override
    public boolean AssociateRescource(TacheResources rescource) {

        String INSERT_TO_TASK_RESOURCE ="insert into TacheResource (TacheId , ResourceId , quantité) values(?,?,?)";

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_TO_TASK_RESOURCE);
            preparedStatement.setInt(1,rescource.getTacheId());
            preparedStatement.setInt(2,rescource.getResourceId());
            preparedStatement.setInt(3,rescource.getQuantité());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            throw new RuntimeException(e);
        }

        return false;
    }
}
