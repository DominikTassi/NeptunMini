/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NeptunMini.controllers;

import NeptunMini.controllers.model.SubjectModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 *
 * @author toth125
 */
@Controller
public class HomeController {
    @GetMapping("")
    public String showForm(SubjectModel subjectModel) {
        return "index";
    }
}
