// 사용자
글쓰기 (/user/write.do)
{
    type : create
    {
        seq : (글번호)
        id : (유저닉네임)
        content : (글내용)
        crt_time : (작성시간)
    }
}

조회 (/user/list.do)
{
    type : read
    {
       seq : (글번호) 
       content : (글내용)
       crt_time : (작성시간)
    }
    {
        seq : (글번호) 
       content : (글내용)
       crt_time : (작성시간)
    } 
    {
        seq : (글번호) 
       content : (글내용)
       crt_time : (작성시간)
    } 
    .... 
}


// 관리자

삭제 (/master/delete.do)
{
    type : delete
    {
        seq : (글번호)
    }   
}

숨기기/열기 (/master/secret.do)
{
    type : update
    open : true / false
    {
        seq : (글번호)
    }
}

전체조회 (/master/list.do)
{
    type : read
    {
        seq : (글번호) 
        open : true / false
        id : (닉네임)
        content : (글내용)
        crt_time : (작성시간)
    }
}