//全局变量

//原始编辑器-中间位置
var editor = "";
//弹窗方法编辑器
var amplificationEditor = "";

//顶部下拉框，当前选择的项目名称
var projectName_own = "";
//当前被点击的API名称
var currentClickApi = "";
//1-入参按钮被点击 2-出参按钮被点击  默认为1
var currentParamType = "1";

//入参、出参
var inputParam = "";
var ouputParam = "";

var mario = {

    init: function () {
        this.initMonaceEditor();
        this.projectSelectHandler();
        this.openEditorPopUps();
        this.handlerProjectGP();
        this.firstSearch();
        this.openApiInterfacePop();
        this.saveApiInterfaceInfo();
        this.monitorApiList();
        this.saveParam();
        this.updateAPIInfo();

        //入参、出参按钮默认不可用
        $("#inPutParamInfo").prop('disabled', true);
        $("#outParamInfo").prop('disabled', true);
        $("#updateParam").prop('disabled', true);
    },

    //初始化原始编辑器和弹窗放大编辑器
    initMonaceEditor: function () {
        $(document).ready(function () {
            //设置路径
            require.config({paths: {'vs': '/static/monaco-editor/min/vs'}});
            require(['vs/editor/editor.main'], function () {
                //初始化原始编辑器
                mario.editor = monaco.editor.create(document.getElementById('paramContainer'), {
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

    //页面打开后，查询所有项目名称，填充到下拉框中
    firstSearch: function () {
        mario.searchProjectName();
    },

    //项目下拉框中节点的点击处理
    projectSelectHandler: function () {
        $("#projectNameID").on('changed.bs.select', function (e) {
            //被点击的项目名称
            projectName_own = e.target.value;
            //根据被点击的项目名称，查询项目下所有的api接口信息
            mario.queryApiListByProjectName();
        })
    },

    //弹窗放大编辑器
    openEditorPopUps: function () {
        $("#amplificationEditorButton").click(function () {
            //填充弹窗中的，顶部文案
            if (currentParamType == "1") {
                $("#editorPopUpsModalLabel").html("入参");
            } else if (currentParamType == "2") {
                $("#editorPopUpsModalLabel").html("出参");
            }
            //显示弹窗
            $("#editorModal").modal();
            //将中间编辑器中的数据，塞到弹窗放大编辑器中
            mario.amplificationEditor.setValue(mario.editor.getValue());
        });
    },

    //新增、删除项目通用弹窗
    handlerProjectPopUpsGP: function (operating) {
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
            }
            //打开通用项目操作弹窗
            mario.openHandlerProjectPopUps();
        }
    },

    //项目通用弹窗
    openHandlerProjectPopUps: function () {
        $("#handlerProjectModalFade").modal();
    },

    //操作项目弹窗-submit通用处理
    handlerProjectGP: function () {
        $("#btn_handlerProject_submit").click(function (e) {
            var typeFlag = $("#btn_handlerProject_submit").attr("typeFlag");
            var projectName = $("#txt_handlerProject_departmentname").val();
            if (!isEmpty(typeFlag)) {
                if ("01" == typeFlag) {
                    // 添加项目
                    mario.saveProjectName(e, projectName);
                } else if ("02" == typeFlag) {
                    // 删除项目
                    mario.deleteProjectName(e, projectName);
                }
            }
        });
    },

    //保存项目名称
    saveProjectName: function (e, projectName) {
        $.ajax({
            type: "post",
            dataType: 'json',
            async: false,
            url: "/addProject.do",
            data: {"projectName": projectName},
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        mario.caveatPop(resultData.copyWriting);
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
            async: false,
            url: "/deletePorject.do",
            data: {"projectName": projectName},
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        mario.caveatPop(resultData.copyWriting);
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

    //查询所有项目名称
    searchProjectName: function () {

        //初始化bootstrap-select
        $('.bs-select').selectpicker({});

        $.ajax({
            type: "get",
            dataType: 'json',
            async: false,
            url: "/searchAllProject.do",
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        var htmlProjectNames = "";
                        var projectNames = resultData.projectNames;
                        for (var i = 0; i < projectNames.length; i++) {
                            var projectName = projectNames[i];
                            htmlProjectNames += '<option>' + projectName + '</option>';
                        }
                        $("#projectNameID").empty();
                        $("#projectNameID").append(htmlProjectNames);

                        $('#projectNameID').selectpicker('refresh');
                        $('#projectNameID').selectpicker('render');
                    } else if (resultData.successFlag === "N") {
                        var errrorInfo = resultData.errorInfo;
                        sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                    }
                } else {
                    sweetAlert("异常信息", "查询所有项目名称失败", "error")
                }
            }
        });
    },

    //弹窗-刷新页面
    caveatPop: function (text) {
        //弹窗提醒
        swal({
                title: "操作成功！",
                text: text,
                type: "success",
                confirmButtonColor: "#8CD4F5",
                confirmButtonText: "确定",
                closeOnConfirm: false
            },
            function () {
                window.location.reload();
            });
    },

    //打开编辑API信息的弹窗
    openApiInterfacePop: function () {
        $("#addNewApiInterfaceBut").click(function () {
            $("#addApiInfoModal").modal();
        });
    },

    //新增API接口
    saveApiInterfaceInfo: function () {
        $("#btn_api_info_submit").click(function () {
            if (isEmpty(projectName_own)) {
                sweetAlert("异常信息", "请先选择顶部下拉框中的项目，或者请新建项目", "error")
                return;
            }
            var data = appendApiInfomation();
            $.ajax({
                type: "post",
                dataType: 'json',
                async: false,
                data: {"data": JSON.stringify(data)},
                url: "/addApi.do",
                success: function (data) {
                    var successFlag = data.successFlag;
                    var resultData = data.resultData;
                    if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                        if (resultData.successFlag === "Y") {
                            var apiInfos = resultData.apiInfos;
                            //新增API接口，添加到列表中。
                            accumulateAPIList(apiInfos);
                            // 新增节点，将API接口信息，填充到最右侧展示框中。
                            fillingApiInfomation(apiInfos[0]);
                            //设置为当前选中API接口
                            currentClickApi = apiInfos[0].apiName;
                            // 清空表单信息
                            clearSaveAPIInfoForm();
                        } else if (resultData.successFlag === "N") {
                            var errrorInfo = resultData.errorInfo;
                            sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                        }
                    } else {
                        sweetAlert("异常信息", "保存API接口信息异常", "error")
                    }
                }
            });
        });
    },

    //监控API列表，查询被点击API接口信息
    monitorApiList: function () {
        $("body").on('click', '.list-group-item', function (e) {
            //某个API被点击，放开按钮,变为可用
            $("#inPutParamInfo").removeAttr("disabled");
            $("#outParamInfo").removeAttr("disabled");
            $("#updateParam").removeAttr("disabled");
            
            //修改样式
            $(this).addClass('list-group-item-click').siblings().removeClass('list-group-item-click');
            
            //清空全局变量中的入参、出参结构数据
            inputParam = "";
            ouputParam = "";
            var apiName = e.target.text;
            currentClickApi = apiName;
            mario.queryApiInfoByApiName(apiName);
        });
    },

    //根据API名称查询信息
    queryApiInfoByApiName: function (apiName) {
        $.ajax({
            type: "post",
            dataType: 'json',
            async: false,
            data: {"apiName": apiName},
            url: "/queryApiInfoByApiName.do",
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        var apiInfo = resultData.apiInfo;
                        // 新增节点，将API接口信息，填充到最右侧展示框中。
                        fillingApiInfomation(apiInfo);
                    } else if (resultData.successFlag === "N") {
                        var errrorInfo = resultData.errorInfo;
                        sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                    }
                } else {
                    sweetAlert("异常信息", "查询API接口信息异常", "error")
                }
            }
        });
    },

    //通过projectName，查询归属所有的API
    queryApiListByProjectName: function () {
        $.ajax({
            type: "post",
            dataType: 'json',
            async: false,
            data: {"projectName": projectName_own},
            url: "/queryAllApiList.do",
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        var apiInfos = resultData.apiInfos;
                        if (!isEmpty(apiInfos)) {
                            if (apiInfos.length > 0) {
                                //循环展示API列表
                                accumulateAPIList(apiInfos);
                            } else {
                                // sweetAlert("异常信息", projectName_own + " 项目中暂时没有API接口", "error");
                                clearAllInfo();
                                clearAPIList();
                            }
                        }
                    } else if (resultData.successFlag === "N") {
                        var errrorInfo = resultData.errorInfo;
                        sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                    }
                } else {
                    sweetAlert("异常信息", "查询API列表信息异常", "error")
                }
            }
        });
    },

    //入参/出参 按钮点击事件
    handlerParamButton: function (paramType) {
        //存入全局变量
        currentParamType = paramType;
        if (paramType == "1") {
            // 入参
            mario.editor.setValue(inputParam);
            // 入参按钮蓝色
            $("#inPutParamInfo").attr("class", "btn btn-info btn-sm btn-block");
            //出参按钮时白色
            $("#outParamInfo").attr("class", "btn btn-default btn-sm btn-block");
        } else if (paramType == "2") {
            // 出参
            mario.editor.setValue(ouputParam);
            // 入参按钮时白色
            $("#inPutParamInfo").attr("class", "btn btn-default btn-sm btn-block");
            //出参按钮蓝色
            $("#outParamInfo").attr("class", "btn btn-info btn-sm btn-block");
        }
    },

    //顶部按钮'保存/修改' 按钮点击事件
    saveParam: function () {
        $("#updateParam").click(function () {
            var data = {};
            data.apiName = currentClickApi;
            data.paramData = mario.editor.getValue();
            data.paramFlag = currentParamType;
            $.ajax({
                type: "post",
                dataType: 'json',
                async: false,
                data: {"data": JSON.stringify(data)},
                url: "/saveParamData.do",
                success: function (data) {
                    var successFlag = data.successFlag;
                    var resultData = data.resultData;
                    if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                        if (resultData.successFlag === "Y") {
                            sweetAlert("操作成功", resultData.copyWriting, "success")
                            //重查一次API信息
                            mario.queryApiInfoByApiName(currentClickApi);
                        } else if (resultData.successFlag === "N") {
                            var errrorInfo = resultData.errorInfo;
                            sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                        }
                    } else {
                        sweetAlert("异常信息", "查询API列表信息异常", "error")
                    }
                }
            });
        });
    },

    //API更新
    openUpdateApiModel: function (e) {

        //被点击的API节点
        var apiName = e[0].text;
        //为空，直接展示空表单
        if (isEmpty(apiName)) {
            $("#updateApiInfoModal").modal();
            return;
        }

        $.ajax({
            type: "post",
            dataType: 'json',
            async: false,
            data: {"apiName": apiName},
            url: "/queryApiInfoByApiName.do",
            success: function (data) {
                var successFlag = data.successFlag;
                var resultData = data.resultData;
                if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                    if (resultData.successFlag === "Y") {
                        var apiInfo = resultData.apiInfo;

                        //1.根据api name查询，将结果反填到表单中
                        $("#update_api_id").val(apiInfo.apiId);
                        $("#update_APINumber_id").val(apiInfo.apiNum);
                        $("#update_APIInterName_id").val(apiInfo.apiName);
                        $("#update_package_class_method_id").val(apiInfo.apiPath);
                        $("#update_api_url_id").val(apiInfo.apiURL);
                        $("#update_api_method_id").val(apiInfo.requestMethod);
                        $("#update_terminal_id").val(apiInfo.terminal);
                        $("#update_coderName_id").val(apiInfo.coder);
                        $("#update_product_id").val(apiInfo.product);

                        //2.展示更新弹窗表单
                        $("#updateApiInfoModal").modal();
                    } else if (resultData.successFlag === "N") {
                        var errrorInfo = resultData.errorInfo;
                        sweetAlert("异常信息", errrorInfo.errorMsg, "error");
                    }
                } else {
                    sweetAlert("异常信息", "查询API接口信息异常", "error")
                    //清空表单
                    clearUpdateAPIInfoModel();
                }
            }
        });
    },

    //更新API信息
    updateAPIInfo: function () {
        $("#btn_update_api_info_submit").click(function () {
            var apiInfoData = getUpdateApiInfoModel();

            $.ajax({
                type: "post",
                dataType: 'json',
                async: false,
                data: {"data": JSON.stringify(apiInfoData)},
                url: "/updateApi.do",
                success: function (data) {
                    var successFlag = data.successFlag;
                    var resultData = data.resultData;
                    if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                        if (resultData.successFlag === "Y") {
                        } else if (resultData.successFlag === "N") {
                            var errrorInfo = resultData.errorInfo;
                            sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                        }
                    } else {
                        sweetAlert("异常信息", "更新API信息异常", "error")
                    }
                }
            });
        });
    },

    //删除API
    deleteApi: function (e) {

        //被点击的API节点
        var apiName = e[0].text;

        swal({
                title: "确定删除吗？",
                text: "你将无法恢复！",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消删除！",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定删除！",
                closeOnConfirm: false
            },
            function () {
                $.ajax({
                    type: "post",
                    dataType: 'json',
                    async: false,
                    data: {"apiName": apiName},
                    url: "/deleteApi.do",
                    success: function (data) {
                        var successFlag = data.successFlag;
                        var resultData = data.resultData;
                        if (!isEmpty(successFlag) && successFlag === "1" && !isEmpty(resultData)) {
                            if (resultData.successFlag === "Y") {
                                sweetAlert("操作成功", resultData.copyWriting, "success")
                                //从页面列表中删除
                                e[0].remove();
                                //清空数据
                                clearAllInfo();
                            } else if (resultData.successFlag === "N") {
                                var errrorInfo = resultData.errorInfo;
                                sweetAlert("异常信息", errrorInfo.errorMsg, "error")
                            }
                        } else {
                            sweetAlert("异常信息", "删除API接口异常", "error")
                        }
                    }
                });
            });
    }
};

