package com.medo.xbuilder.dao.resources;

import com.medo.xbuilder.dao.project.ProjectDao;
import com.medo.xbuilder.model.Resource;
import com.medo.xbuilder.service.resources.ResourceService;
import com.medo.xbuilder.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceDao implements ResourceService {
    DBConnection DBConnection = new DBConnection();
    private  static final Logger log = Logger.getLogger(ResourceDao.class.getName());

    @Override
    public boolean AddNewResource(Resource resource) {
        String ADD_NEW_RESOURCE = "insert into resource (name, detail , type , quantité  ,fournisseur ) values(?,?,?,?,?)";
        try (Connection connection= DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_RESOURCE)) {
            preparedStatement.setString(1,resource.getResourceName());
            preparedStatement.setString(2,resource.getResourceDetail());
            preparedStatement.setString(3, resource.getResourceType());
            preparedStatement.setInt(4, resource.getResourceQuantite());
            preparedStatement.setString(5,resource.getResourceFournisseur());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            return  false;

        }
    }

    @Override
    public boolean DeleteResource(int id) {
        String DELETE_RESOURCE = "delete  from resource where ResourceId=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(DELETE_RESOURCE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            return false;

        }
    }

    @Override
    public List<Resource> DisplayALLResource() {
        List<Resource> resources = new ArrayList<>();
        String SELECT_ALL_RESOURCE = "select * from resource";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESOURCE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int ResourceId = resultSet.getInt("ResourceId");
                String name = resultSet.getString("name");
                String detail = resultSet.getString("detail");
                String type = resultSet.getString("type");
                int quantite = resultSet.getInt("quantité");
                String fournisseur = resultSet.getString("fournisseur");
                Resource resource= new Resource(ResourceId,name ,detail ,type ,quantite ,fournisseur);
                resources.add(resource);

            }
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error occurred",e );
            throw new RuntimeException(e);
        }
        return resources;
    }

    @Override
    public Resource DisplayResourceById(int id) {
        return null;
    }

    @Override
    public boolean UpdateResource(Resource resource) {
        String UPDATE_RESOURCE="update Resource set name=? ,  detail =? , type =? , quantité =? ,fournisseur=?  where ResourceId=? ";
        try (Connection connection= DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESOURCE)) {

            preparedStatement.setString(1,resource.getResourceName());
            preparedStatement.setString(2,resource.getResourceDetail());
            preparedStatement.setString(3, resource.getResourceType());
            preparedStatement.setInt(4, resource.getResourceQuantite());
            preparedStatement.setString(5,resource.getResourceFournisseur());
            preparedStatement.setInt(6,resource.getResourceId());


            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            return  false;

        }
    }

    @Override
    public boolean UpdateResourceQantity(Resource resource) {
        String UPDATE_RESOURCEQ="update Resource set  quantité =?   where ResourceId=? ";
        try (Connection connection= DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESOURCEQ)) {
            preparedStatement.setInt(1, resource.getResourceQuantite());
            preparedStatement.setInt(2,resource.getResourceId());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.log(Level.SEVERE,"Error occurred",e );
            return  false;

        }    }
}
