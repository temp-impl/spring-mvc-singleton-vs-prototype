package my.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/prototype")
public class PrototypeController extends ControllerBase {
}
