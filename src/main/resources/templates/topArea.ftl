<div class="projectNames">
    <select id="projectNameID" class="selectpicker" title="项目名称" data-live-search="true">
    </select>
</div>

<div class="nav-content" style="line-height:35px;">
    <span class="nav-content-detail">
        <button type="button" id="button_add_project" class="btn btn-primary" onclick="mario.handlerProjectPopUpsGP('01')">添加项目</button>
    </span>
    <span class="nav-content-detail">
        <button type="button" id="button_delete_project" class="btn btn-danger" onclick="mario.handlerProjectPopUpsGP('02')">删除项目</button>
    </span>

    <div class="languageContent">
        <label class="control-label">编辑器语言：</label>
        <select id="languageSelectID" class="selectpicker-languageContent" title="json" data-live-search="true">
            <option>json</option>
            <option>xml</option>
            <option>ini</option>
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
