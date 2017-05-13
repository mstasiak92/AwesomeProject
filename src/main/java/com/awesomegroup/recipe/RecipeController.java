package com.awesomegroup.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Michał on 2017-04-23.
 */
@Controller
@RequestMapping("/partials/recipe")
public class RecipeController {

    @GetMapping("list")
    public String displayRecipesListPartial() {
        return "partials/recipes/list";
    }
}