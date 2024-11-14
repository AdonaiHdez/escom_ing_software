package com.ing.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;  
    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "<html>"
                + "<head><title>Login</title></head>"
                + "<body>"
                + "<h1>Login</h1>"
                + "<p>Welcome to</p>"
                + "<form action=\"/home\" method=\"post\">" 
                + "<label for=\"email\">Mail:</label><br>" 
                + "<input type=\"email\" id=\"email\" name=\"email\" required><br><br>" 
                + "<label for=\"password\">Password:</label><br>" 
                + "<input type=\"password\" id=\"password\" name=\"password\" required><br><br>" 
                + "<button type=\"submit\">Enviar</button>" // Cambiado a "submit"
                + "</form>" 
                + "<a href=\"/signup\">Forgot password?</a>"
                + "<br>"
                + "<br>"
                + "<a href=\"/signup\">Register!</a>"
                + "</body>"
                + "</html>";
    }
    
    
    @GetMapping("/signup")
    @ResponseBody
    public String showForm() {
        return "<html>" +
                    "<head><title>Form</title></head>" +
                    "<body>" +
                        "<h1>Sign Up</h1>" +
                        "<form action=\"/submit\" method=\"post\">" +
                            "<label for=\"username\">User name:</label><br>" +
                            "<input type=\"text\" id=\"username\" name=\"username\" required><br><br>" +
                            "<label for=\"email\">Mail:</label><br>" +
                            "<input type=\"email\" id=\"email\" name=\"email\" required><br><br>" +
                            "<label for=\"email\">Password:</label><br>" +
                            "<input type=\"password\" id=\"password\" name=\"password\" required><br><br>" +
                            "<button type=\"submit\">Enviar</button>" +
                        "</form>" +
                    "</body>" +
               "</html>";
    }
    
    @PostMapping("/home")
    @ResponseBody
    public String homePage() {
        return "<html>" +
                    "<head><title>Home</title></head>" +
                    "<body>" +
                        "<h1>Home</h1>" +
                        "<p>Welcome to the home page</p>" +
                    "</body>" +
               "</html>";
    }

    @PostMapping("/submit")
    @ResponseBody
    public String submitForm(@RequestParam("username") String username, 
                             @RequestParam("email") String email,
                             @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return String.format("¡Formulario recibido y guardado!<br>Nombre de usuario: %s<br>Correo: %s", username, email);

    
    }
}


