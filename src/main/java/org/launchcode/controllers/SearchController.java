package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
//        List<HashMap<String, String>> items = null;
//        if (searchType.equals("all")) {
//            items = JobData.findByValue(searchTerm);
//        } else {
//            items = JobData.findByColumnAndValue(searchType, searchTerm);
//        }
        List<HashMap<String, String>> items = searchType.equals("all") ? JobData.findByValue(searchTerm)
                : JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("items", items);
        return "search";
    }
}
