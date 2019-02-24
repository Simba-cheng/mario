<div class="modal-dialog" id="addProjectModalDialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="">
                <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title" id="myModalLabel">新增项目名称</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <label for="txt_departmentname">项目名称</label>
                <textarea id="txt_addPro_departmentname" name="content" rows="3" cols="5" placeholder=""></textarea>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
            </button>
            <button type="button" id="btn_addProject_submit" class="btn btn-primary" data-dismiss="modal">
                <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
            </button>
        </div>
    </div>
</div>