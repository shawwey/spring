<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Freemarker模板</title>
</head>
<body>
${world}
<br/>

<#list persons as person>
    <#if person_index == 2>
        ${person}---红色
    <#else>
        ${person}---绿色
    </#if>
</#list><br/>

<#list map?keys as key>
    ${map[key]}
</#list>
${map.fbb}/${map.lbb}<br/>

<#list maps as map>
    <#list map?keys as key>
        ${map[key]}
    </#list>
</#list>
<#list maps as map>
    ${map.id1}///${map.id2}
</#list>
</body>
</html>