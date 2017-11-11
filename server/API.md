<b>모든 key-value는 쌍따옴표(")로 쌓여있다.</b><br>

예 ) "type" : "GOOGLE"

<table>
    <tbody>
    <tr>
        <th></th>
        <th align=left>Client->Server</th>
        <th align=left>Server->Client</th>
    </tr>
    <tr>
        <td>글쓰기 : (/user/write.do)</td>
        <td>
            type : CREATE,<br>
            seq : (글번호), <br>
            userId : (유저닉네임), <br>
            title : (제목), <br>
            content : (글내용), <br>
            crt_time : (작성시간) <br>
        </td>
        <td align="center">-</td>
    </tr>
    <tr>
        <td>글 조회 (사용자) : (/user/list.do)</td>
        <td align="center">-</td>
        <td>
            type : READ<br>
            list: [<br>
            {<br>
                seq : (글번호) ,<br>
                title : (글제목), <br>
                content : (글내용),<br>
                crt_time : (작성시간)<br>
            },<br>
            {<br>
                seq : (글번호) ,<br>
                title : (글제목), <br>
                content : (글내용),<br>
                crt_time : (작성시간)<br>
            }...]<br>
        </td>
    </tr>
    <tr>
        <td>삭제 : (/master/delete.do)</td>
        <td>
            type : DELTE,<br>
            seq : (글번호)<br>
        </td>
        <td align="center">-</td>
    </tr>
    <tr>
        <td>숨기기/열기 : (/master/secret.do)</td>
        <td>
            type : READ,<br>
            seq : (글번호)<br>        
        </td>
        <td align="center">-</td>
    </tr>
    <tr>     
        <td>전체 글 조회(관리자) : (/master/list.do)</td>
        <td align="center">-</td>
        <td>
            type : READ,<br>
            list: [<br>
            {<br>
                seq : (글번호)<br>
                open : true / false, <br>
                userId : (닉네임), <br>
                title : (글제목), <br>
                content : (글내용), <br>
                crt_time : (작성시간), <br>
            }, 
            {<br>
                seq : (글번호)<br>
                open : true / false, <br>
                userId : (닉네임), <br>
                title : (글제목), <br>
                content : (글내용), <br>
                crt_time : (작성시간), <br>
            }...]<br>
        </td>
    </tr>
    <tr>
        <td>닉네임 검색 : (/master/search.do)</td>
        <td>
            type : READ,<br>
            userId : (닉네임)<br>        
        </td>
        <td>
            type : READ, <br>
            list: [<br>
            {<br>
                seq : (글번호)<br>
                open : true / false, <br>
                userId : (닉네임), <br>
                title : (글제목), <br>
                content : (글내용), <br>
                crt_time : (작성시간), <br>
            }, 
            {<br>
                seq : (글번호)<br>
                open : true / false, <br>
                userId : (닉네임), <br>
                title : (글제목), <br>
                content : (글내용), <br>
                crt_time : (작성시간), <br>
            }...]<br>
        </td>
    </tr>
</tr>
    </tbody>
</table>
