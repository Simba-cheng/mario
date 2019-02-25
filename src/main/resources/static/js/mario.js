var editor = "";
var amplificationEditor = "";

var mario = {

    init: function () {
        this.initMonaceEditor();
        this.projectSelectHandler();
        this.openEditorPopUps();
        this.saveProjectName();
        this.openHandlerProjectPopUps();
        this.handlerProjectGP();
    },

    initMonaceEditor: function () {
        $(document).ready(function () {
            //设置路径
            require.config({paths: {'vs': '/static/monaco-editor/min/vs'}});

            require(['vs/editor/editor.main'], function () {
                //初始化中间编辑器
                mario.editor = monaco.editor.create(document.getElementById('paramContainer'), {
                    value: [
                        '{',
                        '  "properties": [',
                        '    {',
                        '      "defaultValue": true,',
                        '      "name": "camel.component.jolt.enabled",',
                        '      "description": "Enable jolt component",',
                        '      "type": "java.lang.Boolean"',
                        '    }',
                        '  ]',
                        '}'
                    ].join('\n'),
                    //支持语言
                    language: 'json',
                    //背景样式
                    theme: 'vs',
                    //编辑器随浏览器窗口自动调整大小
                    automaticLayout: true,
                    //编辑器中文字的大小
                    fontSize: '16'
                });

                //初始化弹窗放大编辑器
                mario.amplificationEditor = monaco.editor.create(document.getElementById('amplificationEditor'), {
                    //支持语言
                    language: 'json',
                    //背景样式
                    theme: 'vs',
                    //编辑器随浏览器窗口自动调整大小
                    automaticLayout: true,
                    //编辑器中文字的大小
                    fontSize: '16'
                });

                //编辑器背景样式修改
                $(".selectpicker-modifyEditorBackGround").change(function (e) {
                    mario.changeTheme(this.selectedIndex);
                });

                //修改语言
                try {
                    $(".selectpicker-languageContent").change(function (e) {
                        var name = e.target.value;

                        var data = mario.editor.getValue();
                        var newModel = monaco.editor.createModel(data, name);
                        mario.editor.setModel(newModel);

                        var ampData = mario.amplificationEditor.getValue();
                        var newAmpModel = monaco.editor.createModel(ampData, name);
                        mario.amplificationEditor.setModel(newAmpModel);
                    });
                } catch (e) {
                }

                //弹窗编辑器被修改后，将被修改的内容，copy到原本的编辑器中
                mario.amplificationEditor.onDidChangeModelContent(function () {
                    mario.editor.setValue(mario.amplificationEditor.getValue());
                });
            });
        });
    },

    //切换编辑器背景
    changeTheme: function (theme) {
        var newTheme = (theme === 1 ? 'vs-dark' : (theme === 0 ? 'vs' : 'hc-black'));
        monaco.editor.setTheme(newTheme);
    },

    //项目下拉框点击处理
    projectSelectHandler: function () {
        $("#projectNameID").on('changed.bs.select', function (e) {
            console.log(e);
            console.log(e.target.value);
        })
    },

    //放大编辑器 弹窗
    openEditorPopUps: function () {
        $("#amplificationEditorButton").click(function () {
            $("#editorModal").modal();
            //将中间编辑器中的数据，塞到放大的编辑器中
            mario.amplificationEditor.setValue(mario.editor.getValue());
        });
    },

    //操作项目弹窗-打开弹窗通用处理
    handlerProjectPopUpsGP: function (operating, e) {

        if (!isEmpty(operating)) {
            //赋值
            if ("01" == operating) {
                // 添加项目
                $("#handlerProModalLabel").html("新增项目");
                $("#btn_handlerProject_submit").attr("typeFlag", "01")
            } else if ("02" == operating) {
                // 删除项目
                $("#handlerProModalLabel").html("删除项目");
                $("#btn_handlerProject_submit").attr("typeFlag", "02")
            } else if ("03" == operating) {
                // 修改项目
                $("#handlerProModalLabel").html("修改项目");
                $("#btn_handlerProject_submit").attr("typeFlag", "03")
            }
            //打开通用项目操作弹窗
            mario.openHandlerProjectPopUps();
        }
    },

    //新增项目弹窗
    openHandlerProjectPopUps: function () {
        $("#handlerProjectModalFade").modal();
    },

    //操作项目弹窗-submit通用处理
    handlerProjectGP: function () {
        $("#btn_handlerProject_submit").click(function (e) {

            var typeFlag = $("#btn_handlerProject_submit").attr("typeFlag");

            var projectName = $("#txt_handlerProject_departmentname").val();

            if (isEmpty(typeFlag)) {

                if ("01" == typeFlag) {
                    // 添加项目
                    mario.saveProjectName(e, projectName);
                } else if ("02" == typeFlag) {
                    // 删除项目
                    mario.deleteProjectName(e, projectName);
                } else if ("03" == typeFlag) {
                    // 修改项目
                    mario.updateProjectName(e, projectName);
                }
            }

        });
    },

    //保存项目名称
    saveProjectName: function (e, projectName) {
        $.ajax({
            type: "post",
            dataType: 'json',
            async: true,
            url: "/addProject.do",
            data: {"projectName": projectName},
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        sweetAlert("操作成功", resultData.copyWriting, "success")
                    } else if (resultData.successFlag === "N") {
                        var errorInfo = resultData.errorInfo;
                        sweetAlert("异常信息", errorInfo.errorMsg, "error")
                    }
                } else {
                    // 异常
                    sweetAlert("异常信息", "保存项目名称失败，请稍后再试", "error")
                }
                //清空输入框中的内容
                $("#txt_handlerProject_departmentname").val("");
            }
        });
    },

    //删除项目名称
    deleteProjectName: function (e, projectName) {
        $.ajax({
            type: "post",
            dataType: 'json',
            async: true,
            url: "/deletePorject.do",
            data: {"projectName": projectName},
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        sweetAlert("操作成功", resultData.copyWriting, "success")
                    } else if (resultData.successFlag === "N") {
                        var errorInfo = resultData.errorInfo;
                        sweetAlert("异常信息", errorInfo.errorMsg, "error")
                    }
                } else {
                    // 异常
                    sweetAlert("异常信息", "删除项目名称失败，请稍后再试", "error")
                }
                //清空输入框中的内容
                $("#txt_handlerProject_departmentname").val("");
            }
        });
    },

    //更新项目名称
    updateProjectName: function (e, projectName) {


    }
};

function isEmpty(data) {
    var result = false;
    if (data === null || data === undefined || data === '') {
        result = true;
    }
    return result;
}

$(function () {
    mario.init();
});
