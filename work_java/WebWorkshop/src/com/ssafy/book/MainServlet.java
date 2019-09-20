package com.ssafy.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//초기요청url = http://localhost:8080/ws/main.do
// -> action==null이므로 index.jsp로 간다.
public class MainServlet extends HttpServlet {

	private BookMgr mgr = new BookMgr();
	private LoginDAO dao = new LoginDAO();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");		
		System.out.println("action:"+action);
		
		if(action == null){//처음엔 초기화면으로 간다.
			res.sendRedirect("index.jsp");
			return;
		}
		//action 파라메터 값으로 어디로 갈지 지정한다.
		if (action.equals("SAVE")) {
			save(req, res);
		} else if (action.equals("VIEW")) {
			view(req, res);
		}else if (action.equals("DEL")) {
			delete(req, res);
		}else if (action.equals("SEARCH")) {
			search(req, res);
		}else if (action.equals("REGBOOK")) {
			
			req.getRequestDispatcher("book/Book.jsp").forward(req, res);
		}else if (action.equals("DESC")) {
			desc(req, res);
			
		}else if (action.equals("UPDATE")) {
			update(req, res);
			
		}else if (action.equals("UPDATESAVE")) {
			updateSave(req, res);
			
		}else if(action.equalsIgnoreCase("LOGIN")){
			login(req, res);
			
		}else if(action.equalsIgnoreCase("LOGOUT")){
			HttpSession hs=req.getSession(false);
			if(hs != null){
				hs.invalidate();
			}			
			res.sendRedirect("index.jsp");
		}
	}

	public void desc(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String isbn = req.getParameter("isbn");
		System.out.println(isbn);
		String nextPage="Error.jsp";
		Book b;
		try {
			b = mgr.search(isbn);
			req.setAttribute("result", b.getDescription());
			nextPage="DescResult.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","오류 발생,  다시 시도해 주세요.");
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void search(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String nextPage="Error.jsp";
		String field = req.getParameter("searchField");
		if(field == null) field="";
		String text = req.getParameter("searchText");
		if(text == null)  text="";
		field=field.trim();
		text=text.trim();
		System.out.println(field+":"+text);
		List<Book> result=null;
		try {
			switch(field){
			case "TITLE":			
					result=mgr.searchByTitle(text);				
				break;
			case "PUBLISHER":
				result=mgr.searchByPublisher(text);
				break;
			case "PRICE":
				result=mgr.searchByPrice(Integer.parseInt(text));
				break;
			default :
				result=mgr.search();
			}
			req.setAttribute("books", result );
			req.setAttribute("field", field );
			req.setAttribute("text", text );
			nextPage="book/BookList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	
	public void view(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String nextPage="Error.jsp";
		String isbn = req.getParameter("isbn").trim();
		try {
			req.setAttribute("b",mgr.search(isbn) );
			nextPage="book/BookView.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void update(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String nextPage="Error.jsp";
		String isbn = req.getParameter("isbn").trim();
		try {
			Book bb=mgr.search(isbn);
			System.out.println(bb);
			req.setAttribute("b",bb );
			nextPage="book/BookUpdate.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void updateSave(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String nextPage="Error.jsp";
		Book b=new Book();
		b.setIsbn(req.getParameter("isbn").trim());
		b.setTitle(req.getParameter("title").trim());
		b.setAuthor(req.getParameter("author").trim());
		b.setPrice(Integer.parseInt(req.getParameter("price").trim()));
		b.setDescription(req.getParameter("description").trim());

		try {
			mgr.update(b);
			List<Book> result=mgr.search();
			req.setAttribute("books",result );
			nextPage="book/BookList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg","검색 중 오류가 발생했습니다." );
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void delete(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String isbn = req.getParameter("isbn").trim();
		String nextPage="Result.jsp";
		try {
			req.setAttribute("msg", "정상적으로 삭제 되었습니다");
			mgr.delete(isbn);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			nextPage="Error.jsp";
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void save(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String isbn1 = req.getParameter("isbn1").trim();
		String isbn2 = req.getParameter("isbn2").trim();
		String isbn3 = req.getParameter("isbn3").trim();
		String isbn = isbn1 + "-" + isbn2 + "-" + isbn3;
		String title = req.getParameter("title").trim();
		String catalogue = req.getParameter("catalogue").trim();
		String nation = req.getParameter("nation").trim();
		String publishDate = req.getParameter("publishDate").trim();
		String publisher = req.getParameter("publisher").trim();
		String author = req.getParameter("author").trim();
		String price = req.getParameter("price").trim();
		int p = Integer.parseInt(price);
		String currency = req.getParameter("currency").trim();
		String description = req.getParameter("description").trim();
		Book book = new Book(isbn, title, catalogue, nation, publishDate,
				publisher, author, p, currency, description);
        
   
        
		String nextPage="Error.jsp";
		try {
			mgr.insertBook(book);
			req.setAttribute("book", book);
			req.setAttribute("msg", "정상적으로 저장 되었습니다");
			nextPage="Result.jsp";		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "저장 중 오류가 발행했습니다.");
		}
		req.getRequestDispatcher(nextPage).forward(req, res);
	}
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String nextPage="Error.jsp";
		//DB 연동해서 체크
		try {
			if(dao.loginCheck(user,pass)){
					HttpSession hs=request.getSession();
					hs.setAttribute("user", user);
					request.setAttribute("msg", "정상적으로 로그인 되었습니다");
			}else {
				System.out.println("아이디 또는 패스워드가 틀립니다.");
				String msg="아이디 또는 패스워드가 틀립니다.";
				request.setAttribute("msg", msg);
			}
			nextPage="index.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg","로그인 실패~~잠시 후 사용해 주세요");
		}
		request.getRequestDispatcher(nextPage).forward(request, response);
	}
	public  void logout(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		req.getSession().invalidate();
		res.sendRedirect("index.jsp");
	}
	
}