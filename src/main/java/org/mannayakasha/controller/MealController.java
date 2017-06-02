package org.mannayakasha.controller;

import org.mannayakasha.model.Meal;
import org.mannayakasha.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MealController {

    private MealService mealService;

    @Autowired(required = true)
    @Qualifier(value = "mealService")
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }

    @RequestMapping(value = "meals", method = RequestMethod.GET)
    public String listMeals(Model model){
        model.addAttribute("meal", new Meal());
        model.addAttribute("listMeals", this.mealService.listMeals());

        return "meals";
    }

    @RequestMapping(value = "/meals/add", method = RequestMethod.POST)
    public String addMeal(@ModelAttribute("meal") Meal meal){
        if(meal.getId() == null){
            this.mealService.addMeal(meal);
        }else {
            this.mealService.updateMeal(meal);
        }

        return "redirect:/meals";
    }

    @RequestMapping("/removeMeal/{id}")
    public String removeMeal(@PathVariable("id") int id){
        this.mealService.removeMeal(id);

        return "redirect:/meals";
    }

    @RequestMapping("editMeal/{id}")
    public String editMeal(@PathVariable("id") int id, Model model){
        model.addAttribute("meal", this.mealService.getMealById(id));
        model.addAttribute("listMeals", this.mealService.listMeals());

        return "meals";
    }

/*    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }*/
}
