package NeptunMini.controllers;

import NeptunMini.controllers.model.StudentModel;
import NeptunMini.entity.RegisteredSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import NeptunMini.entity.Student;
import NeptunMini.entity.Subject;
import NeptunMini.services.StudentService;

import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController implements WebMvcConfigurer {
    private StudentService studentService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/student-results").setViewName("student-results");
    }

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    @ResponseBody
    ModelAndView getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-list-form");
        mav.addObject("studentList", studentList);

        return mav;
    }

    @GetMapping("/init")
    @ResponseBody
    boolean createDemo(){
        Subject subject1 = new Subject("GEAIL-123B", "Java Advanced", 5);
        Subject subject2 = new Subject("GEAIL-686B", "Oracle", 4);

        Student student = new Student("QLNW5K", "Tassi Dominik");

        student.addRegisteredSubjects(new RegisteredSubject(subject1, 5));
        student.addRegisteredSubjects(new RegisteredSubject(subject2, 3));

        studentService.addStudent(student);
        return true;
    }


    @GetMapping("")
    public String showForm(StudentModel studentModel) {
        return "student-form";
    }

    @PostMapping("")
    public String saveSubject(@Valid StudentModel studentModel, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors())
            return "student-form";

        Student student = new Student(studentModel.getStudentId(), studentModel.getStudentName());
        student.setRegisteredSubjects(student.getRegisteredSubjects());

        System.out.println(studentModel.toString());

        studentService.addStudent(student);
        ra.addFlashAttribute("newStudent", studentModel);
        return "redirect:/student-results";
    }


}
