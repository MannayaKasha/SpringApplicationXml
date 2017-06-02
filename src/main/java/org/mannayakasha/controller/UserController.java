package org.mannayakasha.controller;

import org.mannayakasha.model.Meal;
import org.mannayakasha.model.User;
import org.mannayakasha.service.MealService;
import org.mannayakasha.service.SecurityService;
import org.mannayakasha.service.UserService;
import org.mannayakasha.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel
 * @version 1.0
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private MealService mealService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        List<Meal> listMeals = this.mealService.listMeals();
        double totalFats = 0;
        double totalProteins = 0;
        double totalCarbohydrates = 0;
        int totalCalories = 0;
        String user = getPrincipal();
        int neededCalories = this.userService.findByUsername(user).getCalories();

        for (Meal meal : listMeals) {
            if (meal.getUser().getUsername().equals(user)) {
                totalFats += meal.getFood().getFats();
                totalProteins += meal.getFood().getProteins();
                totalCarbohydrates += meal.getFood().getCarbohydrates();
                totalCalories += meal.getFood().getCalories();
            }
        }


        double progressBar = totalCalories * 100 / neededCalories;

        model.addAttribute("progressBar", progressBar);
        model.addAttribute("totalFats", totalFats);
        model.addAttribute("totalProteins", totalProteins);
        model.addAttribute("totalCarbohydrates", totalCarbohydrates);
        model.addAttribute("totalCalories", totalCalories);

        model.addAttribute("user", user);

        model.addAttribute("meal", new Meal());
        model.addAttribute("listMeals", this.mealService.listMeals());

        return "welcome";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
