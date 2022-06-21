package ezenweb.controller;

import ezenweb.Dto.BoardDto;
import ezenweb.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

    @Autowired
    private HttpServletRequest request;
    //세션 호출을 위한 request 객체 생성

    @Autowired
    private BoardService boardService;
    //서비스 호출을 위한 boardservice 객체 생성






    ///////////////////////////////////// 페이지 열기

    @GetMapping("/") //최상위경로로 메인 페이지 열기
    public String index(Model model){
        return "main";
    }

    //쓰기 페이지로 이동
    @GetMapping("/writer")
    public String writer(){
        return "writer";
    }



    ////////////////////////////////////////호출(처리)


    //1. C : 작성한 게시글 등록
    @PostMapping("/writer") 
    @ResponseBody //객체 반환
        public boolean write_save(BoardDto boardDto){
        boardService.boardservice_save(boardDto);
        return true;
    }


    //2. R 모든 게시물 출력
    @GetMapping("/getboardlist")
    public void getboardlist(HttpServletResponse response){
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(boardService.getboardlist());
        } catch (Exception e) {System.out.println(e);}
    }


    //2-1. 개별 게시물 출력
    @GetMapping("/board")
    public void board(HttpServletResponse response){
        int bno = (Integer) request.getSession().getAttribute("bno");
        try{
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(boardService.getboard(bno));
        } catch (Exception e){ System.out.println(e); }
    }

    int bnocall = 0;
    @GetMapping("/getboard/{bno}")
    public String getboard(HttpServletResponse response , @PathVariable("bno") int bno){
        request.getSession().setAttribute("bno", bno);
        bnocall = bno;
        return "view";
    }


}