$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/funds/fundsList',
        datatype: "json",
        colModel: [			
			/*{ label: '编号', name: 'id', index: "id", width: 45, key: true },*/
			{ label: '部门名称', name: 'detpname', width: 75 },
			{ label: '部门编号', name: 'deptno', width: 90 },
			{ label: '资金来源', name: 'moneyway', width: 100 },
			/*0.货物 1.服务 2.工程*/
			{ label: '采购类别' , name: 'buyitemtype', width: 25,align:"center",formatter: function(value, options, row){
				if(value == "0"){
					return '<span class="label label-info">货物</span>';
				}else if(value =="1"){
					return '<span class="label label-success">服务</span>';
				}else {
					return '<span class="label label-primary">工程</span>';
				}
			}},
			{ label: '金额', name: 'money', width: 25}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: false, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: false,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.pageNum",
            total: "page.pages",
            records: "page.total"
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			detpname: null
		},
		showList: true,
		title:null,
		roleList:{},
		user:{
			ismiddledept:null,
			roleIdList:[]
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		upload: function(){
			vm.showList = false;
			vm.title = "上传Excel";
			vm.roleList = {};
			vm.user = {status:1,roleIdList:[]};
			
		},
		uploadExcel: function(){
			var formData = new FormData();
			var files=$('#excelFile')[0].files[0];
			debugger;
			if(vm.checkFileFormat(files)){
				formData.append('file', files);
				$.ajax({
					url : baseURL + 'sys/funds/uploadFile',
					type : 'POST',
					cache : false,
					data : formData,
					processData : false,
					contentType : false,
					success : function(data) {
						//vm.setResultMsg($(".result_div"),data.msg)
						alert(data.msg)
						vm.reload();
					}
				});
			}
		},
		// 检查文件格式
		checkFileFormat:function (files){
			var flag=true;
			if(typeof(files)=="undefined"){// 未选择文件
				vm.setResultMsg($(".result_div"),"请选择要导入的Excel文件！");
				flag=false;
				return flag;
			}
			if(!vm.checkFileExt(files["name"])){
				vm.setResultMsg($(".result_div"),"请选择正确格式的文件,如:【.xls,.xlsx】");
				flag=false;
				return flag;
			}
			return flag;
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			var detpname=vm.q.detpname
			var postData={}
			if(detpname!=null){
				postData.detpname=detpname
			}
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData,
                page:page
            }).trigger("reloadGrid");
		},
		// 检查后缀名
		checkFileExt:function (filename){
			var flag = false; // 状态
			var arr = ["xls","xlsx"];
			// 取出上传文件的扩展名
			var index = filename.lastIndexOf(".");
			var ext = filename.substr(index+1);
			// 循环比较
			for(var i=0;i<arr.length;i++){
				if(ext == arr[i]){
					flag = true; // 一旦找到合适的，立即退出循环
					return flag;
				}
			}
			return flag;
		},
		// 整体调用提示消息
		setResultMsg:function (resultDiv,msg){
			resultDiv.html(vm.setMsg(msg));
			vm.hideMsgDiv();
		},
		// 设置提示消息
		setMsg:function (msg){
			return $("<div></div>").addClass("resultMsg").append(msg);
		},
		// 隐藏提示消息
		hideMsgDiv:function (){
			setTimeout(() => {
				$(".resultMsg").fadeOut(2000);
			}, 2000);
		}		
	}
});