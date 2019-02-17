<html>
<head>
    <title>Mario - API Manage</title>

    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/sweetalert/css/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/bootstrap-select/css/bootstrap-select.css">

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

<div class="projectNav">

    <div class="projectNames">
        <select id="projectNameID" class="selectpicker multiple" title="项目名称" data-live-search="true">
            <option>项目-1</option>
            <option>项目-2</option>
        </select>
    </div>

    <div class="nav-content">
        <span class="nav-content-detail">
		    <button type="button" id="button_conn_zkServer" class="btn btn-primary" onclick="">添加项目</button>
        </span>
        <span class="nav-content-detail">
            <button type="button" id="button_refresh_page" class="btn btn-success">功能-2</button>
        </span>
        <span class="nav-content-detail">
		    <button type="button" id="button_close_zkServer" class="btn btn-danger">功能-3</button>
	    </span>
    </div>
</div>

<#--核心区域-->
<div class="apiCore" id="apiCoreID">

<#--API列表展示区域-->
    <div class="apiListShowRegion" id="apiListShowRegion">

    <#--API列表组-->
        <ul class="list-group">
            <a href="#" class="list-group-item active">
                <span class="http_method_path" http_method_post="post">API-1</span>
            </a>
            <a href="#" class="list-group-item list-group-item-success">API-2</a>
            <a href="#" class="list-group-item list-group-item-info">API-3</a>
            <a href="#" class="list-group-item list-group-item-warning">API-4</a>
            <a href="#" class="list-group-item list-group-item-danger">API-5</a>
            <a href="#" class="list-group-item list-group-item-danger">API-6</a>
            <a href="#" class="list-group-item list-group-item-danger">API-7</a>
            <a href="#" class="list-group-item list-group-item-danger">API-8</a>
            <a href="#" class="list-group-item list-group-item-danger">API-9</a>
            <a href="#" class="list-group-item list-group-item-danger">API-10</a>
            <a href="#" class="list-group-item list-group-item-danger">API-11</a>
            <a href="#" class="list-group-item list-group-item-danger">API-12</a>
            <a href="#" class="list-group-item list-group-item-danger">API-13</a>
            <a href="#" class="list-group-item list-group-item-danger">API-14</a>
            <a href="#" class="list-group-item list-group-item-danger">API-15</a>
            <a href="#" class="list-group-item list-group-item-danger">API-16</a>
            <a href="#" class="list-group-item list-group-item-danger">API-17</a>
        </ul>

    </div>

<#--API中数据展示-->
    <div class="apiDataShowRegion" id="apiDataShowRegion">

        <div class="inPutParamInfoBut">
            <button type="button" class="btn btn-warning btn-sm btn-block" id="inPutParamInfo">入参</button>
        </div>
        <div class="outParamInfoBut">
            <button type="button" class="btn btn-primary btn-sm btn-block" id="outParamInfo">出参</button>
        </div>
        <div class="updateParamBut">
            <button type="button" class="btn btn-danger btn-sm btn-block" id="updateParam">确定修改</button>
        </div>

        <div class="languageContent">
            <select id="languageSelectID" class="selectpicker multiple" title="json" data-live-search="true">
                <option>json</option>
                <option>xml</option>
            </select>
        </div>

    <#--页面编辑器绑定元素-->
        <div id="paramContainer"></div>
    </div>

    <div class="apiInfoShowRegion" id="apiInfoShowRegion">

    </div>

</div>

<#--页脚footer-->
<div class="footer">
    <p class="ng-copyright">Copyright© 2018-2099 ，CYX_Simba版权所有 苏ICP备000001号 </p>
</div>

<script>
    $('.selectpicker').selectpicker();
</script>

<#--点击右键事件-->
<script>
    new BootstrapMenu('.list-group-item', {
        fetchElementData: function (e) {
            // console.log("id : " + e[0].id);
            return e;
        },
        actions: [{
            name: 'test1',
            onClick: function (e) {
            }
        }, {
            name: 'test2',
            onClick: function (e) {
            }
        }, {
            name: 'test3',
            onClick: function (e) {
            }
        }]
    });

    function changeTheme(theme) {
        var newTheme = (theme === 1 ? 'vs-dark' : ( theme === 0 ? 'vs' : 'hc-black' ));
        if (editor) {
            editor.updateOptions({ 'theme' : newTheme });
        }
        if (diffEditor) {
            diffEditor.updateOptions({ 'theme': newTheme });
        }
    }

</script>
</body>
</html>


