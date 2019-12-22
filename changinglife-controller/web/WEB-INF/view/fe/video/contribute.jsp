<%--
  Created by IntelliJ IDEA.
  User: XJ
  Date: 2019/12/20
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/contribute/upload" enctype="multipart/form-data">
        视频：<input type="file" name="myFile"/><br/>
        视频名称：<input type="text" name="videoName"/><br/>
        视频简介：<input type="text" name = "videoIntroduction"><br/>
        <input type="submit" value="上传视频">
    </form>
</body>
</html>
