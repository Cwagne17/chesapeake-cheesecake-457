package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Event;
import Model.entities.Ingredient;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IIngredientModel {

    public ArrayList<Ingredient> getIngredients();

    public Ingredient getIngredient(String name) throws SQLException, StringException;

    public void createIngredient(
            String name,
            int stock
    );

    public void updateIngredient(int stock);

}
