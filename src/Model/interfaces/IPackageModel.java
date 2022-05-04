package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Package;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPackageModel {

    public ArrayList<Package> getPackages();

    public Package getPackage(String name) throws SQLException, StringException;

    public void createPackage(String name, double cost);

    public void updatePackage(double cost);

}
