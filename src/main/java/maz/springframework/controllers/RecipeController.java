package maz.springframework.controllers;

import lombok.extern.slf4j.Slf4j;
import maz.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {
   private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping("recipes")
    public String recipe(Model model){
        log.debug("######### Recipe Controller #########");
        model.addAttribute("recipes",recipeService.getRecipes());
        return "recipes";
    }


}
