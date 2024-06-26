package football.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utility.Paging;

@Service("myFootBallDao")
public class FootBallDao {

	private String namespace="football.FootBallBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<FootBallBean> getFootBallLists(Map<String, String> map, Paging pageInfo) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<FootBallBean> lists = new ArrayList<FootBallBean>();
		
		lists = sqlSessionTemplate.selectList(namespace + ".getFootBallLists", map, rowBounds);
		
		return lists;
	}
	
	public int getTotalCount(Map map) {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		System.out.println("getTotalCount cnt : " + cnt);
		return cnt;
	}

	public int insertFootBall(FootBallBean football) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".insertFootBall", football);
		return cnt;
	}

	public int searchName(String inputName) {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace + ".searchName", inputName);
		return cnt;
	}

	public FootBallBean getFootBallNum(int num) {
		int cnt = -1;
		FootBallBean fb = null;
		fb = sqlSessionTemplate.selectOne(namespace + ".getFootBallNum", num);
		return fb;
	}

	public int updateFootBall(FootBallBean football) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".updateFootBall", football);
		return cnt;
	}

	public int deleteFootBall(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteFootBall", num);
		return cnt;
	}

}
