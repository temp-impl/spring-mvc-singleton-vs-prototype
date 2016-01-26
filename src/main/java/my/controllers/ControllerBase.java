package my.controllers;

import com.google.common.collect.ImmutableMap;
import my.beans.PrototypeBean;
import my.beans.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class ControllerBase {

    @Autowired
    private SingletonBean singleton;

    @Autowired
    private PrototypeBean prototype;

    private <T> T createAutowiredObject(Class<T> clazz){
        return factory.createBean(clazz);
    }
    @Autowired
    private AutowireCapableBeanFactory factory;

    @RequestMapping({"", "/"})
    public String _default(Model model){
        ImmutableMap<String,Object> map = ImmutableMap.<String, Object>builder()
            .put("controller", this)
            .put("singleton_member", singleton)
            .put("prototype_member", prototype)
            .put("singleton_created", createAutowiredObject(SingletonBean.class))
            .put("prototype_created", createAutowiredObject(PrototypeBean.class))
            .build();
        model.addAttribute("map", map);
        return "default";
    }
}
