package org.launchcode.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {

    static HashMap<String, String> actionChoices = new HashMap<String, String>();

    @ModelAttribute("actions")
    public static HashMap getActionChoices(){
        return actionChoices;
    }
}
