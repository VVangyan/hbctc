$(function() {
/**
 * 分页
 */
var paginationConf = {
		currentPage : 1,   //当前第几页
		totalItems : 0,    //共有多少
		itemsPerPage : 10, //每页显示记录条数
		pagesLength : 15,
		perPageOptions : [ 10 ],
		rememberPerPage : 'perPageItems',
		onChange : function() {
			//showTopicList(this.currentPage, this.totalItems);
			init(this.currentPage)
		}
};

// alert(1)
var btn = $("#btn_add_zxjh")
btn.on("click", function() {
	showReqModal()
	getAgency()
});
function showReqModal(){
	$("#add_zxjh_Modal").modal({
		backdrop : "static"
	});
};
function hideReqModal(){
	$("#add_zxjh_Modal").modal("hide");
};


//详情
$("#detail_zxjh_Modal").on("hidden.bs.modal", function() {//关闭页面后清空数据。
	if($("input[name=detail_buyway]").length>0){
		$("input[name=detail_buyway]").removeAttr("checked")
	}
	
	if($("tr[detailFlag=detailFlag]").length>0){//清除tr,重置 rowspan为3，itemId为0
		$("tr[detailFlag=detailFlag]").remove()
		var row = $("#detail_rowspan_change")[0]
		// debugger
		row.rowSpan=3
	}
	$("#agency_div_detail").remove()
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
$("#premoney").bind("input propertychange",function(){
	var premoney=$(this).val().trim();
	if(premoney>=100000&&$(".agency_div").length==0){//新增
		$(".modal-body").append(getAgentcTr())
	}
	if(premoney<100000&&$(".agency_div").length>0){//移除
		$(".agency_div").remove()
	}
	console.log(agencyData)
});
//预算项目金额  实时事件
$("#edit_premoney").bind("input propertychange",function(){
	var premoney=$(this).val().trim();
	if(premoney>=100000&&$(".agency_div").length==0){//新增
		$(".modal-body").append(getAgentcTrEdit())
	}
	if(premoney<100000&&$(".agency_div").length>0){//移除
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
	var isten=$(this).attr("isten")
	debugger
	if(tag=="detail"){//详情
		showDetail(id)
		debugger
	}
	if(tag=="request"){//申报
		if(stepstatus==7){
			loadUserDeptModal(id,stepstatus)
		}else{
			alert("当前状态不能审批!")
		}
	}
	if(tag=="plan_YWJBR"){//审批
		if(stepstatus==11){
			checkPlan(id,isten)
		}else{
			alert("当前状态不能审批!")
		}
		debugger
	}

});

var checkPlan=function(id,isten){
	$("#checkPlan_Modal").modal({backdrop:"static"})
	if(isten==0){
		$("#zbwj_div").hide()
	}
	$("#plan_fail").attr({"preid":id,"isten":isten})
	$("#plan_pass").attr({"preid":id,"isten":isten})
	
	
}

$("#planStatus_div button").on("click",function(){
	var btn=$(this).attr("id")
	var planStatus=$(this).attr("planStatus")
	var preid=$(this).attr("preid")
	var isten=$(this).attr("isten")
	var checkMsg={}
	
	if(isOk("#checkPlan__formId")){
		checkMsg.msg=$("#check_Msg").val().trim()
		//2018年02月22日 17:42:03
		checkMsg.checkdate=$("#ymd01").val().trim()
		checkMsg.preid=preid
		checkMsg.id=planStatus
		checkMsg.checkby=2
		if(btn=="plan_fail"){
			//sendData(checkMsg)
			uploadFile(checkMsg,isten,btn)
		}
		if(btn=="plan_pass"){
			//sendData(checkMsg)
			uploadFile(checkMsg,isten,btn)
		}
	}
});
function sendData(checkMsg){
	$.ajax({
		type: "POST",
		url:"/checkPlanByYWJBR",
		contentType: "application/json",
		data: JSON.stringify(checkMsg),
		success:function(r){
			$("#checkPlan_Modal").modal("hide")
			alert(r.msg)
			debugger
			init(paginationConf.currentPage)
		}
	})
}

//上传文件
function uploadFile(checkMsg,isten,btn) {
	var formData = new FormData();
		formData.append('checkMsg', JSON.stringify(checkMsg)); 
	if(isten==1&&btn=="plan_pass"){
		var files=$('#zbwj')[0].files[0];
		debugger
		if(files==undefined){
			alert("请选择招标文件")
			return false
		}
		formData.append('file', files);
	}
	
	$.ajax({
		url :"/checkPlanByYWJBR",
		type : 'POST',
		cache : false,
		data : formData,
		processData : false,
		contentType : false,
		success : function(r) {
			$("#checkPlan_Modal").modal("hide")
			alert(r.msg)
			init(paginationConf.currentPage)
		}
	});
}
function editRequestTable(id,stepstatus){
	$("#edit_zxjh_Modal").modal({backdrop:"static"})
	
	getAgency()//获取代理机构
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
var vm=new Vue({
	el: '#app',
	data: {
		message: 'Runoob!',
		stepstatus:null,
		id:null
	},
	methods: {
		addToSend: function() {
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
			    	$("#load_user_dept_Modal").modal("hide")
			    	alert(r.msg)
			    	init(paginationConf.currentPage)
			    }
			});
		}
	}
})








function showDetail(id){
	$("#detail_zxjh_Modal").modal({backdrop:"static"})
	getAgency()//获取代理机构
	
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



//加载详情数据。
function loadDetailData(r){
	var  bc=$(".bmshc")
	var  bm=$("#bmshyj")
	var  zb=$(".zcbshc")
	var  zc=$("#zcbspyj")
		 bc.removeClass("height")
		 bm.text("")
		 zb.removeClass("height")
		 zc.text("")	
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
}

// 点击显示（YYYY年MM月DD日 hh:mm:ss）格式
$("#ymd01").jeDate({
	isinitVal : false,
	festival : false,
	//format : 'YYYY年MM月DD日'
	format: 'YYYY-MM-DD hh:mm:ss'
});

function init(pn){//页面初始化，加载数据
	var  tbodyid=$("#tbodyId")
		 tbodyid.text("")
    $.ajax({
        type: "GET",
        url: "/getReqFormList",
        data:{pn:pn},
        success: function(r){
        	var resultList=r.resultList
        	if(resultList.length>0){
        		var bottom_div=$("#bottom_div");
    			bottom_div.text("");//清空
    			/**
    			 * 分页
    			 */
    			var pageDiv=$("<div></div>");
    				pageDiv.attr("id","page");
    				pageDiv.addClass("page_div");
    				pageDiv.appendTo(bottom_div);
    			//每页显示多少条记录	
    			var pageSize=paginationConf.itemsPerPage;
    			//总记录数
    			var totalRecord=parseInt(r.page.total);
    			//获取总页数
    			var totalPage = parseInt(r.page.pages)
    			
    				//分页
    				$("#page").paging({
    					totalPage: totalPage,
    					totalSize: totalRecord,
    					pageNo: paginationConf.currentPage,
    					callback: function(num) {
    						//获取点击的id
    						var clickid = jconfirm.lastClicked[0].id;
    						//查询拦截过滤
    						if(paginationConf.currentPage<=1&&(clickid=="firstPage"||clickid=="prePage")){
    							return false;
    						}else if(paginationConf.currentPage>=totalPage&&(clickid=="nextPage"||clickid=="lastPage")){
    							return false;
    						}else{
    							/*alert(num);*/
    							paginationConf.currentPage=num;
    							//alert(totalItems,currentPage);
    							paginationConf.onChange();
    						}
    					}
    				});
        		
        		for(x in resultList){
        			var baseTrList=$("<tr></tr>")
        			var td1=$("<td></td>").append(resultList[x].id)
        			var td2=$("<td></td>").append(resultList[x].dept)
        			var td3=$("<td></td>").append(resultList[x].deptpeo)
        			var td4=$("<td></td>").append(resultList[x].deptpeoinfo)
        			var td5=$("<td></td>").append(resultList[x].projectname)
        			var td6=$("<td></td>").append(resultList[x].projectcontact)
        			var td7=$("<td></td>").append(resultList[x].projectpeoinfo)
        			
        			
        			var stepstatus=parseInt(resultList[x].stepstatus)
        			stepstatusName=""
            			if(stepstatus==1){
            				stepstatusName="项目负责<br>人审核中"
            			}
            			if(stepstatus==2){
            				stepstatusName="项目负责<br>人审核未通过"
            			}
            			if(stepstatus==3){
            				stepstatusName="项目负责<br>人审核通过"
            			}
            			if(stepstatus==4){
            				stepstatusName="业务经办<br>人审核未通过 "
            			}
            			if(stepstatus==5){
            				stepstatusName="业务经办<br>人审核中"
            			}
            			if(stepstatus==6){
            				stepstatusName="业务负责<br>人审核未通过 "
            			}
            			if(stepstatus==7){
            				stepstatusName="业务经办<br>人审核通过"
            			}
            			if(stepstatus==8){
            				stepstatusName="业务主管部门<br>审核未通过"
            			}
            			if(stepstatus==9){
            				stepstatusName="业务负责人<br>审核中"
            			}
            			if(stepstatus==11){
            				stepstatusName="业务负责<br>人审核通过"
            			}
            			if(stepstatus==13){
            				stepstatusName="业务主管部门<br>审核中"
            			}
            			if(stepstatus==15){
            				stepstatusName="业务主管部门<br>审核通过"
            			}
            			if(stepstatus==17){
            				stepstatusName="结项"
            			}
            			
        			
        			var td8=$("<td></td>").append(stepstatusName)
        			
        			
        			var td9=$("<td></td>").append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='detail'>详情</a>"))					  
					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='plan_YWJBR'  isten="+resultList[x].isten+" style='padding-left:5px'>审批</a>"))
					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='request'   style='padding-left:5px'>申报</a>"));
        								  
        			baseTrList.append(td1)
        					  .append(td2)
        					  .append(td3)
        					  .append(td4)
        					  .append(td5)
        					  .append(td6)
        					  .append(td7)
        					  .append(td8)
        					  .append(td9)
        					  baseTrList.appendTo(tbodyid)
        		}
        	}else{
        		tbodyid.html("<h4 style='text-algin:center;width:100px;'>暂无数据。</h4>")
        	}
        }
    });
}
init(paginationConf.currentPage);
	
	
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
	

//表单校验
function isOk(id){
	var ok=false
	//form 校验。
	var flag=$(id).form('validate')
	debugger
	//采购项目需求不能为空
	if(flag){
		ok=true
	}
	return ok
};

/**

 * 检查是否为正整数

 */
var isNum=function(inputNum){
	var re=/^\d+$/g;
	if(re.test(inputNum)){
		return true;
	}else{
		return false;
	}
};

})


/*******************************时间转换工具  start   ************************************/
/**

 * timeStamp

 * 转换

 * StringDate

 */
var timeStamp2String= function(time){
    var datetime = new Date();
     datetime.setTime(time);
     var year = datetime.getFullYear();
     var month = datetime.getMonth() + 1;
     var date = datetime.getDate();
     var hour = datetime.getHours();
     var minute = datetime.getMinutes();
     var second = datetime.getSeconds();
     //var mseconds = datetime.getMilliseconds();

     //return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second+"."+mseconds;

     return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
};

/**

 * datetime

 * 转换

 * timestamp

 */
var datetime2timestamp=function(strdate){
	var date = new Date(strdate);
	return Math.round(date.getTime());
}
