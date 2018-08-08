<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>


<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8"/>
    <title>数据报表平台</title>
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap-table.min.css"/>
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap-theme.css"/>
    <!--
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.css" />
    -->
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/select2.css"/>
    <link rel="stylesheet" href="${ctxStatic}/css/ireport.css"/>
    <script type="text/javascript" src="${ctxStatic}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/bootstrap-table.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/ichart.latest.min.js"></script>
    <!--
    <script type="text/javascript" src="js/bootstrap-select.js"></script>
    -->
    <script type="text/javascript" src="${ctxStatic}/js/select2.js"></script>
    <%--<script type="text/javascript" src="${ctxStatic}/js/ireport.js"></script>--%>
</head>
<body>
<!--
<div class="navbar navbar-duomi navbar-static-top" role="navigation">
 <div class="container-fluid">
  <div class="navbar-header">
   <a class="navbar-brand" href="javascript:void(0)" id="logo">资源数据报表平台</a>
  </div>
 </div>
</div>
-->
<!-- 顶端导航 -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">数据报表平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
                 <form class="navbar-form navbar-right" action="${ctx}/logout">
                   <%--<div class="form-group">--%>
                     <%--<input type="text" placeholder="Email" class="form-control">--%>
                   <%--</div>--%>
                   <%--<div class="form-group">--%>
                     <%--<input type="password" placeholder="Password" class="form-control">--%>
                   <%--</div>--%>
                   <%--<button type="submit" class="btn btn-success">Sign in</button>--%>
                   <button type="submit" class="btn btn-success">logout</button>
                 </form>
        </div>
        <!--/.navbar-collapse -->
    </div>
</nav>
<!-- 顶端导航 -->
<div class="container-fluid" style="margin-top:50px;">
    <div class="row">
        <!-- 左侧nav -->
        <div style="width:21%; border-right:solid 1px rgb(134, 174, 203);; height:800px;">
            <div style="margin-top:30px;">
                <!-- 一级分类管理 -->
                <div class="btn-group">
                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown"
                            aria-expanded="false">一级分类管理 <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a id="link_add_classify" href="javascript:;">增加</a></li>
                        <li><a id="link_delete_classify" href="javascript:;">删除</a></li>
                        <li><a id="link_modify_classify" href="javascript:;">修改</a></li>
                    </ul>
                </div>
                <!-- 一级分类管理 end-->
                <!-- 二级分类管理 -->
                <div class="btn-group">
                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown"
                            aria-expanded="false">二级分类管理 <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a id="link_add_classify_children" href="javascript:;">增加</a></li>
                        <li><a id="link_delete_classify_children" href="javascript:;">删除</a></li>
                        <li><a id="link_modify_classify_children" href="javascript:;">修改</a></li>
                    </ul>
                </div>
                <!-- 二级分类管理 end-->
                <h4><select id="classify_filter" class="populate"
                            style="width: 100%; display: none; margin-top:20px;height:800px"> </select></h4>
                <div id="report_list" class="container-fluid">

                </div>
            </div>
            <!-- 增加企业报表按钮 -->
            <div style="margin-top:30px;">
                <button type="button" onclick="genGrap()" class="btn btn-info dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">企业月度销售报表
                </button>
            </div>
        </div>
        <!-- 左侧nav end -->
        <div class="col-md-10" style="width:79%">
            <div id="dataTable" style="margin-top: 10%;display: none;">
                <button style="margin-top: -5%;margin-left: 10%;" onclick="$('.iframe').toggle();"
                        class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">视图转换
                </button>
                <!-- <table id="table-javascript" data-height="299" data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1">
                </table> -->
                <iframe style="display: none;" id="grapReport" width="100%" height="88%" class="iframe"></iframe>
                <iframe id="grapReportText" width="100%" height="88%" class="iframe"></iframe>
            </div>
            <!--
            <div id="canvasDiv">
             <canvas tyle="width: 800px; height: 400px;" width="800" height="400">
              <p>Your browser does not support the canvas element</p>
             </canvas>
            </div>
            -->
        </div>
        <div class="col-md-10" style="width:79%">
            <div id="dataTable" style="margin-top: 10%;display: none;">
                <button style="margin-top: -5%;margin-left: 10%;" onclick="$('.iframe').toggle();"
                        class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">视图转换
                </button>
                <!-- <table id="table-javascript" data-height="299" data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1">
                </table> -->
                <iframe style="display: none;" id="grapReport" width="100%" height="88%" class="iframe"></iframe>
                <iframe id="grapReportText" width="100%" height="88%" class="iframe"></iframe>
            </div>
        </div>
        <script>
            function genGrap() {
                $('#dataTable').show();
                $('#grapReport').attr('src', '${ctx}/jasper/genView')
                $('#grapReportText').attr('src', '${ctx}/jasper/genText')
            }
        </script>
    </div>
