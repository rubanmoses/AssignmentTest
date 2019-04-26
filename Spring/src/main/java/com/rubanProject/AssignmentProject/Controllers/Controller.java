package com.rubanProject.AssignmentProject.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubanProject.AssignmentProject.Models.Employee;
import com.rubanProject.AssignmentProject.Models.MessageModel;
import com.rubanProject.AssignmentProject.Models.UserDetails;
import com.rubanProject.AssignmentProject.Repository.EmployeeRepository;
import com.rubanProject.AssignmentProject.Service.AssignmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/ruban"})
public class Controller {
	
	@Autowired
	EmployeeRepository employee;
	
	@Autowired
	AssignmentService service;
	
	@GetMapping(path = {"/work"})
	public String workingCheck()
	{
		return "This Controller is Working!";
	}
	
	@GetMapping(path = {"/getEmployees"})
	public List<Employee> getAllTask()
	{
		List<Employee> l = new ArrayList<Employee>();
		employee.save(new Employee(1,"Ruban"));
		employee.save(new Employee(2,"Moses"));
		employee.save(new Employee(3,"George"));
		for(Employee e: employee.findAll())
		{
			l.add(e);
		}
		return l;
	}
	
	@GetMapping(path = {"/getUsersList"})
	public List<UserDetails> getAllUsers()
	{
		return service.addIntialData();
	}
	
	@GetMapping(path = {"/getAllMessage"})
	public List<MessageModel> getAllMessage()
	{
		return service.fetchAllMessages();
	}
	
	@PostMapping(path = {"/addUser"})
	public @ResponseBody UserDetails addNewUser(@RequestBody UserDetails user) 
	{
		return service.addUsers(user);
	}
	
	@PostMapping(path = {"/sendMessage"})
	public @ResponseBody MessageModel sendMessage(@RequestBody MessageModel msg) 
	{
		return service.addMessage(msg);
	}
	
	@GetMapping(path = {"/checkUserExist/{username}"})
	public List<UserDetails> getOneUser(@PathVariable("username") String name) {
		return service.checkUserExist(name);
	}
	
	@GetMapping(path = {"/sentMessage/{fromName}/{toName}"})
	public List<MessageModel> sentMessage(@PathVariable("fromName") String fromName,@PathVariable("toName") String toName) {
		System.out.println("From name is -> " +fromName);
		System.out.println("To name is -> " +toName);
		return service.listOfAllSentMessages(fromName, toName);
	}
	@GetMapping(path = {"/replyMessage/{fromName}/{toName}"})
	public List<MessageModel> replyMessage(@PathVariable("fromName") String fromName,@PathVariable("toName") String toName) {
		return service.listOfAllReplyMessages(fromName, toName);
	}
	@DeleteMapping(path ={"/{id}"})
	public void deleteUser(@PathVariable("id") UserDetails user) 
	{
		System.out.println("Inside delete task method!");
		service.deleteTheUser(user);
	}
}
