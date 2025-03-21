package com.medo.xbuilder.Dao.Resources;

import com.medo.xbuilder.Model.Project;
import com.medo.xbuilder.Model.Resource;
import com.medo.xbuilder.Service.Resources.ResourceService;
import com.medo.xbuilder.Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDao implements ResourceService {
    DBConnection DBConnection = new DBConnection();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
            return  false;

        }
    }
}
