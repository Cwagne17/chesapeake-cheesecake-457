package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Package;
import Model.interfaces.IPackageModel;
import Model.shared.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageModel implements IPackageModel {
    private Connection conn;

    public PackageModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Package> getPackages() throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Package"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public Package getPackage(String name) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Package" +
                        "WHERE name = ?"
        );
        stmt.setString(1, name);
        ResultSet res = stmt.executeQuery();
        ArrayList<Package> packages = this.buildResponse(res);
        return packages.get(0);
    }

    @Override
    public void createPackage(String name, double cost) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Package" +
                        "(name, cost)" +
                        "VALUES (?, ?)"
        );
        stmt.setString(1, name);
        stmt.setDouble(2, cost);

        stmt.executeUpdate();
    }

    @Override
    public void updatePackage(String name, double cost) throws SQLException, StringException {
        Package curr_ingredient = this.getPackage(name);
        if (Validator.exists(Double.toString(cost))) {
            curr_ingredient.setCost(cost);
        }
        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE chesapeake457.Package" +
                        "SET cost = ?" +
                        "WHERE (name = ?)"
        );
        stmt.setDouble(1, cost);
        stmt.setString(2, name);

        stmt.executeUpdate();
    }

    private ArrayList<Package> buildResponse(ResultSet res) throws SQLException, StringException {
        ArrayList<Package> packages = new ArrayList<>();

        ArrayList<String> attributes = new Package().getAttributeNames();
        while (res.next()) {
            Package obj = new Package();
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
            packages.add(obj);
        }
        return packages;
    }
}
