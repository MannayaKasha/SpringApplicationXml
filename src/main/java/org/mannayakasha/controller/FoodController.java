package org.mannayakasha.controller;

import org.mannayakasha.model.Food;
import org.mannayakasha.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

    private FoodService foodService;

    @Autowired(required = true)
    @Qualifier(value = "foodService")
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "foods", method = RequestMethod.GET)
    public String listFoods(Model model){
        model.addAttribute("food", new Food());
        model.addAttribute("listFoods", this.foodService.listFoods());

        return "foods";
    }

    @RequestMapping(value = "/foods/add", method = RequestMethod.POST)
    public String addFood(@ModelAttribute("food") Food food){
        if(food.getId() == null){
            this.foodService.addFood(food);
        }else {
            this.foodService.updateFood(food);
        }

        return "redirect:/foods";
    }

    @RequestMapping("/removeFood/{id}")
    public String removeFood(@PathVariable("id") int id){
        this.foodService.removeFood(id);

        return "redirect:/foods";
    }

    @RequestMapping("editFood/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("food", this.foodService.getFoodById(id));
        model.addAttribute("listFoods", this.foodService.listFoods());

        return "foods";
    }

/*    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }*/
}
