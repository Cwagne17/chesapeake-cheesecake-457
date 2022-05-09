package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Package;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPackageModel {

    public ArrayList<Package> getPackages() throws SQLException, StringException;

    public Package getPackage(String name) throws SQLException, StringException;

    public void createPackage(String name, double cost) throws SQLException;

    void updatePackage(String name, double cost) throws SQLException, StringException;
}
