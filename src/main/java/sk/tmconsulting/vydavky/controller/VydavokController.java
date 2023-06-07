package sk.tmconsulting.vydavky.controller;
import sk.tmconsulting.vydavky.model.Vydavok;
import sk.tmconsulting.vydavky.service.VydavokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VydavokController implements ErrorController {
    @Autowired // vytvori objekt VydavokService, to je to iste ako keby ste dali VydavokService VydavokService = new VydavokService();
    private VydavokService VydavokService;

    @GetMapping("/") // lomka reprezentuje korenovu /hlavnu/ adresu
    public String uvodnaStranka() {
        return "index";
    }

    @GetMapping("/pridajNovyZaznam")
    public String pridaNovyZaznam(Model model) {
        Vydavok vydavokObjekt = new Vydavok();
        model.addAttribute("vydavokObjektThymeleaf", vydavokObjekt);
        return "pridaj-novy-zaznam";
    }

    @PostMapping("/ulozZaznam")
    public String ulozZaznam(@ModelAttribute("vydavokObjektThymeleaf") Vydavok vydavokObjekt) {
        VydavokService.ulozVydavok(vydavokObjekt);
        return "redirect:/"; // presmeruje na hlavnú stranku
    }


    @GetMapping("/zobrazFormularNaAktualizaciu/{id}") // na adresu zobrazFormularNaAktualizaciu/id reagujeme tymto GetMapping-om
    public String zobrazFormularNaAktualizaciu(@PathVariable(value="id") long id, Model model) {
        Vydavok vydavokObjekt = VydavokService.ziskajVydavokPodlaId(id); // my sme ziskali zaznam z databazy, cize Vydavok podla id
        model.addAttribute("vydavokObjektThymeleaf", vydavokObjekt); // prostrednictvom atribútu naplnime vydavok objekt, kt. odosleme Thymeleaf stranke
        return "aktualizuj-zaznam";
    }

    @GetMapping("/vymazZaznam/{id}")
    public String vymazZaznam(@PathVariable(value="id") long id, Model model) {
        VydavokService.odstranVydavokPodlaId(id);
        model.addAttribute("vydavkyZoznam", VydavokService.ziskajVsetkyVydavky());
        return "zobraz-vsetky-zaznamy"; // zobrazi zobraz-vsetky-zaznamy.html
    }


    @GetMapping("/zobrazVsetkyZaznamy") // uri adresa, cize ta adresa ktora je za lomkou
    public String zobrazVsetkyZaznamy(Model model) {
        model.addAttribute("vydavkyZoznam", VydavokService.ziskajVsetkyVydavky());
        return "zobraz-vsetky-zaznamy"; // odkaz na zobraz-vsetky-zaznamy.html, ktory sa nachadza v templates
    }


    @RequestMapping("/error") // adresa pre stranku 404, zobrazi sa vtedy, ked nie je podstranka (uri) najdena
    public String zobrazChybovuStranku() {
        return "zobraz-chybovu-stranku";
    }

}
