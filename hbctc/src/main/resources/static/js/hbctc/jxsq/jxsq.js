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
	
	$("textarea").val("")
	$(".agency_div").remove()
	$("#add_request").show()
	$(".div_sh").hide()
});
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

function subNum(){
	// 获取rowSpan,初始值为4，每次删除一个栏目，值减1
	var row = $("#rowspan_change")[0]
	// debugger
	row.rowSpan=parseInt(row.rowSpan)-1
	console.log(row)
	//tr的个数，如果值为15,说明删除的是最后一个元素，此时需要将itemId的值初始化为0
	var num=$("table[id=add_table_ids] tr").length
	if(num==15){
		itemId=0
	}
};

//新增item
$(document).on("click",".id_div_add",function() {
	var cgxmxq_tr=$("table[id=add_table_ids] tr:eq("+addNum()+")")
	createTd(cgxmxq_tr)
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


//删除item
$(document).on("click",".sub_img",function(){
	var checkedTr=this;
	var trid=checkedTr.getAttribute("checkedtrid")
	subNum()
	$("tr[id="+trid+"]").remove()
	debugger
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
		
		/*				buyItemInfo.byintemid=parseInt(inputs.context.id)
			buyItemInfo.buyitemname=inputs[0].value
			buyItemInfo.buyitemqty=inputs[1].value
			buyItemInfo.buyitemunit=selects[1].value 
			
			buyItemInfo.buyitemsum=inputs[2].value
			
			buyItemInfo.buyitemtype=selects[0].value
			buyItemInfo.isimport=selects[2].value
			buyItemInfo.isenergy=selects[3].value
			buyItemInfo.isenvironment=selects[3].value*/
		
		buyItemInfos.push(buyItemInfo)
		debugger
	}
	var projectRequestForm=new ProjectRequestForm(
			dept,
			deptpeo,
			deptpeoinfo,
			projectname,
			projectcontact,
			projectpeoinfo,
			buyway,
			moneyway,
			premoney,
			questmoney,
			buyItemInfos,
			totalmoney,
			others,
			(totalmoney>100000)? 1:0)
	if(premoney>=100000){//有代理机构
		projectRequestForm.agentno=$("#agencySelectId").find("option:selected").val();
	}
	//
	debugger
	if(isOk(buyItemInfos)){
		$.ajax({
			type: "POST",
			url: "/project",
			contentType: "application/json",
			data: JSON.stringify(projectRequestForm),
			success: function(r){
				debugger;
				hideReqModal()
				init(paginationConf.currentPage);
				alert("申请成功!")
			}
		});
	}
});

//表单校验
function isOk(buyItemInfos){
	var ok=false
	//form 校验。
	var flag=$("#formId").form('validate')
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
var agencyData=null;
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
		
	}
	if(tag=="edit"){//编辑
		
	}
	if(tag=="delete"){//删除
		if(stepstatus==0){
			delItem(id,stepstatus)
		}else{
			alert("当前状态下不能删除")
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

function delItem(id,stepstatus){
	confirm("确定要删除选中的记录？",function(){
		$.ajax({
			type: "DELETE",
			url:"/delItemById/"+id+"/"+stepstatus,
			success:function(r){
				alert(r.msg)
			}
		})
	})
};


//加载详情数据。
function loadDetailData(r){
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
		var  td2=$('<td><input type="text"  style="width: 150px" class="easyui-validatebox" disabled="disabled"  value='+buyItemTypeName+' ></td>')
		
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
		
		var td7=$('<td><select disabled="disabled"  id="isImport"><option value="1">'+((parseInt(buyItemInfos[i].isImport)==1)? '是':'否')+'</option></select></td>')
		var td8=$('<td><select disabled="disabled" id="isEnergy"><option value="1">'+((parseInt(buyItemInfos[i].isEnergy)==1)? '是':'否')+'</option></select></td>')
		var td9=$('<td><select disabled="disabled" id="isEnvironment"><option value="1">'+((parseInt(buyItemInfos[i].isEnvironment)==1)? '是':'否')+'</option></select></td>')
		
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
	format : 'YYYY年MM月DD日'
		// format: 'YYYY年MM月DD日 hh:mm:ss'
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
        			if(stepstatus==0){
        				stepstatusName="待申请"
        			}
        			if(stepstatus==1){
        				stepstatusName="项目负责人审核中"
        			}
        			if(stepstatus==2){
        				stepstatusName="待申请"
        			}
        			if(stepstatus==3){
        				stepstatusName="待申请"
        			}
        			if(stepstatus==4){
        				stepstatusName="待申请"
        			}
        			if(stepstatus==5){
        				stepstatusName="待申请"
        			}
        			
        			var td8=$("<td></td>").append(stepstatusName)
        			
        			
        			var td9=$("<td></td>").append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='detail'>详情</a>"))					  
					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+"  tag='request'   style='padding-left:5px'>申报</a>"))
					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+" tag='edit'   style='padding-left:5px'>编辑</a>"))
					        			  .append($("<a id="+resultList[x].id+" stepstatus="+stepstatus+" tag='delete' style='padding-left:5px'>删除</a>"))
        								  
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

