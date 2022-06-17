package ezenweb.domain;

import lombok.*;

import javax.persistence.*;

@Getter  @Setter  @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder @Table(name = "board")
@Entity
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; //번호
    private String btitle; //제목
    @Column(columnDefinition = "TEXT")
    private String bcontent; //내용
    private String bwriter; //작성자
    private String bpw; //비밀번호

}
