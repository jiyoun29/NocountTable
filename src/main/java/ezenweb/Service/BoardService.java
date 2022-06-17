package ezenweb.Service;

import ezenweb.Dto.BoardDto;
import ezenweb.domain.BoardEntity;
import ezenweb.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {

    //리포지토리 선언
    @Autowired
    private BoardRepository boardRepository;

    //게시글 저장
    @Transactional
    public boolean boardservice_save(BoardDto boardDto){
        //객체 생성
        BoardEntity boardEntity = boardDto.toEntity();
//        BoardEntity boardEntity = BoardEntity.builder()
//            .btitle(boardDto.getBtitle())
//            .bcontent(boardDto.getBcontent())
//            .bwriter(boardDto.getBwriter())
//            .bpw(boardDto.getBpw())
//           .build();

        //저장
        boardRepository.save(boardEntity);
        return true;
    }

}
