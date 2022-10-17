$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '用户', field: 'user.realName' }, 			
			{ title: '标题', field: 'title' }, 			
			{ title: '内容', field: 'content' }, 	
			{ title: '状态', field: 'status',
				formatter: function (value, row, index) {
					if(value == 1){
						return "已读";
					}else if(value == 0){
						return "未读";
					}else{
						return "未知";
					}
			}}, 
			{ title: '创建时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'message/list',
	        cache: false,
	        striped: true,
	        pagination: true,
	        pageSize: 10,
	        pageNumber: 1,
	        sidePagination: 'server',
	        pageList: [10, 25, 50],
	        columns: columns,
	        queryParams: function (params) {
	        	return {
		        	page: params.offset / 10 + 1,
		        	limit: params.limit
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		message: {},
		userList: []
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.message = {
					userId: ''
			};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.message.id == null ? "message/save" : "message/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.message),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "message/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "message/info/"+id, function(r){
                vm.message = r.message;
            });
		},
		getUser: function(){
			$.get(baseURL + "member/listAll", function(r){
                vm.userList = r.memberList;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refreshOptions',  {pageNumber: 1});
		}
	},
	created: function(){
		this.getUser();
	}
});