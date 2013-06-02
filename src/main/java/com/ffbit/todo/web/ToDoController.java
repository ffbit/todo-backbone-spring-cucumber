package com.ffbit.todo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/todos")
public class ToDoController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<?> index() {
        logger.info("index");
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create() {
        logger.info("create");
        return Collections.singletonMap("id", 1);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, String> update(@RequestBody Map<String, String> todo,
                                      @PathVariable String id) {
        logger.info("update todo: {} {}", id, todo);
        return todo;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpStatus destroy(@PathVariable String id) {
        logger.info("destroy {}", id);
        return HttpStatus.OK;
    }

}
