$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'deptList',
        datatype: "json",
        colModel: [			
			{ label: '部门ID', name: 'id', index: "id", width: 45, key: true },
			{ label: '部门名', name: 'detpname', width: 75 },
			{ label: '部门编号', name: 'deptno', width: 90 },
			{ label: '上级id', name: 'preid', width: 100 },
			{ label: '主管部门', name: 'ismiddledept', width: 80}
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
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.roleList = {};
			vm.user = {status:1,roleIdList:[]};
			
			//获取角色信息
			this.getRoleList();
		},
		update: function () {
			var deptId = getSelectedRow();
			if(deptId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.deptDeptById(deptId);
		},
		del: function () {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }

			//var url = vm.user.userId == null ? "sys/user/save" : "sys/user/update";
            var url = "addDept";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
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
		deptDeptById: function(deptId){
			$.get(baseURL + "deptDeptById/"+deptId, function(r){
				debugger
				vm.user = r.dept;
				vm.user.password = null;
			});
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
        validator: function () {
            if(isBlank(vm.user.detpname)){
                alert("部门名不能为空");
                return true;
            }

            if(vm.user.deptno == null && isBlank(vm.user.deptno)){
                alert("部门编码不能为空");
                return true;
            }
            if(vm.user.ismiddledept == null && isBlank(vm.user.ismiddledept)){
            	alert("部门类别不能为空");
            	return true;
            }
        }
	}
});