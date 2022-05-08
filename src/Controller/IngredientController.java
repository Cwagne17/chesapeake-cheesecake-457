package Controller;

import Config.errors.StringException;
import Model.IngredientModel;
import Model.entities.Ingredient;
import Utils.TableHelpers;
import View.Ingredient.IngredientDashboard;
import View.Ingredient.IngredientForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientController {

    private IngredientModel ingredientModel = new IngredientModel();
    private IngredientForm form;
    private IngredientDashboard dash;
    private JTable table;

    private List<Ingredient> ingredients;

    public IngredientController(IngredientDashboard dash) {
        this.dash = dash;
    }

    public IngredientController(IngredientForm form) {
        this.form = form;
    }

    public void submitIngredient(){
        // submit package
        String name = this.form.getNameText().getText().trim();
        int stock = Integer.valueOf(this.form.getStockText().getText().trim());

        try {
            this.ingredientModel.createIngredient(name, stock);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getIngredients() {
        try {
            this.ingredients = new ArrayList<Ingredient>(this.ingredientModel.getIngredients());
            table = TableHelpers.getIngredientTableRows(ingredients);
            this.dash.add(table);
        } catch (SQLException | StringException ex) {
            ex.printStackTrace();
        }
    }
}
