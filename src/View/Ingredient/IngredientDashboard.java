package View.Ingredient;

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
