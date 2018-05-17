package NeptunMini.controllers;

import NeptunMini.controllers.model.AddSubjectModel;
import NeptunMini.controllers.model.MarkModel;
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
        registry.addViewController("/addMark-results").setViewName("addMark-results");
        registry.addViewController("/addSubjectToStudent-results").setViewName("addSubjectToStudent-results");
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

    @GetMapping("/addMarkTest")
    @ResponseBody
    boolean addMarkTest(){

        studentService.addMark("QLNW5K","GEAIL-123B", 1);

        return true;
    }


    @GetMapping("/addMark")
    public String showAddMarkForm(MarkModel markModel) {
        return "addMark-form";
    }

    @PostMapping("/addMark")
    public String addMark(@Valid MarkModel markModel, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors())
            return "addMark-form";

        Student student = studentService.getStudentById(markModel.getStudentId());
        student.setRegisteredSubjects(student.getRegisteredSubjects());
        List<RegisteredSubject> registeredSubjects = student.getRegisteredSubjects();

        for (int i = 0; i < registeredSubjects.size(); i++){
            if(registeredSubjects.get(i).getSubject().getSubjectId().equals(markModel.getSubjectId())){
                studentService.addMark(markModel.getStudentId(), markModel.getSubjectId(), markModel.getMark());
            }
        }

        System.out.println(markModel.toString());
        ra.addFlashAttribute("newMark", markModel);
        return "redirect:/addMark-results";
    }


    @GetMapping("/registerSubject")
    public String showRegisterSubjectForm(AddSubjectModel addSubjectModel) {
        return "addMark-form";
    }

    @PostMapping("/registerSubject")
    public String addSubject(@Valid AddSubjectModel addSubjectModel, BindingResult bindingResult, RedirectAttributes ra){
        if(bindingResult.hasErrors())
            return "addMark-form";

        Student student = studentService.getStudentById(addSubjectModel.getStudentId());
        studentService.addSubjectToStudent(addSubjectModel.getStudentId(), );

        System.out.println(addSubjectModel.toString());
        ra.addFlashAttribute("addedSubject", addSubjectModel);
        return "redirect:/addSubject-results";
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
