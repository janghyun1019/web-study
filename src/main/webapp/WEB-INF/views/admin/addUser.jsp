<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	<h2>사용자 추가</h2>
	
	<form action="" method="post" id="frm_user">
		사용자 아이디 : <input type="text" name="id" required="required" id="input_id"> <br>
		사용자 이름 : <input type="text" name="name"> <br>
		<button type="submit">등록하기</button>
	</form>
	
	<script>
		let frm_user = document.getElementById('frm_user');
		frm_user.addEventListener('submit', (event)=>{
			event.preventDefault();
			
			//진행 제약 조건(검증)
			let input_id = document.getElementById('input_id').value;
			if(input_id.length < 2){
				alert('아이디 2글자 이상');
				return;
			}
			//진행 제약 조건(검증)
			//진행 제약 조건(검증)
			
			
			//모두 통과 -> submit 진행!
			frm_user.submit();
			
			
		});
// 		let form ....				
// 		form.addeventList('.submit'){				
// 		preventDefault..발생 중지			
					
// 		input input_id .value == ''  value.length < 1 {			
// 			진행못한다~ 		
// 		}			

	
	</script>
</body>
</html> 