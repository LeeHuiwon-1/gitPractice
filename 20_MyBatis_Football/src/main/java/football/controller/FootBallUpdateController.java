package football.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import football.model.FootBallBean;
import football.model.FootBallDao;

@Controller
public class FootBallUpdateController {

	private final String command = "/update.fb";
	private final String getPage = "FootBallUpdate";
	private final String gotoPage = "redirect:/list.fb";
	
	@Autowired
	FootBallDao fdao;
	
	@RequestMapping(value=command , method=RequestMethod.GET)
	public ModelAndView updateForm(
				@RequestParam(value="num", required = true) int num, 
				@RequestParam(value="pageNumber", required = false) String pageNumber,
				@RequestParam(value="whatColumn", required = false) String whatColumn,
				@RequestParam(value="keyword", required = false) String keyword
			) {
		
		FootBallBean fb = fdao.getFootBallNum(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("football", fb);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("football") @Valid FootBallBean football, BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword
			) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		fdao.updateFootBall(football);
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);		
		mav.setViewName(gotoPage);
		return mav;
	}
}
