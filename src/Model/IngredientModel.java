package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Event;
import Model.entities.Ingredient;
import Model.interfaces.IIngredientModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientModel implements IIngredientModel {
    private Connection conn;

    public IngredientModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return null;
    }

    @Override
    public Ingredient getIngredient(String name) throws SQLException, StringException {
        return null;
    }

    @Override
    public void createIngredient(String name, int stock) {

    }

    @Override
    public void updateIngredient(int stock) {

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
