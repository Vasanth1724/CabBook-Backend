package CabBook.CabBookingSite.Service;

import CabBook.CabBookingSite.Model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, String> users = new HashMap<>();

    public Map<String, String> signup(User user) {
        Map<String, String> response = new HashMap<>();
        if (users.containsKey(user.getEmail())) {
            response.put("message", "User already exists!");
        } else {
            users.put(user.getEmail(), user.getPassword());
            response.put("message", "Signup successful!");
        }
        return response;
    }

    public Map<String, String> login(User user) {
        Map<String, String> response = new HashMap<>();
        if (!users.containsKey(user.getEmail())) {
            response.put("message", "User not found!");
        } else if (users.get(user.getEmail()).equals(user.getPassword())) {
            response.put("message", "Login successful!");
            response.put("token", "dummy-jwt-token"); // replace with real token if needed
        } else {
            response.put("message", "Invalid password!");
        }
        return response;
    }
}