</div>
<!-- 模式对话框 -->
<!-- 添加一级菜单 -->
<div class="modal fade" id="modal_add_classify" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"><i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加一级报表分类
                </h4>
            </div>
            <div class="modal-body">
                <div class="classify_msg"></div>
                <div class="input-group col-md-offset-2" style="margin-top:10px; width:70%;">
                    <span class="input-group-addon" id="basic-addon1">名称</span>
                    <input id="add_classify_name" type="text" class="form-control ireport_msg" placeholder="不能为空"
                           aria-describedby="basic-addon1"/>
                </div>
                <div class="input-group col-md-offset-2" style="margin-top:10px; width:70%;">
                    <span class="input-group-addon" id="basic-addon1">简介</span>
                    <textarea id="add_classify_info" class="form-control ireport_msg" placeholder="未填"
                              aria-describedby="basic-addon1" rows="3"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="btn_add_classify" type="button" class="btn btn-primary">添加</button>
            </div>
        </div>
    </div>
</div>
<!-- 添加一级菜单 end -->
<!-- 删除一级报表菜单 -->
<div class="modal fade" id="modal_delete_classify" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"><i class="glyphicon glyphicon-remove"></i>&nbsp;&nbsp;删除一级报表分类
                </h4>
            </div>
            <div class="modal-body">
                <div class="classify_msg"></div>
                <div style="height:300px;">
                    <h4><select id="delete_classify_filter"
                                style="width: 100%; display: none; margin-top:20px;"> </select></h4>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="btn_delete_classify" type="button" class="btn btn-primary">删除</button>
            </div>
        </div>
    </div>
</div>
<!-- 删除一级报表菜单 end -->
<!-- 修改一级报表菜单 -->
<div class="modal fade" id="modal_modify_classify" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"><i class="glyphicon glyphicon-pencil"></i>&nbsp;&nbsp;修改一级报表分类
                </h4>
            </div>
            <div class="modal-body">
                <div class="classify_msg"></div>
                <div>
                    <h4><select id="modify_classify_filter"
                                style="width: 100%; display: none; margin-top:20px;"> </select></h4>
                    <div class="input-group col-md-offset-2" style="margin-top:10px; width:70%;">
                        <span class="input-group-addon" id="basic-addon1">名称</span>
                        <input id="modify_classify_name" type="text" class="form-control ireport_msg" placeholder="不能为空"
                               aria-describedby="basic-addon1"/>
                    </div>
                    <div class="input-group col-md-offset-2" style="margin-top:10px; width:70%;">
                        <span class="input-group-addon" id="basic-addon1">简介</span>
                        <textarea id="modify_classify_info" class="form-control ireport_msg" placeholder="未填"
                                  aria-describedby="basic-addon1" rows="3"></textarea>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="btn_modify_classify" type="button" class="btn btn-primary">修改</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改一级报表菜单 end -->
