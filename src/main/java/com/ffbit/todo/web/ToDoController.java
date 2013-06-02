package com.ffbit.todo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<?> index() {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create() {
        return Collections.emptyMap();
    }

}
