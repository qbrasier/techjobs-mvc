package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String results(Model model, HttpServletRequest request) {
        //first we need to get value of searchType
        //second we need to get value of search terms
        //then we need to call something but not sure what
        //  probably the list controller

        model.addAttribute("columns", ListController.columnChoices);

        //model.addAttribute("hi", "HI");
        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");

        if(searchType.equals("all")){
            model.addAttribute("jobs", JobData.findByValue(searchTerm));
        }else{
            model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        }

        return "search";
    }

}
