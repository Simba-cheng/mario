<html>
<head>
    <title>Mario - API Manage</title>

    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/sweetalert/css/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/bootstrap-select/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="/static/css/candle.css">

    <script type="text/javascript" src="/static/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/static/jquery/jquery.cookie.js"></script>

    <script type="text/javascript" src="/static/sweetalert/js/sweetalert.min.js"></script>

    <script type="text/javascript" src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/static/bootstrap/bootstrap-menu/BootstrapMenu.min.js"></script>
    <script type="text/javascript" src="/static/bootstrap/bootstrap-select/js/bootstrap-select.js"></script>

    <script src="/static/monaco-editor/min/vs/loader.js"></script>

    <script type="text/javascript" src="/static/js/mario.js"></script>
</head>

<body>

<#--顶部区域-->
<div class="projectNav">
    <#include "topArea.ftl">
</div>

<#--核心区域-->
<div class="apiCore" id="apiCoreID">
    <#include "coreZone.ftl">
</div>

<#--页脚footer-->
<div class="footer">
    <p class="ng-copyright">
        <span style="margin-left: -250px;">
            Copyright© 2018-2099 ，CYX_Simba版权所有 苏ICP备000001号
        </span>
    </p>
</div>

<script>
    <#--点击右键事件-->
    new BootstrapMenu('.list-group-item', {
        fetchElementData: function (e) {
            // console.log("id : " + e[0].id);
            return e;
        },
        actions: [{
            name: '新增API接口',
            onClick: function (e) {
            }
        }, {
            name: '删除API接口',
            onClick: function (e) {
            }
        }, {
            name: 'test3',
            onClick: function (e) {
            }
        }]
    });

</script>
</body>
</html>