//拼接表单中 api接口信息
function appendApiInfomation() {
    var data = {};
    //拼装参数
    var apiNumber = $("#APINumber_id").val();
    var packageClassMethod = $("#package_class_method_id").val();
    var apiUrl = $("#api_url_id").val();
    var apiMethod = $("#api_method_id").val();
    var terminal = $("#terminal_id").val();
    var coderName = $("#coderName_id").val();
    var product = $("#product_id").val();
    var apiName = $("#APIInterName_id").val();
    data.projectName = projectName_own;
    data.apiNum = apiNumber;
    data.apiName = apiName;
    data.apiPath = packageClassMethod;
    data.apiURL = apiUrl;
    data.requestMethod = apiMethod;
    data.terminal = terminal;
    data.coder = coderName;
    data.product = product;
    data.requestParam = "";
    data.responseParam = "";
    return data;
}

//清空 更新API信息弹窗表单
function clearUpdateAPIInfoModel() {
    $("#update_api_id").val("");
    $("#update_APINumber_id").val("");
    $("#update_APIInterName_id").val("");
    $("#update_package_class_method_id").val("");
    $("#update_api_url_id").val("");
    $("#update_api_method_id").val("");
    $("#update_terminal_id").val("");
    $("#update_coderName_id").val("");
    $("#update_product_id").val("");
}

