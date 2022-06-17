package ezenweb.controller;

import ezenweb.Dto.BoardDto;
import ezenweb.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/") //최상위경로
    public String index(Model model){

        return "main";
    }

    //쓰기 페이지로 이동
    @GetMapping("/writer")
    public String writer(){
        return "writer";
    }


    //작성한 게시글 등록
    @PostMapping("/writer") //@ResponseBody //객체반환
    @ResponseBody
        public boolean write_save(BoardDto boardDto){
        boardService.boardservice_save(boardDto);
        return true;
    }
//    public boolean write_save(@RequestParam("btitle") String btitle,
//              @RequestParam("bcontent") String bcontent,
//              @RequestParam("bwriter") String bwriter,
//              @RequestParam("bpw") String bpw){
//        //dto 생성
//        BoardDto boardDto = BoardDto.builder()
//                .btitle(btitle)
//                .bcontent(bcontent)
//                .bwriter(bwriter)
//                .bpw(bpw)
//                .build();
//    return true;}






}