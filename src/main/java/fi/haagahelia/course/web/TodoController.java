package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Todo;
import fi.haagahelia.course.domain.TodoRepository;

@Controller
public class TodoController {
	@Autowired
	private TodoRepository repository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }		
	
	// Show all todos
    @RequestMapping(value="/todos")
    public String todoList(Model model) {	
        model.addAttribute("todolist", repository.findAll());
        return "todos";
    }

    // Add new todo
    @RequestMapping(value = "/add")
    public String addTodo(Model model){
    	model.addAttribute("todo", new Todo());
        return "addtodo";
    }     
    
    // Save new todo
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Todo todo){
        repository.save(todo);
        return "redirect:todos";
    }    

}