//获取 更新API信息弹窗表单的信息
function getUpdateApiInfoModel() {
    var apiInfoData = {};
    apiInfoData.projectName = projectName_own;
    apiInfoData.apiId = $("#update_api_id").val();
    apiInfoData.apiNum = $("#update_APINumber_id").val();
    apiInfoData.apiName = $("#update_APIInterName_id").val();
    apiInfoData.apiPath = $("#update_package_class_method_id").val();
    apiInfoData.apiURL = $("#update_api_url_id").val();
    apiInfoData.requestMethod = $("#update_api_method_id").val();
    apiInfoData.terminal = $("#update_terminal_id").val();
    apiInfoData.coder = $("#update_coderName_id").val();
    apiInfoData.product = $("#update_product_id").val();
    return apiInfoData;
}

//清空API信息弹窗表单
function clearSaveAPIInfoForm() {
    $("#APINumber_id").val("");
    $("#package_class_method_id").val("");
    $("#api_url_id").val("");
    $("#api_method_id").val("");
    $("#terminal_id").val("");
    $("#coderName_id").val("");
    $("#product_id").val("");
    $("#APIInterName_id").val("");
}

// 填充API信息至展示区域
function fillingApiInfomation(apiInfo) {
    var apiInfomation = '<div class=table-responsive">' +
        '<table class="table text-nowrap">' +
        '<tr>' +
        '<th>项目/应用名称</th>' +
        '<td>' + apiInfo.projectName + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>API编号</th>' +
        '<td>' + apiInfo.apiNum + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>API接口名称</th>' +
        '<td>' + apiInfo.apiName + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>包.类.方法名</th>' +
        '<td>' + apiInfo.apiPath + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>API URL</th>' +
        '<td>' + apiInfo.apiURL + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>API请求方式</th>' +
        '<td>' + apiInfo.requestMethod + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>调用终端</th>' +
        '<td>' + apiInfo.terminal + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>开发人员</th>' +
        '<td>' + apiInfo.coder + '</td>' +
        '</tr>' +
        '<tr>' +
        '<th>产品</th>' +
        '<td>' + apiInfo.product + '</td>' +
        '</tr>' +
        '</tbody>' +
        '</table>' +
        '</div>';

    //入参和出参结构数据，存在全局变量中，默认展示入参
    inputParam = apiInfo.requestParam;
    mario.editor.setValue(inputParam);
    ouputParam = apiInfo.responseParam;
    //手动触发，修改顶部按钮颜色，防止歧义
    mario.handlerParamButton("1");
    //删除原节点
    $("#apiInfoShowRegion").children().remove();
    $("#apiInfoShowRegion").append(apiInfomation);
}