<!-- 二级菜单的报表的增删改查 -->
<!-- 修改一级报表菜单 -->
<div class="modal fade" id="modal_add_classify_children" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width:99%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel"><i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;增加报表</h4>
            </div>
            <div class="modal-body">
                <div class="classify_msg"></div>
                <h4>
                    <!--设置默认表个数-->
                    <span class="label label-info lable-report">表个数:</span>
                    <select id="table_count">
                        <option value="1">1个</option>
                        <option value="2">2个</option>
                        <option value="3">3个</option>
                        <option value="4">4个</option>
                        <option value="5">5个</option>
                    </select>
                    <!--
                      <button id="add_table" type="button" class="btn btn-primary" >添加表</button>
                      -->

                    &nbsp;&nbsp;
                    <div class="btn-group">
                        <button type="button" class="btn btn-success select_btn">选择</button>
                        <button type="button" class="btn btn-info select_btn">过滤</button>
                        <button type="button" class="btn btn-info select_btn">分组</button>
                        <button type="button" class="btn btn-info select_btn">排序</button>
                    </div>
                    &nbsp;&nbsp;
                    <button id="btn_analyze_sql" type="button" class="btn btn-primary">生成SQL</button>
                    &nbsp;&nbsp;
                    <button id="btn_verify_sql" type="button" class="btn btn-primary">验证SQL</button>
                    &nbsp;&nbsp;
                    <span class="label label-info lable-report">报表类型:</span>&nbsp;<select id="report_type"
                                                                                          style="display: none;width:250px;"></select>
                    <!-- 选择，分组，排序选择按钮 -->
                    &nbsp;&nbsp;
                    <span class="span-report">名称</span>
                    <input id="report_name" type="text" class=" ireport_msg" placeholder="不能为空"
                           aria-describedby="basic-addon1"/>
                    <button id="btn_add_sql" type="button" class="btn btn-primary">添加报表</button>
                </h4>
                <!--用于列出所有的表，一级关联字段的下拉框-->
                <div id="table_list" class="container-fluid fill_items">
                </div> <!--用于列出所有的表，一级关联字段的下拉框 end-->

                <!--列出选择的字段-->
                <h4>&nbsp;&nbsp;<span class="label label-info">选择字段:</span></h4>
                <div id="selected_columns_div" class="container-fluid fill_items">
                </div><!--列出选择的字段 end---->

                <!--列出过滤的字段-->
                <h4>&nbsp;&nbsp;<span class="label label-info">过滤字段:</span></h4>
                <div id="where_columns_div" class="container-fluid fill_items">
                </div><!--列出过滤的字段 end---->

                <!--列出排序的字段-->
                <h4>&nbsp;&nbsp;<span class="label label-info">排序字段:</span></h4>
                <div id="orderby_columns_div" class="container-fluid fill_items">
                </div><!--列出排序的字段 end---->

                <!--用于显示生成的SQL语句框-->
                <div id="sql_div" style="width:100%; margin-top:10px;">
                    <textarea id="sql_text" class="form-control ireport_msg" placeholder="SQL语句"
                              aria-describedby="basic-addon1" rows="8"></textarea>
                </div>
                <!--用于显示生成的SQL语句框 end-->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<div class="col-md-2">
    <div></div>
</div>
<script>
    /**
     * todo 树需要调整 形状不对
     * @param menu
     * @param html
     */
    function extracted(menu, html) {
        // console.log('威斯克->>>>>>>>>>> '+menu.childMenus.length)
        console.log('威斯克->>>>>>>>>>> '+menu.childMenus)
        if (menu.childMenus) {
            // html += '<ul>';
            $('.col-md-2').children().append('<ul>');
            $.each(menu.childMenus, function () {
                var clazz = this.childMenus ? 'icon-minus-sign' : 'icon-leaf';
                // html += '<li>'
                $('.col-md-2').children().append('<li>');
                // if (this.href) $('.col-md-2').children().append('<a href="'+this.href+'">');
                $('.col-md-2').children().append('<a href="'+this.href+'"><span><i class="'+clazz+'"></i>'+this.name+'</span>');
                // if (!this.childMenus) html += '</a>';
                if (this.href) $('.col-md-2').children().append('</a>');
                console.log('威斯克1->>>>>>>>>>> '+this.name)
                extracted(this, $('.col-md-2').children().html());
                // html += '</li>';
                // if (!this.childMenus)
                    $('.col-md-2').children().append('</li>');
                // alert('威斯克------------------>   '+html)
            })
            // html += '</ul>';
            $('.col-md-2').children().append('</ul>');
        }
    }

    $.post('${ctx}/showMenus',function(data){
        // var html = '<ul><li><span><i class="icon-folder-open"></i>'+data.name+'</span>';
        $('.col-md-2').children().html('<ul><li><span><i class="icon-folder-open"></i>'+data.name+'</span>');
        // alert('begin------------------> '+html)
        extracted(data, $('.col-md-2').children().html());
        // html += '</li></ul>';
        $('.col-md-2').children().append('</li></ul>');
        // alert('end------------------> '+html)
        // $('.col-md-2').children().html(html);
    })
</script>
</body>
</html>