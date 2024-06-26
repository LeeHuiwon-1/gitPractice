package football.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import football.model.FootBallBean;
import football.model.FootBallDao;

@Controller
public class FootBallInsertController {

	private final String command = "/insert.fb";
	private final String getPage = "FootBallInsert";
	private final String gotoPage = "redirect:/list.fb";
	
	@Autowired
	FootBallDao fdao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String insertForm() {
		return getPage;
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView insert(
					@ModelAttribute("football")@Valid FootBallBean football,
					BindingResult result
			) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = -1;
		cnt = fdao.insertFootBall(football);
		
		if(cnt != -1) {
			mav.setViewName(gotoPage);
		}
		else {
			mav.setViewName(getPage);
		}
		return mav;
	}
}
