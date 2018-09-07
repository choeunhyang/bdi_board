package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.board.bdi.common.DBCon;
import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.vo.UserInfoVO;

class UserDAOTest {
	@Test
	void selectUserTest() {// 일부러 에러 발생시키기 테스트
		UserDAO udao = new UserDAOImpl();
		udao.setCon(DBCon.getCon());
		try {
			UserInfoVO ui = new UserInfoVO();
			UserInfoVO rUi = udao.selectUser(ui);
			assertEquals(rUi, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void insertUserTest() {
		UserDAO udao = new UserDAOImpl();
		udao.setCon(DBCon.getCon());
		try {
			UserInfoVO ui = new UserInfoVO();
			ui.setUiid("test");
			ui.setUiname("장길동");
			ui.setUipwd("1234");
			ui.setUiemeil("test@naver.com");
			int cnt = udao.insertUser(ui);
			DBCon.commit();
			assertEquals(cnt, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
	}
}
