$(function() {
	var fundList=[];
	var originalArr=[];
	var canShowArr=[];
	var baseURL="/";
	$("#jqGrid").jqGrid({
	    url: baseURL + 'getReqList',
	    datatype: "json",
	    colModel: [			
			{ label: '编号', name: 'id', index: "id", width: 40, key: true },
			{ label: '项目申报部门', name: 'dept', width: 150 },
			{ label: '部门负责人', name: 'deptpeo',  width: 100},
			{ label: '联系方式', name: 'deptpeoinfo',  width: 100},
			{ label: '项目名称', name: 'projectname',  width: 120},
			{ label: '项目联系人	', name: 'projectcontact', width: 100},
			{ label: '联系方式', name: 'projectpeoinfo',  width: 130},
			{ label: '状态', name: 'stepstatus', width: 170,formatter : function(value, options, row) {
				var stepstatusName=null;
				if(value==0){
					stepstatusName="初始状态"
				}
    			if(value==1){
    				stepstatusName="项目负责人审核中"
    			}
    			if(value==2){
    				stepstatusName="项目负责人审核未过"
    			}
    			if(value==3){
    				stepstatusName="项目负责人审核通过"
    			}
    			if(value==4){
    				stepstatusName="业务经办人审核未过 "
    			}
//    			if(value==5){
//    				stepstatusName="业务经办人审核中"
//    			}
    			if(value==6){
    				stepstatusName="业务负责人审核未过 "//
    			}
    			if(value==7){
    				stepstatusName="业务经办人审核通过"
    			}
    			if(value==8){
    				stepstatusName="业务主管部门审核未过"
    			}
    			if(value==9){
    				stepstatusName="业务负责人审核中";//
    			}
    			if(value==11){
    				stepstatusName="业务经办人审核中"//业务负责人审核通过
    			}
    			if(value==13){
    				stepstatusName="业务主管部门审核中"
    			}
    			if(value==15){
    				stepstatusName="业务主管部门审核通过"
    			}
    			if(value==7){
    				stepstatusName="审核结束"
    			}
				return stepstatusName;
            }},
			{ label: '操作', name: 'stepstatus', width: 170,formatter : function(value, options, row) {
					var a1="<a id="+row.id+" stepstatus="+row.stepstatus+"  tag='detail' title='详情'>详情</a>";
					var a2="<a id="+row.id+" stepstatus="+row.stepstatus+"  tag='request'   style='padding-left:5px' title='申报'>申报</a>";
					var a3="<a id="+row.id+" stepstatus="+row.stepstatus+" tag='edit'   style='padding-left:5px' title='编辑'>编辑</a>";
					var a4="<a id="+row.id+" stepstatus="+row.stepstatus+" tag='delete' style='padding-left:5px' title='删除'>删除</a>";
					return a1+a2+a3+a4;
                }
			}
	    ],
	    viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: false, 
        rownumWidth: 30, 
        autowidth:true,
        multiselect: false,
        pager: "#jqGridPager",
	    jsonReader : {
	        root: "page.list",
	        page: "page.currPage",
	        total: "page.totalPage",
	        records: "page.totalCount"
	    },
	    prmNames : {
	        page:"page", 
	        rows:"limit", 
	        order: "order"
	    },
	    gridComplete:function(){
	    	//隐藏grid底部滚动条
	    	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
	    }
	});	 
	var vm=new Vue({
		el: '#rrapp',
		data: {
			message: 'Runoob!',
			stepstatus:null,
			id:null,
			showList: true,
	        people: []  
		},
		methods: {
			reload : function() {
				vm.showList = true;
				var page = $("#jqGrid").jqGrid('getGridParam','page');
				$("#jqGrid").jqGrid('setGridParam',{ 
	                page:page
	            }).trigger("reloadGrid");
			},
			addToSend: function() {
				debugger
				var treeObj = $.fn.zTree.getZTreeObj("tree");
	            var nodes = treeObj.getCheckedNodes(true);
	            var stepstatus=this.stepstatus;
	            var id=parseInt(this.id);
	            debugger
	            if(nodes.length>0&&nodes[0].preid!="-1"){
	            	var ztreDeptno=nodes[0].preid//detpno  
	            	var ztreUserid=nodes[0].userid//userid 
	            	var checkData={}
		            	checkData.ztreDeptno=ztreDeptno
		            	checkData.ztreUserid=ztreUserid
		            	checkData.stepstatus=stepstatus
		            	checkData.id=id//当前选择记录的id
		            	vm.sendCheckData(checkData)
	            }else{
	            	alert("请选择发送人")
	            }
	            debugger
			},
			sendCheckData:function(checkData){
				var url="sendCheckData"
				$.ajax({
					type: "POST",
				    url: baseURL + url,
	                contentType: "application/json",
				    data: JSON.stringify(checkData),
				    success: function(r){
				    	$("#load_user_dept_Modal").modal("hide");
				    	alert(r.msg,function(){
								location.reload() 
				    	})
				    }
				});
			}
		}
	});	
	

	 
var btn = $("#btn_add_zxjh")
btn.on("click", function() {
	showReqModal()
	getAgency()
	getFounds()
});
function showReqModal(){
	$("#add_zxjh_Modal").modal({
		backdrop : "static"
	});
};
function hideReqModal(){
	$("#add_zxjh_Modal").modal("hide");
};

//新增页面关闭后操作
$("#add_zxjh_Modal").on("hidden.bs.modal", function() {//关闭页面后清空数据。
	if($("input[name!=buyway]").length>0){
		$("input[name!=buyway]").val("")
	}
	
	if($("tr[trFlag=trFlag]").length>0){//清除tr,重置 rowspan为3，itemId为0
		$("tr[trFlag=trFlag]").remove()
		itemId=0
		var row = $("#rowspan_change")[0]
		// debugger
		row.rowSpan=3
	}
	
	if($("tr[trid=trid]").length>0){//移除tr,重置rowspan为2
		$("tr[trid=trid]").remove()
		$("#captialTd").attr("rowspan",2)
	}
	
	$("textarea").val("")
	$(".agency_div").remove()
	$("#add_request").show()
	$(".div_sh").hide()
});

//详情页面关闭后操作
$("#detail_zxjh_Modal").on("hidden.bs.modal", function() {//关闭页面后清空数据。
	if($("input[name=detail_buyway]").length>0){
		$("input[name=detail_buyway]").removeAttr("checked")
	}
	
	if($("tr[trid=trid]").length>0){
		$("tr[trid=trid]").remove();
		$("#captialTd_detail").attr({"rowspan":2})
	}
	
	if($("tr[detailFlag=detailFlag]").length>0){//清除tr,重置 rowspan为3，itemId为0
		$("tr[detailFlag=detailFlag]").remove()
		var row = $("#detail_rowspan_change")[0]
		// debugger
		row.rowSpan=3
	}
	$("#agency_div_detail").remove()
});
//修改页面关闭后操作
$("#edit_zxjh_Modal").on("hidden.bs.modal", function() {//关闭页面后清空数据。
	if($("input[name=edit_buyway]").length>0){
		$("input[name=edit_buyway]").removeAttr("checked")
	}
	
	
	if($("tr[trid=trid]").length>0){
		$("tr[trid=trid]").remove();
		$("#captialTd_edit").attr({"rowspan":2})
	}
	
	if($("tr[editFlag=editFlag]").length>0){//清除tr,重置 rowspan为3，itemId为0
		$("tr[editFlag=editFlag]").remove()
		var row = $("#edit_rowspan_change")[0]
		// debugger
		row.rowSpan=3
	}
	$("#agency_div_edit").remove()
	
	
		
});
var itemId=0
function addNum(){
	// 获取rowSpan,初始值为4，每次新增一个栏目，值加1
	var row = $("#rowspan_change")[0]
	// debugger
	row.rowSpan=parseInt(row.rowSpan)+1
	var num=$("table[id=add_table_ids] tr").length
	num=num-3
	console.log(row)
	
	//每行id加1
	itemId+=1;
	return num;
};
function addNumEdit(){
	// 获取rowSpan,初始值为4，每次新增一个栏目，值加1
	var row = $("#edit_rowspan_change")[0]
	// debugger
	row.rowSpan=parseInt(row.rowSpan)+1
	var num=$("table[id=edit_table_ids] tr").length
	num=num-3
	console.log(row)
	
	//每行id加1
	itemId+=1;
	return num;
};

function subNum(){
	// 获取rowSpan,初始值为4，每次删除一个栏目，值减1
	var row = $("#rowspan_change")[0]
	// debugger
	row.rowSpan=parseInt(row.rowSpan)-1
	console.log(row)
	//tr的个数，如果值为15,说明删除的是最后一个元素，此时需要将itemId的值初始化为0
	if(row.rowSpan==3){//2018.02.18 根据rowspan的数量来重置itemId
		itemId=0
	}
};
function subNumEdit(){
	// 获取rowSpan,初始值为4，每次删除一个栏目，值减1
	var row = $("#edit_rowspan_change")[0]
	// debugger
	row.rowSpan=parseInt(row.rowSpan)-1
	console.log(row)
	//tr的个数，如果值为15,说明删除的是最后一个元素，此时需要将itemId的值初始化为0
	if(row.rowSpan==3){
		itemId=0
	}
};

//新增item
$(document).on("click",".id_div_add",function() {
	var cgxmxq_tr=$("table[id=add_table_ids] tr:eq("+addNum()+")")
	createTd(cgxmxq_tr)
});
//新增item
$(document).on("click",".id_div_edit",function() {
	var cgxmxq_tr=$("table[id=edit_table_ids] tr:eq("+addNumEdit()+")")
	debugger
	createTdEdit(cgxmxq_tr)
});

function createTd(cgxmxq_tr){
	var  tr1=$('<tr id='+itemId+'  trFlag="trFlag"></tr>')
	var  td1=$('<td><div class="id_div_sub"><div class="sub_img" title="点击删除栏目" checkedtrid='+itemId+'></div><div class="id_value">'+itemId+'</div></div> </td>')
	var  td2=$('<td><input type="text" id="buyItemName" style="width: 150px" class="easyui-validatebox" required="true" missingMessage="不能为空"></td>')
	var  td3=$('<td><select id="buyItemType"><option value="0">货物</option><option value="1">服务</option><option value="2">工程</option></select></td>')
	
	var td4=$('<td><input type="text" id="buyItemQty" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
	var td5=$('<td><select id="buyItemUnit"><option  value="0">套</option><option value="1">台</option><option value="2">个</option></select></td>')
	var td6=$('<td><input type="text" id="buyItemSum" style="width: 100px" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
	
	var td7=$('<td><select id="isImport"><option value="1">是</option><option value="0">否</option></select></td>')
	var td8=$('<td><select id="isEnergy"><option value="1">是</option><option value="0">否</option></select></td>')
	var td9=$('<td><select id="isEnvironment"><option value="1">是</option><option value="0">否</option></select></td>')
	
	tr1.append(td1)
	.append(td2)
	.append(td3)
	.append(td4)
	.append(td5)
	.append(td6)
	.append(td7)
	.append(td8)
	.append(td9)
	/**
	 * Easyui中使用jquery或js动态添加元素时出现的样式失效的解决方法  
	 * 可以使用$.parser.parse();这个方法进行处理；
	 * $.parser.parse(tr1);
	 */
	$.parser.parse(tr1);//重新渲染样式
	cgxmxq_tr.after(tr1)
};
function createTdEdit(cgxmxq_tr){
	var  tr1=$('<tr id='+itemId+'  editFlag="editFlag"></tr>')
	var  td1=$('<td><div class="id_div_sub"><div class="sub_img_edit" id="sub_img_edit" title="点击删除栏目" checkedtrid='+itemId+'></div><div class="id_value">'+itemId+'</div></div> </td>')
	var  td2=$('<td><input type="text" id="edit_buyItemName" style="width: 150px" class="easyui-validatebox" required="true" missingMessage="不能为空"></td>')
	var  td3=$('<td><select id="edit_buyItemType"><option value="0">货物</option><option value="1">服务</option><option value="2">工程</option></select></td>')
	
	var td4=$('<td><input type="text" id="edit_buyItemQty" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
	var td5=$('<td><select id="edit_buyItemUnit"><option  value="0">套</option><option value="1">台</option><option value="2">个</option></select></td>')
	var td6=$('<td><input type="text" id="edit_buyItemSum" style="width: 100px" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
	
	var td7=$('<td><select id="edit_isImport"><option value="1">是</option><option value="0">否</option></select></td>')
	var td8=$('<td><select id="edit_isEnergy"><option value="1">是</option><option value="0">否</option></select></td>')
	var td9=$('<td><select id="edit_isEnvironment"><option value="1">是</option><option value="0">否</option></select></td>')
	
	tr1.append(td1)
	.append(td2)
	.append(td3)
	.append(td4)
	.append(td5)
	.append(td6)
	.append(td7)
	.append(td8)
	.append(td9)
	/**
	 * Easyui中使用jquery或js动态添加元素时出现的样式失效的解决方法  
	 * 可以使用$.parser.parse();这个方法进行处理；
	 * $.parser.parse(tr1);
	 */
	$.parser.parse(tr1);//重新渲染样式
	cgxmxq_tr.after(tr1)
};


//删除item
$(document).on("click",".sub_img",function(){
	var checkedTr=this;
	var trid=checkedTr.getAttribute("checkedtrid")
	subNum()
	$("tr[id="+trid+"]").remove()
	debugger
});
//删除item 删除采购项目需求
$(document).on("click","#sub_img_edit",function(){
	var checkedTr=this;
	var preid=checkedTr.getAttribute("preid")
	var id=checkedTr.getAttribute("checkedtrid")
	
	if(preid==null){
		subNumEdit()
		$("tr[id="+id+"]").remove()
	}else{
		debugger/////////////////////////////
		confirm("确定要删除该条记录么？",function(){
			$.ajax({
				type: "DELETE",
				url: "/deleteByItemInfoById/"+id+"/"+preid,
				success: function(r){
					subNumEdit()
					$("tr[id="+id+"]").remove()
					debugger;
					alert("删除成功!")
				}
			});
			
		})
	}
});


$(document).on("click","#add_request",function(){
	//var trs=$("tr[id][id!=''] input");//获取 input
	//var select=$("tr[id][id!=''] select");//获取 select
	//$(trs[0]).find("input")  //获取 input
	//$(trs[0]).find("select")
	//获取 input & select  
	var inputsAndSelects=$("tr[trFlag=trFlag]")
	
	var dept=$("#dept").val().trim()//项目申报部门
	var deptpeo=$("#deptpeo").val().trim()//项目申报部门负责人
	var deptpeoinfo=$("#deptpeoinfo").val().trim()//联系方式
	var projectname=$("#projectname").val().trim()//项目名称
	var projectcontact=$("#projectcontact").val().trim()//项目联系人
	var projectpeoinfo=$("#projectpeoinfo").val().trim()//联系方式
	var buyway=$("input[name='buyway']:checked").val()//采购方式
	
	var moneyway=$("#moneyway").val().trim()// 资金来源
	var premoney=$("#premoney").val().trim()//预算项目金额（元)
	var questmoney=$("#questmoney").val().trim()//申请项目金额（元）
	
	var totalmoney=$("#totalmoney").val().trim()//合计金额（元）
	
	var others=$("#others").val().trim()// 其他说明
	
	debugger
	var buyItemInfos=new Array();
	
	for(var i=0;i<inputsAndSelects.length;i++){
		//变为jq对象，在过滤 input 和select
		var inputs=$(inputsAndSelects[i]).find("input")
		var selects=$(inputsAndSelects[i]).find("select")
		debugger
		//var buyItemInfo=new Object()
		var buyItemInfo=new BuyItemInfo(
				parseInt(inputs.context.id),
				inputs[0].value,
				inputs[1].value,
				selects[1].value,
				inputs[2].value,
				selects[0].value,
				
				selects[2].value,
				selects[3].value,
				selects[4].value
		)
		
		buyItemInfos.push(buyItemInfo)
		debugger
	}
	//////////////////////$$$$$$$$$$$$$$$$%%%%%%%%#$#######################
	//资金来源
	var capItems=$("tr[trid='trid']")
	var  capitalsourceInfos=new Array();
	for(var i=0;i<capItems.length;i++){
		//var csid=capItems[i].getAttribute("trnum")//资金来源编号
		//var moneyway= capItems[i].children[0].lastChild.value;  //资金来源
		var csid=$(capItems[i].children[0]).find("select").find("option:selected").attr("idval")//资金来源编号
		var moneyway=$(capItems[i].children[0]).find("select").find("option:selected").val()
		debugger;
		var premoney= capItems[i].children[1].lastChild.value;  //预算金额
		var questmoney= capItems[i].children[2].lastChild.value;//申请项目资金
		var capitalSource=new CapitalSource(csid,moneyway,premoney,questmoney);
		capitalsourceInfos.push(capitalSource)
	}
	debugger
	
	var projectRequestForm=new ProjectRequestForm(
			dept,
			deptpeo,
			deptpeoinfo,
			projectname,
			projectcontact,
			projectpeoinfo,
			buyway,
			capitalsourceInfos,
			buyItemInfos,
			totalmoney,
			others,
			(totalmoney>50000)? 1:0)
	if(premoney>=50000){//有代理机构
		projectRequestForm.agentno=$("#agencySelectId").find("option:selected").val();
	}
	//
	debugger
	if(isOk(buyItemInfos,"#formId")){
	debugger
		
	$.ajax({
			type: "POST",
			url: "/project",
			contentType: "application/json",
			data: JSON.stringify(projectRequestForm),
			success: function(r){
				debugger;
				hideReqModal()
				alert(r.msg,function(){
					location.reload() 
				});
			}
		});
	}
});

$(document).on("click","#edit_request",function(){
	debugger
	var webpreid=$(this).attr("webpreid")
	var inputsAndSelects=$("tr[editFlag=editFlag]")
	
	var dept=$("#edit_dept").val().trim()//项目申报部门
	var deptpeo=$("#edit_deptpeo").val().trim()//项目申报部门负责人
	var deptpeoinfo=$("#edit_deptpeoinfo").val().trim()//联系方式
	var projectname=$("#edit_projectname").val().trim()//项目名称
	var projectcontact=$("#edit_projectcontact").val().trim()//项目联系人
	var projectpeoinfo=$("#edit_projectpeoinfo").val().trim()//联系方式
	var buyway=$("input[name='edit_buyway']:checked").val()//采购方式
	
	//var moneyway=$("#edit_moneyway").val().trim()// 资金来源
	//var premoney=$("#edit_premoney").val().trim()//预算项目金额（元)
	//var questmoney=$("#edit_questmoney").val().trim()//申请项目金额（元）
	
	var totalmoney=$("#edit_totalmoney").val().trim()//合计金额（元）
	
	var others=$("#edit_others").val().trim()// 其他说明
	
	debugger
	var buyItemInfos=new Array();
	
	for(var i=0;i<inputsAndSelects.length;i++){
		//变为jq对象，在过滤 input 和select
		var inputs=$(inputsAndSelects[i]).find("input")
		var selects=$(inputsAndSelects[i]).find("select")
		
		var ids=$(".sub_img_edit")
		
		//ids[0].getAttribute("checkedtrid")
		//ids[0].getAttribute("preid")
		debugger
		//var buyItemInfo=new Object()
		var preid=null
		if(ids[i].attributes.preid==undefined){
			preid=null
		}else{
			 preid=ids[i].attributes.preid.value	
		}
		
		var buyItemInfo=new BuyItemInfo(
				parseInt(inputs.context.id),
				inputs[0].value,
				inputs[1].value,
				selects[1].value,
				inputs[2].value,
				selects[0].value,
				
				selects[2].value,
				selects[3].value,
				selects[4].value
		)
		buyItemInfo.id=ids[i].getAttribute("checkedtrid")
		buyItemInfo.preid=preid
		buyItemInfos.push(buyItemInfo)
		debugger
	}
	
	
	//资金来源
	var capItems=$("tr[trid='trid']")
	var  capitalsourceInfos=new Array();
	for(var i=0;i<capItems.length;i++){
		//var csid=capItems[i].getAttribute("trnum")//资金来源编号
		//var moneyway= capItems[i].children[0].lastChild.value;  //资金来源
		var csid=$(capItems[i].children[0]).find("select").find("option:selected").attr("idval")//资金来源编号
		var moneyway=$(capItems[i].children[0]).find("select").find("option:selected").val()
		debugger;
		var premoney= capItems[i].childNodes[1].lastChild.value;  //预算金额
		var questmoney= capItems[i].children[2].lastChild.value;//申请项目资金
		
		//hasid 如果不为undefined ,说明数据库中存在该数据
		var id=$(capItems[i].children[0]).find("select").find("option:selected").attr("hasid")
		var capitalSource=new CapitalSource(csid,moneyway,premoney,questmoney);
			capitalSource.id=id
		capitalsourceInfos.push(capitalSource)
	}
	
	
	
	var projectRequestForm=new ProjectRequestForm(
			dept,
			deptpeo,
			deptpeoinfo,
			projectname,
			projectcontact,
			projectpeoinfo,
			buyway,
			capitalsourceInfos,
			buyItemInfos,
			totalmoney,
			others,
			(totalmoney>50000)? 1:0)
	
	if(ids[0].getAttribute("preid")==null){
		projectRequestForm.id=webpreid
	}else{
		projectRequestForm.id=ids[0].getAttribute("preid")
	}
	
	debugger
	if(premoney>=50000){//有代理机构
		projectRequestForm.agentno=$("#agency_div_edit").find("option:selected").val();
	}
	//
	debugger
	if(isOk(buyItemInfos,"#edit_formId")){
		$.ajax({
			type: "POST",
			url: "/updatePorject",
			contentType: "application/json",
			data: JSON.stringify(projectRequestForm),
			success: function(r){
				debugger;
				$("#edit_zxjh_Modal").modal('hide')
				$("#agency_div_edit").remove()
				alert(r.msg,function(){
					location.reload();
				})
			}
		});
	}
});






//表单校验
function isOk(buyItemInfos,id){
	var ok=false
	//form 校验。
	var flag=$(id).form('validate')
	debugger
	//采购项目需求不能为空
	if(flag&&buyItemInfos.length>0){
		ok=true
	}
	return ok
};


//预算项目金额  实时事件
$("#edit_premoney").bind("input propertychange",function(){
	var premoney=$(this).val().trim();
	if(premoney>=50000&&$(".agency_div").length==0){//新增
		$(".modal-body").append(getAgentcTrEdit())
	}
	if(premoney<50000&&$(".agency_div").length>0){//移除
		$(".agency_div").remove()
	}
	console.log(agencyData)
});
//生成agentcTr
function getAgentcTr(){
	var  baseSelect=$('<select id="agencySelectId"></select>')
	if(agencyData.length>0){
		for(var i=0;i<agencyData.length;i++){
			agentno=agencyData[i].agentno
			agency=agencyData[i].agency
			baseSelect.append($("<option value="+agentno+">"+agency+"</option>"))
		}
	}
	var divs=$('<div  class="agency_div"><div class="agency_div_left"><b>代理机构</b></div></div>')
	.append($('<div class="agency_div_right"></div>')
			.append(baseSelect))
			return 	divs
};


function getRandomAgency(){
	debugger
	if(agencyData.length>0){//随机代理
		var index=Math.floor((Math.random()*agencyData.length)+1);
		//agency,agentno
		agentno=agencyData[index].agentno
		agency=agencyData[index].agency
	}
};
agencyData=null;
function getAgency(){
	debugger
	if(agencyData==null){
		$.ajax({
			type: "GET",
			url: "/getAgency",
			success: function(r){
				agencyData=r
			}
		});
	}
};

//操作事件
$(document).on("click","a[tag!='']",function(){
	var tag=$(this).attr("tag")
	var id=$(this).attr("id")
	var stepstatus=$(this).attr("stepstatus")
	debugger
	if(tag=="detail"){//详情
		showDetail(id)
		debugger
	}
	if(tag=="request"){//申报
		if(stepstatus==0||stepstatus==2||
		   stepstatus==3||stepstatus==4||
		   stepstatus==6||stepstatus==8||stepstatus==15){
			//requestToLeader(id,stepstatus)
			loadUserDeptModal(id,stepstatus)
		}else{
			alert("当前状态不能申报!")
		}
	}
	if(tag=="edit"){//编辑
		//0:待申报 (将数字设为1):【项目负责人审核中】;项目负责人审核通过(将数值设为3):【业务经办人审核中】,业务经办人审核通过(将数值设为5)
		//                                      项目负责人审核未通过(将数值设为2)                      4:业务经办人审核未通过        
		
		//【业务负责人审核中】业务负责人审核通过7
		//                   业务负责人审核未通过6
		if(stepstatus==0||stepstatus==2||
		   stepstatus==4||stepstatus==6||
		   stepstatus==8){
			editRequestTable(id,stepstatus)
		}else{
			alert("当前状态不能修改!")
		}
	}
	if(tag=="delete"){//删除
		if(stepstatus==0){
			delItem(id,stepstatus)
		}else{
			alert("当前状态下不能删除")
		}
	}
});


function editRequestTable(id,stepstatus){
	$("#edit_zxjh_Modal").modal({backdrop:"static"})
	$("#edit_request").attr({"webpreid":id})
	getAgency()//获取代理机构
	getFounds();
	$.ajax({
		type: "GET",
		url:"/getDetails",
		data:{id:parseInt(id)},
		success:function(r){
			loadEditData(r)
			debugger
		}
	})
	debugger
}
var  tmpArray=[]//  修改时候临时 id的数组
function loadEditData(r){
	$("#edit_bh1").val(r.bh1)//项目申报部门
	$("#edit_bh2").val(r.bh2)//项目申报部门
	$("#edit_dept").val(r.dept)//项目申报部门
	$("#edit_deptpeo").val(r.deptpeo)//项目申报部门负责人
	$("#edit_deptpeoinfo").val(r.deptpeoinfo)//联系方式
	$("#edit_projectname").val(r.projectname)//项目名称
	$("#edit_projectcontact").val(r.projectcontact)//项目联系人
	$("#edit_projectpeoinfo").val(r.projectpeoinfo)//联系方式
	$("input[name=edit_buyway][value="+r.buyway+"]").prop("checked", true); //采购方式
	$("#edit_moneyway").val(r.moneyway)// 资金来源
	$("#edit_premoney").val(r.premoney)//预算项目金额（元)
	$("#edit_questmoney").val(r.questmoney)//申请项目金额（元）
	$("#edit_totalmoney").val(r.totalmoney)//合计金额（元）
	$("#edit_others").val(r.others)// 其他说明
	
	var cList=r.capitalsourceInfos;
	
	function createCaptionl (cList){
		var tdNum=1
		for(var c=0;c<cList.length;c++){
			var captialTd_edit=$("#captialTd_edit")
			rowspan=captialTd_edit.attr("rowspan")
			debugger
			var captialTr=$("#captialTr_edit")
			
			var newTr=$('<tr trnum='+tdNum+'  trid="trid"></tr>')
			var newTd1=$('<td colspan="5" tdNum='+tdNum+'><div class="sub_img_captionl_edit" title="点击删除栏目"   hasid='+cList[c].id+'  trnum='+tdNum+'  csid='+cList[c].csid+'  projectid='+cList[c].preid+'  ></div></td>')

			var newDatalist=$('<select  class="form-control" style="width:400px;float:left;" id="moneyway"></select >')
			var tempArry=[]
			tempArry=fundList
			var option='<option   value='+cList[c].moneyway+' id="inputid"  hasid='+cList[c].id+' idval='+cList[c].id+' >'+cList[c].moneyway+'</option>'
			newDatalist.append(option)
			
			var newTd2=$('<td colspan="2"><input type="text" id="premoney" style="width: 170px" class="easyui-numberbox" required="true"   value= '+cList[c].premoney+' missingMessage="不能为空"></td>')
			var newTd3=$('<td colspan="2"><input type="text" id="questmoney" style="width: 100px" class="easyui-numberbox" required="true" value= '+cList[c].questmoney+' missingMessage="不能为空"></td>')
			
			newTd1.append(newDatalist)//,input1,input2)
			
			newTr.append(newTd1,newTd2,newTd3)
			
			captialTd_edit.attr("rowspan",parseInt(rowspan)+1)
			
			captialTr.after(newTr)
			
			$.parser.parse(newTr);//重新渲染样式
			tdNum++;
		}
		
	}
	createCaptionl (cList);

	
	
	
	
	
	
	var items_tr=$("#edit_items_tr_id")
	var buyItemInfos=r.buyItemInfos

	function  addRowSpanAndToTr(){
		var num=$("table[id=edit_table_ids] tr").length
			num=num-3
		var row = $("#edit_rowspan_change")[0]
		    row.rowSpan=parseInt(row.rowSpan)+1    
		var toTr=$("table[id=edit_table_ids] tr:eq("+num+")")
		return toTr
	}
	
	//设置id ,preid edit_request
	for(var i=0;i<buyItemInfos.length;i++){
		tmpArray[i]=buyItemInfos[i]["byintemid"]
		debugger
		var  tr1=$('<tr id='+buyItemInfos[i]["byintemid"]+'  editFlag="editFlag"></tr>')
		//var  td1=$('<td>'+buyItemInfos[i]["byintemid"]+'</td>')
		
		var  td1=$('<td><div class="id_div_sub"><div class="sub_img_edit" id="sub_img_edit" title="点击删除栏目" checkedtrid='+buyItemInfos[i]["byintemid"]+'  preid='+buyItemInfos[i]["preid"]+'></div><div class="id_value">'+buyItemInfos[i]["byintemid"]+'</div></div> </td>')
		
		var  td2=$('<td><input type="text"  style="width: 150px" class="easyui-validatebox"   value='+buyItemInfos[i]["buyitemname"]+' ></td>')
		
		var td3;
		if(parseInt(buyItemInfos[i]["buyitemtype"])==0){//0.货物 1.服务 2.工程
			td3=$('<td><select    id="edit_buyItemType"><option value="0">货物</option><option value="1">服务</option><option value="2">工程</option></select></td>')
		}
		if(parseInt(buyItemInfos[i]["buyitemtype"])==1){//0.货物 1.服务 2.工程
			td3=$('<td><select    id="edit_buyItemType"><option value="1">服务</option><option value="0">货物</option><option value="2">工程</option></select></td>')
		}
		if(parseInt(buyItemInfos[i]["buyitemtype"])==2){//0.货物 1.服务 2.工程
			td3=$('<td><select    id="edit_buyItemType"><option value="2">工程</option><option value="0">货物</option><option value="1">服务</option></select></td>')
		}
		
		var td4=$('<td><input type="text" id="edit_buyItemQty" class="easyui-numberbox"   value='+buyItemInfos[i]["buyitemqty"]+'></td>')
		var td5;
		if(parseInt(buyItemInfos[i]["buyitemunit"])==0){//0.套 1.台 2.个
			td5=$('<td><select    id="edit_buyitemunit"><option value="0">套</option><option value="1">台</option><option value="2">个</option></select></td>')
		}
		if(parseInt(buyItemInfos[i]["buyitemunit"])==1){//0.套 1.台 2.个
			td5=$('<td><select    id="edit_buyitemunit"><option value="1">台</option><option value="0">套</option><option value="2">个</option></select></td>')
		}
		if(parseInt(buyItemInfos[i]["buyitemunit"])==2){//0.套 1.台 2.个
			td5=$('<td><select    id="edit_buyitemunit"><option value="2">个</option><option value="0">套</option><option value="1">台</option></select></td>')
		}
		
		var td6=$('<td><input type="text" id="edit_buyItemSum" style="width: 100px" class="easyui-numberbox"    value='+buyItemInfos[i]["buyitemsum"]+'></td>')
		
		var td7;
		debugger
		if(parseInt(buyItemInfos[i].isimport)==1){
			td7=$('<td><select  id="isImport"><option value="1">是</option><option value="0">否</option></select></td>')
		}else{
			td7=$('<td><select  id="isImport"><option value="0">否</option><option value="1">是</option></select></td>')
		}
		var td8;
		if(parseInt(buyItemInfos[i].isenergy)==1){
			td8=$('<td><select  id="edit_isEnergy"><option value="1">是</option><option value="0">否</option></select></td>')
		}else{
			td8=$('<td><select  id="edit_isEnergy"><option value="0">否</option><option value="1">是</option></select></td>')
		}
		
		var td9;
		if(parseInt(buyItemInfos[i].isenvironment)==1){
			td9=$('<td><select  id="edit_isEnvironment"><option value="1">是</option><option value="0">否</option></select></td>')
		}else{
			td9=$('<td><select  id="edit_isEnvironment"><option value="0">否</option><option value="1">是</option></select></td>')
		}
		
		
		tr1.append(td1)
		   .append(td2)
		   .append(td3)
		   .append(td4)
		   .append(td5)
		   .append(td6)
		   .append(td7)
		   .append(td8)
		   .append(td9)
     $.parser.parse(tr1);//重新渲染样式
	addRowSpanAndToTr().after(tr1)
	}
	
	if(tmpArray.length>0){
		//设置最大值  
		itemId=Math.max.apply(null, tmpArray)
	}
	
	debugger
	
	
	
	var agentno=r.agentno
	if(agentno!=null){
		$("#edit_table_ids").after(getAgentcTrEdit())
	}
	
}


//生成agentcTr
function getAgentcTrEdit(){
	var  baseSelect=$('<select id="agencySelectIdEdit" ></select>')
	var  firstOption
	var  others=[]
	var  j=0
	if(agencyData.length>0){
		if(typeof(defined)=="undefined"){
			for(var i=0;i<agencyData.length;i++){
				var agentno=agencyData[i].agentno
				var agency=agencyData[i].agency
				baseSelect.append($("<option value="+agentno+">"+agency+"</option>"))
			}
		}else{
			for(var i=0;i<agencyData.length;i++){
				if(agentno==agencyData[i].agentno){
					var agency=agencyData[i].agency
					firstOption=$("<option value="+agentno+">"+agency+"</option>")
					baseSelect.append(firstOption)
				}else{
					var agency=agencyData[i].agency
					others[j]="<option value="+agentno+">"+agency+"</option>"
					j+=1
				}
			}
			for(x in others){
				baseSelect.append(others[x])
			}
		}
	}
	var divs=$('<div  class="agency_div"  id="agency_div_edit"><div class="agency_div_left"><b>代理机构</b></div></div>')
	.append($('<div class="agency_div_right"></div>')
			.append(baseSelect))
			return 	divs
};


var requestToLeader=function(id,stepstatus){
	confirm("填写信息无误,确认申报？",function(){
		$.ajax({
			type: "POST",
			url:"/requestToLeader/"+id+"/"+stepstatus,
			success:function(r){
				alert(r.msg,function(){
					location.reload() 
				});
			}
		})
	})
}
function loadUserDeptModal(id,stepstatus){
	$("#load_user_dept_Modal").modal({backdrop:"static"})
	vm.stepstatus=stepstatus
	vm.id=id
	$.get(baseURL + "getMapResult", function(r){
		debugger
		var zDiv = $("#tree")
	    zDiv = $.fn.zTree.init(zDiv, setting, r);
	    //展开所有节点
		zDiv.expandAll(true);
	});
};
var zNodes =[
	{id:"QCYHKXY", pId:"0", name:"汽车与航空学院", open:true},
	{id:"zs", pId:"QCYHKXY", name:"张三", open:true},
	{id:"ls", pId:"QCYHKXY", name:"李四", open:true},
	{id:"xxx", pId:"0", name:"汽车与航空学院", open:true},
	{id:"zs", pId:"xxx", name:"张三", open:true},
	{id:"ls", pId:"xxx", name:"李四", open:true}
];

var ztree;
var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "deptno",
			pIdKey: "preid",
			rootPId: "-1"
		}
	},
	check: {
        enable: true,
        chkStyle: "radio",  //单选框
        radioType: "all"   //对所有节点设置单选
    }
};


function showDetail(id){
	$("#detail_zxjh_Modal").modal({backdrop:"static"})
	getAgency()//获取代理机构
	getFounds();
	$("div[id=detail_zxjh_Modal] input ").attr("disabled", true);
	$("div[id=detail_zxjh_Modal] textarea ").attr("disabled", true);
	$.ajax({
		type: "GET",
		url:"/getDetails",
		data:{id:parseInt(id)},
		success:function(r){
			loadDetailData(r)
			console.log(r)
			debugger
		}
		
	})
}

function delItem(id,stepstatus){
	confirm("确定要删除选中的记录？",function(){
		$.ajax({
			type: "DELETE",
			url:"/delItemById/"+id+"/"+stepstatus,
			success:function(r){
				alert(r.msg,function(){
					location.reload() 
				});
			}
		})
	})
};


//加载详情数据。
function loadDetailData(r){
	debugger
	$("#detail_bh1").val(r.bh1)//项目申报部门
	$("#detail_bh2").val(r.bh2)//项目申报部门
	$("#detail_dept").val(r.dept)//项目申报部门
	$("#detail_deptpeo").val(r.deptpeo)//项目申报部门负责人
	$("#detail_deptpeoinfo").val(r.deptpeoinfo)//联系方式
	$("#detail_projectname").val(r.projectname)//项目名称
	$("#detail_projectcontact").val(r.projectcontact)//项目联系人
	$("#detail_projectpeoinfo").val(r.projectpeoinfo)//联系方式
	$("input[name=detail_buyway][value="+r.buyway+"]").prop("checked", true); //采购方式
	$("#detail_moneyway").val(r.moneyway)// 资金来源
	$("#detail_premoney").val(r.premoney)//预算项目金额（元)
	$("#detail_questmoney").val(r.questmoney)//申请项目金额（元）
	$("#detail_totalmoney").val(r.totalmoney)//合计金额（元）
	$("#detail_others").val(r.others)// 其他说明
	
	
	
	/****生成自主采购资金来源  start****/
	var cList=r.capitalsourceInfos;
	function createCaptionl (cList){
		var tdNum=1
		for(var c=0;c<cList.length;c++){
			var captialTd_edit=$("#captialTd_detail")
			rowspan=captialTd_edit.attr("rowspan")
			debugger
			var captialTr=$("#captialTr_detail")
			
			var newTr=$('<tr trnum='+tdNum+'  trid="trid"></tr>')
			var newTd1=$('<td colspan="5" tdNum='+tdNum+'></td>')

			var newDatalist=$('<select  class="form-control" style="width:400px;float:left;" id="moneyway" disabled="disabled"></select >')
			var tempArry=[]
			tempArry=fundList
			var option='<option   value='+cList[c].moneyway+' id="inputid" idval='+cList[c].id+' >'+cList[c].moneyway+'</option>'
			newDatalist.append(option)
			
			var newTd2=$('<td colspan="2"><input type="text" id="premoney" style="width: 170px" class="easyui-numberbox" required="true"   value= '+cList[c].premoney+' missingMessage="不能为空"  readonly="readonly"></td>')
			var newTd3=$('<td colspan="2"><input type="text" id="questmoney" style="width: 100px" class="easyui-numberbox" required="true" value= '+cList[c].questmoney+' missingMessage="不能为空" readonly="readonly"></td>')
			
			newTd1.append(newDatalist)//,input1,input2)
			
			newTr.append(newTd1,newTd2,newTd3)
			
			captialTd_edit.attr("rowspan",parseInt(rowspan)+1)
			
			captialTr.after(newTr)
			
			$.parser.parse(newTr);//重新渲染样式
			tdNum++;
		}
		
	}
	createCaptionl (cList);
	/****生成自主采购资金来源  end****/
	
	
	
	
	
	
	var items_tr=$("#detail_items_tr_id")
	var buyItemInfos=r.buyItemInfos

	function  addRowSpanAndToTr(){
		var num=$("table[id=detail_table] tr").length
			num=num-3
		var row = $("#detail_rowspan_change")[0]
		    row.rowSpan=parseInt(row.rowSpan)+1    
		var toTr=$("table[id=detail_table] tr:eq("+num+")")
		return toTr
	}

	for(var i=0;i<buyItemInfos.length;i++){
		var  bc=$(".bmshc")
		var  bm=$("#bmshyj")
		var  zb=$(".zcbshc")
		var  zc=$("#zcbspyj")
			 bc.removeClass("height")
			 bm.text("")
			 zb.removeClass("height")
			 zc.text("")
		
		var  tr1=$('<tr detailFlag="detailFlag"></tr>')
		var  td1=$('<td>'+buyItemInfos[i]["byintemid"]+'</td>')
		
		var buyItemTypeName=""
		if(parseInt(buyItemInfos[i]["buyitemtype"])==0){//0.货物 1.服务 2.工程
			buyItemTypeName="货物"
		}
		if(parseInt(buyItemInfos[i]["buyitemtype"])==1){//0.货物 1.服务 2.工程
			buyItemTypeName="服务"
		}
		if(parseInt(buyItemInfos[i]["buyitemtype"])==2){//0.货物 1.服务 2.工程
			buyItemTypeName="工程"
		}
		var  td2=$('<td><input type="text"  style="width: 150px" class="easyui-validatebox" disabled="disabled"  value='+buyItemInfos[i]["buyitemname"]+' ></td>')
		
		var buyItemUnitName=""
		if(parseInt(buyItemInfos[i]["buyitemunit"])==0){//0.套 1.台 2.个
			buyItemUnitName="套"
		}
		if(parseInt(buyItemInfos[i]["buyitemunit"])==1){//0.套 1.台 2.个
			buyItemUnitName="台"
		}
		if(parseInt(buyItemInfos[i]["buyitemunit"])==2){//0.套 1.台 2.个
			buyItemUnitName="个"
		}
		
		var  td3=$('<td><select  disabled="disabled"  id="buyItemType"><option value="0">'+buyItemTypeName+'</option></select></td>')
		
		var td4=$('<td><input type="text" id="buyItemQty" class="easyui-numberbox" disabled="disabled"  value='+buyItemInfos[i]["buyitemqty"]+'></td>')
		var td5=$('<td><select disabled="disabled"  id="buyItemUnit"><option  value="0">'+buyItemUnitName+'</option></select></td>')
		var td6=$('<td><input type="text" id="buyItemSum" style="width: 100px" class="easyui-numberbox"  disabled="disabled"  value='+buyItemInfos[i]["buyitemsum"]+'></td>')
		var td7=$('<td><select disabled="disabled"  id="isImport"><option value="1">'+((parseInt(buyItemInfos[i].isimport)==1 )? '是':'否')+'</option></select></td>')
		var td8=$('<td><select disabled="disabled" id="isEnergy"><option value="1">'+((parseInt(buyItemInfos[i].isenergy)==1)? '是':'否')+'</option></select></td>')
		var td9=$('<td><select disabled="disabled" id="isEnvironment"><option value="1">'+((parseInt(buyItemInfos[i].isenvironment)==1)? '是':'否')+'</option></select></td>')
		
		tr1.append(td1)
		   .append(td2)
		   .append(td3)
		   .append(td4)
		   .append(td5)
		   .append(td6)
		   .append(td7)
		   .append(td8)
		   .append(td9)
	     $.parser.parse(tr1);//重新渲染样式
		 addRowSpanAndToTr().after(tr1)
	
		 
		 
/*		 <ul class="list-group">
		  <li class="list-group-item">Cras justo odio</li>
		  <li class="list-group-item">Dapibus ac facilisis in</li>
		  <li class="list-group-item">Morbi leo risus</li>
		  <li class="list-group-item">Porta ac consectetur ac</li>
		  <li class="list-group-item">Vestibulum at eros</li>
		</ul>*/
		 var clist=r.clist
		 var num=0
		 var nnm=0
		 if (clist.length > 0) {
				var uL1 = $('<ul class="list-group" ></ul>')
				var uL2 = $('<ul class="list-group" ></ul>')
				for (var i = 0; i < clist.length; i++) {
					var checkby = clist[i].checkby
					var msg = clist[i].msg
					var checkdate = clist[i].checkdate
					if (checkby == 1) {
						uL1.append($(' <li class="list-group-item"></li>').append(msg).append(",").append(checkdate))
						num+=1
					} else {
						nnm+=1
						uL2.append($(' <li class="list-group-item"></li>').append(msg).append(",").append(checkdate))
					}
				}
				
				if(num*42>120){
					bc.css({"height":num*42+"px"})
					bm.css({"height":num*42+"px"})
				}else{
					bc.css({"height":"130px"})
					bm.css({"height":"130px"})
				}
				if(nnm*42>120){
					zb.css({"height":nnm*42+"px"})
					zc.css({"height":nnm*42+"px"})
				}else{
					zb.css({"height":"130px"})
					zc.css({"height":"130px"})
				}
				
				bm.append(uL1)
				zc.append(uL2)

		}else{
			var uL1 = $('<ul class="list-group" ></ul>')
			var uL2 = $('<ul class="list-group" ></ul>')
				if(num*42>120){
					bc.css({"height":num*42+"px"})
					bm.css({"height":num*42+"px"})
				}else{
					bc.css({"height":"130px"})
					bm.css({"height":"130px"})
				}
				if(nnm*42>120){
					zb.css({"height":nnm*42+"px"})
					zc.css({"height":nnm*42+"px"})
				}else{
					zb.css({"height":"130px"})
					zc.css({"height":"130px"})
				}
				bm.append(uL1)
				zc.append(uL2)
		}
	}
	var agentno=r.agentno
	if(agentno!=null){
		$("#detail_table").after(getAgentcTrDetail())
	}
	
	//生成agentcTr
	function getAgentcTrDetail(){
		var  baseSelect=$('<select id="agencySelectId" disabled="disabled"></select>')
		if(agencyData.length>0){
			for(var i=0;i<agencyData.length;i++){
				if(agentno==agencyData[i].agentno){
					var agency=agencyData[i].agency
					baseSelect.append($("<option value="+agentno+">"+agency+"</option>"))
					break
				}
			}
		}
		var divs=$('<div  class="agency_div"  id="agency_div_detail"><div class="agency_div_left"><b>代理机构</b></div></div>')
		.append($('<div class="agency_div_right"></div>')
				.append(baseSelect))
				return 	divs
	};
	
	//去除禁用时候灰色
	var divs=$("#detail_zxjh_modal_div");
		divs.find("input").css({"background-color": "white"});
		divs.find("textarea").css({"background-color": "white"});
		divs.find("select").css({"background-color": "white"});
};




//function init(pn){//页面初始化，加载数据
//	var  tbodyid=$("#tbodyId")
//		 tbodyid.text("")
//    $.ajax({
//        type: "GET",
//        url: "/getReqFormList",
//        data:{pn:pn},
//        success: function(r){
//        	var resultList=r.resultList
//        	if(resultList.length>0){
//        		var bottom_div=$("#bottom_div");
//    			bottom_div.text("");//清空
//    			/**
//    			 * 分页
//    			 */
//    			var pageDiv=$("<div></div>");
//    				pageDiv.attr("id","page");
//    				pageDiv.addClass("page_div");
//    				pageDiv.appendTo(bottom_div);
//    			//每页显示多少条记录	
//    			var pageSize=paginationConf.itemsPerPage;
//    			//总记录数
//    			var totalRecord=parseInt(r.page.total);
//    			//获取总页数
//    			var totalPage = parseInt(r.page.pages)
//    			
//    				//分页
//    				$("#page").paging({
//    					totalPage: totalPage,
//    					totalSize: totalRecord,
//    					pageNo: paginationConf.currentPage,
//    					callback: function(num) {
//    						//获取点击的id
//    						var clickid = jconfirm.lastClicked[0].id;
//    						//查询拦截过滤
//    						if(paginationConf.currentPage<=1&&(clickid=="firstPage"||clickid=="prePage")){
//    							return false;
//    						}else if(paginationConf.currentPage>=totalPage&&(clickid=="nextPage"||clickid=="lastPage")){
//    							return false;
//    						}else{
//    							/*alert(num);*/
//    							paginationConf.currentPage=num;
//    							//alert(totalItems,currentPage);
//    							paginationConf.onChange();
//    						}
//    					}
//    				});
//        		
//        		for(x in resultList){
//        			var baseTrList=$("<tr></tr>")
//        			var td1=$("<td></td>").append(resultList[x].id)
//        			var td2=$("<td></td>").append(resultList[x].dept)
//        			var td3=$("<td></td>").append(resultList[x].deptpeo)
//        			var td4=$("<td></td>").append(resultList[x].deptpeoinfo)
//        			var td5=$("<td></td>").append(resultList[x].projectname)
//        			var td6=$("<td></td>").append(resultList[x].projectcontact)
//        			var td7=$("<td></td>").append(resultList[x].projectpeoinfo)
//        			
//        			
//        			var stepstatus=parseInt(resultList[x].stepstatus)
//        			stepstatusName=""
//        				if(stepstatus==0){
//        					stepstatusName="初始状态"
//        				}
//            			if(stepstatus==1){
//            				stepstatusName="项目负责人审核中"
//            			}
//            			if(stepstatus==2){
//            				stepstatusName="项目负责人审核未通过"
//            			}
//            			if(stepstatus==3){
//            				stepstatusName="项目负责人审核通过"
//            			}
//            			if(stepstatus==4){
//            				stepstatusName="业务负责人审核未通过 "
//            			}
//            			if(stepstatus==5){
//            				stepstatusName="业务负责人审核中"
//            			}
//            			if(stepstatus==6){
//            				stepstatusName="业务经办人审核未通过 "
//            			}
//            			if(stepstatus==7){
//            				stepstatusName="业务负责人审核通过"
//            			}
//            			if(stepstatus==8){
//            				stepstatusName="业务主管部门审核未通过"
//            			}
//            			if(stepstatus==9){
//            				stepstatusName="业务经办人审核中"
//            			}
//            			if(stepstatus==11){
//            				stepstatusName="业务经办人审核通过"
//            			}
//            			if(stepstatus==13){
//            				stepstatusName="业务主管部门审核中"
//            			}
//            			if(stepstatus==15){
//            				stepstatusName="业务主管部门审核通过"
//            			}
//            			if(stepstatus==17){
//            				stepstatusName="结项"
//            			}
//            			
//        			var td8=$("<td></td>").append(stepstatusName)
//        			
//        			
//        			var td9=$("<td></td>").append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='detail'>详情</a>"))					  
//					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='request'   style='padding-left:5px'>申报</a>"))
//					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+" tag='edit'   style='padding-left:5px'>编辑</a>"))
//					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+" tag='delete' style='padding-left:5px'>删除</a>"))
//        								  
//        			baseTrList.append(td1)
//        					  .append(td2)
//        					  .append(td3)
//        					  .append(td4)
//        					  .append(td5)
//        					  .append(td6)
//        					  .append(td7)
//        					  .append(td8)
//        					  .append(td9)
//        					  baseTrList.appendTo(tbodyid)
//        		}
//        	}else{
//        		tbodyid.html("<h4 style='text-algin:center;width:100px;'>暂无数据。</h4>")
//        	}
//        }
//    });
//}
//init(paginationConf.currentPage);
	
	
/**
 * 分页跳转
 */
$(document).on("click","#jumpBtn",function(){
	var totalPage=$(this).attr("totalPage");
	var jump2page= $("#jump2page").val();
	if(isNum(jump2page)){
		totalPage=parseInt(totalPage);
		jump2page=parseInt(jump2page);
		if(jump2page>totalPage||jump2page<1){
			alert("请输入正确的页码!")
			return false;
		}else{
			paginationConf.currentPage=jump2page;
			paginationConf.onChange();
		}
	}else{
		alert("请输入正确的页码!")
		return;
	}
});
	
/**

 * 检查是否为正整数

 */
var isNum=function(inputNum){
	var re=/^\d+$/g;
	if(re.test(inputNum)){
		return true;
	}
	return false;
};
	/**
	 * 新增资金
	 */
	var tdNum=1;
	$(document).on("click","#add_captionl",function(){
		var captialTd=$("#captialTd")
		rowspan=captialTd.attr("rowspan")
		debugger
		var captialTr=$("#captialTr")
		
		var newTr=$('<tr trnum='+tdNum+'  trid="trid"></tr>')
		var newTd1=$('<td colspan="5" tdNum='+tdNum+'><div class="sub_img_captionl" title="点击删除栏目" trnum='+tdNum+' ></div></td>')
		//var newInput=$(' <input list="browsers"   type="text" id="moneyway" style="width: 400px" class="easyui-validatebox" required="true" missingMessage="不能为空">')

/*		var newDatalist=$('<datalist id="browsers"></datalist>')
		var tempArry=[]
			tempArry=fundList
		for(var i=0;i<fundList.length;i++){
			var option='<option value='+fundList[i].moneyway+'  id="inputid" idval='+fundList[i].id+'>'
			newDatalist.append(option)
		}*/
		var newDatalist=$('<select  class="form-control" style="width:400px;float:left;" id="moneyway"></select >')
		
		var tempArry=[]
		tempArry=fundList
		for(var i=0;i<fundList.length;i++){
			var option='<option   value='+fundList[i].moneyway+' id="inputid" idval='+fundList[i].id+'  fundmoney='+fundList[i].money+'>'+fundList[i].moneyway+'</option>'
			newDatalist.append(option)
		}
		debugger
			
		
		var newTd2=$('<td colspan="2"><input type="text" id="premoney" style="width: 170px" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
		var newTd3=$('<td colspan="2"><input type="text" id="questmoney" style="width: 100px" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
		
		//var input1=$('<input type="text" style="height:30px;width:80px;folat:right;"  value="可用资金:"; disabled="disabled">  ')
		//var input2=$('<input type="text" style="height:30px;width:120px;folat:right"; disabled="disabled">')
		newTd1.append(newDatalist)//,input1,input2)
		
		newTr.append(newTd1,newTd2,newTd3)
		
		captialTd.attr("rowspan",parseInt(rowspan)+1)
		
		captialTr.after(newTr)
		
		$.parser.parse(newTr);//重新渲染样式
		tdNum++;
		
		
		
/*	      <tr   >
	          <td colspan="5"  id="add_captionl_td1">
	          
	           <input list="browsers"  type="text" id="moneyway" style="width: 400px" class="easyui-validatebox" required="true" missingMessage="不能为空">
					<datalist id="browsers">
					  <option value="Internet Explorer">
					  <!-- <option v-for="person in people" :value="person.name">{{ person.name }}</option> -->
					</datalist>
	          </td>
	          <td colspan="2"  id="add_captionl_td2">
	          	<!-- <input type="text" id="premoney" style="width: 170px" class="easyui-numberbox" required="true" missingMessage="不能为空"> -->
	          </td>
	          <td colspan="2"  id="add_captionl_td3">
	          	<!-- <input type="text" id="questmoney" style="width: 100px" class="easyui-numberbox" required="true" missingMessage="不能为空"> -->
	          </td>
	      </tr>*/
		
		
		
	});
	
	$(document).on("click","#add_captionl_edit",function(){
		var captialTd=$("#captialTd_edit")
		rowspan=captialTd.attr("rowspan")
		debugger
		var captialTr=$("#captialTr_edit")
		
		var newTr=$('<tr trnum='+tdNum+'  trid="trid"></tr>')
		var newTd1=$('<td colspan="5" tdNum='+tdNum+'><div class="sub_img_captionl_edit" title="点击删除栏目" trnum='+tdNum+' ></div></td>')
		//var newInput=$(' <input list="browsers"   type="text" id="moneyway" style="width: 400px" class="easyui-validatebox" required="true" missingMessage="不能为空">')
		
		/*		var newDatalist=$('<datalist id="browsers"></datalist>')
		var tempArry=[]
			tempArry=fundList
		for(var i=0;i<fundList.length;i++){
			var option='<option value='+fundList[i].moneyway+'  id="inputid" idval='+fundList[i].id+'>'
			newDatalist.append(option)
		}*/
		var newDatalist=$('<select  class="form-control" style="width:400px;float:left;" id="moneyway"></select >')
		var tempArry=[]
		tempArry=fundList
		for(var i=0;i<fundList.length;i++){
			var option='<option   value='+fundList[i].moneyway+' id="inputid" idval='+fundList[i].id+'  fundmoney='+fundList[i].money+'>'+fundList[i].moneyway+'</option>'
			newDatalist.append(option)
		}
		debugger
		
		
		var newTd2=$('<td colspan="2"><input type="text" id="premoney" style="width: 170px" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
		var newTd3=$('<td colspan="2"><input type="text" id="questmoney" style="width: 100px" class="easyui-numberbox" required="true" missingMessage="不能为空"></td>')
		
		//var input1=$('<input type="text" style="height:30px;width:80px;folat:right;"  value="可用资金:"; disabled="disabled">  ')
		//var input2=$('<input type="text" style="height:30px;width:120px;folat:right"; disabled="disabled">')
		newTd1.append(newDatalist)//,input1,input2)
		
		newTr.append(newTd1,newTd2,newTd3)
		
		captialTd.attr("rowspan",parseInt(rowspan)+1)
		
		captialTr.after(newTr)
		
		$.parser.parse(newTr);//重新渲染样式
		tdNum++;
		
		
		
		/*	      <tr   >
	          <td colspan="5"  id="add_captionl_td1">
	          
	           <input list="browsers"  type="text" id="moneyway" style="width: 400px" class="easyui-validatebox" required="true" missingMessage="不能为空">
					<datalist id="browsers">
					  <option value="Internet Explorer">
					  <!-- <option v-for="person in people" :value="person.name">{{ person.name }}</option> -->
					</datalist>
	          </td>
	          <td colspan="2"  id="add_captionl_td2">
	          	<!-- <input type="text" id="premoney" style="width: 170px" class="easyui-numberbox" required="true" missingMessage="不能为空"> -->
	          </td>
	          <td colspan="2"  id="add_captionl_td3">
	          	<!-- <input type="text" id="questmoney" style="width: 100px" class="easyui-numberbox" required="true" missingMessage="不能为空"> -->
	          </td>
	      </tr>*/
		
		
		
	});
	
	/**
	 * 删除
	 */
	$(document).on("click",".sub_img_captionl",function(){
		var checkedTr=this;
		var trnum=checkedTr.getAttribute("trnum")
		
		debugger
		var trs=$("tr").filter("[trnum="+trnum+"]").remove()
		var captialTd=$("#captialTd")
		rowspan=captialTd.attr("rowspan")
		captialTd.attr("rowspan",parseInt(rowspan)-1)
		tdNum--;
		changeOptionValue()
		debugger
	});
	
	function changeTV(trnum){
		var trs=$("tr").filter("[trnum="+trnum+"]").remove()
		var captialTd=$("#captialTd_edit")
		rowspan=captialTd.attr("rowspan")
		captialTd.attr("rowspan",parseInt(rowspan)-1)
		tdNum--;
	}
	
	//删除自主采购资金来源
	$(document).on("click",".sub_img_captionl_edit",function(){
		var checkedTr=this;
		var trnum=checkedTr.getAttribute("trnum")
		var hasid=checkedTr.getAttribute("hasid")
		var csid=checkedTr.getAttribute("csid")
		var projectid=checkedTr.getAttribute("projectid")
		debugger
		if(hasid==null){
			changeTV(trnum)
		}else{
			confirm("确定要删除选中的记录？",function(){
				$.ajax({
					type: "DELETE",
					url:"/deleteCapitalSourceById/"+hasid+"/"+csid+"/"+projectid,
					success:function(r){
						alert(r.msg,function(){
							changeTV(trnum)
						})
						
					}
				})
			})
		}
		
	});
	
	function getFounds(){
		 $.get(baseURL+"getFounds",function(r){
			  debugger
			  if(r.msg=="F"){
				  return false;
			  }
			  if(r.fundFormList.length>0){
				  fundList=r.fundFormList
				  originalArr=r.fundFormList
			  }
		  })
	}
	
	
	$(document).on("change","#moneyway",function(){
		changeOptionValue()
		var current=$(this);
		current.parent()
		debugger;
	})
	
	function  changeOptionValue(){
		var moneywayArr=$("select");
		debugger
		var tempArry=[]
		for(var i=0;i<moneywayArr.length;i++){
			tempArry[i]=moneywayArr[i].value
		}
		debugger
		// array.forEach(function(currentValue, index, arr), thisValue)
		addOrRemoveItem(tempArry)
	}
	
	
	function addOrRemoveItem(tempArry){
		var diffArr= diff(originalArr, tempArry)
		var canShowArr=canShow(diffArr)
		debugger
		fundList=[]//清空
		fundList=canShowArr
	}
	function diff(arr1, arr2) {/**比较不同**/
		debugger
		var newArr = [];
		var arr3 = [];
		for(var i = 0; i < arr1.length; i++) {
			if(arr2.indexOf(arr1[i].moneyway) === -1){
				arr3.push(arr1[i]);	
			}
		}
	/*	var arr4 = [];
		for(var j = 0; j < arr2.length; j++) {
			if(arr1.indexOf(arr2[j]) === -1){
				arr4.push(arr2[j]);
			}
		}*/
		//newArr = arr3.concat(arr4);
		newArr = arr3
		return newArr;
	}
	
	function canShow(diff) {/**可以显示**/
		debugger
		var canShowArr = []
		if(diff.length > 0) {
			originalArr.forEach(function(item1) {
				diff.forEach(function(item2) {
					if(item1.moneyway.toLowerCase().indexOf(item2.moneyway) != -1) {
						canShowArr.push(item1)
					}
				})
			})
			return canShowArr
		}
		return canShowArr
	}
	
	/*预算项目金额事件*/
/*	$(document).on("change","#premoney",function(){
		var current=$(this);
		var currentMoney=parseFloat(current.val());//输入的钱
		var moneywat=current.parent().prev().find("select").find("option:selected").text()//资金来源名称
		var fundmoney=parseFloat(current.parent().prev().find("select").find("option:selected").attr("fundmoney"))//资金额度
		debugger
		if(currentMoney>fundmoney){
			alert("预算项目金额超过额度！")
			current.val("")//超过了清空
			return false
		}
	})*/
	
	$(document).on("input propertychange","#premoney",function(){
		var current=$(this);
		debugger
		var premoney=current.val().trim();
		//找到预算数组
		var inputs=$("tr").find("input[id=premoney]")
		//获取预算金额数组
		var temp=new Array();
		for(var i=0;i<inputs.length;i++){
			temp.push(inputs[i].value)
		}
		//最大的预算
		var flag=Math.max.apply(null, temp);
		//预算项目金额  实时事件★★★★★★★★★★★★★★★★★★★★★★★
		if(flag>=50000&&$(".agency_div").length==0){
			debugger
			$(".modal-body").append(getAgentcTr())
		}else if(flag<50000&&$(".agency_div").length>0){
			$(".agency_div").remove()
		}
		
		console.log(agencyData)
		
		//超值提示
		var currentMoney=parseFloat(premoney);//输入的钱
		var moneywat=current.parent().prev().find("select").find("option:selected").text()//资金来源名称
		var fundmoney=parseFloat(current.parent().prev().find("select").find("option:selected").attr("fundmoney"))//资金额度
		debugger
		if(currentMoney>fundmoney){
			current.val("")//超过了清空
			$(".agency_div").remove()
			alert("预算项目金额超过额度！")
			return false
		}
	});
})
