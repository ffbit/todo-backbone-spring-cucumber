package cucumber.todo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String[] index(Model model) {
        return new String[]{"one", "two", "three"};
    }

}
