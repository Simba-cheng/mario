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
        <button type="button" id="button_refresh_page" class="btn btn-success">删除项目</button>
    </span>
    <span class="nav-content-detail">
        <button type="button" id="button_close_zkServer" class="btn btn-danger">修改项目</button>
    </span>

    <div class="languageContent">
        <label class="control-label">编辑器语言：</label>
        <select id="languageSelectID" class="selectpicker-languageContent" title="json" data-live-search="true">
            <option>json</option>
            <option>xml</option>
        </select>
    </div>

    <div class="modifyEditorBackGround">
        <label class="control-label">编辑器背景：</label>
        <select id="modifyEditorBackGroundID" class="selectpicker-modifyEditorBackGround" title="修改编辑器背景颜色" <#--data-live-search="true"-->>
            <option>Visual Studio</option>
            <option>Visual Studio Dark</option>
            <option>High Contrast Dark</option>
        </select>
    </div>
</div>