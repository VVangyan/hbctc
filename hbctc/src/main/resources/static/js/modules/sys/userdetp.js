$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'userId', index: "user_id", width: 45, key: true },
			{ label: '用户名', name: 'username', width: 75 },
			{ label: '邮箱', name: 'email', width: 90 },
			{ label: '手机号', name: 'mobile', width: 100 },
			{ label: '状态', name: 'status', width: 80, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
			{ label: '创建时间', name: 'createTime', index: "create_time", width: 80}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
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
});
var tempDeptlist=[]
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			username: null
		},
		showList: true,
		showUserDept:true,
		title:null,
		userId:null,
		deptList:{},
		userdeptname:null,
		userdeptno:null,
		selected:null,
		user:{
			status:1,
			roleIdList:[]
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		addUserDept: function () {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			debugger
			vm.showList = false;
            vm.title = "新增用户部门";
			vm.getDeptList(userId)
		},
		updateUserDept:function(){
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			debugger
			vm.showList = false;
            vm.title = "修改用户部门";
			vm.getDeptList(userId)
		},
		lookUserDept:function(){
			var userId = getSelectedRow();
			debugger
			if(userId == null){
				return ;
			}
			debugger
			vm.showList = false;
			vm.showUserDept = false;
            vm.title = "查看用户部门";
            debugger
            vm.getUserDept(userId)
		},
		getUserDept:function(userId){
			$.ajax({
				type: "POST",
			    url: baseURL + "getUserDept",
                contentType: "application/json",
			    data: JSON.stringify({"userid":userId}),
			    success: function(r){
			    	debugger
			    	if(r.length>0){
			    		vm.userdeptname=r[0].detpname
			    	}else{
			    		vm.userdeptname="暂无数据"
			    	}
			    	
			    	console.log("r:"  +JSON.stringify(r))
				}
			});
		},
		addOrUpdateUserDept:function(){
            if(vm.validator()){
                return ;
            }
			var userid=vm.userId
			var deptno=vm.selected.split("_")[0]
			var detpname=vm.selected.split("_")[1]
			var userDept={"userid":userid,"deptno":deptno,"detpname":detpname}
			var title=vm.title
			debugger
			var url = vm.title == "新增用户部门" ? "addUserDept" : "updateUserDept";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(userDept),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getDeptList:function(userId){
			$.get(baseURL + "getDeptList", function(r){
				vm.deptList=r
				vm.userId=userId
				vm.tempDeptlist=r
				debugger
				console.log("tempDeptList: "+ JSON.stringify(r))
			});
		},
		reload: function () {
			vm.showList = true;
			vm.showUserDept = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
		},
        validator: function () {
            if(isBlank(vm.selected)){
                alert("部门名称不能为空");
                return true;
            }
        }
	}
});