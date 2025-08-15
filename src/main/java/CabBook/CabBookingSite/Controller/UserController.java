package CabBook.CabBookingSite.Controller;

import CabBook.CabBookingSite.Model.User;
import CabBook.CabBookingSite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        return userService.login(user);
    }
}
