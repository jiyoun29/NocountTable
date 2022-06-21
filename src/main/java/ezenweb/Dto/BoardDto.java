package ezenweb.Dto;

import ezenweb.domain.BoardEntity;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
public class BoardDto {

    private int bno; //번호
    private String btitle; //제목
    private String bcontent; //내용
    private String bwriter; //작성자
    private String bpw; //비밀번호
    private String bcategory; //카테고리

    //dto-> entity
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bwriter(this.bwriter)
                .bpw(this.bpw)
                .bcategory(this.bcategory)
                .build();
    }
}
