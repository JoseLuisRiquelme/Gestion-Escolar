package cl.praxis.EscuelaRural.controller;

import cl.praxis.EscuelaRural.model.entities.Curso;
import cl.praxis.EscuelaRural.model.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CursoController {
    private final CursoService cService;

    public CursoController(CursoService cService) {
        this.cService = cService;
    }
//courses
    @GetMapping
    public String coursesList(Model model) {
        model.addAttribute("courses", cService.findAll());
        return "coursesList";
    }
//new course form
    @GetMapping("/new")
    public String getCreate() {
        return "newCourse";
    }
//new course creation
    @PostMapping("/new")
    public String postCreate(@ModelAttribute Curso course) {
        boolean result = cService.create(course);
        return "redirect:/courses";
    }
//delete course
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean result = cService.delete(id);
        return "redirect:/courses";
    }
//read course
    @GetMapping("/{id}")
    public String getUpdate(@PathVariable("id") int id, Model model) {
        Curso courseToUpdate = cService.findOne(id);
        model.addAttribute("course", courseToUpdate);
        return "courseEdit";
    }
//update course
    @PostMapping
    public  String postUpdate(@ModelAttribute Curso course){
        boolean result  = cService.update(course);
        return "redirect:/courses";
    }
}
