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
        <td>글쓰기 (/user/write.do)</td>
        <td align="center">-</td>
        <td>
            seq : (글번호), <br>
            title : (제목)<br>
            user_Id : (닉네임)<br>
            content : (글내용)<br>
            crt_time : (작성시간)<br>
        </td>
    </tr>
    <tr>
        <td>조회(/user/list.do)</td>
        <td align="center">-</td>
        <td>
            list: [<br>
            {<br>
                seq : (글번호) ,<br>
                title : (제목)<br>
                user_Id : (닉네임)<br>
                content : (글내용)<br>
                crt_time : (작성시간)<br>
            },<br>
            {<br>
                seq : (글번호) ,<br>
                title : (제목)<br>
                user_Id : (닉네임)<br>
                content : (글내용)<br>
                crt_time : (작성시간)<br>
            }...]<br>
        </td>
    </tr>
    <tr>
        <td>삭제(/master/delete.do)</td>
        <td align="center">-</td>
        <td>
            seq : (글번호),<br>
            title : (제목),<br>
            user_Id : (닉네임),<br>
            content : (글내용),<br>
            crt_time : (작성시간),<br>
        </td>
    </tr>
    <tr>
        <td>숨기기/열기(/master/secret.do)</td>
        <td align="center">-</td>
        <td>
            open : true / false<br>        
        </td>
    </tr>
    <tr>     
        <td>전체조회(/master/list.do)</td>
        <td align="center">-</td>
        <td>
            list: [<br>
            {<br>
                seq : (글번호),<br>
                open : true / false<br>
                user_Id : (닉네임)<br>
                content : (글내용)<br>
                crt_time : (작성시간)<br>
            },<br>
            {<br>
                seq : (글번호) <br>
                open : true / false<br>
                title : (제목)<br>
                user_Id : (닉네임)<br>
                content : (글내용)<br>
                crt_time : (작성시간)<br>
            }...]<br>
        </td>
    </tr>
</tr>
    </tbody>
</table>
