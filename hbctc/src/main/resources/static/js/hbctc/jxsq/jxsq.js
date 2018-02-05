$(function() {
	// alert(1)

	function addzxjh() {
		var btn = $("#btn_add_zxjh")
		btn.on("click", function() {
			$("#add_zxjh_Modal").modal({
				backdrop : "static"
			});
		})
		
		var itemId=0
		function addNum(){
			// 获取rowSpan,初始值为4，每次新增一个栏目，值加1
			var row = $("#rowspan_change")[0]
				// debugger
				row.rowSpan=parseInt(row.rowSpan)+1
			var num=$("table tr").length
			    num=num-3
			    console.log(row)
			    
			    //每行id加1
			    itemId+=1;
			    return num;
		}
		
		function subNum(){
			// 获取rowSpan,初始值为4，每次删除一个栏目，值减1
			var row = $("#rowspan_change")[0]
				// debugger
				row.rowSpan=parseInt(row.rowSpan)-1
			    console.log(row)
			    //tr的个数，如果值为15,说明删除的是最后一个元素，此时需要将itemId的值初始化为0
			    var num=$("table tr").length
			    if(num==15){
			    	itemId=0
			    }
		}
		
		//新增item
		$(document).on("click",".id_div_add",function() {
			var cgxmxq_tr=$("table tr:eq("+addNum()+")")
			createTd(cgxmxq_tr)
		})
		
		function createTd(cgxmxq_tr){
			var  tr1=$('<tr id='+itemId+'></tr>')
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
		}
		
		
		//删除item
		$(document).on("click",".sub_img",function(){
			var checkedTr=this;
			var trid=checkedTr.getAttribute("checkedtrid")
			subNum()
			$("tr[id="+trid+"]").remove()
			debugger
		})
		
		
		$(document).on("click","#add_request",function(){
			//var trs=$("tr[id][id!=''] input");//获取 input
			//var select=$("tr[id][id!=''] select");//获取 select
			//$(trs[0]).find("input")  //获取 input
			//$(trs[0]).find("select")
			//获取 input & select  
			var inputsAndSelects=$("tr[id][id!='']")
			
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
	                }
	            });
			}
		})
		
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
		}
		
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
		})
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
		}
		
		
		function getRandomAgency(){
			debugger
			if(agencyData.length>0){//随机代理
				var index=Math.floor((Math.random()*agencyData.length)+1);
				//agency,agentno
				agentno=agencyData[index].agentno
				agency=agencyData[index].agency
			}
		}
		var agencyData=null;
		function getAgency(){
			debugger
			if(agencyData==null){
	            $.ajax({
	                type: "GET",
	                url: "/getAgency",
	                success: function(r){
	                    console.log(r)
	                    agencyData=r
	                }
	            });
			}
		}getAgency()
		
		// 点击显示（YYYY年MM月DD日 hh:mm:ss）格式
		$("#ymd01").jeDate({
			isinitVal : false,
			festival : false,
			format : 'YYYY年MM月DD日'
		// format: 'YYYY年MM月DD日 hh:mm:ss'
		});
	}

	addzxjh()
})