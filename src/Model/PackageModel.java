package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Package;
import Model.interfaces.IPackageModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageModel implements IPackageModel {
    private Connection conn;

    public PackageModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Package> getPackages() {
        return null;
    }

    @Override
    public Package getPackage(String name) throws SQLException, StringException {
        return null;
    }

    @Override
    public void createPackage(String name, double cost) {

    }

    @Override
    public void updatePackage(double cost) {

    }
}
