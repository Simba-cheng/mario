<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                ×
            </button>
            <h4 class="modal-title" id="myModalLabel">
                API接口信息
            </h4>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">API编号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_APINumber_id" name="update_APINumber_name" value=""  placeholder="例如：mario_api_001">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">API名称</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_APIInterName_id" name="update_APIInterName_name" value=""  placeholder="例如：查询所有人员信息">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">包.类.方法名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_package_class_method_id" name="update_package_class_method_name" placeholder="例如：org.springframework.web.context.ContextLoader">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">API URL</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_api_url_id" name="update_api_url_name" placeholder="例如：http://localhost:8848/showHome.do">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">API请求方式</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_api_method_id" name="update_api_method_name" placeholder="POST、GET、DELETE、PUT...">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">调用终端</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_terminal_id" name="update_terminal_name" placeholder="wap、app、pc...">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">开发</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_coderName_id" name="update_coderName_name" placeholder="coder name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">产品</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_product_id" name="update_product_name" placeholder="">
                    </div>
                </div>
                <#--默认隐藏-->
                <div class="form-group" style="display: none">
                    <label for="lastname" class="col-sm-3 control-label">API-ID内部编号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="update_api_id" name="update_api_id_name" placeholder="">
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
            </button>
            <button type="button" id="btn_update_api_info_submit" class="btn btn-primary" data-dismiss="modal">
                <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>确定
            </button>
        </div>
    </div>
</div>
