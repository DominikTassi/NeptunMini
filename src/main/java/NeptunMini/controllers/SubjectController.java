package NeptunMini.controllers;

import NeptunMini.controllers.model.SubjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import NeptunMini.entity.Subject;
import NeptunMini.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController implements WebMvcConfigurer {
    private SubjectService subjectService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/subject-results").setViewName("subject-results");
    }
    @Autowired
    public void setSubjectService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllSubject(){
        List<Subject> subjectList = subjectService.getAllSubject();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("subject-list-form");
        mav.addObject("subjectList", subjectList);

        return mav;
    }

    @GetMapping("/init")
    @ResponseBody
    boolean createDemo(){
        Subject subject = new Subject("GEAIL-123B", "Java Advanced", 5);
        subjectService.addSubject(subject);
        Subject subject2 = new Subject("GEAIL-686B", "Oracle", 4);
        subjectService.addSubject(subject2);
        return true;
    }

    @GetMapping("")
    public String showForm(SubjectModel subjectModel) {
        return "subject-form";
    }

    @PostMapping("")
    public String saveSubject(@Valid SubjectModel subjectModel, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors())
            return "subject-form";

        Subject subject = new Subject(subjectModel.getSubjectId(), subjectModel.getSubjectName(), subjectModel.getCredit());

        System.out.println(subjectModel.toString());

        subjectService.addSubject(subject);

        ra.addFlashAttribute("newSubject", subjectModel);
        return "redirect:/subject-resutls";
    }




}
