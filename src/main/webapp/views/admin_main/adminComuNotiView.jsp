<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<style>
</style>
<body>

	<%@ include file="../common/adminMenubar.jsp" %>
	
            <!-- ============================================================== -->
             <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <br><br><br>
                        <h2 class="page-title">커뮤니티 관리</h2>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="form-control mr-sm-2" type="text" placeholder="Search">
                        <button class="btn btn-success" type="submit">Search</button>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Sales Cards  -->
                <!-- ============================================================== -->
                <div class="card">
                    <div class="card-body" style="height:55px">
                        <h5 class="card-title m-b-0" style="vertical-align:45px">공지사항</h5>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="btn-group bb1" style="margin: 0px 0px 150px 0px;">
                            <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">조회방법 선택</button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">전체조회</a>
                                <a class="dropdown-item" href="#">등록일 순 조회</a>
                            </div>
                        </div>
                        <!-- /views/admin_main/comu_noti/adminComuNotiDetail.jsp -->
                        <button onClick="location.href='<%=request.getContextPath()%>/views/admin_main/comu/adminComuNotiDetail.jsp'" class="btn btn-dark" style="float:right" id="btnn">공지사항 등록</button>
                    </div>
                        <div class="table-responsive">
                            <table class="table">
                                <thead class="thead-light">
                                    <tr>
                                        <th width="1">
                                            <label class="customcheckbox m-b-20">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <th scope="col">No.</th>
                                        <th scope="col">제목</th>
                                        <th scope="col">작성자</th>
                                        <th scope="col">작성일</th>
                                        <th scope="col">마지막수정일</th>
                                    </tr>
                                </thead>
                                <tbody class="custom">
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>19</td>
                                        <td>이벤트 참여 방법</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>18</td>
                                        <td>공지사항 읽어주세요</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>17</td>
                                        <td>저작권 관련 공지</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>16</td>
                                        <td>불량회원에 대한 공지</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>15</td>
                                        <td>꼭 지켜주세요</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>14</td>
                                        <td>사이트 이용 공지</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>13</td>
                                        <td>공지</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>12</td>
                                        <td>공지22</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>11</td>
                                        <td>공지333</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr>
                                        <th>
                                            <label class="customcheckbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </th>
                                        <td>10</td>
                                        <td>공지44</td>
                                        <td>admin01</td>
                                        <td>2022.07.26</td>
                                        <td>2022.07.26</td>
                                    </tr>
                                    <tr align="center">
                                        <th colspan="10">
                                            <br>
                                            <div class="btn-group" role="group" aria-label="Basic example">
                                                <button type="button" class="btn btn-outline-secondary"><</button>
                                                <button type="button" class="btn btn-outline-secondary">1</button>
                                                <button type="button" class="btn btn-outline-secondary">2</button>
                                                <button type="button" class="btn btn-outline-secondary">3</button>
                                                <button type="button" class="btn btn-outline-secondary">4</button>
                                                <button type="button" class="btn btn-outline-secondary">5</button>
                                                <button type="button" class="btn btn-outline-secondary">6</button>
                                                <button type="button" class="btn btn-outline-secondary">7</button>
                                                <button type="button" class="btn btn-outline-secondary">8</button>
                                                <button type="button" class="btn btn-outline-secondary">9</button>
                                                <button type="button" class="btn btn-outline-secondary">10</button>
                                                <button type="button" class="btn btn-outline-secondary">></button>
                                              </div>
                                        </th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer text-center">
                
            </footer>
</body>
</html>