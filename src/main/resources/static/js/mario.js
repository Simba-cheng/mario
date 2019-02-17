var mario = {

    init: function () {
        this.initMonaceEditor();
        this.projectSelectHandler();
        this.lanagerSelectHandler();
    },

    initMonaceEditor: function () {
        //设置路径
        require.config({paths: {'vs': '/static/monaco-editor/min/vs'}});

        require(['vs/editor/editor.main'], function () {
            var editor = monaco.editor.create(document.getElementById('paramContainer'), {
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
                theme: 'vs-dark',
                //编辑器随浏览器窗口自动调整大小
                automaticLayout: true,
                //编辑器中文字的大小
                fontSize: '16'
            });
        });
    },

    //项目下拉框点击处理
    projectSelectHandler: function () {

        $("#projectNameID").on('changed.bs.select', function (e) {
            console.log(e);
            console.log(e.target.value);
        })
    },

    //语言下拉框点击处理
    lanagerSelectHandler:function () {

        $("#languageSelectID").on('changed.bs.select', function (e) {
            console.log(e);
            console.log(e.target.value);
        })
    }
};

$(function () {
    mario.init();
});