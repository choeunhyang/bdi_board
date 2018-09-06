package com.board.bdi.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.board.bdi.common.ParseUtil;
import com.board.bdi.vo.CommentInfoVO;

/**
 * Servlet implementation class MappingServlet
 */
@WebServlet("/mapping/*")
public class MappingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MappingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> params = request.getParameterMap();
		CommentInfoVO ci = ParseUtil.parseRequest(request, CommentInfoVO.class);
		System.out.println(ci);
//		CommentInfoVo ci = new CommentInfoVo();
//		try {
//			BeanUtils.populate(ci, request.getParameterMap());
//			System.out.println(ci);
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ci.setCinum(Integer.parseInt(request.getParameter("cinum")));
//		System.out.println(params);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
