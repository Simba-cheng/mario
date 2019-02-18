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
    <p class="ng-copyright">Copyright© 2018-2099 ，CYX_Simba版权所有 苏ICP备000001号 </p>
</div>

<script>
    $('.selectpicker').selectpicker();
</script>

<#--点击右键事件-->
<script>
    // $(document).ready(function () {
    //     //设置路径
    //     require.config({paths: {'vs': '/static/monaco-editor/min/vs'}});
    //
    //     require(['vs/editor/editor.main'], function () {
    //         mario.editor = monaco.editor.create(document.getElementById('paramContainer'), {
    //             value: [
    //                 '{',
    //                 '  "properties": [',
    //                 '    {',
    //                 '      "defaultValue": true,',
    //                 '      "name": "camel.component.jolt.enabled",',
    //                 '      "description": "Enable jolt component",',
    //                 '      "type": "java.lang.Boolean"',
    //                 '    }',
    //                 '  ]',
    //                 '}'
    //             ].join('\n'),
    //             //支持语言
    //             language: 'json',
    //             //背景样式
    //             theme: 'vs-dark',
    //             //编辑器随浏览器窗口自动调整大小
    //             automaticLayout: true,
    //             //编辑器中文字的大小
    //             fontSize: '16'
    //         });
    //
    //         $(".selectpicker-modifyEditorBackGround").change(function (e) {
    //             console.log(e.target.value);
    //             changeTheme(this.selectedIndex);
    //         });
    //     });
    // });

    //切换编辑器背景
    function changeTheme(theme) {
        var newTheme = (theme === 1 ? 'vs-dark' : (theme === 0 ? 'vs' : 'hc-black'));
        monaco.editor.setTheme(newTheme);
    }

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

</script>
</body>
</html>


