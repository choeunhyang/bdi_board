package com.board.bdi.service.impl;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.board.bdi.common.DBCon;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;
import com.board.bdi.vo.UserInfoVO;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();

	@Override
	public void joinUser(HttpServletRequest request) throws SQLException, ServletException {
		UserInfoVO ui = ParseUtil.parseRequest(request, UserInfoVO.class);
		udao.setCon(DBCon.getCon());
		try {
			if (udao.selectUser(ui) == null) {
				int cnt = udao.insertUser(ui);
				request.setAttribute("cnt", cnt);
				DBCon.commit();
			} else {
				request.setAttribute("err", "아이디 중복 됬다고!!");
//				throw new ServletException("아이디 이미 있음.");
			}
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
	}

	@Override
	public void loginUser(HttpServletRequest request) throws SQLException, ServletException {
		UserInfoVO ui = ParseUtil.parseRequest(request, UserInfoVO.class);
		udao.setCon(DBCon.getCon());
		try {
			UserInfoVO rUi = udao.selectUser(ui);
			if (rUi != null) {
				if(rUi.getUipwd().equals(ui.getUipwd())) {
					HttpSession hs = request.getSession();
					hs.setAttribute("user", rUi);
					request.setAttribute("msg", rUi.getUiname() + "님 환영합니다.");
				}else {
					request.setAttribute("err", "비밀번호를 확인해주세요.");
				}
			} else {
				request.setAttribute("err", "아이디를 확인해주세요.");
			}
		} catch (SQLException e) {
			DBCon.rollback();
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
	}

	@Override
	public void logoutUser(HttpServletRequest request) throws SQLException, ServletException {
		HttpSession hs = request.getSession();
		hs.invalidate();

	}

	@Override
	public void deleteUser(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void userList(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

}