//清空核心区域所有信息
function clearAllInfo() {
    //清空api信息
    var apiInfo = {};
    apiInfo.projectName = "";
    apiInfo.apiNum = "";
    apiInfo.apiName = "";
    apiInfo.apiPath = "";
    apiInfo.apiURL = "";
    apiInfo.requestMethod = "";
    apiInfo.terminal = "";
    apiInfo.coder = "";
    apiInfo.product = "";
    apiInfo.requestParam = "";
    apiInfo.responseParam = "";
    fillingApiInfomation(apiInfo)
    //清空编辑器
    mario.editor.setValue("");
}

function clearAPIList() {
    $(".list-group").children().remove();
}

/**
 * 展示API列表
 *
 * @param apiList
 */
function accumulateAPIList(apiInfos) {
    var child = "";
    for (var i = 0; i < apiInfos.length; i++) {
        var apiInfo = apiInfos[i];
        var requestMethod = apiInfo.requestMethod;
        var clazz = "list-group-item-success";
        if ("POST" == requestMethod) {
            clazz = "list-group-item-info";
        } else if ("GET " == requestMethod) {
            clazz = "list-group-item-warning";
        } else if ("DELETE" == requestMethod) {
            clazz = "list-group-item-danger";
        }
        child += '<a href="#" class="list-group-item ' + clazz + '">' + apiInfo.apiName + '</a>';
    }
    $(".list-group").append(child);
}

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
