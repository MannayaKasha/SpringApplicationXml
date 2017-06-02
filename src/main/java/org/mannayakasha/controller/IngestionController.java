package org.mannayakasha.controller;

import org.mannayakasha.model.Ingestion;
import org.mannayakasha.service.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngestionController {

    private IngestionService ingestionService;

    @Autowired(required = true)
    @Qualifier(value = "ingestionService")
    public void setIngestionService(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @RequestMapping(value = "ingestion", method = RequestMethod.GET)
    public String listIngestion(Model model){
        model.addAttribute("ingestion", new Ingestion());
        model.addAttribute("listIngestion", this.ingestionService.listIngestion());

        return "ingestion";
    }

    @RequestMapping(value = "/ingestion/add", method = RequestMethod.POST)
    public String addIngestion(@ModelAttribute("ingestion") Ingestion ingestion){
        if(ingestion.getId() == null){
            this.ingestionService.addIngestion(ingestion);
        }else {
            this.ingestionService.updateIngestion(ingestion);
        }

        return "redirect:/ingestion";
    }

    @RequestMapping("/removeIngestion/{id}")
    public String removeIngestion(@PathVariable("id") int id){
        this.ingestionService.removeIngestion(id);

        return "redirect:/ingestion";
    }

    @RequestMapping("editIngestion/{id}")
    public String editIngestion(@PathVariable("id") int id, Model model){
        model.addAttribute("ingestion", this.ingestionService.getIngestionById(id));
        model.addAttribute("listIngestion", this.ingestionService.listIngestion());

        return "ingestion";
    }

/*    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }*/
}
