package com.board.bdi.service.impl;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.board.bdi.common.DBCon;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.common.UploadFiles;
import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;
import com.board.bdi.vo.BoardInfoVO;
import com.board.bdi.vo.CommentInfoVO;
import com.board.bdi.vo.PageInfo;


public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	@Override
	public void insertBoard(HttpServletRequest request) throws SQLException, ServletException {
		Map<String,String> params = UploadFiles.saveFileList(request);
		BoardInfoVO bi = new BoardInfoVO();
		bi.setBititle(params.get("bititle"));
		bi.setBitext(params.get("bitext"));
		bi.setBifile(params.get("bifile"));
		bi.setUinum(Integer.parseInt(params.get("uinum")));
		bdao.setCon(DBCon.getCon());
		try {
			request.setAttribute("cnt", bdao.insertBoard(bi));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void selectBoard(HttpServletRequest request) throws SQLException, ServletException {
		BoardInfoVO bi = ParseUtil.parseRequest(request, BoardInfoVO.class);
		
		bdao.setCon(DBCon.getCon());
		try {
			bdao.updateBoardCnt(bi);
			CommentInfoVO ci = new CommentInfoVO();
			ci.setBinum(bi.getBinum());
			request.setAttribute("ciList", bdao.selectCommentList(ci));
			request.setAttribute("bi", bdao.selectBoard(bi));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void updateBoard(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectBoardList(HttpServletRequest request) throws SQLException, ServletException {
		BoardInfoVO bi = ParseUtil.parseRequest(request, BoardInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			/*PageInfo pi = new PageInfo();
			pi.setTotalCnt(bdao.countBoardList());
			pi.pageCount();
			bi.setPi(pi);
			request.setAttribute("pi", pi);*/
			PageInfo pi = bi.getPi();
			pi.setTotalCnt(bdao.countBoardList());
			pi.pageCount();
			request.setAttribute("pi", pi);
//			request.setAttribute("pi", bi.getPi());
			request.setAttribute("biList", bdao.selectBoardList(bi));
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void selectCommentList(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectComment(HttpServletRequest request) throws SQLException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertComment(HttpServletRequest request) throws SQLException, ServletException {
		CommentInfoVO ci = ParseUtil.parseRequest(request, CommentInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			BoardInfoVO bi = new BoardInfoVO();
			bi.setBinum(ci.getBinum());
			request.setAttribute("bi", bdao.selectBoard(bi));
			request.setAttribute("ciCnt", bdao.insertComment(ci));
			request.setAttribute("ciList", bdao.selectCommentList(ci));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void deleteComment(HttpServletRequest request) throws SQLException, ServletException {
		CommentInfoVO ci = ParseUtil.parseRequest(request, CommentInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			BoardInfoVO bi = new BoardInfoVO();
			bi.setBinum(ci.getBinum());
			request.setAttribute("ciDelCnt", bdao.deleteComment(ci));
			request.setAttribute("bi", bdao.selectComment(ci));
			request.setAttribute("ciList", bdao.selectCommentList(ci));
			DBCon.commit();
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
