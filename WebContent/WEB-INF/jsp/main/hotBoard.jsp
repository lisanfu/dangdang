<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
		<!-- <h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<div id="NewProduct_1_o_t" onmouseover="">-->
<div><ul>
	<s:iterator value="books">
	<li >
		<div align="center">
			<a href="http://localhost:8080/dangdang/main/book_view?id=${id }" ><img
					src="${pageContext.request.contextPath}/productImages/${product_pic }" border=0 width="120px" /> </a>
		</div>
		<li class="shuming">
			<a href="http://localhost:8080/dangdang/main/book_view?id=${id }" >${product_name }</a><a href="#" target="_blank"></a>
		</li>
		<li class="price">
			定价：￥${fixed_price }
		</li>
		<li class="price">
			当当价：￥${dang_price }
		</li>
	</li>
	<li class="book_c_xy_long"></li>
	</s:iterator>
</ul>
</div>
	<!-- <h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div> -->