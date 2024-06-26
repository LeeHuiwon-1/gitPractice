package football.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class FootBallBean {

	private int num;
	
	@NotEmpty(message="필수 입력 사항입니다.")
	private String name;
	
	@NotEmpty(message="필수 입력 사항입니다.")
	private String league;
	
	@NotEmpty(message="필수 입력 사항입니다.")
	private String team;
	
	@NotEmpty(message="필수 입력 사항입니다.")
	private String position;
	
	@NotNull(message="필수 입력 사항입니다.")
	private int height;
	
	@NotNull(message="필수 입력 사항입니다.")
	private int weight;
	
	@NotEmpty(message="필수 입력 사항입니다.")
	private String grade;
	
	public FootBallBean() {
		
	}

	public FootBallBean(int num, String name, String league, String team, String position, int height, int weight,
			String grade) {
		super();
		this.num = num;
		this.name = name;
		this.league = league;
		this.team = team;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.grade = grade;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
