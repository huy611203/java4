<!DOCTYPE html>
<html>
<head>
   
<title>Home</title>
 <style>
       /* Định dạng cho phần tiêu đề */
header {
  background-color: #333;
  color: white;
  padding: 20px;
}

/* Định dạng cho danh sách sản phẩm */
.product-list {
  display: flex;
  flex-wrap: wrap;
}

/* Định dạng cho từng sản phẩm */
.product {
  width: 200px;
  margin: 10px;
  text-align: center;
}

/* Định dạng cho hình ảnh sản phẩm */
.product img {
  width: 100%;
}

/* Định dạng cho tên sản phẩm */
.product h2 {
  font-size: 18px;
  margin: 10px 0;
}

/* Định dạng cho giá sản phẩm */
.product p {
  color: #f60;
}
    </style>
</head>
<body>
<div class="title">Online Shopping Mall</div>
<div class="logo">Logo</div>
 <div class="container row">
 
       <div class="productItem">
       <jsp:include page="item.jsp">
       <jsp:param value="San Pham 1" name="name"/>
       <jsp:param value="sp1.png" name="image"/>
       </jsp:include>
       </div>
       
              <jsp:include page="item.jsp">
       <jsp:param value="San Pham 2" name="name"/>
       <jsp:param value="sp2.png" name="image"/>
       </jsp:include>
       </div>
       
              <jsp:include page="item.jsp">
       <jsp:param value="San Pham 3" name="name"/>
       <jsp:param value="sp3.png" name="image"/>
       </jsp:include>
       </div>
 
 
 </div>

</body>
</html>