package Model.interfaces;

import Model.dto.CreateIngredientDto;
import Model.dto.UpdateIngredientDto;
import Model.entities.Ingredient;

import java.util.ArrayList;

public interface IIngredientModel {

    public ArrayList<Ingredient> getIngredients();

    public void createIngredient(CreateIngredientDto createIngredientDto);

    public void updateIngredient(UpdateIngredientDto updateIngredientDto);

}
