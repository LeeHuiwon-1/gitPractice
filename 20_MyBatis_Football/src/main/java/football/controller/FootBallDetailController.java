package football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import football.model.FootBallBean;
import football.model.FootBallDao;

@Controller
public class FootBallDetailController {
	
	private final String command = "/detail.fb";
	private final String gotoPage = "FootBallDetail";

	@Autowired
	FootBallDao fdao;
	
	@RequestMapping(value=command)
	public String detail(
				@RequestParam int num,
				@RequestParam int pageNumber,
				@RequestParam String whatColumn,
				@RequestParam String keyword,
				Model model
			) {
		
		FootBallBean fb = fdao.getFootBallNum(num);
		model.addAttribute("football", fb);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);
		
		return gotoPage;
	}
}
