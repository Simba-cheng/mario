<#--API列表展示区域-->
<div class="apiListShowRegion" id="apiListShowRegion">

<#--API列表组-->
    <ul class="list-group">
        <a href="#" class="list-group-item active">
            <span class="http_method_path" http_method_post="post">API-1</span>
        </a>
        <a href="#" class="list-group-item list-group-item-success">API-2</a>
        <a href="#" class="list-group-item list-group-item-info">API-3</a>
        <a href="#" class="list-group-item list-group-item-warning">API-4</a>
        <a href="#" class="list-group-item list-group-item-danger">API-5</a>
        <a href="#" class="list-group-item list-group-item-danger">API-6</a>
        <a href="#" class="list-group-item list-group-item-danger">API-7</a>
        <a href="#" class="list-group-item list-group-item-danger">API-8</a>
        <a href="#" class="list-group-item list-group-item-danger">API-9</a>
        <a href="#" class="list-group-item list-group-item-danger">API-10</a>
        <a href="#" class="list-group-item list-group-item-danger">API-11</a>
        <a href="#" class="list-group-item list-group-item-danger">API-12</a>
        <a href="#" class="list-group-item list-group-item-danger">API-13</a>
        <a href="#" class="list-group-item list-group-item-danger">API-14</a>
        <a href="#" class="list-group-item list-group-item-danger">API-15</a>
        <a href="#" class="list-group-item list-group-item-danger">API-16</a>
        <a href="#" class="list-group-item list-group-item-danger">API-17</a>
    </ul>

</div>

<#--API中数据展示-->
<div class="apiDataShowRegion" id="apiDataShowRegion">

    <div class="inPutParamInfoBut">
        <button type="button" class="btn btn-warning btn-sm btn-block" id="inPutParamInfo">入参</button>
    </div>
    <div class="outParamInfoBut">
        <button type="button" class="btn btn-primary btn-sm btn-block" id="outParamInfo">出参</button>
    </div>
    <div class="updateParamBut">
        <button type="button" class="btn btn-danger btn-sm btn-block" id="updateParam">确定修改</button>
    </div>
    <div class="amplificationEditorBut">
        <button type="button" class="btn btn-success btn-sm btn-block" id="amplificationEditorButton">编辑器放大</button>
    </div>

<#--页面编辑器绑定元素-->
    <div id="paramContainer"></div>
</div>

<#--API接口其他相关信息-->
<div class="apiInfoShowRegion" id="apiInfoShowRegion">
    <#include "candle.html">
</div>
