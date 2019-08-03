<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
		</script>
<script>
			$(document).ready(function(){
				//ajax请求得到学生信息，并且显示所出
				showStu();
			});
			function showByTag(tag) {
				$("#addStu").css("display","none"); 
				$("#StuTable").css("display","none");
				$("#updateStu").css("display","none");
				$("#detailedGrade").css("display","none");
				$("#lookClazzGrade").css("display","none");
				$("#publishExamination").css("display","none");
				if(tag == "addStu") {
					$("#addStu").css("display","block"); 
				} else if(tag=="StuTable") {
					$("#StuTable").css("display","table");
				} else if(tag=="updateStu") {
					$("#updateStu").css("display","block");
				} else if(tag=="detailedGrade") {
					$("#detailedGrade").css("display","block");
				} else if(tag=="lookClazzGrade") {
					$("#lookClazzGrade").css("display","block");
				} else if(tag=="publishExamination") {
					$("#publishExamination").css("display","block");
				}
			}
			
			//ajax请求得到学生信息，并且显示所出
			function showStu() {
				//得到班级的clazzId
				$.ajax({
					type : "get",//请求的方式
					url : "getStuByClazzId.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						clazzId: ${clazz.id}
					}, 
					success : function(stuList) {
						stuList = JSON.parse(stuList);
						var stuInf = "<tr><td>id</td><td>no</td><td>name</td><td>sex</td><td>pwd</td><td>删除</td><td>修改</td><td>详细信息</td></tr>";
						for(let i=0; i<stuList.length; i++) {
							var stu = stuList[i];
							stuInf += "<tr>";
						    stuInf += "<td>"+stu.id+"</td>";
							stuInf += "<td>"+stu.no+"</td>";
							stuInf += "<td>"+stu.name+"</td>";
							stuInf += "<td>"+stu.sex+"</td>";
							stuInf += "<td>"+stu.pwd+"</td>";
							stuInf += "<td class='a'>删除</td>";
							//updateStu(oldStuId,oldStuNo,oldStuName,oldStuSex,oldStuPwd)
							stuInf += "<td class='a' onclick='updateStu("+stu.id+",\""+stu.no+"\",\""+stu.name+"\",\""+stu.sex+"\",\""+stu.pwd+"\");'>修改</td>";
							stuInf += "<td class='a' onclick='lookStuGrade("+stu.id+",\""+stu.name+"\")'>详细信息</td>";
							stuInf += "</tr>";
						}
						$("#StuTable").html(stuInf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			
			//进入学生详细信息的界面看该学生的所有成绩
			function lookStuGrade(stuId, stuName) {
				showByTag("detailedGrade");//
				$.ajax({
					type : "get",//请求的方式
					url : "getAllGradeByStuId.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						stuId: stuId
					}, 
					success : function(gradeList) {
						gradeList = JSON.parse(gradeList);
						var inf = "<tr><td>学生名</td><td>考试名</td><td>分数</td><td>第几次</td></tr>";
						for(let i=0; i<gradeList.length; i++) {
							var grade = gradeList[i];
							inf += "<tr><td>"+stuName+"</td><td>"+grade.examinationName+"</td><td>"+grade.score+"</td><td>"+grade.times+"</td></tr>";
						}
						$("#stuGradeTable").html(inf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			//进入发布当前班级的一次考试的界面
			function publishExamination() {
				//进入发布考试的界面
				showByTag("publishExamination");
				//查出当前班级是否有正在进行的考试
				$.ajax({
					type : "get",//请求的方式
					url : "getExaminationName.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						clazzId: ${clazz.id}
					}, 
					success : function(examination) {
						var inf;
						if(examination!="no") {//有正在进行的考试
							 inf = "正在对\""+examination+"\"进行考试，不能发布新考试";
							 $("#haveExamination").css("color","red");
							 $("#surePublishExaminationBtn").css("display", "none");	
							 $("#endExaminationBtn").css("display", "block");	
						}else {//没有正在进行的考试
							 inf = "请发布考试";
							 $("#haveExamination").css("color","green");
							 $("#surePublishExaminationBtn").css("display", "block");	
							 $("#endExaminationBtn").css("display", "none");
						}
						$("#haveExamination").html(inf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
				
				//查出所有的题型category
				$.ajax({
					type : "get",//请求的方式
					url : "getAllCategory.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {}, 
					success : function(categoryList) {
						categoryList = JSON.parse(categoryList);
						var str = "请选题型";
						for(let i=0; i<categoryList.length; i++) {
							var category = categoryList[i];
							str += "<input type='checkbox' value='"+category.id+"'>"+category.name;
						}
						$("#categoryDiv").html(str);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			
			<!-- 确定发布考试 -->
				function surePublishExamination() {
					var inputArray = $("#categoryDiv>input:checkbox:checked");
					var categoryIdArray = "{";//"{1,2,3}";
					for(let i=0; i<inputArray.length; i++) {
						var id = inputArray[i].value;
						if(i==inputArray.length-1) {//最后一个
							categoryIdArray += id+"}";
						}else {
							categoryIdArray += id+",";
						}
					}
					$.ajax({
						type : "post",//请求的方式
						url : "publishExamination.do",//请求的url
						dataType : "text",//
						data : {
							clazzId: ${clazz.id},//班级id
							examinationName:$("#examinationName").val(),
							subjectNum:	 $("input[name='subject_num']:checked").val(),
							teacherId: (JSON.parse(localStorage.getItem("teacher"))).id,
							category: categoryIdArray
						}, 
						success : function(msg) {
							if(msg=="yes") {//发布考试成功
								publishExamination()
							}else {
								alert("发布考试失败");							
							}
						},
						error : function() {//当ajax请求失败回调
							alert("ajax请求失败")
						}
					});
				}
			//进入查看当前班级所有学生的所有成绩
			function lookClazzGrade() {
				showByTag("lookClazzGrade");
			}
			//进入增加学生的界面 
			function addStu() {// 
				showByTag("addStu");
			}
			//确定增加学生
			function sureAddStu() {//显示table
				showByTag("StuTable");
			}
			//取消增加学生
			function cancleAddStu() {//显示table
				showByTag("StuTable");
			}
			function searchStuByKey() {
				showByTag("StuTable");
			}
			
			//进入修改学生的界面
			function updateStu(oldStuId,oldStuNo,oldStuName,oldStuSex,oldStuPwd) {
				showByTag("updateStu");
				
				$("#oldStuId").val(oldStuId);
				$("#oldStuName").val(oldStuName);
				$("#oldStuNo").val(oldStuNo);
				$("#oldStuPwd").val(oldStuPwd);
				
				if(oldStuSex=="男") {
					$("input[name='oldStuSex']")[0].setAttribute("checked","checked");
				}else {
					$("input[name='oldStuSex']")[1].setAttribute("checked","checked");
				}
				//获取所有的班级的id和name,然后使用select显示出来
				$.ajax({
					type : "get",//请求的方式
					url : "getAllClazz.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {}, 
					success : function(clazzList) {
						clazzList = JSON.parse(clazzList);
						
						var clazzInf = "";
						for(let i=0; i<clazzList.length; i++) {
							var clazz = clazzList[i];
							clazzInf += "<option checked='true' value='"+clazz.id+"'>"+clazz.name+"</option>";
						}
						$('#clazzSelect').html(clazzInf);
						$("#clazzSelect>option[value='"+${clazz.id}+"']").attr("selected", true);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			
			//确定修改学生
			function sureUpdateStu() {
				//进入显示学生的table
				showByTag("StuTable");
				
				//要修改的数据
				var stuId = $("#oldStuId").val();
				var stuName = $("#oldStuName").val();
				var stuNo = $("#oldStuNo").val();
				var stuPwd = $("#oldStuPwd").val();
				var stuSex = $("input[name='oldStuSex']:checked").val();
				var clazzId = $("#clazzSelect").val();
				
				//访问服务器修改数据
				$.ajax({
					type : "post",//请求的方式
					url : "updateStu.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						id:stuId,
						name:stuName,
						no:stuNo,
						pwd:stuPwd,
						sex:stuSex,
						clazzId:clazzId
					}, 
					success : function(msg) {
						if(msg=="yes") {
							showStu();
						}else {
							alert("修改失败");							
						}
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
				
			}
			
			//取消修改学生
			function cancleUpdateStu() {
				showByTag("StuTable");
			}
		</script>
<script type="text/javascript">
			function endExamination() {
				//访问服务器修改数据
				$.ajax({
					type : "post",//请求的方式
					url : "endExamination.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						clazzId:${clazz.id}
					}, 
					success : function(msg) {
						if(msg=="yes") {//关闭考试成功
							publishExamination();
						}else {
							alert("关闭考试失败");							
						}
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
		</script>

</head>
<body>
	<div id="content">
		<div id="top">${clazz.id},${clazz.name }</div>
		<div id="middle">
			<div id="middle1">
				<input type="text" id="key" />
				<button onclick="searchStuByKey()">搜索学生</button>
				<button onclick="addStu()">增加学生</button>
				<button onclick="lookClazzGrade()">查看本班的成绩</button>
				<button onclick="publishExamination()">发布考试</button>
			</div>

			<div id="middle2">
				<table cellspacing='0' id="StuTable">

				</table>
				<div id="addStu" class="hiddenDiv">
					班名<input type="text" id="name" /><br /> 专业<input type="text"
						id="major" /><br /> <a href="javascript: sureAddStu()">确定</a> <a
						href="javascript: cancleAddStu()">取消</a>
				</div>
				<div id="updateStu" class="hiddenDiv">
					<h1 align="center">修改学生</h1>
					<input type="text" id="oldStuId" value="23" style="display: none" /><br />
					名字:<input type="text" id="oldStuName" value="秦可卿" /><br /> 学号:<input
						type="text" id="oldStuNo" value="007" /><br /> 密码:<input
						type="text" id="oldStuPwd" value="123456" /><br /> 性别:男<input
						type="radio" name="oldStuSex" value="男" /> 女<input type="radio"
						name="oldStuSex" value="女" /><br /> 班级:<select id="clazzSelect">
					</select> <a href="javascript: sureUpdateStu()">确定</a> <a
						href="javascript: cancleUpdateStu()">取消</a>
				</div>
				<div id="detailedGrade" class="hiddenDiv">
					<table id="stuGradeTable">
						<tr>
							<td>学生名</td>
							<td>考试名</td>
							<td>分数</td>
							<td>第几次</td>
						</tr>
						<tr>
							<td>小明</td>
							<td>springboot</td>
							<td>59</td>
							<td>1</td>
						</tr>
						<tr>
							<td>小明</td>
							<td>java基础</td>
							<td>70</td>
							<td>1</td>
						</tr>
						<tr>
							<td>小明</td>
							<td>springboot</td>
							<td>70</td>
							<td>2</td>
						</tr>
					</table>
				</div>
				<div id="lookClazzGrade" class="hiddenDiv">本班所有学生的所有成绩</div>
				<div id="publishExamination" class="hiddenDiv">
					<h1 id="haveExamination">正在对"????"进行考试，不能发布新考试</h1>

					<button id="endExaminationBtn" onclick="endExamination();">结束考试</button>
					<br /> 考试名:<input id="examinationName" type="text"
						value="spring测试" /> <br /> 题数: <input type="radio"
						name="subject_num" value="20" checked="true" />20道题 <input
						type="radio" name="subject_num" value="25" />25道题 <input
						type="radio" name="subject_num" value="40" />40道题<br />

					<div id="categoryDiv"></div>

					<button id="surePublishExaminationBtn"
						onclick="surePublishExamination()">确认发布考试</button>

				</div>
			</div>
		</div>
	</div>
</body>
<script src="base.js" type="text/javascript" charset="utf-8"></script>
<style>
body {
	font-size: 2rem;
}

input[type='radio'] {
	width: 2rem;
	height: 2rem;
}

option {
	font-size: 2rem;
}

.hiddenDiv {
	height: 40rem;
	background: paleturquoise;
	width: 100%;
	display: none;
	font-size: 2rem;
}

.a:hover {
	background: palegoldenrod;
	cursor: pointer
}

tr:hover {
	background: #EEEEEE;
}

tr:first-child {
	background-color: pink;
	font-size: 2rem;
}

th, td {
	text-align: center;
	padding-top: 1rem;
	padding-bottom: 1rem;
	color: yellow;
}

table {
	width: 100%;
	display: table;
}

table, th, td {
	border: 1px solid black;
}

#middle1>* {
	margin: 1rem;
}

#middle1 {
	width: 80rem;
	background: green;
}

#middle {
	width: 80rem;
	min-height: 40rem;
	background: gray;
}

#top {
	width: 80rem;
	height: 10rem;
	background: palegoldenrod;
	font-size: 5rem;
	text-align: center;
	line-height: 10rem;
	//
	文字的行高
}

#content {
	width: 80rem;
	min-height: 50rem;
	background: pink;
	margin: 0 auto;
}
</style>
</html>
