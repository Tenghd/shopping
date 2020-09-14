<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	  <script src="../js/shopcar.js"></script>
	   <style type="text/css">
         body{ background-image:url("../image/2.jpg");background-repeat:repeat }
		 
		 span{ font-size:30px; color:red; font-weight:bolder;margin-left:200px }
      .f{ width:150px; height:70px}
	  
	  .d{ text-align:center; word-spacing:20px;width:70%}
      img{ border:none }
	  
      </style>
  </head>
  <body>&nbsp;  
    
	<!-- Title -->
     <img src="../image/zgc_px.jpg" align="middle" class="f"/>
     <span>欢迎访问我的购物网站</span>
     <hr/>
   
   <!--  Menu Bar  -->
   <center>
   <div class="d">
     <a href="/shopping/a/FindByPageAction?currentPage=1&pageSize=2"><img src="../image/index.gif"/></a>
     <a href="/shopping/view/UserManageView.jsp"><img src="../image/reg.gif"/></a>
     <a href="/shopping/view/ShopCarView.jsp"><img src="../image/cart.gif"/></a>
     <a href=""><img src="../image/order.gif"/></a>
     <a href="/shopping/SafeOutAction"><img src="../image/exit.gif"/></a>
   </div> 
  </center>
  
	
     <form action="/shopping/a/deleteAllCartAction" method="post">
  	 <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
  		<tbody id="tbody">
  			<tr bgcolor="lightblue" align="center">
  			    <td><b>&nbsp;</b></td>
  				<td><b>商品编号</b></td>
  				<td><b>商品名称</b></td>
				<td><b>图片</b></td>
  				<td><b>商品单价</b></td>
  				<td><b>数量</b></td>
  				<td><b>总价</b></td>
  				<td><b>删除</b></td>
  			</tr>
			<c:forEach items="${sessionScope.cart }" var="cart">
	  			<tr onmouseover="over(this);" onmouseout="out(this);" align="center">
	  			  <td><input type="checkbox" name="ids" value="${cart.key}"/></td>
	  	          <td>${cart.key }</td>
	  	          <td>${cart.value.product.productName }</td>
			       <td><img src="..${cart.value.product.picpath }"/></td>
	  	           <td>${cart.value.product.price }</td><td>
	  	      	    <input type="button" value="-" onclick="sub(this);"/>
	  	      	    <input type="text" value="${cart.value.num }" size="1" maxlength="1" name="1"/>
	  	      	    <input type="button" value="+" onclick="add(this);"/>
	  	          </td><td>${cart.value.totalPrice }</td>
	  	          <td><a href="/shopping/a/deleteCartAction?id=${cart.value.product.id }" style="text-decoration: none;">删除</a></td>
	  	        </tr>
  	      </c:forEach>
  	      <tr align="center">
  	          <td colspan="7">
  	              <input type="button" value="选中所有行" onclick="selectAll();"/>
  		          <input type="button" value="取消选中" onclick="quxiao();"/>
  		          <input type="submit" value="删除选中的行" />
  	          </td>
  	      </tr>
  		</tbody>
  	</table>
  	<center><p><input type="button" value="提交修改"/></p></center>
  	</form>
  	<center>
  	    <hr/>
  	    <a href="">提交订单</a>
  	</center>
  </body>
</html>