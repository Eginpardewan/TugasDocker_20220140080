package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    private final String USERNAME = "admin";
    private final String PASSWORD = "20220140080";

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            session.setAttribute("user", username);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Username atau password salah!");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        // Kirim seluruh objek user ke view
        User user = (User) session.getAttribute("userData");
        model.addAttribute("userData", user);  // ← Perbaikan: kirim objek utuh

        return "home";
    }

    @GetMapping("/form")
    public String formPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam String nama,
                             @RequestParam String nim,
                             @RequestParam(defaultValue = "Laki-laki") String jenisKelamin,
                             HttpSession session,
                             Model model) {

        // Validasi NIM minimal 10 digit
        if (nim == null || nim.length() < 10) {
            model.addAttribute("error", "NIM minimal 10 digit!");
            return "form";
        }

        // Validasi nama tidak boleh kosong
        if (nama == null || nama.trim().isEmpty()) {
            model.addAttribute("error", "Nama tidak boleh kosong!");
            return "form";
        }

        // Simpan data ke session dengan jenis kelamin
        User user = new User(nama, nim, jenisKelamin);
        session.setAttribute("userData", user);

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/reset")
    public String reset(HttpSession session) {
        session.removeAttribute("userData");
        return "redirect:/home";
    }
}