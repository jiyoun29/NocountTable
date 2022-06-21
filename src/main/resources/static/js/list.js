
alltable();
board_get(); //맨처음 호출

//모든 게시판 출력
function alltable(){
    $.ajax({
        url : "/getboardlist" ,
        method : "GET",
        success : function( boardlist ){
        let html =
            '<tr><th width="10%">번호</th><th width="80%">제목</th><th width="10%">작성자</th></tr>';
        for( let i = 0 ; i<boardlist.length ; i++ ){
        html +=
        '<tr>'+
            '<td>'+boardlist[i].bno+'</td> '+
            '<td><a href="/getboard/'+boardlist[i].bno+'">'+boardlist[i].btitle+'<a></td> '+
            '<td>'+boardlist[i].bwriter+'</td>'+
         '</tr>';
            }
            $("#alltable").html( html );
        }
    });
}





//특정 게시물 호출
function board_get(){
    $.ajax({
       url : '/board',
       success : function(board){
        console.log(board);
            let html =
                '<div>게시물 번호:'+board.bno+'</div>'+
                '<div>게시물 제목:'+board.btitle+'</div>'+
                '<div>게시물 내용:'+board.bcontent+'</div>';
            $("#board_view").html(html);
       }
    });
}


