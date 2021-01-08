package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class AddController
{

  @RequestMapping(value = "/",method = RequestMethod.GET)
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName( "index" );
    return mv;
  }
  @RequestMapping(value="/add",method = RequestMethod.POST)
  public ModelAndView addIt( Model model)
  {
    int number1 = Integer.parseInt( model.getAttribute( "number1" ).toString());
    int number2 = Integer.parseInt( model.getAttribute( "number2" ).toString());
    ModelAndView mv = new ModelAndView();
    mv.addObject( "ans",number1+number2 );
    mv.setViewName("display"  );
    return mv;
  }
}
