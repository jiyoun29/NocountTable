package ezenweb.Service;

import ezenweb.Dto.BoardDto;
import ezenweb.domain.BoardEntity;
import ezenweb.domain.BoardRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    //리포지토리 선언
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;


/////////////////////////////////////////////


    //1. C : 게시글 저장
    @Transactional
    public boolean boardservice_save(BoardDto boardDto){
        //객체 생성
//        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity boardEntity = BoardEntity.builder()
            .btitle(boardDto.getBtitle())
            .bcontent(boardDto.getBcontent())
            .bwriter(boardDto.getBwriter())
            .bpw(boardDto.getBpw())
           .build();

        //저장
        boardRepository.save(boardEntity);
        return true;
    }


    //2. R
        //전부 호출
    public JSONArray getboardlist(){ //모두 호출
        JSONArray jsonArray = new JSONArray(); //리스트 생성

        //불러오기
        List<BoardEntity> boardEntities = boardRepository.findAll();

        //리스트에 있는 모든 entity를 json으로 변환시킴
        for(BoardEntity entity : boardEntities){
            JSONObject object = new JSONObject();

            object.put("bno", entity.getBno());
            object.put("btitle", entity.getBtitle());
            object.put("bwriter", entity.getBwriter());
            //담은 후
            jsonArray.put(object); //반환시킴
        }
        return jsonArray;
    } //getboardlist end


        //개별 호출
    @Transactional
    public JSONObject getboard(int bno){ //게시물 번호를 받음

        Optional<BoardEntity> optional = boardRepository.findById(bno);
        BoardEntity entity = optional.get(); //빼내오기

        JSONObject object = new JSONObject();
        object.put("bno", entity.getBno());
        object.put("btitle", entity.getBtitle());
        object.put("bcontent", entity.getBcontent());
        object.put("bwriter", entity.getBwriter());

        return object;
    }













}
