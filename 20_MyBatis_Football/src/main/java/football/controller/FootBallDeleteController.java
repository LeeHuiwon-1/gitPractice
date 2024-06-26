package football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import football.model.FootBallDao;

@Controller
public class FootBallDeleteController {

	private final String command = "/delete.fb";
	private final String gotoPage= "redirect:/list.fb";
	
	@Autowired
	FootBallDao fdao;
	
	@RequestMapping(command)
	public ModelAndView delete(
			@RequestParam int num,
			@RequestParam int pageNumber,
			@RequestParam String whatColumn,
			@RequestParam String keyword		
			) {
		ModelAndView mav = new ModelAndView();
		
		fdao.deleteFootBall(num);
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		
		mav.setViewName(gotoPage);
		return mav;
		
	}
}