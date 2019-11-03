package maz.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import maz.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        log.debug("######### Index Controller #########");
        return "index";
    }

}
