package com.example.springboottodoapp.Controllers;

import com.example.springboottodoapp.Models.TodoItem;
import com.example.springboottodoapp.Services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model){

        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemService
        .getById(id)
        .orElseThrow(() -> new IllegalArgumentException("ToDo Item: " + id + "not found"));

        todoItemService.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemService
        .getById(id)
        .orElseThrow(() -> new IllegalArgumentException("ToDo Item: " + id + "not found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";

    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable ("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model){

        TodoItem item = todoItemService
        .getById(id)
        .orElseThrow(() -> new IllegalArgumentException("ToDo Item: " + id + "not found"));
        
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemService.save(todoItem);
        return "redirect:/";
    }
}
