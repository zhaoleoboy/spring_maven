<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取图片验证码</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/plugins/jquery/jquery-1.11.1.min.js"></script>
</head>
<body>

	<form action="##" method='post'>
		<div class="form-group">
			<div class="email controls">
				<input type="text" name='"username"' id="username" placeholder="用户名"
					class='form-control' />
			</div>
		</div>
		<div class="form-group">
			<div class="pw controls">
				<input type="password" autocomplete="off" id="pwd" name="pwd"
					placeholder="密码" class='form-control' />
			</div>
		</div>

		<div class="form-group">
			<div class="email controls">
				<input id="validateCode" onblur="checkImg(this.value)"
					name="validateCode" type="text" class="form-control"
					placeholder="输入验证码" />
			</div>
			<span class="y_yzimg"><img id="codeValidateImg"
				onClick="javascript:flushValidateCode();" alt="验证码" /></span>
			<p class="y_change">
				<a href="javascript:flushValidateCode();">换一张</a>
			</p>
		</div>

		<div class="form-group">
			<span class="text-danger"></span>
		</div>

		<div class="submit">
			<div class="remember">
				<input type="checkbox" name="remember" value="1" class='icheck-me'
					data-skin="square" data-color="blue" id="remember"> <label
					for="remember">记住我</label>
			</div>
			<input type="button" value="登录" onclick="javascript:submitForm();"
				class='btn btn-primary'>
		</div>
	</form>

	<script type="text/javascript">
		$(document).ready(function() {
			flushValidateCode();//进入页面就刷新生成验证码
		});

		/* 刷新生成验证码 */
		function flushValidateCode() {
			var validateImgObject = document.getElementById("codeValidateImg");
			var src = "${pageContext.request.contextPath }/user/getSysManageLoginCode.action?time="
					+ new Date();
			validateImgObject.src = src;
		}
		/*校验验证码输入是否正确*/
		function checkImg(code) {
			var url = "${pageContext.request.contextPath}/checkimagecode";
			$.get(url, {
				"validateCode" : code
			}, function(data) {
				if (data == "ok") {
					alert("ok!")
				} else {
					alert("error!")
					flushValidateCode();
				}
			})
		}
		
		/**/
		function submitForm() {
			alert(123);
			var username = $("#username").val();
			var password = $("#pwd").val();
			var vcode = $("#validateCode").val();
			var rememberMe = $('#remember').is(':checked');
			var url = "${pageContext.request.contextPath}/user/ajaxLogin";
			$.post(url, {
				"username" : username,
				"password" : password,
				"vcode" : vcode,
				"rememberMe" : rememberMe
			}, function(result) {
				if (result.status == 200) {
					location.href = "/index";
				} else {
					$("#erro").html(result.message);
				}
			});
		}
	</script>

</body>
</html>