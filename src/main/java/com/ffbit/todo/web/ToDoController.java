package com.ffbit.todo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

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
    public Object update(@PathVariable String id) {
        logger.info("update {}", id);
        return Collections.emptyMap();
    }

}
