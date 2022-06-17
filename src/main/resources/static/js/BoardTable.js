/*
1. 쓰기
2. 모든 게시물 출력
3. 개별출력
4.수정(조건:비밀번호)
5.삭제(조건:비밀번호)
*/


//쓰기 저장
function save(){
    alert("세이브 진입");
    //폼 가져오기
    let form = $("#board_write_form")[0];
    let formData = new FormData(form);
    console.log(formData);
    $.ajax({
        url : "/writer",
        method : "POST",
        data : formData, //,{"btitle":btitle, "bcontent":bcontent, "bwriter":bwriter,"bpw":bpw}
        contentType : false, //첨부파일 전송시 사용되는 속성
        processData : false, //true 넣으면 문자열이 날아간다.
        success : function(re){
            alert("통신 성공");
        }
    });
}




//모든 게시판 출력
function alltable(){



}
