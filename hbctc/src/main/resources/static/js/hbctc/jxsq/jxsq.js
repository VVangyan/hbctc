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
			    
			    //每行的编号减一
			    itemId-=1;
		}
		
		//新增item
		$(document).on("click",".id_div_add",function() {
			var cgxmxq_tr=$("table tr:eq("+addNum()+")")
			createTd(cgxmxq_tr)
		})
		function createTd(cgxmxq_tr){
			var  tr1=$('<tr id='+itemId+'></tr>')
			var  td1=$('<td><div class="id_div_sub"><div class="sub_img" title="点击删除栏目" checkedtrid='+itemId+'></div><div class="id_value">'+itemId+'</div></div> </td>')
			var  td2=$('<td><input type="text" id="projectName" style="width: 150px"></td>')
			var  td3=$('<td><select id="cglb"><option>货物</option><option>服务</option><option>工程</option></select></td>')
			
			var td4=$('<td><input type="text" id="qta"></td>')
			var td5=$('<td><input type="text" id="jldw"></td>')
			var td6=$('<td><input type="text" id="ysje"></td>')
			
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