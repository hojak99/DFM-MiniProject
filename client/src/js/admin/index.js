
//처음 화면 로딩 데이터 랜더링
$(document).ready(function(){
  $.ajax({
    type: 'get',
    url: '',
    dataType: "application/json",
    success: function(data) {
      if(data){
        for(var item of data){
          $("#list").append(
            <li>
              <p>item.title</p>
              <div>item.content</div>
              <p>
                <span>item.crt_time</span> /
                <span>item.nickname</span>
              </p>
            </li>
          );
        }
        

      }else{

      }
    }
  })
});
