package kr.co.itcen.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.itcen.mysite.dao.BoardDao;
import kr.co.itcen.mysite.vo.BoardVo;
import kr.co.itcen.web.WebUtils;
import kr.co.itcen.web.mvc.Action;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no=null;
		if(!"".equals(request.getParameter("no"))) {
			no = Long.parseLong(request.getParameter("no"));
		}
		String title=request.getParameter("title");
		String context = request.getParameter("content");
		BoardVo vo = new BoardDao().view(no);
		vo.setNo(no);
		request.setAttribute("vo", vo);
		WebUtils.forward(request, response, "/WEB-INF/views/board/view.jsp");
	}

}
