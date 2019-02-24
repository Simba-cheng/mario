<html>
<head>
    <title>Mario - API Manage</title>

    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/sweetalert/css/sweetalert.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/bootstrap-select/css/bootstrap-select.css">
<#--<link rel="stylesheet" type="text/css" href="/static/css/candle.css">-->

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

<#--编辑器 放大 弹窗-->
<div class="modal fade" id="editorModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none">
    <#include "editorPopup.ftl">
</div>

<#--新增项目名称-弹窗-->
<div class="modal fade" id="addProjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none">
    <#include "addProjectPopl.ftl">
</div>

<#--删除项目弹窗-->
<div class="modal fade" id="deleteProjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none">

    <div class="modal-dialog" id="deleteProjectModalDialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">删除项目</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="txt_departmentname">项目名称</label>
                    <textarea id="txt_deletePro_departmentname" name="content" rows="3" cols="5" placeholder=""></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
                </button>
                <button type="button" id="btn_deleteProject_submit" class="btn btn-primary" data-dismiss="modal">
                    <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
                </button>
            </div>
        </div>
    </div>

</div>

<#--动画-->
<#--<#include "candle.html">-->

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


