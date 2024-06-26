package football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import football.model.FootBallDao;

@Controller
public class FootBallCheckController {

	@Autowired
	FootBallDao fdao;
	
	private final String command = "/name_check_proc.fb";

	@RequestMapping(command)
	@ResponseBody
	public String check(@RequestParam(
					value="inputName",required = true) String inputName
									) {
		
		System.out.println("controller inputName : " + inputName);

		int cnt = fdao.searchName(inputName);
		
		if(cnt == 0) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
