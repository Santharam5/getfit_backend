package com.example.getfit.RestAPi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.getfit.controller.User;
import com.example.getfit.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://your-frontend-domain.com","https://get-4hrrx71dq-santharam-bs-projects.vercel.app"})
public class UserRestApi {
@Autowired
private UserService userService;
@PostMapping("/createquery")
public User Create(@RequestBody User Userdetails ) {
	return userService.save(Userdetails);
}
@GetMapping("/getalluser")
public List<User> getalluser(){
	List<User> alluser=userService.listofAllUsers();
	if(alluser.isEmpty()) {
		System.out.println("None of the Users are Found!!!");
	}
	return alluser;
}
@GetMapping("/getalluser/{id}")
public User getsingleuserid(@PathVariable Integer id) {
	User Singleuser=userService.getUser(id);
	return Singleuser;
}
@PutMapping("/{id}")
public User updateuser(@PathVariable Integer id,@RequestBody User Userdetails ) {
	User updateduser = userService.getUser(id);
    Userdetails.setId(updateduser.getId());
    return userService.save(Userdetails);
}
@DeleteMapping("/{id}")
	public String deletesingleuser(@PathVariable Integer id) {
		userService.DeleteUser(id);
		return "User is Deleted from database!!!";
	}
@DeleteMapping("/deleteall")
public String deleteallstring() {
	userService.DeleteAllUSer();
	return "All Users are removed from Database!!!";
}
}

