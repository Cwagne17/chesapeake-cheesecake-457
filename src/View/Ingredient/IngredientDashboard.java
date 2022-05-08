package View.Ingredient;

import Controller.IngredientController;

import javax.swing.*;

public class IngredientDashboard extends JPanel {
    private IngredientController ingredientController;

    public IngredientDashboard() {
        this.ingredientController = new IngredientController(this);
    }

    public void getIngredients() {
        ingredientController.getIngredients();
    }
}
