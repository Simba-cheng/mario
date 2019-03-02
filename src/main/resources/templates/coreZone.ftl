<#--API列表展示区域-->
<div class="apiListShowRegion" id="apiListShowRegion">

    <div class="addNewApiInterface">
        <button type="button" class="btn btn-success btn-sm btn-block" id="addNewApiInterfaceBut">新增接口</button>
    </div>

<#--API列表组-->
    <ul class="list-group" id="api_list_group">
    </ul>

</div>

<#--API中数据展示-->
<div class="apiDataShowRegion" id="apiDataShowRegion">

    <div class="inPutParamInfoBut">
        <button type="button" class="btn btn-info btn-sm btn-block" id="inPutParamInfo" onclick="mario.handlerParamButton('1')">入参</button>
    </div>
    <div class="outParamInfoBut">
        <button type="button" class="btn btn-default btn-sm btn-block" id="outParamInfo" onclick="mario.handlerParamButton('2')">出参</button>
    </div>
    <div class="updateParamBut">
        <button type="button" class="btn btn-warning btn-sm btn-block" id="updateParam">确定 保存/修改</button>
    </div>
    <div class="amplificationEditorBut">
        <button type="button" class="btn btn-success btn-sm btn-block" id="amplificationEditorButton">编辑器放大</button>
    </div>

<#--页面编辑器绑定元素-->
    <div id="paramContainer"></div>
</div>

<#--API接口其他相关信息-->
<div class="apiInfoShowRegion" id="apiInfoShowRegion">

    <div class=table-responsive">
        <table class="table text-nowrap">
            <tr>
                <th>项目/应用名称</th>
                <td></td>
            </tr>
            <tr>
                <th>API编号</th>
                <td></td>
            </tr>
            <tr>
                <th>API接口名称</th>
                <td></td>
            </tr>
            <tr>
                <th>包.类.方法名</th>
                <td></td>
            </tr>
            <tr>
                <th>API URL</th>
                <td></td>
            </tr>
            <tr>
                <th>API请求方式</th>
                <td></td>
            </tr>
			<tr>
                <th>调用终端</th>
                <td></td>
            </tr>
            <tr>
                <th>开发人员</th>
                <td></td>
            </tr>
            <tr>
                <th>产品</th>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
