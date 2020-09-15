<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 테스트</title>
<script
	src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
    crossorigin="anonymous" >
</script>
<script>
$().ready(function() {	// 문서가 다 시작되면...
   $("#btn1").click(function() {
      $.ajax({
         url : '/member/rest/addJson',	// 상대경로
         data : {
            name : '길동이',	// <input type="text" name="name" value="길동이"> -> 나중에는 길동이 대신 getElementByName("name")으로 해서 입력값 받음...
            pwd : '11111'
         },
         dataType : 'json', /*html, text, json, xml, script*/
         method : 'get',	// post로 받을거면 @PostMapping을 써야됨
         success : function(data) {
            $.each( data, function( key, value ) {	// key : index ( Json에서 0, 1, 2, ... ), value : key-value...
                 var tdValue = "";
                  $.each(value, function(k1, v1) {
                      //alert(k1 + ' ' + v1);
                      // TD 에 합치기
                      tdValue += v1 + "   ";
                  });
                  // TR
                  $('#memberList').append("<tr><td>" + tdValue + "</td></tr>");
               })

         },

         error : function(xhr, status, error) {
            alert(xhr.status); // 에러코드(404, 500 등)
            alert(xhr.responseText); // html 포맷의 에러 메시지
            alert(status); // 'error'
            alert(error); // 'Not Found'
         }
      });
   });
});
</script>

</head>
<body>
    <button id="btn1">AJAX Request Test -- 여길 누르세요</button>
    <div>
      <table id="memberList" border = "1"></table>
    </div>
</body>
</html>