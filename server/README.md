<b>모든 key-value는 쌍따옴표(")로 쌓여있다.</b><br>
<b>최상위 key는 type과 data뿐이다.</b> type을 제외한 정보는 data안에 위치한다.<br>

예 ) "type" : "GOOGLE"

<table>
    <tbody>
    <tr>
        <th></th>
        <th align=left>Client->Server</th>
        <th align=left>Server->Client</th>
    </tr>
    <tr>
        <td>글쓰기</td>
        <td align="center">-</td>
        <td>
            type : CREATE,<br>
            seq : (글번호), <br>
            userId : (유저닉네임), <br>
            content : (글내용), <br>
            crt_time : (작성시간) <br>
        </td>
    </tr>
    <tr>
        <td>조회</td>
        <td align="center">-</td>
        <td>
            type : READ<br>
            list: [<br>
            {<br>
                seq : (글번호) ,<br>
                content : (글내용),<br>
                crt_time : (작성시간)<br>
            },<br>
            {<br>
                seq : (글번호) ,<br>
                content : (글내용),<br>
                crt_time : (작성시간)<br>
            }...]<br>
        </td>
    </tr>
    <tr>
        <td>삭제</td>
        <td align="center">-</td>
        <td>
            type : DELTE,<br>
            seq : (글번호)<br>
        </td>
    </tr>
    <tr>
        <td>숨기기/열기</td>
        <td align="center">-</td>
        <td>
            type : READ,<br>
            open : true / false<br>        
        </td>
    </tr>
    <tr>     
        <td>전체조회</td>
        <td align="center">-</td>
        <td>
            type : READ,<br>
            list: [<br>
            {<br>
                seq : (글번호) 
                open : true / false
                userId : (닉네임)
                content : (글내용)
                crt_time : (작성시간)
            },<br>
            {<br>
                seq : (글번호) 
                open : true / false
                userId : (닉네임)
                content : (글내용)
                crt_time : (작성시간)
            }...]<br>
        </td>
    </tr>
</tr>
    </tbody>
</table>
