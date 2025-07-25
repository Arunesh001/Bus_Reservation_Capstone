package com.bus_reservation_system.controller;

import com.bus_reservation_system.model.Trip;
import com.bus_reservation_system.model.User;
import com.bus_reservation_system.repository.TripRepository;
import com.bus_reservation_system.repository.UserRepository;
import com.bus_reservation_system.service.TripService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private TripService tripService;
    @Autowired
    private BookingController bookingController;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model,
                               HttpSession session) {

        // Find the user by username
        User user = userRepository.findByUsername(username);

        // Check if user exists and password matches
        if (user != null && user.getPassword().equals(password)) {
            // Save user in session
            session.setAttribute("loggedInUser", user);
            return "redirect:/"; // Redirect to home/dashboard
        } else {
            // Invalid login
            model.addAttribute("error", "Invalid username or password");
            return "Invalid username or password"; // Return to login page with error
        }
    }

    @GetMapping("/")
    public String showIndexpage(Model model){
        model.addAttribute("trip",new Trip());
        return "index";
    }

    @PostMapping("/")
    public  String getsourceandDetails(@ModelAttribute Trip trip, RedirectAttributes redirectAttributes){
        String source=trip.getSource();
        String destnation=trip.getDestination();
        List<Trip>tripList=tripService.findBySourceContainingIgnoreCaseAndDestinationContainingIgnoreCase(source,destnation);

        redirectAttributes.addFlashAttribute("trip",tripList);
        return "redirect:/bookings/new";

    }
}
