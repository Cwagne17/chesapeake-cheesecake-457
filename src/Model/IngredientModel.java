package Model;

import Model.dto.CreateIngredientDto;
import Model.dto.UpdateIngredientDto;
import Model.entities.Ingredient;
import Model.interfaces.IIngredientModel;

import java.util.ArrayList;

public class IngredientModel implements IIngredientModel {
    @Override
    public ArrayList<Ingredient> getIngredients() {
        return null;
    }

    @Override
    public void createIngredient(CreateIngredientDto createIngredientDto) {

    }

    @Override
    public void updateIngredient(UpdateIngredientDto updateIngredientDto) {

    }
}
