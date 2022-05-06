package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Event;
import Model.entities.Ingredient;
import Model.interfaces.IIngredientModel;
import Model.shared.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientModel implements IIngredientModel {
    private Connection conn;

    public IngredientModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Ingredient> getIngredients() throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Ingredient"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public Ingredient getIngredient(String name) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                        "FROM chesapeake457.Ingredient " +
                        "WHERE name = ?");
        stmt.setString(1, name);
        ResultSet res = stmt.executeQuery();
        ArrayList<Ingredient> events = this.buildResponse(res);
        return events.get(0);
    }

    @Override
    public void createIngredient(String name, int stock) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Ingredient" +
                        "(name, stock)" +
                        "VALUES (?, ?)"
        );
        stmt.setString(1, name);
        stmt.setInt(2, stock);
    }

    @Override
    public void updateIngredient(String name, int stock) throws SQLException, StringException {
        Ingredient curr_ingredient = this.getIngredient(name);
        if (Validator.exists(Integer.toString(stock))) {
            curr_ingredient.setStock(stock);
        }
        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE chesapeake457.Ingredient" +
                        "SET stock = ?" +
                        "WHERE (name = ?)"
        );
        stmt.setInt(1, stock);
        stmt.setString(2, name);

        stmt.executeUpdate();
    }

    private ArrayList<Ingredient> buildResponse(ResultSet res) throws SQLException, StringException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        ArrayList<String> attributes = new Event().getAttributeNames();
        while (res.next()) {
            Ingredient obj = new Ingredient();
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
            ingredients.add(obj);
        }
        return ingredients;
    }

}
