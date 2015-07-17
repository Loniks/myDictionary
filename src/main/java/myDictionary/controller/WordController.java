package myDictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * A Spring MVC controller to produce an HTML frontend. Remember, so auto-configuration adds static index.html support.
 *
 * @author Dmytro Bondar
 */
@Controller
public class WordController {

    /**
     * Redirects to the actual {@code add.html}.
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewApplication() {
        return "add";
    }
}
