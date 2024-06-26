package football.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import football.model.FootBallBean;
import football.model.FootBallDao;
import utility.Paging;

@Controller
public class FootBallListController {

	private final String command = "/list.fb";
	private final String goPage = "footballList";
	
	@Autowired
	private FootBallDao fdao;
	
	@RequestMapping(command)
	public ModelAndView list(
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			HttpServletRequest request
			) {
		
		Map map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = fdao.getTotalCount(map);
		String url = request.getContextPath() + this.command;
		
		Paging pageInfo = new Paging(pageNumber, null, totalCount,url, whatColumn, keyword);
		
		ModelAndView mav = new ModelAndView();
		List<FootBallBean> lists = fdao.getFootBallLists(map,pageInfo);
		
		mav.addObject("lists", lists);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(goPage);
		return mav;
	}
}
