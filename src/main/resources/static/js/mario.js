var editor = "";
var amplificationEditor = "";

var mario = {

    init: function () {
        this.initMonaceEditor();
        this.projectSelectHandler();
        this.lanagerSelectHandler();
        this.openEditorPopUps();
    },

    initMonaceEditor: function () {

        $(document).ready(function () {
            //设置路径
            require.config({paths: {'vs': '/static/monaco-editor/min/vs'}});

            require(['vs/editor/editor.main'], function () {
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

                //初始化弹窗编辑器
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
                        mario.amplificationEditor.setModel(newModel);
                    });
                } catch (e) {
                }

                //弹窗编辑器被修改后，将被修改的内容，copy到原本的编辑器中
                mario.amplificationEditor.onDidChangeModelContent(function () {
                    console.log(123123123);
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

    //语言下拉框点击处理
    lanagerSelectHandler: function () {

        $("#languageSelectID").on('changed.bs.select', function (e) {
            console.log(e);
            console.log(e.target.value);
        })
    },

    //放大编辑器 弹窗
    openEditorPopUps: function () {
        $("#amplificationEditorButton").click(function () {

            $("#editorModal").modal();

            mario.amplificationEditor.setValue(mario.editor.getValue());
        });
    }
};

$(function () {
    mario.init();
});