package net.javaguides.helloworld.controller;

import net.javaguides.helloworld.service.VydavokService;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VydavokController implements ErrorController {
    private VydavokService vydavokService;

    @GetMapping("/") // lomka reprezentuje korenovu /hlavnu/ adresu
    public String uvodnaStranka(Model model) {
        model.addAttribute("vydavky", vydavokService.ziskajVsetkyVydavky()); //
        return "index";
    }

    @GetMapping("/zobrazVsetkyZaznamy") // uri adresa, cize ta adresa ktora je za lomkou
    public String zobrazVsetkyZaznamy() {
        return "zobraz-vsetky-zaznamy"; // odkaz na zobraz-vsetky-zaznamy.html, ktory sa nachadza v templates
    }

    @RequestMapping("/error") // adresa pre stranku 404, zobrazi sa vtedy, ked nie je podstranka (uri) najdena
    public String zobrazChybovuStranku() {
        return "zobraz-chybovu-stranku";
    }


}
