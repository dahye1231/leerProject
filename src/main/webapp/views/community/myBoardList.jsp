<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.leer.community.model.vo.ComuBoard, com.leer.common.model.vo.PageInfo"%>
    
<%
	/* PageInfo pi = (PageInfo)request.getAttribute("pi");  */
	ArrayList<ComuBoard> list = (ArrayList<ComuBoard>)request.getAttribute("list");
	/* int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();  */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .list-area th {
            font-size: 14px;
            border-top: 1px solid rgba(128, 128, 128, .7);
            border-bottom: 1px solid gray;

        }

        .list-area td {
            font-size: 12px;
            border-bottom: 1px solid rgba(128, 128, 128, .4);

        }

        .list-area {
            width: 100%;
            height: 50px;
            text-align: center;

        }

        .list-area button:hover {
            cursor: pointer;
            color: gray;
        }

        .list-area button {
            border: none;
            background-color: white;
            font-weight: bold;
        }

        .myBoardTitle {
            font-size: 14px;
        }

        .boardDelete{
            border: none;
            background-color: white;
            color: wite;
            font-weight: bold;
            font-size: 14px;
        }
    </style>
</head>
<body>

<%@ include file="../community/communityMain.jsp" %>

<div class="col-lg-8 col-md-7">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6">
                            <div class="blog__item__text2" style="margin-top:20px">
                                <div align="left">
                                    <h4>내가 작성한 게시글 </h4>
                                    <span class="myBoardTitle"><strong><%= loginUser.getNickname() %></strong>님의 게시글 목록</span>
                                </div>
                                <!-- 현재 로그인한 사용자가 관리자일 경우(로그인한회원의아이디가 admin일경우) 보여질 div -->
                                <table class="list-area" align="center">
                                    <thead>
                                        <tr>
                                            <th width="70">번호</th>
                                            <th width="280">제목</th>
                                            <th width="100">작성자</th>
                                            <th width="70">조회수</th>
                                            <th width="100">작성일</th>
                                            <th width="70"><button>전체선택</button></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!--case1. 공지글이 없을 경우-->
                                        <% if(list.isEmpty()) { %>
                                         <tr>
                                            <td colspan="5">존재하는 게시글이 없습니다.</td>
                                        </tr> 
                                        <!--case2. 공지글이 있을 경우-->
                                        <% }else{ %>
                                        	<% for(ComuBoard c : list) { %>
		                                        <tr>
		                                            <td>
		                                                
		                                            </td>
		                                            <td align="left">
		                                                <span><%= c.getTitle() %></span>
		                                            </td>
		                                            <td>
		                                                <span name="nickname"><%= c.getMemNo() %></span>
		                                            </td>
		                                            <td>
		                                                24
		                                            </td>
		                                            <td>
		                                                <span><%= c.getEnrollDate() %></span>
		                                            </td>
		                                            <td><input type="checkbox"></td>
		                                        </tr>
                                    		<% } %>
                                    <% } %>
                                    </tbody>
                                </table>
                                <div class="col-lg-12" style="padding: 0;" align="right">
                                        <button class="boardDelete">삭제하기</button>
                                </div>
                                <div class="product__pagination blog__pagination" align="center">
                   <%--              <% if(currentPage != 1){ %>
                                	<a href="<%=contextPath%>/myBoard.li?memNo=<%=loginUser.getMemNo()%>?cpage=<%=currentPage-1%>">&lt;</a>
                                 <% } %>
                                 
                                 <% for(int p=startPage; p<=endPage; p++) {%>
                                 <% if(p == currentPage){ %>
				            			<a disabled style="opacity:0.7"><%= p %></button>
				            		<% }else { %>
				              			 <a href="<%=contextPath%>/myBoard.li?memNo=<%=loginUser.getMemNo()%>?cpage=<%= p %>"><%= p %></a>
				              		<% } %>
			          		   <% } %>
			         
					         <% if(currentPage != maxPage){ %>
					            <a href="<%=contextPath%>/myBoard.li?memNo=<%=loginUser.getMemNo()%>?cpage=<%=currentPage+1%>" >&gt;</a>
					            <% } %> --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
	 <%@ include file="../community/comuMypage.jsp" %>
	 <%@ include file="../common/footer.jsp" %>
</body>
</html>