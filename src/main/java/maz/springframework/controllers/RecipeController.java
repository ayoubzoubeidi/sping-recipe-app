package maz.springframework.controllers;

import maz.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
   private RecipeService recipeService;

    @RequestMapping("recipes")
    public String recipe(Model model){
        model.addAttribute("recipes",recipeService.findRecipes());
        return "recipes";
    }


}
