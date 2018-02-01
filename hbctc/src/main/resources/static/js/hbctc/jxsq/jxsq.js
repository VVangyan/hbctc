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
			var  td2=$('<td><input type="text" id="buyItemName" style="width: 150px"></td>')
			var  td3=$('<td><select id="buyItemType"><option>货物</option><option>服务</option><option>工程</option></select></td>')
			
			var td4=$('<td><input type="text" id="buyItemQty"></td>')
			var td5=$('<td><input type="text" id="buyItemUnit"></td>')
			var td6=$('<td><input type="text" id="buyItemSum"></td>')
			
			var td7=$('<td><select id="isImport"><option>是</option><option>否</option></select></td>')
			var td8=$('<td><select id="isEnergy"><option>是</option><option>否</option></select></td>')
			var td9=$('<td><select id="isEnvironment"><option>是</option><option>否</option></select></td>')
			
			tr1.append(td1)
				.append(td2)
				.append(td3)
				.append(td4)
				.append(td5)
				.append(td6)
				.append(td7)
				.append(td8)
				.append(td9)
			
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
			//var projectRequestForm={}
			
			var dept=$("#dept").val().trim()//
			
			
			
			
			
			
			
			
			var projectRequestForm=new ProjectRequestForm();
			var buyItemInfos=new Array();
			
			for(var i=0;i<inputsAndSelects.length;i++){
				var inputs=$(inputsAndSelects[i]).find("input")
				var selects=$(inputsAndSelects[i]).find("select")
				debugger
				//var buyItemInfo=new Object()
				var buyItemInfo=new BuyItemInfo(
												parseInt(inputs.context.id),
												inputs[0].value,
												inputs[1].value,
												inputs[2].value,
												inputs[3].value,
												selects[0].value,
												selects[1].value,
												selects[2].value,
												selects[3].value)
				
/*				buyItemInfo.byintemid=parseInt(inputs.context.id)
				buyItemInfo.buyitemname=inputs[0].value
				buyItemInfo.buyitemqty=inputs[1].value
				buyItemInfo.buyitemunit=inputs[2].value
				buyItemInfo.buyitemsum=inputs[3].value
				
				buyItemInfo.buyitemtype=selects[0].value
				buyItemInfo.isimport=selects[1].value
				buyItemInfo.isenergy=selects[2].value
				buyItemInfo.isenvironment=selects[3].value*/
				buyItemInfos.push(buyItemInfo)
				debugger
			}
			projectRequestForm.buyItemInfos=buyItemInfos
			projectRequestForm.dept="dept"
			
			debugger
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/project",
                contentType: "application/json",
			    data: JSON.stringify(projectRequestForm),
                success: function(r){
                    
                }
            });
			
		})
		
		
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